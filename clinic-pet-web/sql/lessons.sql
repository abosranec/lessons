-- create tables
CREATE TABLE Branch
(
  bno INTEGER PRIMARY KEY,
  street VARCHAR(60),
  city VARCHAR(30) NOT NULL,
  tel_no VARCHAR(15) UNIQUE,
  CONSTRAINT cityCheck CHECK (city IN('Brest', 'Vitebsk', 'Gomel', 'Grodno', 'Mogilev', 'Minsk'))
);
CREATE TABLE Staff
(
  sno INTEGER PRIMARY KEY,
  fname VARCHAR(30) NOT NULL,
  lname VARCHAR(30) NOT NULL,
  address VARCHAR(60) NOT NULL,
  tel_no VARCHAR(15),
  position VARCHAR(60) NOT NULL,
  sex VARCHAR(6) NOT NULL,
  dob DATE,
  salary REAL,
  bno INTEGER,
  CONSTRAINT sexCheck CHECK(sex IN('Male', 'Female')),
  CONSTRAINT bnoForeign FOREIGN KEY(bno) REFERENCES Branch (bno)
);
CREATE TABLE Owner
(
  ono INTEGER PRIMARY KEY,
  fname VARCHAR(30) NOT NULL,
  lname VARCHAR(30),
  address VARCHAR(60) NOT NULL,
  tel_no VARCHAR(15) UNIQUE
);
CREATE TABLE Property_for_rent
(
  pno INTEGER PRIMARY KEY,
  street VARCHAR(60),
  city VARCHAR(30) NOT NULL,
  type VARCHAR(1) NOT NULL,
  rooms INTEGER NOT NULL,
  rent REAL NOT NULL,
  ono INTEGER,
  sno INTEGER,
  bno INTEGER,
	  CONSTRAINT onoForeign FOREIGN KEY (ono) REFERENCES Owner(ono),
	  CONSTRAINT snoForeign FOREIGN KEY (sno) REFERENCES Staff(sno),
	  CONSTRAINT bnoForeign FOREIGN KEY (bno) REFERENCES Branch(bno),
	  CONSTRAINT typeCheck CHECK (type IN ('h','f')),
	  CONSTRAINT cityCheck CHECK (city IN ('Brest', 'Vitebsk', 'Gomel', 'Grodno', 'Mogilev', 'Minsk'))
);
CREATE TABLE Renter
(
  rno INTEGER PRIMARY KEY,
  fname VARCHAR(30) NOT NULL,
  lname VARCHAR(30),
  address VARCHAR(60) NOT NULL UNIQUE,
  tel_no VARCHAR(15) UNIQUE,
  pref_type VARCHAR(1),
  max_rent REAL NOT NULL,
  bno INTEGER NOT NULL,
	  CONSTRAINT pref_typeCheck CHECK (pref_type IN ('h','f')),
	  CONSTRAINT bnoForeign FOREIGN KEY (bno) REFERENCES Branch (bno)
);
CREATE TABLE Viewing
(
  rno INTEGER,
  pno INTEGER,
  date1 DATE,
  comment1 VARCHAR(500),
    CONSTRAINT rno_pnoPrimary PRIMARY KEY (rno, pno),
	  CONSTRAINT rnoForeign FOREIGN KEY (rno) REFERENCES Renter (rno),
    CONSTRAINT pnoForeign FOREIGN KEY (pno) REFERENCES Property_for_rent (pno)
);
CREATE SEQUENCE Branch_seq START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE Staff_seq START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE Renter_seq START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE Owner_seq START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE Prop_seq START WITH 1 INCREMENT BY 1;

