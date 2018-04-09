mysql -u root -p
123456

drop database bta;
create database bta;
use bta;

CREATE TABLE IF NOT EXISTS `users` (
  `idnumber` varchar(30) NOT NULL,
  `fullname` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL,
  `grade` int(3) default 0,
  `usertype` varchar(30) default 'student',
  PRIMARY KEY  (`idnumber`)
) ;

INSERT INTO users(`idnumber`,`fullname`,`password`,`grade`,`usertype`) VALUES ('admin','administrator','123456',0,'admin');

-- ----------------------------
-- Table structure for books
-- ----------------------------
DROP TABLE IF EXISTS `books`;
CREATE TABLE `books` (
  `bid` int(10) unsigned NOT NULL auto_increment,
  `title` varchar(255) DEFAULT NULL,  
  `author` varchar(255) DEFAULT NULL,  
  `yrpublished` varchar(255) DEFAULT NULL,
  `desc` text,
  `image` varchar(255) DEFAULT NULL,
  `preview` varchar(255) DEFAULT NULL,
  `noofcopies` int(10) unsigned NOT NULL default 10,
  `grade` int(3) not null,
  `status` int(3) not null default 0,
  PRIMARY KEY (`bid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `issuebooks`;
CREATE TABLE `issuebooks` (
  `tid` int(11) NOT NULL AUTO_INCREMENT,
  `bookid` varchar(255) DEFAULT NULL,
  `memid` varchar(255) DEFAULT NULL,
  `issuedate` datetime DEFAULT NULL,
  `duedate` datetime DEFAULT NULL,
  `status` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`tid`),
  UNiQUE KEY(bookid,memid,status)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

commit;