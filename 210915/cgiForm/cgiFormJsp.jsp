<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import="java.util.Enumeration" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>cgiFormJsp</title>
</head>
<body>
<h3>cgiFormJsp</h3>
<h3>header</h3>
<hr>
<% request.setCharacterEncoding("EUC-KR"); %>
<%-- 요청한 웹브라우저에서 header 정보 추출하기  --%>
<%
	Enumeration<String> em = request.getHeaderNames();
	while (em.hasMoreElements()){
		String name = em.nextElement();
		String value = request.getHeader(name);
		out.println(name + " : " + value + "<br>");
		System.out.println(name + " : " + value);		
	}
%>
<h3>getParameter</h3>
<!-- 
http://localhost:8088/testKosmo/cgiForm/cgiFormJsp.jsp
?mname=111
&mid=1111
&mpw=111
&mhp=111
&mgender=M
&mhobby=book
&mhobby=sports&mhobby=mugic&mhobby=trable
&mlocal=gunggido
&mmsg=11111
&isudtype=I
 -->
<hr>
<%
	String method = request.getMethod();	
	String isudtype = request.getParameter("isudtype");
	if (isudtype !=null) isudtype.toUpperCase();
	
	if (isudtype !=null && isudtype.length() > 0){
		System.out.println("isudtype >>> : " + isudtype);
		System.out.println("method >>> : " + method);
		
		if ("I".equals(isudtype)){
			
			// input type="text"			
			String mname = request.getParameter("mname");
			out.println("mname >>> : " + mname + "<br>");
			System.out.println("mname >>> : " + mname);
			
			String mid = request.getParameter("mid");
			out.println("mid >>> : " + mid + "<br>");			
			System.out.println("mid >>> : " + mid);
			
			String mpw = request.getParameter("mpw");
			out.println("mpw >>> : " + mpw + "<br>");			
			System.out.println("mpw >>> : " + mpw);
				
			// input type="radio"
			String mgender = request.getParameter("mgender");
			out.println("mgender >>> : " + mgender + "<br>");
			System.out.println("mgender >>> : " + mgender);
					
			// input type="checkbox"
			String mhobby = "";					
			String hobby[] = request.getParameterValues("mhobby");		
			if (hobby !=null){
				for(int i=0; i < hobby.length; i++){
					//out.println("hobby : " + hobby[i] + ", <br>");
					//System.out.println("hobby : " + hobby[i] + ",");
					mhobby += hobby[i] + ",";
				}		
			}
			out.println("mhobby >>> : " + mhobby + "<br>");	
		
			// input type="select"
			String mlocal = request.getParameter("mlocal");
			out.println("mlocal >>> : " + mlocal + "<br>");
			System.out.println("mlocal >>> : " + mlocal);
			
			// textarea
			String mmsg = request.getParameter("mmsg");
			out.println("mmsg >>> : " + mmsg + "<br>");
			System.out.println("mmsg >>> : " + mmsg);				
		}
		
	}else{
		System.out.println("isudtype 타입을 잘 넘기세요 >>> : ");
	}
%>
</body>
</html>