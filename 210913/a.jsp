<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import="java.util.Date" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>a.jsp</title>
</head>
<body>
<h3>a.jsp</h3>
<%= new Date() %>
<hr>
<form action="/testKosmo/cgiScope/a_1.jsp" method="GET">
아이디 : <input type="text" name="mid"><br>
패스워드 : <input type="text" name="mpw"><br>
		<input type="submit"  value="보내기">
</form>

</body>
</html>