
/*

    ex01 ~ ex12 : DML 기본
    
    [DDL]
    - 데이터 정의어
    - 데이터베이스 객체를 생성/수정/삭제한다.
    - 데이터베이스 객체 > 테이블, 뷰, 인덱스, 프로시저, 트리거, 제약 사항, 시노님
    - CREATE, ALTER, DROP
    
    
    테이블 생성하기 > 스키마 정의하기 > 속성(컬럼) 정의하기 > 속성(컬럼)의 성격(이름)과 도메인(자료형, 제약)을 정의
    
    CREATE TABLE 테이블명
    (
        컬럼 정의,
        컬럼 정의,
        컬럼 정의,
        컬럼 정의,
        컬럼 정의
        
        컬럼명 자료형(길이) NULL 제약사항
    );
    
    [제약사항, Constraint]
    - 해당 컬럼에 들어갈 데이터(값)에 대한 조건
        > 조건 만족 시 대입, 불만족시 에러 발생
    - 유효성 검사 도구
    - 데이터 무결성을 보장하기 위한 도구 ********
        
        
    1. NOT NULL
        - 해당 컬럼이 반드시 값을 가져야 한다.
    
    2. PRIMARY KEY, PK = 기본키
    
        - 테이블의 행을 구분하기 위한 제약사항 > 
        - 행을 식별하는 수많은 키들 중 대표로 지정한 키
        - 모든 테이블 안에는 반드시 1개의 기본키가 존재해야 함 ***********
        - 중복값을 가질 수 없다. (UNIQUE)
        - 값을 반드시 가진다. (NOT NULL)
    
    3. FOREIGN KEY
    
    4. UNIQUE
        - 유일하다. > 행들간 동일값을 가질 수 없다.
        - UNIQUE 제약은 null을 가질 수 있다. > 식별자가 될 수 없다.
        
        e.g. 경품
            - 고객(번호(PK), 이름, 주소, 당첨(UQ)) 
                1,홍길동,서울,1등
                2,아무개,부산,NULL
                3,하하하,서울,2등
                4,호호호,경기,3등
                5,후후후,제주,NULL
                
        e.g. 초등학교 교실
            - 학생(번호(PK), 이름, 직책(UQ))
                1,홍길동,반장
                2,아무개,NULL
                3,하하하,부반장
                4,호호호,체육부장
                5,후후후,NULL
    
    5. CHECK
        - 사용자 정의 제약 조건
        - where절과 동일하게 조건을 컬럼에 적용한다.
        
    
    6. DEFAULT
        - 기본값 설정
        - insert/update 작업 시 컬럼값을 넣어주지 않으면(null을 넣으면) null 대신 미리 설정한 값을 입력한다.
    

*/

-- 메모 테이블

create table tblMemo(

    -- 컬럼명 자료형(길이) NULL 제약사항
    
    -- default : 뒤에 null 생략 > null값 허용
    seq number(3),      -- 메모번호
    name varchar2(30),   -- 작성자
    memo varchar2(1000),  -- 메모
    regdate date        -- 작성 날짜
    
);

select * from tblMemo;


-- insert into 테이블(컬럼리스트) values (값리스트);
insert into tblMemo(seq, name, memo, regdate) values (1, '홍길동', '메모입니다.', sysdate);
insert into tblMemo(seq, name, memo, regdate) values (2, '아무개', null, sysdate);
insert into tblMemo(seq, name, memo, regdate) values (3,  null, null, null);
insert into tblMemo(seq, name, memo, regdate) values (null, null, null, null); -- 의미 없는 데이터
insert into tblMemo(seq, name, memo, regdate) values (4,  '홍길동', '테스트', '2022-01-01'); -- 날짜 암묵적 형변환 발생
insert into tblMemo(seq, name, memo, regdate) values (5,  '홍길동', '테스트', to_date('2022-01-01 12:30:00', 'yyyy-mm-dd hh24:mi:ss')); -- 날짜 + 시분초 > to_date() 함수 사용


-- NOT NULL
drop table tblMemo;

create table tblMemo(

    -- 컬럼명 자료형(길이) NULL 제약사항
    
    seq number(3) not null,         -- 메모번호(NN)
    name varchar2(30),              -- 작성자
    memo varchar2(1000) not null,   -- 메모(NN)
    regdate date                     -- 작성 날짜
    
);


insert into tblMemo(seq, name, memo, regdate) values (1, '홍길동', '메모입니다.', sysdate);

-- not null 설정한 컬럼에 null값을 넣는 경우 > ORA-01400: cannot insert NULL into ("HR"."TBLMEMO"."MEMO")
insert into tblMemo(seq, name, memo, regdate) values (2, '홍길동', null, sysdate);
insert into tblMemo(seq, name, memo, regdate) values (2, '홍길동', '', sysdate); -- 빈문자열도 null로 취급!!

select * from tblMemo;


-- PRIMARY KEY
drop table tblMemo;

create table tblMemo(

    -- 컬럼명 자료형(길이) NULL 제약사항
    
    seq number(3) primary key,      -- 메모번호(PK > NOT NULL 포함)
    name varchar2(30),              -- 작성자
    memo varchar2(1000) not null,   -- 메모(NN)
    regdate date                     -- 작성 날짜
    
);

insert into tblMemo(seq, name, memo, regdate) values (1, '홍길동', '메모입니다.', sysdate);

