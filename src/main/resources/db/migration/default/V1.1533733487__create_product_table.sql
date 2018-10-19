CREATE TABLE `product` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `features` longtext,
  `price` double(10,2) NOT NULL,
  `quantity` int(20) DEFAULT NULL,
  `category` varchar(20) DEFAULT NULL,
  `image_url` varchar(255) DEFAULT NULL,
   PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;