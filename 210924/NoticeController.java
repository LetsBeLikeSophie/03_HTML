package a.b.c.com.kosmo.notice.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import a.b.c.com.common.CommonUtils;
import a.b.c.com.common.FileUploadUtil;
import a.b.c.com.common.GetChabun;
import a.b.c.com.kosmo.board.service.BoardService;
import a.b.c.com.kosmo.board.service.BoardServiceImpl;
import a.b.c.com.kosmo.board.vo.BoardVO;
import a.b.c.com.kosmo.mem.service.MemberService;
import a.b.c.com.kosmo.mem.service.MemberServiceImpl;
import a.b.c.com.kosmo.mem.vo.MemberVO;
import a.b.c.com.kosmo.notice.service.NoticeService;
import a.b.c.com.kosmo.notice.service.NoticeServiceImpl;
import a.b.c.com.kosmo.notice.vo.NoticeVO;

@WebServlet("/notice")
public class NoticeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("EUC-KR");
		response.setCharacterEncoding("EUC-KR");
		response.setContentType("text/html; charset=EUC-KR");
		PrintWriter out = response.getWriter();
		
		String isudType = request.getParameter("ISUD_TYPE");	
		
		if (isudType !=null && isudType.length() > 0){
			isudType = isudType.toUpperCase();
			
			// 공지사항 등록 ------------------------------------------------------------------------------
			if ("I".equals(isudType)){
				System.out.println("공지사항등록isudType >>> : " + isudType);
				
                boolean bool = request.getContentType().toLowerCase().startsWith("multipart/form-data");				
				if (bool){
					System.out.println("공지사항등록 파일업로드 루틴 :: bool >>> : " + bool);
					
					String filePaths = CommonUtils.NOTICE_IMG_UPLOAD_PATH;
	                int size_limit = CommonUtils.NOTICE_IMG_FILE_SIZE;
	                String  encode_type = CommonUtils.NOTICE_IMG_ENCODE;
					
					FileUploadUtil fu = new FileUploadUtil();					
					boolean bFile = fu.fileUpldad3(request, filePaths, size_limit, encode_type);
					
					if (bFile){
						
						// 서비스 호출하기 
						NoticeService ns = new NoticeServiceImpl();
						NoticeVO nvo = null;
						nvo = new NoticeVO();
						
						String nnum = GetChabun.getNoticeChabun("d");
						System.out.println("nnum >>> : " + nnum);
						
						// 공지사항 번호
						nvo.setNnum(nnum);
						// 공지사항 제목
						nvo.setNsubject(fu.getParameter("nsubject"));
						// 공지사항  내용
						nvo.setNmemo(fu.getParameter("nmemo"));						
						// 사진
						ArrayList<String> aFileName = fu.getFileNames();
						String nphoto = aFileName.get(0);				
						nvo.setNphoto(nphoto);
						
					
						System.out.println("NoticeController 공지사항 등록 >>> I ");
						NoticeVO.printlnNoticeVO(nvo);
					
						int nCnt = ns.noticeInsert(nvo);
						if (nCnt > 0){						
							request.setAttribute("nCnt", new Integer(nCnt));				
							RequestDispatcher rd = request.getRequestDispatcher("/kosmo/notice/noticeInsert.jsp");
							rd.forward(request, response);						
						}else{
							out.println("<script>");				
							out.println("location.href='/testKosmo/kosmo/notice/notice.html'");
							out.println("</script>");
						}
					
					}else{
						System.out.println("공지사항 등록 및 파일 업로드 실패 ");
					}	
				}				
			} // 공지사항 등록 end
			
			// 전체 공지사항 조회 ------------------------------------------------------------------------
			if ("SALL".equals(isudType)){
				System.out.println("공지사항정보 전체조회 isudType >>> : " + isudType);
				
				// 서비스 호출하기 
				NoticeService ns = new NoticeServiceImpl();
				ArrayList<NoticeVO> aListAll = ns.noticeSelectAll();
				
				if (aListAll !=null && aListAll.size() > 0) {
					
					request.setAttribute("aListAll", aListAll);					
					RequestDispatcher rd= request.getRequestDispatcher("/kosmo/notice/noticeSelectAll.jsp");
					rd.forward(request, response);
					
				}else {
					out.println("<script>");					
					out.println("location.href='/testKosmo/notice?ISUD_TYPE=SALL'");
					out.println("</script>");
				}		
			} // 전체 회원정보 조회 end
			
			// 공지사항 조회 : S U D ---------------------------------------------------------------------
			if ("S".equals(isudType) || "U".equals(isudType)){
				System.out.println("공지사항 조건조회 : S U D isudType >>> : " + isudType);

				String nnum = request.getParameter("nnumCheck");				
				if (nnum !=null && nnum.length() > 0){
					System.out.println("공지사항 번호 >>> :  " + nnum);
					
					// 서비스 호출하기 
					NoticeService ns = new NoticeServiceImpl();
					NoticeVO nvo = null;
					nvo = new NoticeVO();
					
					nvo.setNnum(nnum);					
					ArrayList<NoticeVO> aListS = ns.noticeSelect(nvo);
					
					if (aListS !=null && aListS.size() > 0) {
						System.out.println("aListS.size() >>> : " + aListS.size());						
						request.setAttribute("aListS", aListS);					
						RequestDispatcher rd= request.getRequestDispatcher("/kosmo/notice/noticeSelect.jsp");
						rd.forward(request, response);
						
					}else {
						out.println("<script>");
						out.println("alert('공지사항 조회 실패')");
						out.println("location.href='/testKosmo/notice?ISUD_TYPE=SALL'");
						out.println("</script>");
					}									
				}else{
					System.out.println("공지사항 번호가  없습니다. ");
				}		
			}
			
			// 공지사항 수정 ------------------------------------------------------------------------------
			if ("UOK".equals(isudType)){
				System.out.println("공지사항 수정 isudType >>> : " + isudType);
				
				String nnum = request.getParameter("nnum");
				String nsubject = request.getParameter("nsubject");
				String nmemo = request.getParameter("nmemo");				
				System.out.println("nnum >>> : " + nnum);
				System.out.println("nsubject >>> : " + nsubject);
				System.out.println("nmemo >>> : " + nmemo);
				
				// 서비스 호출하기 
				NoticeService ns = new NoticeServiceImpl();
				NoticeVO nvo = null;
				nvo = new NoticeVO();
				
				nvo.setNnum(nnum);
				nvo.setNsubject(nsubject);
				nvo.setNmemo(nmemo);
				
				int nCnt = ns.noticeUpdate(nvo);
				
				if (nCnt > 0) {
					System.out.println("공지사항 정보가  수정 되었습니다." + nCnt);					
					request.setAttribute("nCnt", new Integer(nCnt));										
					RequestDispatcher rd= request.getRequestDispatcher("/kosmo/notice/noticeUpdate.jsp");
					rd.forward(request, response);
					
				}else {
					System.out.println("글 수정 실패 !!!!");
					out.println("<script>");	
					out.println("alert('글 수정 실패')");
					out.println("location.href='/testKosmo/notice?ISUD_TYPE=SALL'");
					out.println("</script>");
				}
			}			
			
			// 공지사항 삭제 ------------------------------------------------------------------------------
			if ("DOK".equals(isudType)){
				System.out.println("공지사항 삭제 isudType >>> : " + isudType);
				
			
				String nnum = request.getParameter("nnumCheck");				
				if (nnum !=null && nnum.length() > 0){
					System.out.println("공지사항 번호 >>> :  " + nnum);
					
					// 서비스 호출하기 
					NoticeService ns = new NoticeServiceImpl();
					NoticeVO nvo = null;
					nvo = new NoticeVO();
					
					nvo.setNnum(nnum);
					int nCnt = ns.noticeDelete(nvo);
					
					if (nCnt > 0) {
						System.out.println("공지사항 정보가  삭제 되었습니다." + nCnt);					
						request.setAttribute("nCnt", new Integer(nCnt));										
						RequestDispatcher rd= request.getRequestDispatcher("/kosmo/notice/noticeDelete.jsp");
						rd.forward(request, response);
						
					}else {
						System.out.println("글 삭제 실패 !!!!");
						out.println("<script>");	
						out.println("alert('글 수정 실패')");
						out.println("location.href='/testKosmo/notice?ISUD_TYPE=SALL'");
						out.println("</script>");
					}
				}else{
					System.out.println("공지사항 번호를 잘 넘기세요 !!!! ");
				}	
			}	
			
			// 공지사항 공지하기 : NOTICE ---------------------------------------------------------------------
			if ("NOTICE".equals(isudType)){
				System.out.println("공지사항 조건조회 : NOTICE isudType >>> : " + isudType);

				String nnum = "NB202109240005";				
				if (nnum !=null && nnum.length() > 0){
					System.out.println("공지사항 번호 >>> :  " + nnum);
					
					// 서비스 호출하기 
					NoticeService ns = new NoticeServiceImpl();
					NoticeVO nvo = null;
					nvo = new NoticeVO();
					
					nvo.setNnum(nnum);					
					ArrayList<NoticeVO> aListS = ns.noticeSelect(nvo);
					
					if (aListS !=null && aListS.size() > 0) {
						System.out.println("aListS.size() >>> : " + aListS.size());						
						request.setAttribute("aListS", aListS);					
						RequestDispatcher rd= request.getRequestDispatcher("/kosmo/notice/noticePopup.jsp");
						rd.forward(request, response);
						
					}else {
						out.println("<script>");
						out.println("alert('공지사항 공지 조회실패')");					
						out.println("</script>");
					}									
				}else{
					System.out.println("공지사항 번호가  없습니다. ");
				}		
			}
		}else{
			System.out.println("form 태그에서 hidden 타입의 ISUD_TYPE 잘 넘기세요 >>> : ");
		}		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
