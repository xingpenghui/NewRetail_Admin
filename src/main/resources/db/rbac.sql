-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: db_newretail
-- ------------------------------------------------------
-- Server version	5.7.18-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `sys_member`
--

DROP TABLE IF EXISTS `sys_member`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_member` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `mname` varchar(20) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `ctime` datetime DEFAULT NULL,
  `flag` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `i_mname` (`mname`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_member`
--

LOCK TABLES `sys_member` WRITE;
/*!40000 ALTER TABLE `sys_member` DISABLE KEYS */;
INSERT INTO `sys_member` VALUES (1,'admin','v/Q7WDs24G/oneuI3VjfMQ==','2019-08-16 14:40:53',1);
/*!40000 ALTER TABLE `sys_member` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_permission`
--

DROP TABLE IF EXISTS `sys_permission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `icon` varchar(30) DEFAULT NULL,
  `parentid` int(11) DEFAULT NULL,
  `prms` varchar(50) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `level` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_permission`
--

LOCK TABLES `sys_permission` WRITE;
/*!40000 ALTER TABLE `sys_permission` DISABLE KEYS */;
INSERT INTO `sys_permission` VALUES (1,'系统首页','icon-home',-1,'',1,1),(2,'产品管理','icon-desktop',-1,'',1,1),(3,'图片管理','icon-picture',-1,'',1,1),(4,'交易管理','icon-list',-1,'',1,1),(5,'支付管理','icon-credit-card',-1,'',1,1),(6,'会员管理','icon-user',-1,'',1,1),(7,'消息管理','icon-home',-1,'',1,1),(8,'文章管理','icon-home',-1,'',1,1),(9,'财务管理','icon-home',-1,'',1,1),(10,'系统管理','icon-home',-1,'',1,1),(11,'管理员管理','icon-home',-1,'',1,1),(12,'产品列表','',2,'Products_List.html',1,2),(13,'品牌管理','',2,'Brand_Manage.html',1,2),(14,'分类管理','',2,'Category_Manage.html',1,2),(15,'广告管理','',3,'advertising.html',1,2),(16,'分类管理','',3,'Sort_ads.html',1,2),(17,'交易信息','',4,'transaction.html',1,2),(18,'交易订单','',4,'Order_Chart.html',1,2),(19,'订单管理','',4,'Orderform.html',1,2);
/*!40000 ALTER TABLE `sys_permission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_role`
--

DROP TABLE IF EXISTS `sys_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `info` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_role`
--

LOCK TABLES `sys_role` WRITE;
/*!40000 ALTER TABLE `sys_role` DISABLE KEYS */;
INSERT INTO `sys_role` VALUES (1,'管理员','拥有一切权限，严禁泄露');
/*!40000 ALTER TABLE `sys_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_rolepermission`
--

DROP TABLE IF EXISTS `sys_rolepermission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_rolepermission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `rid` int(11) DEFAULT NULL,
  `pid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_rolepermission`
--

LOCK TABLES `sys_rolepermission` WRITE;
/*!40000 ALTER TABLE `sys_rolepermission` DISABLE KEYS */;
INSERT INTO `sys_rolepermission` VALUES (1,1,1),(2,1,2),(3,1,3),(4,1,4),(5,1,5),(6,1,6),(7,1,7),(8,1,8),(9,1,9),(10,1,10),(11,1,11),(12,1,12),(13,1,13),(14,1,14),(15,1,15),(16,1,16),(17,1,17),(18,1,18),(19,1,19);
/*!40000 ALTER TABLE `sys_rolepermission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_userrole`
--

DROP TABLE IF EXISTS `sys_userrole`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_userrole` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) DEFAULT NULL,
  `rid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_userrole`
--

LOCK TABLES `sys_userrole` WRITE;
/*!40000 ALTER TABLE `sys_userrole` DISABLE KEYS */;
INSERT INTO `sys_userrole` VALUES (1,1,1);
/*!40000 ALTER TABLE `sys_userrole` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_user`
--

DROP TABLE IF EXISTS `t_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `phone` varchar(12) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `flag` smallint(6) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `phone` (`phone`),
  KEY `i_uphone` (`phone`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_user`
--

LOCK TABLES `t_user` WRITE;
/*!40000 ALTER TABLE `t_user` DISABLE KEYS */;
INSERT INTO `t_user` VALUES (1,'110','63w+z8BXlz/KXGsn11Shew==',1),(2,'18515990152','DypIQ0UENoTPHTxVMHOwNg==',1);
/*!40000 ALTER TABLE `t_user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-08-19 10:45:58
