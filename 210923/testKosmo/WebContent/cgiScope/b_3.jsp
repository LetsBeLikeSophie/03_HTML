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
	out.println("b3.jsp ::: is_getData >>> : " + is_getData + "<br>");
	
	if ("�ּ���".equals(is_getData)){
		out.println("b_3.jsp ::: is_getData >>> : "+ is_getData);
%>
	<script>
		alert('<%= is_getData %> �� �α��� ���Դϴ�');
	</script>
<%		
	}else{
%>
	<script>
		alert('<%= is_getData %> �� ���� �α׾ƿ� ���Դϴ�');
	</script>
<%		
	}

%>

</body>
</html>