
-- traffic_accident. 각 교통 수단 별(지하철, 철도, 항공기, 선박, 자동차) 발생한 총 교통 사고 발생 수, 총 사망자 수, 사건 당 평균 사망자 수를 가져오시오.

select
    trans_type as "교통 수단",
    sum(total_acct_num) as "총 사고 발생 수",
    sum(death_person_num) as "총 사망자 수",
    round(avg(death_person_num)) as "평균 사망자 수"
from traffic_accident
    group by trans_type;

        
        

-- tblZoo. 종류(family)별 평균 다리의 갯수를 가져오시오.

select
    family as "종류",
    round(avg(leg)) as "평균 다리 개수"
from tblZoo 
    group by family;
    

    
-- tblZoo. 체온이 변온인 종류 중 아가미 호흡과 폐 호흡을 하는 종들의 갯수를 가져오시오.

select breath, count(*) as "수" from tblZoo where thermo = 'variable' group by breath; 
       
        

-- tblZoo. 사이즈와 종류별로 그룹을 나누고 각 그룹의 갯수를 가져오시오.

select
    family,
    sizeof,
    count(*)
from tblZoo
    group by family, sizeof
    order by family;
       
        

-- tblMen. tblWomen. 서로 짝이 있는 사람 중 남자와 여자의 정보를 모두 가져오시오.

--    [남자]        [남자키]   [남자몸무게]     [여자]    [여자키]   [여자몸무게]
--    홍길동         180       70              장도연     177        65
--    아무개         175       null            이세영     163        null
--    ..
select
    m.name as "남자",
    m.height as "남자키",
    m.weight as "남자몸무게",
    m.couple as "여자",
    w.height as "여자키",
    w.weight as "여자몸무게"
from tblMan m inner join tblWoman w
    on m.couple = w.name;

    
    

-- tblAddressBook. 가장 많은 사람들이 가지고 있는 직업은 주로 어느 지역 태생(hometown)인가?

select * from tblAddressBook;

select 
    hometown, count(*) 
from tblAddressBook
group by hometown;

        

-- tblAddressBook. 관리자의 실수로 몇몇 사람들의 이메일 주소가 중복되었다. 중복된 이메일 주소만 가져오시오.

select * from tblAddressBook;

select 
    email 
from tblAddressBook
    group by email
    having count(email) > 1;
    
    

-- tblAddressBook. 이메일 도메인들 중 평균 아이디 길이가 가장 긴 이메일 사이트의 도메인은 무엇인가?

select 
    substr(email, instr(email, '@') + 1) as "도메인"
from tblAddressBook
group by substr(email, instr(email, '@') + 1)
having avg(length(substr(email, 1, instr(email, '@')))) = (
    select
        max(avg(length(substr(email, 1, instr(email, '@')))))
    from tblAddressBook
        group by substr(email, instr(email, '@') + 1)
);

        

-- tblAddressBook. 성씨별 인원수가 100명 이상 되는 성씨들을 가져오시오.

select * from tblAddressBook;

select 
    substr(name, 1, 1) as "성",
    count(substr(name, 1, 1)) as "인원수"
from tblAddressBook
    group by substr(name, 1, 1)
    having count(substr(name, 1, 1)) >= 100;

    

-- tblAddressBook. 이메일이 스네이크 명명법으로 만들어진 사람들 중에서 여자이며, 20대이며, 키가 150~160cm 사이며, 고향이 서울 또는 인천인 사람들만 가져오시오. 
select * from tblAddressBook;

select 
    * 
from tblAddressBook
where instr(email, '_') > 0
    and gender = 'f'
    and age between 20 and 29
    and height between 150 and 160
    and hometown in ('서울', '인천');


--tblAddressBook. 가장 나이가 많으면서 가장 몸무게가 많이 나가는 사람과 같은 직업을 가지는 사람들을 가져오시오.
select
    *
from tblAddressBook
    where job = (
        select
            job
        from tblAddressBook
            where age = (select max(age) from tblAddressBook)
                and weight = (select max(weight) from tblAddressBook)
    );



-- tblAddressBook. '건물주'와 '건물주자제분'들의 거주지가 서울과 지방의 비율이 어떻게 되느냐?

select
    case
        when job = '건물주' then job
        when job = '건물주자제분' then job
    end as 직업,
    round(count(case when hometown = '서울' then '1' end) / count(*) * 100) || '%' as 서울,
    round(count(case when hometown <> '서울' then '1' end) / count(*) * 100) || '%' as 지방
from (select * from tblAddressBook where job in ('건물주', '건물주자제분')) a
    group by job;


    
    
    
