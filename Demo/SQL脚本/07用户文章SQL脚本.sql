CREATE DATABASE IF NOT EXISTS mvcdb DEFAULT CHARSET = UTF8;
USE mvcdb;
-- 用户表
DROP TABLE IF EXISTS mvc_user;
CREATE TABLE mvc_user
(
    id       BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT '用户编号',
    username VARCHAR(20) COMMENT '用户名',
    password CHAR(80) COMMENT '密码',
    nickname VARCHAR(20) COMMENT '昵称',
    created  TIMESTAMP COMMENT '注册时间'
) CHARSET = UTF8;
-- 文章表
DROP TABLE IF EXISTS mvc_article;
CREATE TABLE mvc_article
(
    id      BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT '文章编号',
    title   VARCHAR(20) COMMENT '文章标题',
    content TEXT COMMENT '文章内容',
    user_id BIGINT COMMENT '用户编号'
) CHARSET = UTF8;

INSERT INTO mvc_user(username, password, nickname, created)
VALUES ('admin', '123456', 'admin', '2000-01-01 00:00:00');