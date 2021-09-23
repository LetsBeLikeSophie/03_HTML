<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>d_sendRedirect</title>
</head>
<body>
<h3>d_sendRedirect</h3>
<hr>
<%
	String mid = "abc00";
	String mpw = "abc1234";
	response.sendRedirect("/testKosmo/cgiScope/d_1.jsp?mid="+mid+"&mpw="+mpw);
%>
</body>
</html>