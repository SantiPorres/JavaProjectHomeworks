-- MySQL dump 10.13  Distrib 8.0.33, for Linux (x86_64)
--
-- Host: localhost    Database: java_project_hw
-- ------------------------------------------------------
-- Server version	8.0.33-0ubuntu0.22.04.2

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `course`
--

DROP TABLE IF EXISTS `course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `course` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `teacher_id` bigint DEFAULT NULL,
  `school_grade` varchar(5) NOT NULL,
  `status` enum('active','inactive') DEFAULT (_utf8mb4'active'),
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `teacher_id` (`teacher_id`),
  CONSTRAINT `course_ibfk_1` FOREIGN KEY (`teacher_id`) REFERENCES `teacher` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course`
--

LOCK TABLES `course` WRITE;
/*!40000 ALTER TABLE `course` DISABLE KEYS */;
INSERT INTO `course` VALUES (1,1,'8vo','active','2023-05-12 15:26:16','2023-05-12 10:26:16'),(2,2,'3ro','active','2023-05-26 12:40:42','2023-05-26 07:40:42');
/*!40000 ALTER TABLE `course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `grade`
--

DROP TABLE IF EXISTS `grade`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `grade` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `homework_code` bigint NOT NULL,
  `student_id` bigint NOT NULL,
  `score` float DEFAULT '0',
  `status` enum('pending','qualified') NOT NULL DEFAULT 'pending',
  `homework_solution` varchar(1000) NOT NULL,
  `appreciation` varchar(255) DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `homework_code` (`homework_code`),
  KEY `student_id` (`student_id`),
  CONSTRAINT `grade_ibfk_1` FOREIGN KEY (`homework_code`) REFERENCES `homeworks` (`code`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `grade_ibfk_2` FOREIGN KEY (`student_id`) REFERENCES `students` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `grade`
--

LOCK TABLES `grade` WRITE;
/*!40000 ALTER TABLE `grade` DISABLE KEYS */;
INSERT INTO `grade` VALUES (2,2,1,4.2,'qualified','www.drive-tarea.com',NULL,'2023-05-17 01:54:37','2023-05-17 13:24:32'),(4,3,1,4,'qualified','1- 108432\nEsta es la respuesta','algo','2023-05-17 02:34:37','2023-06-26 07:51:34'),(5,4,1,0,'pending','www.unity.com',NULL,'2023-05-17 16:52:46','2023-05-17 12:48:04'),(6,2,2,2.3,'qualified','www.jose-armando-homework.com/https/hsopdiasjsonssdodjakjalsaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa','Faltaron los puntos 5-6-7','2023-05-17 21:53:21','2023-05-25 00:00:34'),(7,5,2,4.2,'qualified','www.drive-funciones-python.com','hizo la tarea bien','2023-05-18 02:08:02','2023-05-26 07:45:48'),(8,7,2,5,'qualified','uoiufidgoi',NULL,'2023-05-18 12:01:32','2023-05-18 07:02:07'),(9,4,2,2.55556,'qualified','Esta es la solución a la tarea',NULL,'2023-05-19 18:09:43','2023-05-19 13:14:12'),(10,9,2,0,'pending','esta es la tarea resuelta',NULL,'2023-05-26 12:46:59','2023-05-26 07:46:59'),(11,9,3,0,'pending','hola profe, no pude hacer la tarea porque estaba enferma.',NULL,'2023-05-26 12:59:49','2023-05-26 07:59:49'),(12,10,2,0,'pending','Este es el trabajo de photoshop profe\n',NULL,'2023-06-16 12:30:13','2023-06-16 07:30:13'),(13,11,1,1,'qualified','Ah profe, no la pude entregar','Muy mal','2023-06-16 15:19:43','2023-06-16 10:37:46'),(14,12,1,0,'pending','Estas son las funciones',NULL,'2023-06-16 15:38:40','2023-06-16 10:38:40'),(15,13,1,0,'pending','algo mas',NULL,'2023-06-26 12:53:11','2023-06-26 07:53:11');
/*!40000 ALTER TABLE `grade` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `homeworks`
--

DROP TABLE IF EXISTS `homeworks`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `homeworks` (
  `code` bigint NOT NULL AUTO_INCREMENT,
  `course_id` bigint NOT NULL,
  `title` varchar(100) NOT NULL,
  `description` varchar(500) DEFAULT NULL,
  `deadline` date NOT NULL,
  `resource` varchar(500) DEFAULT NULL,
  `status` enum('active','inactive') DEFAULT (_utf8mb4'active'),
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`code`),
  KEY `course_id` (`course_id`),
  CONSTRAINT `homeworks_ibfk_1` FOREIGN KEY (`course_id`) REFERENCES `course` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `homeworks`
--

LOCK TABLES `homeworks` WRITE;
/*!40000 ALTER TABLE `homeworks` DISABLE KEYS */;
INSERT INTO `homeworks` VALUES (1,1,'Sumas','Realizar las siguientes sumas','2023-05-13','','active','2023-05-12 15:28:06','2023-05-12 10:28:06'),(2,1,'Restas','Hacer las siguientes 10 restas','2023-05-30','www.google.com','active','2023-05-12 15:46:03','2023-05-17 16:52:21'),(3,1,'Multiplicaciones','Resuelvan estas multiplicaciones en casa','2023-05-18','www.holamundo.com','active','2023-05-17 02:32:48','2023-05-16 21:32:48'),(4,1,'Divisiones','Realizar las siguientes divisiones','2023-05-26','','active','2023-05-17 16:39:50','2023-05-17 11:39:50'),(5,1,'Funciones en python','Muy buenos dias muchachos, les adjunto el archivo de las 50 funciones en python que estabamos realizando en clase.\n\nPorfavor terminarlas y subirlas a esta evidencia.\n\nFeliz noche para todos.','2023-05-25','https://www.w3schools.com/sql/sql_join_inner.asp','active','2023-05-17 23:24:07','2023-05-17 18:24:07'),(6,1,'Funciones Java','','2023-05-17','https://www.google.com/search?channel=fs&client=ubuntu-sn&q=json+es+un+lenguaje%3F','active','2023-05-17 23:27:13','2023-05-17 18:27:13'),(7,1,'Funciones PHP','Hacer las siguientes funciones','2023-05-25','- https://www.google.com/search?channel=fs&client=ubuntu-sn&q=translate','active','2023-05-17 23:35:05','2023-05-17 18:35:05'),(8,1,'Funciones C#','','2023-05-17','https://www.google.com/search?channel=fs&client=ubuntu-sn&q=translate','active','2023-05-17 23:35:38','2023-05-17 18:35:38'),(9,2,'Tarea Diana Español','Investigación del romanticismo.\n\nSubir aqui el link de la sintesis realizada.','2023-05-30','www.google.com','active','2023-05-26 12:42:10','2023-05-26 07:42:10'),(10,1,'Photoshop 2','klasndoiubaskldal','2023-06-23','jkhjghf','active','2023-06-09 13:59:32','2023-06-09 08:59:32'),(11,1,'Programación en Java','Hacer el proyecto de java','2023-06-30','google.com	','active','2023-06-16 15:17:49','2023-06-16 10:17:49'),(12,1,'Clases en java','Hacer las siguientes funciones','2023-06-23','google.com	','active','2023-06-16 15:36:53','2023-06-16 10:36:53'),(13,1,'Hola esta es otra tarea','','2023-06-29','','active','2023-06-21 13:52:25','2023-06-21 08:52:25');
/*!40000 ALTER TABLE `homeworks` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `students`
--

DROP TABLE IF EXISTS `students`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `students` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `course_id` bigint NOT NULL,
  `identification_number` varchar(15) NOT NULL,
  `fullname` varchar(200) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(20) NOT NULL,
  `status` enum('active','inactive') DEFAULT (_utf8mb4'active'),
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `identification_number` (`identification_number`),
  KEY `course_id` (`course_id`),
  CONSTRAINT `students_ibfk_1` FOREIGN KEY (`course_id`) REFERENCES `course` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `students`
--

LOCK TABLES `students` WRITE;
/*!40000 ALTER TABLE `students` DISABLE KEYS */;
INSERT INTO `students` VALUES (1,1,'456','Geraldine Russo','geraldine@email.com','456','active','2023-05-12 15:26:16','2023-05-17 07:50:57'),(2,1,'123','Jose Armando','jose@email.com','123','active','2023-05-17 17:00:39','2023-05-17 12:00:39'),(3,2,'789','Milena  Artista','milena@email.com','789','active','2023-05-26 12:52:33','2023-05-26 07:52:33');
/*!40000 ALTER TABLE `students` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teacher`
--

DROP TABLE IF EXISTS `teacher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `teacher` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `cc` varchar(15) NOT NULL,
  `fullname` varchar(200) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(20) NOT NULL,
  `status` enum('active','inactive') DEFAULT (_utf8mb4'active'),
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cc` (`cc`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher`
--

LOCK TABLES `teacher` WRITE;
/*!40000 ALTER TABLE `teacher` DISABLE KEYS */;
INSERT INTO `teacher` VALUES (1,'123','Jorge Alberto Ramirez','jorge@email.com','jorge123','active','2023-05-12 15:26:15','2023-05-12 10:26:15'),(2,'789','Diana Duque','diana@email.com','diana789','active','2023-05-26 12:40:26','2023-05-26 07:40:26');
/*!40000 ALTER TABLE `teacher` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-06-28 21:24:52
