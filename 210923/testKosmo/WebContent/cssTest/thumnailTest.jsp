<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import="a.b.c.com.common.ImageFileEditUtil" %>
<%@ page import="a.b.c.com.common.CommonUtils" %>
<%@ page import="java.io.File" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
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
<img src="/testKosmo/fileupload/book/<%= thumbnailFile%>">
</body>
</html>