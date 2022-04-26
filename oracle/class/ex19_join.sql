
/*
    
    관계형 데이터베이스 시스템이 지양하는 것들
    -> 테이블을 다시 수정해야 고쳐짐
    
    1. 테이블에 기본키가 없는 상태
    2. null이 많은 상태의 테이블 > 공간 낭비
    3. 데이터가 중복되는 상태 > 공간 낭비 + 데이터 관리 곤란
    4. 하나의 속성값이 원자값이 아닌 상태 > 더이상 쪼개지지 않는 값을 넣어야 한다.


*/

-- Ver. 1
-- 직원 정보
-- 직원(번호, 직원명, 급여, 거주지, 담당 프로젝트)
create table tblStaff (
    seq number primary key,         -- 직원번호(PK)
    name varchar2(30) not null,     -- 직원명
    salary number not null,         -- 급여
    address varchar2(300) not null, -- 거주지
    project varchar2(300) null      -- 담당 프로젝트
);

insert into tblStaff(seq, name, salary, address, project)
    values(1, '홍길동', 300, '서울시', '홍콩 수출');
    
insert into tblStaff(seq, name, salary, address, project)
    values(2, '아무개', 250, '인천시', 'TV 광고');
    
insert into tblStaff(seq, name, salary, address, project)
    values(3, '하하하', 350, '의정부시', '매출 분석');
    
-- '홍길동'에게 담당 프로젝트 1건 추가 > 고객 관리
insert into tblStaff(seq, name, salary, address, project)
    values(4, '홍길동', 300, '서울시', '고객 관리');
    
-- '호호호' 직원 추가 + '게시판 관리, 회원 응대'
insert into tblStaff(seq, name, salary, address, project)
    values (5, '호호호', 250, '서울시', '게시판 관리, 회원 응대');
    
select * from tblStaff;

-- 'TV 광고' 담당자 호출
select * from tblStaff where project = 'TV 광고';

-- 'TV 광고' > 'SNS 광고'
update tblStaff set project = 'SNS 광고' where project = 'TV 광고'; -- 맞을 때가 있고, 틀릴 때가 있음!

-- '회원 응대' 담당자 호출
-- 문제점 > 원자값이 아닌 데이터가 존재한다!!!!
select * from tblStaff where project = '회원 응대';
select * from tblStaff where instr(project, '회원 응대') > 0;

-- '회원 응대' > '고객 불만 대응'
-- 기존에 저장되어 있던 '게시판 관리' 날아감
update tblStaff set project = '고객 불만 대응' where instr(project, '회원 응대') > 0;

-- '홍길동' > 연봉 인상 > 350만원
update tblStaff set salary = 350 where seq = 1;
select * from tblStaff;

-- '홍길동' 급여 확인
-- 문제!! 같은 데이터가 2번 이상 저장됨
select * from tblStaff where name = '홍길동';




-- 테이블 설계 다시 > 프로젝트 테이블 따로 생성
drop table tblStaff;
drop table tblProject;

-- Ver. 2 > 테이블 분리
-- 직원 정보
-- 직원(번호(PK), 직원명, 급여, 거주지)
create table tblStaff (
    seq number primary key,         -- 직원번호(PK)
    name varchar2(30) not null,     -- 직원명
    salary number not null,         -- 급여
    address varchar2(300) not null -- 거주지
);

-- 1 정규화 (복합값 -> 원자값)
create table tblProject (
    seq number primary key,         -- 프로젝트 번호
    project varchar2(30) not null,  -- 프로젝트 명
    staff_seq number not null       -- 직원 번호
);

insert into tblStaff (seq, name, salary, address) values (1, '홍길동', 300, '서울시');
insert into tblStaff (seq, name, salary, address) values (2, '아무개', 250, '인천시');
insert into tblStaff (seq, name, salary, address) values (3, '하하하', 350, '부산시');

insert into tblProject (seq, project, staff_seq) values (1, '홍콩 수출', 1);
insert into tblProject (seq, project, staff_seq) values (2, 'TV 광고', 2);
insert into tblProject (seq, project, staff_seq) values (3, '매출 분석', 3);
insert into tblProject (seq, project, staff_seq) values (4, '노조 협상', 1);
insert into tblProject (seq, project, staff_seq) values (5, '대리점 분양', 2);

