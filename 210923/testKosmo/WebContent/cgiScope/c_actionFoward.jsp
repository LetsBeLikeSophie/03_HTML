<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Action Forward</title>
</head>
<body>
<h2>forwar �׼� �±�</h2>
<hr>
actionForward.jsp ���� ���� �κ��Դϴ�.<br>
forward �±״� ������ �Ӽ� ���Ϸ� ��� �ѱ�ϴ�.<br>
actionForward.jsp �������� ��� ������ �ϳ��� ��µ��� �ʽ��ϴ�.<br>
<%
	String mid = "kosmo00";
	String mpw = "kosmo1234";
%>

<jsp:forward page="c_subForward.jsp" >
	<jsp:param value="data_value" name="parameter_key"/>
	<jsp:param value="<%= mid %>" name="mid"/>
	<jsp:param value="<%= mpw %>" name="mpw"/>
</jsp:forward>

actionForward.jsp ���� �� �κ��Դϴ�.<br>
</body>
</html>