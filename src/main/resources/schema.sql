create table customers
(
    id           int primary key auto_increment,
    name         varchar(255) not null,
    surname      varchar(255) not null,
    age          int check ( age > -1 ),
    phone_number varchar(255) not null
);

create table orders
(
    id           int primary key auto_increment,
    date         timestamp    not null default now(),
    customer_id  int,
    product_name varchar(255) not null,
    amount       double check ( amount > 0 ),
    foreign key (customer_id) references customers (id)
);