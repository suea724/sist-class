# 📌 DDL, Data Definition Language
- 데이터 정의어
- **데이터베이스 객체를 생성/수정/삭제**한다.
- 데이터베이스 객체 : 테이블, 뷰, 인덱스, 프로시저, 트리거, 제약사항, 시노님

<br>

### ✅ CREATE
- 컬럼명과 도메인(자료형, 제약사항)을 정의하고, 기본키 및 외래키를 정의한다.
```sql
CREATE TABLE 테이블이름
(
    {속성이름 데이터타입
        [NULL|NOT NULL|UNIQUE|DEFAULT 기본값|CHECK 체크조건]
    }
    [PRIMARY KEY 속성이름(들)]
    [FOREIGN KEY 속성이름 REFERENCES 테이블이름(속성이름)]
        [ON DELETE {CASCADE|SET NULL}]
);
```

<br>

### ✅ 제약사항
- 해당 컬럼에 들어갈 데이터에 대한 조건
- 조건 만족 시 데이터 입력, 불만족 시 에러 발생
- 유효성 검사 도구
- **데이터 무결성을 보장**하기 위한 도구 ⭐

<br>

1. **NOT NULL**
- 해당 컬럼이 반드시 값을 가져야 한다.

<br>

2. **PRIMARY KEY, PK**
- 행을 식별하는 수많은 키들 중 대표로 지정한 키
- 모든 테이블 안에는 반드시 1개의 기본키가 존재해야 한다.
- 중복값을 가질 수 없다. (UNIQUE)
- 값을 반드시 가진다. (NOT NULL)

<br>

3. **FOREIGN KEY, FK**
- 다른 테이블의 기본키를 참조하는 외래키
- 외래키 지정 시 참조되는 테이블의 튜플이 삭제될 때 동작을 지정할 수 있다.
- **ON DELETE CASADE** : 참조되는 테이블의 튜플 삭제 시, 이를 참조하는 튜플이 연쇄삭제 된다.
- **ON DELETE SET NULL** : 참조되는 테이블의 튜플 삭제 시,  이를 참조하는 튜플이 NULL값이 된다.

<br>

4. **UNIQUE**
- 튜플 간 동일값을 가질 수 없다.
- UNIQUE 제약은 NULL 값을 가질 수 있다.

<br>

5. **CHECK**
- 사용자 정의 제약 조건
- where절과 동일하게 조건을 컬럼을 적용한다.

<br>

6. **DEFAULT**
- 기본값 설정
- insert/update 작업 시 컬럼값을 넣어주지 않으면,null 대신 미리 설정한 값을 입력한다.

<br>

### ✅ ALTER
- 테이블의 컬럼과 제약사항을 수정 시 사용하는 명령어
- 되도록 테이블을 수정하는 상황을 발생시키면 안된다.
```sql
ALTER TABLE 테이블이름
    [ADD 속성이름 데이터입]
    [DROP COLUMN 속성이름]
    [ALTER COLUMN 속성이름 데이터타입]
    [ALTER COLUMN 속성이름 [NULL|NOT NULL]]
    [ADD PRIMARY KEY(속성이름)]
    [[ADD|DROP] 제약이름]
```
<br>

- **컬럼 추가**
```sql
alter table tblEdit 
    add (price number null);

-- NOT NULL 제약 추가는 테이블이 비어있을 때 가능함
alter table tblEdit
    add (memo varchar2(100) not null);
```

<br>

- **컬럼 수정**
```sql
-- 자료형 수정 시 테이블이 비어있을 때 가능
alter table tblEdit
    modify (data varchar2(100));

-- 컬럼명 수정
alter table tblEdit
    rename column data to etc;
```

<br>

- **제약사항 추가**
```sql
alter table tblEdit
    add constraint tbledit_seq_pk primary key(seq);
    
alter table tblEdit
    add constraint tbledit_color_ck
        check (color in('red', 'yellow', 'blue'));
```

<br>

- **제약사항 삭제**
```sql
alter table tblEdit
    drop constraint tbledit_color_ck;
```

<Br>

- **컬럼 삭제**
```sql
alter table tblEdit drop column etc;
```

<br>

### ✅ DROP
- 테이블을 삭제
- A테이블이 B테이블을 참조한다면 A테이블을 먼저 삭제해야 한다.
```sql
drop table 테이블이름
```