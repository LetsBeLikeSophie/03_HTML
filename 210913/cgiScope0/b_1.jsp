<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>b_1</title>
</head>
<body>
<h3>b_1</h3>
<hr>
<%
	String abc = String.valueOf(request.getAttribute("abc")); 
	out.println("abc >>> : " + abc + "<br>");
	
	String abc00 = String.valueOf(session.getAttribute("abc00")); 
	out.println("abc00 >>> : " + abc00 + "<br>");
	
	String abc11 = String.valueOf(application.getAttribute("abc11")); 
	out.println("abc11 >>> : " + abc11);
%>
</body>
</html>