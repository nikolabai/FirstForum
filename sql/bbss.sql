/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50622
Source Host           : localhost:3306
Source Database       : bbss

Target Server Type    : MYSQL
Target Server Version : 50622
File Encoding         : 65001

Date: 2017-07-21 17:07:49
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for board
-- ----------------------------
DROP TABLE IF EXISTS `board`;
CREATE TABLE `board` (
  `BOARDID` int(11) NOT NULL,
  `BOARDNAME` varchar(255) DEFAULT NULL,
  `BOARDDESC` varchar(255) DEFAULT NULL,
  `TOPICNUM` int(11) DEFAULT NULL,
  PRIMARY KEY (`BOARDID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of board
-- ----------------------------
INSERT INTO `board` VALUES ('1', '体育', '世界杯', '0');
INSERT INTO `board` VALUES ('2', '娱乐', '格莱美', '1');
INSERT INTO `board` VALUES ('3', '文学', '死亡诗社', '3');

-- ----------------------------
-- Table structure for loginlog
-- ----------------------------
DROP TABLE IF EXISTS `loginlog`;
CREATE TABLE `loginlog` (
  `LOGINLOGID` int(11) NOT NULL AUTO_INCREMENT,
  `IP` varchar(255) DEFAULT NULL,
  `LOGINDATE` datetime DEFAULT NULL,
  `USER` int(11) DEFAULT NULL,
  PRIMARY KEY (`LOGINLOGID`),
  KEY `FK_1trod57oade11hftwydjykg4n` (`USER`),
  CONSTRAINT `FK_1trod57oade11hftwydjykg4n` FOREIGN KEY (`USER`) REFERENCES `user` (`USERID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of loginlog
-- ----------------------------
INSERT INTO `loginlog` VALUES ('1', '127.0.0.1', '2017-07-17 15:54:02', '1');
INSERT INTO `loginlog` VALUES ('2', '127.0.0.1', '2017-07-18 15:19:57', '1');
INSERT INTO `loginlog` VALUES ('3', '127.0.0.1', '2017-07-18 15:20:29', '2');
INSERT INTO `loginlog` VALUES ('4', '127.0.0.1', '2017-07-19 20:56:31', '1');
INSERT INTO `loginlog` VALUES ('5', '127.0.0.1', '2017-07-19 20:58:28', '1');

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission` (
  `PERMISSIONID` bigint(20) NOT NULL,
  `NAME` varchar(255) DEFAULT NULL,
  `DESCRIPTION` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`PERMISSIONID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of permission
-- ----------------------------
INSERT INTO `permission` VALUES ('1', 'creatBoard', '创建版块');
INSERT INTO `permission` VALUES ('2', 'assignAdmin', '指定版块管理员');
INSERT INTO `permission` VALUES ('3', 'lock', '锁定用户');
INSERT INTO `permission` VALUES ('4', 'delete', '删除主题和回复');
INSERT INTO `permission` VALUES ('5', 'update', '修改主题和回复');
INSERT INTO `permission` VALUES ('6', 'distillatePost', '指定精华帖');
INSERT INTO `permission` VALUES ('7', 'creatTopic ', '发表主题');
INSERT INTO `permission` VALUES ('8', 'reply', '回复');
INSERT INTO `permission` VALUES ('9', 'visit', '游客访问');
INSERT INTO `permission` VALUES ('10', 'select', '查询');

-- ----------------------------
-- Table structure for post
-- ----------------------------
DROP TABLE IF EXISTS `post`;
CREATE TABLE `post` (
  `BOARDID` int(11) NOT NULL,
  `POSTLD` int(11) DEFAULT NULL,
  `POSTTITLE` varchar(255) DEFAULT NULL,
  `POSTTEXT` varchar(255) DEFAULT NULL,
  `CREATTIME` date DEFAULT NULL,
  `USER` int(11) DEFAULT NULL,
  `TOPIC` int(11) DEFAULT NULL,
  PRIMARY KEY (`BOARDID`),
  KEY `FK_t39qptycw8vc8khek37y4epfa` (`USER`),
  KEY `FK_c2wl6jr80yj3qtcldnqx1g9nf` (`TOPIC`),
  CONSTRAINT `FK_c2wl6jr80yj3qtcldnqx1g9nf` FOREIGN KEY (`TOPIC`) REFERENCES `topic` (`TOPICID`),
  CONSTRAINT `FK_t39qptycw8vc8khek37y4epfa` FOREIGN KEY (`USER`) REFERENCES `user` (`USERID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of post
-- ----------------------------

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `ROLEID` bigint(20) NOT NULL,
  `NAME` varchar(255) DEFAULT NULL,
  `DESCRIPTION` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ROLEID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', 'forumadmin', '版块创建，指定论坛版块管理员，用户的锁定和解锁');
INSERT INTO `role` VALUES ('2', 'boardadmin', '删除主题，删除回复，指定精华帖');
INSERT INTO `role` VALUES ('3', 'regular', '发表主题，回复');
INSERT INTO `role` VALUES ('4', 'visitor', '浏览');

-- ----------------------------
-- Table structure for rolepermission
-- ----------------------------
DROP TABLE IF EXISTS `rolepermission`;
CREATE TABLE `rolepermission` (
  `ID` int(11) NOT NULL,
  `ROLEID` bigint(20) DEFAULT NULL,
  `PERMISSIONID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_hmd2nfbdg4kpkl0ii88u9xow2` (`ROLEID`),
  KEY `FK_2wqfa4f5bio8ww24h2vncqxqo` (`PERMISSIONID`),
  CONSTRAINT `FK_2wqfa4f5bio8ww24h2vncqxqo` FOREIGN KEY (`PERMISSIONID`) REFERENCES `permission` (`PERMISSIONID`),
  CONSTRAINT `FK_hmd2nfbdg4kpkl0ii88u9xow2` FOREIGN KEY (`ROLEID`) REFERENCES `role` (`ROLEID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of rolepermission
-- ----------------------------
INSERT INTO `rolepermission` VALUES ('1', '1', '1');
INSERT INTO `rolepermission` VALUES ('2', '1', '2');
INSERT INTO `rolepermission` VALUES ('3', '1', '3');
INSERT INTO `rolepermission` VALUES ('4', '2', '4');
INSERT INTO `rolepermission` VALUES ('5', '2', '6');
INSERT INTO `rolepermission` VALUES ('6', '3', '5');
INSERT INTO `rolepermission` VALUES ('7', '3', '7');
INSERT INTO `rolepermission` VALUES ('8', '3', '8');
INSERT INTO `rolepermission` VALUES ('9', '4', '9');
INSERT INTO `rolepermission` VALUES ('10', null, null);
INSERT INTO `rolepermission` VALUES ('11', null, null);
INSERT INTO `rolepermission` VALUES ('12', null, null);

-- ----------------------------
-- Table structure for topic
-- ----------------------------
DROP TABLE IF EXISTS `topic`;
CREATE TABLE `topic` (
  `TOPICID` int(11) NOT NULL,
  `BOARD` int(11) DEFAULT NULL,
  `TOPICTITLE` varchar(255) DEFAULT NULL,
  `CREATETIME` datetime DEFAULT NULL,
  `LASTPOST` datetime DEFAULT NULL,
  `VIEWS` int(11) DEFAULT NULL,
  `REPLIES` int(11) DEFAULT NULL,
  `DIGEST` int(11) DEFAULT NULL,
  `USER` int(11) DEFAULT NULL,
  `TOPICTEXT` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`TOPICID`),
  KEY `FK_5adiossfkjy8ejgatsf4qessb` (`BOARD`),
  KEY `FK_mb6i59vonu5e9cp6h3727rlro` (`USER`),
  CONSTRAINT `FK_5adiossfkjy8ejgatsf4qessb` FOREIGN KEY (`BOARD`) REFERENCES `board` (`BOARDID`),
  CONSTRAINT `FK_mb6i59vonu5e9cp6h3727rlro` FOREIGN KEY (`USER`) REFERENCES `user` (`USERID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of topic
-- ----------------------------
INSERT INTO `topic` VALUES ('1', '3', '沁园春', '2017-07-21 15:43:42', '2017-07-21 15:43:50', '1', '1', '1', '1', 'hah ');
INSERT INTO `topic` VALUES ('2', '3', '再别康桥', '2017-07-21 15:43:45', '2017-07-21 15:43:53', '2', '2', '2', '1', 'hah ');
INSERT INTO `topic` VALUES ('3', '3', '锦瑟', '2017-07-21 15:43:48', '2017-07-21 15:43:56', '3', '3', '3', '1', 'haha');
INSERT INTO `topic` VALUES ('4', '3', '史记', '2017-07-21 17:00:48', '2017-07-21 17:00:51', '4', '4', '4', '1', 'DD');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `USERID` int(11) NOT NULL AUTO_INCREMENT,
  `USERNAME` varchar(255) DEFAULT NULL,
  `PASSWORD` varchar(255) DEFAULT NULL,
  `USERTYPE` bigint(20) DEFAULT NULL,
  `LOCKED` bigint(20) DEFAULT NULL,
  `CREDIT` int(11) DEFAULT NULL,
  `LASTVISIT` datetime DEFAULT NULL,
  `LASTIP` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`USERID`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'nick', '123', '1', '0', '145', '2017-07-19 20:58:28', '127.0.0.1');
INSERT INTO `user` VALUES ('2', 'admin', '123', '1', '0', '110', '2017-07-18 15:20:29', '127.0.0.1');
INSERT INTO `user` VALUES ('6', 'hemingway', '82ab0733681f5a45e8ca849753bf47f6', '1', '0', '100', null, null);
INSERT INTO `user` VALUES ('7', 'jack', 'b82d913882cf3384328d33cc5da5381e', '1', '0', '100', null, null);
INSERT INTO `user` VALUES ('8', 'rose', '99b9541649ccecf6ee4ff47ef3764741', '1', '0', '100', null, null);

-- ----------------------------
-- Table structure for userrole
-- ----------------------------
DROP TABLE IF EXISTS `userrole`;
CREATE TABLE `userrole` (
  `ID` int(11) NOT NULL,
  `USERID` int(11) DEFAULT NULL,
  `ROLEID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_mgw80u6hxndhjmeb2pvn4bipi` (`USERID`),
  KEY `FK_cipsmgjk84tva9iw50frwipwq` (`ROLEID`),
  CONSTRAINT `FK_cipsmgjk84tva9iw50frwipwq` FOREIGN KEY (`ROLEID`) REFERENCES `role` (`ROLEID`),
  CONSTRAINT `FK_mgw80u6hxndhjmeb2pvn4bipi` FOREIGN KEY (`USERID`) REFERENCES `user` (`USERID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of userrole
-- ----------------------------
INSERT INTO `userrole` VALUES ('0', '8', '3');
INSERT INTO `userrole` VALUES ('1', '8', '4');