-- insert rows
INSERT INTO Branch VALUES ( nextval('branch_seq'), 'Ангарская', 'Minsk', '+375292837549');
INSERT INTO Branch VALUES ( nextval('branch_seq'), 'Корженевского', 'Mogilev', '+375293647569');
INSERT INTO Branch VALUES ( nextval('branch_seq'), 'Кропоткина', 'Minsk', '+375294758698');
INSERT INTO Branch VALUES ( nextval('branch_seq'), 'Короткевича', 'Grodno', '+375293548794');
INSERT INTO Branch VALUES ( nextval('branch_seq'), 'Казинца', 'Brest', '+375295554657');
INSERT INTO Branch VALUES ( nextval('branch_seq'), 'Серова', 'Minsk', '+375296464646');
INSERT INTO Branch VALUES ( nextval('branch_seq'), 'Тимирязева', 'Gomel', '+375296667687');
INSERT INTO Staff VALUES (nextval('Staff_seq'), 'Виктор', 'Афанасьев', 'Vitebsk, ул.Федотова 12/9', '+375293567899', 'Риэлтор', 'Male', '23/06/1973', 1200, 4);
INSERT INTO Staff VALUES (nextval('Staff_seq'), 'Вероника', 'Зуева', 'Mogilev, ул.Казинца 79/230', '+375293451789', 'Кадровик', 'Female', '19/03/1987', 800, 5);
INSERT INTO Staff VALUES (nextval('Staff_seq'), 'Лидия', 'Архипова', 'Minsk, ул.Горная 23/89', '+375292223456', 'Программист', 'Female', '12/07/1989', 600, 2);
INSERT INTO Staff VALUES (nextval('Staff_seq'), 'Евгения', 'Шубина', 'Mogilev, ул.Брестская 78/123', '+375292234509', 'Программист', 'Male', '30/09/1970', 700, 3);
INSERT INTO Staff VALUES (nextval('Staff_seq'), 'Владимир', 'Кузнецов', 'Mogilev, ул.Тракторная 99/63', '+375299998789', 'Экономист', 'Male', '23/02/1973', 700, 3);
INSERT INTO Staff VALUES (nextval('Staff_seq'), 'Виктория', 'Рыбаков', 'Brest, ул.Ольшевского 98/290', '+375299036524', 'Программист', 'Female', '24/09/1978', 900, 4);
INSERT INTO Staff VALUES (nextval('Staff_seq'), 'Полина', 'Некрасова', 'Gomel, ул.Опанского 176/230', '+375295557390', 'Делопроизводитель', 'Female', '21/05/1987', 500, 5);
INSERT INTO Staff VALUES (nextval('Staff_seq'), 'Екатерина', 'Сорокина', 'Brest, ул.Микулича 98/23', '+375293457870', 'Юрист', 'Female', '21/06/1982', 800, 6);
INSERT INTO Staff VALUES (nextval('Staff_seq'), 'Владимир', 'Большаков', 'Minsk, ул.Кижеватова 72/3', '+375291555356', 'Риэлтор', 'Male', '06/06/1994', 700, 1);
INSERT INTO Owner VALUES (nextval('Owner_seq'), 'Лариса', 'Иванов', 'Vitebsk, ул.Слесарная 33/230', '+375299574652');
INSERT INTO Owner VALUES (nextval('Owner_seq'), 'Александр', 'Кудрин', 'Mogilev, ул.Чичерина 33/230', '+375298796821');
INSERT INTO Owner VALUES (nextval('Owner_seq'), 'Павел', 'Тарасов', 'Gomel, ул.Южная 33/230', '+375299953426');
INSERT INTO Owner VALUES (nextval('Owner_seq'), 'Михаил', 'Лазарев', 'Grodno, ул.Козлова 33/230', '+375296687209');
INSERT INTO Owner VALUES (nextval('Owner_seq'), 'Леонид', 'Савин', 'Minsk, ул.Народная 33/230', '+375293376529');
INSERT INTO Owner VALUES (nextval('Owner_seq'), 'Евгения', 'Сидорова', 'Brest, ул.Ириновская 33/230', '+375292227622');
INSERT INTO Owner VALUES (nextval('Owner_seq'), 'Полина', 'Егорова', 'Brest, ул.Некрасова 33/230', '+375298475645');
INSERT INTO Property_for_rent VALUES (nextval('Prop_seq'), 'Карпова', 'Gomel', 'f', '4','600', 3, 4, 3);
INSERT INTO Property_for_rent VALUES (nextval('Prop_seq'), 'Мележа', 'Grodno', 'h', '1','150', 4, 5, 4);
INSERT INTO Property_for_rent VALUES (nextval('Prop_seq'), 'Столетова', 'Minsk', 'f', '3','380', 1, 5, 7);
INSERT INTO Property_for_rent VALUES (nextval('Prop_seq'), 'Алибегова', 'Grodno', 'h', '1','150', 2, 4, 6);
INSERT INTO Property_for_rent VALUES (nextval('Prop_seq'), 'Жудро', 'Minsk', 'f', '1','270', 1, 4, 3);
INSERT INTO Property_for_rent VALUES (nextval('Prop_seq'), 'Лобанка', 'Brest', 'h', '2','200', 2, 5, 4);
INSERT INTO Property_for_rent VALUES (nextval('Prop_seq'), 'Амурская', 'Minsk', 'f', '4','700', 3, 6, 5);
INSERT INTO Property_for_rent VALUES (nextval('Prop_seq'), 'Есенина', 'Minsk', 'f', '2','650', 3, 6, 5);
INSERT INTO Property_for_rent VALUES (nextval('Prop_seq'), 'Корженевского', 'Minsk', 'f', '2','270', 2, 5, 4);
INSERT INTO Property_for_rent VALUES (nextval('Prop_seq'), 'Ленина', 'Minsk', 'f', '2','450', 2, 4, 5);
INSERT INTO Renter VALUES (nextval('Renter_seq'), 'Ирина', 'Пупкина', 'Minsk, ул.Кабушкина 23/89', '+375294489745', 'h', 200, 7);
INSERT INTO Renter VALUES (nextval('Renter_seq'), 'Владислав', 'Мамонтов', 'Grodno, ул.Копыльская 29/230', '+375299584638', 'h', 250, 4);
INSERT INTO Renter VALUES (nextval('Renter_seq'), 'Геннадий', 'Беляков', 'Vitebsk, ул.Кривичская 176/123', '+375293647261', 'f', 300, 2);
INSERT INTO Renter VALUES (nextval('Renter_seq'), 'Валентин', 'Дроздов', 'Brest, ул.Народная 23/98', '+375296645378', 'h', 190, 1);
INSERT INTO Renter VALUES (nextval('Renter_seq'), 'Данила', 'Воробьёв', 'Mogilev, ул.Одесская 52/57', '+375293376890', 'f', 350, 6);
INSERT INTO Renter VALUES (nextval('Renter_seq'), 'Валерий', 'Константинов', 'Minsk, ул.Базисная 92/112', '+375297652985', 'h', 320, 7);
INSERT INTO Renter VALUES (nextval('Renter_seq'), 'Маргарита', 'Зайцева', 'Grodno, ул.Дружбы 33/230', '+375297283645', 'f', 400, 4);
INSERT INTO Viewing VALUES (1, 1, '06/06/2014', 'бла');
INSERT INTO Viewing VALUES (2, 2, '23/08/2014', 'бла-бла');
INSERT INTO Viewing VALUES (3, 3, '07/05/2014', 'бла-бла-бла');
INSERT INTO Viewing VALUES (4, 4, '11/08/2013', 'бла-бла-бла-бла');
INSERT INTO Viewing VALUES (5, 5, '29/10/2014', 'бла-бла-бла-бла-бла');
INSERT INTO Viewing VALUES (6, 6, '13/01/2014', 'бла-бла-бла-бла-бла-бла');
INSERT INTO Viewing VALUES (7, 7, '30/04/2014', 'бла-бла-бла-бла-бла-бла-бла');
INSERT INTO Viewing VALUES (3, 4, '30/04/2014', 'бла-бла-бла-бла-бла-бла-бла-бла');
INSERT INTO Viewing VALUES (4, 6, '10/04/2015', 'бла-бла-бла-бла-бла-бла-бла-бла-бла');

