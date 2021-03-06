# ๐ DOM, Document Object Model
- XML์ด๋ HTML๋ฌธ์์ ์ ๊ทผํ๊ธฐ ์ํ ์ผ์ข์ ์ธํฐํ์ด์ค
- W3C์ ํ์ค ๊ฐ์ฒด ๋ชจ๋ธ
- ๋ฌธ์ ๋ด์ ๋ชจ๋  ์์๋ฅผ **๊ณ์ธต์ผ๋ก ํํ**ํ๊ณ , ๊ฐ **์์์ ์ ๊ทผํ๋ ๋ฐฉ๋ฒ**์ ์ ๊ณตํ์ฌ ์์ฑ, ๋ณํ, ์ญ์  ํ  ์ ์๋๋ก ํ๋ค.

> DOM ๊ณ์ธต ๊ตฌ์กฐ

![](./img_js_htmldom.png)

<br>

### โ DOM์ ์ข๋ฅ
W3C DOM ํ์ค์ ์ธ๊ฐ์ง ๋ชจ๋ธ๋ก ๊ตฌ๋ถ๋๋ค.
1. **Core DOM** : ๋ชจ๋  ๋ฌธ์ ํ์์ ์ํ DOM ๋ชจ๋ธ
2. **HTML DOM** : HTML ๋ฌธ์๋ฅผ ์ํ DOM ๋ชจ๋ธ
3. **XML DOM** : XML ๋ฌธ์๋ฅผ ์ํ DOM ๋ชจ๋ธ

<br>

# ๐ Document ๊ฐ์ฒด
- ์น ํ์ด์ง ๊ทธ ์์ฒด
- ์น ํ์ด์ง์ ์กด์ฌํ๋ HTML ์์์ ์ ๊ทผํ๋ ค๋ฉด Document ๊ฐ์ฒด๋ถํฐ ์์ํด์ผ ํ๋ค.

<br>

### โ Document ๋ฉ์๋
- **HTML ์์์ ์ ํ**
    - `document.getElementsByTagName(ํ๊ทธ์ด๋ฆ)` : ํด๋น ํ๊ทธ ์ด๋ฆ์ ์์๋ฅผ ๋ชจ๋ ์ ํ
    - `document.getElementById(์์ด๋)` : ํด๋น ์์ด๋์ ์์๋ฅผ ์ ํ
    - `document.getElementsByClassName(ํด๋์ค์ด๋ฆ)` : ํด๋น ํด๋์ค์ ์ํ ์์๋ฅผ ๋ชจ๋ ์ ํ
    - `document.getElementsByName(name์์ฑ๊ฐ)` : ํด๋น name ์์ฑ๊ฐ์ ๊ฐ์ง๋ ์์๋ฅผ ๋ชจ๋ ์ ํ
    - `document.querySelectorAll(์ ํ์)` : ํด๋น ์ ํ์๋ก ์ ํ๋๋ ์์๋ฅผ ๋ชจ๋ ์ ํ

    <br>


- **HTML ์์์ ์์ฑ**
    - `document.createElement(HTML์์)` : ์ง์ ๋ HTML ์์๋ฅผ ์์ฑ
    - `document.write(ํ์คํธ)` : HTML ์ถ๋ ฅ ์คํธ๋ฆผ์ ํตํด ํ์คํธ๋ฅผ ์ถ๋ ฅ

    <br>


- **HTML ์ด๋ฒคํธ ํธ๋ค๋ฌ ์ถ๊ฐ**
    - `document.getElementById(์์ด๋).onclick = function() {์คํํ  ์ฝ๋}` : ๋ง์ฐ์ค ํด๋ฆญ ์ด๋ฒคํธ์ ์ฐ๊ฒฐ๋  ์ด๋ฒคํธ ํธ๋ค๋ฌ ์ฝ๋๋ฅผ ์ถ๊ฐ

    <br>

