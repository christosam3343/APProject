-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 27, 2024 at 03:56 AM
-- Server version: 10.4.17-MariaDB
-- PHP Version: 8.0.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `jhtdatabase`
--

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `CustId` int(11) NOT NULL,
  `company` varchar(30) NOT NULL,
  `contactPerson` varchar(60) NOT NULL,
  `custAddress1` varchar(60) NOT NULL,
  `custAddress2` varchar(60) NOT NULL,
  `custPostOffice` varchar(50) NOT NULL,
  `custParish` varchar(50) NOT NULL,
  `custTelephone` varchar(20) NOT NULL,
  `custEmail` varchar(40) NOT NULL,
  `custBalance` double NOT NULL,
  `custStatus` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`CustId`, `company`, `contactPerson`, `custAddress1`, `custAddress2`, `custPostOffice`, `custParish`, `custTelephone`, `custEmail`, `custBalance`, `custStatus`) VALUES
(456, 'q', 'q', 'q', 'q', 'q', 'q', 'q', 'q', 21, 0),
(12334, 'q', 'q', 'q', 'q', 'q', 'q', 'q', 'q', 21, 0),
(12345, 'Joel', 'Mason', '123', 'Boolean Ave', 'Spa Town', 'St Catherine', '8764995678', 'joel@gmail.com', 3500, 0);

-- --------------------------------------------------------

--
-- Table structure for table `logins`
--

CREATE TABLE `logins` (
  `userName` varchar(20) NOT NULL,
  `password` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `logins`
--

INSERT INTO `logins` (`userName`, `password`) VALUES
('admin', 'admin'),
('contractor', 'contractor'),
('superadmin', 'superadmin');

-- --------------------------------------------------------

--
-- Table structure for table `orders`
--

CREATE TABLE `orders` (
  `invoiceNo` varchar(20) NOT NULL,
  `company` varchar(20) NOT NULL,
  `sourceAddress` varchar(20) NOT NULL,
  `destinationAddress` varchar(20) NOT NULL,
  `rate` double NOT NULL,
  `driver` varchar(60) NOT NULL,
  `billedBy` varchar(60) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `routerates`
--

CREATE TABLE `routerates` (
  `routeName` varchar(11) NOT NULL,
  `source` varchar(30) NOT NULL,
  `destination` varchar(30) NOT NULL,
  `rate` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `routerates`
--

INSERT INTO `routerates` (`routeName`, `source`, `destination`, `rate`) VALUES
('K-M', 'Kingston', 'Montego Bay', 18000),
('K-N', 'Kingston', 'Negril', 22000),
('K-O', 'Kingston', 'Ocho Rios', 14000),
('K-P', 'Kingston', 'Portmore', 7000),
('K-S', 'Kingston', 'Spanish Town', 9000),
('M-K', 'Montego Bay', 'Kingston', 18000),
('M-N', 'Montego Bay', 'Negril', 11000),
('M-O', 'Montego Bay', 'Ocho Rios', 6000),
('M-P', 'Montego Bay', 'Portmore', 15000),
('M-S', 'Montego Bay', 'Spanish Town', 14000);

-- --------------------------------------------------------

--
-- Table structure for table `staff`
--

CREATE TABLE `staff` (
  `staffID` int(11) NOT NULL,
  `staffFirstName` varchar(20) NOT NULL,
  `staffLastName` varchar(20) NOT NULL,
  `staffDob` varchar(50) NOT NULL,
  `staffAddress1` varchar(70) NOT NULL,
  `staffAddress2` varchar(70) NOT NULL,
  `staffPostOffice` varchar(70) NOT NULL,
  `staffParish` varchar(15) NOT NULL,
  `staffTelephone` varchar(15) NOT NULL,
  `staffEmail` varchar(50) NOT NULL,
  `staffPosition` varchar(30) NOT NULL,
  `staffStatus` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `staff`
--

INSERT INTO `staff` (`staffID`, `staffFirstName`, `staffLastName`, `staffDob`, `staffAddress1`, `staffAddress2`, `staffPostOffice`, `staffParish`, `staffTelephone`, `staffEmail`, `staffPosition`, `staffStatus`) VALUES
(18, 'Hugh', 'Scott', '2024-03-08', 'Address', 'Address2', 'post office', 'Manchester', '839243998', 'email@email.com', 'Left', 1),
(2008423, 'Christo', 'George', 'Thu Sep 27 00:00:00 EST 2001', '71 Wiggan Loop', 'Kingston 6', 'Kingston 6', 'Kingston', '8763039148', 'christosamkulangara@gmail.com', 'Senior Manager', 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`CustId`);

--
-- Indexes for table `logins`
--
ALTER TABLE `logins`
  ADD PRIMARY KEY (`userName`);

--
-- Indexes for table `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`invoiceNo`);

--
-- Indexes for table `routerates`
--
ALTER TABLE `routerates`
  ADD PRIMARY KEY (`routeName`);

--
-- Indexes for table `staff`
--
ALTER TABLE `staff`
  ADD PRIMARY KEY (`staffID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
