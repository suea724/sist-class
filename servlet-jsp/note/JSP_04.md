# π JSP νμΌ μλ‘λ
### β νμΌ μλ‘λ
- λΈλΌμ°μ μ μΉμλ² κ°μ νμΌ λ³΅μ¬
- μλ‘λ : ν΄λΌμ΄μΈνΈμΈ‘μ μμμ μλ²λ‘ μ μ‘ 
- λ€μ΄λ‘λ : μλ²μΈ‘μ μμμ ν΄λΌμ΄μΈνΈλ‘ μ μ‘

<br>

### β Formμ μ¬μ©ν POST μ μ‘
- `<input type=file>`λ₯Ό μ¬μ©ν΄ νμΌμ μ μ‘ν  μ μλ€.
- κΈ°λ³Έμ μΌλ‘ formμ ν΅ν μ μ‘ μ content typeμ `application/x-www-form-urlencoded`μΌλ‘ μ€μ λλ€.
- λ μ’λ₯ μ΄μμ λ°μ΄ν°λ₯Ό ν¨κ» μ μ‘νκΈ° μν΄μλ form μ enctype μμ±μ `multipart/form-data`λ‘ μ€μ ν΄μΌ νλ€.

[x-www-form-urlencodedκ³Ό Multipart/form-data](https://velog.io/@ksmfou98/HTTP-%ED%8F%BC%EA%B3%BC-%ED%8C%8C%EC%9D%BC-%EC%A0%84%EC%86%A1-x-www-form-urlencoded-Multipartform-data)


<br>

### β νμΌ μλ‘λ λΌμ΄λΈλ¬λ¦¬
- `enctype="multipart/form-data"`λ‘ μ§μ ν νΌμ request κ°μ²΄λ‘ νλΌλ―Έν°μ κ°μ μ»μ΄λΌ μ μλ€.
- μ§μ ν νμΌμ μλ²μ μ μ₯νκΈ° μν΄ νΉλ³ν μ»΄ν¬λνΈκ° νμνλ€.
- νμΌ μλ‘λλ₯Ό μ§μνλ λΌμ΄λΈλ¬λ¦¬μΈ [COS λΌμ΄λΈλ¬λ¦¬](http://servlets.com/cos/)λ₯Ό μ¬μ©νλ€. 
- WEB-INF/lib μμΉμ λΌμ΄λΈλ¬λ¦¬λ₯Ό μΆκ°νλ€.

<br>

### β MultipartRequest
- νμΌ μλ‘λμ νΉνλ κΈ°λ₯μ μΆκ°ν request κ°μ²΄μ Wrapping Class

> κ°μ²΄ μμ±

```jsp
String path = application.getRealPath("/example/files"); // μλ² μλ μ μ μ₯λ  μ§μ§ κ²½λ‘
int size = 1024 * 1024 * 100; // 100MB

MultipartRequest multi = new MultipartRequest(
									request,                        // μλ request κ°μ²΄
									path, 	                        // μλ‘λ μμΉ
									size,	                        // μ΅λ ν¬κΈ°
									"UTF-8",                        // μΈμ½λ© μ§μ 
									new DefaultFileRenamePolicy()); // νμΌ μ΄λ¦μ΄ μ€λ³΅λμ§ μλλ‘ λ³ν
```

<br>

> λ°μ΄ν° μ κ·Ό
```jsp
// νμΌμ΄ μλ μΌλ° λ°μ΄ν°
txt = multi.getParameter("txt");
num = multi.getParameter("num");

// νμΌ λ°μ΄ν°
fileName = multi.getFilesystemName("attach"); // μλ²μ μλ‘λλ μ§μ§ μ΄λ¦
orgFileName = multi.getOriginalFileName("attach"); // μ¬μ©μκ° μ¬λ¦° μλ³Έμ μ΄λ¦
```

<br>

> λμ΄μ¨ λͺ¨λ  νμΌ λ°μ΄ν°μ μ κ·Ό
```jsp
Enumeration files = multi.getFileNames();

while (e.hasMoreElements()) {
    String file = (String)e.nextElement();

    filesystemName = multi.getFilesystemName(file);  // μλ²μ μλ‘λλ μ§μ§ μ΄λ¦
    originalFileName = multi.getOriginalFileName(file); // μ¬μ©μκ° μ¬λ¦° μλ³Έμ μ΄λ¦
    contentType = multi.getContentType(file); // μλ‘λλ νμΌμ νμμ λ°ν
    length = multi.getFile(file).length(); // νμΌμ ν¬κΈ°λ₯Ό longνμμΌλ‘ λ°ν
}
```
