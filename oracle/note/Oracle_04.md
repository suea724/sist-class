# 📌 Join
- 한 테이블의 행을 다른 테이블에 연결하여 두개 이상의 테이블을 결합하는 연산

<br>

### ✅ 종류
- **단순 조인, CROSS JOIN**
    - `SELECT 컬럼리스트 FROM 테이블A CROSS JOIN 테이블B;` 
    - 두 테이블의 **각각의 레코드에 대해 가능한 모든 결합**을 출력한다.
    - 결과셋 레코드 개수 = A 테이블 레코드 개수 x B 테이블 레코드 개수
    - 결과셋 컬럼 개수 = A 테이블 컬럼 개수 + B 테이블 컬럼 개수
```SQL
select * from tblCustomer cross join tbSales; -- ANSI-SQL
select * from tblCustomer, tblSales; -- Oracle에서만 사용 가능
```

<BR>

- **내부 조인, INNER JOIN** ⭐
    - `SELECT 컬럼리스트 FROM 테이블A INNER JOIN 테이블B ON 테이블A.PK = 테이블B.FK;`
    - 단순 조인에서 유효한 레코드만 추출한 조인
    - 두 테이블에 동시에 존재하는 데이터만 가져온다. (NULL 값이 있는 경우 X)
```SQL
select c.name, s.item 
from tblCustomer c 
    inner join tblSales s 
        on c.seq = s.cseq;
```

<BR>

- **외부 조인, OUTER JOIN** ⭐
    - `SELECT 컬럼리스트 FROM 테이블A (LEFT | RIGHT) OUTER JOIN 테이블B ON 테이블A.컬럼 = 테이블B.컬럼;`
    - 내부 조인의 결과 셋에 포함되지 못한 부모 테이블의 나머지 레코드를 포함하여 가져온다.
```SQL
-- 구매 이력과 상관없이, 고객정보와 함께 구매 이력을 가져오시오.
select 
    * 
from tblCustomer c 
    left outer join tblSales s 
        on c.seq = s.cseq;
```

<BR>

- **셀프 조인, SELF JOIN**
    - 하나의 테이블(자신)을 대상으로 조인
    - alias 반드시 필요함
```sql
-- 상사의 이름을 포함하여 직원 명단을 가져오시오. 
select 
    b.seq,
    b.name,
    b.department,
    a.name as "상사"
from tblSelf a                  -- 부모 테이블
    inner join tblSelf b        -- 자식 테이블
        on a.seq = b.super;
```

<BR>

- **전체 외부 조인, FULL OUTER JOIN**
    - 내부 조인의 결과 셋에 포함되지 못한 부모 테이블의 나머지 레코드를 포함하여 가져온다.
    - 서로 참조하고 있는 관계에서만 사용할 수 있는 조인
```sql
select
    *
from tblMan m
    full outer join
        tblWoman w
            on m.couple = w.name;
```
