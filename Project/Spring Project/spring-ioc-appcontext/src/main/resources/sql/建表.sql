CREATE TABLE user (
                          id BIGINT AUTO_INCREMENT NOT NULL,
                          email VARCHAR(50) NOT NULL,
                          password VARCHAR(50) NOT NULL,
                          name VARCHAR(50) NOT NULL,
                          PRIMARY KEY(id)
) Engine=INNODB DEFAULT CHARSET=UTF8;

INSERT INTO user (id, email, password, name) VALUES (1, 'bob@example.com', 'password', 'Bob');
INSERT INTO user (id, email, password, name) VALUES (2, 'alice@example.com', 'password', 'Alice');
INSERT INTO user (id, email, password, name) VALUES (3, 'tom@example.com', 'password', 'Tom');
