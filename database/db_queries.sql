DROP DATABASE IF EXISTS employee_system:
CREATE DATABASE employee_system:

USE employee_system:

CREATE TABLE `employee` (
  `id` int NOT NULL,
  `name` varchar(30) NOT NULL,
  `phone_number` varchar(30) NOT NULL,
  `male` tinyint NOT NULL,
  `salary` double NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


