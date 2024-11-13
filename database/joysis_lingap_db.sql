-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 13, 2024 at 04:09 PM
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
-- Database: `joysis_lingap_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `doctor_info_tbl`
--

CREATE TABLE `doctor_info_tbl` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `field` varchar(50) NOT NULL,
  `schedule_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `doctor_info_tbl`
--

INSERT INTO `doctor_info_tbl` (`id`, `name`, `field`, `schedule_id`) VALUES
(1, 'Dr. Justin Zander', 'Cardiologist', 1),
(2, 'Dr. Althea Bayudan', 'Dermatology', 2),
(3, 'Dr. John Leonard', 'Orthopedic', 3);

-- --------------------------------------------------------

--
-- Table structure for table `doctor_schedules_tbl`
--

CREATE TABLE `doctor_schedules_tbl` (
  `id` int(11) NOT NULL,
  `day` varchar(25) NOT NULL,
  `time` varchar(25) NOT NULL,
  `slots_remaining` int(11) NOT NULL DEFAULT 3
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `doctor_schedules_tbl`
--

INSERT INTO `doctor_schedules_tbl` (`id`, `day`, `time`, `slots_remaining`) VALUES
(1, 'Monday', '7:00-12:00', 3),
(2, 'Tuesday', '7:00-12:00', 3),
(3, 'Wednesday', '7:00-12:00', 3);

-- --------------------------------------------------------

--
-- Table structure for table `user_credentials_tbl`
--

CREATE TABLE `user_credentials_tbl` (
  `id` int(11) NOT NULL,
  `username` varchar(25) NOT NULL,
  `password` varchar(255) NOT NULL,
  `user_id` int(11) NOT NULL,
  `role` int(11) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `user_credentials_tbl`
--

INSERT INTO `user_credentials_tbl` (`id`, `username`, `password`, `user_id`, `role`) VALUES
(1, 'mark123', '$s0$e0801$ZUSZi5v8DYX3xUCC2q49VA==$bIBWKi2Ic5ZZH0jNKGDB/V4DO1VUiGzbjTvMptleJyE=', 1, 0),
(2, 'haylie', '$s0$e0801$tAHF/HPLSPQvhKb/nJ0iog==$gPEjNfZ+7jv6ToM8B6u+cWY1dU6A/g7F3fHFhHX5FgQ=', 2, 1),
(3, 'leo2024', '$s0$e0801$1qA7xOFLq5WyAYrjwOjZ1A==$UVuIx2kNCeIolOydkUP44xwOQ7GBo7yHgn3H0Y45CVY=', 8, 0);

-- --------------------------------------------------------

--
-- Table structure for table `user_info_tbl`
--

CREATE TABLE `user_info_tbl` (
  `id` int(11) NOT NULL,
  `first_name` varchar(25) NOT NULL,
  `last_name` varchar(25) NOT NULL,
  `age` int(11) NOT NULL,
  `address` varchar(50) NOT NULL,
  `phone` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `user_info_tbl`
--

INSERT INTO `user_info_tbl` (`id`, `first_name`, `last_name`, `age`, `address`, `phone`) VALUES
(1, 'Mark Gerald', 'Guerrero', 19, '251 M. Lapu Lapu', '09678764455'),
(2, 'Haylie', 'Dela cruz', 24, '33 Munding', '09877659266'),
(3, 'Mark', 'Guerrero', 19, '251 Pureza', '09785556789'),
(8, 'John Leonard', 'Dela Rosa', 19, '251 M. Espiritu', '0987676863');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `doctor_info_tbl`
--
ALTER TABLE `doctor_info_tbl`
  ADD PRIMARY KEY (`id`),
  ADD KEY `doctor_info_tbl_doctor_schedules_tbl` (`schedule_id`);

--
-- Indexes for table `doctor_schedules_tbl`
--
ALTER TABLE `doctor_schedules_tbl`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user_credentials_tbl`
--
ALTER TABLE `user_credentials_tbl`
  ADD PRIMARY KEY (`id`),
  ADD KEY `user_credential_tbl_user_info_tbl_fk` (`user_id`);

--
-- Indexes for table `user_info_tbl`
--
ALTER TABLE `user_info_tbl`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `doctor_info_tbl`
--
ALTER TABLE `doctor_info_tbl`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `doctor_schedules_tbl`
--
ALTER TABLE `doctor_schedules_tbl`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `user_credentials_tbl`
--
ALTER TABLE `user_credentials_tbl`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `user_info_tbl`
--
ALTER TABLE `user_info_tbl`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `doctor_info_tbl`
--
ALTER TABLE `doctor_info_tbl`
  ADD CONSTRAINT `doctor_info_tbl_doctor_schedules_tbl` FOREIGN KEY (`schedule_id`) REFERENCES `doctor_schedules_tbl` (`id`) ON UPDATE CASCADE;

--
-- Constraints for table `user_credentials_tbl`
--
ALTER TABLE `user_credentials_tbl`
  ADD CONSTRAINT `user_credential_tbl_user_info_tbl_fk` FOREIGN KEY (`user_id`) REFERENCES `user_info_tbl` (`id`) ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
