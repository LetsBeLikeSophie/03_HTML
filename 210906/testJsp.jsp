2021-09-06
--------------------------------------

웹 애플리케이션 

웹 : 웹 브라우저에서 구동되는 프로그램 : 웹 서비스 
앱 : 폰에서 구동되는 프로그램 

웹 서비스를 제공하는 프로그램 
웹 서비스를 제공받는 브라우저 

웹 서비스 : 웹 브라우저로 웹 애플리케이션 프로그램의 결과를 받는 것

확장 CGI : Common Gateway Interface 
웹 브라우저 <- HTML -> 웹서버 <- JSP, Servlet, PHP, .NET ... etc. -> WAS <- JDBC, ODBC ... etc. -> 데이터베이스 

웹 브라우저(크롬, ie, Edge) <- html -> 웹서버(탐캣 코요테) <- jsp, Servlet -> 와쓰(탐캣 카탈리나) <- JDBC-> 오라클 11g 2릴리즈  


Client Side Script : html, css, javaScript : 정적인 페이지
Server Side Script : jsp : 동적인 페이지 


jsp : Java Server Page 
===================================
웹 브라우저에서 페이지를 이동 시키는 기술 

웹 브라우저에서 시작 태그의 표시를 보고 스크립트를 구분한다. 

<%@ : jsp 표시 
<html> : html 
<script> : 자바스크립트 
<style> : css
<?xml : xml 


jsp 파일 실행과정 : 자스퍼(jasper.jar) 가한다.
==========================================
*.jsp -> *_jsp.java 서블릿 소스로 변환한다. --> 변환된 *_jsp.java 서블릿 소스는 *_jsp.class 로 컴파일 된다.
*_jsp.class 파일이 실행 되어서 결과를 클라이언트에게 전달한다.
==========================================
WebContent -> cgiTest -> New -> Jsp File 에서 testJsp.jsp 생성 
HTML 코드에 내용 추가 
JSP 코드블럭에 내용 추가 
XML 코드 추가 
실행을 시킴

testJsp.jsp ---> testJsp_jsp.java 변경된다. 
testJsp_jsp.java ---> testJsp_jsp.class 컴파일 된다. 
testJsp_jsp.class 클래스 파일이 실행된다.

C:\00.KOSMO93\30.Web\el_web_neon _work\
.metadata\
.plugins\
org.eclipse.wst.server.core\ <-- 항상 요기를 찾아야 한다. 
tmp0\ <-- tmp1, tmp2  가 생기기도 한다. 잘 확인하고 사용해야 한다. 
work\
Catalina\localhost\
testKosmo\
org\apache\jsp\
cgiTest <-- 컨텍스트


