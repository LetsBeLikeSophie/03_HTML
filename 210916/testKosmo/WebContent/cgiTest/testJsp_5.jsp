<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Ŭ���̾�Ʈ �� ��������</title>
</head>
<body>
<h3>Ŭ���̾�Ʈ �� ��������<h3>
<hr>

<%
	// jsp ���� request ������ ������Ʈ(built in Object)�� �����ϸ�
	// HttpServletRequest �������̽���  �ִ� �ڿ��� ����� �� �ִ�. 
	// IPv4 : 192.168.219.100
	// IPv6 : 0:0:0:0:0:0:0:1
	// http://192.168.219.100:8088/testKosmo/cgiTest/testJsp_5.jsp
	String remoteAddr = request.getRemoteAddr();
	out.println("remoteAddr >>> : " + remoteAddr + "<br>");
	System.out.println("remoteAddr >>> : " + remoteAddr);
	
	String protocol = request.getProtocol();
	out.println("protocol >>> : " + protocol + "<br>");
	System.out.println("protocol >>> : " + protocol);
	
	String method = request.getMethod();
	out.println("method >>> : " + method + "<br>");
	System.out.println("method >>> : " + method);
	
	String uri = request.getRequestURI();
	out.println("uri >>> : " + uri + "<br>");
	System.out.println("uri >>> : " + uri);	
	
	String url = request.getRequestURL().toString();
	out.println("url >>> : " + url + "<br>");
	System.out.println("url >>> : " + url);	
	
	String context = request.getContextPath();
	out.println("context >>> : " + context + "<br>");
	System.out.println("context >>> : " + context);	
	
	String serverName = request.getServerName();
	out.println("serverName >>> : " + serverName + "<br>");
	System.out.println("serverName >>> : " + serverName);	
	
	String serverPort = String.valueOf(request.getServerPort());
	out.println("serverPort >>> : " + serverPort + "<br>");
	System.out.println("serverPort >>> : " + serverPort);	
	
	String remotePort = String.valueOf(request.getRemotePort());
	out.println("remotePort >>> : " + remotePort + "<br>");
	System.out.println("remotePort >>> : " + remotePort);	
	
%>

</body>
</html>