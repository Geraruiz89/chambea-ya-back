-- MariaDB dump 10.18  Distrib 10.5.7-MariaDB, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: publisher
-- ------------------------------------------------------
-- Server version	10.5.7-MariaDB-1:10.5.7+maria~focal

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


DROP DATABASE IF EXISTS publisher;
CREATE DATABASE publisher;
USE publisher;

--
-- Table structure for table `caracteristica_producto`
--

DROP TABLE IF EXISTS `caracteristica_producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `caracteristica_producto` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_producto` int(11) DEFAULT NULL,
  `descripcion` varchar(256) DEFAULT NULL,
  `activa` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `caracteristica_producto`
--

LOCK TABLES `caracteristica_producto` WRITE;
/*!40000 ALTER TABLE `caracteristica_producto` DISABLE KEYS */;
INSERT INTO `caracteristica_producto` VALUES (1,1,'Su resolucion XYZW123',1),(2,1,'Manejalo con la voz',1),(3,1,'Conecta tus dispositivos',1),(4,1,'Dimensiones perfects',1),(5,1,'Entretenimiento sin fin',1),(6,2,'Futurista',1),(7,2,'Rebajada',1),(8,3,'Rematada',1),(9,3,'Dream shop',1),(10,3,'Excelente',1),(11,4,'Inmejorable',1),(12,4,'Perfecta',1);
/*!40000 ALTER TABLE `caracteristica_producto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `imagen_producto`
--

DROP TABLE IF EXISTS `imagen_producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `imagen_producto` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_producto` int(11) DEFAULT NULL,
  `nombre` varchar(256) DEFAULT NULL,
  `activa` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `imagen_producto`
--

LOCK TABLES `imagen_producto` WRITE;
/*!40000 ALTER TABLE `imagen_producto` DISABLE KEYS */;
INSERT INTO `imagen_producto` VALUES (1,1,'D-1.jpg',1),(2,1,'D-2.jpg',1),(3,1,'D-3.jpg',1),(4,1,'D-4.jpg',1),(5,1,'D-5.jpg',1),(6,2,'02-01.jpg',1),(7,2,'02-02.jpg',1),(8,3,'03-01.jpg',1),(9,3,'03-02.jpg',1),(10,3,'03-03.jpg',1),(11,4,'04-01.jpg',1),(12,4,'04-02.jpg',1),(13,4,'04-03.jpg',1),(14,4,'04-04.jpg',1),(15,4,'04-05.jpg',1),(16,4,'04-06.jpg',1),(17,4,'04-07.jpg',1);
/*!40000 ALTER TABLE `imagen_producto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `producto`
--

DROP TABLE IF EXISTS `producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `producto` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(256) DEFAULT NULL,
  `total_stars` decimal(10,1) DEFAULT NULL,
  `votos_totales` int(11) DEFAULT NULL,
  `vendidas` int(11) DEFAULT NULL,
  `precio` decimal(10,0) DEFAULT NULL,
  `mensualidad` int(11) DEFAULT NULL,
  `minutos` int(11) DEFAULT NULL,
  `direccion` varchar(256) DEFAULT NULL,
  `num_ventas` int(11) DEFAULT NULL,
  `total_prod` int(11) DEFAULT NULL,
  `unidades` int(11) DEFAULT NULL,
  `tienda` varchar(128) DEFAULT NULL,
  `total_ventas` int(11) DEFAULT NULL,
  `meses` int(11) DEFAULT NULL,
  `espec_dia` varchar(32) DEFAULT NULL,
  `descripcion` varchar(32) DEFAULT NULL,
  `activa` tinyint(1) DEFAULT NULL,
  `nombre_imagen_principal` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producto`
--

LOCK TABLES `producto` WRITE;
/*!40000 ALTER TABLE `producto` DISABLE KEYS */;
INSERT INTO `producto` VALUES (1,'Pantalla JVC SI32H LCD HD 32 110V/240V',2.8,23,63,2916,917,57,'Cuernavaca Morelos',500,32,24,'Glogi',1000,3,'Martes','descipcion 01',1,'D-1.jpg'),(2,'Sony PlayStation 5 825GB color blanco y negro',5.0,500,500,13594,1359,180,'Jiutepec Morelos',7000,1,89,'Sony enterteiment',900,10,'Domingo','descipcion 02',1,'02-01.jpg'),(3,'Metabo Ge 950 G Plus Mototool/rectificador Recto 950w 110v',4.0,2,4,7978,664,180,'Tlaltizapan Morelos',5,10,1,'Metabo',40,12,'Jueves','',1,'03-01.jpg'),(4,'Interfaz de audio Focusrite Scarlett Solo 220V roja 3.ª gen',5.0,68,500,2756,275,250,'Tepoztlan Morelos',100,5,1,'Milan Inter',100,10,'Miercoles','descipcion 03',1,'04-02.jpg');
/*!40000 ALTER TABLE `producto` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-03-16  7:09:18