-- tblVideo, tblRent, tblMember. '뽀뽀할까요' 라는 비디오를 빌려간 회원의 이름은?

select * from tblVideo;
select * from tblRent;
select * from tblMember;
 
select 
    m.name as "회원 이름"
from tblVideo v
    inner join tblRent r
        on v.seq = r.video
            inner join tblMember m
                on m.seq = r.member
where v.name = '뽀뽀할까요';



-- tblAddressBook. 남자 평균 나이보다 나이가 많은 서울 태생 + 직업을 가지고 있는 사람들을 가져오시오.
select * from tblAddressBook;

select
    *
from tblAddressBook
where age > (select avg(age) from tblAddressBook group by gender having gender = 'm')
    and hometown = '서울'
    and job not in ('취업준비생', '학생', '백수') ;



-- tblAddressBook. gmail.com을 사용하는 사람들의 성별 > 세대별(10,20,30,40대) 인원수를 가져오시오.

select
    case 
        when gender = 'f' then '여자'
        when gender = 'm' then '남자'
    end as "성별",
    count(case when age between 10 and 19 then '1' end) as "10대",
    count(case when age between 20 and 29 then '1' end) as "20대",
    count(case when age between 30 and 39 then '1' end) as "30대",
    count(case when age between 40 and 49 then '1' end) as "40대"
from tblAddressBook
    where substr(email, instr(email, '@')) = '@gmail.com'
    group by gender;
    



-- tblVideo, tblRent, tblMember. 현재 반납을 안한 회원명과 비디오명, 대여날짜를 가져오시오.
select
    m.name as "회원명",
    v.name as "비디오명",
    r.rentdate as "대여날짜"
from tblVideo v
    inner join tblRent r
        on v.seq = r.video
            inner join tblMember m
                on r.member = m.seq
where r.retdate is null;


-- tblVideo, tblRent, tblMember, tblGenre. 2007년 2월에 대여된 구매내역을 가져오시오. 회원명, 비디오명, 언제, 대여가격
select * from tblGenre;

select
    m.name as "회원명",
    v.name as "비디오명",
    r.rentdate as "대여 날짜",
    g.price as "대여가격"
from tblGenre g
    inner join tblVideo v
        on g.seq = v.genre
            inner join tblRent r
                on v.seq = r.video
                    inner join tblMember m
                        on r.member = m.seq
where to_char(rentdate, 'yyyy-mm') = '2007-02';


-- employees, jobs. 직책(Job Title)이 Sales Manager인 사원들의 입사년도와 입사년도(hire_date)별 평균 급여를 가져오시오. 년도를 기준으로 오름차순 정렬.
select * from employees;
select * from jobs;

select 
    to_char(hire_date, 'yyyy') as "입사년도",
    avg(salary) as "평균급여"
from jobs j
    inner join employees e
        on j.job_id = e.job_id
where j.job_title = 'Sales Manager'
    group by to_char(hire_date, 'yyyy')
    order by 입사년도 asc;



-- tblAddressBook. 평균 나이가 가장 많은 출신(hometown)들이 가지고 있는 직업 중 가장 많은 직업은?

-- 1. 평균 나이가 가장 많은 출신의 직업 추출
create or replace view a
as
select
    job
from tblAddressBook
where hometown = (
        select
            hometown
        from tblAddressBook
            group by hometown
            having avg(age) = (
                select
                    max(avg(age))
                from tblAddressBook
                    group by hometown
            )
    );
    
select * from a;
    

-- 2. 그중 가장 많은 직업 추출    
select 
    job
from a
    group by job
    having count(job) = (
        select
            max(count(*))
        from a
        group by job
    );




-- tblAddressBook.  동명이인이 여러명 있습니다. 이 중 가장 인원수가 많은 동명이인(모든 이도윤)의 명단을 가져오시오.

select
    *
from tblAddressBook
    where name = (
        select
            name
        from tblAddressBook
            group by name
            having count(*) = (
                select max(count(name))
                from tblAddressBook
                group by name
            )
    );



-- tblAddressBook. 가장 사람이 많은 직업의(332명) 세대별 비율을 구하시오.

select
    job,
    round(count(case when age between 10 and 19 then '1' end) / count(*) * 100, 1) || '%' as "10대",
    round(count(case when age between 20 and 29 then '1' end) / count(*) * 100, 1) || '%' as "20대",
    round(count(case when age between 30 and 39 then '1' end) / count(*) * 100, 1) || '%' as "30대",
    round(count(case when age between 40 and 49 then '1' end) / count(*) * 100, 1) || '%' as "40대"
from tblAddressBook
where job = (
    select job from tblAddressBook group by job having count(*) = (
            select max(count(job)) from tblAddressBook group by job
    )
)
group by job;



