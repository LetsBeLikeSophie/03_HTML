<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import="a.b.c.com.common.ImageFileEditUtil" %>
<%@ page import="a.b.c.com.common.CommonUtils" %>
<%@ page import="java.io.File" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>정예지 서점</title>
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
정예지 책방
<hr>
<div>
<table border="1" width="850" height="100">
<tr>
	<td calspan="2" class="align">
		방구석 심리학 실험실-집에서도 할 수 있는 50가지 초간단 실림실험
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
				화제의 책 + 가랜드 램프.직소퍼즐(이벤트 도서 포함, 국내서 4만원이상)		
			</a>
		</h4>				
	</td>	
 </tr>
<tr>	
	<td class="align">정가</td>
	<td colspan="3" class="align">18,000원</td>
</tr>
<tr>
	<td class="align">판매가</td>
	<td colspan="3" class="align">
		<font size="5" class="align">16,200</font>원(10%, 1,800원 할인)
	</td>
</tr>
<tr>	
	<td class="align">마일리지</td>
	<td colspan="3" class="align">
		900원(5%) + 멤버십(3~1%)<br> 
		+ 5만원이상 구매시 2,000원
		<img src="/testKosmo/img/img_book/icon_question.png">
	</td>
</tr>
<tr>	
	<td class="align">배송료</td>
	<td colspan="3" class="align">
		신간도서 단 1권도 무료
		<img src="/testKosmo/img/img_book/icon_question.png">
	</td>
</tr>
<tr>
	<td class="align">
		이미지
	</td>
	<td colspan="3" class="align">
		<button style="background-color:#FAAC58;  color:white">양탄자배송</button><br>
		밤 10시까지 주문하면 내일 아침 7시 <font color="red">출근전 배송</font><br>
		(중구 중림동 기준) 지역변경
	</td>
</tr>
<tr>	
	<td colspan="4" class="align">
		Sales Point: 710 이미지
		<img src="/testKosmo/img/img_book/icon_question.png">
	</td>
</tr>
<tr>	
	<td colspan="4" class="align">
		<img src="/testKosmo/img/img_book/icon_star10.png">
		별표이미지 10.0 100자평(11) 리뷰(17)
		<button style="background-color:#58ACFA;  color:white">이 책 어때요?</button>
	</td>	
</tr>
<tr>	
	<td class="align">
		전자책
		<img src="/testKosmo/img/img_book/btn_go.png">
	</td>
	<td colspan="3" class="align">11,340원 이미지</td>
</tr>  
<tr>	
	<td colspan="4"  class="align">
		<a href="#">카드/간편결제 활인 ></a>
		<a href="#">무이자 할부 ></a>
		<a href="#">소득공재 ></a>
	</td>	
</tr>
<tr>	
	<td class="align">수량</td>
	<td colspan="3" class="align">
		<input type="number">
	</td>
</tr> 
<tr>	
	<td colspan="4" class="align">
		<button style="background-color:#FE2EF7; color:white">장바구니 담기</button>	
		<button style="background-color:#FF0040; color:white">바로구매</button>
		<button style="color:red;">선물하기</button>	
		<button style="color:red;">보관함 +</button>
	</td>
</tr>
<tr>	
	<td>
		<img src="/testKosmo/img/img_book/icon_prev_book.png">
		미리보기
	</td>
	<td colspan="3" class="align">
		<a href="#">중고 등록알림 신청 > </a>
		<a href="#">중고로 팔기</a>	
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