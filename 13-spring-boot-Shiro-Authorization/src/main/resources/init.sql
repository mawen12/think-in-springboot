CREATE TABLE `user`
(
    `id`          INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    `name`        VARCHAR(50)                    NOT NULL,
    `password`    VARCHAR(50)                    NOT NULL,
    `create_time` DATETIME                       NULL,
    `status`      VARCHAR(50)                    NOT NULL
);
INSERT INTO `user` (name, password, status)
VALUES ('mawen', '55dc3b9b1e5ce1172131ae3b02ef724a', '0');


CREATE TABLE `permission`
(
    `id`   INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    `url`  VARCHAR(200)                   NULL,
    `name` VARCHAR(50)                    NULL
);
INSERT INTO `permission`
VALUES ('1', '/user', 'user:user');
INSERT INTO `permission`
VALUES ('2', '/user/add', 'user:add');
INSERT INTO `permission`
VALUES ('3', '/user/delete', 'user:delete');


CREATE TABLE `role`
(
    `id`   int PRIMARY KEY AUTO_INCREMENT NOT NULL,
    `name` VARCHAR(50)                    NULL,
    `memo` VARCHAR(50)                    NULL
);
INSERT INTO `role`
VALUES ('1', 'admin', '超级管理员');
INSERT INTO `role`
VALUES ('2', 'test', '测试账户');


CREATE TABLE `role_permission`
(
    rid int NULL,
    pid int NULL
);
INSERT INTO `role_permission`
VALUES ('1', '2');
INSERT INTO `role_permission`
VALUES ('1', '3');
INSERT INTO `role_permission`
VALUES ('2', '1');
INSERT INTO `role_permission`
VALUES ('1', '1');


CREATE TABLE `user_role`
(
    `user_id` int NULL,
    `rid`     int NULL
);
INSERT INTO `user_role`
VALUES ('1', '1');
INSERT INTO `user_role`
VALUES ('2', '2');
