
-- 일련 번호가 필요한 업무 > 순차적으로 증가하는 숫자가 필요한 업무
-- 오라클 전용

-- 계층형 쿼리
select
    level,
    prior name as "상사명",
    name as "직원명"
from tblSelf
    start with seq = 1
        connect by super = prior seq;
        

select
    level
from dual
    connect by level <= 10;
    
    
-- 2022-05-01 ~ 2022-05-31 > date형으로

-- 1. ANSI-SQL > 계층형 쿼리 사용!
-- 2. PL/SQL
-- 3. Java


select
    to_date('2022-05-01', 'yyyy-mm-dd') + (level - 1)
from dual
    connect by level <= 31;


-- 근태 상황(출석)
create table tblDate (
    seq number primary key,         -- 번호(PK)
    state varchar2(30) not null,    -- 정상|지각|조퇴
    regdate date not null           -- 날짜
);


--insert into tblDate values (1, '', '2022-03-01');
insert into tblDate values (2, '정상', '2022-03-02');
insert into tblDate values (3, '정상', '2022-03-03');
insert into tblDate values (4, '정상', '2022-03-04');
--insert into tblDate values (5, '', '2022-03-05');
--insert into tblDate values (6, '', '2022-03-06');
insert into tblDate values (7, '지각', '2022-03-07');
insert into tblDate values (8, '조퇴', '2022-03-08');
--insert into tblDate values (9, '', '2022-03-09');

insert into tblDate values (10, '정상', '2022-03-10');
insert into tblDate values (11, '정상', '2022-03-11');
--insert into tblDate values (12, '', '2022-03-12');
--insert into tblDate values (13, '', '2022-03-13');
insert into tblDate values (14, '지각', '2022-03-14');
-- insert into tblDate values (15, '정상', '2022-03-15'); -- 결석
insert into tblDate values (16, '지각', '2022-03-16');
insert into tblDate values (17, '정상', '2022-03-17');
insert into tblDate values (18, '정상', '2022-03-18');


select * from tblDate;

-- 요구사항 > 3월 1일 ~ 3월 18일까지 날짜와 함께 근태정보를 가져오시오.
--            *** 근태 기록이 없는 날짜도 다 같이 가져오시오.
--            *** 빠진 날짜 메꾸기


select
    to_date('2022-03-18', 'yyyy-mm-dd') - to_date('2022-03-01', 'yyyy-mm-dd')
from dual; -- 반복 횟수


-- 기억!! > date 자료형으로 원하는 기간의 레코드를 얻어오는 방법
create or replace view vwDate
as
select
    to_date('2022-03-01', 'yyyy-mm-dd') + (level - 1) as regdate
from dual
    connect by level <= to_date('2022-03-18', 'yyyy-mm-dd') - to_date('2022-03-01', 'yyyy-mm-dd') + 1;
    

select * from vwDate;
select * from tblDate;


select
    v.regdate,
    t.state
from vwDate v
    left outer join tblDate t
        on v.regdate = t.regdate
order by v.regdate;


-- 주말 처리(토,일)
select
    v.regdate,
    case
        when to_char(v.regdate, 'd') in (1) then '일요일'
        when to_char(v.regdate, 'd') in (7) then '토요일'
        else t.state
    end as state
from vwDate v
    left outer join tblDate t
        on v.regdate = t.regdate
order by v.regdate;


-- 공휴일 처리
-- 공휴일 정보를 담고있는 테이블 생성
create table tblHoliday (
    seq number primary key,
    regdate date not null,
    name varchar2(30) not null
);

insert into tblHoliday values (1, '2022-03-01', '삼일절');
insert into tblHoliday values (2, '2022-03-09', '대통령선거일');

select * from tblHoliday;

select
    v.regdate,
    case
        when to_char(v.regdate, 'd') in (1) then '일요일'
        when to_char(v.regdate, 'd') in (7) then '토요일'
        when t.state is null and h.name is not null then h.name
        when t.state is null and h.name is null then '결석'
        else t.state
    end as state
from vwDate v
    left outer join tblDate t
        on v.regdate = t.regdate
            left outer join tblHoliday h
                on v.regdate = h.regdate
order by v.regdate;




-- 복합키 생성

-- 복합키 > 조인하는 방법

-- 식별관계, 비식별관계

create table tblStudent (
    seq number primary key,
    name varchar2(30) not null
);


create table tblSubject (
    seq number primary key,
    name varchar2(30) not null
);


create table tblRegister(
    student_seq number,
    subject_seq number,
    
    constraint register_pk primary key(student_seq, subject_seq), -- 복합키
    constraint register_fk1 foreign key(student_seq) references tblStudent(seq),
    constraint register_fk2 foreign key(subject_seq) references tblSubject(seq)
);

create table tblScore(
    seq number primary key,
    score number not null,
    student_seq number not null,
    subject_seq number not null,
    
    constraint score_fk foreign key(student_seq, subject_seq) references tblRegister(student_seq, subject_seq)
    
);

insert into tblStudent values(1, '홍길동');
insert into tblStudent values(2, '아무개');
insert into tblStudent values(3, '하하하');

insert into tblSubject values (1, '자바');
insert into tblSubject values (2, '오라클');
insert into tblSubject values (3, 'JDBC');
insert into tblSubject values (4, 'JSP');
insert into tblSubject values (5, '스프링');

insert into tblRegister values (1, 1);
insert into tblRegister values (1, 2);
insert into tblRegister values (1, 3);
insert into tblRegister values (2, 2);
insert into tblRegister values (2, 4);
insert into tblRegister values (2, 5);
insert into tblRegister values (2, 1);
insert into tblRegister values (3, 2);
insert into tblRegister values (3, 5);

insert into tblScore values (1, 100, 1, 1);
insert into tblScore values (2, 90,  1, 2);
insert into tblScore values (3, 80,  1, 3);
insert into tblScore values (4, 70,  2, 2);
insert into tblScore values (5, 60,  3, 2);

select * from tblStudent;
select * from tblSubject;
select * from tblRegister;

-- 학생 정보 + 수강 정보 + 과목 정보
select
    st.name as "학생명",
    sb.name as "과목명",
    sc.score as "점수"
from tblStudent st
    inner join tblRegister r
        on st.seq = r.student_seq
            inner join tblSubject sb
                on sb.seq = r.subject_seq
                    inner join tblScore sc
                        on r.student_seq = sc.student_seq and r.subject_seq = sc.subject_seq; -- 두개의 복합키, 각 조건 명시

