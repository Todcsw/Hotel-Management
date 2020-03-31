/*
SQLyog Ultimate v12.08 (64 bit)
MySQL - 5.5.49 : Database - hms
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`hms` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `hms`;

/*Table structure for table `administrator` */

DROP TABLE IF EXISTS `administrator`;

CREATE TABLE `administrator` (
  `Adm_id` varchar(20) NOT NULL,
  `Adm_name` varchar(20) NOT NULL,
  `Adm_pwd` varchar(20) NOT NULL,
  `Adm_jmpwd` varchar(50) DEFAULT NULL,
  `Adm_delremark` int(4) NOT NULL,
  `Adm_problem` varchar(20) DEFAULT NULL,
  `Adm_text` text,
  PRIMARY KEY (`Adm_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `administrator` */

insert  into `administrator`(`Adm_id`,`Adm_name`,`Adm_pwd`,`Adm_jmpwd`,`Adm_delremark`,`Adm_problem`,`Adm_text`) values ('1','陈圣文','485226','dBlVVRtY8QmM0kZuU2JCZw==',1,'陈圣文',NULL);

/*Table structure for table `checkout` */

DROP TABLE IF EXISTS `checkout`;

CREATE TABLE `checkout` (
  `Che_id` varchar(20) NOT NULL,
  `Emp_id` varchar(10) NOT NULL,
  `Cus_id` varchar(20) NOT NULL,
  `Roo_id` varchar(10) NOT NULL,
  `Cho_date` date DEFAULT NULL,
  `Cho_text` text,
  `Cho_other` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`Che_id`),
  KEY `Emp_id` (`Emp_id`),
  KEY `Cus_id` (`Cus_id`),
  KEY `Roo_id` (`Roo_id`),
  CONSTRAINT `checkout_ibfk_1` FOREIGN KEY (`Emp_id`) REFERENCES `employess` (`Emp_id`),
  CONSTRAINT `checkout_ibfk_2` FOREIGN KEY (`Cus_id`) REFERENCES `customer` (`Cus_id`),
  CONSTRAINT `checkout_ibfk_3` FOREIGN KEY (`Roo_id`) REFERENCES `room` (`Roo_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `checkout` */

insert  into `checkout`(`Che_id`,`Emp_id`,`Cus_id`,`Roo_id`,`Cho_date`,`Cho_text`,`Cho_other`) values ('1','2','1577365331244','302','2019-12-20',NULL,NULL),('2','3','1577365331244','201','2019-08-12',NULL,NULL);

/*Table structure for table `customer` */

DROP TABLE IF EXISTS `customer`;

CREATE TABLE `customer` (
  `Cus_id` varchar(20) NOT NULL,
  `Cus_name` varchar(10) NOT NULL,
  `Cus_sex` varchar(4) NOT NULL,
  `Cus_identify` varchar(18) NOT NULL,
  `Cus_tel` varchar(13) NOT NULL,
  `Cus_text` text,
  `Cus_other` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`Cus_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `customer` */

insert  into `customer`(`Cus_id`,`Cus_name`,`Cus_sex`,`Cus_identify`,`Cus_tel`,`Cus_text`,`Cus_other`) values ('1577286258603','薛','男','411522123413434123','15565323533',NULL,NULL),('1577286581034','学学学','男','134134343434343434','17962032222',NULL,NULL),('1577365331244','陈圣文','男','213123234231413434','17630902584',NULL,NULL),('1577845514453','王小飞','女','232312324232321323','17630243231',NULL,NULL),('1577845688952','李勇','男','432323423232123211','17623212371',NULL,NULL);

/*Table structure for table `employess` */

DROP TABLE IF EXISTS `employess`;

CREATE TABLE `employess` (
  `Emp_id` varchar(20) NOT NULL,
  `Emp_name` varchar(20) NOT NULL,
  `Emp_pwd` varchar(20) NOT NULL,
  `Emp_jmpwd` varchar(50) DEFAULT NULL,
  `Emp_sex` varchar(4) NOT NULL,
  `Emp_identify` varchar(18) NOT NULL,
  `Emp_salary` float NOT NULL,
  `Emp_delremark` int(4) NOT NULL,
  `Emp_text` text,
  `Emp_problem` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`Emp_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `employess` */

insert  into `employess`(`Emp_id`,`Emp_name`,`Emp_pwd`,`Emp_jmpwd`,`Emp_sex`,`Emp_identify`,`Emp_salary`,`Emp_delremark`,`Emp_text`,`Emp_problem`) values ('1','王飞','987456','+2JXnpkNpOKo8Vw9HhI0OA==','男','411522200003261513',2545,0,NULL,'陈圣文'),('10','陈圣文','485226','dBlVVRtY8QmM0kZuU2JCZw==','男','423412341234324411',5550,1,NULL,'485226'),('1578921300187','王','485226','dBlVVRtY8QmM0kZuU2JCZw==','女','411348899803290',4000,1,NULL,'485226'),('2','李','990927','ZjzRim8jdWUN4QKP98dm2A==','男','181451081403485456',200,0,NULL,'485226'),('3','胡凯','485226','dBlVVRtY8QmM0kZuU2JCZw==','男','411524312343243423',3000,1,NULL,'陈圣文'),('4','李滨','485226','dBlVVRtY8QmM0kZuU2JCZw==','男','411521243141344314',30000,1,NULL,'陈圣文'),('5','成伟','123456','4QrcOUm6Wau+VuBX8g+IPg==','男','411521243123434314',32665,1,NULL,'陈圣文'),('6','薛雪雪','485226','dBlVVRtY8QmM0kZuU2JCZw==','男','124312341234123434',32156,1,NULL,'陈圣文'),('7','哈哈','485226','dBlVVRtY8QmM0kZuU2JCZw==','男','123243154123412341',20210,1,NULL,'陈圣文'),('8','武汉市','123456','4QrcOUm6Wau+VuBX8g+IPg==','男','213412343432134441',25462,1,NULL,'陈圣文'),('9','王小飞','485226','dBlVVRtY8QmM0kZuU2JCZw==','男','124312341234123441',20024,1,NULL,'陈圣文');

/*Table structure for table `order1` */

DROP TABLE IF EXISTS `order1`;

CREATE TABLE `order1` (
  `Ord_id` varchar(20) NOT NULL,
  `Emp_id` varchar(20) NOT NULL,
  `Cus_id` varchar(20) NOT NULL,
  `Roo_id` varchar(10) NOT NULL,
  `Ord_deposit` float NOT NULL,
  `Ord_date` date DEFAULT NULL,
  `Ord_outdate` date DEFAULT NULL,
  `Ord_text` text,
  PRIMARY KEY (`Ord_id`),
  KEY `Cus_id` (`Cus_id`),
  KEY `Roo_id` (`Roo_id`),
  KEY `Emp_id` (`Emp_id`),
  CONSTRAINT `order1_ibfk_1` FOREIGN KEY (`Cus_id`) REFERENCES `customer` (`Cus_id`),
  CONSTRAINT `order1_ibfk_2` FOREIGN KEY (`Roo_id`) REFERENCES `room` (`Roo_id`),
  CONSTRAINT `order1_ibfk_3` FOREIGN KEY (`Emp_id`) REFERENCES `employess` (`Emp_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `order1` */

insert  into `order1`(`Ord_id`,`Emp_id`,`Cus_id`,`Roo_id`,`Ord_deposit`,`Ord_date`,`Ord_outdate`,`Ord_text`) values ('1548524668583','3','1577845514453','201',600,'2019-12-12','2019-12-13',NULL),('1548945662522','2','1577845688952','302',400,'2019-12-19','2019-12-20',NULL),('1548975245854','1','1577845514453','11',500,'2018-02-22','2019-12-22',NULL),('1554856251551','2','1577845514453','1',200,'2019-12-16','2019-12-19',NULL),('1577153444920','7','1577845514453','2',200,'2019-12-27','2019-12-28',NULL),('1577286506014','1','1577286258603','1',400,'2019-12-02','2019-12-03',NULL),('1577286616771','1','1577286581034','11',300,'2019-09-25','2019-12-26',NULL),('1577365433892','2','1577365331244','11',400,'2019-12-26','2019-12-27',NULL);

/*Table structure for table `room` */

DROP TABLE IF EXISTS `room`;

CREATE TABLE `room` (
  `Roo_id` varchar(10) NOT NULL,
  `Rok_id` varchar(20) NOT NULL,
  `Roo_state` int(4) NOT NULL,
  `Roo_text` text,
  `Roo_other` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`Roo_id`),
  KEY `Rok_id` (`Rok_id`),
  CONSTRAINT `room_ibfk_1` FOREIGN KEY (`Rok_id`) REFERENCES `roomkind` (`Rok_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `room` */

insert  into `room`(`Roo_id`,`Rok_id`,`Roo_state`,`Roo_text`,`Roo_other`) values ('1','1',0,'该房间有窗',NULL),('11','2',1,'该房间的噪音太大',NULL),('12','2',1,'大房间',NULL),('2','1',0,'该房间较为舒适',NULL),('201','2',1,'就好',NULL),('302','3',1,'大房间',NULL);

/*Table structure for table `roomkind` */

DROP TABLE IF EXISTS `roomkind`;

CREATE TABLE `roomkind` (
  `Rok_id` varchar(20) NOT NULL,
  `Rok_name` varchar(20) NOT NULL,
  `Rok_money` float NOT NULL,
  `Rok_total` int(11) NOT NULL,
  `Rok_surplus` int(11) NOT NULL,
  `Rok_delremark` int(4) DEFAULT NULL,
  `Rok_text` text,
  `Rok_other` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`Rok_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `roomkind` */

insert  into `roomkind`(`Rok_id`,`Rok_name`,`Rok_money`,`Rok_total`,`Rok_surplus`,`Rok_delremark`,`Rok_text`,`Rok_other`) values ('1','单人间',200,5,5,1,NULL,NULL),('2','双人间',300,5,5,1,NULL,NULL),('3','总统套间',500,5,5,1,NULL,NULL),('4','主题客房',1000,4,5,1,NULL,NULL),('5','三人间',350,5,5,0,NULL,NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
