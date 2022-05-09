# 📌 PL/SQL
- Procedural Language/Structured Query Language
- 기존의 ANSI-SQL에 절차지향 언어의 기능(제어)을 추가한 SQL

### ✅ ANSI-SQL
- 비절차지향 언어로 문장의 순서가 없고 연속적이지 않다.
- 문장 단위 구조

<br>

### ✅ 프로시저, Procedure
- 작업 순서가 정해진 독립된 프로그램의 수행 단위
- PL/SQL은 프로그램 로직을 프로시저로 구현하여 객체 형태로 사용한다.
- PL/SQL 명령어는 반드시 프로시저 내에서만 작성 및 동작이 가능하다.
- **익명 프로시저**
    - 1회용 코드 작성용
- **저장 프로시저**
    - 재사용 가능 
    - 데이터베이스에 이름을 가진 객체로 저장된다.

<br>

### ✅ 프로시저 블럭 구조
```SQL
declare 
    num number;
    name varchar2(20);
    today date;
begin
    num := 10;
    dbms_output.put_line(num);
    
    name := '홍길동';
    dbms_output.put_line(name);
    
    today := sysdate;
    dbms_output.put_line(today);

exception
    -- when 예외상수 then
    when others then
        dbms_output.put_line('예외 처리');
end;
```
#### 1️⃣ DECLARE
- 선언부
- 프로시저에서 사용할 변수, 객체 등을 선언하는 영역
- `변수명 자료형 [NOT NULL] [DEFAULT 값]`
#### 2️⃣ BEGIN ~ END
- 구현부
- 구현된 코드를 작성하는 영역 (메서드의 body)
- 생략 불가능
#### 3️⃣ EXCEPTION
- 예외 처리부
- 실행 부에서 발생하는 예외를 처리하는 블럭(catch)
- 생략 가능

<BR>

### ✅ SELECT INTO 절
``` SQL
declare
    vname varchar2(15);
    vbuseo varchar2(15);
    vjikwi varchar2(15);
begin
    -- vname := (select name from tblInsa where num = 1001);
    select name into vname from tblInsa where num = 1001;
    select name, buseo, jikwi into vname, vbuseo, vjikwi from tblInsa where num = 1001;
    dbms_output.put_line(vname);
end;
```
- 변수에 SELECT 결과값을 담을 수 있다.
- PL/SQL 블럭 안에는 절대로 일반 SELECT문을 작성할 수 없고, SELECT INTO 절을 사용해야 한다.
- 변수에 값을 넣을 때 컬럼의 개수, 순서, 자료형이 변수의 개수, 순서, 자료형과 일치해야 한다.

<BR>

### ✅ 타입 참조
```sql
declare
    vbuseo tblInsa.buseo%type;
    vrow tblInsa%rowtype;
begin
    select buseo into vbuseo from tblInsa where num = 1001;
    select * into vrow from tblInsa where num = 1001; -- 와일드 카드 사용

    dbms_output.put_line(vbuseo);
    dbms_output.put_line(vrow.num);
    dbms_output.put_line(vrow.name);
    dbms_output.put_line(vrow.ssn);
    dbms_output.put_line(vrow.buseo);
    dbms_output.put_line(vrow.basicpay);
end;
```
- 변수 선언 시 사용한다.
- 원본 테이블의 컬럼이 변경되면 반영된다.
- **%type**
    - 컬럼 1개의 자료형, 길이 참조
    - 사용하는 테이블의 특정 컬럼의 스키마를 변수에 적용한다.
- **%rowtype**
    - 행 전체 참조(모든 컬럼 참조)

<br>

### ✅ 제어문
#### 👉 조건문
- if-elsif-else문
```sql
declare
    vnum number := 0;
begin
    if vnum > 0 then
        dbms_output.put_line('양수');
    elsif vnum < 0 then
        dbms_output.put_line('음수');
    else
        dbms_output.put_line('0');
    end if;
end;
```
- case문
```sql
declare
    vcontinent tblCountry.continent%type;
    vresult varchar2(30);
begin
    -- case문 (다중 if문과 비슷)
    case
        when vcontinent = 'AS' then vresult := '아시아';
        when vcontinent = 'EU' then vresult := '유럽';
        when vcontinent = 'AF' then vresult := '아프리카';
        else vresult := '기타';
    end case;
    
    dbms_output.put_line(vresult);
    
    
    -- case문 (자바의 switch문과 비슷) 
    case vcontinent
        when 'AS' then vresult := '아시아';
        when 'EU' then vresult := '유럽';
        when 'AF' then vresult := '아프리카';
        else vresult := '기타';
    end case;
    
    dbms_output.put_line(vresult);
    
end;
```

#### 👉 반복문
- loop : 단순 반복
```sql
declare
    vnum number := 1;
begin
    loop
        dbms_output.put_line(to_char(sysdate, 'hh24:mi:ss'));
        vnum := vnum + 1;
        exit when vnum > 10; -- 조건 만족 시 Loop 탈출
    end loop;
end;
```
- for loop : 횟수 반복
```sql
begin
    for i in 1..10 loop
        dbms_output.put_line(i);
    end loop;
end;
```
- while loop : 조건 반복
```sql
declare
    vnum number := 1;
begin
    while vnum <= 10 loop
        dbms_output.put_line(vnum);
        vnum := vnum + 1;
    end loop;
end;
```

