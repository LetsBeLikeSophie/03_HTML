2021-09-06
--------------------------------------

�� ���ø����̼� 

�� : �� ���������� �����Ǵ� ���α׷� : �� ���� 
�� : ������ �����Ǵ� ���α׷� 

�� ���񽺸� �����ϴ� ���α׷� 
�� ���񽺸� �����޴� ������ 

�� ���� : �� �������� �� ���ø����̼� ���α׷��� ����� �޴� ��

Ȯ�� CGI : Common Gateway Interface 
�� ������ <- HTML -> ������ <- JSP, Servlet, PHP, .NET ... etc. -> WAS <- JDBC, ODBC ... etc. -> �����ͺ��̽� 

�� ������(ũ��, ie, Edge) <- html -> ������(ŽĹ �ڿ���) <- jsp, Servlet -> �;�(ŽĹ īŻ����) <- JDBC-> ����Ŭ 11g 2������  


Client Side Script : html, css, javaScript : ������ ������
Server Side Script : jsp : ������ ������ 


jsp : Java Server Page 
===================================
�� ���������� �������� �̵� ��Ű�� ��� 

�� ���������� ���� �±��� ǥ�ø� ���� ��ũ��Ʈ�� �����Ѵ�. 

<%@ : jsp ǥ�� 
<html> : html 
<script> : �ڹٽ�ũ��Ʈ 
<style> : css
<?xml : xml 


jsp ���� ������� : �ڽ���(jasper.jar) ���Ѵ�.
==========================================
*.jsp -> *_jsp.java ���� �ҽ��� ��ȯ�Ѵ�. --> ��ȯ�� *_jsp.java ���� �ҽ��� *_jsp.class �� ������ �ȴ�.
*_jsp.class ������ ���� �Ǿ ����� Ŭ���̾�Ʈ���� �����Ѵ�.
==========================================
WebContent -> cgiTest -> New -> Jsp File ���� testJsp.jsp ���� 
HTML �ڵ忡 ���� �߰� 
JSP �ڵ���� ���� �߰� 
XML �ڵ� �߰� 
������ ��Ŵ

testJsp.jsp ---> testJsp_jsp.java ����ȴ�. 
testJsp_jsp.java ---> testJsp_jsp.class ������ �ȴ�. 
testJsp_jsp.class Ŭ���� ������ ����ȴ�.

C:\00.KOSMO93\30.Web\el_web_neon _work\
.metadata\
.plugins\
org.eclipse.wst.server.core\ <-- �׻� ��⸦ ã�ƾ� �Ѵ�. 
tmp0\ <-- tmp1, tmp2  �� ����⵵ �Ѵ�. �� Ȯ���ϰ� ����ؾ� �Ѵ�. 
work\
Catalina\localhost\
testKosmo\
org\apache\jsp\
cgiTest <-- ���ؽ�Ʈ


