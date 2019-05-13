<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>새 사진</title>
<jsp:include page="../commonCss.jsp" />
<link href="/java-web-project/node_modules/bootstrap/dist/css/bootstrap.css" rel="stylesheet">
<link href="/java-web-project/node_modules/summernote/dist/summernote.css" rel="stylesheet">
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
      <div class="col-sm-10">
        <button class="btn btn-primary">등록</button>
        <a class="btn btn-primary" href='.'>목록</a>
      </div>
    </div>
    <div id="form-group row">
      <textarea class="form-control" id="summernote" name="content" placeholder="content" maxlength="140" rows="5"></textarea>
    </div>
  </form>
<script src="/java-web-project/node_modules/jquery/dist/jquery.js"></script>
<script src="/java-web-project/node_modules/popper.js/dist/umd/popper.min.js"></script>
<script src="/java-web-project/node_modules/bootstrap/dist/js/bootstrap.js"></script>
<script src="/java-web-project/node_modules/handlebars/dist/handlebars.min.js"></script>
<script src="/java-web-project/node_modules/summernote/dist/summernote.js"></script>
<script src="/java-web-project/node_modules/summernote/dist/lang/summernote-ko-KR.js"></script>
<script>
// summernote 시작
$(document).ready(function() {
  $('#summernote').summernote({
    height: 300,
    minHeight: null,
    maxHeight: null,
    focus: true,
    callbacks: {
      onImageUpload: function(files, editor, welEditable) {
        for (var i = files.length - 1; i >= 0; i--) {
          sendFile(files[i], this);
        }
      }
    }
  });
});

function sendFile(file, el) {
  var form_data = new FormData();
  form_data.append('file', file);
  $.ajax({
    data: form_data,
    type: "POST",
    url: '/image',
    cache: false,
    contentType: false,
    enctype: 'multipart/form-data',
    processData: false,
    success: function(url) {
      $(el).summernote('editor.insertImage', url);
      $('#imageBoard > ul').append('<li><img src="'+url+'" width="480" height="auto"/></li>');
    }
  });
}

var markupStr = $('#summernote').summernote('code');

var contents = "contents";

$('#summernote').summernote('code', contents);
</script>
</body>
</html>