/*
Navicat MySQL Data Transfer

Source Server         : localhost_mybase
Source Server Version : 50508
Source Host           : localhost:3306
Source Database       : gyl

Target Server Type    : MYSQL
Target Server Version : 50508
File Encoding         : 65001

Date: 2018-05-18 15:36:13
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `department`
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
  `did` bigint(20) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  `description` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`did`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES ('1', 'qwe', 'qweqweqweqwe');

-- ----------------------------
-- Table structure for `menuitem`
-- ----------------------------
DROP TABLE IF EXISTS `menuitem`;
CREATE TABLE `menuitem` (
  `mid` bigint(20) NOT NULL,
  `pid` bigint(20) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `icon` varchar(100) DEFAULT NULL,
  `isParent` bit(1) DEFAULT NULL,
  PRIMARY KEY (`mid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of menuitem
-- ----------------------------

-- ----------------------------
-- Table structure for `privilege`
-- ----------------------------
DROP TABLE IF EXISTS `privilege`;
CREATE TABLE `privilege` (
  `id` bigint(20) NOT NULL,
  `description` varchar(20) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `pid` bigint(20) DEFAULT NULL,
  `isParent` bit(1) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `icon` varchar(100) DEFAULT NULL,
  `url` varchar(100) DEFAULT NULL,
  `target` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of privilege
-- ----------------------------

-- ----------------------------
-- Table structure for `role`
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `rid` bigint(20) NOT NULL,
  `pid` bigint(20) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `isParent` bit(1) DEFAULT NULL,
  PRIMARY KEY (`rid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------

-- ----------------------------
-- Table structure for `role_privilege`
-- ----------------------------
DROP TABLE IF EXISTS `role_privilege`;
CREATE TABLE `role_privilege` (
  `id` bigint(20) NOT NULL,
  `rid` bigint(20) NOT NULL,
  PRIMARY KEY (`rid`,`id`),
  KEY `FK45FBD628F2CBBE84` (`id`),
  KEY `FK45FBD628789AABCB` (`rid`),
  CONSTRAINT `FK45FBD628789AABCB` FOREIGN KEY (`rid`) REFERENCES `role` (`rid`),
  CONSTRAINT `FK45FBD628F2CBBE84` FOREIGN KEY (`id`) REFERENCES `privilege` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_privilege
-- ----------------------------

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `uid` bigint(20) NOT NULL,
  `email` varchar(20) DEFAULT NULL,
  `password` varchar(8) DEFAULT NULL,
  `phone` varchar(11) DEFAULT NULL,
  `sex` varchar(10) DEFAULT NULL,
  `username` varchar(20) DEFAULT NULL,
  `did` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`uid`),
  KEY `FK36EBCBD50FDB99` (`did`),
  CONSTRAINT `FK36EBCBD50FDB99` FOREIGN KEY (`did`) REFERENCES `department` (`did`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------

-- ----------------------------
-- Table structure for `user_role`
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `uid` bigint(20) NOT NULL,
  `rid` bigint(20) NOT NULL,
  PRIMARY KEY (`rid`,`uid`),
  KEY `FK143BF46A3A2539E3` (`uid`),
  KEY `FK143BF46A789AABCB` (`rid`),
  CONSTRAINT `FK143BF46A3A2539E3` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`),
  CONSTRAINT `FK143BF46A789AABCB` FOREIGN KEY (`rid`) REFERENCES `role` (`rid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_role
-- ----------------------------

-- ----------------------------
-- Table structure for `xsyddzhib`
-- ----------------------------
DROP TABLE IF EXISTS `xsyddzhib`;
CREATE TABLE `xsyddzhib` (
  `xsyddzhibid` bigint(20) NOT NULL,
  `spbm` varchar(255) DEFAULT NULL,
  `spmc` varchar(255) DEFAULT NULL,
  `dpkl` float DEFAULT NULL,
  `hh` bigint(20) DEFAULT NULL,
  `hsdj` float DEFAULT NULL,
  `hsje` float DEFAULT NULL,
  `jldw` varchar(255) DEFAULT NULL,
  `se` float DEFAULT NULL,
  `shdw` varchar(255) DEFAULT NULL,
  `shulv` float DEFAULT NULL,
  `sl` bigint(20) DEFAULT NULL,
  `wsdj` float DEFAULT NULL,
  `wsje` float DEFAULT NULL,
  `xh` varchar(255) DEFAULT NULL,
  `zke` float DEFAULT NULL,
  `xsyddzhubid` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`xsyddzhibid`),
  KEY `FK52DE278552E138E2` (`xsyddzhubid`),
  CONSTRAINT `FK52DE278552E138E2` FOREIGN KEY (`xsyddzhubid`) REFERENCES `xsyddzhub` (`xsyddzhubid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of xsyddzhib
-- ----------------------------

-- ----------------------------
-- Table structure for `xsyddzhub`
-- ----------------------------
DROP TABLE IF EXISTS `xsyddzhub`;
CREATE TABLE `xsyddzhub` (
  `xsyddzhubid` bigint(20) NOT NULL,
  `ddh` varchar(100) DEFAULT NULL,
  `dhrq` date DEFAULT NULL,
  `khmc` varchar(100) DEFAULT NULL,
  `spr` varchar(20) DEFAULT NULL,
  `sprq` datetime DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `sxbm` varchar(20) DEFAULT NULL,
  `xgr` varchar(20) DEFAULT NULL,
  `xgrq` datetime DEFAULT NULL,
  `ywy` varchar(20) DEFAULT NULL,
  `zdr` varchar(255) DEFAULT NULL,
  `zdrq` datetime DEFAULT NULL,
  PRIMARY KEY (`xsyddzhubid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of xsyddzhub
-- ----------------------------
