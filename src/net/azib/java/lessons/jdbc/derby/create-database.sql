connect 'jdbc:derby:c:\\eclipse\\myderby;create=true;user=test;password=test';

drop table test;

create table test(
 name varchar(20),
 age integer,
 gender char(1)
);

insert into test values ('John Doe', 55, 'M');
insert into test values ('Diana Smith', 34, 'F');
insert into test values ('Foo Bar', 21, 'M');

select * from test;

disconnect;
exit;