-- 1. 원자값 보장 (콤마로 연결되는 데이터 X)
-- 2. 데이터 중복 X
select * from tblStaff;
select * from tblProject;

-- A. 신입 사원 입사 > 신규 프로젝트 담당
-- A.1 신입 사원 추가
insert into tblStaff (seq, name, salary, address) values (4, '호호호', 250, '성남시');

-- A.2 신규 프로젝트 추가
insert into tblProject (seq, project, staff_seq) values (6, '자재 매입', 4);

-- A.3 신규 프로젝트 추가
-- FK 제약사항 추가시 오류 > ORA-02291: integrity constraint (HR.SYS_C007161) violated - parent key not found
insert into tblProject (seq, project, staff_seq) values (7, '고객 유치', 5); -- 5번 직원은 존재하지 않음! 논리 오류

-- '고객 유치' 담당자 알아내기
select * from tblStaff where seq = (select staff_seq from tblProject where project = '고객 유치');



-- B. '홍길동' 퇴사
-- B.1 '홍길동' 삭제
-- FK 제약사항 추가시 오류 > ORA-02292: integrity constraint (HR.SYS_C007161) violated - child record found
delete from tblStaff where seq = 1; -- > 프로젝트

select * from tblStaff;
select * from tblProject;


-- B.2 '아무개' 퇴사 > 인수 인계(위임)
update tblProject set staff_seq = 3 where staff_seq = 2;

update tblProject 
set staff_seq = (select seq from tblStaff where name = '하하하')
where staff_seq = (select seq from tblStaff where name = '아무개');

-- B.3 '아무개' 퇴사 > 삭제
delete from tblStaff where seq = 2;

select * from tblStaff;
select * from tblProject where staff_seq = 1;



drop table tblStaff;
drop table tblProject;

-- Ver. 3 > FK 추가 > 두 테이블 간 물리적인 관계를 맺음
-- 부모 테이블이 먼저 생성되어야 함 (참조 당하는 쪽)

-- 직원 정보
-- 직원(번호(PK), 직원명, 급여, 거주지)
create table tblStaff (
    seq number primary key,         -- 직원번호(PK)
    name varchar2(30) not null,     -- 직원명
    salary number not null,         -- 급여
    address varchar2(300) not null -- 거주지
); -- 부모 테이블

create table tblProject (
    seq number primary key,                                 -- 프로젝트 번호
    project varchar2(30) not null,                          -- 프로젝트 명
    staff_seq number not null references tblStaff(seq)       -- 직원 번호
); -- 자식 테이블

-- A, B 시나리오 다시 실행




-- 고객 테이블 > 부모 테이블
create table tblCustomer (
    seq number primary key,         -- 고객번호(PK)
    name varchar2(30) not null,     -- 고객명
    tel varchar2(15) not null,      -- 연락처
    address varchar2(100) not null   -- 주소
);

-- 판매내역 테이블 > 자식 테이블
create table tblSales (
    seq number primary key,                             -- 판매번호(PK)
    item varchar2(50) not null,                         -- 제품명
    qty number not null,                                -- 판매수량
    regdate date default sysdate not null,              -- 판매날짜
    cseq number not null references tblCustomer(seq)   -- 판매한 고객번호(FK)
);

select * from tblCustomer;
select * from tblSales;

drop table tblGenre;
drop table tblVideo;
drop table tblMember;
drop table tblRent;

-- [비디오 대여점]

-- 장르 테이블
create table tblGenre (
    seq number primary key,         -- 장르 번호(PK)
    name varchar2(30) not null,     -- 장르명
    price number not null,          -- 대여 가격
    period number not null          -- 대여기간(일)
);

-- 비디오 테이블
create table tblVideo (
    seq number primary key,                          -- 비디오 번호(PK)
    name varchar2(100) not null,                     -- 비디오 제목
    qty number not null,                             -- 비디오 수량
    company varchar2(50) null,                   -- 제작사
    director varchar2(50) null,                  -- 감독
    major varchar2(50) null,                     -- 주연배우
    genre number not null references tblGenre(seq)   -- 장르 번호(FK)
);

-- 고객 테이블
create table tblMember (
    seq number primary key,         -- 고객번호(PK)
    name varchar2(30) not null,     -- 고객명
    grade number(1) not null,       -- 고객 등급(1,2,3)
    byear number(4) not null,       -- 생년
    tel varchar2(15) not null,      -- 연락처
    address varchar2(300) null,  -- 주소
    money number not null           -- 예치금
);

