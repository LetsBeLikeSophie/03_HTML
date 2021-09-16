<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>cgiLogin</title>
</head>
<body>
<h3>cgiLogin</h3>
<hr>

<% request.setCharacterEncoding("EUC-KR"); %>
<%
	String mid = request.getParameter("mid");
	String mpw = request.getParameter("mpw");
	
	String _mid = "abc00";
	String _mpw = "abc1234";
	
	
%>
</body>
</html>