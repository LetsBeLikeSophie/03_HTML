<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>b_3</title>
</head>
<body>
<h3>b_3</h3>
<hr>

<%
	Object getData = session.getAttribute("abc00");
	String is_getData = String.valueOf(getData);
	out.println("is_getData >>> : " + is_getData + "<br>");
	
	if ("최세라".equals(is_getData)){
		out.println("is_getData >>> : "+ is_getData);
%>
	<script>
		alert('<%= is_getData %> 님 로그인 중입니당');
	</script>
<%		
	}else{
%>
	<script>
		alert('<%= is_getData %> 님 현재 로그아웃 중입니당');
	</script>
<%		
	}

%>

</body>
</html>