-- 대여 테이블
create table tblRent (
    seq number primary key,                             -- 대여번호(PK)
    member number not null references tblMember(seq),   -- 회원번호(FK)
    video number not null references tblVideo(seq),      -- 비디오번호(FK)
    rentdate date default sysdate not null,             --  대여시각
    retdate date null,                                  -- 반납시각
    remark varchar2(500) null                           -- 비고

);

-- 테이블 관계
-- 장르 <- 비디오 <- 대여 -> 고객



-- 장르 데이터
INSERT INTO tblGenre VALUES (1, '액션',1500,2);
INSERT INTO tblGenre VALUES (2, '에로',1000,1);
INSERT INTO tblGenre VALUES (3, '어린이',1000,3);
INSERT INTO tblGenre VALUES (4, '코미디',2000,2);
INSERT INTO tblGenre VALUES (5, '멜로',2000,1);
INSERT INTO tblGenre VALUES (6, '기타',1800,2);




-- 비디오 데이터
INSERT INTO tblVideo (seq, Name, qty, Company, Director, Major, Genre) VALUES (1, '영구와 땡칠이',5,'영구필름','심영래','땡칠이',3);
INSERT INTO tblVideo (seq, Name, qty, Company, Director, Major, Genre) VALUES (2, '어쭈구리',5,'에로 프로덕션','김감독','박에로',2);
INSERT INTO tblVideo (seq, Name, qty, Company, Director, Major, Genre) VALUES (3, '털미네이터',3,'파라마운트','James','John',1);
INSERT INTO tblVideo (seq, Name, qty, Company, Director, Major, Genre) VALUES (4, '육복성',3,'대만영화사','홍군보','생룡',4);
INSERT INTO tblVideo (seq, Name, qty, Company, Director, Major, Genre) VALUES (5, '뽀뽀할까요',6,'뽀뽀사','박감독','최지후',5);
INSERT INTO tblVideo (seq, Name, qty, Company, Director, Major, Genre) VALUES (6, '우정과 영혼',2,'파라마운트','James','Mike',5);
INSERT INTO tblVideo (seq, Name, qty, Company, Director, Major, Genre) VALUES (7, '주라기 유원지',1,NULL,NULL,NULL,1);
INSERT INTO tblVideo (seq, Name, qty, Company, Director, Major, Genre) VALUES (8, '타이거 킹',4,'Walt','Kebin','Tiger',3);
INSERT INTO tblVideo (seq, Name, qty, Company, Director, Major, Genre) VALUES (9, '텔미 에브리 딩',10,'영구필름','강감독','심으나',5);
INSERT INTO tblVideo (seq, Name, qty, Company, Director, Major, Genre) VALUES (10, '동무',7,'부산필름','박감독','장동근',1);
INSERT INTO tblVideo (seq, Name, qty, Company, Director, Major, Genre) VALUES (11, '공동경쟁구역',2,'뽀뽀사','박감독','이병흔',1);




-- 회원 데이터
INSERT INTO tblMember (seq, Name,Grade,Byear,Tel,address,Money) VALUES (1, '김유신',1,1970,'123-4567','12-3번지 301호',10000);
INSERT INTO tblMember (seq, Name,Grade,Byear,Tel,address,Money) VALUES (2, '강감찬',1,1978,'111-1111','777-2번지 101호',0);
INSERT INTO tblMember (seq, Name,Grade,Byear,Tel,address,Money) VALUES (3, '유관순',1,1978,'222-2222','86-9번지',20000);
INSERT INTO tblMember (seq, Name,Grade,Byear,Tel,address,Money) VALUES (4, '이율곡',1,1982,'333-3333',NULL,15000);
INSERT INTO tblMember (seq, Name,Grade,Byear,Tel,address,Money) VALUES (5, '신숙주',1,1988,'444-4444','조선 APT 1012호',0);
INSERT INTO tblMember (seq, Name,Grade,Byear,Tel,address,Money) VALUES (6, '안중근',1,1981,'555-5555','대한빌라 102호',1000);
INSERT INTO tblMember (seq, Name,Grade,Byear,Tel,address,Money) VALUES (7, '윤봉길',1,1981,'666-6666','12-1번지',0);
INSERT INTO tblMember (seq, Name,Grade,Byear,Tel,address,Money) VALUES (8, '이순신',1,1981,'777-7777',NULL,1500);
INSERT INTO tblMember (seq, Name,Grade,Byear,Tel,address,Money) VALUES (9, '김부식',1,1981,'888-8888','73-6번지',-1000);
INSERT INTO tblMember (seq, Name,Grade,Byear,Tel,address,Money) VALUES (10, '박지원',1,1981,'999-9999','조선 APT 902호',1200);



