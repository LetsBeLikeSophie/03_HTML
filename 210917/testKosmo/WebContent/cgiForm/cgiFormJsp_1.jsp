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
<hr>
<%
	String method = request.getMethod();	
	String isudtype = request.getParameter("isudtype");
	if (isudtype !=null) isudtype.toUpperCase();
	
	if (isudtype !=null && isudtype.length() > 0){
		System.out.println("isudtype >>> : " + isudtype);
		System.out.println("method >>> : " + method);
		
		if ("I".equals(isudtype)){
			
			Enumeration<String> emForm = request.getParameterNames();
			
			while (emForm.hasMoreElements()){
			
				String name = emForm.nextElement();
				
				String[] values = request.getParameterValues(name);
				
				for(String v: values){
					
					out.println(name + " : " + v + "<br>");
					System.out.println(name + " : " + v);	
				}
			}							
		}
		
	}else{
		System.out.println("isudtype 타입을 잘 넘기세요 >>> : ");
	}
%>
</body>
</html>