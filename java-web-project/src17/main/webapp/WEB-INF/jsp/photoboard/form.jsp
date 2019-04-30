<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>새 사진</title>
<link rel="stylesheet"
  href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
  integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
  crossorigin="anonymous">
<link rel="stylesheet" href="${contextRootPath}/css/common.css">
</head>
<body>

  <jsp:include page="../header.jsp" />
  <h1>새 사진</h1>
  <form action='add' method='post' enctype='multipart/form-data'>

    <div class="form-group row">
      <label for="lessonNo" class="col-sm-2 col-form-label">수업</label>
      <div class="col-sm-4">
        <select class="custom-select" name='lessonNo'>
          <option selected>수업을 선택하세요</option>
          <c:forEach items="${lessons}" var="lesson">
            <option value="${lesson.no}" ${board.lessonNo == lesson.no ? "selected" : ""}>${lesson.title}(${lesson.startDate}
              ~ ${lesson.endDate})</option>
          </c:forEach>
        </select>
      </div>
    </div>
    <div class="form-group row">
      <label for="title" class="col-sm-2 col-form-label">사진 제목</label>
      <div class="col-sm-10">
        <input type="text" class="form-control-plaintext" id="title" name='title'>
      </div>
    </div>

    <div class="form-group row">
      <label for="description" class="col-sm-2 col-form-label">사진 최소 한 개의 사진 파일을 등록해야 합니다.</label>
    </div>

    <div class="form-group row">
      <label for="photo" class="col-sm-2 col-form-label">사진1</label>
      <div class="col-sm-10">
        <input type="file" class="form-control-file" id="photo" name='photo'>
      </div>
    </div>
    <div class="form-group row">
      <label for="photo" class="col-sm-2 col-form-label">사진2</label>
      <div class="col-sm-10">
        <input type="file" class="form-control-file" id="photo" name='photo'>
      </div>
    </div>
    <div class="form-group row">
      <label for="photo" class="col-sm-2 col-form-label">사진3</label>
      <div class="col-sm-10">
        <input type="file" class="form-control-file" id="photo" name='photo'>
      </div>
    </div>
    <div class="form-group row">
      <label for="photo" class="col-sm-2 col-form-label">사진4</label>
      <div class="col-sm-10">
        <input type="file" class="form-control-file" id="photo" name='photo'>
      </div>
    </div>
    <div class="form-group row">
      <label for="photo" class="col-sm-2 col-form-label">사진5</label>
      <div class="col-sm-10">
        <input type="file" class="form-control-file" id="photo" name='photo'>
      </div>
    </div>
    <div class="form-group row">
      <div class="col-sm-10">
        <button class="btn btn-primary">등록</button>
        <a class="btn btn-primary" href='.'>목록</a>
      </div>
    </div>
  </form>
  <jsp:include page="../javascript.jsp" />
</body>
</html>