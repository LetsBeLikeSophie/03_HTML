<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import="a.b.c.com.common.ImageFileEditUtil" %>
<%@ page import="a.b.c.com.common.CommonUtils" %>
<%@ page import="java.io.File" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>������ ����</title>
<style type="text/css">
	* {
		margin: 0 auto;
		text-align: center;
	}
		
	td {
		padding: 5px;
	}
	
	.attr {
		font-weight: bold;
	}
	
	.align {
		text-align: left;
	}
	
	a { text-decoration:none } 
	a:link { color: red; text-decoration: none;}
 	a:visited { color: red; text-decoration: none;}
	a:hover { color: red; text-decoration: none;}
</style>
</head>
<%
String sf = CommonUtils.BOOK_IMG_UPLOAD_PATH;
String originFile = "book1.jpg";
File f = new File(sf + "//" + originFile);
int index = originFile.lastIndexOf(".");
String fileExt = originFile.substring(index + 1);
System.out.println("fileExt >>> : " + fileExt);
String thumbnailFile = ImageFileEditUtil.makeThumbnail(f.getAbsolutePath(), sf, originFile, fileExt, request);
System.out.println("thumbnailFile >>> : " + thumbnailFile);
%>
<body>
������ å��
<hr>
<div>
<table border="1" width="850" height="100">
<tr>
	<td calspan="2" class="align">
		�汸�� �ɸ��� �����-�������� �� �� �ִ� 50���� �ʰ��� �Ǹ�����
		<img src="/testKosmo/img/img_book/bu_freeshipping.gif">
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;		
		<img src="/testKosmo/img/img_book/btn_share.png">
	</td>
</tr>
<tr>
	<td></td>	
</tr>
<tr>
	<td></td>	
</tr>

</table>
</div>
<div>
<form>
<table border="1" width="850" height="400">
<tr>
	<td rowspan="12" width="300" height="400">
		<img src="/testKosmo/fileupload/book/<%= thumbnailFile%>">
	</td>
	<td colspan="4" class="align">
		<h4 style="color:red">
			<a href="#">			
				ȭ���� å + ������ ����.��������(�̺�Ʈ ���� ����, ������ 4�����̻�)		
			</a>
		</h4>				
	</td>	
 </tr>
<tr>	
	<td class="align">����</td>
	<td colspan="3" class="align">18,000��</td>
</tr>
<tr>
	<td class="align">�ǸŰ�</td>
	<td colspan="3" class="align">
		<font size="5" class="align">16,200</font>��(10%, 1,800�� ����)
	</td>
</tr>
<tr>	
	<td class="align">���ϸ���</td>
	<td colspan="3" class="align">
		900��(5%) + �����(3~1%)<br> 
		+ 5�����̻� ���Ž� 2,000��
		<img src="/testKosmo/img/img_book/icon_question.png">
	</td>
</tr>
<tr>	
	<td class="align">��۷�</td>
	<td colspan="3" class="align">
		�Ű����� �� 1�ǵ� ����
		<img src="/testKosmo/img/img_book/icon_question.png">
	</td>
</tr>
<tr>
	<td class="align">
		�̹���
	</td>
	<td colspan="3" class="align">
		<button style="background-color:#FAAC58;  color:white">��ź�ڹ��</button><br>
		�� 10�ñ��� �ֹ��ϸ� ���� ��ħ 7�� <font color="red">����� ���</font><br>
		(�߱� �߸��� ����) ��������
	</td>
</tr>
<tr>	
	<td colspan="4" class="align">
		Sales Point: 710 �̹���
		<img src="/testKosmo/img/img_book/icon_question.png">
	</td>
</tr>
<tr>	
	<td colspan="4" class="align">
		<img src="/testKosmo/img/img_book/icon_star10.png">
		��ǥ�̹��� 10.0 100����(11) ����(17)
		<button style="background-color:#58ACFA;  color:white">�� å ���?</button>
	</td>	
</tr>
<tr>	
	<td class="align">
		����å
		<img src="/testKosmo/img/img_book/btn_go.png">
	</td>
	<td colspan="3" class="align">11,340�� �̹���</td>
</tr>  
<tr>	
	<td colspan="4"  class="align">
		<a href="#">ī��/������� Ȱ�� ></a>
		<a href="#">������ �Һ� ></a>
		<a href="#">�ҵ���� ></a>
	</td>	
</tr>
<tr>	
	<td class="align">����</td>
	<td colspan="3" class="align">
		<input type="number">
	</td>
</tr> 
<tr>	
	<td colspan="4" class="align">
		<button style="background-color:#FE2EF7; color:white">��ٱ��� ���</button>	
		<button style="background-color:#FF0040; color:white">�ٷα���</button>
		<button style="color:red;">�����ϱ�</button>	
		<button style="color:red;">������ +</button>
	</td>
</tr>
<tr>	
	<td>
		<img src="/testKosmo/img/img_book/icon_prev_book.png">
		�̸�����
	</td>
	<td colspan="3" class="align">
		<a href="#">�߰� ��Ͼ˸� ��û > </a>
		<a href="#">�߰�� �ȱ�</a>	
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;		
		<img src="/testKosmo/img/img_book/btn_more.png">
	</td>
</tr> 
</table>
</form>
</div>
</body>
</html>