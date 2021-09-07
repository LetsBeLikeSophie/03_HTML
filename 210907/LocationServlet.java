package a.b.c.cgitest;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LocationServlet
 */
@WebServlet("/location")
public class LocationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) 
		throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		req.setCharacterEncoding("EUC-KR");
		res.setContentType("text/html; charset=EUC-KR"); 
		PrintWriter out = res.getWriter();
		
		/*
		out.println("<script>");
		out.println("location.href='http://www.naver.com'");
		out.println("</script>");
		*/
		
		// /testKosmo/WebContent/cgiTest/dispather.jsp 
		// /testKosmo/cgiTest/dispather.jsp 
		// :: WebContent ��θ� ��Ŭ���� ���̳��� �� ������Ʈ ���� �����ӿ�ũ���� ����ϴ� ���� ����̴�.
		// RequestDispatcher �������̽� ���� ����ϴ� getRequestDispatcher �Լ������� 
		// Context ��θ� �������  ����
		RequestDispatcher rd = req.getRequestDispatcher("/cgiTest/dispather.jsp");
		rd.forward(req, res);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
