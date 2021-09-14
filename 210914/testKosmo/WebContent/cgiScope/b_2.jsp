<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>b_2</title>
</head>
<body>
<h3>b_2</h3>
<hr>
<%
	String abc = String.valueOf(request.getAttribute("abc")); 
	out.println("b_2.jsp ::: abc >>> : " + abc + "<br>");
	
	String abc00 = String.valueOf(session.getAttribute("abc00")); 
	out.println("b_2.jsp ::: abc00 >>> : " + abc00 + "<br>");
	
	String abc11 = String.valueOf(application.getAttribute("abc11")); 
	out.println("b_2.jsp ::: abc11 >>> : " + abc11);
%>
</body>
</html>