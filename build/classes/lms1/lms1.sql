-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 13, 2024 at 08:39 AM
-- Server version: 10.4.27-MariaDB
-- PHP Version: 7.4.33

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `lms1`
--

-- --------------------------------------------------------

--
-- Table structure for table `attendance`
--

CREATE TABLE `attendance` (
  `id` int(11) NOT NULL,
  `attendance_id` varchar(100) NOT NULL,
  `totalshift` varchar(100) NOT NULL,
  `extrashift` varchar(100) NOT NULL,
  `timein` varchar(100) NOT NULL,
  `timeout` varchar(100) NOT NULL,
  `building` varchar(100) NOT NULL,
  `date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `attendance`
--

INSERT INTO `attendance` (`id`, `attendance_id`, `totalshift`, `extrashift`, `timein`, `timeout`, `building`, `date`) VALUES
(1, '001', '15 hours', '5 hours', '7:00', '4:00', 'first building', '2024-01-28'),
(2, '002', '12 hours', '3 hours', '7', '9', 'first building', '2024-01-28'),
(3, '003', '10 hours', '2 hours', '7:00', '2:00', 'first building', '2024-02-01'),
(4, '005', '5 hours', '4 hours', '8:00', '5:00', 'second building', '2024-01-28'),
(5, '003', '15 hours', '2 hours', '8:00', '9:45', 'Third Building', '2024-02-02'),
(6, '004', '5 hours', '3 hours', '2:00', '4:00', 'last building', '2024-01-28'),
(7, '003', '3 hours', '3 hours', '4:00', '10:00', 'Last Building', '2024-02-15'),
(8, '001', '6 hour', '1 hour', '5:00', '3:00', 'First Building', '2024-02-13'),
(9, '002', '9 hours', '3 hours', '7:00', '2:00', 'Second Building', '2024-02-13');

-- --------------------------------------------------------

--
-- Table structure for table `details`
--

CREATE TABLE `details` (
  `id` int(11) NOT NULL,
  `worker_id` varchar(100) NOT NULL,
  `name` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `contact` varchar(100) NOT NULL,
  `referrer` varchar(100) NOT NULL,
  `experience` varchar(100) NOT NULL,
  `identification` varchar(100) NOT NULL,
  `weight` double NOT NULL,
  `status` varchar(100) NOT NULL,
  `height` double NOT NULL,
  `address` varchar(100) NOT NULL,
  `nok_name` varchar(100) NOT NULL,
  `nok_email` varchar(100) NOT NULL,
  `nok_contact` varchar(100) NOT NULL,
  `date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `details`
--

INSERT INTO `details` (`id`, `worker_id`, `name`, `email`, `contact`, `referrer`, `experience`, `identification`, `weight`, `status`, `height`, `address`, `nok_name`, `nok_email`, `nok_contact`, `date`) VALUES
(1, '001', 'Admin', 'admin@gmail.com', '0000000000', 'Admin123', 'Expert', 'Permanent', 50, 'Upper', 150.5, 'Oluyole, Ibadan', 'Admin123', 'admin123@gmail.com', '111111111', '2024-02-02'),
(2, '002', 'KD', 'kd@gmail.com', '019827345234', 'Kd123', 'Novice', 'Temporary', 56.01987, 'Lower', 150.0987, 'Ibadan', 'Kd123', 'kd123@gmail.com', '12345673456', '2024-01-23'),
(3, '003', 'Captain', 'captain@gmail.com', '123456789', 'Captain123', 'Advanced Beginner', 'Temporary', 234.234, 'Middle', 123.23, 'Oyo State', 'Captain123', 'captain123@gmail.com', '1234567890', '2024-01-23'),
(4, '004', 'sdfghjk', 'dtfghujkk', '34567', 'tyguhijo', 'Advanced Beginner', 'Permanent', 56.98, 'Working', 67.98, 'dtfghjkl', 'fghjkl', 'hgjk', '567867890', '2024-01-25'),
(5, '005', 'Semiah', 'semiah@gmail.com', '090546452832', 'Ismail', 'Expert', 'Permanent', 45.09, 'Upper', 120, 'Ilorin, Kwara State', 'Ismail Fawaz', 'fawaz@gmail.com', '0987656789', '2024-01-26'),
(6, '006', 'Jerry', 'jerry@gmail.com', '123456', 'Jerry123', 'Competent', 'Temporary', 123, 'Lower', 123.66, 'Aerodrome', 'Jerry123', 'jerry123@gmail.com', '123456', '2024-01-27');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `username` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `question` varchar(100) NOT NULL,
  `answer` varchar(100) NOT NULL,
  `date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `username`, `password`, `question`, `answer`, `date`) VALUES
(1, 'kd', 'kolade12345', 'What is your favourite Color?', 'yellow', '2024-01-20'),
(2, 'admin', 'admin12345', 'What is your favourite food?', 'Rice', '2024-01-21');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `attendance`
--
ALTER TABLE `attendance`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `details`
--
ALTER TABLE `details`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `attendance`
--
ALTER TABLE `attendance`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `details`
--
ALTER TABLE `details`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
