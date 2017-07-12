-- MySQL dump 10.13  Distrib 5.7.18, for Linux (x86_64)
--
-- Host: localhost    Database: RESTful_in_Peace
-- ------------------------------------------------------
-- Server version	5.7.18-0ubuntu0.16.04.1

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
-- Table structure for table `admin_authentication`
--

DROP TABLE IF EXISTS `admin_authentication`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `admin_authentication` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `admin_privilege` int(11) NOT NULL,
  `password` tinyblob NOT NULL,
  `token` varchar(255) DEFAULT NULL,
  `username` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_59hl6gra6tde9m6fbyoy5gk6j` (`username`),
  KEY `admin_authentication_id` (`id`),
  KEY `admin_authentication_username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin_authentication`
--

LOCK TABLES `admin_authentication` WRITE;
/*!40000 ALTER TABLE `admin_authentication` DISABLE KEYS */;
INSERT INTO `admin_authentication` VALUES (1,0,'b22C3CcDfD3f3C2bce9Ae5c2fACb29Abb275BceCcccDbD1cbDB9bb1DCf53Bf7A',NULL,'ashik'),(2,1,'e131ADD73bBe551f1C9AbDD79Ce1eBACfc1Aae2aC5eEDDEAD7Ac5b3f17b1Afe9',NULL,'ashif'),(3,3,'C7B77c2ebDD33eCA1EE571a2aabca9eBC193EBE7af2AbfBB7E5A2aefA5E72bb5',NULL,'akash');
/*!40000 ALTER TABLE `admin_authentication` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `doctor_patient_visiting`
--

DROP TABLE IF EXISTS `doctor_patient_visiting`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `doctor_patient_visiting` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `doctor_fee` double NOT NULL,
  `is_effective` bit(1) DEFAULT NULL,
  `doctor_prediction` varchar(255) DEFAULT NULL,
  `doctor_suggestion` varchar(255) DEFAULT NULL,
  `patient_symptoms` varchar(255) DEFAULT NULL,
  `visiting_date_time` datetime DEFAULT NULL,
  `doctor_id` bigint(20) DEFAULT NULL,
  `patient_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `doctor_patient_visiting_doctor_fee` (`doctor_fee`),
  KEY `doctor_patient_visiting_patient_symptoms` (`patient_symptoms`),
  KEY `doctor_patient_visiting_doctor_prediction` (`doctor_prediction`),
  KEY `doctor_patient_visiting_doctor_suggestion` (`doctor_suggestion`),
  KEY `FKitqaupypr77vc5p04trbtkwap` (`doctor_id`),
  KEY `FKalvpbv7htgsr9298nj8gsjmim` (`patient_id`),
  CONSTRAINT `FKalvpbv7htgsr9298nj8gsjmim` FOREIGN KEY (`patient_id`) REFERENCES `patients` (`id`),
  CONSTRAINT `FKitqaupypr77vc5p04trbtkwap` FOREIGN KEY (`doctor_id`) REFERENCES `doctors` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `doctor_patient_visiting`
--

