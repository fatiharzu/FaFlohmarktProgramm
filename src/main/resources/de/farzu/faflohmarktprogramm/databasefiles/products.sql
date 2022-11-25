-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 25, 2022 at 11:54 AM
-- Server version: 10.4.25-MariaDB
-- PHP Version: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `products`
--

-- --------------------------------------------------------

--
-- Table structure for table `products`
--

CREATE TABLE `products` (
  `pk_id` int(11) NOT NULL,
  `species` text NOT NULL,
  `alterGroup` int(11) NOT NULL,
  `name` text NOT NULL,
  `description` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `products`
--

INSERT INTO `products` (`pk_id`, `species`, `alterGroup`, `name`, `description`) VALUES
(34, 'Kinderbuch ', 8, 'Heidi', 'Gute Zustand'),
(36, 'Kinderbuch ', 8, 'Spiderman', '35 pages'),
(42, 'Spielzeug  ', 4, 'Puppenhause', 'Es gibt keine Tür'),
(43, 'Kleidung   ', 3, 'Hose', 'Ein neuer Knopf sollte angenäht werden'),
(44, 'Spielzeug  ', 3, 'Puppe', 'Gute Zustand'),
(45, 'Kindermöbel', 4, 'Kinderbett', 'hat leichte kratzer'),
(46, 'Kindermöbel', 10, 'Schreibtisch', 'Gute Zustand'),
(47, 'Kleidung   ', 5, 'Hose', 'Gute Zustand'),
(48, 'Kleidung   ', 4, 'Rock', 'Gute Zustand'),
(49, 'Baby Produkts', 1, 'Hohe Stühle', 'Gute Zustand'),
(50, 'Baby Produkts', 1, 'Schnuller', 'unbenutztes Produkt'),
(51, 'Baby Produkts', 1, 'Babyflaschen', 'Gute Zustand');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`pk_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `products`
--
ALTER TABLE `products`
  MODIFY `pk_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=52;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
