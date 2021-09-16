<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="a.b.c.cgitest.EmpVO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>dispather.jsp</title>
</head>
<body>
<h3>dispather.jsp</h3>
<hr>
<%
	Object obj = request.getAttribute("aList");
	if (obj == null) return;
	
	ArrayList<EmpVO> aList = (ArrayList<EmpVO>)obj;
	
	if (aList !=null && aList.size() > 0){
		out.println("aList >>> : " + aList.size() + "<br>");	
		
		for (int i=0; i < aList.size(); i++){
			EmpVO evo = aList.get(i);
			out.println(evo.getEmpno() + " : ");
			out.println(evo.getEname() + " : ");
			out.println(evo.getJob() + " : ");
			out.println(evo.getMgr() + " : ");
			out.println(evo.getHiredate() + " : ");
			out.println(evo.getSal() + " : ");
			out.println(evo.getComm() + " : ");
			out.println(evo.getDeptno() + "<br>");
		}
		
	}else{
		out.println("ArrayList에 데이터가 없서요 >>> :");
	}
	
%>
</body>
</html>