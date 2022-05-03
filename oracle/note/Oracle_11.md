# 📌 View, 뷰
- 실제 테이블처럼 사용할 수 있는 **가상의 테이블**로, 데이터베이스 객체 중 하나 (DDL 사용)
- **쿼리의 양을 줄이기 위해 사용**한다. <br>→ 반복된 SELECT 또는 긴 SELECT에 사용
- 뷰는 **쿼리문(SQL)을 저장한 객체**이다. (데이터 저장 X) <br> → 원본 테이블에 변경 발생 시 반영됨
- 뷰는 **읽기 전용 테이블**로 SELECT 외 다른 DML을 사용하지 않는다.

<br>

### ✅ 뷰 생성 또는 수정
```sql
CREATE (OR REPLACE) VIEW 뷰 이름
AS
SELECT 문;
```

<br>

- 뷰 생성
```SQL
create view vwInsa
as
select * from tblInsa;
```

<br>

- 뷰 수정
```sql
create or replace view vwInsa
as
select * from tblInsa where buseo = '영업부';

select * from vwInsa;
```


<br>

### ✅ 뷰 삭제
```sql
DROP VIEW 뷰 이름;
```

<br>

### ✅ 뷰 활용

- 복잡한 쿼리에 사용
```sql
-- 모든 회원의 반납 여부를 확인할 수 있는 뷰 생성
create or replace view "대여 체크"
as
select
    m.name as mname,
    v.name as vname,
    to_char(r.rentdate, 'yyyy-mm-dd') as rentdate,
    case
        when r.retdate is not null then '완료'
        else '미완료'
    end as state
from tblRent r
    inner join tblVideo v
        on v.seq = r.video
            inner join tblMember m
                on m.seq = r.member;

select * from "대여 체크";
```

<br>

- 계정별로 객체에 대해 접근/조작을 통제
```sql
create or replace view 신입전용
as
select num, name, ssn, city from tblInsa;

select * from tblInsa;   -- 신입. tblInsa 접근 권한 X
select * from 신입전용;  -- 신입. view 접근 권한 O
```