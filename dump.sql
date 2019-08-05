CREATE DATABASE  IF NOT EXISTS `formula1` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `formula1`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: formula1
-- ------------------------------------------------------
-- Server version	5.5.5-10.2.8-MariaDB

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
-- Table structure for table `arquibancada`
--

DROP TABLE IF EXISTS `arquibancada`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `arquibancada` (
  `id_arquibancada` int(11) NOT NULL AUTO_INCREMENT,
  `setor` varchar(1) NOT NULL,
  `totalAssentos` int(11) NOT NULL,
  `id_autodromo` int(11) NOT NULL,
  PRIMARY KEY (`id_arquibancada`),
  KEY `fk_id_autodromo_arquibancada_idx` (`id_autodromo`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `autodromo`
--

DROP TABLE IF EXISTS `autodromo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `autodromo` (
  `id_autodromo` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) DEFAULT NULL,
  `endereco` varchar(300) DEFAULT NULL,
  `cidade` varchar(40) NOT NULL,
  `pais` varchar(20) NOT NULL,
  `descricao` text DEFAULT NULL,
  `imagem` text DEFAULT NULL,
  PRIMARY KEY (`id_autodromo`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `circuito`
--

DROP TABLE IF EXISTS `circuito`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `circuito` (
  `id_circuito` int(11) NOT NULL AUTO_INCREMENT,
  `nome_circuito` varchar(300) DEFAULT NULL,
  `total_corredores` int(11) NOT NULL,
  `data` datetime NOT NULL,
  `descricao` text DEFAULT NULL,
  `imagem` varchar(300) DEFAULT NULL,
  `id_autodromo` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_circuito`),
  KEY `fk_idAutodromo` (`id_autodromo`),
  CONSTRAINT `fk_idAutodromo` FOREIGN KEY (`id_autodromo`) REFERENCES `autodromo` (`id_autodromo`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `ingresso`
--

DROP TABLE IF EXISTS `ingresso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ingresso` (
  `id_ingresso` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(300) DEFAULT NULL,
  `data_evento` datetime NOT NULL,
  `cidade` varchar(45) NOT NULL,
  `pais` varchar(45) NOT NULL,
  `preco` float(6,2) NOT NULL,
  `descricao` text DEFAULT NULL,
  `arquibancada_id_arquibancada` int(11) NOT NULL,
  PRIMARY KEY (`id_ingresso`),
  KEY `fk_ingresso_arquibancada1_idx` (`arquibancada_id_arquibancada`),
  CONSTRAINT `fk_ingresso_arquibancada1` FOREIGN KEY (`arquibancada_id_arquibancada`) REFERENCES `arquibancada` (`id_arquibancada`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `ingresso_pessoa`
--

DROP TABLE IF EXISTS `ingresso_pessoa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ingresso_pessoa` (
  `id_ingressopessoa` int(11) NOT NULL AUTO_INCREMENT,
  `pessoa_cpf` int(11) NOT NULL,
  `id_ingresso` int(11) NOT NULL,
  `nmr_Assento` int(11) DEFAULT NULL,
  `tipo_entrada` varchar(7) NOT NULL,
  PRIMARY KEY (`id_ingressopessoa`),
  KEY `fk_ingresso_pessoa_pessoa_idx` (`pessoa_cpf`),
  KEY `fk_ingresso_pessoa_ingresso1_idx` (`id_ingresso`),
  CONSTRAINT `fk_ingresso_pessoa_ingresso1` FOREIGN KEY (`id_ingresso`) REFERENCES `ingresso` (`id_ingresso`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_ingresso_pessoa_pessoa` FOREIGN KEY (`pessoa_cpf`) REFERENCES `pessoa` (`cpf`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `pessoa`
--

DROP TABLE IF EXISTS `pessoa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pessoa` (
  `nomeCompleto` varchar(60) NOT NULL,
  `cpf` int(11) NOT NULL,
  `rg` varchar(10) NOT NULL,
  `email` varchar(100) NOT NULL,
  `celular` varchar(9) DEFAULT NULL,
  `senha` varchar(20) NOT NULL,
  `cep` varchar(10) NOT NULL,
  `endereco` varchar(200) NOT NULL,
  `cidade` varchar(45) NOT NULL,
  `pais` varchar(20) NOT NULL,
  PRIMARY KEY (`cpf`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping routines for database 'formula1'
--
/*!50003 DROP PROCEDURE IF EXISTS `inserir_ingresso` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `inserir_ingresso`(in nome varchar(45),
                                  in data_evento datetime,
                                  in cidade varchar(45),
                                  in pais varchar(45),
                                  in preco float(6,2),
                                  in descricao varchar(300),
                                  in arquibancada_id_arquibancada int(11))
BEGIN
	insert into ingresso values(null,nome,data_evento,cidade,pais,preco,descricao,arquibancada_id_arquibancada);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-12-03 11:15:12
