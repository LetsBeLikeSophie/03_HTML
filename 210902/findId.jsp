<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import="java.util.ArrayList" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>IDFIND</title>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">

	$(document).ready(function(){	
		
		$("#mcomfirm").click(function(){
			console.log("mcomfirm >>> : ");		
			alert("mcomfirm >>> : ");
			
		});
		
		$("#idbtn").click(function(){
			console.log("idbtn >>> : ");
			alert("idbtn >>> : ");
			
		});
	});
</script>
</head>
<body>
<h3 align="center">IDFIND</h3>
<hr>
<%
	String mname = "";
	String memail = "";
	String authnum = "";
%>
<h4 align="center">본인확인 이메일 주소와  입력한 이메일 주소가 같아야, 인증번호를 받을 수 있습니다.</h4>
<form name="idForm" id="idForm">
<table border="1" align="center">
<tr>
<td>이름</td>
<td><input type="text" name="mname" id="mname" value='<%= mname%>'  style="width:200px;"></td>
</tr>
<tr>
<td>이메일 주소</td>
<td>
	<input type="text" name="memail" id="memail" value='<%= memail%>'  placeholder="" style="width:200px;">
	<button type="button" id="mcomfirm">인증번호받기</button>
</td>
</tr>
<tr>
<td>인증번호</td>
<td>
<input type="text" name="authnum" id="authnum" value='<%= authnum%>' 
       placeholder="인증번호  6자리 숫자 입력" style="width:200px;"></td>
</tr>
<tr>
<td></td>
<td>인증번호가 오지 않나요<img src="/testWeb/img/ase.gif" width="20" height="20">
</td>
</tr>
<tr>
<td colspan="2" align="center">
<input type="hidden" name="login_type" id="login_type">
<button type="button" id="idbtn">다음</button>
</td>
</tr>
</table> 
</form>
</body>
</html>
