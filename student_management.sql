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

-- ----------------------------
-- Records of province
-- ----------------------------
INSERT INTO `province` VALUES ('Hà Giang');
INSERT INTO `province` VALUES ('Hà Nội');
INSERT INTO `province` VALUES ('Cao Bằng');
INSERT INTO `province` VALUES ('Bắc Kạn');
INSERT INTO `province` VALUES ('Tuyên Quang');
INSERT INTO `province` VALUES ('Lào Cai');
INSERT INTO `province` VALUES ('Điện Biên');
INSERT INTO `province` VALUES ('Lai Châu');
INSERT INTO `province` VALUES ('Sơn La');
INSERT INTO `province` VALUES ('Yên Bái');
INSERT INTO `province` VALUES ('Hoà Bình');
INSERT INTO `province` VALUES ('Thái Nguyên');
INSERT INTO `province` VALUES ('Lạng Sơn');
INSERT INTO `province` VALUES ('Quảng Ninh');
INSERT INTO `province` VALUES ('Bắc Giang');
INSERT INTO `province` VALUES ('Phú Thọ');
INSERT INTO `province` VALUES ('Vĩnh Phúc');
INSERT INTO `province` VALUES ('Bắc Ninh');
INSERT INTO `province` VALUES ('Hải Dương');
INSERT INTO `province` VALUES ('Hải Phòng');
INSERT INTO `province` VALUES ('Hưng Yên');
INSERT INTO `province` VALUES ('Thái Bình');
INSERT INTO `province` VALUES ('Hà Nam');
INSERT INTO `province` VALUES ('Nam Định');
INSERT INTO `province` VALUES ('Ninh Bình');
INSERT INTO `province` VALUES ('Thanh Hóa');
INSERT INTO `province` VALUES ('Nghệ An');
INSERT INTO `province` VALUES ('Hà Tĩnh');
INSERT INTO `province` VALUES ('Quảng Bình');
INSERT INTO `province` VALUES ('Quảng Trị');
INSERT INTO `province` VALUES ('Thừa Thiên Huế');
INSERT INTO `province` VALUES ('Đà Nẵng');
INSERT INTO `province` VALUES ('Quảng Nam');
INSERT INTO `province` VALUES ('Quảng Ngãi');
INSERT INTO `province` VALUES ('Bình Định');
INSERT INTO `province` VALUES ('Phú Yên');
INSERT INTO `province` VALUES ('Khánh Hòa');
INSERT INTO `province` VALUES ('Ninh Thuận');
INSERT INTO `province` VALUES ('Bình Thuận');
INSERT INTO `province` VALUES ('Kon Tum');
INSERT INTO `province` VALUES ('Gia Lai');
INSERT INTO `province` VALUES ('Đắk Lắk');
INSERT INTO `province` VALUES ('Đắk Nông');
INSERT INTO `province` VALUES ('Lâm Đồng');
INSERT INTO `province` VALUES ('Bình Phước');
INSERT INTO `province` VALUES ('Tây Ninh');
INSERT INTO `province` VALUES ('Bình Dương');
INSERT INTO `province` VALUES ('Đồng Nai');
INSERT INTO `province` VALUES ('Bà Rịa - Vũng Tàu');
INSERT INTO `province` VALUES ('Hồ Chí Minh');
INSERT INTO `province` VALUES ('Long An');
INSERT INTO `province` VALUES ('Tiền Giang');
INSERT INTO `province` VALUES ('Bến Tre');
INSERT INTO `province` VALUES ('Trà Vinh');
INSERT INTO `province` VALUES ('Vĩnh Long');
INSERT INTO `province` VALUES ('Đồng Tháp');
INSERT INTO `province` VALUES ('An Giang');
INSERT INTO `province` VALUES ('Kiên Giang');
INSERT INTO `province` VALUES ('Cần Thơ');
INSERT INTO `province` VALUES ('Hậu Giang');
INSERT INTO `province` VALUES ('Sóc Trăng');
INSERT INTO `province` VALUES ('Bạc Liêu');
INSERT INTO `province` VALUES ('Cà Mau');


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
  MODIFY `province_id` int(11) NOT NULL AUTO_INCREMENT;

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
