

create table Customer_Ultra(SSN number(9) unique,
Customer_id number(9)primary key,
Name varchar2(25) not null,
Age number(3) not null,
Address varchar2(50) not null,
City varchar2(50)not null,
State varchar2(50)not null
)
create table Account_Ultra(Customer_id references Customer_Ultra(Customer_id),
Account_id number(9)primary key,
Account_type varchar2(10)not null,
Balance number(10,5)not null,
CR_date date not null,
CR_lastdate varchar2(50) default('2020-03-31')
)
drop table Account_Ultra

drop sequence seq_customer_ultra

drop table Customer_Ultra

drop table Account_Ultra

drop table Account_Status_Ultra

drop table Customer_Status_Ultra

drop sequence seq_account_ultra


create sequence seq_customer_ultra
minvalue 100000000
start with 100000000
maxvalue 999999999
increment by 1
nocycle

drop sequence seq_customer_ultra

create sequence seq_account_ultra
minvalue 120000000
start with 120000001
maxvalue 999999999
increment by 1
nocycle


select * from Customer_Ultra

select * from Account_Ultra

select * from Customer_Status_Ultra

select * from Account_Status_Ultra

delete from Account_Ultra
select SSN,Customer_id,Name,age,address from Customer_Ultra where ssn=328411795 and customer_id=100000000

update Customer_Ultra set name='Ajay',age=25,address='Rajkamal Chowk' where  customer_id=100000000

select * from Login_UltraP


create table Customer_Status_Ultra(SSNID references Customer_Ultra(SSN),
Customer_id references Customer_Ultra(Customer_id),
Status varchar2(25),Message varchar2(25),Last_Updated timestamp)



delete from Customer_Ultra where customer_id=100000003

drop table Account_Ultra

insert into Login_UltraP values('abc','abc@123',sysdate)

create table Account_Status_Ultra(Customer_id references Customer_Ultra(Customer_id),
Account_id references Account_Ultra(Account_id),Account_type varchar2(10)not null,
Status varchar2(25),Message varchar2(25),Last_Updated timestamp)

create table Login_Ultra(Username varchar2(20),password varchar2(20));

select * from Login_UltraP



