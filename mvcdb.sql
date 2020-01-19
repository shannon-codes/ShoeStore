DROP DATABASE IF EXISTS mvcdb;

create DATABASE mvcdb;

USE mvcdb;

CREATE TABLE IF NOT EXISTS customers
(
customerId int not null AUTO_INCREMENT,
primary key(customerId),
userName character(20) not null,
password character(20) not null,
firstname character(20) not null,
lastname character(20) not null,
address character(20) not null,
city character(20) not null,
postalCode character(20) not null
);

INSERT INTO customers VALUES (01, 'yves', '1111', 'yunna', 'won', '100 sheridan', 'oakville', 'A1B 3C4');
INSERT INTO customers VALUES (02, 'dior', '2222', 'julia', 'kwon', '1201 rose', 'oakville', 'L2T 1P8');
INSERT INTO customers VALUES (03, 'mac', '3333', 'yena', 'park', '3045 square', 'mississauga', 'X3Z 0Q6');

CREATE TABLE IF NOT EXISTS csr
(
employeeId int not null AUTO_INCREMENT,
primary key (employeeId),
userName character(20) not null,
password character(20) not null,
firstname character(20) not null,
lastname character(20) not null
);

INSERT INTO csr VALUES (01, 'jenny', 'jenny', 'jenny', 'kim');
INSERT INTO csr VALUES (02, 'tommy', 'tommy', 'tommy', 'lee') ;
INSERT INTO csr VALUES (03, 'tom', 'tom', 'tom', 'jackson'); 

CREATE TABLE IF NOT EXISTS shoes
(
itemId int not null AUTO_INCREMENT,
primary key (itemId),
itemName character(20) not null,
category character(20) not null,
shoesSize decimal(3,1) not null,
price decimal(7,2) not null
);

INSERT INTO shoes VALUES (01, 'nike', 'running', 5.5, 65.00);
INSERT INTO shoes VALUES (02, 'adidas', 'running', 4.0, 70.00);
INSERT INTO shoes VALUES (03, 'jordan', 'running', 2.5, 45.50);


CREATE TABLE IF NOT EXISTS orders
(
orderId int not null AUTO_INCREMENT,
primary key (orderId),
customerId int not null,
FOREIGN KEY (customerId) REFERENCES customers(customerId),
itemId int not null,
foreign key (itemId) references shoes(itemId),
orderDate DATE not null,
quantity int not null,
status character(20) not null
);

INSERT INTO orders VALUES (01, 01, 01, '2018-11-22', 2, 'in-process');
INSERT INTO orders VALUES (02, 02, 02, '2018-11-22',1, 'delivered');
INSERT INTO orders VALUES (03, 03, 03, '2018-11-23', 5, 'order placed');


