-- MySQL dump 10.13  Distrib 5.6.16, for Win64 (x86_64)
--
-- Host: localhost    Database: scheduledb
-- ------------------------------------------------------
-- Server version	5.6.16

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
-- Table structure for table `schedule`
--

DROP TABLE IF EXISTS `schedule`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `schedule` (
  `id` int(11) NOT NULL,
  `days` varchar(255) NOT NULL,
  `groups` varchar(255) NOT NULL,
  `subject` varchar(255) NOT NULL,
  `teachers` varchar(255) NOT NULL,
  `time` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  UNIQUE KEY `subject` (`subject`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `schedule`
--

LOCK TABLES `schedule` WRITE;
/*!40000 ALTER TABLE `schedule` DISABLE KEYS */;
INSERT INTO `schedule` VALUES (1,'Lunes,Martes,Miercoles,Viernes','6GT2','Enginyeria de Aplicacions','Antonia Gallardo,Toni Oller','17:30-20:30,15:00-19:00,19:30-20:30,17:00-20:00'),(2,'Martes,Miercoles','6GT2','Planificació de Xarxes','Sebastià Sallent,David Rincón','19:00-21:00,17:30-19:30'),(3,'Jueves,Viernes','6GT2','Seguretat en Xarxes','Olga León,Juan Hernandez','15:00-16:30,15:00-17:00'),(4,'Lunes,Martes','5GM2','Xarxes Locals, d\'Access i Metropolitanes','Lluis Casals,Joan Mataix','08:00-11:00,08:00-10:00'),(5,'Lunes,Miercoles,Viernes','5GM2','Disseny d\'Aplicacions','Sergio Machado,Roc Meseguer','11:00-14:00,12:00-14:00,08:00-11:00'),(6,'Miercoles,Jueves','5GM2','Serveis Audivisuals sobre Internet','David Rincón','08:00-12:00,11:00-14:00'),(7,'Jueves,Viernes','5GM2','Anàlisis i Dimensionament de Xarxes','Ramon Piney','11:00-12:30,11:00-14:00'),(8,'Jueves','6GT2','Xarxes de Transport','Cristina Cervelló','16:30-21:00'),(9,'Lunes,Miercoles&Martes,Viernes','4GM11&4GT21','Circuits Electronics i Sistemes de Alimentació','Oscar&Gasulla','11:00-13:00,10:00-12:30&15:00-17:30,16:30-19:30'),(10,'Lunes,Jueves&Martes,Jueves','3GM11&3GT21','Fonaments de la Comunicació','Juan&Elotro','9:00-12:00,10:00-12:30&15:00-18:30,16:30-19:00'),(11,'Martes,Jueves','5GM2','Movilitat de Xarxes i Serveis','Carles Gómez,Enrica Zola','12:00-14:00,11:00-14:00'),(12,'Lunes,Miercoles','6GT2','Infraestructura i Organitzacions de les Telecomunicacions','Francesca Torrell,David Rincón','15:00-17:30,15:00-17:30');
/*!40000 ALTER TABLE `schedule` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-01-18 23:12:14