LOCK TABLES `doctor_patient_visiting` WRITE;
/*!40000 ALTER TABLE `doctor_patient_visiting` DISABLE KEYS */;
INSERT INTO `doctor_patient_visiting` VALUES (1,1000,NULL,NULL,NULL,NULL,'2019-05-07 00:00:00',1,3),(2,700,NULL,NULL,NULL,NULL,'2018-07-07 00:00:00',3,3),(3,900,NULL,NULL,NULL,NULL,'2018-03-07 00:00:00',2,1),(4,1000,NULL,NULL,NULL,NULL,'2018-02-07 00:00:00',1,1),(5,1500,NULL,NULL,NULL,NULL,'2018-02-07 00:00:00',1,2),(6,1000,NULL,NULL,NULL,NULL,'2018-07-07 00:00:00',3,2),(7,1000,NULL,NULL,NULL,NULL,'2018-03-07 00:00:00',2,6);
/*!40000 ALTER TABLE `doctor_patient_visiting` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `doctors`
--

DROP TABLE IF EXISTS `doctors`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `doctors` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) NOT NULL,
  `birth_date` date DEFAULT NULL,
  `city_name` varchar(255) NOT NULL,
  `country_name` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `first_name` varchar(255) NOT NULL,
  `gender` int(11) NOT NULL,
  `last_name` varchar(255) NOT NULL,
  `password` longblob NOT NULL,
  `phone_number` varchar(255) DEFAULT NULL,
  `state_name` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_caifv0va46t2mu85cg5afmayf` (`email`),
  UNIQUE KEY `UK_15xrlsp4drthssb0ns4pghcfk` (`username`),
  KEY `doctors_city_name` (`city_name`),
  KEY `doctors_username` (`username`),
  KEY `doctors_email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `doctors`
--

LOCK TABLES `doctors` WRITE;
/*!40000 ALTER TABLE `doctors` DISABLE KEYS */;
INSERT INTO `doctors` VALUES (1,'90 Banksia Court','1937-02-22','NONDA QLD 4822','Australia','RichardSBryant@dayrep.com','Richard',0,'S. Bryant','Bb2ecDae7bbA5CDb7cA7EEE22E3ece9c7aaEbA7BaCc392EBfBa5e3e1EfAB3BAe','(07) 4066 5672','NONDA','user1'),(2,'3541 O Conner Street','1958-02-05','Gulfport, MS 39501 ','USA','TonyaPSchisler@dayrep.com','Tonya',1,'P. Schisler','1cca5Ce5D3Da77Aaaf1BeA21c1EDE5E5cfaaE771e57eB31E9fE5C29bED7aEfE5','228-623-2964','Gulfport','user2'),(3,'Via Loreto, 80','1970-01-22','63044-Comunanza AP ','Italy','DonaldJJones@dayrep.com ','Donald',0,'J. Jones','DCE3b2EDBeDEEAAe2BcCAcb9baDeab91C9A97ffcBAA32fAff19BEfAEC1EBaBD5','0353 1696839','Comunanza AP','user3');
/*!40000 ALTER TABLE `doctors` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patients`
--

DROP TABLE IF EXISTS `patients`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `patients` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) NOT NULL,
  `birth_date` date DEFAULT NULL,
  `city_name` varchar(255) NOT NULL,
  `country_name` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `first_name` varchar(255) NOT NULL,
  `gender` int(11) NOT NULL,
  `last_name` varchar(255) NOT NULL,
  `password` longblob NOT NULL,
  `phone_number` varchar(255) DEFAULT NULL,
  `state_name` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_a370hmxgv0l5c9panryr1ji7d` (`email`),
  UNIQUE KEY `UK_myobm1tnc2tqmyk2fxl8ujpfj` (`username`),
  KEY `patients_city_name` (`city_name`),
  KEY `patient_username` (`username`),
  KEY `patient_email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patients`
--

LOCK TABLES `patients` WRITE;
/*!40000 ALTER TABLE `patients` DISABLE KEYS */;
INSERT INTO `patients` VALUES (1,'2298 Biddie Lane','1960-09-12','Richmond, VA 23219 ','USA','JeremyCJohnson@rhyta.com','Jeremy',0,'C. Johnson','Bb2ecDae7bbA5CDb7cA7EEE22E3ece9c7aaEbA7BaCc392EBfBa5e3e1EfAB3BAe','804-628-2745','Richmond','user1'),(2,'3592 Tenmile Road','1947-04-27','Cambridge, MA 02142','UK','PamelaRLane@teleworm.us','Pamela',1,'R. Lane','1cca5Ce5D3Da77Aaaf1BeA21c1EDE5E5cfaaE771e57eB31E9fE5C29bED7aEfE5','781-679-1019','Cambridge','user2'),(3,'1481 Shadowmar Drive','1957-07-24','New Orleans, LA 70118 ','USA','KimberlyMPatterson@dayrep.com ','Kimberly',1,'M. Patterson','DCE3b2EDBeDEEAAe2BcCAcb9baDeab91C9A97ffcBAA32fAff19BEfAEC1EBaBD5','504-866-3244','New Orleans','user3'),(4,'3065 Lake Floyd Circle','1969-07-26','Gaithersburg, MD 20877 ','USA','JacklynSHilton@jourrapide.com','Jacklyn',1,'S. Hilton','f7Bcfa77aB5e77Dc22Ab2Cef22eBafEE7e5b73eAAAfb2a97C3AbBec7AADDfE3C','301-948-8248','Gaithersburg','user4'),(5,'3454 Kinney Street','1987-06-16','Holyoke, MA 01040 ','USA','JanEMurray@armyspy.com','Jan',1,'E. Murray','bc51cc2bAABA91EB91A79CBAbf9cf9b9CCD1fcf97aED15Da71bB15af57c19D3E','413-534-3984','Holyoke','user5'),(6,'Eichendorffstr. 14','1945-05-11','84053 Rottenburg ','Germany','RuthJAleman@teleworm.us','Ruth',1,'J. Aleman','A37eBBEaEcC3cCfbEBDBcB555D75cfC57bcC51a9Ac711EfeDbcfED5aDccbDDBD','07457 38 29 19','Rottenburg ','user6');
/*!40000 ALTER TABLE `patients` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `system_logs`
--

DROP TABLE IF EXISTS `system_logs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `system_logs` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `log_date` datetime DEFAULT NULL,
  `exception_class` varchar(255) DEFAULT NULL,
  `log_message` varchar(1000) DEFAULT NULL,
  `object_state` varchar(2000) DEFAULT NULL,
  `parent_class` varchar(255) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `log_list_user_id` (`user_id`),
  KEY `log_list_log_date` (`log_date`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `system_logs`
--

LOCK TABLES `system_logs` WRITE;
/*!40000 ALTER TABLE `system_logs` DISABLE KEYS */;
INSERT INTO `system_logs` VALUES (1,'2017-07-13 05:38:36','java.lang.NullPointerException',NULL,'Visiting{id=null, doctorFee=900.0, symptoms=null, prediction=null, suggestions=null, isEffective=null, visitingDate=Mon May 07 00:00:00 BDT 2018}','com.studevs.dummy.restful.in.peace.controllers.rest_controllers.CreateVisitingController',4),(2,'2017-07-13 05:39:29','java.lang.NullPointerException',NULL,'Visiting{id=null, doctorFee=900.0, symptoms=null, prediction=null, suggestions=null, isEffective=null, visitingDate=Wed Mar 07 00:00:00 BDT 2018}','com.studevs.dummy.restful.in.peace.controllers.rest_controllers.CreateVisitingController',4);
/*!40000 ALTER TABLE `system_logs` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-07-13  5:46:51
