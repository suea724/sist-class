# π λ³μμ μμ
### β λ³μ μ μΈ ν€μλ
- **let**
    - λ³μ μ μΈ ν€μλ.
    - κ°μ μ΄λ¦μ λ³μλ νλ²λ§ μ μΈ κ°λ₯. μ¬λ¬ λ² μ μΈ μ μλ¬ λ°μ
    - λΈλ‘ λ λ²¨ μ€μ½νκ° μ μ©λ¨
    - λΈλ‘ λ°μμ λ³μ μ¬μ© λΆκ°
- **const** 
    - μμ μ μΈ ν€μλ.
    - κ°μ λ³κ²½ν  μ μμ
- **var**
    - μ€λλ λ³μ μ μΈ ν€μλ.
    - λ³μ μ μΈ ν€μλ μλ΅ μ κΈ°λ³Έμ μΌλ‘ varλ‘ μ μΈλλ€.
    - κ°μ μ΄λ¦μ λ³μλ₯Ό μ¬λ¬λ² μ μΈν΄λ μλ¬κ° λ°μνμ§ μμ
    - ν¨μ λ λ²¨ μ€μ½νκ° μ μ©λ¨
    - λΈλ‘ λ°μμ λ³μ μ¬μ© κ°λ₯

<br>

### β letκ³Ό varμ μ°¨μ΄
λ³μλ ν¬κ² `μ μΈ -> μ΄κΈ°ν -> ν λΉ`μ λ¨κ³λ₯Ό κ°μ§λ€.

