<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import="java.util.Date" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>a_2.jsp</title>
</head>
<body>
<h3>a_2.jsp</h3>
<%= new Date() %>
<hr>
<%
	String mid = request.getParameter("mid");
	String mpw = request.getParameter("mpw");
	out.println("a_2.jsp ::: mid >>> : " + mid + "<br>");
	out.println("a_2.jsp ::: mpw >>> : " + mpw + "<br>");
	System.out.println("a_2.jsp ::: mid >>> : " + mid);
	System.out.println("a_2.jsp ::: mpw >>> : " + mpw);
	
	if (true){
%>
		<script>
			location.assign("/testKosmo/a_3?mid="+ <%= mid %> +"&mpw=" + <%= mpw %>);
		</script>		
<%		
	}
%>
<hr>

</body>
</html>