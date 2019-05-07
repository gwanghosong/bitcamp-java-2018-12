"use strict"

var param =location.href.split('?')[1];
// if문에 undefined가 들어가면 자동으로 false 값이됨.
if (param) {
  document.querySelector('h1').innerHTML = "회원 조회"
  loadData(param.split('=')[1])
  var el = document.querySelectorAll('.bit-new-item');
  for (var e of el) {
    e.style.display = 'none';
  }
} else {
  document.querySelector('h1').innerHTML = "새 회원"
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
  xhr.open('POST', '../../app/json/member/add', true) // POST 방식일 때는 먼저 연결하고 헤더 설정한다.
  xhr.setRequestHeader('Content-Type', 'multipart/form-data');
  
  var name = document.querySelector('#name').value;
  var email = document.querySelector('#email').value;
  var password = document.querySelector('#password').value;
  var endDate = document.querySelector('#endDate').value;
  var photo = document.querySelector('#photo').value;
  var tel = document.querySelector('#tel').value;
  
  var qs = 
    'name=' + encodeURIComponent(name) + 
    '&email=' + encodeURIComponent(email) + 
    '&password=' + encodeURIComponent(password) +
    '&photo=' + encodeURIComponent(photo) +
    '&tel=' + encodeURIComponent(tel);
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
  xhr.open('GET', '../../app/json/member/delete?no=' + no, true)
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
  xhr.open('POST', '../../app/json/member/update', true) // POST 방식일 때는 먼저 연결하고 헤더 설정한다.
  xhr.setRequestHeader('Content-Type', 'multipart/form-data');
  
  var no = document.querySelector('#no').value;
  var name = document.querySelector('#name').value;
  var email = document.querySelector('#email').value;
  var password = document.querySelector('#password').value;
  var photo = document.querySelector('#photo').value;
  var tel = document.querySelector('#tel').value;
  
  var qs = 
    'no=' + no + 
    '&name=' + encodeURIComponent(name) + 
    '&email=' + encodeURIComponent(email) + 
    '&password=' + encodeURIComponent(password) +
    '&photo=' + encodeURIComponent(photo) +
    '&tel=' + encodeURIComponent(tel);

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
    document.querySelector('#name').value = data.name;
    document.querySelector('#email').value = data.email;
    document.querySelector('#password').value = data.password;
    document.querySelector('#tel').value = data.tel;
    document.querySelector('#registeredDate').value = data.registeredDate;
    console.log(data.photo);
    if (data.photo) {
     document.querySelector('#member-view-img').src = '../../upload/member/' + data.photo;      
    } else { // data.photo가 없다면
     document.querySelector('#member-view-img').src = '../../images/default.jpg'; 
    }
  };
 xhr.open('GET', '../../app/json/member/detail?no=' + no, true)
 xhr.send()
}