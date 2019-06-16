<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
  trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>회원 조회</title>
<jsp:include page="../commonCss.jsp" />
</head>
<body>

  <jsp:include page="../header.jsp" />

  <div class="container">
    <h1>회원 조회</h1>
    <c:choose>
      <c:when test="${empty member}">
        <p>해당하는 회원이 없습니다.</p>
      </c:when>
      <c:otherwise>
        <form action='update' method='post' enctype='multipart/form-data'>
          <div class="form-group row">
            <label for="no" class="col-sm-2 col-form-label">번호</label>
            <div class="col-sm-8">
              <input type="text" class="form-control-plaintext" id="no" name='no'
                value='${member.no}' readonly>
            </div>
          </div>
          <div class="form-group row">
            <label for="name" class="col-sm-2 col-form-label">이름</label>
            <div class="col-sm-8">
              <input type="text" class="form-control-plaintext" id="name" name='name'
                value='${member.name}'>
            </div>
          </div>
          <div class="form-group row">
            <label for="email" class="col-sm-2 col-form-label">이메일</label>
            <div class="col-sm-8">
              <input type="email" class="form-control-plaintext" id="email" name='email'
                value='${member.email}'>
            </div>
          </div>
          <div class="form-group row">
            <label for="password" class="col-sm-2 col-form-label">암호</label>
            <div class="col-sm-8">
              <input type="password" class="form-control-plaintext" id="password" name='password'>
            </div>
          </div>
          <div class="form-group row">
            <label for="photo" class="col-sm-2 col-form-label">사진</label>
            <div class="col-sm-8">
              <c:set var="contextRootPath" value="${pageContext.servletContext.contextPath}"></c:set>
              <c:if test="${empty member.photo}">
                <img src='${contextRootPath}/images/default.jpg' style='height: 80px'>
                <br>
              </c:if>
              <c:if test="${not empty member.photo}">
                <img src='${contextRootPath}/upload/member/${member.photo}' style='height: 80px'>
                <br>
              </c:if>
              <input type="file" class="form-control-file" id="photo" name='photo'
                value='${member.photo}'>
            </div>
          </div>
          <div class="form-group row">
            <label for="tel" class="col-sm-2 col-form-label">전화</label>
            <div class="col-sm-8">
              <input type="text" class="form-control-plaintext" id="tel" name='tel'
                value='${member.tel}'>
            </div>
          </div>
          <div class="form-group row">
            <label for="registeredDate" class="col-sm-2 col-form-label">가입일</label>
            <div class="col-sm-8">
              <input type="date" class="form-control-plaintext" id="registeredDate"
                value='${member.registeredDate}' readonly>
            </div>
          </div>
          <div class="form-group row">
            <div class="col-sm-8">
              <a class="btn btn-primary" href='.'>목록</a> <a class="btn btn-primary"
                href='delete/${member.no}'>삭제</a>
              <button class="btn btn-primary">변경</button>
            </div>
          </div>
        </form>
      </c:otherwise>
    </c:choose>
  </div>
  <!-- .container -->

  <jsp:include page="../javascript.jsp" />

</body>
</html>