<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import="java.util.Date" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>a_1.jsp</title>
</head>
<body>
<h3>a_1.jsp</h3>
<%= new Date() %>
<hr>
<!-- 
	jsp -> javascript -> html 
 -->
<%
	String mid = request.getParameter("mid");
	String mpw = request.getParameter("mpw");
	out.println("a_1.jsp ::: id >>> : " + mid + "<br>");
	out.println("a_1.jsp ::: mpw >>> : " + mpw + "<br>");
	System.out.println("a_1.jsp ::: mid >>> : " + mid);
	System.out.println("a_1.jsp ::: mpw >>> : " + mpw);
	
	if (true){
%>
	<script>
		location.href="/testKosmo/cgiScope/a_2.jsp?mid=<%= mid %>&mpw=<%= mpw %>";
	</script>
<%	
	}else{
%>
	<form action="/testKosmo/cgiScope/a_2.jsp" method="GET">
	아이디 : <input type="text" name="mid" value="<%= mid %>"><br>
	패스워드 : <input type="text" name="mpw" value="<%= mpw %>"><br>
			<input type="submit"  value="보내기">
	</form>
<%
	}
%>



</body>
</html>