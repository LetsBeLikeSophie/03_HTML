<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="a.b.c.cgitest.EmpVO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>dispatherSelect.jsp</title>
</head>
<body>
<h3>dispatherSelect.jsp</h3>
<hr>
<%
	Object obj = request.getAttribute("nCnt");
	if (obj == null) return;
	
	int nCnt = ((Integer)obj).intValue();
	
	if (1 == nCnt){
		System.out.println("로그인 성공 >>> : " + nCnt);	
%>
		<script>
			alert("로그인 성공");
			location.href="/testKosmo/cgiTest/testJsp_1.jsp";
		</script>
<% 		
	}
%>
</body>
</html>