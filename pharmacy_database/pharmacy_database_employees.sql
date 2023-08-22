-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: pharmacy_database
-- ------------------------------------------------------
-- Server version	8.0.27

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `employees`
--

DROP TABLE IF EXISTS `employees`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employees` (
  `id` int NOT NULL AUTO_INCREMENT,
  `full_name` varchar(60) DEFAULT NULL,
  `username` varchar(60) DEFAULT NULL,
  `address` varchar(60) DEFAULT NULL,
  `telephone` varchar(20) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `rol` varchar(20) DEFAULT NULL,
  `created` datetime DEFAULT NULL,
  `updated` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employees`
--

LOCK TABLES `employees` WRITE;
/*!40000 ALTER TABLE `employees` DISABLE KEYS */;
INSERT INTO `employees` VALUES (1,'Piero Vasquez Gereda','PiVaGe','Av Los Angeles #150',NULL,'pieroangello7@gmail.com','123','Administrador',NULL,'2023-04-13 13:06:19'),(2,'Angello Vasquez Gereda','Anvage','Av Los Angeles #150','981234567','anvage@gmail.com','1234','Auxiliar','2023-03-25 14:29:27','2023-04-02 19:09:07'),(6,'Dorotea de Villalba Carrasco','Dorotea','Calle 234','72487694','Dorotea.Carrasco@gmail.com','1234','Administrador','2023-04-02 16:57:49','2023-04-02 16:57:49'),(9,'Valentina Aroca Prat','Valentina','Calle 567','73101266','Valentina.Aroca@gmail.com','1234','Administrador','2023-04-02 16:57:49','2023-04-02 16:57:49'),(10,'Josué Pol Salamanca','Josue','Calle 678','77147374','Josue.Salamanca@gmail.com','1234','Administrador','2023-04-02 16:57:49','2023-04-02 16:57:49'),(11,'Encarna Nieto Cañas','Encarna','Calle 789','75272226','Encarna.Canas@gmail.com','1234','Administrador','2023-04-02 16:57:49','2023-04-02 16:57:49'),(12,'Jovita Marisol Pareja Bautista','Jovita Marisol','Calle 901','71859514','Marisol.Pareja@gmail.com','1234','Administrador','2023-04-02 16:57:49','2023-04-03 10:50:40'),(13,'Felipe Cabezas Martinez','Felipe','Calle 1011','79467330','Felipe.Cabezas@gmail.com','1234','Auxiliar','2023-04-02 16:57:49','2023-04-02 16:57:49'),(15,'Cintia de Boada Medina','Cintia','Calle 1233','79085424','Cintia.Medina@gmail.com','1234','Auxiliar','2023-04-02 16:57:49','2023-04-02 16:57:49'),(16,'Cruz de Perales Caceres','Cruz','Calle 1344','79296755','Cruz.Caceres@gmail.com','1234','Auxiliar','2023-04-02 16:57:49','2023-04-02 16:57:49'),(17,'Iván Estévez Azorin','Ivan','Calle 1455','70329265','Ivan.Estevez@gmail.com','1234','Auxiliar','2023-04-02 16:57:49','2023-04-02 16:57:49'),(18,'Ramona Anna Piñeiro Ibáñez','Ramona','Calle 1566','73284932','Ramona.Piñeiro@gmail.com','1234','Auxiliar','2023-04-02 16:57:49','2023-04-02 16:57:49'),(19,'Remedios Contreras Esteve','Remedios','Calle 1677','73985568','Remedios.Contreras@gmail.com','1234','Auxiliar','2023-04-02 16:57:49','2023-04-02 16:57:49'),(20,'Pablo Borja Royo','Pablo','Calle 1788','77339883','Pablo.Borja@gmail.com','1234','Auxiliar','2023-04-02 16:57:49','2023-04-03 22:55:56');
/*!40000 ALTER TABLE `employees` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-07-25 19:14:28
