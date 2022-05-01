# 📌 시퀀스, Sequence
- 데이터베이스 객체 중 하나 (오라클 전용 객체)
- **자동으로 순차적으로 증가하는 일련 번호를 생성하는 객체**
- 주로 PK 컬럼에 값을 넣을 때(식별자 생성 시) 사용한다. > 

```sql
CREATE SEQUENCE [시퀀스명]
    INCREMNET BY [증감숫자]
    START WITH [시작값]
    MINVALUE [최소값]
    MAXVALUE [최대값]
    CYCLE -- 최대값에 도달하면 최소값부터 다시 시작
    CACHE -- 메모리에 시퀀스 값 미리 할당
```

<br>

### ✅ 시퀀스 객체 생성
```sql
CREATE SEQUENCE 시퀀스명;
```

<br>

### ✅ 시퀀스 객체 삭제
```sql
DROP SEQUENCE 시퀀스명;
```

<br>

### ✅ 시퀀스 객체 사용
- currVal은 peek() 역할 > 잘 안쓰임
```sql
시퀀스명.nextVal
시퀀스명.currVal
```

- 예시
```sql
-- 쇼핑몰 상품테이블의 상품번호
select 'A' || seqNum.nextVal from dual;
select 'A' || to_char(seqNum.nextVal, '0000') from dual;
select 'A' || ltrim(to_char(seqNum.nextVal, '0000')) from dual;
```