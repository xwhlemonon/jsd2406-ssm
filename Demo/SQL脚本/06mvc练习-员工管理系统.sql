CREATE DATABASE IF NOT EXISTS mvcdb DEFAULT CHARSET = UTF8;
USE mvcdb;
DROP TABLE IF EXISTS emp;
CREATE TABLE emp
(
    id     INT PRIMARY KEY AUTO_INCREMENT,
    name   VARCHAR(20),
    salary DOUBLE(10, 2),
    job    VARCHAR(20)
) CHARSET = UTF8;