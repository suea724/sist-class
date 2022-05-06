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
- in모드(기본), out 모드
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
