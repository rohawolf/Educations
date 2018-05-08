-- 회원정보 테이블 : DDL(create, drop, alter)

DROP	TABLE	member;

CREATE
	TABLE	member (
 	id 			varchar(20) 	primary key,
 	pw 			varchar(20) 	not null,
	name 		varchar(50) 	not null,
	address 	varchar(300),
 	joindate 	date default 	SYSDATE
);

-- DML

insert into member values 
	('oj1234', '12345678', '홍길동', '서울 구로구 구로동', sysdate);
insert into member values 
	('abc123', '12341234', '배수지', '서울 마포구 상암동', sysdate);
insert into member values 
	('def456', '11111111', '한가인', '서울 영등포구 여의도동', sysdate);

update member 
   set address='서울 구로구 대림동',
       pw='11111111'
   where id='oj1234';    
              
select * from member;	

select * from MEMBER
   where id='oj1234';
   
delete from member;   

delete from member where id='oj1234';