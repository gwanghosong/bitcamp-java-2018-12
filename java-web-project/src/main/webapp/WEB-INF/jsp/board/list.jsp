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
      <a href='form' class="btn btn-primary btn-sm">새 글</a>
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
          <c:forEach items="${list}" var="board">
            <tr>
              <th scope="row">${board.no}</th>
              <td><a href='${board.no}'>${board.contents}</a></td>
              <td>${board.createdDate}</td>
              <td data-toggle='popover' title="title">${board.viewCount}</td>
            </tr>
          </c:forEach>
        </tbody>
      </table>
      <a href="javascript:;" data-toggle='popover' title="title">hahaha</a>
    </div>
    <!-- .bit-list -->
    
    <div id="test">
        <select id="selectBox">
          <option>소속팀 선택</option>
      <c:forEach items="${list}" var="board">
          <option value="${board.no}">${board.viewCount}</option>
      </c:forEach>
        </select>
    </div>

    <nav aria-label="목록 페이지 이동">
      <ul class="pagination justify-content-center pager">
        <li class="page-item ${pageNo <= 1 ? 'disabled' : ' '}" id="previousPage"><a
          class="page-link" href="?pageNo=${pageNo - 1}&pageSize=${pageSize}">${pageNo - 1}</a></li>
        <li class="page-item active"><a class="page-link"
          href="?pageNo=${pageNo}&pageSize=${pageSize}">${pageNo}</a></li>
        <li class="page-item ${pageNo >= totalPage ? 'disabled' : ' '}"><a class="page-link"
          href="?pageNo=${pageNo + 1}&pageSize=${pageSize}">${pageNo + 1}</a></li>
      </ul>
    </nav>
  </div>
  <!-- .container -->

  <jsp:include page="../javascript.jsp" />
  
<script>

var abc = contentReturn();


var list = new Array(); 
<c:forEach items="${list}" var="board">
list.push("${board.no}");
</c:forEach>


$(function () {
  $('[data-toggle="popover"]').popover({
    html : true,
    trigger : 'click',
    container : 'body',
    content: String($('#test').html())
  }).on('shown.bs.popover', function(){
  });
  
})

function contentReturn() {
  var content = '';
  content = $('#test').html();
  str = String(content);
  console.log(content);
  console.log(str);
  return str;
}


</script>
</body>
</html>







