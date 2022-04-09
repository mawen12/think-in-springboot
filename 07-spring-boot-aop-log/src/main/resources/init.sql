CREATE TABLE sys_log
(
    id int PRIMARY KEY  AUTO_INCREMENT NOT NULL,
    username varchar(50) NULL,
    operation varchar(50) NULL,
    `time` int NULL,
    method varchar(200) NULL,
    params varchar(500) NULL,
    ip varchar(50) NULL,
    create_time DATETIME NULL
);