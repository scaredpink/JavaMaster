-- 创建数据库learjdbc:
DROP DATABASE IF EXISTS learnjdbc;
CREATE DATABASE learnjdbc;

-- 创建登录用户learn/口令
CREATE USER IF NOT EXISTS 'learnspring'@'%' IDENTIFIED BY 'password';
GRANT ALL PRIVILEGES ON learnjdbc.* TO 'learnspring'@'%' WITH GRANT OPTION;
FLUSH PRIVILEGES;


DROP TABLE IF EXISTS spring_user;
CREATE TABLE spring_user (
                          id BIGINT AUTO_INCREMENT NOT NULL,
                          email VARCHAR(50) NOT NULL,
                          password VARCHAR(50) NOT NULL,
                          name VARCHAR(50) NOT NULL,
                          PRIMARY KEY(id)
) Engine=INNODB DEFAULT CHARSET=UTF8;

INSERT INTO spring_user (id, email, password, name) VALUES (1, 'bob@example.com', 'password', 'Bob');
INSERT INTO spring_user (id, email, password, name) VALUES (2, 'alice@example.com', 'password', 'Alice');
INSERT INTO spring_user (id, email, password, name) VALUES (3, 'tom@example.com', 'password', 'Tom');
