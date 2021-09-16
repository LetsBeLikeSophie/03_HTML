<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>cgiLogin</title>
</head>
<body>
<h3>cgiLogin</h3>
<hr>

<% request.setCharacterEncoding("EUC-KR"); %>
<%
	String empno = request.getParameter("empno");
	String ename = request.getParameter("ename");
	if (empno !=null) empno.toUpperCase();
	if (ename !=null) ename.toUpperCase();
	out.println("empno >>> : " + empno + "<br>");
	out.println("ename >>> : " + ename + "<br>");
	System.out.println("empno >>> : " + empno);
	System.out.println("ename >>> : " + ename);
	
	String _empno = "";
	String _ename = "";	
	
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orclKOSMO00", "scott","tiger");
	Statement stmt = conn.createStatement();
	ResultSet rsRs = stmt.executeQuery("SELECT * FROM EMP WHERE EMPNO = " + empno + " AND ENAME = " + "'" + ename + "'");
	while (rsRs.next()){
		_empno = rsRs.getString(1);
		_ename = rsRs.getString(2);
	}
	
	String sEmpno = String.valueOf(session.getAttribute("empno"));
	if (sEmpno !=null){
		if (empno.equals(sEmpno)){
			out.println(sEmpno + " 님 이미 로그인 중입니다 <br>");
			out.println("sEmpno :::: value >>> : " + sEmpno + "<br>");
			System.out.println("sEmpno :::: value >>> : " + sEmpno);	
		}		
	}
	
	session.setAttribute("empno", empno);	
	out.println(empno + " 님 로그인 하고 세션을 부여했습니다. <br>");
			
%>
</body>
</html>