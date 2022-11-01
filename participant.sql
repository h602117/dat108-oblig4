create table participant (
    phonenumber char(8) primary key,
    firstname varchar(20) not null,
    lastname varchar(20) not null,
    password varchar not null,
    gender char check(gender='M' or gender='F') not null
);
