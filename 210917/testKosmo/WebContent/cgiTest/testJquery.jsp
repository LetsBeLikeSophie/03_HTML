<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">

	$(document).ready(function(){

		$("#btn").click(function(){
			alert(">>");
			
			var v1 = $("#isudtype").val('U');
			console.log("v1 >>> : " + v1.val());
			
			var v3 = $("input[name=isudtype]").val('D');
			console.log("v3 >>> : " + v3.val());
			
			var v4 = document.getElementById("isudtype").value;
			console.log("v4 >>> : " + v4);
		});
	});

</script>
</head>
<body>
<form id="formName" name="formName">
	<input type="hidden" id="isudtype" nam="isudtype" ><br>
	<input type="button" value="클릭" id="btn">
</form>
</body>
</html>