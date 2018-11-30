-- phpMyAdmin SQL Dump
-- version 4.7.9
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 30, 2018 at 06:32 AM
-- Server version: 10.1.31-MariaDB
-- PHP Version: 5.6.34

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `project`
--

-- --------------------------------------------------------

--
-- Table structure for table `advisors`
--

CREATE TABLE `advisors` (
  `ID` int(15) NOT NULL,
  `Name` varchar(30) NOT NULL,
  `Gender` varchar(30) NOT NULL,
  `Email` varchar(50) NOT NULL,
  `Phone` varchar(50) NOT NULL,
  `Designation` varchar(80) NOT NULL,
  `Department` varchar(30) NOT NULL,
  `isApprove` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `advisors`
--

INSERT INTO `advisors` (`ID`, `Name`, `Gender`, `Email`, `Phone`, `Designation`, `Department`, `isApprove`) VALUES
(1, 'Faisal Jameel', 'Male', 'faisal@gmail.com', '789654', 'Junior Lecturar', 'CS', 'Yes'),
(2, 'Faheem', 'Male', 'faheem@gmail.com', '78965', 'Junior', 'SE', 'Yes'),
(3, 'Anser', 'Male', 'muhammadtalha3810@gmail.com', '3352700381', 'Lecturar', 'CS', 'No');

-- --------------------------------------------------------

--
-- Table structure for table `announcement`
--

CREATE TABLE `announcement` (
  `ID` int(10) NOT NULL,
  `Type` varchar(30) NOT NULL,
  `A_From` int(10) NOT NULL,
  `A_To` varchar(30) NOT NULL,
  `Title` varchar(90) NOT NULL,
  `Description` varchar(120) NOT NULL,
  `Date` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `announcement`
--

INSERT INTO `announcement` (`ID`, `Type`, `A_From`, `A_To`, `Title`, `Description`, `Date`) VALUES
(4, 'Advisors', 1, 'All Departments', 'Exam Preparation', 'Check preparation of students by asking from teachers and some students ', '2018-08-06'),
(5, 'Advisors', 2, 'CS', 'Feedback', 'Take feedback from students', '2018-08-08'),
(6, 'Advisors', 2, 'SE', 'VIS', 'Guide students about VIS', '2018-07-07'),
(8, 'Student', 4, 'Student', 'Feedback Required for Final Exam', 'AoA\r\nStudent!\r\nTell me feedback about SE course before final exam\r\nThanks', '2018-08-07'),
(55, 'Student', 8, 'Student', 'Feedback Required', 'Dear Students!\r\nFeedback is required before mid term exams...So visit to my office kindly.\r\nThanks', '11-11-2018'),
(150, 'Student', 4, 'Student', 'Friday off', 'Students\r\nFriday is off due to security reason', '2018-10-30');

-- --------------------------------------------------------

--
-- Table structure for table `assigned_students`
--

CREATE TABLE `assigned_students` (
  `ID` int(30) NOT NULL,
  `Advisor_ID` int(80) NOT NULL,
  `No_of_students` int(50) NOT NULL,
  `First_student` varchar(80) NOT NULL,
  `Last_student` varchar(80) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `assigned_students`
--

INSERT INTO `assigned_students` (`ID`, `Advisor_ID`, `No_of_students`, `First_student`, `Last_student`) VALUES
(9, 2, 4, 'bse153048', 'bse153108'),
(13, 1, 2, 'bcs153044', 'bcs153048');

-- --------------------------------------------------------

--
-- Table structure for table `meeting`
--

CREATE TABLE `meeting` (
  `ID` int(30) NOT NULL,
  `RegNo` int(11) NOT NULL,
  `Date` date NOT NULL,
  `MeetingWith` varchar(50) NOT NULL,
  `Subject` varchar(90) NOT NULL,
  `Description` varchar(180) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `meeting`
--

INSERT INTO `meeting` (`ID`, `RegNo`, `Date`, `MeetingWith`, `Subject`, `Description`) VALUES
(1, 181, '2018-08-08', 'Student', 'Feedback', 'good'),
(2, 188, '2018-08-08', 'Student', 'Feedback', 'Feedback is almost good. No issue find'),
(3, 188, '2018-08-01', 'Parent', 'Result', 'GPA was less than 2.0. Discuss with parent GPA less due to family issue');

-- --------------------------------------------------------

--
-- Table structure for table `messages`
--

CREATE TABLE `messages` (
  `ID` int(11) NOT NULL,
  `name` varchar(30) NOT NULL,
  `email` varchar(30) NOT NULL,
  `subject` varchar(30) NOT NULL,
  `message` varchar(80) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `messages`
--

INSERT INTO `messages` (`ID`, `name`, `email`, `subject`, `message`) VALUES
(1, 'M Talha', 'muhammadtalha3810@gmail.com', 'Complains', 'Sir!\r\nIts me talha\r\nbye'),
(2, 'M Talha', 'muhammadtalha3810@gmail.com', 'Complains', 'Sir!\r\nIts me talha\r\nbye'),
(3, 'sadf', 'sadf@ghb.ghb', 'sadf', 'Sir!\r\nIts me talha\r\nbye'),
(4, 'M Talha', 'muhammadtalha@gmail.com', 'Complain', 'AoA \r\nI can\'t login system.\r\nThanks'),
(5, 'ujythgre', 'yhtg@gfds.htg', 'jtyhgrfedwshgrefwd', 'AoA \r\nI can\'t login system.\r\nThanks');

-- --------------------------------------------------------

--
-- Table structure for table `students`
--

CREATE TABLE `students` (
  `id` int(11) NOT NULL,
  `RegNo` varchar(15) NOT NULL,
  `Name` varchar(50) NOT NULL,
  `Address` varchar(80) NOT NULL,
  `Phone` varchar(100) NOT NULL,
  `UG_Atmp` int(150) NOT NULL,
  `UG_Ernd` int(50) NOT NULL,
  `Curr_SCH` int(50) NOT NULL,
  `Prev_SCH` int(50) NOT NULL,
  `U_GPA` float NOT NULL,
  `U_CGPA` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `students`
--

INSERT INTO `students` (`id`, `RegNo`, `Name`, `Address`, `Phone`, `UG_Atmp`, `UG_Ernd`, `Curr_SCH`, `Prev_SCH`, `U_GPA`, `U_CGPA`) VALUES
(181, 'Bcs153044', 'M Talha', 'Islamabad', '03352700381', 104, 104, 18, 19, 3.2, 3.3),
(182, 'Bcs153048', 'M Ali', 'Islamabad', '2147483647', 0, 104, 0, 0, 3.2, 3.3),
(183, 'Bcs153036', 'Hashir', 'Islamabad', '2147483647', 0, 100, 0, 0, 2.5, 3.3),
(184, 'Bcs153054', 'Saad', 'Islamabad', '2147483647', 0, 100, 0, 0, 3.2, 3.3),
(185, 'Bcs153108', 'Simra', 'Islamabad', '123654', 0, 101, 0, 0, 3.5, 3.5),
(186, 'Bcs153073', 'Summiya', 'Rawalpindi', '78965', 0, 101, 0, 0, 3.6, 3.7),
(187, 'Bse153044', 'M Talha', 'Islamabad', '2147483647', 0, 0, 0, 0, 3.2, 3.3),
(188, 'Bse153048', 'M Ali', 'Islamabad', '2147483647', 0, 0, 0, 0, 3.2, 3.3),
(189, 'Bse153036', 'Hashir', 'Islamabad', '2147483647', 0, 0, 0, 0, 2.5, 3.3),
(190, 'Bse153054', 'Saad', 'Islamabad', '2147483647', 0, 0, 0, 0, 3.2, 3.3),
(191, 'Bse153108', 'Simra', 'Islamabad', '123654', 0, 0, 0, 0, 3.5, 3.5),
(192, 'Bse153073', 'Summiya', 'Rawalpindi', '78965', 0, 0, 0, 0, 3.6, 3.7),
(193, 'bcs183011', 'Hussain', 'Isl', '123', 0, 0, 0, 0, 3, 3),
(194, 'Bce153044', 'M Talha', 'Islamabad', '3352700381', 512289377, 0, 0, 0, 3.2, 3.3),
(195, 'Bce153048', 'M Ali', 'Islamabad', '3352700381', 512289377, 0, 0, 0, 3.2, 3.3),
(196, 'Bce153036', 'Hashir', 'Islamabad', '3352700381', 512289377, 0, 0, 0, 2.5, 3.3),
(197, 'Bce153054', 'Saad', 'Islamabad', '3352700381', 512289377, 0, 0, 0, 3.2, 3.3),
(198, 'Bce153108', 'Simra', 'Islamabad', '123654', 789654, 0, 0, 0, 3.5, 3.5),
(199, 'Bce153073', 'Summiya', 'Rawalpindi', '78965', 45632, 0, 0, 0, 3.6, 3.7),
(209, 'BC113010', 'Khawaja', '', '', 157, 135, 0, 0, 0, 2.4),
(210, 'BC113033', 'Haider Ali', '', '', 169, 138, 12, 16, 3, 2.05),
(211, 'BC113115', 'Mustafa', '', '', 178, 135, 0, 8, 0, 2.13),
(220, 'BCS153039', 'Sufiyan', 'Rawal Pindi', '03325185640', 103, 100, 16, 18, 2.5, 2.3),
(221, 'BCS153038', 'Aqib', 'BCS153038', '03060316516', 105, 104, 20, 18, 3, 3.1),
(222, 'BCS153061', 'Luqman', 'PWD', '0332995640', 105, 103, 18, 19, 3.5, 3.3),
(223, 'Taufeeq', 'BCS153073', 'Islamabad', '0301115516', 105, 80, 20, 18, 2, 2.1),
(225, 'BSE153039', 'Sufiyan', 'Rawal Pindi', '03325185640', 103, 100, 16, 18, 2.5, 2.3),
(226, 'Aqib', 'BSE153038', 'Aqib', '03060316516', 105, 104, 20, 18, 3, 3.1),
(227, 'BSE153061', 'Luqman', 'PWD', '0332995640', 105, 103, 18, 19, 3.5, 3.3),
(228, 'BSE153073', 'Taufeeq', 'Islamabad', '0301115516', 105, 80, 20, 18, 2, 2.1);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `ID` int(11) NOT NULL,
  `UserName` varchar(30) NOT NULL,
  `Password` varchar(30) NOT NULL,
  `Role` varchar(11) NOT NULL,
  `email` varchar(30) NOT NULL,
  `reset_password_key` varchar(50) DEFAULT NULL,
  `activation` varchar(80) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`ID`, `UserName`, `Password`, `Role`, `email`, `reset_password_key`, `activation`) VALUES
(1, 'Dr Azhar ', 'qwe', 'Head', 'head@cust.pk', '9a1c30e363d213e7b2e3c4c145183721', 'Yes'),
(2, 'Advisor', 'qwe@123', 'Advisor', '', '', 'Yes'),
(3, 'Student', 'qwe@123', 'Student', '', '', 'Yes'),
(4, 'Faisal Jameel', 'qwe@123', 'Advisor', 'faheem@gmail.com', '', 'Yes'),
(6, 'Talha', 'qwe@123', 'Advisor', '', '', 'Yes'),
(7, 'bcs153044', 'qwe', 'Student', 'muhammadtalha3810@gmail.com', '15e4', 'Yes'),
(8, 'Faheem', 'qwe', 'Advisor', '', '', 'Yes'),
(11, 'Bcs153108', 'qwe@123', 'Student', 'simraabid57@gmail.com', '', 'Yes'),
(12, 'Bcs153073', 'qwe@123', 'Student', 'seemikabeer49@gmail.com', '', 'Yes'),
(13, 'Anser', 'qwe@123', 'Advisor', 'muhammadtalha@gmail.com', '3a0a5', 'Yes');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `advisors`
--
ALTER TABLE `advisors`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `announcement`
--
ALTER TABLE `announcement`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `A_From` (`A_From`);

--
-- Indexes for table `assigned_students`
--
ALTER TABLE `assigned_students`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `Advisor_ID` (`Advisor_ID`);

--
-- Indexes for table `meeting`
--
ALTER TABLE `meeting`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `RegNo` (`RegNo`);

--
-- Indexes for table `messages`
--
ALTER TABLE `messages`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `students`
--
ALTER TABLE `students`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `advisors`
--
ALTER TABLE `advisors`
  MODIFY `ID` int(15) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `announcement`
--
ALTER TABLE `announcement`
  MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=151;

--
-- AUTO_INCREMENT for table `assigned_students`
--
ALTER TABLE `assigned_students`
  MODIFY `ID` int(30) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `meeting`
--
ALTER TABLE `meeting`
  MODIFY `ID` int(30) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `messages`
--
ALTER TABLE `messages`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `students`
--
ALTER TABLE `students`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=229;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `announcement`
--
ALTER TABLE `announcement`
  ADD CONSTRAINT `announcement_ibfk_1` FOREIGN KEY (`A_From`) REFERENCES `users` (`ID`);

--
-- Constraints for table `assigned_students`
--
ALTER TABLE `assigned_students`
  ADD CONSTRAINT `assigned_students_ibfk_1` FOREIGN KEY (`Advisor_ID`) REFERENCES `advisors` (`ID`);

--
-- Constraints for table `meeting`
--
ALTER TABLE `meeting`
  ADD CONSTRAINT `meeting_ibfk_1` FOREIGN KEY (`RegNo`) REFERENCES `students` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
