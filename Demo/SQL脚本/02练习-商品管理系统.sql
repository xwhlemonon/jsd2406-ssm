CREATE DATABASE IF NOT EXISTS mybatisdb DEFAULT CHARSET = UTF8;
USE mybatisdb;
DROP TABLE IF EXISTS product;
CREATE TABLE product
(
    id      INT PRIMARY KEY AUTO_INCREMENT COMMENT '商品编号',
    title   VARCHAR(20) COMMENT '商品标题',
    price   DOUBLE(10, 2) COMMENT '商品价格',
    stock   INT COMMENT '商品库存'
) CHARSET = UTF8;