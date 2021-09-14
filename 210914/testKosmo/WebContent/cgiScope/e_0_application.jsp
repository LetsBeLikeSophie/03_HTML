<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>application</title>
</head>
<body>
서버 정보 : <%= application.getServerInfo() %><br>
서블릿 규약 메이저 버전 : <%= application.getMajorVersion() %><br>
서블릿 규약 마이너 버전 : <%= application.getMinorVersion() %><br>
<%
	application.log("application.log :: 로그메시지 :: " + new java.util.Date());
	log("jsp :: 로그메시지 :: " + new java.util.Date());
%>
</body>
</html>