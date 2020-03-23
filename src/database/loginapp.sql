CREATE DATABASE loginapp CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

GRANT ALL PRIVILEGES ON loginapp.* TO 'loginapp'@'%' IDENTIFIED BY 'loginapp';

USE loginapp;


CREATE TABLE IF NOT EXISTS credential (
    id INT AUTO_INCREMENT PRIMARY KEY, 
    username varchar(255) NOT NULL, 
    password varchar(255) NOT NULL,
    role varchar(255)
) ENGINE=INNODB;


insert into credential(username,password,role) values ('user1','{noop}password1','USER');
insert into credential(username,password,role) values ('user2','{noop}password2','USER');
insert into credential(username,password,role) values ('admin1','{noop}adminpwd1','ADMIN');



