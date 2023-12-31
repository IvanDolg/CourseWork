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
                                       role int,
                                       country_id int not null,
                                       foreign key (country_id) references "country"(id)
                                       /*foreign key (role) references "role"(role)*/
    );

create table if not exists "city" (
                                      id serial not null primary key,
                                      name varchar(50) not null unique,
                                      country_id int,
                                      foreign key (country_id) references "country"(id)
    );

create table if not exists "exercise" (
                                    id serial not null primary key,
                                    name varchar(50) not null unique,
                                    discription varchar not null,
                                    rightCode varchar not null,
                                    scores int
    );

drop table role;

create table  if not exists "role"(
                                    id serial not null primary key,
                                    role int not null unique,
                                    role_name varchar(50)
);