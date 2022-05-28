-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th5 28, 2022 lúc 06:53 PM
-- Phiên bản máy phục vụ: 10.4.20-MariaDB
-- Phiên bản PHP: 8.0.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `restaurant`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `categories`
--

CREATE TABLE `categories` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `createdAt` datetime NOT NULL,
  `updatedAt` datetime NOT NULL,
  `status` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `categories`
--

INSERT INTO `categories` (`id`, `name`, `createdAt`, `updatedAt`, `status`) VALUES
(1, 'Món nướng', '2022-05-28 18:15:53', '2022-05-28 18:15:53', 1),
(2, 'Món luộc', '2022-05-28 18:15:53', '2022-05-28 18:15:53', 1),
(3, 'Món chay', '2022-05-28 18:15:53', '2022-05-28 18:15:53', 1),
(4, 'Đồ uống', '2022-05-28 18:15:53', '2022-05-28 18:15:53', 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `food`
--

CREATE TABLE `food` (
  `id` int(11) NOT NULL,
  `categoryId` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `description` text NOT NULL,
  `thumbnail` text NOT NULL,
  `price` double NOT NULL,
  `createdAt` datetime NOT NULL,
  `updatedAt` datetime NOT NULL,
  `status` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `food`
--

INSERT INTO `food` (`id`, `categoryId`, `name`, `description`, `thumbnail`, `price`, `createdAt`, `updatedAt`, `status`) VALUES
(1, 1, 'Dồi sụn nướng', 'Lorem ipsum', 'Lorem ipsum', 100, '2022-05-28 18:32:42', '2022-05-28 18:32:42', -1),
(5, 1, 'Thịt xiên nướng', 'Làm từ thịt lợn sạch', 'https://res.cloudinary.com/dpwixbzs0/image/upload/v1653741845/kqozkwavltqyk3r2w7cl.jpg', 200, '2022-05-28 19:45:36', '2022-05-28 19:45:36', 1),
(6, 2, 'Thịt gà luộc', 'Gà chạy đồi', 'https://res.cloudinary.com/dpwixbzs0/image/upload/v1653743634/h7iz2rhdmnrok27uhjxa.jpg', 50, '2022-05-28 20:14:10', '2022-05-28 20:14:10', 1),
(7, 3, 'Nộm hoa chuối', 'Làm từ hoa chuối', 'https://res.cloudinary.com/dpwixbzs0/image/upload/v1653743766/aacy4p0qnlidxfnl2tpa.jpg', 20, '2022-05-28 20:16:25', '2022-05-28 20:16:25', 1),
(8, 2, 'Ngan Luộc', 'Làm từ thịt ngan', 'https://res.cloudinary.com/dpwixbzs0/image/upload/v1653745317/adqgviplm1yto64p3ksf.jpg', 20, '2022-05-28 20:42:04', '2022-05-28 20:42:04', 1);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `categories`
--
ALTER TABLE `categories`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `food`
--
ALTER TABLE `food`
  ADD PRIMARY KEY (`id`),
  ADD KEY `categoryId` (`categoryId`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `categories`
--
ALTER TABLE `categories`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT cho bảng `food`
--
ALTER TABLE `food`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `food`
--
ALTER TABLE `food`
  ADD CONSTRAINT `food_ibfk_1` FOREIGN KEY (`categoryId`) REFERENCES `categories` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
