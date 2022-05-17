# 📌 인덱스, Index
- 테이블의 특정 컬럼에 대해 생성한다.
- 테이블의 검색 속도를 향상시키기 위해 사용한다.
- b-tree 구조를 사용한다.
- table full scan을 하지 않는다.
- 너무 잦은 인덱스 사용은 데이터베이스 성능을 저하시킬 수 있다.

<br>

### ✅ 자동으로 인덱스가 걸리는 컬럼
- Primary key
- Unique

<br>

### ✅ 인덱스를 사용해야 하는 경우
1. 테이블에 데이터가 너무 많을 때
2. where절에 사용되는 횟수가 많은 컬럼에 적용 ⭐
3. join에 조건으로 사용되는 횟수가 많은 컬럼에 적용 ⭐
4. select 결과가 10 ~ 15% 이하인 경우

<br>

### ✅ 인덱스를 사용하지 말아야 하는 경우
1. 테이블에 데이터가 적은 경우 (의미 없음)
2. select 결과가 15% 이상인 경우
3. 해당 테이블에 삽입, 수정, 삭제가 빈번한 경우 ⭐ <br>
→ 변경이 발생할 때마다 정렬 수행이 되므로 성능 저하

<br>

### ✅ 인덱스 종류
1. 고유 인덱스
    - 중복 인덱스 불가
    - ex) PK, UNIQUE
```sql
create unique index idxName on tblIndex(name);  -- 동명이인 없을 때
```

<br>


2. 비고유 인덱스
    - 중복 인덱스 가능
    - 일반 컬럼
```sql
create index idxBuseo on tblIndex(buseo);   -- 일반 컬럼
```

<br>

3. 단일 인덱스
    - 컬럼 1개 대상
```sql
create index idxBuseo on tblIndex(buseo);

select count(*) from tblIndex where buseo =  '기획부'; -- 인덱스 효과 O

select count(*) from tblIndex where buseo =  '기획부' and name = '홍길동'; -- 인덱스 효과 X
```

<br>


4. 복합 인덱스
    - 컬럼 N개 대상
```sql
create index idxBuseoName on tblIndex(buseo, name);

select count(*) from tblIndex where buseo =  '기획부' and name = '홍길동'; -- 인덱스 효과 O
```

<br>


5. 함수 기반 인덱스
    - 함수를 사용해 조작한 값 대상
```sql
create index idxSsn on tblIndex(substr(ssn, 8, 1));

select count(*) from tblIndex where substr(ssn, 8, 1) = '1';
```

[참고하면 좋을 포스트](https://coding-factory.tistory.com/746)