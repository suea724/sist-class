# 📌 CSS 속성

### 💡 CSS 수치 표현법
|단위|설명|
|:-:|-|
|pt|포인트, 1/72인치|
|px|픽셀(크기, 여백, 위치, 글꼴 등)|
|em|부모 요소의 글꼴 크기를 기준으로 하는 상대 크기(%), 알파벳 대문자 M의 높이를 기준으로 함 (모바일과 호환)|
|rem|루트 요소(`<html>`)의 글꼴 크기를 기준으로 하는 상대 크기. 자식 요소에게 상속되지 않는다.|
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
|font-family|폰트|폰트명 + `serif`, `sans-serif`, `monospace`|
|font-size|글자 크기|수치값 (주로 em)|
|font-style|글자 스타일|`normal`, `italic`|
|font-weight|글자 두께|`lighter`, `normal`, `bold`, `bolder`, 수치값(100~900)|
|line-height|줄간격|수치값|
|word-spacing|단어 간격(스페이스 너비)|수치값|
|letter-spacing|글자 간격|수치값|
|text-decoration|글자 꾸밈|`none`, `overline`, `underline`, `line-through`, `underline overline`|
|text-indent|들여쓰기|수치값|

<br>

### ✅ border
```css
 #box1 {
    border-color : pink;
    border-width: 5px;
    border-style: dashed;

    border : 3px solid lightskyblue;
    border-top: 3px solid gold;
    border-right: 3px solid lightgreen;
    border-bottom: 3px solid orange;
    border-left: 3px solid rgb(168, 168, 38);

    border-color : red blue green yellow; /* 시계방향 */
    border-color : royalblue tomato; /* 상, 하 */
}
```
|속성|설명|속성값|
|:-:|-|-|
|border-color|테두리 색상 지정|색상명 또는 색상코드|
|border-width|테두리 두께|수치값(px)|
|border-style|선 종류|`solid`, `dashed`, `dotted`|
|border|위 속성 동시에 지정 가능|테두리 속성값|
|border-top|위 테두리|테두리 속성값|
|border-right|오른쪽 테두리|테두리 속성값|
|border-bottom|아래 테두리|테두리 속성값|
|border-left|왼쪽 테두리|테두리 속성값|
|border-collapse|테이블 선 합치기|`seperate` : 표 테두리와 셀 테두리 사이에 간격 O <br> `collapse` : 표 테두리와 셀 테두리 사이에 간격 X|

<br>

### ✅ margin, padding
```css
 #box2 {
    padding : 20px;
    padding-top : 50px;
    padding-right : 10px;
    padding-bottom: 0px;
    padding-left: 100px;
    
    margin : 20px;
    margin-top : 30px;
    margin-right : 10px;
    margin-bottom : 5px;
    margin-left: 100px;
}
```
- **padding**
    - 테두리 안쪽 여백
    - 태그의 테두리와 콘텐츠 영역 사이의 거리
- **margin**
    - 테두리 바깥쪽 여백
    - 태그의 테두리와 외부 태그 사이의 거리
    - 요소 배치용으로 사용

    <br>

### ✅ box-sizing
- width, height를 지정해도 border, padding 등과 같이 다른 속성에 의해 요소의 크기가 달라질 수 있다.

|속성값|설명|
|:-:|-|
|content-box|기본값, 콘텐츠 영역(width, height)이  다른 속성에 의해 영향을 받는다.|
|border-box|콘텐츠 영역(width, height)이 다른 속성에 의해 영향을 받지 않는다.|

<br>

### ✅ overflow
- **height 값 지정시** 오버플로우가 발생할 수 있다!

|속성값|설명|
|:-:|-|
|visible|영역에 상관없이 내용을 끝까지 출력(default)|
|scroll|스크롤바 생성|
|hidden|영역 내 내용만 출력|
|auto|기본 visible, 오버플로우 발생 시 scroll|
    
<br>

### ✅ display
- 요소의 **출력 방식을 조작**하는 속성

|속성값|설명|
|:-:|-|
|none|요소를 화면에 출력하지 않는다. (영역 보존 X) <br> vs `visibility: hidden` : 영역 보존 O|
|inline|요소를 개행없이 한줄에 배치|
|block|요소를 개행하여 한줄씩 배치|
|inline-block|inline 요소처럼 배치, inline요소에서 사용 불가능한 `width`, `height`, `margin`, `padding` 속성 사용 가능|

<br>

### ✅ float
|속성|설명|속성값|
|:-:|-|-|
|float|기본 출력 방식을 깨고, 요소를 영역의 좌측 또는 우측 끝에 위치시킴|`left`, `right`|
|clear|float의 영향을 받지 않도록 설정|`left`, `right`|

<br>

### ✅ position
- 좌표값을 사용해 요소의 위치를 조정할 수 있다. (static 제외)
- 좌표 속성 : top, right, left, bottom, z-index

|속성값|좌표 종류|기준점|원래 영역|
|:-:|-|-|-|
|static <br> (기본값)|정적 좌표|X|변화 없음|
|absolute|절대 좌표|가까운 위치 지정 조상요소|제거됨|
|relative|상대 좌표|원래 자신의 위치|유지됨|
|fixed|고정 좌표|브라우저 창의 좌측 상단|제거됨|

<br>
