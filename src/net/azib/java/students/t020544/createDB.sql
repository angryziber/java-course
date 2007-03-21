connect 'jdbc:derby:c:\\eclipse\\myDB;create=true;user=test;password=test';

drop table emp;

create table emp(
 name varchar(20),
 age integer,
 gender char(1)
);

insert into emp values ('John Doe', 55, 'M');
insert into emp values ('Diana Smith', 34, 'F');
insert into emp values ('Foo Bar', 21, 'M');

select * from emp;

disconnect;
exit;