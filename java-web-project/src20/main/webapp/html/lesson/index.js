"use strict"
var pageNo = 1,
      pageSize = 3,
      tbody = document.querySelector('tbody'),
      prevPageLi = document.querySelector('#prevPage'),
      nextPageLi = document.querySelector('#nextPage'),
      currSpan = document.querySelector('#currPage > span');

//JSON 형식의 데이터 목록 가져오기
function loadList(pn) {
  var xhr = new XMLHttpRequest()
  xhr.onreadystatechange = function() {
    if (xhr.readyState != 4 || xhr.status != 200)
      return;
    
    // 서버에서 받은 JSON 형식의 데이터를 ==> JavaScript 객체로 변환
    var obj = JSON.parse(xhr.responseText);
    
    // 서버에서 받은 데이터 중에서 페이지 번호를 글로벌 변수에 저장한다.
    pageNo = obj.pageNo;
    
    // TR 태그를 생성하여 테이블 데이터를 갱신한다.
    tbody.innerHTML = ''; // 이전에 출력한 내용을 제거한다.
    for (var data of obj.list) {  
      var tr = '<tr>'
      + '<th scope="row">' + data.no + '</th>'
      // 모바일쪽에서 이 코드가 잘 안먹힘. 데이터가 갱신이 잘안되서 예전 데이터가 오는 경우가있음.
      //+ '<td><a href="view.html?no=' + data.no +'">' + data.contents + '</a></td>'
      // 반복되서 만들어지는 부분들에 id를 만들면 id가 반복되기때문에 오류가 발생한다. class를 쓰자.
      + '<td><a class="bit-view-link" href="#" data-no="' + data.no +'">' + data.title + '</a></td>'
      + '<td>' + data.startDate + ' ~ ' + data.endDate + '</td>'
      + '<td>' + data.totalHours + '</td>'
      + '</tr>';
      tbody.innerHTML = tbody.innerHTML + tr;
    }
    
    // 현재 페이지의 번호를 갱신한다.
    currSpan.innerHTML = String(pageNo);
    
    // 1페이지일 경우 버튼을 비활성화시킨다.
    if (pageNo == 1){
      prevPageLi.className = prevPage.className + ' disabled';
    } else {
      prevPageLi.className = prevPage.className.replace(' disabled', '');
    }
    
    if (pageNo == obj.totalPage) {
      nextPageLi.className = nextPage.className + ' disabled';
    } else {
      nextPageLi.className = nextPage.className.replace(' disabled', '');
    }
    
    // 데이터 로딩이 완료된 후, a 태그에 click 리스너를 등록하기 - 동기방식
    //registerClickListener();
    
    // 데이터 로딩이 완료되면 body 태그에 이벤트를 전송한다. - 비동기방식
    document.body.dispatchEvent(new Event('loaded-list'));
      
  };
  xhr.open('GET', 
      '../../app/json/lesson/list?pageNo=' + pn + '&pageSize=' + pageSize, 
      true)
  xhr.send()
} // loadList()

document.querySelector('#prevPage > a').onclick = (e) => {
  e.preventDefault();
  loadList(pageNo - 1);
};

document.querySelector('#nextPage > a').onclick = (e) => {
  e.preventDefault();
  loadList(pageNo + 1);
};


loadList(1);

//테이블 목록 가져오기를 완료했으면 제목 a 태그에 클릭 리스너를 등록한다. - 비동기방식
document.body.addEventListener('loaded-list', () => {
//제목을 클릭했을 때 view.html로 전환시키기
var alist = document.querySelectorAll('.bit-view-link');
  for (var a of alist) {
    a.onclick = (e) => {
      e.preventDefault();
      window.location.href = 'view.html?no=' + e.target.getAttribute('data-no');
    };
  }
});