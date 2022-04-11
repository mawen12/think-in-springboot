CREATE TABLE `user`(
    `id` INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    `name` VARCHAR(50) NOT NULL,
    `password` VARCHAR(50) NOT NULL,
    `create_time` DATETIME NULL,
    `status` VARCHAR(50) NOT NULL
);

INSERT INTO `user` (name, password, status)
VALUES ('mawen', '55dc3b9b1e5ce1172131ae3b02ef724a', '0');