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
		// :: WebContent 경로를 이클립스 다이나믹 웹 프로젝트 빌드 프레임워크에서 사용하는 가상 경로이다.
		// RequestDispatcher 인터페이스 에서 사용하는 getRequestDispatcher 함수에서는 
		// Context 경로를 사용하지  않음
		RequestDispatcher rd = req.getRequestDispatcher("/cgiTest/dispather.jsp");
		rd.forward(req, res);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
