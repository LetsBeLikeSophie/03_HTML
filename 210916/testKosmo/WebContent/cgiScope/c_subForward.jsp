<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>포워드</title>
</head>
<body>
<%
	String xxx = request.getParameter("parameter_key");
	String mid = request.getParameter("mid");
	String mpw = request.getParameter("mpw");
	out.println("c_subForward.jsp :::  xxx >>> : " + xxx + "<br>");
	out.println("c_subForward.jsp :::  mid >>> : " + mid + "<br>");
	out.println("c_subForward.jsp :::  mpw >>> : " + mpw + "<br>");
	System.out.println("c_subForward.jsp :::  xxx >>> : " + xxx);
	System.out.println("c_subForward.jsp :::  mid >>> : " + mid);
	System.out.println("c_subForward.jsp :::  mpw >>> : " + mpw);	
%>
<h2>forwar 액션 태그</h2>
<hr><font color="blue">
이전에 있던 c_actionForward.jsp의 출력이 나오지 않습니다.<br>
forward 태그는 페이지 속성 파일로 제어를 넘김니다.<br>

이 부분이 forward 태그가 있던 자리로 
c_subForward.jsp의 결과만이 출력 됩니다.<br>


이후에 있던 c_actionForward.jsp 파일 끝 부분의 출력이 나오지 않습니다.<br>
</font>
</body>
</html>