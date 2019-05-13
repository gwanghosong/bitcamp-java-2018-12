<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
  trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<title>test 등록</title>
<jsp:include page="../commonCss.jsp" />
<!-- include libraries(jQuery, bootstrap) -->
<link href="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.css" rel="stylesheet">
<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.4/jquery.js"></script>
<script src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script>
<!-- include summernote css/js-->
<link href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.2/summernote.css" rel="stylesheet">
<script src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.2/summernote.js"></script>
</head>
<body>

  <jsp:include page="../header.jsp" />

  <c:if test="${not empty message}">
    <div>
      <h2>${message}</h2>
    </div>
  </c:if>
  <div class="container">
    <div class="header clearfix">
      <nav>
        <ul class="nav nav-pills pull-right">
        </ul>
      </nav>
      <h3 class="text-muted">Summernote Image Upload Example</h3>
    </div>
    <div class="row marketing">
      <div class="col-lg-12">
        <div class="form-area">
          <form id="articleForm" role="form" action="/article" method="post">
            <br style="clear: both">
            <h3 style="margin-bottom: 25px;">Article Form</h3>
            <div class="form-group">
              <input type="text" class="form-control" id="subject" name="subject" placeholder="subject" required>
            </div>
            <div class="form-group">
              <textarea class="form-control" id="summernote" name="content" placeholder="content" maxlength="140" rows="7"></textarea>
            </div>
            <button type="submit" id="submit" name="submit" class="btn btn-primary pull-right">Submit Form</button>
          </form>
        </div>
      </div>
    </div>
  </div>

  <script>
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
      url: '/java-web-project/app/article/image',
      cache: false,
      contentType: false,
      enctype: 'multipart/form-data',
      processData: false,
      success: function(url) {
        $(el).summernote('editor.insertImage', url);
      }
    });
  }
  </script>
</body>
</html>
