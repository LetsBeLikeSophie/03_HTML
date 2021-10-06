<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
	
	$(document).ready(function(){
		console.log(">>> : ");
		
		$("#btn1").click(function(){
			console.log(">>> : btn1.click() OK");
			
			var jsonUrl = "/testCss/jsonTest/emp.json";
			
			$.ajax({
				type: "POST",
				url : jsonUrl,
				dataType: "text",
				success: function(data){				
					console.log(data);	
					var v = JSON.stringify(data);	// 자바스크립트 객체를 문자열로 변환함.
					document.getElementById("json").innerHTML = v;
					
					var vv = JSON.parse(data);	// JSON 형식의 문자열을 자바스크립트 객체로 변환함.
					
					console.log(vv);
					console.log(vv.length);
					console.log(vv[0]);									
					
					document.getElementById("json1").innerHTML = vv + "<br>";
					document.getElementById("json1").innerHTML 
					 	+= vv[0].EMPNO + ", " 
						 + vv[0].ENAME + ", "
						 + vv[0].JOB + ", "
						 + vv[0].MGR + ", "
						 + vv[0].HIREDATE + ", "
						 + vv[0].SAL + ", "
						 + vv[0].COMM + ", "
						 + vv[0].DEPTNO + "<br>";
					
					for (var i=0; i < vv.length; i++){
					
						document.getElementById("json1").innerHTML 
					 	
						+= vv[i].EMPNO + ", " 
						 + vv[i].ENAME + ", "
						 + vv[i].JOB + ", "
						 + vv[i].MGR + ", "
						 + vv[i].HIREDATE + ", "
						 + vv[i].SAL + ", "
						 + vv[i].COMM + ", "
						 + vv[i].DEPTNO + "<br>";
					}
					
				}
			});
		});
	});

</script>
</head>
<body>
<p id="json"></p>
<p id="json1"></p>
<button id="btn1">button</button>
</body>
</html>