![](https://noah0316.github.io/static/9edccb0975ba87abf535462e3b31c02d/3c492/var.png)
- varλ‘ μ μΈλ λ³μλ **μ μΈκ³Ό μ΄κΈ°νκ° λμ**μ μ§νλλ€.
- μ μΈ μ ν λΉνμ§ μμμ λ var λ³μμ μ΄κΈ°κ°μ **undefined**

<br>

![](https://noah0316.github.io/static/0d6208436219e3b022a6c152572d803c/3c492/let.png)
- letμΌλ‘ μ μΈλ λ³μλ **μ μΈκ³Ό μ΄κΈ°νκ° λΆλ¦¬**λμ΄  κ·Έ μ¬μ΄μ TDZκ° μμ±λλ€.
- μ΄λ λ³μμ μ κ·Ό μ ReferenceErrorκ° λ°μνλ€.

<br>

> λ³μ μ¬μ μΈ
```javascript
let message = "This";
let message = "That"; // SyntaxError: 'message' has already been declared

var user = "Pete";
var user = "John"; // μ¬μ μΈ νμ§ μμ, ν λΉλ¬Έλ§ μ€νλ¨

alert(user); // John
```

<br>

> μ€μ½ν
```javascript
if (true) {
  var test = true; // var
}

alert(test); // true(if λ¬Έμ΄ λλ¬μ΄λ λ³μμ μ¬μ ν μ κ·Όν  μ μμ)

// let
if (true) {
  let test = true; // let
}

alert(test); // Error: test is not defined
```



<br>

# π μλ°μ€ν¬λ¦½νΈ νμ
|μ’λ₯|μ€λͺ|
|:-:|-|
|μ«μν|μ μ λ° μ€μ νν, Infinity, NaNκ³Ό κ°μ νΉμ μ«μ κ° ν¬ν¨|
|BigInt|μΌλ° μ«μνμ ννν  μ μλ μμ μ μ½μ΄ μλ λ°λ©΄, κΈΈμ΄μ μκ΄μμ΄ μ μλ₯Ό λνλΌ μ μμ|
|λ¬Έμν|ν°λ°μ΄ν("")λ μμλ°μ΄ν('') λλ λ°±ν±(``)λ‘ λλ¬μΈμΈ λ¬Έμμ μ§ν©, λ°±ν± μ¬μ© μ `${}`μμ λ³μλ ννμμ μ½κ² λ£μ΄μ€ μ μμ|
|boolean|true λλ false κ°|
|null|μ‘΄μ¬νμ§ μλ(nothing) κ°, λΉμ΄μλ(empty) κ°, μμμλ(unknown) κ°|
|undefined|κ°μ΄ ν λΉλμ§ μμ μν νν|
|symbol|μ μΌνκ³  λ³κ²½ν  μ μλ νμ, κ°μ²΄μ νλ‘νΌν°λ₯Ό μν μλ³μλ‘ μ¬μ©|
|κ°μ²΄|μ¬λ¬ νλ‘νΌν°(property)λ λ©μλ(method)λ₯Ό κ°μ μ΄λ¦μΌλ‘ λ¬Άμ΄λμ μΌμ’μ μ§ν©μ²΄|

<br>

### β nullκ³Ό undefined
- null : κ°λ°μκ° μλμ μΌλ‘ μλ ₯ν κ°
- undefined : μ΄κΈ°νλμ§ μμ λ³μ λλ μ‘΄μ¬νμ§ μλ κ°
```javascript
// == : μλ£ν λΉκ΅(X), κ°λ§ λΉκ΅(O)
// === : μλ£ν λΉκ΅(O) + κ° λΉκ΅(O)
null ==  undefined; // true
null === undefined; // false
```

<br>

### β typeOf
νμ¬ λ³μλ μμμ μλ£νμ νμΈνλ μ°μ°μ
```javascript
console.log(typeof 100);
console.log(typeof 3.14);
console.log(typeof num);
console.log(typeof name);
console.log(typeof flag);
```

<br>

# π νμ λ³ν
μλ°μ€ν¬λ¦½νΈλ νμ κ²μ¬κ° λ§€μ° μ μ°νλ―λ‘ κ°μ λ³μμ λ€λ₯Έ νμμ κ°μ λμν  μ μλ€.

### β λ¬΅μμ  νμ λ³ν
νΉμ  νμμ κ°μ κΈ°λνλ κ³³μ λ€λ₯Έ νμμ κ°μ΄ μ€λ©΄ μλμΌλ‘ νμμ λ³νν΄μ€λ€.
```javascript
10 + "λ¬Έμμ΄"; // λ¬Έμμ΄ μ°κ²°μ μν΄ μ«μ 10μ΄ λ¬Έμμ΄λ‘ λ³νλ¨.
"3" * "5";     // κ³±μ μ°μ°μ μν΄ λ λ¬Έμμ΄μ΄ λͺ¨λ μ«μλ‘ λ³νλ¨.
1 - "λ¬Έμμ΄";  // NaN
```

### β λͺμμ  νμ λ³ν
μλ°μ€ν¬λ¦½νΈλ λͺμμ  νμ λ³νμ μν μ μ­ν¨μλ₯Ό μ κ³΅νλ€.
1. **Number()**
2. **String()**
3. **Boolean()**
4. **Object()**
5. **parseInt()**
6. **parseFloat()**

```javascript
Number("10"); // μ«μ 10
String(true); // λ¬Έμμ΄ "true"
Boolean(0);   // λΆλ¦¬μΈ false
Object(3);    // new Number(3)μ λμΌν κ²°κ³Όλ‘ μ«μ 3
```

<br>

### β λ μ§λ₯Ό λ¬Έμμ΄ λλ μ«μλ‘ λ³ν
```javascript
String(Date());        // Mon May 16 2016 19:35:25 GMT+0900
Date().toString();     // Mon May 16 2016 19:35:25 GMT+0900
var date = new Date(); // Date κ°μ²΄ μμ±
date.getFullYear();    // 2016
date.getTime();        // 1463394925632 -> 1970λ 1μ 1μΌλΆν° νμ¬κΉμ§μ μκ°μ λ°λ¦¬μ΄ λ¨μμ μ«μλ‘ λ°νν¨. 
```

<br>

### β λ¬Έμμ΄μ μ«μλ‘ λ³ν
1. parseInt()
2. parseFloat()
```javascript
var size = '1.5em';
console.log(parseInt(size)); // 1
console.log(parseFloat(size)); // 1.5
```