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
|background-size|배경 이미지 크기 조정|수치값 <br> `contains` : 이미지가 잘리지 않음<br> `cover` : 영역에 꽉참|
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
|border-radius|모서리 둥글기|수치값(px, %)|
|border|위 속성 동시에 지정 가능|테두리 속성값|
|border-top|위 테두리|테두리 속성값|
|border-right|오른쪽 테두리|테두리 속성값|
|border-bottom|아래 테두리|테두리 속성값|
|border-left|왼쪽 테두리|테두리 속성값|
|border-collapse|테이블 선 합치기|`seperate` : 표 테두리와 셀 테두리 사이에 간격 O <br> `collapse` : 표 테두리와 셀 테두리 사이에 간격 X|

※ border 사용 시 레이아웃을 깨뜨릴 수 있다. 레이아웃이 깨지지 않길 원하면 `outline` 속성을 사용한다.

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

|속성|설명|
|:-:|-|
|padding|- 테두리 안쪽 여백 <br> - 태그의 테두리와 콘텐츠 영역 사이의 거리|
|margin|- 테두리 바깥쪽 여백 <br> - 태그의 테두리와 외부 태그 사이의 거리 <br> - 요소 배치용으로 사용|    

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
|flex|요소를 수직 또는 수평으로 배치(flex conatiner)|

<br>

### ✅ flex
|속성|설명|속성값|
|:-:|-|-|
|flex-flow|flex-direction과 flext-wrap의 단축 속성|각 속성값|
|flex-direction|flex 요소의 주축을 설정|`row` : 기본값, 수평방향으로 왼쪽에서 오른쪽으로 정렬 <br> `row-reverse` : row와 반대 <br> `column` : 수직방향으로 위에서 아래로 정렬 <br> `column-reverse` : column과 반대|
|flex-wrap|flex 요소의 줄바꿈 설정|`nowrap` : 모든 요소를 한줄에 표시 <br> `wrap` : 요소 줄바꿈 <br> `wrap-reverse` : 요소를 역방향으로 줄바꿈 |
|justify-content|주축의 정렬 방법 설정|`flex-start` : 요소를 주축 기준 시작부분부터 배치 <br> `flex-end` : 요소를 주축 기준 끝부분부터 배치 <br> `center` : 요소 주축 기준 가운데 정렬 <br> `space-between` : 요소 사이에 동일한 간격을 둠 <br> `space-around` : 양 끝에 여백, 요소 사이에 동일한 간격을 둠 <br> `space-evenly` : 양 끝에 여백과 요소 사이 간격이 동일 <br> `stretch` : 주축 기준으로 끝까지 요소를 채움|
|align-content|교차축의 정렬 방법을 설정|`flex-start` : 요소를 교차축 기준 시작부분부터 배치 <br> `flex-end` : 요소를 교차축 기준 끝부분부터 배치 <br> `center` : 요소 교차축 기준 가운데 정렬 <br> `space-between` : 요소 사이에 동일한 간격을 둠 <br> `space-around` : 양 끝에 여백, 요소 사이에 동일한 간격을 둠 <br> `space-evenly` : 양 끝에 여백과 요소 사이 간격이 동일 <br> `stretch` : 교차축 기준으로 끝까지 요소를 채움|

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

### ✅ shadow
|속성|설명|속성값|
|:-:|-|-|
|text-shadow|글자 요소에 그림자 생성|좌표, 흐림도, 색상|
|box-shadow|요소를 포함하는 블럭에 그림자 생성|좌표, 흐림도, 색상|

<br>

### ✅ column
다단 구조 생성시 사용하는 속성
|속성|설명|
|:-:|-|
|column-count|분할의 개수를 지정|
|column-gap|분할 사이 간격 조정|
|column-rule|분할 사이에 구분선 추가|

<br>

### ✅ transform
요소를 회전하거나 확대/축소, 비틀기 등 형태를 변형하는 속성
|속성값|설명|
|:-:|-|
|translate(좌표)|위치 이동|
|scale(비율)|배율 변형(확대, 축소)|
|rotate(angle)|회전 변형, 회전 기준점은 `transform-origin`으로 설정 가능(기본값 : 요소의 중심)|
|skew(angle)|왜곡(비틀기)|



[transform 참고자료](https://www.codingfactory.net/12593) 

<br>

### ✅ transition
객체의 속성값이 변화되는 과정을 애니메이션 형태로 나타내주는 속성 (수치형 속성값에만 적용 가능)
|속성|설명|속성값|
|:-:|-|-|
|transition-delay|전환효과의 시작을 연기|시간(s 또는 ms)|
|transition-duration|전환효과의 총 시간 설정|시간(s 또는 ms)|
|transition-property|전환효과를 설정할 요소의 속성 설정|`none` : 모든 속성에 적용하지 않음 <br> `all` : 모든 속성에 적용 <br> `property` : 속성 지정, 여러 개의 속성 지정 시 쉼표로 구분|
|transition-timing-function|전환효과의 진행 속도 설정|`ease` : 천천히 - 빠르게 - 천천히 <br> `linear` : 등속 <br> `ease-in` : 천천히 - 보통 <br> `ease-out` : 보통 - 천천히 <br> `ease-in-out` : 천천히 - 보통 - 천천히|


[transition 참고자료](https://www.codingfactory.net/10953)

<br>

### ✅ animation
요소에 동적인 효과를 부여하는 속성 (transition보다 세밀)
|속성|설명|속성값|
|:-:|-|-|
|@keyframes|어떤 모양에서 어떤 모양으로 바꿀지 설정|0% ~ 100% 또는 from, to로 설정|
|animation-name|어떤 @keyframes를 사용할지 설정|@keyframes 이름|
|animation-duration|애니메이션의 지속 시간 (총 시간 = 지속 시간 * 반복 횟수)|시간 (s 또는 ms)|
|animation-timing-function|애니메이션 진행 속도|transition-timing-fuction와 동일|
|animation-delay|애니메이션 시작 전 대기 시간|시간 (s 또는 ms)|
|animation-iteration-count|애니메이션 반복 횟수|숫자|
|animation-direction|애니메이션 진행 방향|`normal` : 기본값, 정해진 순서로 진행 <br> `reverse` : 반대 순서로 진행 <br> `alternate` : 정해진 순서로 진행 후 반대 순서로 진행 <br> `alternate-reverse` : 반대 순서로 진행 후 정해진 순서로 진행|
|animation-fill-mode|애니메이션을 마친 후 상태|`none` : 애니메이션이 끝난 후 상태를 설정하지 않음 <br> `forwards` : 애니메이션이 끝난 후 그 지점에 그대로 있음 <br> `backwords` : 애니메이션이 끝난 후 시작점으로 돌아옴<br> `both` : 애니메이션의 앞 뒤 결과를 조합하여 설정|

[animation 참고자료](https://www.codingfactory.net/11163)

