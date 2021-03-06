<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
  trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<title>새 수업</title>
<jsp:include page="../commonCss.jsp" />
</head>
<body>

  <jsp:include page="../header.jsp" />

  <h1>새 수업</h1>
  <form action='add' method='post'>
    <div class="form-group row">

      <label for="title" class="col-sm-2 col-form-label">수업제목</label>
      <div class="col-sm-10">
        <input type="text" class="form-control-plaintext" id="title" name="title"
          value="${lesson.title}">
      </div>
    </div>

    <div class="form-group row">
      <label for="contents" class="col-sm-2 col-form-label">내용</label>
      <div class="col-sm-8">
        <textarea class="form-control" id="contents" name='contents' rows='5'>${lesson.contents}</textarea>
      </div>
    </div>

    <div class="form-group row">
      <label for="startDate" class="col-sm-2 col-form-label">시작일</label>
      <div class="col-sm-10">
        <input type="date" class="form-control-plaintext" id="startDate" name='startDate'
          value='${lesson.startDate}'>
      </div>
    </div>

    <div class="form-group row">
      <label for="endDate" class="col-sm-2 col-form-label">종료일</label>
      <div class="col-sm-10">
        <input type="date" class="form-control-plaintext" id="endDate" name='endDate'
          value='${lesson.endDate}'>
      </div>
    </div>
    <div class="form-group row">
      <label for="totalHours" class="col-sm-2 col-form-label">총 교육시간</label>
      <div class="col-sm-10">
        <input type="number" class="form-control-plaintext" id="totalHours" name='totalHours'
          value='${lesson.totalHours}'>
      </div>
    </div>
    <div class="form-group row">
      <label for="dayHours" class="col-sm-2 col-form-label">일 교육시간</label>
      <div class="col-sm-10">
        <input type="number" class="form-control-plaintext" id="dayHours" name='dayHours'
          value='${lesson.dayHours}'>
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
