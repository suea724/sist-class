# 📌 CSS
### ✅ HTML 문서와 CSS 연결하기
#### 1️⃣ 인라인 스타일 시트, Inline Style Sheet
```html
 <li style="color:coral;">수업 내용 정리하기</li>
```
- 원하는 태그에 직접 속성을 지정한다.
- **장점** : 가독성 높음
- **단점** : 서식 일괄 적용 불가

#### 2️⃣ 내부 스타일 시트, Embeded Style Sheet
```html
<style>
    li {
        font-style: italic;
    }
</style>
```
- `<style>`태그 내에 서식 명시 (head 태그 내)
- **장점** : 서식 일괄 적용 가능
- **단점** : 가독성 낮음

#### 3️⃣ 외부 스타일 시트, External Style Sheet
```html
<link rel="stylesheet" href="css파일 경로">
```
- 별도의 CSS 파일에 서식 명시
- HTML 문서에서 `<link>` 태그로 참조 (head 태그 내)
- **장점** : CSS 재사용성 높음
- **단점** : 가독성 낮음

<br>

### ✅ 선택자, Selector
#### 1️⃣ 전체 선택자
```css
* {
    color : blue;
}
```
- 모든 태그를 선택한다.
- 잘 사용하지 않음
#### 2️⃣ 태그 선택자
```css
h2 {
    color : blue;
}
```
- 특정 태그를 선택하여 일괄 적용한다.
- 많이 사용
- 생산성은 높지만, 각 태그의 성격을 구분하지 않는다.
#### 3️⃣ ID 선택자
```css
h2#title {
    color : blue;
}
```
- `태그명#id명` or `#id명`
- 태그에 명시된 id 속성을 사용해서 원하는 태그를 선택한다.
- 특정한 태그 하나에만 적용한다. (id 속성의 성격)
#### 4️⃣ 클래스 선택자
```css
.test {
    color : blue;
}
```
- `태그명.클래스명` or `.클래스명`
- 태그에 명시된 class 속성을 사용해서 원하는 태그를 선택한다.
- 동일한 클래스명을 가진 태그에 일괄 적용된다.
- 태그명 지정시 지정한 태그에만 적용된다.