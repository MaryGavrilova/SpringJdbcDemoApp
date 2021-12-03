create table customers
(
    id           int primary key auto_increment,
    name         varchar(255) not null,
    surname      varchar(255) not null,
    age          int check ( age > -1 ),
    phone_number varchar(255) not null
)