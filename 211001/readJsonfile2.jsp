<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
	
	$(document).ready(function(){
		
		$("#btn1").click(function(){
			
			console.log(">>> : btn1.click() OK");			
			var jsonUrl = "/testCss/jsonTest/dept.json";
			
			$.ajax({
				type: "POST",
				url : jsonUrl,
				dataType: "text",
				success: function(data){				
					var v = JSON.stringify(data);	// �ڹٽ�ũ��Ʈ ��ü�� ���ڿ��� ��ȯ��.
					var vv = JSON.parse(data);	// JSON ������ ���ڿ��� �ڹٽ�ũ��Ʈ ��ü�� ��ȯ��.					
					console.log(vv);
					console.log(vv.length);
					
					for (var i=0; i < vv.length; i++){					
						document.getElementById("json1").innerHTML 	 += vv[i].DEPTNO + ", " 
																	 + vv[i].DNAME + ", "
																	 + vv[i].LOC + "<br>";
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