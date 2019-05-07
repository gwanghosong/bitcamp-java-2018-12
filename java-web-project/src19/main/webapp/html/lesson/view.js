"use strict"

var param =location.href.split('?')[1];
// if문에 undefined가 들어가면 자동으로 false 값이됨.
if (param) {
  document.querySelector('h1').innerHTML = "수업 조회"
  loadData(param.split('=')[1])
  var el = document.querySelectorAll('.bit-new-item');
  for (var e of el) {
    e.style.display = 'none';
  }
} else {
  document.querySelector('h1').innerHTML = "새 수업"
  var el = document.querySelectorAll('.bit-view-item');
  for (var e of el) {
    e.style.display = 'none';
  }
}

document.querySelector('#add-btn').onclick = () => {
  var xhr = new XMLHttpRequest()
  xhr.onreadystatechange = function() {
    if (xhr.readyState != 4 || xhr.status != 200)
      return;
    
    var data = JSON.parse(xhr.responseText);
    if (data.status == 'success') {
      location.href = 'index.html'
    } else {
      alert('등록 실패입니다!\n' + data.message)
    }
  };
  xhr.open('POST', '../../app/json/lesson/add', true) // POST 방식일 때는 먼저 연결하고 헤더 설정한다.
  xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
  
  var title = document.querySelector('#title').value;
  var contents = document.querySelector('#contents').value;
  var startDate = document.querySelector('#startDate').value;
  var endDate = document.querySelector('#endDate').value;
  var totalHours = document.querySelector('#totalHours').value;
  var dayHours = document.querySelector('#dayHours').value;
  
  var qs = 
    'title=' + encodeURIComponent(title) + 
    '&contents=' + encodeURIComponent(contents) + 
    '&startDate=' + encodeURIComponent(startDate) +
    '&endDate=' + encodeURIComponent(endDate) +
    '&totalHours=' + totalHours +
    '&dayHours=' + dayHours;
  xhr.send(qs);
};

document.querySelector('#delete-btn').onclick = () => {
  var xhr = new XMLHttpRequest()
  xhr.onreadystatechange = function() {
    if (xhr.readyState != 4 || xhr.status != 200)
      return;
    
    var data = JSON.parse(xhr.responseText);
    if (data.status == 'success') {
      location.href = 'index.html'
        
    } else {
      alert('삭제 실패입니다!\n' + data.message)
    }
  };
  var no = document.querySelector('#no').value;
  xhr.open('GET', '../../app/json/lesson/delete?no=' + no, true)
  xhr.send();
};

document.querySelector('#update-btn').onclick = () => {
  var xhr = new XMLHttpRequest()
  xhr.onreadystatechange = function() {
    if (xhr.readyState != 4 || xhr.status != 200)
      return;
    
    var data = JSON.parse(xhr.responseText);
    if (data.status == 'success') {
      location.href = 'index.html'
    } else {
      alert('변경 실패입니다!\n' + data.message);
    }
  };
  xhr.open('POST', '../../app/json/lesson/update', true) // POST 방식일 때는 먼저 연결하고 헤더 설정한다.
  xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
  
  var no = document.querySelector('#no').value;
  var title = document.querySelector('#title').value;
  var contents = document.querySelector('#contents').value;
  var startDate = document.querySelector('#startDate').value;
  var endDate = document.querySelector('#endDate').value;
  var totalHours = document.querySelector('#totalHours').value;
  var dayHours = document.querySelector('#dayHours').value;
  
  var qs = 
    'no=' + no + 
    '&title=' + encodeURIComponent(title) + 
    '&contents=' + encodeURIComponent(contents) + 
    '&startDate=' + encodeURIComponent(startDate) +
    '&endDate=' + encodeURIComponent(endDate) +
    '&totalHours=' + totalHours +
    '&dayHours=' + dayHours;
  xhr.send(qs);
};

function loadData(no) {
  var xhr = new XMLHttpRequest()
  xhr.onreadystatechange = function() {
    if (xhr.readyState != 4 || xhr.status != 200)
      return;
    
    var data = JSON.parse(xhr.responseText);
    console.log(data);
    document.querySelector('#no').value = data.no;
    document.querySelector('#title').value = data.title;
    document.querySelector('#contents').value = data.contents;
    document.querySelector('#startDate').value = data.startDate;
    document.querySelector('#endDate').value = data.endDate;
    document.querySelector('#totalHours').value = data.totalHours;
    document.querySelector('#dayHours').value = data.dayHours;
  };
 xhr.open('GET', '../../app/json/lesson/detail?no=' + no, true)
 xhr.send()
}