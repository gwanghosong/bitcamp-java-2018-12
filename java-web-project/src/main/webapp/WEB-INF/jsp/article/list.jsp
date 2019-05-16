<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
  trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>게시물 목록</title>
<jsp:include page="../commonCss.jsp" />
</head>
<body>

  <jsp:include page="../header.jsp" />

  <div class="container">
    <h1>게시물 목록</h1>
    <p>
      <a href='article/form' class="btn btn-primary btn-sm">새 글</a>
    </p>

    <div class="bit-list">
      <table class="table table-hover">
        <thead>
          <tr>
            <th scope="col">번호</th>
            <th scope="col">제목</th>
            <th scope="col">등록일</th>
            <th scope="col">조회수</th>
          </tr>
        </thead>
        <tbody>
          <c:forEach items="${list}" var="article">
            <tr>
              <th scope="row">${article.id}</th>
              <td><a href='article/${article.id}'>${article.subject}</a></td>
              <td>${article.regDate}</td>
              <td>${article.updDate}</td>
            </tr>
          </c:forEach>
        </tbody>
      </table>
    </div>
    <!-- .bit-list -->
  </div>
  <!-- .container -->

  <jsp:include page="../javascript.jsp" />
</body>
</html>