- **HTML ๊ฐ์ฒด์ ์ ํ**
    - `document.body` : body ์์๋ฅผ ๋ฐํ
    - `document.images` : img ์์๋ฅผ ๋ชจ๋ ๋ฐํํจ
    - [๋๋ณด๊ธฐ](http://www.tcpschool.com/javascript/js_dom_document)

<br>

# ๐ ๋ธ๋
- DOM์ ๋ธ๋๋ผ๊ณ  ๋ถ๋ฆฌ๋ ๊ณ์ธต์  ๋จ์์ ์ ๋ณด๋ฅผ ์ ์ฅํ๋ค.
- DOM์ ์ด๋ฌํ ๋ธ๋๋ค์ ์ ์ํ๊ณ  ๊ทธ๋ค ์ฌ์ด์ ๊ด๊ณ๋ฅผ ์ค๋ชํด์ฃผ๋ ์ญํ ์ ํ๋ค.

<br>

### โ ๋ธ๋์ ์ข๋ฅ
|๋ธ๋|์ค๋ช|
|:-:|-|
|๋ฌธ์ ๋ธ๋(document node)|HTML ๋ฌธ์ ์ ์ฒด๋ฅผ ๋ํ๋ด๋ ๋ธ๋|
|์์ ๋ธ๋(element node)|๋ชจ๋  HTML ์์. ์์ฑ ๋ธ๋๋ฅผ ๊ฐ์ง ์ ์๋ ์ ์ผํ ๋ธ๋|
|์์ฑ ๋ธ๋(attribute node)|๋ชจ๋  HTML์์์ ์์ฑ. ์์ ๋ธ๋์ ๋ํ ์ ๋ณด๋ฅผ ๊ฐ์ง๊ณ  ์์, ํด๋น ์์ ๋ธ๋์ ์์ ๋ธ๋์๋ ํฌํจ๋์ง ์์|
|ํ์คํธ ๋ธ๋(text node)|HTML ๋ฌธ์์ ๋ชจ๋  ํ์คํธ|
|์ฃผ์ ๋ธ๋(comment node)|HTML ๋ฌธ์์ ๋ชจ๋  ์ฃผ์|

<br>

### โ ๋ธ๋ ๊ฐ์ ๊ด๊ณ
![](./img_js_node_relationship.png)
- ๋ชจ๋  ๋ธ๋๋ ์๋ก ๊ณ์ธต์  ๊ด๊ณ๋ฅผ ๋งบ์
- ๋ธ๋ ํธ๋ฆฌ์ ๊ฐ์ฅ ์์์๋ ๋จ ํ๋์ ๋ฃจํธ ๋ธ๋๊ฐ ์กด์ฌ
- ๋ชจ๋  ์์ ๋ธ๋๋ ์์ ๋ธ๋๋ฅผ ๊ฐ์ง ์ ์์

<br>

### โ ๋ธ๋๋ก์ ์ ๊ทผ
#### ๐ getElementsByTagName() ๋ฉ์๋๋ฅผ ์ด์ฉํ์ฌ ์ ๊ทผ
- ํน์  ํ๊ทธ ์ด๋ฆ์ ๊ฐ์ง๋ ๋ชจ๋  ์์๋ฅผ ๋ธ๋ ๋ฆฌ์คํธ ํํ๋ก ๋ฐํ

<br>

#### ๐ ๋ธ๋ ๊ฐ์ ๊ด๊ณ๋ฅผ ์ด์ฉํ์ฌ ์ ๊ทผ
- ๋ถ๋ชจ ๋ธ๋ ์ ๊ทผ
    - parentNode : ๋ถ๋ชจ ๋ธ๋
    - parentElement : ๋ถ๋ชจ ์์ ๋ธ๋

    <br>

- ์์ ๋ธ๋ ์ ๊ทผ
    - childNodes : ๋ชจ๋  ์ข๋ฅ์ ์์ ๋ธ๋ ์ฐธ์กฐ
    - firstChild : ์ฒซ๋ฒ์งธ ์์ ๋ธ๋
    - lastChild : ๋ง์ง๋ง ์์ ๋ธ๋
    - children : ์์ ๋ธ๋ ์ค ์์ ๋ธ๋ ์ฐธ์กฐ
    - firstElementChild : ์ฒซ๋ฒ์งธ ์์ ์์ ๋ธ๋
    - lastElementChild : ๋ง์ง๋ง ์์ ์์ ๋ธ๋

    <br>

- ํ์  ๋ธ๋ ์ ๊ทผ
    - nextSibling : ๋ค์ ํ์  ๋ธ๋
    - previousSibling : ์ด์  ํ์  ๋ธ๋
    - nextElementSibling : ๋ค์ ํ์  ์์ ๋ธ๋
    - previousElementSibling : ์ด์  ํ์  ์์ ๋ธ๋

<br>

### โ ๋ธ๋์ ๋ํ ์ ๋ณด
- nodeName
    - ๋ธ๋ ๊ณ ์ ์ ์ด๋ฆ์ ์ ์ฅ, ์ฝ๊ธฐ ์ ์ฉ ํ๋กํผํฐ
```javascript
// HTML ๋ฌธ์์ ๋ชจ๋  ์์ ๋ธ๋ ์ค์์ ๋ ๋ฒ์งธ ๋ธ๋์ ์ด๋ฆ์ ์ ํํจ.
document.getElementById("document").innerHTML = document.childNodes[1].nodeName; // HTML


// html ๋ธ๋์ ๋ชจ๋  ์์ ๋ธ๋ ์ค์์ ์ฒซ ๋ฒ์งธ ๋ธ๋์ ์ด๋ฆ์ ์ ํํจ.
document.getElementById("html").innerHTML = document.childNodes[1].childNodes[0].nodeName; // HEAD
```

<br>

- nodeValue
    - ๋ธ๋์ ๊ฐ ์ ์ฅ
```javascript
var para = document.getElementById("text"); // id๊ฐ "text"์ธ ์์ ์ ํ

function changeText() {
    para.firstChild.nodeValue = "ํ์คํธ ๋ณ๊ฒฝ ์๋ฃ!";
}
```

<br>

- nodeType
    - ๋ธ๋ ๊ณ ์ ์ ํ์์ ์ ์ฅ, ์์ ํ  ์ ์๋ ์ฝ๊ธฐ ์ ์ฉ ํ๋กํผํฐ
```javascript
document.getElementById("document").innerHTML = document.nodeType; // 9
```

|๋ธ๋|ํ๋กํผํฐ ๊ฐ|
|:-:|:-:|
|์์ ๋ธ๋(element node)|1|
|์์ฑ ๋ธ๋(attribute node)|2|
|ํ์คํธ ๋ธ๋(text node)|3|
|์ฃผ์ ๋ธ๋(comment node)|8|
|๋ฌธ์ ๋ธ๋(document node)|9|

<br>

### โ ๋ธ๋ ๊ด๋ฆฌ
#### ๐ ๋ธ๋ ์ถ๊ฐ
- appendChild() : ์๋ก์ด ๋ธ๋๋ฅผ ํด๋น ๋ธ๋์ ์์ ๋ธ๋ ๋ฆฌ์คํธ ๋งจ ๋ง์ง๋ง์ ์ถ๊ฐ
```javascript
function appendNode() {

    var parent = document.getElementById("list");  // id๊ฐ "list"์ธ ์์๋ฅผ ์ ํ
    var newItem = document.getElementById("item"); // id๊ฐ "item"์ธ ์์๋ฅผ ์ ํ

    parent.appendChild(newItem); // ํด๋น ์์์ ๋งจ ๋ง์ง๋ง ์์ ๋ธ๋๋ก ์ถ๊ฐ
}
```

<br>

- insertBefore() : ์๋ก์ด ๋ธ๋๋ฅผ ํน์  ์์ ๋ธ๋ ๋ฐ๋ก ์์ ์ถ๊ฐ
```javascript
function appendNode() {

    var parent = document.getElementById("list"); // id๊ฐ "list"์ธ ์์๋ฅผ ์ ํ
    var criteriaItem = document.getElementById("criteria"); // id๊ฐ "criteria"์ธ ์์๋ฅผ ์ ํํจ.
    var newItem = document.getElementById("item"); // id๊ฐ "item"์ธ ์์๋ฅผ ์ ํํจ.
 
    parent.insertBefore(newItem, criteriaItem); // ํด๋น ๋ธ๋๋ฅผ ๊ธฐ์ค์ด ๋๋ ์์ ๋ธ๋์ ๋ฐ๋ก ์์ ์ถ๊ฐํจ.
}
```

<br>

#### ๐ ๋ธ๋ ์์ฑ
- createElement() : ์์ ๋ธ๋ ์์ฑ
```javascript
function createNode() {

    var criteriaNode = document.getElementById("text"); // ๊ธฐ์ค์ด ๋๋ ์์๋ก id๊ฐ "text"์ธ ์์๋ฅผ ์ ํํจ.
    var newNode = document.createElement("p");          // ์๋ก์ด <p> ์์๋ฅผ ์์ฑํจ.
    newNode.innerHTML = "์๋ก์ด ๋จ๋ฝ์๋๋ค.";
    document.body.insertBefore(newNode, criteriaNode);  // ์๋ก์ด ์์๋ฅผ ๊ธฐ์ค์ด ๋๋ ์์ ๋ฐ๋ก ์์ ์ถ๊ฐํจ.
}
```

<br>

- createAttribute() : ์์ฑ ๋ธ๋ ์์ฑ
```javascript
function createNode() {

    var text = document.getElementById("text");           // id๊ฐ "text"์ธ ์์๋ฅผ ์ ํํจ.
    var newAttribute = document.createAttribute("style"); // ์๋ก์ด style ์์ฑ ๋ธ๋๋ฅผ ์์ฑํจ.
    newAttribute.value = "color:red";
    text.setAttributeNode(newAttribute);                  // ํด๋น ์์์ ์์ฑ ๋ธ๋๋ก ์ถ๊ฐํจ.
}
```

<br>

#### ๐ ๋ธ๋ ์ ๊ฑฐ
- removeChild() : ์์ ๋ธ๋ ๋ฆฌ์คํธ์์ ํน์  ์์ ๋ธ๋ ์ ๊ฑฐ
```javascript
var parent = document.getElementById("list");      // id๊ฐ "list"์ธ ์์๋ฅผ ์ ํํจ.
var removedItem = document.getElementById("item"); // id๊ฐ "item"์ธ ์์๋ฅผ ์ ํํจ.
parent.removeChild(removedItem);                   // ์ง์ ๋ ์์๋ฅผ ์ญ์ ํจ.
```

<br>

- removeAttribute() : ์์ฑ์ ์ด๋ฆ์ ์ด์ฉํ์ฌ ํน์  ์์ฑ ๋ธ๋ ์ ๊ฑฐ
```javascript
var text = document.getElementById("text"); // id๊ฐ "text"์ธ ์์๋ฅผ ์ ํํจ.
text.removeAttribute("style");              // ํด๋น ์์์ "style" ์์ฑ์ ์ ๊ฑฐํจ.
```