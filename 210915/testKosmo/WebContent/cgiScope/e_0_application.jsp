<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>application</title>
</head>
<body>
���� ���� : <%= application.getServerInfo() %><br>
���� �Ծ� ������ ���� : <%= application.getMajorVersion() %><br>
���� �Ծ� ���̳� ���� : <%= application.getMinorVersion() %><br>
<%
	application.log("application.log :: �α׸޽��� :: " + new java.util.Date());
	log("jsp :: �α׸޽��� :: " + new java.util.Date());
%>
</body>
</html>