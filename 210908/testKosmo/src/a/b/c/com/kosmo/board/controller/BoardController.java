package a.b.c.com.kosmo.board.controller;

import java.io.IOException;
import java.io.PrintWriter;
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
import a.b.c.com.kosmo.board.service.BoardService;
import a.b.c.com.kosmo.board.service.BoardServiceImpl;
import a.b.c.com.kosmo.board.vo.BoardVO;

@WebServlet("/board")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
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
			
			// �۵�� ------------------------------------------------------------------------
			if ("I".equals(isudType)){
				System.out.println("�Խ��� �� ��� isudType >>> : " + isudType);
				
				 String saveDirectory = CommonUtils.BOARD_IMG_UPLOAD_PATH;
                 int maxPostSize = CommonUtils.BOARD_IMG_FILE_SIZE;
                 String  encoding = CommonUtils.BOOK_IMG_ENCODE;
				
				
				boolean bool = request.getContentType().toLowerCase().startsWith("multipart/form-data");				
				if (bool){
					System.out.println("�Խ��� �� ��� ���Ͼ��ε� ��ƾ :: bool >>> : " + bool);
					
					try {
						MultipartRequest mr = new MultipartRequest(  request  
													                ,saveDirectory
													                ,maxPostSize
													                ,encoding
													                ,new DefaultFileRenamePolicy());
						
						String bsubject = mr.getParameter("bsubject");
						String bwriter = mr.getParameter("bwriter");
						String bpw = mr.getParameter("bpw");
						String bmemo = mr.getParameter("bmemo");
						// ����
						// String bphoto = mr.getParameter("bsubject");
						Enumeration<String> e = mr.getFileNames();
						String imgName = e.nextElement();
						String bphoto = mr.getFilesystemName(imgName);
						
						System.out.println("bsubject >>> : " + bsubject);
						System.out.println("bwriter >>> : " + bwriter);
						System.out.println("bpw >>> : " + bpw);
						System.out.println("bmemo >>> : " + bmemo);					
						System.out.println("bphoto >>> : " + bphoto);
						
						// ���� ȣ���ϱ� 
						BoardService bs = new BoardServiceImpl();
						BoardVO bvo = null;
						bvo = new BoardVO();
						
						bvo.setBnum("BD202109080001");
						bvo.setBsubject(bsubject);
						bvo.setBwriter(bwriter);
						bvo.setBpw(bpw);
						bvo.setBmemo(bmemo);
						bvo.setBphoto(bphoto);
						
						boolean bInsert = bs.boardInsert(bvo);
						
						if (bInsert){						
							request.setAttribute("bInsert", new Boolean(bInsert));				
							// RequestDispatcher �������̽� ���� ����ϴ� getRequestDispatcher �Լ������� 
							// Context ��θ� �������  ����								
							RequestDispatcher rd = request.getRequestDispatcher("/kosmo/board/boardInsert.jsp");
							rd.forward(request, response);						
						}else{
							out.println("<script>");				
							out.println("location.href='/testKosmokosmo/board/board.html'");
							out.println("</script>");
						}
						
					}catch(Exception e){
						System.out.println("�Խñ� ��� �� ������ >>> :" + e.getMessage());
					}
					
				}				
			} // �۵�� end 
			
			// �� ��ü��ȸ ---------------------------------------------------------------------
			// �� ������ȸ ---------------------------------------------------------------------
			// �� ���� ------------------------------------------------------------------------
			// �� ���� ------------------------------------------------------------------------
			
			
		}else{
			System.out.println("form �±׿��� hidden Ÿ���� ISUD_TYPE �� �ѱ⼼�� >>> : ");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
