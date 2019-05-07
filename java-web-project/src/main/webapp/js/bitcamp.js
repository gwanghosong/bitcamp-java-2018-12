var Bitcamp = {}; // new Object();

/*
jQuery 사용 이유:
 
1) 크로스브라우징을 대신 처리해 주기 때문에 코드를 간략하게 처리 가능.
    jQuery를 사용하지 않는다면 
    브라우저마다 자바스크립트 지원이 다르기때문에 코드를 다르게 만들고 호출해야 한다.
    ex) AJAX iex9이하 XMLHttpRequest 지원 X
    따라서 이렇게 지원하지 않을 경우 개발자가 각각 브라우저마다 일일이 다 코딩해야 한다.
    jQuery는 이렇게 브라우저마다 코딩해야할 코드를 함수를 정의하면서 미리 처리해둔다.
    jQuery를 사용하면 크로스 브라우징을 AJAX 함수안에 이미 구현해놓았기 때문에,
    jQuery를 사용하면 간결하게 표현 가능하다.
    이렇게 해 놓으면 일관된 방법으로 코드를 사용할 수 있다.
    jQuery는 크로스 브라우징 처리를 기본적으로 수행할 수 있는 라이브러리다.

2) javaScript코드를 그냥 순수하게 사용하는 것보다 
    DOM API, 이벤트처리하는 코드같은 부분을 간략하게 함수로 묶어 만들어줘서
    코드를 조금 더 간략하게 사용할 수 있다.
*/
Bitcamp.ajax =  function(url, settings) {
  // XMLHttpRequest 객체를 사용하여 AJAX 요청하는 코드를 사용하기 쉽도록 캡슐화시킨다.
  
  // => 파라미터 값으로 settings 객체가 넘어오지 않는다면 빈 객체를 만든다.
  if (settings == undefined || settings == null) {
    settings = {};
  }
  
  // => settings 객체에 method 프로퍼티가 정의되지 않았다면 기본 값 'GET'으로 설정한다.
  if (!settings.method) {
    settings.method = 'GET';
  }
  
  // => 서버가 보낸 데이터의 형식을 알려주지 않으면 기본으로 일반 텍스트로 설정한다.
  if (!settings.dataType) {
    settings.dataType = 'text';
  }
  
  var xhr = new XMLHttpRequest()
  xhr.onreadystatechange = function() {
    if (xhr.readyState != 4 )
      return;
      
    if (xhr.status != 200) {
      // 서버에서 오류가 발생했다면 error() 함수를 호출한다.
      // => 단 error라는 함수가 있을 때만 호출한다.
      if (settings.error) {
        settings.error();
      }
      return;
    }
    
    // 서버로부터 정상적으로 응답을 받았다면 success 함수를 호출한다.
    // => success라는 이름의 함수가 settings에 있을 때만 호출한다.
    if (settings.success) {
      if (settings.dataType == 'json') {
        settings.success(JSON.parse(xhr.responseText));
      } else {        
        settings.success(xhr.responseText);
      }
    }
    };
  xhr.open(settings.method , url, true)
  xhr.send()
};

Bitcamp.getJSON = function(url, success) {
  Bitcamp.ajax(url, {
    "dataType": 'json',
    "success":  success
  });
};

var $ = Bitcamp;



