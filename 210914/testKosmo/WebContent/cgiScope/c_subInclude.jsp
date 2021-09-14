<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

<%
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
%>
<br>
<%= "c_subInclude.jsp ::: id >>> : " + id %><br>
<%= "c_subInclude.jsp ::: ipw >>> : " + pw %>
<hr>
<font color=blue>
이 부분은 include 태그가 있던 자리로 sub.jsp의 결과가 나타나게 됩니다. 	
</font>
</body>
</html>