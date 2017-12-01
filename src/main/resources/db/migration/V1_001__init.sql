CREATE TABLE `spring-boot-oauth2`.`user` (
  `id`       INT          NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45)  NOT NULL,
  `password` VARCHAR(255) NOT NULL,
  `role`     VARCHAR(45)  NULL,
  PRIMARY KEY (`id`)
);

INSERT INTO `spring-boot-oauth2`.`user`(username, password, role) VALUES ('admin','admin','ADMIN');
INSERT INTO `spring-boot-oauth2`.`user`(username, password, role) VALUES ('user','user','USER');
INSERT INTO `spring-boot-oauth2`.`user`(username, password, role) VALUES ('client','client','CLIENT');

