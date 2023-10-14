drop table "human";

create table if not exists "country" (
                                         id serial not null primary key,
                                         name varchar(50) not null unique
    );

create table if not exists "human" (
                                       id serial not null primary key,
                                       name varchar(50) not null,
                                       surname varchar(50) not null,
                                       username varchar(20) not null unique,
                                       photo bytea,
                                       email varchar(50) not null unique,
                                       password varchar(50) not null,
                                       role varchar(50),
                                       country_id int not null,
                                       foreign key (country_id) references "country"(id)
    );

create table if not exists "city" (
                                      id serial not null primary key,
                                      name varchar(50) not null unique,
                                      country_id int,
                                      foreign key (country_id) references "country"(id)
    );