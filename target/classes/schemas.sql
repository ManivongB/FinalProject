DROP TABLE IF EXISTS product_orders;
DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS employees;
DROP TABLE IF EXISTS customer;
DROP TABLE IF EXISTS products;

use gamestore;

CREATE TABLE products (
product_id int NOT NULL auto_increment,
price decimal(7, 2) NOT NULL,
product_name varchar(100) NOT NULL,


PRIMARY KEY (product_id)
);

CREATE TABLE customer (
customer_id INT NOT NULL auto_increment,
first_name varchar(100) NOT NULL,
last_name varchar(100) NOT NULL,
phone_number varchar(100) NOT NULL,


PRIMARY KEY (customer_id)
  
);

CREATE TABLE employees (
employee_id int NOT NULL auto_increment,
employee_name varchar(100) NOT NULL,

PRIMARY KEY (employee_id)
 
);

CREATE TABLE orders (
  order_id int NOT NULL auto_increment,
  customer_id int NOT NULL,
  product_id int NOT NULL,
  employee_id int NOT NULL,
  
  PRIMARY KEY (order_id),
  foreign key (customer_id) references customer (customer_id),
  foreign key (product_id) references products (product_id),
  foreign key (employee_id) references employees (employee_id)

);

CREATE TABLE product_orders (
order_id int NOT NULL,
product_id int NOT NULL,

foreign key (order_id) references orders (order_id),
foreign key (product_id) references products (product_id)

);
