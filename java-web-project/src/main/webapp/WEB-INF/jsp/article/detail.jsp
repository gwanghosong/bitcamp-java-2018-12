<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
  trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>게시물 조회</title>
<jsp:include page="../commonCss.jsp" />
<link href="/java-web-project/node_modules/bootstrap/dist/css/bootstrap.css" rel="stylesheet">
<link href="/java-web-project/node_modules/summernote/dist/summernote.css" rel="stylesheet">
</head>
<body>

  <jsp:include page="../header.jsp" />

        <div id="summernote"></div>
        
        
        
<script src="/java-web-project/node_modules/jquery/dist/jquery.js"></script>
<script src="/java-web-project/node_modules/popper.js/dist/umd/popper.min.js"></script>
<script src="/java-web-project/node_modules/bootstrap/dist/js/bootstrap.js"></script>
<script src="/java-web-project/node_modules/handlebars/dist/handlebars.min.js"></script>
<script src="/java-web-project/node_modules/summernote/dist/summernote.js"></script>
<script src="/java-web-project/node_modules/summernote/dist/lang/summernote-ko-KR.js"></script>

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


