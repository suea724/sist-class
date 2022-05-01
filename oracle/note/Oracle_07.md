# 📌 DML - INSERT, DELETE, UPDATE
### ✅ INSERT
- 테이블에 데이터를 추가(행 추가)하는 명령어
```sql
INSERT INTO 테이블명(컬럼리스트) VALUES(값리스트);
```
- 예시
```sql
-- 컬럼리스트와 값리스트의 순서와 개수가 일치해야 한다.
insert into tblMemo(seq, name, memo, regdate) values(seqMemo.nextVal, '홍길동', '메모', sysdate);

-- null, default 조작
-- 1) null 상수 명시 > default 동작 X
insert into tblMemo(seq, name, memo, regdate) values(seqMemo.nextVal, '홍길동', null, sysdate);

-- 2) 컬럼 생략 > default 동작 O
insert into tblMemo(seq, name) values(seqMemo.nextVal, '홍길동'); -- regdate에 sysdate(default값) 입력

-- 3) default 상수 명시
insert into tblMemo(seq, name, memo, regdate) values(seqMemo.nextVal, default, '메모', sysdate);  -- name에 '익명'(default값) 입력

-- 컬럼리스트 생략 가능 > 원본 테이블의 컬럼리스트와 순서와 개수가 동일한 경우
insert into tblMemo values(seqMemo.nextVal, '홍길동', '메모', sysdate);

-- 테이블 복사 > subquery 사용
insert into tblMemoCopy select * from tblMemo;
```

<br>

### ✅ UPDATE
- 원하는 행의 속성 값을 수정하는 명령어
```sql
UPDATE 테이블명 SET 컬럼명 = 값 [,컬럼명 = 값] [WHERE절]
```
- 예시
```SQL
-- 대한민국의 수도를 세종으로 변경
update tblCountry set capital = '세종' where name = '대한민국';

-- 전세계 인구수 10% 증가
update tblCountry set population = population * 1.1;
```

<br>

### ✅ DELETE
- 원하는 행을 삭제하는 명령어
```sql
DELETE FROM 테이블명 [WHERE절]
```
- 예시
```SQL
-- basicpay 180~200만원인 사람 제거
delete from tblInsa where basicpay between 1800000 and 2000000;
```