-- 대여 데이터

INSERT INTO tblRent (seq, member, video, Rentdate, Retdate) VALUES (1, 1,1,'2007-01-01',NULL);
INSERT INTO tblRent (seq, member, video, Rentdate, Retdate) VALUES (2, 2,2,'2007-02-02','2001-02-03');
INSERT INTO tblRent (seq, member, video, Rentdate, Retdate) VALUES (3, 3,3,'2007-02-03',NULL);
INSERT INTO tblRent (seq, member, video, Rentdate, Retdate) VALUES (4, 4,3,'2007-02-04','2001-02-08');
INSERT INTO tblRent (seq, member, video, Rentdate, Retdate) VALUES (5, 5,5,'2007-02-05',NULL);
INSERT INTO tblRent (seq, member, video, Rentdate, Retdate) VALUES (6, 1,2,'2007-02-10',NULL);

select * from tblGenre;
select * from tblVideo;
select * from tblMember;
select * from tblRent;

/*

    [조인, Join]
    - (서로 관계를 맺은) 2개(1개) 이상의 테이블을 1개의 결과셋을 만드는 기술
    
    [조인의 종류]
    1. 단순 조인, CROSS JOIN, 카티션곱(데카르트곱)
    2. 내부 조인, INNER JOIN *****
    3. 외부 조인, OUTER JOIN *****
    4. 셀프 조인, SELF JOIN
    5. 전체 외부 조인, FULL OUTER JOIN
*/



/*

 1. 단순 조인, CROSS JOIN, 카티션곱(데카르트곱)
      - A 테이블 레코드 개수 X B 테이블 레코드 개수 = 결과셋 레코드 개수
      - 가치있는 행과 가치 없는 행이 뒤섞여 있다. > 쓸모 없음!
      - 결과셋: 행 개수 > 3 * 9 = 27개, 컬럼 개수 > 4 + 5 = 9개
      
      SELECT 컬럼리스트 FROM 테이블A CROSS JOIN 테이블B;

*/

select * from tblCustomer; -- 3명
select * from tblSales; -- 9건

select * from tblCustomer cross join tbSales; -- ANSI-SQL(추천)
select * from tblCustomer, tblSales; -- Oracle에서만 사용 가능




/*

    2. 내부 조인, INNER JOIN *****
    - 단순 조인에서 유효한 레코드만 추출한 조인
    
    <ANSI-SQL>
    SELECT 컬럼리스트 FROM 테이블A INNER JOIN 테이블B ON 테이블A.PK = 테이블B.FK;
    
    <ORACLE>
    SELECT 컬럼리스트 FROM 테이블A, 테이블B WHERE 테이블A.PK = 테이블B.FK;

*/

-- 직원 테이블, 프로젝트 테이블
select * from tblStaff;
select * from tblProject;

-- 직원 명단을 가져오시오. (담당 프로젝트 포함)
select
    *
from tblStaff inner join tblProject 
    on tblStaff.seq = staff_seq;
    


-- 고객 정보와 판매 내역을 가져오기 > 고객명, 연락처, 구매 내역(종류, 수량)

-- 대부분의 상황에서 내부 조인의 결과는 자식 테이블 레코드와 동일한 수의 레코드가 나온다. ****
-- 대부분의 상황에서 내부 조인의 결과는 부모 레코드가 반복되는 현상이 발생한다. ****

select name, tel, item, qty from tblCustomer inner join tblSales
    on tblCustomer.seq = tblSales.cseq
    order by tblCustomer.seq;
    


-- 비디오 제목과 대여 가격을 가져오시오.
select * from tblGenre; -- Parent Table
select * from tblVideo; -- Child Table

