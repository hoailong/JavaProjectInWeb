-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 30, 2019 at 05:18 AM
-- Server version: 10.1.38-MariaDB
-- PHP Version: 7.1.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
CREATE DATABASE `student_management`;
ALTER DATABASE `student_management` CHARACTER SET utf8 COLLATE utf8_vietnamese_ci;
USE `student_management`;
--
-- Database: `student_management`
--

-- --------------------------------------------------------

--
-- Table structure for table `province`
--

CREATE TABLE `province` (
  `province_id` int(11) NOT NULL,
  `name` varchar(50) COLLATE utf8_vietnamese_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `student_id` int(11) NOT NULL,
  `name` varchar(50) COLLATE utf8_vietnamese_ci DEFAULT NULL,
  `dob` varchar(10) COLLATE utf8_vietnamese_ci DEFAULT NULL,
  `gender` tinyint(1) DEFAULT NULL,
  `math` float DEFAULT NULL,
  `physical` float DEFAULT NULL,
  `chemistry` float DEFAULT NULL,
  `province_id` int(11) DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `province`
--
ALTER TABLE `province`
  ADD PRIMARY KEY (`province_id`);

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`student_id`),
  ADD KEY `province_id` (`province_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `student`
--
ALTER TABLE `student`
  MODIFY `student_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10000;

--
-- AUTO_INCREMENT for table `province`
--
ALTER TABLE `province`
  MODIFY `province_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1;

-- ----------------------------
-- Records of province
-- ----------------------------
INSERT INTO `province`(name) VALUES ('Hà Giang');
INSERT INTO `province`(name) VALUES ('Hà Nội');
INSERT INTO `province`(name) VALUES ('Cao Bằng');
INSERT INTO `province`(name) VALUES ('Bắc Kạn');
INSERT INTO `province`(name) VALUES ('Tuyên Quang');
INSERT INTO `province`(name) VALUES ('Lào Cai');
INSERT INTO `province`(name) VALUES ('Điện Biên');
INSERT INTO `province`(name) VALUES ('Lai Châu');
INSERT INTO `province`(name) VALUES ('Sơn La');
INSERT INTO `province`(name) VALUES ('Yên Bái');
INSERT INTO `province`(name) VALUES ('Hoà Bình');
INSERT INTO `province`(name) VALUES ('Thái Nguyên');
INSERT INTO `province`(name) VALUES ('Lạng Sơn');
INSERT INTO `province`(name) VALUES ('Quảng Ninh');
INSERT INTO `province`(name) VALUES ('Bắc Giang');
INSERT INTO `province`(name) VALUES ('Phú Thọ');
INSERT INTO `province`(name) VALUES ('Vĩnh Phúc');
INSERT INTO `province`(name) VALUES ('Bắc Ninh');
INSERT INTO `province`(name) VALUES ('Hải Dương');
INSERT INTO `province`(name) VALUES ('Hải Phòng');
INSERT INTO `province`(name) VALUES ('Hưng Yên');
INSERT INTO `province`(name) VALUES ('Thái Bình');
INSERT INTO `province`(name) VALUES ('Hà Nam');
INSERT INTO `province`(name) VALUES ('Nam Định');
INSERT INTO `province`(name) VALUES ('Ninh Bình');
INSERT INTO `province`(name) VALUES ('Thanh Hóa');
INSERT INTO `province`(name) VALUES ('Nghệ An');
INSERT INTO `province`(name) VALUES ('Hà Tĩnh');
INSERT INTO `province`(name) VALUES ('Quảng Bình');
INSERT INTO `province`(name) VALUES ('Quảng Trị');
INSERT INTO `province`(name) VALUES ('Thừa Thiên Huế');
INSERT INTO `province`(name) VALUES ('Đà Nẵng');
INSERT INTO `province`(name) VALUES ('Quảng Nam');
INSERT INTO `province`(name) VALUES ('Quảng Ngãi');
INSERT INTO `province`(name) VALUES ('Bình Định');
INSERT INTO `province`(name) VALUES ('Phú Yên');
INSERT INTO `province`(name) VALUES ('Khánh Hòa');
INSERT INTO `province`(name) VALUES ('Ninh Thuận');
INSERT INTO `province`(name) VALUES ('Bình Thuận');
INSERT INTO `province`(name) VALUES ('Kon Tum');
INSERT INTO `province`(name) VALUES ('Gia Lai');
INSERT INTO `province`(name) VALUES ('Đắk Lắk');
INSERT INTO `province`(name) VALUES ('Đắk Nông');
INSERT INTO `province`(name) VALUES ('Lâm Đồng');
INSERT INTO `province`(name) VALUES ('Bình Phước');
INSERT INTO `province`(name) VALUES ('Tây Ninh');
INSERT INTO `province`(name) VALUES ('Bình Dương');
INSERT INTO `province`(name) VALUES ('Đồng Nai');
INSERT INTO `province`(name) VALUES ('Bà Rịa - Vũng Tàu');
INSERT INTO `province`(name) VALUES ('Hồ Chí Minh');
INSERT INTO `province`(name) VALUES ('Long An');
INSERT INTO `province`(name) VALUES ('Tiền Giang');
INSERT INTO `province`(name) VALUES ('Bến Tre');
INSERT INTO `province`(name) VALUES ('Trà Vinh');
INSERT INTO `province`(name) VALUES ('Vĩnh Long');
INSERT INTO `province`(name) VALUES ('Đồng Tháp');
INSERT INTO `province`(name) VALUES ('An Giang');
INSERT INTO `province`(name) VALUES ('Kiên Giang');
INSERT INTO `province`(name) VALUES ('Cần Thơ');
INSERT INTO `province`(name) VALUES ('Hậu Giang');
INSERT INTO `province`(name) VALUES ('Sóc Trăng');
INSERT INTO `province`(name) VALUES ('Bạc Liêu');
INSERT INTO `province`(name) VALUES ('Cà Mau');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `student`
--
ALTER TABLE `student`
  ADD CONSTRAINT `student_ibfk_1` FOREIGN KEY (`province_id`) REFERENCES `province` (`province_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
