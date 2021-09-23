<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>d_1</title>
</head>
<body>
<h3>d_1</h3>
<hr>
<%
	String mid = request.getParameter("mid");
	String mpw = request.getParameter("mpw");
	out.println("d_1.jsp ::: mid >>> : " + mid + "<br>");
	out.println("d_1.jsp ::: mpw >>> : " + mpw + "<br>");
	System.out.println("d_1.jsp ::: mid >>> : " + mid + "<br>");
	System.out.println("d_1.jsp ::: mpw >>> : " + mpw + "<br>");
%>
</body>
</html>