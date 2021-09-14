<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>b_0</title>
</head>
<body>
<h3>b_0</h3><br>
setAttribute(java.lang.String, java.lang.Object) :: getAttribute(java.lang.String)
<hr>
<%

	request.setAttribute("abc", "최세라");
	String abc = String.valueOf(request.getAttribute("abc")); 
	out.println("abc >>> : " + abc + "<br>");
	
	application.setAttribute("abc11", "최세라");
	String abc11 = String.valueOf(application.getAttribute("abc11")); 
	out.println("abc11 >>> : " + abc11 + "<br>");
%>
</body>
</html>