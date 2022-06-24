# 📌 JSP 파일 업로드
### ✅ 파일 업로드
- 브라우저와 웹서버 간의 파일 복사
- 업로드 : 클라이언트측의 자원을 서버로 전송 
- 다운로드 : 서버측의 자원을 클라이언트로 전송

<br>

### ✅ Form을 사용한 POST 전송
- `<input type=file>`를 사용해 파일을 전송할 수 있다.
- 기본적으로 form을 통한 전송 시 content type은 `application/x-www-form-urlencoded`으로 설정된다.
- 두 종류 이상의 데이터를 함께 전송하기 위해서는 form 의 enctype 속성을 `multipart/form-data`로 설정해야 한다.

[x-www-form-urlencoded과 Multipart/form-data](https://velog.io/@ksmfou98/HTTP-%ED%8F%BC%EA%B3%BC-%ED%8C%8C%EC%9D%BC-%EC%A0%84%EC%86%A1-x-www-form-urlencoded-Multipartform-data)


<br>

### ✅ 파일 업로드 라이브러리
- `enctype="multipart/form-data"`로 지정한 폼은 request 객체로 파라미터의 값을 얻어낼 수 없다.
- 지정한 파일을 서버에 저장하기 위해 특별한 컴포넌트가 필요하다.
- 파일 업로드를 지원하는 라이브러리인 [COS 라이브러리](http://servlets.com/cos/)를 사용한다. 
- WEB-INF/lib 위치에 라이브러리를 추가한다.

<br>

### ✅ MultipartRequest
- 파일 업로드에 특화된 기능을 추가한 request 객체의 Wrapping Class

> 객체 생성

```jsp
String path = application.getRealPath("/example/files"); // 서버 작동 시 저장될 진짜 경로
int size = 1024 * 1024 * 100; // 100MB

MultipartRequest multi = new MultipartRequest(
									request,                        // 원래 request 객체
									path, 	                        // 업로드 위치
									size,	                        // 최대 크기
									"UTF-8",                        // 인코딩 지정
									new DefaultFileRenamePolicy()); // 파일 이름이 중복되지 않도록 변환
```

<br>

> 데이터 접근
```jsp
// 파일이 아닌 일반 데이터
txt = multi.getParameter("txt");
num = multi.getParameter("num");

// 파일 데이터
fileName = multi.getFilesystemName("attach"); // 서버에 업로드된 진짜 이름
orgFileName = multi.getOriginalFileName("attach"); // 사용자가 올린 원본의 이름
```

<br>

> 넘어온 모든 파일 데이터에 접근
```jsp
Enumeration files = multi.getFileNames();

while (e.hasMoreElements()) {
    String file = (String)e.nextElement();

    filesystemName = multi.getFilesystemName(file);  // 서버에 업로드된 진짜 이름
    originalFileName = multi.getOriginalFileName(file); // 사용자가 올린 원본의 이름
    contentType = multi.getContentType(file); // 업로드된 파일의 타입을 반환
    length = multi.getFile(file).length(); // 파일의 크기를 long타입으로 반환
}
```