-- employees, departments. locations. 각 도시(city)에 있는 모든 부서 사원들의 평균급여가 가장 낮은 도시부터 도시명(city)과 평균연봉, 해당 도시의 사원수를 가져오시오.
-- 단, 도시에 근무하는 사원이 10명 이상인 곳은 제외하고 가져오시오.
select * from employees;
select * from departments;
select * from locations;

select
    l.city as "도시명",
    round(avg(e.salary)) as "평균연봉",
    count(employee_id) as "사원 수"
from locations l
    inner join departments d
        on l.location_id = d.location_id
            inner join employees e
                on d.department_id = e.department_id
group by l.city
    having count(*) < 10
order by avg(e.salary) asc;



-- employees. 'Munich' 도시에 위치한 부서에 소속된 직원들 명단?
select * from employees;
select * from locations;
select * from departments;

select
    *
from departments d
    inner join employees e
        on d.department_id = e.department_id
            inner join locations l
                on l.location_id = d.location_id
where l.city = 'Munich';



-- tblStaff, tblProject. 현재 재직중인 모든 직원의 이름, 주소, 월급, 담당프로젝트명을 가져오시오.
select * from tblStaff;
select * from tblProject;

select
    s.name,
    s.address,
    s.salary,
    p.project
from tblStaff s
    left outer join tblProject p
        on s.seq = p.staff_seq;
       

    
-- tblStaff, tblProejct. 'TV 광고'을 담당한 직원의 월급은 얼마인가?
select
    salary
from tblStaff s
    inner join tblProject p
        on s.seq = p.staff_seq
where project = 'TV 광고';
    
    
    
-- tblVideo, tblRent, tblMember. '털미네이터' 비디오를 한번이라도 빌려갔던 회원들의 이름은?
select
    m.name
from tblVideo v
    inner join tblRent r
        on v.seq = r.video
            inner join tblMember m
                on m.seq = r.member
where v.name = '털미네이터';


                
-- tblStaff, tblProject. 서울시에 사는 직원을 제외한 나머지 직원들의 이름, 월급, 담당프로젝트명을 가져오시오.
select
    s.name,
    s.salary,
    p.project
from tblStaff s
    inner join tblProject p
        on s.seq = p.staff_seq
where s.address <> '서울시';
        
    
    
-- tblCustomer, tblSales. 상품을 2개(단일상품) 이상 구매한 회원의 연락처, 이름, 구매상품명, 수량을 가져오시오.

select
    c.tel,
    c.name,
    s.item,
    s.qty
from tblCustomer c
    inner join tblSales s
        on c.seq = s.cseq
where qty >= 2;

                
                
-- tblVideo, tblRent, tblGenre. 모든 비디오 제목, 보유수량, 대여가격을 가져오시오.

select
    v.name as "비디오 제목",
    v.qty as "보유 수량",
    g.price as "대여 가격"
from tblGenre g
    inner join tblVideo v
        on g.seq = v.genre
            inner join tblRent r
                on r.video = v.seq;
                    
    
-- employees, departments. 사원들의 이름, 부서번호, 부서명을 가져오시오.

select
    e.first_name || ' ' || e.last_name as "사원명",
    d.department_id as "부서번호",
    d.department_name as "부서명"
from departments d
    inner join employees e
        on d.department_id = e.department_id;
        
        
        
-- employees, jobs. 사원들의 정보와 직업명을 가져오시오.

select
    e.employee_id,
    e.first_name,
    e.last_name,
    e.email,
    e.phone_number,
    e.salary,
    j.job_title
from employees e
    inner join jobs j
        on e.job_id = j.job_id;


        
-- employees, jobs. 직무(job_id)별 최고급여(max_salary) 받는 사원 정보를 가져오시오.
        
select
    *
from jobs j
    inner join employees e
        on j.job_id = e.job_id
where salary in (
    select
        max(salary)
    from employees
    group by job_id
);
        
    
    
-- departments, locations. 모든 부서와 각 부서가 위치하고 있는 도시의 이름을 가져오시오.
select * from departments;
select * from locations;

select
    distinct d.*,
    l.city
from locations l
    inner join departments d
        on l.location_id = d.location_id
order by department_id;
        
        
        
-- locations, countries. location_id 가 2900인 도시가 속한 국가 이름을 가져오시오.
select * from locations;
select * from countries;

select
    c.country_name
from countries c
    inner join locations l
        on c.country_id = l.country_id
where l.location_id = 2900;
        

                        
-- employees. 급여를 12000 이상 받는 사원과 같은 부서에서 근무하는 사원들의 이름, 급여, 부서번호를 가져오시오.
select
    first_name || ' ' || last_name as "이름",
    salary as "급여",
    department_id as "부서번호"
