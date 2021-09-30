<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@page import="a.b.c.com.kosmo.notice.service.NoticeService"%>
<%@page import="a.b.c.com.kosmo.notice.service.NoticeServiceImpl"%>    
<%@page import="a.b.c.com.kosmo.notice.vo.NoticeVO"%>    
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>���� ����</title>
<style type="text/css">

	html {overflow:hidden;} 

	div {
		width: 80%;		
		margin: 0 auto;
	}			

	td, th {
		 padding: 5px;
	}
	
	.tt {
		text-align: left;
	}
	
	.tt1 {
		text-align: center;
	}
</style>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">

	function closePopup(){
		alert("������ ������");
	}
	
</script>
</head>
<body>
<% request.setCharacterEncoding("EUC-KR");%> 
<%
	Object obj = request.getAttribute("aListS");
	if (obj == null) return;
	
	ArrayList<NoticeVO> aList = (ArrayList<NoticeVO>)obj;
	int nCnt = aList.size();
	
	String nnum = "";
	String nsubject = "";		
	String nmemo = "";
	String nphoto = "";
	
	if (nCnt == 1){
		NoticeVO nvo = aList.get(0);
		
		nnum = nvo.getNnum();
		nsubject = nvo.getNsubject();
		nmemo = nvo.getNmemo();
		nphoto = nvo.getNphoto();
	}
%>
<h4>�������� �˾�</h4>
<hr>
<div>
<form name="noticeForm" id="noticeForm">
<table>
<tr>	
	<td align="center">					
		<font size="4" style="color:blue;">���� ���� </font> 
		<img src="/testKosmo/img/img_mando/ase.gif" width="25" height="25" alt="image">		
	</td>				
</tr>
<tr>
	<td class="tt">������ȣ : <%= nnum %></td>
</tr>
<tr>
	<td class="tt">���� : <%= nsubject %></td>	
</tr>
<tr>
	<td class="tt">���� : <%= nmemo %>	
</td>
</tr>
<tr>
	<td class="tt1">
		<img src="/testKosmo/fileupload/notice/<%= nphoto %>" border="1" width="60" height="50" alt="image">		
	</td>
</tr>
<tr>			
<tr>
	<td>
		<input type="checkbox" name="notice" onClick="closePopup()"> <font style="font-size:10px">���� �Ϸ� ���� ���� ����</font>	
	</td>
</tr>

</table> 
</form>
</div>
</body>
</html>