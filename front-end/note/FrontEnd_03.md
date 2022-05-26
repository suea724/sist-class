# 📌 CSS 속성

### 💡 CSS 수치 표현법
|단위|설명|
|:-:|-|
|pt|포인트, 1/72인치|
|px|픽셀(크기, 여백, 위치, 글꼴 등)|
|em|기본 글꼴 크기를 기준으로 하는 상대 크기(%), 알파벳 대문자 M의 높이를 기준으로 함 (모바일과 호환)|
|rem|em과 동일. 상속을 안받음|
|%|백분율(크기, 여백, 위치, 정렬 등), 상대값|

<br>

### ✅ background
```css
body {
background-color: rgba(136, 227, 140, 0.2);
background-image: url(images/dogfence.jpg);
background-repeat: no-repeat;
background-position: 25% 0%; 
background-attachment: fixed;
}
```
|속성|설명|속성값|
|:-:|-|-|
|background-color|요소의 배경 색상|색상명 또는 색상코드|
|background-image|배경 이미지|`url(이미지 주소)`|
|background-repeat|배경 이미지 반복 여부|`no-repeat` : 반복 안함 <br> `repeat-x` : 가로 반복 <br> `repeat-y` : 세로 반복 <br> `repeat` : 모든 방향 반복 (default)|
|background-position|배경 이미지 위치|`left`, `center`, `right` : 수평정렬 <br> `top`, `center`, `bottom` : 수직정렬 <br> 수치(px, %)|
|background-attachment|배경 이미지 스크롤 여부|`scroll` : 스크롤 시 배경 이미지는 스크롤 되지 않음 <br> `fixed` : 스크롤과 관계없이 고정|

<br>

### ✅ text
```css
.txt {
color: #444; 
text-align:center;
font-size:1em;
line-height : 2em;
font-style : italic;
font-weight: bold;
word-spacing : 0em;
letter-spacing: -1px;
text-decoration: line-through;
}
```
|속성|설명|속성값|
|:-:|-|-|
|color|색상|색상명 또는 색상코드|
|text-align|텍스트 정렬|`left`, `right`, `center`, `justify`|
|font-size|글자 크기|수치값|
|line-height|줄간격|수치값|
|font-style|글자 스타일|`normal`, `italic`|
|font-weight|글자 두께|`lighter`, `normal`, `bold`, `bolder`, 수치값(100~900)|
|word-spacing|단어 간격(스페이스 너비)|수치값|
|letter-spacing|글자 간격|수치값|
|text-decoration|글자 꾸밈|`none`, `overline`, `underline`, `line-through`, `underline overline`|