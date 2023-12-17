SET search_path TO public;

insert into country values (1, 'Беларусь');
insert into country values (2, 'США');

insert into city values (1, 'Гомель', 1);
insert into city values (2, 'Брест', 1);
insert into city values (3, 'Могилев', 1);
insert into city values (4, 'Минск', 1);

insert into city values (5, 'Лос-Анджелес', 2);
insert into city values (6, 'Нью-Йорк', 2);
insert into city values (7, 'Даллас', 2);
insert into city values (8, 'Детройт', 2);

insert into human values (1, 'Ilya', 'Moiseenko', 'IlyaMoiseenko', null, 'IlyaMoiseenko@gmail.com', 'testPassword', 'ADMIN', 1);
insert into human values (2, 'Marina', 'Maslowa', 'MarinaMaslowa', null, 'MarinaMaslowa@gmail.com', 'testPassword', 'ADMIN', 1);
insert into human values (3, 'Kolya', 'Pinchuk', 'KolyaPinchuk', null, 'KolyaPinchuk@gmail.com', 'testPassword', 'ADMIN', 1);
insert into human values (4, 'Karina', 'Mashanova', 'KarinaMashanova', null, 'KarinaMashanova@gmail.com', 'testPassword', 'ADMIN', 1);

insert into exercise values (1, 'first',
                            'Найдите номер модели, скорость и размер жесткого диска для всех ПК стоимостью менее 500 дол. Вывести: model, speed и hd',
                             'SELECT model, speed, hd FROM PC WHERE price < 500', 1);

insert into exercise values (2, 'second',
                             'Найдите производителей принтеров. Вывести: maker',
                             'SELECT DISTINCT maker  FROM   Product WHERE  type = Printer', 1);

insert into exercise values (3, 'third',
                             'Найдите номер модели, объем памяти и размеры экранов ПК-блокнотов, цена которых превышает 1000 дол.',
                             'SELECT  model, ram, screen FROM  laptop WHERE price > 1000', 2);

insert into role values (1, 0, 'admin');
insert into role values (2, 1, 'user');