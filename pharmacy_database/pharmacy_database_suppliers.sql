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
-- Table structure for table `suppliers`
--

DROP TABLE IF EXISTS `suppliers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `suppliers` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(60) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `telephone` varchar(20) DEFAULT NULL,
  `address` varchar(60) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `city` varchar(60) DEFAULT NULL,
  `created` datetime DEFAULT NULL,
  `updated` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `suppliers`
--

LOCK TABLES `suppliers` WRITE;
/*!40000 ALTER TABLE `suppliers` DISABLE KEYS */;
INSERT INTO `suppliers` VALUES (1,'Natural','Distribucion de productos naturales','987654321','Calle 653','natura@sac.com','Ica','2023-03-27 21:25:49','2023-04-08 00:36:39'),(2,'PeruFarma','Incrementamos y aceleramos la comercialización de sus productos a nivel nacional a través de nuestro servicio de distribución de mercadería.','1234567','Los Olivos','perufarma@gmail.com','Lima','2023-03-28 11:23:59','2023-04-08 09:29:40'),(3,'JenFarma','Nos dirigimos al sector Farmacéutico, Farmacias, Boticas, y Hospitales. Nos diferenciamos por nuestra calidad de nuestros productos y puntualidad en las entregas.','5725377 - 998263249','Jirón Amazonas - 3760 San Martin de Porres','laboratoriojenfarma@hotmail.com','Ica','2023-04-07 00:29:20','2023-04-08 09:31:15'),(5,'J & R PERUVIAN S.A.C','Comercialización e importación de medicinas. Material médico e insumos.','951 652 978','Jirón Carhuaz - 381 Chacra Colorada','ventas@jrperuvian.com','Lima','2023-04-08 00:01:32','2023-04-08 09:39:22'),(6,'DROGUERIA VMG','Droguería Vmg, una empresa dedicada a la importación, comercialización, almacenamiento y distribución de productos farmacéuticos, sanitarios y dispositivos médicos.','992 268 139','Avenida Moche - 951 La Libertad Trujillo','administracion@invermedicvmg.com.pe','Lima','2023-04-08 00:14:10','2023-04-08 17:15:27'),(7,'BREMEN PHARMA','Distribuidores de Productos Galénicos.','(01) 4491650','Calle Puerto Eten - 190 Urb.La Castellana','www.bremenpharma.com','Lima','2023-04-08 00:23:02','2023-04-08 17:15:15'),(8,'IXAFARMA_','Distribución de medicamentos.','961 918 166','Calle MZ H, Int A. Lte. 36','ixafarma@hotmail.com','Lima','2023-04-08 00:23:36','2023-04-08 09:37:06');
/*!40000 ALTER TABLE `suppliers` ENABLE KEYS */;
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
