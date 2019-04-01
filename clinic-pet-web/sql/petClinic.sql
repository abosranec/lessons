-- create table
create table Clients (
  clienID serial primary key,
  name varchar(60),
  sex varchar(10),
  city varchar(60),
  address varchar(60),
  phone varchar(60),
  mail varchar(60)
);
create table Pets (
  petID serial primary key,
  name varchar(60),
  type varchar(60),
  birthday DATE,
  clienID integer,
  constraint clientForeign foreign key(clienID) references Clients(clienID)
);

-- insert rows
insert into Clients(name, sex, city, address, phone, mail) values ('Мугако Павел Александрович', 'мужской', 'Минск', 'ул. Наполеона орды, 22', '+375297663733', 'pasha@mail.ru');
insert into Clients(name, sex, city, address, phone, mail) values ('Иванов Иван Иванович', 'мужской', 'Гродно', 'ул. Ленина, 4', '+375256638256', 'ivan@mail.ru');
insert into Clients(name, sex, city, address, phone, mail) values ('Сергеев Сергей Сергеевич', 'мужской', 'Витебск', 'пер. Мира, 11', '+375338569845', 'sergey@mail.ru');
insert into Clients(name, sex, city, address, phone, mail) values ('Петрова Екатерина Павловна', 'женский', 'Минск', 'ул. Победы, 8', '+375338256491', 'katya@mail.ru');

insert into Pets(name, type, birthday, clienID) values ('Арни', 'собака', '23/06/2017', 1);
insert into Pets(name, type, birthday, clienID) values ('Нюша', 'кот', '13/01/2018', 2);
insert into Pets(name, type, birthday, clienID) values ('Кеша', 'попугай', '28/05/2017', 2);
insert into Pets(name, type, birthday, clienID) values ('Баксик', 'кот', '03/08/2016', 3);
insert into Pets(name, type, birthday, clienID) values ('Маруся', 'кот', '19/02/2016', 4);