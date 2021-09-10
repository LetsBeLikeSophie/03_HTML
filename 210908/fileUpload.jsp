<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>fileUpload.jsp</title>
</head>
<body>
<h3>fileUpload.jsp</h3>
<hr>
<%
	Object obj = request.getAttribute("aList");
	if (obj == null) return;
	
	ArrayList<String> aList = (ArrayList<String>)obj;
	
	if (aList !=null && aList.size() > 0){
		for (int i=0; i < aList.size(); i++){
			out.println(">>> : " + aList.get(i) + "<br>");
		}		
	}
%>
</body>
</html>