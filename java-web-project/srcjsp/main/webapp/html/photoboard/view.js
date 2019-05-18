"use strict"

var param =location.href.split('?')[1];
// if문에 undefined가 들어가면 자동으로 false 값이됨.
if (param) {
  document.querySelector('h1').innerHTML = "사진 조회"
  loadData(param.split('=')[1])
  var el = document.querySelectorAll('.bit-new-item');
  for (var e of el) {
    e.style.display = 'none';
  }
} else {
  document.querySelector('h1').innerHTML = "새 사진"
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
  xhr.open('POST', '../../app/json/photoboard/add', true) // POST 방식일 때는 먼저 연결하고 헤더 설정한다.
  xhr.setRequestHeader('Content-Type', 'multipart/form-data');
  
  var title = document.querySelector('#title').value;
  var lessonNo = document.querySelector('#lessonNo').value;
  var photoFile = document.querySelector('#photoFile').value;
  
  var qs = 
    'title=' + encodeURIComponent(title) + 
    '&lessonNo=' + encodeURIComponent(photolessonNo) +
    '&photoFile=' + encodeURIComponent(photoFile) +

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
  xhr.open('GET', '../../app/json/photoboard/delete?no=' + no, true)
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
  xhr.open('POST', '../../app/json/photoboard/update', true) // POST 방식일 때는 먼저 연결하고 헤더 설정한다.
  xhr.setRequestHeader('Content-Type', 'multipart/form-data');
  
  var no = document.querySelector('#no').value;
  var title = document.querySelector('#title').value;
  var lessonNo = document.querySelector('#lessonNo').value;
  var photoFile = document.querySelector('#photoFile').value;
  
  var qs = 
    'no=' + no + 
    '&title=' + encodeURIComponent(title) + 
    '&lessonNo=' + encodeURIComponent(photolessonNo) +
    '&photoFile=' + encodeURIComponent(photoFile) +

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
    document.querySelector('#createdDate').value = data.createdDate;
    document.querySelector('#viewCount').value = data.viewCount;
    document.querySelector('#lessonNo').value = data.lessonNo;
    document.querySelector('#photoFile').value = data.photoFile;
  };
 xhr.open('GET', '../../app/json/photoboard/detail?no=' + no, true)
 xhr.send()
}