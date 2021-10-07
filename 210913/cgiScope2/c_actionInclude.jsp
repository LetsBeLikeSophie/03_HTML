<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h2> include Action tag</h2>
actionInclude.jsp 파일 시작 부분입니다.<br>
include 태그는 페이지 속성 파일 결과를 태그 위치에 삽입합니다<p><br>

<jsp:include page="c_subInclude.jsp" />

<p><br>
c_actionInclude.jsp 파일 끝 부분입니다.<br>

<jsp:include page="c_subInclude.jsp">
	<jsp:param value="aaa" name="id"/>
	<jsp:param value="aaa00" name="pw"/>
</jsp:include>

<%
	String id1 = request.getParameter("id");
	String pw1 = request.getParameter("pw");
%>
<br>
<%= "c_actionInclude.jsp ::: id1 >>> : " + id1 %><br>
<%= "c_actionInclude.jsp ::: pw1 >>> : " + pw1 %>
</body>
</html>