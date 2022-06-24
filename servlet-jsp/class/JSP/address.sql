
drop table tblAddress;
drop sequence seqAddress;

create table tblAddress (
    seq number primary key,                                 --번호(PK)
    name varchar2(30) not null,                             --이름
    age number(3) not null,                                 --나이
    address varchar2(300) not null,                         --주소
    gender char(1) not null check(gender in ('m', 'f')),    --성별
    tel varchar2(15) not null                               --연락처
);

create sequence seqAddress;

select * from tblAddress;
