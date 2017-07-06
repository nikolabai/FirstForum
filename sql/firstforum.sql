/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50622
Source Host           : localhost:3306
Source Database       : firstforum

Target Server Type    : MYSQL
Target Server Version : 50622
File Encoding         : 65001

Date: 2017-05-27 22:51:33
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_board
-- ----------------------------
DROP TABLE IF EXISTS `t_board`;
CREATE TABLE `t_board` (
  `board_id` int(11) NOT NULL,
  `board_name` varchar(150) NOT NULL,
  `board_desc` varchar(255) DEFAULT NULL,
  `topic_num` int(11) NOT NULL,
  PRIMARY KEY (`board_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='论坛版块ID';

-- ----------------------------
-- Records of t_board
-- ----------------------------

-- ----------------------------
-- Table structure for t_board_manager
-- ----------------------------
DROP TABLE IF EXISTS `t_board_manager`;
CREATE TABLE `t_board_manager` (
  `board_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`board_id`,`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_board_manager
-- ----------------------------

-- ----------------------------
-- Table structure for t_login_log
-- ----------------------------
DROP TABLE IF EXISTS `t_login_log`;
CREATE TABLE `t_login_log` (
  `login_log_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `ip` varchar(30) NOT NULL,
  `login_datetime` datetime NOT NULL,
  PRIMARY KEY (`login_log_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_login_log
-- ----------------------------

-- ----------------------------
-- Table structure for t_post
-- ----------------------------
DROP TABLE IF EXISTS `t_post`;
CREATE TABLE `t_post` (
  `post_id` int(11) NOT NULL,
  `board_id` int(11) NOT NULL,
  `topic_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `post_type` tinyint(4) NOT NULL,
  `post_title` varchar(50) NOT NULL,
  `post_text` text NOT NULL,
  `creat_time` datetime NOT NULL,
  PRIMARY KEY (`post_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_post
-- ----------------------------

-- ----------------------------
-- Table structure for t_topc
-- ----------------------------
DROP TABLE IF EXISTS `t_topc`;
CREATE TABLE `t_topc` (
  `topic_id` int(11) NOT NULL,
  `board_id` int(11) NOT NULL,
  `topic_title` varchar(100) NOT NULL,
  `user_id` int(11) NOT NULL,
  `create_time` datetime NOT NULL,
  `last_post` datetime NOT NULL,
  `topic_views` int(11) NOT NULL,
  `topic_replies` int(11) NOT NULL,
  `digest` int(11) NOT NULL,
  PRIMARY KEY (`topic_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_topc
-- ----------------------------

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `user_id` int(11) NOT NULL,
  `user_name` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL,
  `user_type` tinyint(4) NOT NULL,
  `locked` tinyint(4) NOT NULL,
  `credit` int(11) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
