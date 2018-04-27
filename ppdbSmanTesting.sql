-- phpMyAdmin SQL Dump
-- version 4.5.4.1deb2ubuntu2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Apr 27, 2018 at 11:33 AM
-- Server version: 5.7.21-0ubuntu0.16.04.1
-- PHP Version: 7.0.28-0ubuntu0.16.04.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ppdbSmanTesting`
--

-- --------------------------------------------------------

--
-- Table structure for table `sekolah`
--

CREATE TABLE `sekolah` (
  `kodeSekolah` int(11) NOT NULL,
  `namaSekolah` varchar(40) NOT NULL,
  `kuota` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sekolah`
--

INSERT INTO `sekolah` (`kodeSekolah`, `namaSekolah`, `kuota`) VALUES
(0, 'SMA Negeri 1 Depok', 1),
(1, 'SMA Negeri 2 Depok', 10),
(2, 'SMA Negeri 3 Depok', 2),
(3, 'SMA Negeri 4 Depok', 2),
(4, 'SMA Negeri 5 Depok', 5),
(5, 'SMA Negeri 6 Depok', 2),
(6, 'SMA Negeri 7 Depok', 2),
(7, 'SMA Negeri 8 Depok', 2),
(8, 'SMA Negeri 9 Depok', 2),
(9, 'SMA Negeri 10 Depok', 2),
(10, 'SMA Negeri 11 Depok', 2),
(11, 'SMA Negeri 12 Depok', 2),
(12, 'SMA Negeri 13 Depok', 2),
(13, 'SMA Negeri 14 Depok', 2);

-- --------------------------------------------------------

--
-- Table structure for table `sekolahTerima`
--

CREATE TABLE `sekolahTerima` (
  `kodeSekolah` int(11) NOT NULL,
  `nisn` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `siswa`
--

CREATE TABLE `siswa` (
  `nisn` int(10) NOT NULL,
  `nama` varchar(30) NOT NULL,
  `nilai` double NOT NULL,
  `kodeSekolahTerima` int(11) NOT NULL,
  `password` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `siswa`
--

INSERT INTO `siswa` (`nisn`, `nama`, `nilai`, `kodeSekolahTerima`, `password`) VALUES
(0, 'Anjay', 100, 0, ''),
(1, 'Bravo', 70, 0, ''),
(2, 'Charlie', 80, 0, ''),
(3, 'Delta', 30, 0, ''),
(4, 'Echo', 95, 0, ''),
(5, 'Fanta', 90, 0, '');

-- --------------------------------------------------------

--
-- Table structure for table `siswaSekolah`
--

CREATE TABLE `siswaSekolah` (
  `nisn` int(10) NOT NULL,
  `kodeSekolah` int(11) NOT NULL,
  `prioritas` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `siswaSekolah`
--

INSERT INTO `siswaSekolah` (`nisn`, `kodeSekolah`, `prioritas`) VALUES
(0, 4, 1),
(0, 5, 2),
(1, 0, 3),
(1, 4, 2),
(1, 5, 1),
(2, 4, 2),
(2, 5, 1),
(3, 0, 3),
(3, 4, 1),
(3, 5, 2),
(4, 0, 1),
(4, 5, 2),
(5, 4, 2),
(5, 5, 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `sekolah`
--
ALTER TABLE `sekolah`
  ADD PRIMARY KEY (`kodeSekolah`);

--
-- Indexes for table `sekolahTerima`
--
ALTER TABLE `sekolahTerima`
  ADD PRIMARY KEY (`kodeSekolah`,`nisn`),
  ADD KEY `c4` (`nisn`);

--
-- Indexes for table `siswa`
--
ALTER TABLE `siswa`
  ADD PRIMARY KEY (`nisn`);

--
-- Indexes for table `siswaSekolah`
--
ALTER TABLE `siswaSekolah`
  ADD PRIMARY KEY (`nisn`,`kodeSekolah`),
  ADD KEY `c2` (`kodeSekolah`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `sekolahTerima`
--
ALTER TABLE `sekolahTerima`
  ADD CONSTRAINT `c3` FOREIGN KEY (`kodeSekolah`) REFERENCES `sekolah` (`kodeSekolah`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `c4` FOREIGN KEY (`nisn`) REFERENCES `siswa` (`nisn`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `siswaSekolah`
--
ALTER TABLE `siswaSekolah`
  ADD CONSTRAINT `c1` FOREIGN KEY (`nisn`) REFERENCES `siswa` (`nisn`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `c2` FOREIGN KEY (`kodeSekolah`) REFERENCES `sekolah` (`kodeSekolah`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
