<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>b_0</title>
</head>
<body>
<h3>b_0</h3><br>
setAttribute(java.lang.String, java.lang.Object) :: getAttribute(java.lang.String)
<hr>
<%

	request.setAttribute("abc", "�ּ���");
	String abc = String.valueOf(request.getAttribute("abc")); 
	out.println("abc >>> : " + abc + "<br>");

	ArrayList<String> aList = new ArrayList<String>();
	aList.add("���翵");
	aList.add("25");
	aList.add("�ڽ��������Ϳ��� ������");
	aList.add("�����ν� ȣ����");
	request.setAttribute("aListRequest", aList);
	
	Object obj = request.getAttribute("aListRequest");
	if (obj == null) return;
	
	ArrayList<String> _aList = (ArrayList<String>)obj;
	if (_aList !=null && _aList.size() > 0){
		for (int i=0; i < _aList.size(); i++){
			out.println("b_0.jsp ::: _aList.get("+i+") >>> : " + _aList.get(i) + "<br>");
			System.out.println("b_0.jsp ::: _aList.get("+i+") >>> : " + _aList.get(i));
		}		
	}
	
	session.setAttribute("abc00", "�ּ���");
	String abc00 = String.valueOf(session.getAttribute("abc00")); 
	out.println("abc00 >>> : " + abc00 + "<br>");
	
	ArrayList<String> aListSession = new ArrayList<String>();
	aListSession.add("���翵");
	aListSession.add("25");
	aListSession.add("�ڽ��������Ϳ��� ������");
	aListSession.add("�����ν� ȣ����");
	session.setAttribute("aListSession", aListSession);
	
	Object objSession = session.getAttribute("aListSession");
	if (objSession == null) return;
	
	ArrayList<String> _aListSession = (ArrayList<String>)objSession;
	if (_aListSession !=null && _aListSession.size() > 0){
		for (int i=0; i < _aListSession.size(); i++){
			out.println("b_0.jsp ::: _aListSession.get("+i+") >>> : " + _aListSession.get(i) + "<br>");
			System.out.println("b_0.jsp ::: _aListSession.get("+i+") >>> : " + _aListSession.get(i));
		}		
	}
	
	application.setAttribute("abc11", "�ּ���");
	String abc11 = String.valueOf(application.getAttribute("abc11")); 
	out.println("abc11 >>> : " + abc11 + "<br>");
	
	ArrayList<String> aListApplication = new ArrayList<String>();
	aListApplication.add("���翵");
	aListApplication.add("25");
	aListApplication.add("�ڽ��������Ϳ��� ������");
	aListApplication.add("�����ν� ȣ����");
	session.setAttribute("aListApplication", aListApplication);
	
	Object objApplicatoin = session.getAttribute("aListApplication");
	if (objSession == null) return;
	
	ArrayList<String> _aListApplication = (ArrayList<String>)aListApplication;
	if (_aListApplication !=null && _aListApplication.size() > 0){
		for (int i=0; i < _aListApplication.size(); i++){
			out.println("b_0.jsp ::: _aListApplication.get("+i+") >>> : " + _aListApplication.get(i) + "<br>");
			System.out.println("b_0.jsp ::: _aListApplication.get("+i+") >>> : " + _aListApplication.get(i));
		}		
	}
%>

</body>
</html>