/*
Navicat MySQL Data Transfer

Source Server         : 阿里云数据库8806
Source Server Version : 50726
Source Host           : 47.107.177.108:8806
Source Database       : tensquare_friend

Target Server Type    : MYSQL
Target Server Version : 50726
File Encoding         : 65001

Date: 2019-07-02 23:43:04
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `tb_friend`
-- ----------------------------
DROP TABLE IF EXISTS `tb_friend`;
CREATE TABLE `tb_friend` (
  `userid` varchar(20) NOT NULL COMMENT '用户ID',
  `friendid` varchar(20) NOT NULL COMMENT '好友ID',
  `islike` varchar(1) DEFAULT NULL COMMENT '是否互相喜欢',
  PRIMARY KEY (`userid`,`friendid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_friend
-- ----------------------------
INSERT INTO `tb_friend` VALUES ('1', '1144241657038901248', '1');
INSERT INTO `tb_friend` VALUES ('1144241657038901248', '1', '1');

-- ----------------------------
-- Table structure for `tb_nofriend`
-- ----------------------------
DROP TABLE IF EXISTS `tb_nofriend`;
CREATE TABLE `tb_nofriend` (
  `userid` varchar(20) NOT NULL COMMENT '用户id',
  `friendid` varchar(20) NOT NULL COMMENT '好友idd',
  PRIMARY KEY (`userid`,`friendid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_nofriend
-- ----------------------------
