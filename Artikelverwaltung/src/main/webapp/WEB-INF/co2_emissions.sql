-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 06, 2024 at 07:49 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `co2_emissions`
--

-- --------------------------------------------------------

--
-- Table structure for table `artikel`
--

CREATE TABLE `artikel` (
  `nr` int(11) NOT NULL,
  `verfuegbarAb` datetime(6) DEFAULT NULL,
  `DTYPE` varchar(31) NOT NULL,
  `bild` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `text` varchar(255) DEFAULT NULL,
  `trailer` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `artikel`
--

INSERT INTO `artikel` (`nr`, `verfuegbarAb`, `DTYPE`, `bild`, `name`, `text`, `trailer`) VALUES
(1, '2012-12-23 00:00:00.000000', 'Artikel', 'filzschuhe.jpg', 'Pantoffeln \"Rudolph\"', 'Wunderschöne Filzpantoffeln, in beige Farbe mit einem braunen und schwarzen Kringel. Sehr angenehm für kalte Wintertage.', NULL),
(2, '2010-11-03 00:00:00.000000', 'Artikel', 'handtasche.jpg', 'Handtasche \"Cosmopolita\"', 'Modische Filz-Handtasche mit praktischer Cocktailglas-Halterung. Irgendwie kommen wir nie aus dem Haus ohne solchen nützlichen Accessoire.', NULL),
(3, '2013-12-31 00:00:00.000000', 'Artikel', 'hase.jpg', 'Filz-Hase \"Moe\"', 'Ein putziger Hase aus Filz zur Dekoration. Er lässt sich gern am Rand seines Büros stellen, um Mut zu geben.', NULL),
(4, '1970-01-01 01:00:00.000000', 'Film', 'laurence.png', 'Laurence d\'Arabie', 'Wahnsinnige langes und spannendes Film. Ich verspreche es Ihnen. Aber wirklich.', 'laurence-trailer.mp4');

-- --------------------------------------------------------

--
-- Table structure for table `artikel_bewertung`
--

CREATE TABLE `artikel_bewertung` (
  `Artikel_nr` int(11) NOT NULL,
  `bewertungen_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `artikel_seq`
--

CREATE TABLE `artikel_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `artikel_seq`
--

INSERT INTO `artikel_seq` (`next_val`) VALUES
(101),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1);

-- --------------------------------------------------------

--
-- Table structure for table `bewertung`
--

CREATE TABLE `bewertung` (
  `id` int(11) NOT NULL,
  `wert` double NOT NULL,
  `text` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `bewertung_seq`
--

CREATE TABLE `bewertung_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `bewertung_seq`
--

INSERT INTO `bewertung_seq` (`next_val`) VALUES
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1);

-- --------------------------------------------------------

--
-- Table structure for table `country`
--

CREATE TABLE `country` (
  `emissions` double NOT NULL,
  `nr` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `country`
--

INSERT INTO `country` (`emissions`, `nr`, `name`) VALUES
(3230, 1, 'Germany'),
(7200.3, 2, 'USA'),
(9020.1, 3, 'China'),
(2476.7, 5, 'Austria'),
(432, 7, 'Belgium'),
(2423.4, 8, 'Sweden'),
(3424.1, 10, 'France'),
(143.7, 12, 'Iceland'),
(5320.6, 13, 'India'),
(423.6, 15, 'Czechia');

-- --------------------------------------------------------

--
-- Table structure for table `country_seq`
--

CREATE TABLE `country_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `country_seq`
--

INSERT INTO `country_seq` (`next_val`) VALUES
(1),
(1),
(1),
(1),
(1),
(1);

-- --------------------------------------------------------

--
-- Table structure for table `emissions`
--

CREATE TABLE `emissions` (
  `id` int(11) NOT NULL,
  `country` varchar(50) DEFAULT NULL,
  `co2_emission` decimal(10,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `emissions`
--

INSERT INTO `emissions` (`id`, `country`, `co2_emission`) VALUES
(1, 'Germany', 800.50),
(2, 'USA', 5000.75),
(3, 'China', 10000.90);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `artikel`
--
ALTER TABLE `artikel`
  ADD PRIMARY KEY (`nr`);

--
-- Indexes for table `artikel_bewertung`
--
ALTER TABLE `artikel_bewertung`
  ADD UNIQUE KEY `UK_nqxeyaigdvecvwcc3ygnnwds6` (`bewertungen_id`),
  ADD KEY `FKo7n1rsa94u4xei9r4dutuvncc` (`Artikel_nr`);

--
-- Indexes for table `bewertung`
--
ALTER TABLE `bewertung`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `country`
--
ALTER TABLE `country`
  ADD PRIMARY KEY (`nr`);

--
-- Indexes for table `emissions`
--
ALTER TABLE `emissions`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `emissions`
--
ALTER TABLE `emissions`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `artikel_bewertung`
--
ALTER TABLE `artikel_bewertung`
  ADD CONSTRAINT `FK71r3i50p997882tm2sfiyeufe` FOREIGN KEY (`bewertungen_id`) REFERENCES `bewertung` (`id`),
  ADD CONSTRAINT `FKo7n1rsa94u4xei9r4dutuvncc` FOREIGN KEY (`Artikel_nr`) REFERENCES `artikel` (`nr`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
