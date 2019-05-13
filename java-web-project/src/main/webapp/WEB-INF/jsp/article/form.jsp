<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
  trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<title>test 등록</title>
<jsp:include page="../commonCss.jsp" />
</head>
<body>

  <jsp:include page="../header.jsp" />

  <h1>test</h1>
  <form action='add' method='post'>
  <div class="form-group row">
      <label for="subject" class="col-sm-2 col-form-label">제목</label>
      <div class="col-sm-8">
        <input class="form-control" id="subject" name='subject'></input>
      </div>
    </div>
    <div class="form-group row">
      <label for="content" class="col-sm-2 col-form-label">내용</label>
      <div class="col-sm-8">
        <textarea class="form-control" id="content" name='content' rows='5'></textarea>
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
