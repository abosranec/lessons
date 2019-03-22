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
INSERT INTO Branch VALUES ( Branch_seq.nextval, 'Ангарская', 'Minsk', '+375292837549');
INSERT INTO Branch VALUES ( Branch_seq.nextval, 'Корженевского', 'Mogilev', '+375293647569');
INSERT INTO Branch VALUES ( Branch_seq.nextval, 'Кропоткина', 'Minsk', '+375294758698');
INSERT INTO Branch VALUES ( Branch_seq.nextval, 'Короткевича', 'Grodno', '+375293548794');
INSERT INTO Branch VALUES ( Branch_seq.nextval, 'Казинца', 'Brest', '+375295554657');
INSERT INTO Branch VALUES ( Branch_seq.nextval, 'Серова', 'Minsk', '+375296464646');
INSERT INTO Branch VALUES ( Branch_seq.nextval, 'Тимирязева', 'Gomel', '+375296667687');

INSERT INTO Staff VALUES (Staff_seq.nextval, 'Виктор', 'Афанасьев', 'Vitebsk, ул.Федотова 12/9', '+375293567899', 'Риэлтор', 'Male', '06/23/1973', 1200, 4);
INSERT INTO Staff VALUES (Staff_seq.nextval, 'Вероника', 'Зуева', 'Mogilev, ул.Казинца 79/230', '+375293451789', 'Кадровик', 'Female', '03/19/1987', 800, 5);
INSERT INTO Staff VALUES (Staff_seq.nextval, 'Лидия', 'Архипова', 'Minsk, ул.Горная 23/89', '+375292223456', 'Программист', 'Female', '07/12/1989', 600, 2);
INSERT INTO Staff VALUES (Staff_seq.nextval, 'Евгения', 'Шубина', 'Mogilev, ул.Брестская 78/123', '+375292234509', 'Программист', 'Male', '09/30/1970', 700, 3);
INSERT INTO Staff VALUES (Staff_seq.nextval, 'Владимир', 'Кузнецов', 'Mogilev, ул.Тракторная 99/63', '+375299998789', 'Экономист', 'Male', '02/23/1973', 700, 3);
INSERT INTO Staff VALUES (Staff_seq.nextval, 'Виктория', 'Рыбаков', 'Brest, ул.Ольшевского 98/290', '+375299036524', 'Программист', 'Female', '09/24/1978', 900, 4);
INSERT INTO Staff VALUES (Staff_seq.nextval, 'Полина', 'Некрасова', 'Gomel, ул.Опанского 176/230', '+375295557390', 'Делопроизводитель', 'Female', '05/21/1987', 500, 5);
INSERT INTO Staff VALUES (Staff_seq.nextval, 'Екатерина', 'Сорокина', 'Brest, ул.Микулича 98/23', '+375293457870', 'Юрист', 'Female', '06/21/1982', 800, 6);
INSERT INTO Staff VALUES (Staff_seq.nextval, 'Владимир', 'Большаков', 'Minsk, ул.Кижеватова 72/3', '+375291555356', 'Риэлтор', 'Male', '06/06/1994', 700, 1);

INSERT INTO Owner VALUES (Owner_seq.nextval, 'Лариса', 'Иванов', 'Vitebsk, ул.Слесарная 33/230', '+375299574652');
INSERT INTO Owner VALUES (Owner_seq.nextval, 'Александр', 'Кудрин', 'Mogilev, ул.Чичерина 33/230', '+375298796821');
INSERT INTO Owner VALUES (Owner_seq.nextval, 'Павел', 'Тарасов', 'Gomel, ул.Южная 33/230', '+375299953426');
INSERT INTO Owner VALUES (Owner_seq.nextval, 'Михаил', 'Лазарев', 'Grodno, ул.Козлова 33/230', '+375296687209');
INSERT INTO Owner VALUES (Owner_seq.nextval, 'Леонид', 'Савин', 'Minsk, ул.Народная 33/230', '+375293376529');
INSERT INTO Owner VALUES (Owner_seq.nextval, 'Евгения', 'Сидорова', 'Brest, ул.Ириновская 33/230', '+375292227622');
INSERT INTO Owner VALUES (Owner_seq.nextval, 'Полина', 'Егорова', 'Brest, ул.Некрасова 33/230', '+375298475645');

INSERT INTO Property_for_rent VALUES (Prop_seq.nextval, 'Карпова', 'Gomel', 'f', '4','600', 3, 4, 3);
INSERT INTO Property_for_rent VALUES (Prop_seq.nextval, 'Мележа', 'Grodno', 'h', '1','150', 4, 5, 4);
INSERT INTO Property_for_rent VALUES (Prop_seq.nextval, 'Столетова', 'Minsk', 'f', '3','380', 1, 5, 7);
INSERT INTO Property_for_rent VALUES (Prop_seq.nextval, 'Алибегова', 'Grodno', 'h', '1','150', 2, 4, 6);
INSERT INTO Property_for_rent VALUES (Prop_seq.nextval, 'Жудро', 'Minsk', 'f', '1','270', 1, 4, 3);
INSERT INTO Property_for_rent VALUES (Prop_seq.nextval, 'Лобанка', 'Brest', 'h', '2','200', 2, 5, 4);
INSERT INTO Property_for_rent VALUES (Prop_seq.nextval, 'Амурская', 'Minsk', 'f', '4','700', 3, 6, 5);

INSERT INTO Renter VALUES (Renter_seq.nextval, 'Ирина', 'Пупкина', 'Minsk, ул.Кабушкина 23/89', '+375294489745', 'h', 200, 7);
INSERT INTO Renter VALUES (Renter_seq.nextval, 'Владислав', 'Мамонтов', 'Grodno, ул.Копыльская 29/230', '+375299584638', 'h', 250, 4);
INSERT INTO Renter VALUES (Renter_seq.nextval, 'Геннадий', 'Беляков', 'Vitebsk, ул.Кривичская 176/123', '+375293647261', 'f', 300, 2);
INSERT INTO Renter VALUES (Renter_seq.nextval, 'Валентин', 'Дроздов', 'Brest, ул.Народная 23/98', '+375296645378', 'h', 190, 1);
INSERT INTO Renter VALUES (Renter_seq.nextval, 'Данила', 'Воробьёв', 'Mogilev, ул.Одесская 52/57', '+375293376890', 'f', 350, 6);
INSERT INTO Renter VALUES (Renter_seq.nextval, 'Валерий', 'Константинов', 'Minsk, ул.Базисная 92/112', '+375297652985', 'h', 320, 7);
INSERT INTO Renter VALUES (Renter_seq.nextval, 'Маргарита', 'Зайцева', 'Grodno, ул.Дружбы 33/230', '+375297283645', 'f', 400, 4);

INSERT INTO Viewing VALUES (1, 1, '06/06/2014', 'бла');
INSERT INTO Viewing VALUES (2, 2, '08/23/2014', 'бла-бла');
INSERT INTO Viewing VALUES (3, 3, '05/07/2014', 'бла-бла-бла');
INSERT INTO Viewing VALUES (4, 4, '09/01/2014', 'бла-бла-бла-бла');
INSERT INTO Viewing VALUES (5, 5, '10/29/2014', 'бла-бла-бла-бла-бла');
INSERT INTO Viewing VALUES (6, 6, '01/13/2014', 'бла-бла-бла-бла-бла-бла');
INSERT INTO Viewing VALUES (7, 7, '04/30/2014', 'бла-бла-бла-бла-бла-бла-бла');
INSERT INTO Viewing VALUES (3, 4, '04/30/2014', 'бла-бла-бла-бла-бла-бла-бла-бла');