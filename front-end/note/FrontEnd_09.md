# 📌 AJAX, Asynchronous JavaScript And XML
- 비동기 자바스크립트와 XML
- 서버와 통신하기 위해 XMLHttpRequest 객체를 사용
- JSON, XML, HTML, 일반 텍스트 형식 등 다양한 포맷을 주고 받을 수 있음
- 페이지 전체를 리프레쉬 하지 않고서도 수행되는 **비동기성**이 가장 큰 특징 ⭐
- 전체 페이지가 아닌 일부분만 업데이트 가능

<br>

### ✅ 주요 특징
- 페이지 새로고침 없이 서버에 요청
- 서버로부터 데이터를 받고 작업 수행

<br>

### ✅ vanila JS를 사용한 Ajax 예제
```javascript
// Javascript에서 서버로 전송할 HTTP Request를 생성하기 위한 객체
let httpRequest = new XMLHttpRequest();

// 서버로부터 응답을 받았을 때 동작 정의
httpRequest.onreadystatechange = function() {
    // 지정한 HTTP 메서드와 경로로 서버에 요청
    httpRequest.open('GET', '/toy/ajax/ex02data2.do');
    ajax.send(); // 매개변수에 key=value 형태로 입력하면 POST 방식으로 전달
}

if (httpRequest.readyState == 4 && httpRequest.status == 200) {
        // 응답을 성공적으로 받음
        alert(httpRequest.responseText); // 전달받은 데이터
    } else {
        // 응답을 받지 못함
        alert('request에 문제 발생');
    }
```

<br>

### ✅ jQuery를 사용한 Ajax 예제
```javascript
$.ajax({
    url: "/rest/1/pages/245", // 클라이언트가 HTTP 요청을 보낼 서버의 URL 주소
    data: { name: "홍길동" },  // HTTP 요청과 함께 서버로 보낼 데이터
    method: "GET",   // HTTP 요청 메소드(GET, POST 등)
    dataType: "json" // 서버에서 보내줄 데이터의 타입
})
// HTTP 요청이 성공하면 요청한 데이터가 done() 메소드로 전달됨.
.done(function(json) {
    $("<h1>").text(json.title).appendTo("body");
    $("<div class=\"content\">").html(json.html).appendTo("body");
})
// HTTP 요청이 실패하면 오류와 상태에 관한 정보가 fail() 메소드로 전달됨.
.fail(function(xhr, status, errorThrown) {
    $("#text").html("오류가 발생했다.<br>")
    .append("오류명: " + errorThrown + "<br>")
    .append("상태: " + status);
})
// 
.always(function(xhr, status) {
    $("#text").html("요청이 완료되었습니다!");
});
```