-- selects
-- Вывести список всех женщин-программистов
select fname, lname
from Staff
where sex = 'Female' and position = 'Программист';
-- Определить и вывести максимальную зарплату сотрудников в отделении в Гродно.
select MAX(S.salary)
from Staff S, Branch B
where S.bno = B.bno AND B.city = 'Grodno';
-- Определить количество осмотров объектов в день. Подписать вычисляемое поле как 'Количество осмотров в день'.
SELECT date1, count(date1) AS kolichestvo_osmotrov_v_den
FROM VIEWING
GROUP BY date1;
-- Вывести информацию об отделении, где предлагаются в аренду 2-х комнатные квартиры с максимальной средней стоимостью.
select B.city, B.street, B.tel_no
from Branch B, (
    select P2.bno, AVG(P2.rent) as avg_rent
    from Property_for_rent P2
    where P2.rooms = '2'
    group by P2.bno) P
where B.bno = P.bno and P.avg_rent = (
  select MAX(P3.avg_rent)
  from (
    select P2.bno, AVG(P2.rent) as avg_rent
    from Property_for_rent P2
    where P2.rooms = '2'
    group by P2.bno) P3);
-- Получить список сотрудников с зарплатой от 700$ до 800$.
select *
from Staff
where salary between 700 and 900;
-- Получить список телефонов сотрудников, работающих в офисах Бреста или Минска.
select S.fname, S.tel_no
from Branch B
join Staff S
on (B.bno = S.bno AND (B.city in ('Brest', 'Minsk')));
-- Определить и вывести суммарную и среднюю зарплату сотрудников в зависимости от занимаемой ими должности.
-- Подписать вычисляемые поля как «Суммарная зарплата» и «Средняя зарплата»
select S.position, sum(S.salary) as суммарная_зарплата, avg(S.salary) as средняя_зарплата
from Staff S
group by S.position
-- *Вывести должности, по которым суммарная заработная плата больше средней.
select s1.position
from (select position, sum(salary) as sum_s from Staff group by position) s1
natural join (select position, avg(salary) as avg_s from Staff group by position) s2
where s1.sum_s > s2.avg_s
-- Определить адреса и телефоны офисов, расположенных в Минске и Гродно.
select b.street, b.tel_no
from Branch b
where b.city in ('Minsk', 'Grodno');
-- Вывести информацию о сотрудниках, которые предлагают для аренды 3-х комнатные квартиры.
select s.lname, s.tel_no
from Staff s
join Property_for_rent p
on s.sno = p.sno
where p.rooms = '3';
-- Вывести итоговый отчет о средней и суммарной заработных платах сотрудников в зависимости от их половой принадлежности.
-- Подписать вычисляемые поля как «Суммарная зарплата» и «Средняя зарплата».
select s1.sex, s1.s_avg as Средняя_зп, s2.s_sum as Суммарная_зп
from (select s.sex, avg(s.salary) as s_avg from Staff s group by s.sex) s1
natural join (select s.sex, sum(s.salary) as s_sum from Staff s group by s.sex) s2;
-- *Вывести информацию об отделениях, где работает больше женщин, чем мужчин.
select B.*
from Branch B
natural join (
  select *
  from (
    select B.bno, count(S.sex) sex_m
    from Branch B
    join Staff S
    on B.bno = S.bno
    where S.sex = 'Male'
    group by B.bno) BS_m
  natural full join (
    select B.bno, count(S.sex) sex_f
    from Branch B
    join Staff S
    on B.bno = S.bno
    where S.sex = 'Female'
    group by B.bno) BS_f) BS
where BS.sex_f > BS.sex_m or (BS.sex_f is not null and BS.sex_m is null);
-- Определить адреса всех 3-х комнатных квартир, предлагаемых в аренду
select P.street, P.city
from Property_for_rent P
where P.rooms = '3'
-- Получить список арендаторов, осматривавших объекты аренды в 2009 году
select R.*
from Renter R
join Viewing V
on R.rno = V.rno
where TO_CHAR(V.date1, 'YYYY') = '2014'
group by R.rno
-- Определить минимальную и максимальную зарплаты сотрудников во всех отделениях.
-- Подписать вычисляемые поля как «Минимальная зарплата» и «Максимальная зарплата».
select b.*, min(s.salary) as min_salary, max(s.salary) as max_salary
from Staff s
join Branch B
on s.bno = B.bno
group by b.bno
-- *Вывести отделения, в которых суммарная заработная плата больше 1000$.
select b.*
from Staff s
join Branch b
on s.bno = b.bno
group by b.bno
having sum(s.salary) > 1000;



