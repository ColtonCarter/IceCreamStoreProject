CREATE DATABASE icecream;

USE icecream;

DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `firstName` varchar(45) DEFAULT NULL,
  `lastName` varchar(45) DEFAULT NULL,
  `customerID` varchar(45) NOT NULL,
  `faveFlavor` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`customerID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


LOCK TABLES `customer` WRITE;

INSERT INTO `customer` VALUES ('Brittany','Morris','1','Cookie Dough'),('Ximena','Cortez','2','Chocolate'),('Jared','Murray','3','Rocky Road'),('Rob','Nice','4','Mint Chocolate Chip'),('Karla','Flores','5','Vanilla');

UNLOCK TABLES;

DROP TABLE IF EXISTS `orders`;

CREATE TABLE `orders` (
  `order_num` int(11) NOT NULL AUTO_INCREMENT,
  `cone_type` varchar(45) DEFAULT NULL,
  `cone_flavor` varchar(45) DEFAULT NULL,
  `numScoops` varchar(45) DEFAULT NULL,
  `status` varchar(50) DEFAULT NULL,
  `total` varchar(45) NOT NULL,
  `customerID` varchar(45) NOT NULL,
  PRIMARY KEY (`order_num`),
  KEY `fk_customer_id` (`customerID`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;


LOCK TABLES `orders` WRITE;

INSERT INTO `orders` VALUES (1,'Waffle','Vanilla','2','Incomplete','1.75','2'),(2,'Cake','Rocky Road','1','Complete','1.25','1'),(3,'Waffle','Chocolate Chip','3','Incomplete','2.25','3'),(4,'Waffle','Strawberry','2','Incomplete','1.75','5'),(5,'Cake','Mint Chocolate Chip','3','Complete','2.25','4'),(6,'Cake','Vanilla','2','Incomplete','1.75','7');
