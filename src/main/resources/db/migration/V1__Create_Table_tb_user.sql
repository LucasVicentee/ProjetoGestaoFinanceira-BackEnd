CREATE TABLE `tb_user` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `first_name` varchar(150) NOT NULL,
  `last_name` varchar(150) NOT NULL,
  `email` varchar(120) NOT NULL,
  `monthly_income` decimal(38,2) DEFAULT NULL,
  `current_balance` decimal(38,2) DEFAULT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
);