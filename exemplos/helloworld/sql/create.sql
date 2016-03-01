CREATE SCHEMA `mensagens` DEFAULT CHARACTER SET utf8;

CREATE TABLE `mensagens`.`mensagem` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `texto` varchar(200) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;