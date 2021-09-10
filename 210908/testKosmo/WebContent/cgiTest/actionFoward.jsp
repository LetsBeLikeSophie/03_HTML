<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Action Forward</title>
</head>
<body>
<h2>forwar 액션 태그</h2>
<hr>
actionForward.jsp 파일 시작 부분입니다.<br>
forward 태그는 페이지 속성 파일로 제어를 넘김니다.<br>
actionForward.jsp 페이지의 출력 내용은 하나도 출력되지 않습니다.<br>

<jsp:forward page="subForward.jsp" />

actionForward.jsp 파일 끝 부분입니다.<br>
</body>
</html>