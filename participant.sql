drop table if exists participant;

create table participant (
    phonenumber char(8) primary key,
    firstname varchar(20) not null,
    lastname varchar(20) not null,
    pass_hash varchar not null,
    pass_salt varchar not null,
    gender char check(gender='M' or gender='F') not null
);
