CREATE SCHEMA `twitter` DEFAULT CHARACTER SET utf8;

CREATE TABLE `twitter`.`tweets` (
    `id` int(11) NOT NULL AUTO_INCREMENT,
	`user` varchar(50) NOT NULL,
	`createdAt` datetime not null,
	`text` varchar(140) NOT NULL,
	`source` varchar(1000) NOT NULL,
	`isTruncated` char(1) not null,
	`inReplyToStatusId` int(11),
	`inReplyToUserId` int(11),
	`isFavorited` char(1) not null,
	`inReplyToScreenName` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


