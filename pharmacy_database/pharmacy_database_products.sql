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
-- Table structure for table `products`
--

DROP TABLE IF EXISTS `products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `products` (
  `id` int NOT NULL AUTO_INCREMENT,
  `code` varchar(20) DEFAULT NULL,
  `name` varchar(60) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `unit_price` double DEFAULT NULL,
  `product_quantity` int DEFAULT NULL,
  `created` datetime DEFAULT NULL,
  `updated` datetime DEFAULT NULL,
  `category_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `code_UNIQUE` (`code`),
  KEY `product_category_idx` (`category_id`),
  CONSTRAINT `product_category` FOREIGN KEY (`category_id`) REFERENCES `categories` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `products`
--

LOCK TABLES `products` WRITE;
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
INSERT INTO `products` VALUES (1,'2020','Metambel','Metamizol Sódico 1g/2ml.',21,149,'2023-03-29 12:42:17','2023-04-09 01:05:20',2),(7,'2021','Diclofenaco','Analgésico - Antiinflamatorio',9.5,74,'2023-03-30 00:51:39','2023-04-08 09:47:09',2),(10,'5454','Dicloambel','Diclofenaco Sódico',22,97,'2023-03-30 11:21:38','2023-04-08 09:47:03',2),(14,'3030','VitalBell','Colágeno Hidrolizado',15.5,0,'2023-04-08 09:49:26','2023-04-14 14:44:28',1),(15,'777570104444','Headphones','Samsungs',25,10,'2023-04-12 13:09:51','2023-04-12 13:09:51',5),(16,'2003405465519','Azucar Blanca','1kg Marca Tottus',10,NULL,'2023-04-12 13:42:55','2023-04-14 18:54:34',3),(17,'7751158007740','Vape','Plaguicida de uso domestico en pastilla',7.6,10,'2023-04-12 14:01:55','2023-04-12 14:03:29',1),(20,'7752650000260','Algodón','Algodon mas suave y absorbente para ser usado en la limpieza.',8,15,'2023-04-12 14:16:35','2023-04-12 14:16:35',5),(21,'7751731157350','Agua Cielo','1/2 Litro de Agua Cielo',1.5,10,'2023-04-12 21:25:31','2023-04-12 21:25:31',1),(23,'1113','Asdf','asd',1,NULL,'2023-04-13 13:50:39','2023-04-13 13:54:48',1),(25,'1380556511076','Dispensador de Cinta','Oval',12.4,NULL,'2023-04-14 14:55:18','2023-04-14 14:55:18',5),(26,'7754111018333','Plumon azul','Faber Castell',3.5,NULL,'2023-04-14 15:10:27','2023-04-14 18:54:24',5),(27,'7750049612964','Cuaderno Justus','Cuaderno Doble Reglon',5.5,NULL,'2023-04-14 15:12:19','2023-04-14 15:14:10',1),(28,'7754111018319','Plumon Rojo','Faber Castell',3.5,NULL,'2023-04-14 15:16:03','2023-04-14 15:16:03',1),(29,'6903485221618','Equipo de sonido Portable','Modelo LD-S3677FM-BT',38.5,NULL,'2023-04-14 15:19:35','2023-04-14 15:19:35',1),(30,'7751257021838','Toallitas humedas Aloe Vera','Ninet - 100 Toallitas extra gruesa',18.9,NULL,'2023-04-14 15:22:22','2023-04-14 15:22:22',1),(31,'6941237125460','Audifonos TWS inhalambricos','300mAh battery con estuche de carga',55,NULL,'2023-04-14 15:25:16','2023-04-14 18:55:02',5),(32,'6937594602621','Espiral Antimosquitos','5 Espirales Dobles',5.7,NULL,'2023-04-14 15:26:20','2023-04-14 15:26:20',1);
/*!40000 ALTER TABLE `products` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-07-25 19:14:27
