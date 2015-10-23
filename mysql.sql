#insert into user(id, name, user_code, password, age) values(1,'spy','spy','11',20);
select * from user;



CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `name` varchar(45) NOT NULL,
  `user_code` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `age` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;