<br>

### ✅ CURSOR
- SQL문의 실행 결과의 레코드가 N개일 때 사용
- loop 사용
```SQL
declare
    cursor vcursor is select name from tblInsa; -- 커서 선언
    vname tblInsa.name%type; -- 변수 선언
begin
    open vcursor; -- 커서 열기
        loop
            fetch vcursor into vname; -- 한 행씩 변수에 대입
            exit when vcursor%notfound; -- 행이 존재하지 않을 때 LOOP 탈출
            dbms_output.put_line(vname);
        end loop;
    close vcursor; -- 커서 닫기
end;
```
- forloop 사용
```sql
declare
    cursor vcursor is select * from tblInsa;
begin
    for vrow in vcursor loop -- loop + fetch into + vrow 선언 + exit when
        dbms_output.put_line(vrow.name);
    end loop;
end;
```

<br>

### ✅ 저장 프로시저, Stored Procedure
```sql
-- 1. 저장 프로시저 선언
create or replace procedure procTest
is
    vnum number;
begin
    vnum := 100;
    dbms_output.put_line(vnum);
end;

-- 2. 저장 프로시저 호출
begin -- 익명 블럭 필요
    procTest; -- 프로시저 실행(호출)
end;
```
- 오라클 서버에 컴파일 된 프로시저가 저장됨
- 저장되어 있는 프로시저를 호출 시, 구문 분석 및 컴파일 작업을 생략할 수 있기 때문에 비용이 절감된다.
- 첫번째 실행 비용 > 재실행 비용

<br>

#### 👉 매개변수가 있는 프로시저
- 숫자형 매개변수
```sql
create or replace procedure procTest(
    width number,
    height number
)
is
    vresult number;
begin
    vresult := width * height;
    dbms_output.put_line(vresult);
end procTest;
begin
    procTest(10, 20); -- 200
end;
```
- 문자형 매개변수
    - 프로시저의 매개변수에는 길이와 not null을 표현할 수 없다.
```sql
create or replace procedure procTest(
    name varchar2
)
is
begin
    dbms_output.put_line('안녕하세요. ' || name || '님');
end procTest;


begin
    procTest('홍길동');
end;
```

<br>

#### 👉 매개변수 모드
- 매개변수가 값을 전달하는 방식
- **in모드(기본)** : 프로시저 내부에서 사용하기 위한 변수
- **out 모드** : 프로시저 외부로 반환하기 위한 변수
- **단일값**을 반환하는 Out 파라미터
```sql
create or replace procedure procTest (
    pnum1 in number,
    pnum2 in number,
    presult1 out number, -- 변수 자체를 매개변수로 받음 > 주소값을 받아옴 > 반환값 역할
    presult2 out number,
    presult3 out number
)
is
begin
    presult1 := pnum1 + pnum2;
    presult2 := pnum1 - pnum2;
    presult3 := pnum1 * pnum2;
    dbms_output.put_line('프로시저 실행 완료');
end;


declare
    vresult1 number;
    vresult2 number;
    vresult3 number;
begin
    procTest(10, 20, vresult1, vresult2, vresult3);
    dbms_output.put_line(vresult1);
    dbms_output.put_line(vresult2);
    dbms_output.put_line(vresult3);
end;
```
- **다중값**을 반환하는 Out 파라미터 > cursor 사용
```sql
create or replace procedure procBuseo(
    pbuseo in varchar2,
    pcursor out sys_refcursor -- 커서를 반환값으로 사용할 때 자료형
)
is
begin
    open pcursor 
    for
    select * from tblInsa where buseo = pbuseo; -- 커서 정의
end procBuseo;

declare
    vcursor sys_refcursor; -- 커서 참조 변수
    vrow tblInsa%rowtype;
begin
    procBuseo('영업부', vcursor);
    loop
        fetch vcursor into vrow;
        exit when vcursor%notfound;
        dbms_output.put_line(vrow.name);
    end loop;
end;
```

<br>

### ✅ 저장 함수, Stored Function
```sql
-- 두 수의 합 반환하는 저장 함수
-- 1. 선언
create or replace function fnSum (
    pnum1 in number,
    pnum2 in number    
) return number
is
begin
    return pnum1 + pnum2;
end fnSum;

-- 2. 호출
declare
    vresult number;
begin
    vresult := fnSum(10, 20);
    dbms_output.put_line(vresult);
end;
```
- 저장 프로시저와 유사하다.
- **반환값이 반드시 존재**한다. (out 파라미터가 아닌 return 문 사용)
- 주로 ANSI-SQL에서 반복되는 작업을 줄이기 위해 사용한다. ⭐
- 프로시저(PL/SQL) vs 함수(ANSI-SQL)

<br>

