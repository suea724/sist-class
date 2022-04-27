
/*

    문자열 함수
    
    upper(), lower(), initcap()
    - varchar2 upper(컬럼)
    - varchar2 lower(컬럼)
    - varchar2 initcap(컬럼)
    
*/

select
    first_name,
    upper(first_name),
    lower(first_name)
from employees;

select
    'abc',
    initcap('abc') -- 첫번째 문자를 대문자로
from dual;

-- 이름에 'an'이 포함된 직원 > 대소문자 구분없이
select first_name from employees where lower(first_name) like '%an%';

/*
    substr()
    - 문자열 추출함수
    - varchar2 substr(컬럼, 시작위치, 가져올 문자 개수)
    - varchar2 substr(컬럼, 시작위치) > 시작위치 ~ 끝

*/

select
    title,
    substr(title, 3, 4)
from tblTodo;

select 
    'ABCDEFG',
    substr('ABCDEFG', 2, 3)
from dual;

select
    name,
    substr(name, 1, 1) as "성",
    substr(name, 2) as "이름",
    substr(ssn, 1, 2) as "생년",
    substr(ssn, 3, 2) as "생월",
    substr(ssn, 5, 2) as "생일",
    substr(ssn, 8, 1) as "성별"
from tblInsa;


-- 김, 이, 박, 최, 정 > 몇명?
select count(
    case
        when substr(name, 1, 1) = '김' then 1
    end) as 김,
    count(
    case
        when substr(name, 1, 1) = '이' then 1
    end) as 이,
    count(
    case
        when substr(name, 1, 1) = '박' then 1
    end) as 박,
    count(
    case
        when substr(name, 1, 1) = '최' then 1
    end) as 최,
    count(
    case
        when substr(name, 1, 1) = '정' then 1
    end) as 정
from tblInsa;


-- 남, 여 순으로 정렬
select * from tblInsa
order by substr(ssn,8, 1) asc;

/*

    length()
    - 문자열 길이
    - number length(컬럼)
    
*/

-- 컬럼 리스트에서 사용
select name, length(name) from tblCountry;

-- 조건절에 사용
select name from tblCountry where length(name) > 3;
select name from tblCountry where length(name) between 4 and 6;

-- 정렬에 사용
select name from tblCountry order by length(name) desc, name;


-- 게시판 제목 > 특정 길이 이상이면 말줄임표(...) 붙여주기
select
    title,
    case
        when length(title) >= 8 then substr(title, 1, 8) || '...'
        else title
    end as newTitle
from tblTodo;

/*
    instr()
    - 검색 (= indexOf())
    - 검색어의 위치를 반환
    - number instr(컬럼, 검색어)
    - number instr(컬럼, 검색어, 시작위치)
    - 못찾으면 0을 반환
    
*/

select
    '안녕하세요. 홍길동님' as c1,
    instr('안녕하세요. 홍길동님', '홍길동') as c2,
    instr('안녕하세요. 홍길동님', '아무개') as c3,
    instr('안녕하세요. 홍길동님. 반갑습니다. 홍길동님.', '홍길동') as c4, -- 처음 값의 위치만 반환
    instr('안녕하세요. 홍길동님. 반갑습니다. 홍길동님.', '홍길동', 11) as c5
from dual;


-- 010으로 시작하는 번호 찾기
select * from tblInsa where tel like'010%';
select * from tblInsa where substr(tel, 1, 3) = '010';
select * from tblInsa where substr(tel, '010') = 1;


/*

    lpad(), rpad()
    - left padding, right padding
    - varchar2 lpad(컬럼, 개수, 문자)
    - varchar2 rpad(컬럼, 개수, 문자)
    
*/

select
    'a',
    lpad('a', 5, 'b'),
    lpad('1', 3, '0'),
    rpad('1', 3, '0')
from dual;


/*

    trim(), ltrim(), rtrim()
    - varchar2 trim(컬럼)
    
*/

select
    '    하나     둘      셋        ',
    trim('    하나     둘      셋        '),
    ltrim('    하나     둘      셋        '),
    rtrim('    하나     둘      셋        ')
from dual;


/*

    replace()
    - 문자열 치환
    - varchar2 replace(컬럼, 찾을 문자열, 바꿀 문자열)
*/

select
    replace('홍길동', '홍', '김'),
    replace('홍길동', '이', '김'), -- 아무것도 바뀌지 않음
    replace('홍길홍', '홍', '김') -- 다 바꿔줌
from dual;

-- 주민번호 1? 남자, 2? 여자
-- replace를 사용하는 것보다는 case문을 사용하는 것이 가독성이 좋다.
select
    name, ssn,
    replace(replace(substr(ssn, 8, 1), '1', '남자'), '2', '여자') -- replace 중첩
from tblInsa;


/*
    
    decode()
    - 문자열 치환
    - varchar2 decode(컬럼, 찾을 문자열, 바꿀 문자열 [, 찾을 문자열, 바꿀 문자열] X N)
    - 못찾으면 null을 반환함 *******
    - case의 간단한 버전 but 치환 기능만 존재
*/

select
    decode(substr(ssn, 8, 1), '1', '남자', '2', '여자') -- replace를 중첩시키는 것보다 가독성이 더 높다
from tblInsa;
    

select
    decode(continent, 'AS', '아시아', 'EU', '유럽', 'NA', '북아메리카', 'AF', '아프리카')
from tblCountry;


-- 남자 수, 여자 수
select
    count(decode(gender, 'm', '남자')), -- 여자 null 값, count X
    count(decode(gender, 'f', '여자')) -- 남자 null 값, count X
from tblComedian;