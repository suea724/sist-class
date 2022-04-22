
/*
    날짜 시간 함수
    - +, -
    1. 시각 - 시각 = 시간(일)
    2. 시각 + 시간(일) = 시각
    3. 시각 - 시간(일) = 시각
    
    
    날짜 시간 함수
    
    sysdate
    - 현재 시스템의 시간을 반환
    - 자바의 Calendar.getInstance()
    - date sysdate
    
*/

select sysdate from dual;

select name, ibsadate from tblInsa;

desc tblInsa;

-- 시각 - 시각 = 시간(일)

select
    name,
    ibsadate,
    round(sysdate - ibsadate) as "근무일수", -- 날짜 데이터끼리 연산 가능!
    round((sysdate - ibsadate) / 365) as "근무년수", -- 사용금지
    round((sysdate - ibsadate) * 24) as "근무시수",
    round((sysdate - ibsadate) * 24 * 60) as "근무분수",
    round((sysdate - ibsadate) * 24 * 60 * 60) as "근무초수"
from tblInsa;
    

-- from > where > select > order by
-- where절에 select절에서 지정해준 alias를 사용할 수 없다.
select
    title,
    adddate,
    completedate,
    round(completedate - adddate, 1) as "실행 소요 시간"
from tblTodo
    where completedate is not null and (completedate - adddate) <= 3
    order by "실행 소요 시간" desc;
    

-- 시각 +(-) 시간(일) = 시각

select
    sysdate,
    sysdate - 100 as "100일 후",
    sysdate + 100 as "100일 전",
    sysdate - (2/24) as "2시간 전",
    sysdate + (3/24) as "3시간 후",
    sysdate + (30 / 60 / 24) as "30분 후"
from dual;

/*
    
    last_day()
    - date last_day(date)
    - 해당 날짜가 포함된 달의 마지막 날짜를 반환
    
*/

select
    sysdate,
    last_day(sysdate)
from dual;

/*
    
    months_between()
    - 시각 - 시각 = 시간(월)
    - number months_between(date, date)
    
    add_months()
    - date add_months(date, number)
    
*/

select
    name,
    round(sysdate - ibsadate) as "근무일수",
    round(months_between(sysdate, ibsadate)) as "근무월수",
    round(months_between(sysdate, ibsadate) / 12) as "근무년수"
from tblInsa;


select
    sysdate,
    sysdate + 10, -- 10일뒤
    add_months(sysdate, 10), -- 10개월 뒤
    add_months(sysdate, -10), -- 10개월 전
    add_months(sysdate, 3 * 12) -- 3년뒤
from dual;

/*

    [정리]
    
    시각 - 시각
    1. 일, 시, 분, 초 > 연산자 (+, -)
    2. 월, 년 > months_between()
    
    시각 + 시간
    1. 일, 시, 분, 초 > 연산자 (+, -)
    2. 월, 년 > add_months()

*/