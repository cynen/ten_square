/*
Navicat MySQL Data Transfer

Source Server         : 阿里云数据库8806
Source Server Version : 50726
Source Host           : 47.107.177.108:8806
Source Database       : tensquare_user

Target Server Type    : MYSQL
Target Server Version : 50726
File Encoding         : 65001

Date: 2019-07-02 23:43:36
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `tb_admin`
-- ----------------------------
DROP TABLE IF EXISTS `tb_admin`;
CREATE TABLE `tb_admin` (
  `id` varchar(20) NOT NULL COMMENT 'ID',
  `loginname` varchar(100) DEFAULT NULL COMMENT '登陆名称',
  `password` varchar(100) DEFAULT NULL COMMENT '密码',
  `state` varchar(1) DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='管理员';

-- ----------------------------
-- Records of tb_admin
-- ----------------------------
INSERT INTO `tb_admin` VALUES ('1143906202749636608', '阿黄', '$2a$10$pfqUXcHlZcxF18WqSX/FyuZTBvj.siQlEFf5zNUB15caozRaeGp1W', '1');

-- ----------------------------
-- Table structure for `tb_follow`
-- ----------------------------
DROP TABLE IF EXISTS `tb_follow`;
CREATE TABLE `tb_follow` (
  `userid` varchar(20) NOT NULL COMMENT '用户ID',
  `targetuser` varchar(20) NOT NULL COMMENT '被关注用户ID',
  PRIMARY KEY (`userid`,`targetuser`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_follow
-- ----------------------------
INSERT INTO `tb_follow` VALUES ('1', '1');
INSERT INTO `tb_follow` VALUES ('1', '10');

-- ----------------------------
-- Table structure for `tb_user`
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `id` varchar(20) NOT NULL COMMENT 'ID',
  `mobile` varchar(100) DEFAULT NULL COMMENT '手机号码',
  `password` varchar(100) DEFAULT NULL COMMENT '密码',
  `nickname` varchar(100) DEFAULT NULL COMMENT '昵称',
  `sex` varchar(2) DEFAULT NULL COMMENT '性别',
  `birthday` datetime DEFAULT NULL COMMENT '出生年月日',
  `avatar` varchar(100) DEFAULT NULL COMMENT '头像',
  `email` varchar(100) DEFAULT NULL COMMENT 'E-Mail',
  `regdate` datetime DEFAULT NULL COMMENT '注册日期',
  `updatedate` datetime DEFAULT NULL COMMENT '修改日期',
  `lastdate` datetime DEFAULT NULL COMMENT '最后登陆日期',
  `online` bigint(20) DEFAULT NULL COMMENT '在线时长（分钟）',
  `interest` varchar(100) DEFAULT NULL COMMENT '兴趣',
  `personality` varchar(100) DEFAULT NULL COMMENT '个性',
  `fanscount` int(20) DEFAULT NULL COMMENT '粉丝数',
  `followcount` int(20) DEFAULT NULL COMMENT '关注数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户';

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES ('1', '18988889999', '$2a$10$AnLh7HYLh3BHl8jrxbesEeYRoywAIK0YUbbo5Uc6wAEMkpqnPg32i', '小白', '男', '2018-01-08 15:39:19', null, null, null, null, null, null, null, null, '1', '0');
INSERT INTO `tb_user` VALUES ('1143171504406663168', '15011112222', '$2a$10$AnLh7HYLh3BHl8jrxbesEeYRoywAIK0YUbbo5Uc6wAEMkpqnPg32i', '这一下是否会好点', '男', null, null, null, '2019-06-24 22:58:20', '2019-06-24 22:58:20', '2019-06-24 22:58:20', '0', null, null, '0', '0');
INSERT INTO `tb_user` VALUES ('1144241657038901248', '18986521556', '$2a$10$AnLh7HYLh3BHl8jrxbesEeYRoywAIK0YUbbo5Uc6wAEMkpqnPg32i', '测试一把嘛', '男', null, null, null, '2019-06-27 21:50:45', '2019-06-27 21:50:45', '2019-06-27 21:50:45', '0', null, null, '0', '0');