from employees
where department_id in (select distinct department_id from employees where salary >= 12000);

        
        
-- employees, departments. locations.  'Seattle'에서(LOC) 근무하는 사원의 이름, 직위, 부서번호, 부서이름을 가져오시오.

select * from employees;
select * from jobs;

select
    e.first_name || ' ' || e.last_name as "이름",
    j.job_title as "직위",
    d.department_id as "부서번호",
    d.department_name as "부서이름"
from locations l
    inner join departments d
        on l.location_id = d.location_id
            inner join employees e
                on d.department_id = e.department_id
                    inner join jobs j
                        on j.job_id = e.job_id
where city = 'Seattle';
    
    
    
-- employees, departments. first_name이 'Jonathon'인 직원과 같은 부서에 근무하는 직원들 정보를 가져오시오.

select
    *
from departments d
    inner join employees e
        on d.department_id = e.department_id
where d.department_id = (select department_id from employees where first_name = 'Jonathon');


      
-- employees, departments. 사원이름과 그 사원이 속한 부서의 부서명, 그리고 월급을 출력하는데 월급이 3000이상인 사원을 가져오시오.

select
    e.first_name || ' ' || e.last_name as "이름",
    d.department_name as "부서명",
    e.salary as "월급"
from departments d
    inner join employees e
        on d.department_id = e.department_id
where salary >= 3000;
    
            
            
-- employees, departments. 부서번호가 10번인 사원들의 부서번호, 부서이름, 사원이름, 월급을 가져오시오.

select
    d.department_id as "부서번호",
    d.department_name as "부서이름",
    e.first_name || ' ' || e.last_name as "이름",
    e.salary as "월급"
from departments d
    inner join employees e
        on d.department_id = e.department_id         
where d.department_id = 10;


            
-- departments, job_history. 퇴사한 사원의 입사일, 퇴사일, 근무했던 부서 이름을 가져오시오.
        
select 
    j.start_date as "입사일",
    j.end_date as "퇴사일",
    d.department_name as "부서명"
from departments d
    inner join job_history j
        on d.department_id = j.department_id;
        
        
        
-- employees. 사원번호와 사원이름, 그리고 그 사원을 관리하는 관리자의 사원번호와 사원이름을 출력하되,
-- 각각의 컬럼명을 '사원번호', '사원이름', '관리자번호', '관리자이름'으로 하여 가져오시오.

select * from employees;

select 
    e2.employee_id as "사원번호",
    e2.first_name || ' ' || e2.last_name as "사원이름",
    e2.manager_id as "관리자번호",
    e1.first_name || ' ' || e1.last_name as "관리자이름"
from employees e1
    inner join employees e2
        on e1.employee_id = e2.manager_id;

        
        
-- employees, jobs. 직책(Job Title)이 Sales Manager인 사원들의 입사년도와 입사년도(hire_date)별 평균 급여를 가져오시오. 년도를 기준으로 오름차순 정렬.

select
    to_char(hire_date, 'yyyy') as "입사년도",
    avg(salary) as "평균급여"
from jobs j
    inner join employees e
        on j.job_id = e.job_id
where j.job_title = 'Sales Manager'
group by to_char(hire_date, 'yyyy')
order by to_char(hire_date, 'yyyy');

   
            
-- employees, jobs, job_history. ‘Public  Accountant’의 직책(job_title)으로 과거에 근무한 적이 있는 모든 사원의 사번과 이름을 가져오시오. 
-- 현재 ‘Public Accountant’의 직책(job_title)으로 근무하는 사원은 고려 하지 말것. > ??

select
    e.employee_id as "사번",
    e.first_name || ' ' || e.last_name as "이름"
from jobs j
    inner join job_history h
        on j.job_id = h.job_id
            inner join employees e
                on h.employee_id = e.employee_id
where j.job_title = 'Public Accountant';
    


    
-- employees, departments, locations. 커미션을 받는 모든 사람들의 first_name, last_name, 부서명, 지역 id, 도시명을 가져오시오.

select 
    e.first_name,
    e.last_name,
    d.department_name,
    l.location_id,
    l.city
from locations l
    inner join departments d
        on l.location_id = d.location_id
            inner join employees e
                on e.department_id = d.department_id
where commission_pct is not null;

    
    
-- employees. 자신의 매니저보다 먼저 고용된 사원들의 first_name, last_name, 고용일을 가져오시오.

select
    first_name,
    last_name,
    hire_date
from employees e1
where hire_date < (select
                        hire_date
                    from employees e2
                    where e1.manager_id = e2.employee_id

);


