# π ν¨μ, Function
### β ν¨μ μμ±
- ν¨μ μ μΈλ¬Έ
```javascript
function f1() {
    console.log('f1');
}
```

<br>

- μ΅λͺ ν¨μ μ¬μ©
```javascript
 // μ΅λͺ ν¨μλ λ³΄ν΅ μμ±κ³Ό λμμ λ³μμ μ μ₯ν λ€ λμ€μ λ³μλ₯Ό ν΅ν΄μ νΈμΆνλ€.
let b2 = function () {
    console.log('a2');
};

b2();

// μ΄λ²€νΈ μ μ© ν¨μ μ¬μ©μ μμ μ± ν₯μ > μ΄λ²€νΈ ν¨μ μ μμ λμμ μ°κ²°
document.getElementById('btn').onmousedown = function() {
    alert(event.buttons);
}
```

<br>

### β ν¨μ νμ©
- ν¨μλ₯Ό **λ³μ**μ μ μ₯ν  μ μλ€.
```javascript
function f1() {
    console.log('f1');
}

n1 = f1; // ν¨μκ° μ μλ μ£Όμκ°μ λ³΅μ¬
n1(); // ν¨μ νΈμΆ
```

<br>

- ν¨μλ₯Ό **λ§€κ°λ³μ**μ μ λ¬ν  μ μλ€.
```javascript
function a4() {
    console.log('a4');
}

function a5(func) {
    console.log('a5');
    func();
}

// ν¨μμ λ§€κ°λ³μλ‘ ν¨μ μ λ¬
a5(a4);
```

<br>

- ν¨μλ₯Ό **λ°νκ°**μΌλ‘ μ¬μ©ν  μ μλ€.
```javascript
function a6() {
    console.log('a6');
}

function a7() {
    return a6; // ν¨μ μμ²΄λ₯Ό λ°νκ°μΌλ‘ μ¬μ©
}

a7()(); // == a6();
```

<br>

### β λ§€κ°λ³μ
- λ€λ₯Έ μΈμ΄μ λ¬λ¦¬ λ§€κ°λ³μμ κ°μκ° ν¨μ μ μ μ μ€μ ν λ§€κ°λ³μμ κ°μμ λ¬λΌλ μ€λ₯κ° λμ§ μλλ€.
> μμ
```javascript
function addNum(x, y, z) {
    return x + y + z;
}

addNum(1, 2, 3); // 6
addNum(1, 2);    // NaN
addNum(1);       // NaN
addNum();        // NaN
```

<br>

> μ€λ²λ‘λ© ννλ‘ ν¨μ κ΅¬ν
```javascript
function addNum(x, y, z) {

    if(x === undefined)
        x = 0;       

    if(y === undefined)
        y = 0;         

    if(z === undefined) 
        z = 0;          

    return x + y + z;
}

addNum(1, 2, 3); // 6
addNum(1, 2);    // 3
addNum(1);       // 1
addNum();        // 0
```

<br>

### β ν¨μ νΈμ΄μ€ν, Hoisting
- ν¨μ μμμ μ μΈλ **λͺ¨λ  λ³μλ ν¨μ μ μ²΄μ κ±Έμ³ μ ν¨**νλ€.
- λ³μκ° μ μΈλκΈ° μ μλ μ μ©λλ€.
- μ¦, λͺ¨λ  λ³μμ μ μΈμ ν¨μμ λ§¨ μ²μμμ ν κ² μ²λΌ λμνλ€.
> μμ
```javascript
var globalNum = 10; // μ μ­ λ³μ μ΄κΈ°ν

function printNum() {

    document.write("μ§μ­ λ³μ globalNum μ μΈ μ μ globalNumμ κ°μ " + globalNum + "μλλ€.<br>"); // undefined (μ μΈλ§)

    var globalNum = 20; // μ§μ­ λ³μ μ΄κΈ°ν

    document.write("μ§μ­ λ³μ globalNum μ μΈ νμ globalNumμ κ°μ " + globalNum + "μλλ€.<br>"); // 20
}

printNum();
```

<br>

### β λ―Έλ¦¬ μ μλ μ μ­ ν¨μ
- **eval()**
    - λ¬Έμμ΄λ‘ ννλ μλ°μ€ν¬λ¦½νΈ μ½λ μ€ν
```javascript
var x = 20;
var y = 30;
document.write(eval("x + y")); // 50
```
- **isFinite()**
    - μ λ¬λ κ°μ΄ μ νν μμΈμ§ κ²μ¬
    - λ¬Έμμ΄μΌ κ²½μ° μ«μλ‘ λ³νν΄μ κ²μ¬
```javascript
isFinite(123);        // true
isFinite("123");     // true
isFinite("");        // true
isFinite("λ¬Έμμ΄");  // false
```
- **isNaN()**
    - μ λ¬λ κ°μ΄ μ«μκ° μλμ§ κ²μ¬
```javascript
isNaN(123);       // false
isNaN("123");     // false
isNaN("");        // false
isNaN("λ¬Έμμ΄");  // true
```
- **encodeURI()**
    - URI μ λ¬ μ λ¬Έμ κ° μλλ‘ νΉμλ¬Έμμ λν΄ μ΄μ€μΌμ΄ν μ²λ¦¬νμ¬ μΈμ½λ©
```javascript
var uri = "http://google.com/search.php?name=νκΈΈλ&city=μμΈ";
var enc = encodeURI(uri);
```
- **decodeURI()**
    - encodeURI() ν¨μλ λ€λ₯Έ λ°©λ²μΌλ‘ λ§λ€μ΄μ§ URIλ₯Ό ν΄λ
```javascript
var uri = "http://google.com/search.php?name=νκΈΈλ&city=μμΈ";

var enc = encodeURI(uri);
var dec = decodeURI(enc);
document.write(dec);
```

<br>

### β νμ΄ν ν¨μ, Arrow Function
ν¨μ ννμλ³΄λ€ λ¨μνκ³  κ°κ²°ν λ¬Έλ²μΌλ‘ ν¨μλ₯Ό μμ±νλ λ°©μμ΄λ€.
```javascript
let func = function(arg1, arg2, ...argN) {
  return expression;
};
```

<br>

> λ³Έλ¬Έμ΄ μ¬λ¬ μ€μΈ νμ΄ν ν¨μ
```javascript
let sum = (a, b) => {  // μ€κ΄νΈλ λ³Έλ¬Έ μ¬λ¬ μ€λ‘ κ΅¬μ±λμ΄ μμμ λνλ
    let result = a + b;
    return result; // μ€κ΄νΈλ₯Ό μ¬μ©νλ€λ©΄ κ²°κ³Όκ° λ°ν νμ
};

alert(sum(1, 2));
```

<br>

> μ€νλ¬Έμ΄ νμ€μΌ λ μ€ν λΈλ­(μ€κ΄νΈ) μλ΅ κ°λ₯
```javascript
let f1 = () => console.log('f1'); // μ€κ΄νΈ μλ΅
f1();
```

<br>

> λ§€κ°λ³μ νλμΌ λλ κ΄νΈ μλ΅ κ°λ₯
```javascript
let f2 = num => console.log(num);
let f3 = (a, b) => console.log(a + b); // λ§€κ°λ³μ 2κ°μΌ λ μλ΅ λΆκ°
```

<br>

> λ°νκ° return λ¬Έ νμ€μΌ λλ κ΄νΈμ return ν€μλ μλ΅ κ°λ₯
```javascript
let f4 = () => {return 100;}; // returnλ¬Έ λͺμ
let f5 = () => 200; // returnλ¬Έ μλ΅
```