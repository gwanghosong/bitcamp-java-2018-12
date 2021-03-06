<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
  trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<title>수업 조회</title>
</head>
<body>

  <jsp:include page="/header.jsp" />

  <h1>수업 상세 조회(JSP2)</h1>
<jsp:useBean scope="request" id="lesson" type="com.eomcs.lms.domain.Lesson"/>
  <%
    if (lesson == null) {
  %>
  <p>해당 번호의 수업이 없습니다.</p>
  <%
    } else {
  %>
  <form action='update' method='post'>
    <table border='1'>
      <tr>
        <th>번호</th>
        <td><input type='number' name='no' value='${lesson.no}' readonly></td>
      </tr>
      <tr>
        <th>수업</th>
        <td><input type='text' name='title' value='${lesson.title}'></td>
      </tr>
      <tr>
        <th>설명</th>
        <td><textarea name='contents' rows='3' cols='50'>${lesson.contents}
</textarea></td>
      </tr>
      <tr>
        <th>시작일</th>
        <td><input type='date' name='startDate' value='${lesson.startDate}'></td>
      </tr>
      <tr>
        <th>종료일</th>
        <td><input type='date' name='endDate' value='${lesson.endDate}'></td>
      </tr>
      <tr>
        <th>총수업시간</th>
        <td><input type='number' name='totalHours' value='${lesson.totalHours}'></td>
      </tr>
      <tr>
        <th>일수업시간</th>
        <td><input type='number' name='dayHours' value='${lesson.dayHours}'></td>
      </tr>
    </table>
    <p>
      <a href='list'>목록</a> <a href='delete?no=${lesson.no}'>삭제</a>
      <button type='submit'>변경</button>
    </p>
  </form>
  <%}%>
</body>
</html>