-- 순서 큰 의미는 없음. but 부모 테이블 > 자식 테이블로 작성 시 이해하기 쉬움
select 
    tblVideo.name,
    tblGenre.price 
from tblGenre inner join tblVideo 
    on tblGenre.seq = tblVideo.genre;

-- 테이블에 alias 사용!
select 
    v.name,
    g.price 
from tblGenre g inner join tblVideo v
    on g.seq = v.genre;
    



-- 커플 테이블 (솔로 포함 X)
select
    m.name as "남자",
    w.name as "여자"
from tblMan m inner join tblWoman w
    on m.couple = w.name;




-- 고객명 + 판매물품명
select * from tblCustomer;
select * from tblSales;

-- 1. 조인 > 고비용 + 속도 느림
select 
    c.name,
    s.item 
from tblCustomer c inner join tblSales s 
    on c.seq = s.cseq;
    
-- 2. 서브 쿼리 > 저비용 + 속도 빠름
select
    cseq as "고객번호",
    (select name from tblCustomer where seq = tblSales.cseq) as "고객명",
    item as "판매물품명"
from tblSales; -- 자식 테이블




select * from tblGenre; -- 부모
select * from tblVideo; -- 자식     부모
select * from tblRent;  --          자식

-- 3개의 테이블 조인
-- 대여 내역 (비디오 이름, 대여 날짜, 가격)
select
    v.name,
    r.rentdate,
    g.price
from tblGenre g 
    inner join tblVideo v 
        on g.seq = v.genre 
            inner join tblRent r 
                on v.seq = r.video;
                

-- 4개의 테이블 조인
-- 조인의 결과셋에는 와일드 카드(*)를 잘 사용하지 않는다.
select
    m.name as "회원명",
    v.name as "비디오명",
    r.rentdate as "대여날짜",
    g.price as "대여가격"
from tblGenre g
    inner join tblVideo v
        on g.seq = v.genre
            inner join tblRent r
                on v.seq = r.video
                    inner join tblMember m
                        on r.member = m.seq;
                        



-- 관계 없는 테이블끼리 조인 가능 > but 쓸모없는 결과

select * from tblStaff; -- 직원
select * from tblSales; -- 판매

select
    *
from tblStaff f
    inner join tblSales e
        on f.seq = e.cseq;
        


--  HR에서 제공되는 테이블 > 7개
select * from employees;
select * from jobs;
select * from departments;
select * from locations;
select * from countries;
select * from regions;
select * from job_history;


-- 가장 부모일수록 반복이 심함, 말단 자식 반복X
select
    e.first_name || ' ' || e.last_name as "풀네임",
    d.department_name as "소속 부서",
    l.city as "도시명",
    c.country_name as "국가명",
    r.region_name as "대륙명",
    j.job_title as "직업"
from departments d
    inner join employees e 
        on d.department_id = e.department_id
            inner join locations l
                on l.location_id = d.location_id
                    inner join countries c
                        on c.country_id = l.country_id
                            inner join regions r
                                on r.region_id = c.region_id
                                    inner join jobs j
                                        on j.job_id = e.job_id;



insert into tblCustomer values (4, '호호호', '010-1234-5678', '서울시');

select * from tblCustomer; -- 3명 > 4명
select * from tblSales; -- 9건

-- 9개 > 9개

-- 연습 : 절의 실행 순서대로 읽기 + 업무상 표현으로 읽기
-- => 물건을 한번이라도 구매한 이력이 있는 고객의 정보와 그 고객에게 판매한 내역을 가져오시오.

select * from tblCustomer c
    inner join tblSales s
        on c.seq = s.cseq;
        
-- 조인 결과에 추가된 '호호호' 회원의 정보 X
-- 내부 조인 > 두 테이블에 동시에 존재하는 정보만 가져온다. (************)
--             회원 정보가 있을 때 + 그 회원이 구매한 정보가 있을 때 > 가져옴!



/*

    3. 외부 조인, OUTER JOIN *****
    - 내부 조인의 반대가 아님!
    - 내부 조인의 결과 + 결과 셋에 포함되지 못한 부모 테이블의 나머지 레코드를 합하는 행동
    
    SELECT 
        컬럼리스트
    FROM 테이블A (LEFT | RIGHT) OUTER JOIN 테이블B
        ON 테이블A.컬럼 = 테이블B.컬럼;

*/




 








