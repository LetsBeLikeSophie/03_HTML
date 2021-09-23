package a.b.c.com.kosmo.mem.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import a.b.c.com.common.CommonUtils;
import a.b.c.com.common.FileUploadUtil;
import a.b.c.com.common.GetChabun;
import a.b.c.com.kosmo.board.service.BoardService;
import a.b.c.com.kosmo.board.service.BoardServiceImpl;
import a.b.c.com.kosmo.board.vo.BoardVO;
import a.b.c.com.kosmo.mem.service.MemberService;
import a.b.c.com.kosmo.mem.service.MemberServiceImpl;
import a.b.c.com.kosmo.mem.vo.MemberVO;

@WebServlet("/mem")
public class MemberController extends HttpServlet {
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
			
			// ȸ�� ��� ------------------------------------------------------------------------------
			if ("I".equals(isudType)){
				System.out.println("ȸ�����isudType >>> : " + isudType);
				
                boolean bool = request.getContentType().toLowerCase().startsWith("multipart/form-data");				
				if (bool){
					System.out.println("ȸ����� ���Ͼ��ε� ��ƾ :: bool >>> : " + bool);
					
					String filePaths = CommonUtils.MEMBER_IMG_UPLOAD_PATH;
	                int size_limit = CommonUtils.MEMBER_IMG_FILE_SIZE;
	                String  encode_type = CommonUtils.MEMBER_IMG_ENCODE;
					
					FileUploadUtil fu = new FileUploadUtil();					
					boolean bFile = fu.fileUpldad3(request, filePaths, size_limit, encode_type);
					
					if (bFile){
						
						// ���� ȣ���ϱ� 
						MemberService ms = new MemberServiceImpl();
						MemberVO mvo = null;
						mvo = new MemberVO();
						
						String mnum = GetChabun.getMemberChabun("d");
						System.out.println("mnum >>> : " + mnum);
						
						// ȸ����ȣ
						mvo.setMnum(mnum);
						// ȸ���̸�
						mvo.setMname(fu.getParameter("mname"));
						// ���̵�
						mvo.setMid(fu.getParameter("mid"));
						// �н�����
						mvo.setMpw(fu.getParameter("mpw"));
						
						// ����
						mvo.setMgender(fu.getParameter("mgender"));
						
						// �������
						String mbirth = fu.getParameter("mbirth");
						String mbirth1 = fu.getParameter("mbirth1");
						String mbirth2 = fu.getParameter("mbirth2");
						mbirth = mbirth + mbirth1 + mbirth2;
						mvo.setMbirth(mbirth);
						
						// �ڵ���
						String mhp = fu.getParameter("mhp");
						String mhp1 = fu.getParameter("mhp1");
						String mhp2 = fu.getParameter("mhp2");
						mhp = mhp + mhp1 + mhp2;
						mvo.setMhp(mhp);
						
						// ��ȭ��ȣ
						String mtel = fu.getParameter("mtel");
						String mtel1 = fu.getParameter("mtel1");
						String mtel2 = fu.getParameter("mtel2");
						mtel = mtel + mtel1 + mtel2;
						mvo.setMtel(mtel);
						
						// �̸���
						String memail = fu.getParameter("memail");
						String memail1 = fu.getParameter("memail1");						
						memail = memail.concat("@").concat(memail1);
						mvo.setMemail(memail);
						
						// �ּ� : ������ȣ
						mvo.setMzonecode(fu.getParameter("mzonecode"));
						
						// �ּ� : ���θ� �ּ�						
						String mroadaddress = fu.getParameter("mroadaddress");
						String mroadaddressdetail = fu.getParameter("mroadaddressdetail");						
						mroadaddress = mroadaddress.concat("@").concat(mroadaddressdetail);
						mvo.setMroadaddress(mroadaddress);
						
						// �ּ� : ���� �ּ� 
						mvo.setMjibunaddress(fu.getParameter("mjibunaddress"));
						
						// ���
						String[] hobby = fu.getParameterValues("mhobby");
						String mhobby = "";
						for (int i=0; i < hobby.length; i++){
							mhobby += hobby[i] + ",";
						}
						mvo.setMhobby(mhobby);
						
						// ���Ұ�
						mvo.setMinfo(fu.getParameter("minfo"));
						
						// ����
						ArrayList<String> aFileName = fu.getFileNames();
						String mphoto = aFileName.get(0);				
						mvo.setMphoto(mphoto);
						// ������
						mvo.setMadmin("00"); // ������
						
						MemberVO.printlnMemberVO(mvo);
					
						boolean bInsert = ms.memberInsert(mvo);						
						if (bInsert){						
							request.setAttribute("bInsert", new Boolean(bInsert));				
							RequestDispatcher rd = request.getRequestDispatcher("/kosmo/mem/memInsert.jsp");
							rd.forward(request, response);						
						}else{
							out.println("<script>");				
							out.println("location.href='/testKosmo/kosmo/mem/mem.html'");
							out.println("</script>");
						}
					
					}else{
						System.out.println("ȸ�� ��� �� ���� ���ε� ���� ");
					}	
				}				
			} // ȸ�� ��� end
			
			// ��ü ȸ������ ��ȸ ------------------------------------------------------------------------
			if ("SALL".equals(isudType)){
				System.out.println("ȸ������ ��ü��ȸ isudType >>> : " + isudType);
				
				// ���� ȣ���ϱ� 
				MemberService ms = new MemberServiceImpl();
				ArrayList<MemberVO> aListAll = ms.memberSelectAll();
				
				if (aListAll !=null && aListAll.size() > 0) {
					
					request.setAttribute("aListAll", aListAll);					
					RequestDispatcher rd= request.getRequestDispatcher("/kosmo/mem/memSelectAll.jsp");
					rd.forward(request, response);
					
				}else {
					out.println("<script>");					
					out.println("location.href='/testKosmo/mem?ISUD_TYPE=SALL'");
					out.println("</script>");
				}		
			} // ��ü ȸ������ ��ȸ end
			
			// ȸ������ ��ȸ : S U D ---------------------------------------------------------------------
			if ("S".equals(isudType) || "U".equals(isudType) || "D".equals(isudType)){
				System.out.println("ȸ�� ������ȸ : S U D isudType >>> : " + isudType);

				String mnum = request.getParameter("mnumCheck");				
				if (mnum !=null && mnum.length() > 0){
					System.out.println("ȸ�� ��ȣ >>> :  " + mnum);
					
					// ���� ȣ���ϱ� 
					MemberService ms = new MemberServiceImpl();		
					MemberVO mvo = null;
					mvo = new MemberVO();
					
					mvo.setMnum(mnum);					
					ArrayList<MemberVO> aListS = ms.memberSelect(mvo);
					
					if (aListS !=null && aListS.size() > 0) {
						System.out.println("aListS.size() >>> : " + aListS.size());						
						request.setAttribute("aListS", aListS);					
						RequestDispatcher rd= request.getRequestDispatcher("/kosmo/mem/memSelect.jsp");
						rd.forward(request, response);
						
					}else {
						out.println("<script>");
						out.println("alert('�� ��ȸ ����')");
						out.println("location.href='/testKosmo/mem?ISUD_TYPE=SALL'");
						out.println("</script>");
					}									
				}else{
					System.out.println("�۹�ȣ��  �����ϴ�. ");
				}		
			}
			
			
			// ȸ�� ���� ------------------------------------------------------------------------------
			
			// ȸ�� ���� ------------------------------------------------------------------------------
		}else{
			System.out.println("form �±׿��� hidden Ÿ���� ISUD_TYPE �� �ѱ⼼�� >>> : ");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}