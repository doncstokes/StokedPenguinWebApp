DROP DATABASE IF EXISTS StokedPenguin;
CREATE DATABASE StokedPenguin;
USE StokedPenguin;

DROP USER IF EXISTS SpUser@localhost;
CREATE USER SpUser@localhost IDENTIFIED BY 'tinaGetSomeHam';
GRANT ALL PRIVILEGES ON StokedPenguin.* TO 'SpUser'@'localhost';

DROP TABLE IF EXISTS `User`;
CREATE TABLE `User` (
  `id` int NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `username` varchar(128) NOT NULL,
  `pw` varchar(128) NOT NULL,
  `fmt` int NOT NULL
);

INSERT INTO User(username, pw, fmt) VALUES('admin', PASSWORD('admin'), 1);
