<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
  trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<title>실행 오류(JSTL)</title>
<meta http-equiv="Refresh" content="2;url=${header.Referer}">
</head>
<body>
<%
out.flush();
request.getRequestDispatcher("/header").include(request, response);
%>
  <h1>${requestScope["error.title"]}</h1>
  <p>${requestScope["error.content"]}%>
</body>
</html>
