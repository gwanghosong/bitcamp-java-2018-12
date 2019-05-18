"use strict"
var pageNo = 1,
      pageSize = 3,
      tbody = $('tbody'),
      prevPageLi = $('#prevPage'),
      nextPageLi = $('#nextPage'),
      currSpan = $('#currPage > span'),
      templateSrc = $('#tr-template').html(),  // script 태그에서 템플릿 데이터를 꺼낸다.

// Handlebars를 통하여 템플릿 데이터를 가지고 최종 결과를 생성할 함수를 준비한다.
var trGenerator = Handlebars.compile(templateSrc);
      
// JSON 형식의 데이터 목록 가져오기
function loadList(pn) {
  
  $.getJSON('../../app/json/board/list?pageNo=' + pn + '&pageSize=' + pageSize, 
     function(obj) {
      
      // 서버에서 받은 데이터 중에서 페이지 번호를 글로벌 변수에 저장한다.
      pageNo = obj.pageNo;
      
      // TR 태그를 생성하여 테이블 데이터를 갱신한다.
      tbody.html(''); // 이전에 출력한 내용을 제거한다.
      
      $(trGenerator(obj)).appendTo(tbody);
      /*
      for (var data of obj.list) {
        $(trGenerator(data)).appendTo(tbody);
      }
      */
      
      // 현재 페이지의 번호를 갱신한다.
      currSpan.html(String(pageNo));
      
      // 1페이지일 경우 버튼을 비활성화시킨다.
      if (pageNo == 1){
        prevPageLi.addClass('disabled');
      } else {
        prevPageLi.removeClass('disabled');
      }
      
      if (pageNo == obj.totalPage) {
        nextPageLi.addClass('disabled'); // jQuery에 값을 설정할 때마다 return this. 즉 계속 this객체를 리턴하기 때문에 .xxx.xxx.xxx가 가능해진다.);
      } else {
        nextPageLi.removeClass('disabled');
      }
      
      // 데이터 로딩이 완료된 후, a 태그에 click 리스너를 등록하기 - 동기방식
      //registerClickListener();
      
      // 데이터 로딩이 완료되면 body 태그에 이벤트를 전송한다. - 비동기방식
      $(document.body).trigger('loaded-list');
      
    }); // Bitcamp.getJSON()
  
} // loadList()

$('#prevPage > a').click((e) => {
  e.preventDefault();
  loadList(pageNo - 1);
});

$('#nextPage > a').click((e) => {
  e.preventDefault();
  loadList(pageNo + 1);
});

//페이지를 출력한 후 1페이지 목록을 로딩한다.
loadList(1);

/*
// 테이블 목록 가져오기를 완료했으면 제목 a 태그에 클릭 리스너를 등록한다. - 동기방식
function registerClickListener() {
//제목을 클릭했을 때 view.html로 전환시키기
var alist = document.querySelectorAll('.bit-view-link');
  for (a of alist) {
    a.onclick = (e) => {
      e.preventDefault();
      console.log(e.target.getAttribute('data-no'));      
    };
  }
}
*/

//테이블 목록 가져오기를 완료했으면 제목 a 태그에 클릭 리스너를 등록한다. - 비동기방식
$(document.body).bind('loaded-list', () => {
//제목을 클릭했을 때 view.html로 전환시키기
  $('.bit-view-link').click((e) => {
  e.preventDefault();
  window.location.href = 'view.html?no=' + $(e.target).attr('data-no'); // jQuery.함수를 호출할 때는 jQuery객체여야 그 함수를 담아 리턴하기 때문에 포장해준다.
  });
});