#### 👉 함수 사용 vs 미사용
```sql
-- 이름, 부서, 직위, 성별(남자, 여자)

create or replace function fnGender(
    pssn varchar2
) return varchar2
is 
begin
    return case
        when substr(pssn, 8,1) = '1' then '남자'
        when substr(pssn, 8,1) = '2' then '여자'
    end;
end;

-- 함수 미사용
    -- 생산 고비용
    -- 호출 고비용
    -- 개발자 가독성 + 조작성 저하 > 유지보수성 저하
    -- 협업시 bad
select
    name, buseo, jikwi,
    case
        when substr(ssn, 8,1) = '1' then '남자'
        when substr(ssn, 8,1) = '2' then '여자'
    end
from tblInsa;


-- 함수 사용
    -- 생산 저비용
    -- 호출 저비용
    -- 개발자 가독성 + 조작성 향상 > 유지보수성 향상
    -- 협업시 good
select
    name, buseo, jikwi,fnGender(ssn)
from tblInsa;
```

<br>

### ✅ 트리거, Trigger
```sql
create or replace trigger 트리거명
    before|after
    insert|update|delete on 테이블명
    [for each row]
declare
    선언부;
begin
    실행부;
exception
    예외처리부;
end;
```
- 프로시저의 한 종류로, 미리 지정한 이벤트 발생 시 자동으로 실행된다.
- 특정 테이블에서 **insert, update 또는 delete 발생 시, 지정한 트리거가 실행**된다. (오라클이 특정 테이블을 감시
- **부하가 발생**한다는 단점이 있다.
- 특정 테이블에 여러 개의 트리거가 적용되어 있으면 관리가 어려우므로 사용하지 않는 트리거는 삭제해주는 것이 좋다.

<br>

#### 👉 before 트리거
- **트리거 실행 후, 쿼리가 실행**된다.
- 쿼리를 사전에 검사하여 조건에 따라 쿼리 실행 유무를 통제할 수 있다.
```sql
create or replace trigger trgInsa
    before delete on tblInsa
begin
    -- 월요일에는 퇴사가 불가능
    if to_char(sysdate, 'dy') = '월' then
    
        -- 현재 진행하려던 업무 (delete 실행 전) > 취소 > 강제로 예외 발생
        -- throw new Exception()
        -- -20000 ~ -29999
        raise_application_error(-20001, '월요일에는 퇴사가 불가능합니다.');
    end if;
end;

delete from tblInsa where num = 1005;
```

<br>

#### 👉 after 트리거
- **쿼리 실행 후, 트리거가 실행**된다.
- 주로 후처리 작업 시 사용된다. e.g. 로그
```sql
-- 쿼리문 실행할 때마다 로그 테이블에 기록
create or replace trigger trgLogMan
    after
    insert or update or delete -- 세 가지 조작에 대한 트리거
    on tblMan
declare
    vmessage varchar2(1000);
begin
    -- insert or update or delete 구분
    if inserting then 
        vmessage := '새로운 항목이 추가되었습니다.';
    elsif updating then
        vmessage := '새로운 항목이 수정되었습니다.';
    elsif deleting then
        vmessage := '기존 항목이 삭제되었습니다.';
    end if;
    
    insert into tblLogMan values (seqLogMan.nextVal, vmessage, default);
end;

insert into tblMan values ('테스트', 22, 175, 60, null);
update tblMan set weight = 65 where name = '테스트';
delete from tblMan where name = '테스트';
```

<br>

#### 👉 for each now
- 트리거의 옵션
- **사용하지 않을 경우**
    - 문장(Query) 단위 트리거
    - 사건이 적용되는 레코드의 개수와 상관없이 트리거는 1회 호출된다.
    - 적용된 레코드의 정보가 중요하지 않은 경우 (사건 자체가 중요)
- **사용하는 경우**
    - 행(Record) 단위 트리거
    - 사건이 적용되는 레코드의 개수만큼 트리거가 반복 호출된다.
    - 적용된 레코드의 정보가 중요한 경우
- **상관 관계(:old, :new)를 사용**한다. > 일종의 가상 레코드
    - insert > :new (방금 추가된 행 참조)
    - update > :old (수정되기 전 행 참조), :new (수정된 후 행 참조)
    - delete > :old (삭제되기 전 행 참조)
```sql
-- update 트리거 상관 관계 사용
create or replace trigger trgMan
    after update on tblMan for each row
begin
    dbms_output.put_line('레코드를 수정했습니다. - ' || :old.name);
    dbms_output.put_line('수정하기 전 나이 - ' || :old.age);
    dbms_output.put_line('수정한 후 나이 - ' || :new.age);
end;

update tblMan set age = age + 1 where couple is not null;


-- 직원 퇴사 전 담당 프로젝트 자동 위임
create or replace trigger trgDeleteStaff
    before delete on tblStaff for each row -- 직원 테이블에서 퇴사 전에 해당 직원 정보
begin
    update tblProject set
        staff_seq = 4
            where staff_seq = :old.seq; -- 삭제되는 직원의 seq값
end;

delete from tblStaff where seq = 2;
```







