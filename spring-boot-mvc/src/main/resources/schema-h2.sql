create table books (
                       isbn varchar(13) not null primary key,
                       publisherName varchar(30) not null,
                       authorName varchar(50) not null,
                       years integer not null,
                       title varchar(30) not null,
                       price double not null
);