-- ORA-00001: unique constraint (HR.SYS_C007102) violated > UNIQUE 위반
insert into tblMemo(seq, name, memo, regdate) values (1, '홍길동', '메모입니다.', sysdate); 

-- ORA-01400: cannot insert NULL into ("HR"."TBLMEMO"."SEQ") > NOT NULL 위반
insert into tblMemo(seq, name, memo, regdate) values (null, '홍길동', '메모입니다.', sysdate);


insert into tblMemo(seq, name, memo, regdate) values (2, '홍길동', '메모입니다.', sysdate); 
select * from tblMemo;


-- UNIQUE
drop table tblMemo;

create table tblMemo(

    -- 컬럼명 자료형(길이) NULL 제약사항
    
    seq number(3) primary key,      -- 메모번호(PK)
    name varchar2(30) unique,        -- 작성자(UQ)
    memo varchar2(1000) not null,   -- 메모(NN)
    regdate date                    -- 작성 날짜
    
);

insert into tblMemo(seq, name, memo, regdate) values (1, '홍길동', '메모입니다.', sysdate); 
insert into tblMemo(seq, name, memo, regdate) values (2, '홍길동', '메모입니다.', sysdate); -- 이름 중복 > 삽입 불가
insert into tblMemo(seq, name, memo, regdate) values (3, NULL, '메모입니다.', sysdate); -- NULL 값 삽입 가능
insert into tblMemo(seq, name, memo, regdate) values (4, NULL, '메모입니다.', sysdate); -- NULL 값 삽입 가능
insert into tblMemo(seq, name, memo, regdate) values (5, NULL, '메모입니다.', sysdate); -- NULL 값 삽입 가능

select * from tblMemo;



-- CHECK
drop table tblMemo;

create table tblMemo(

    -- 컬럼명 자료형(길이) NULL 제약사항
    
    seq number(3) primary key,                                                        -- 메모번호(PK)
    name varchar2(30),                                                                -- 작성자
    memo varchar2(1000),                                                               -- 메모(NN)
    regdate date,                                                                      -- 작성 날짜
    priority number check (priority between 1 and 3),                                  -- 1(중요), 2(보통), 3(안중요)
    category varchar(30) check(category in('할일', '장보기', '공부', '가족', '친구'))  -- 할일, 장보기, 공부, 가족, 친구
);



insert into tblMemo values (1, '홍길동', '메모입니다.', sysdate, 1, '할일');

-- ORA-02290: check constraint (HR.SYS_C007106) violated
insert into tblMemo values (2, '홍길동', '메모입니다.', sysdate, 5, '할일'); 
insert into tblMemo values (2, '홍길동', '메모입니다.', sysdate, 2, '코딩');

-- check 조건은 null 값 제한X > not null 조건이 없기 때문!
insert into tblMemo values (2, '홍길동', '메모입니다.', sysdate, 2, null);
insert into tblMemo values (3, '홍길동', '메모입니다.', sysdate, null, null);

select * from tblMemo;



-- DEFAULT
drop table tblMemo;

create table tblMemo(

    -- 컬럼명 자료형(길이) NULL 제약사항
    
    seq number(3) primary key,              -- 메모번호(PK)
    name varchar2(30) default '익명',       -- 작성자
    memo varchar2(1000),                    -- 메모
    regdate date default sysdate            -- 작성 날짜(default 값 설정)
    
);

insert into tblMemo values (1, '홍길동', '메모입니다', sysdate);
insert into tblMemo values (2, null, '메모입니다', sysdate); -- null값이 들어감 > 개발자의 의도 표현O

-- 소극적인 default 실행 방법
insert into tblMemo(seq, memo,regdate) values (3, '메모입니다', sysdate); -- name을 넣지 않는 경우 > 개발자의 의도 표현X

-- 적극적인 default 실행 방법
insert into tblMemo values (4, default, '메모입니다', sysdate); -- default 상수 사용

select * from tblMemo;

insert into tblMemo(seq, name, memo) values (6, '홍길동', '메모입니다'); -- 현재 시간 입력됨



-- DDL > 테이블 생성 > 컬럼 생성 = 컬럼명 + 자료형(길이) + 제약사항

/*

    [제약 사항을 만드는 방법]
    
    1. 컬럼 수준에서 만드는 방법
        - 컬럼을 정의할 때 제약 사항도 같이 정의
        
    2. 테이블 수준에서 만드는 방법
        - 컬럼 정의와 제약 사항 정의를 분리시킨 방법
        - 제약 사항만 따로 정의 > 관리 차원 > 코드 분리
        - not null, default > 컬럼 수준에서만 정의
        
    3. 외부에서 만드는 방법
        - ALTER 사용
*/


drop table tblMemo;

create table tblMemo(
    
    -- not null은 컬럼 수준에서만 정의할 수 있음
    seq number(3) not null,             
    name varchar2(30),     
    memo varchar2(1000),                   
    regdate date,
    
    -- 테이블 수준의 제약사항 정의
    -- 제약사항 명 : 테이블명_컬럼명_제약사항
    constraint tblmemo_seq_pk primary key(seq),
    constraint tblmemo_name_uq unique(name),
    constraint tblmemo_memo_ck check(length(memo) >= 10));

-- ORA-00001: unique constraint (HR.TBLMEMO_SEQ_PK) violated
insert into tblMemo values (1, '홍길동', '메모입니다 메모입니다', sysdate);


