-- create table
create table Clients (
  clientID serial primary key,
  clientName varchar(60),
  sex varchar(10),
  city varchar(60),
  address varchar(60),
  phone varchar(60),
  mail varchar(60)
);
create table Pets (
  petID serial primary key,
  petName varchar(60),
  type varchar(60),
  birthday DATE,
  clientID integer,
  constraint clientForeign foreign key(clientID) references Clients(clientID)
);

-- insert rows
insert into Clients(clientName, sex, city, address, phone, mail) values ('Мугако Павел Александрович', 'мужской', 'Минск', 'ул. Наполеона орды, 22', '+375297663733', 'pasha@mail.ru');
insert into Clients(clientName, sex, city, address, phone, mail) values ('Иванов Иван Иванович', 'мужской', 'Гродно', 'ул. Ленина, 4', '+375256638256', 'ivan@mail.ru');
insert into Clients(clientName, sex, city, address, phone, mail) values ('Сергеев Сергей Сергеевич', 'мужской', 'Витебск', 'пер. Мира, 11', '+375338569845', 'sergey@mail.ru');
insert into Clients(clientName, sex, city, address, phone, mail) values ('Петрова Екатерина Павловна', 'женский', 'Минск', 'ул. Победы, 8', '+375338256491', 'katya@mail.ru');

insert into Pets(petName, type, birthday, clientID) values ('Арни', 'собака', '23/06/2017', 1);
insert into Pets(petName, type, birthday, clientID) values ('Нюша', 'кот', '13/01/2018', 2);
insert into Pets(petName, type, birthday, clientID) values ('Кеша', 'попугай', '28/05/2017', 2);
insert into Pets(petName, type, birthday, clientID) values ('Баксик', 'кот', '03/08/2016', 3);
insert into Pets(petName, type, birthday, clientID) values ('Маруся', 'кот', '19/02/2016', 4);