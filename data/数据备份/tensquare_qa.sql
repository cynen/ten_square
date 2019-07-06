/*
Navicat MySQL Data Transfer

Source Server         : 阿里云数据库8806
Source Server Version : 50726
Source Host           : 47.107.177.108:8806
Source Database       : tensquare_qa

Target Server Type    : MYSQL
Target Server Version : 50726
File Encoding         : 65001

Date: 2019-07-02 23:43:20
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `tb_pl`
-- ----------------------------
DROP TABLE IF EXISTS `tb_pl`;
CREATE TABLE `tb_pl` (
  `problemid` varchar(20) NOT NULL COMMENT '问题ID',
  `labelid` varchar(20) NOT NULL COMMENT '标签ID',
  PRIMARY KEY (`problemid`,`labelid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_pl
-- ----------------------------
INSERT INTO `tb_pl` VALUES ('1', '1');

-- ----------------------------
-- Table structure for `tb_problem`
-- ----------------------------
DROP TABLE IF EXISTS `tb_problem`;
CREATE TABLE `tb_problem` (
  `id` varchar(20) NOT NULL COMMENT 'ID',
  `title` varchar(100) DEFAULT NULL COMMENT '标题',
  `content` text COMMENT '内容',
  `createtime` datetime DEFAULT NULL COMMENT '创建日期',
  `updatetime` datetime DEFAULT NULL COMMENT '修改日期',
  `userid` varchar(20) DEFAULT NULL COMMENT '用户ID',
  `nickname` varchar(100) DEFAULT NULL COMMENT '昵称',
  `visits` bigint(20) DEFAULT NULL COMMENT '浏览量',
  `thumbup` bigint(20) DEFAULT NULL COMMENT '点赞数',
  `reply` bigint(20) DEFAULT NULL COMMENT '回复数',
  `solve` varchar(1) DEFAULT NULL COMMENT '是否解决',
  `replyname` varchar(100) DEFAULT NULL COMMENT '回复人昵称',
  `replytime` datetime DEFAULT NULL COMMENT '回复日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='问题';

-- ----------------------------
-- Records of tb_problem
-- ----------------------------
INSERT INTO `tb_problem` VALUES ('1', '这是个问题', '代码调试不通咋办？', '2018-01-08 11:50:50', '2018-01-09 11:50:54', '2', null, '101', null, null, null, null, null);
INSERT INTO `tb_problem` VALUES ('1140621628871413760', '不知道', '通咋办？', '2018-01-08 11:50:50', '2018-01-09 11:50:54', '2', null, '101', null, null, null, null, null);
INSERT INTO `tb_problem` VALUES ('1144243659265413120', '问题一', '代码调试不通咋办,凉拌', null, null, null, null, null, null, null, null, null, null);

-- ----------------------------
-- Table structure for `tb_reply`
-- ----------------------------
DROP TABLE IF EXISTS `tb_reply`;
CREATE TABLE `tb_reply` (
  `id` varchar(20) NOT NULL COMMENT '编号',
  `problemid` varchar(20) DEFAULT NULL COMMENT '问题ID',
  `content` text COMMENT '回答内容',
  `createtime` datetime DEFAULT NULL COMMENT '创建日期',
  `updatetime` datetime DEFAULT NULL COMMENT '更新日期',
  `userid` varchar(20) DEFAULT NULL COMMENT '回答人ID',
  `nickname` varchar(100) DEFAULT NULL COMMENT '回答人昵称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='回答';

-- ----------------------------
-- Records of tb_reply
-- ----------------------------
INSERT INTO `tb_reply` VALUES ('', '1', null, null, null, null, null);
INSERT INTO `tb_reply` VALUES ('2', '1', '问老师呗', '2018-01-10 14:14:06', null, '1', null);
INSERT INTO `tb_reply` VALUES ('3', '2', '明天再调', '2018-01-07 14:14:13', null, '1', null);

-- ----------------------------
-- Table structure for `tb_ul`
-- ----------------------------
DROP TABLE IF EXISTS `tb_ul`;
CREATE TABLE `tb_ul` (
  `uid` varchar(20) NOT NULL COMMENT '用户ID',
  `lid` varchar(20) NOT NULL COMMENT '标签ID',
  PRIMARY KEY (`uid`,`lid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_ul
-- ----------------------------
