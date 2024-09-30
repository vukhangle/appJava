-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th4 25, 2024 lúc 11:17 PM
-- Phiên bản máy phục vụ: 10.4.28-MariaDB
-- Phiên bản PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `qlns`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `bophan`
--

CREATE TABLE `bophan` (
  `DepartmentID` int(20) NOT NULL,
  `name` varchar(100) NOT NULL,
  `NgayLap` varchar(15) NOT NULL,
  `ManagerName` varchar(255) NOT NULL,
  `SoluongNV` int(11) NOT NULL,
  `Address` varchar(255) NOT NULL,
  `Phone` int(11) NOT NULL,
  `Email` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `bophan`
--

INSERT INTO `bophan` (`DepartmentID`, `name`, `NgayLap`, `ManagerName`, `SoluongNV`, `Address`, `Phone`, `Email`) VALUES
(24011, 'Bộ Phận Công Xưởng', 'Apr 25, 2024', 'Nguyễn Văn Sơn', 200, 'Cần Thơ', 787845976, 'congxuong@gmail.com'),
(24022, 'Bộ Phận Kế Toán', 'Apr 26, 2024', 'Nguyễn Thị Bích Lệ', 10, 'Cần Thơ', 123456789, 'ketoan01@gmail.com'),
(24033, 'Bộ Phận Kỹ Thuật', 'Apr 26, 2024', 'C', 50, 'Cần Thơ', 123456789, 'kythuat@gmail.com'),
(24044, 'Bộ Phận Quản Lý', 'Apr 26, 2024', 'D', 10, 'Cần Thơ', 78978978, 'quanly@gmail.com');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chucvu`
--

CREATE TABLE `chucvu` (
  `PositionID` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `salary` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `chucvu`
--

INSERT INTO `chucvu` (`PositionID`, `name`, `salary`) VALUES
(24001, 'Giàm Đốc', '2.0E7'),
(24002, 'Kế Toán', '8000000.0'),
(24003, 'Quản Lý', '1000000.0'),
(24004, 'Kỹ Thuật', '7000000.0'),
(24005, 'Nhân Viên', '5000000.0');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `login`
--

CREATE TABLE `login` (
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `login`
--

INSERT INTO `login` (`username`, `password`) VALUES
('admin', '12345');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nhanvien`
--

CREATE TABLE `nhanvien` (
  `name` varchar(255) NOT NULL,
  `empID` int(11) NOT NULL,
  `dob` varchar(255) NOT NULL,
  `salary` varchar(255) NOT NULL,
  `address` varchar(255) NOT NULL,
  `phone` varchar(10) NOT NULL,
  `email` varchar(255) NOT NULL,
  `education` varchar(255) NOT NULL,
  `departmentID` int(11) NOT NULL,
  `gender` varchar(10) NOT NULL,
  `positionID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `nhanvien`
--

INSERT INTO `nhanvien` (`name`, `empID`, `dob`, `salary`, `address`, `phone`, `email`, `education`, `departmentID`, `gender`, `positionID`) VALUES
('Minh', 314069, 'Apr 23, 2024', '20000000', 'Cần Thơ', '0123456789', 'minhct@gmail.com', 'Đại Học', 24011, 'Nam', 24001),
('dddd', 96366, 'Apr 1, 2024', '133213123', 'asdsad', '13213211', 'asdad@gmail.com', 'Trung Cấp', 24011, 'Nam', 24001),
('Trương Thị Mỹ Lan', 363227, 'Apr 20, 2000', '8000000', 'Cần Thơ', '1234561234', 'lankt@gmail.com', 'Đại Học', 24022, 'Nữ', 24002),
('Nguyễn Văn Sơn', 726775, 'Apr 9, 2001', '1000000', 'Trà Vinh', '0123123123', 'sonql@gmail.com', 'Đại Học', 24044, 'Nam', 24003),
('Nguyễn Thị Bích Lệ', 712648, 'Jun 26, 2000', '10000000', 'Sóc Trăng', '0123123124', 'leql@gmail.com', 'Cao Đẳng', 24044, 'Nữ', 24003);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `bophan`
--
ALTER TABLE `bophan`
  ADD PRIMARY KEY (`DepartmentID`);

--
-- Chỉ mục cho bảng `chucvu`
--
ALTER TABLE `chucvu`
  ADD PRIMARY KEY (`PositionID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
