# π AJAX, Asynchronous JavaScript And XML
- λΉλκΈ° μλ°μ€ν¬λ¦½νΈμ XML
- μλ²μ ν΅μ νκΈ° μν΄ XMLHttpRequest κ°μ²΄λ₯Ό μ¬μ©
- JSON, XML, HTML, μΌλ° νμ€νΈ νμ λ± λ€μν ν¬λ§·μ μ£Όκ³  λ°μ μ μμ
- νμ΄μ§ μ μ²΄λ₯Ό λ¦¬νλ μ¬ νμ§ μκ³ μλ μνλλ **λΉλκΈ°μ±**μ΄ κ°μ₯ ν° νΉμ§ β­
- μ μ²΄ νμ΄μ§κ° μλ μΌλΆλΆλ§ μλ°μ΄νΈ κ°λ₯

<br>

### β μ£Όμ νΉμ§
- νμ΄μ§ μλ‘κ³ μΉ¨ μμ΄ μλ²μ μμ²­
- μλ²λ‘λΆν° λ°μ΄ν°λ₯Ό λ°κ³  μμ μν

<br>

### β vanila JSλ₯Ό μ¬μ©ν Ajax μμ 
```javascript
// Javascriptμμ μλ²λ‘ μ μ‘ν  HTTP Requestλ₯Ό μμ±νκΈ° μν κ°μ²΄
let httpRequest = new XMLHttpRequest();

// μλ²λ‘λΆν° μλ΅μ λ°μμ λ λμ μ μ
httpRequest.onreadystatechange = function() {
    // μ§μ ν HTTP λ©μλμ κ²½λ‘λ‘ μλ²μ μμ²­
    httpRequest.open('GET', '/toy/ajax/ex02data2.do');
    ajax.send(); // λ§€κ°λ³μμ key=value ννλ‘ μλ ₯νλ©΄ POST λ°©μμΌλ‘ μ λ¬
}

if (httpRequest.readyState == 4 && httpRequest.status == 200) {
        // μλ΅μ μ±κ³΅μ μΌλ‘ λ°μ
        alert(httpRequest.responseText); // μ λ¬λ°μ λ°μ΄ν°
    } else {
        // μλ΅μ λ°μ§ λͺ»ν¨
        alert('requestμ λ¬Έμ  λ°μ');
    }
```

<br>

### β jQueryλ₯Ό μ¬μ©ν Ajax μμ 
```javascript
$.ajax({
    url: "/rest/1/pages/245", // ν΄λΌμ΄μΈνΈκ° HTTP μμ²­μ λ³΄λΌ μλ²μ URL μ£Όμ
    data: { name: "νκΈΈλ" },  // HTTP μμ²­κ³Ό ν¨κ» μλ²λ‘ λ³΄λΌ λ°μ΄ν°
    method: "GET",   // HTTP μμ²­ λ©μλ(GET, POST λ±)
    dataType: "json" // μλ²μμ λ³΄λ΄μ€ λ°μ΄ν°μ νμ
})
// HTTP μμ²­μ΄ μ±κ³΅νλ©΄ μμ²­ν λ°μ΄ν°κ° done() λ©μλλ‘ μ λ¬λ¨.
.done(function(json) {
    $("<h1>").text(json.title).appendTo("body");
    $("<div class=\"content\">").html(json.html).appendTo("body");
})
// HTTP μμ²­μ΄ μ€ν¨νλ©΄ μ€λ₯μ μνμ κ΄ν μ λ³΄κ° fail() λ©μλλ‘ μ λ¬λ¨.
.fail(function(xhr, status, errorThrown) {
    $("#text").html("μ€λ₯κ° λ°μνλ€.<br>")
    .append("μ€λ₯λͺ: " + errorThrown + "<br>")
    .append("μν: " + status);
})
// 
.always(function(xhr, status) {
    $("#text").html("μμ²­μ΄ μλ£λμμ΅λλ€!");
});
```