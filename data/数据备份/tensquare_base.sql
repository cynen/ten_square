/*
Navicat MySQL Data Transfer

Source Server         : 阿里云数据库8806
Source Server Version : 50726
Source Host           : 47.107.177.108:8806
Source Database       : tensquare_base

Target Server Type    : MYSQL
Target Server Version : 50726
File Encoding         : 65001

Date: 2019-07-02 23:42:56
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `tb_city`
-- ----------------------------
DROP TABLE IF EXISTS `tb_city`;
CREATE TABLE `tb_city` (
  `id` varchar(20) NOT NULL COMMENT 'ID',
  `name` varchar(20) DEFAULT NULL COMMENT '鍩庡競鍚嶇О',
  `ishot` varchar(1) DEFAULT NULL COMMENT '鏄惁鐑棬',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='鍩庡競';

-- ----------------------------
-- Records of tb_city
-- ----------------------------
INSERT INTO `tb_city` VALUES ('1', '鍖椾含', '1');
INSERT INTO `tb_city` VALUES ('2', '涓婃捣', '1');
INSERT INTO `tb_city` VALUES ('3', '骞垮窞', '1');
INSERT INTO `tb_city` VALUES ('4', '娣卞湷', '1');
INSERT INTO `tb_city` VALUES ('5', '澶╂触', '0');
INSERT INTO `tb_city` VALUES ('6', '閲嶅簡', '0');
INSERT INTO `tb_city` VALUES ('7', '瑗垮畨', '0');

-- ----------------------------
-- Table structure for `tb_label`
-- ----------------------------
DROP TABLE IF EXISTS `tb_label`;
CREATE TABLE `tb_label` (
  `id` varchar(20) NOT NULL COMMENT '标签ID',
  `labelname` varchar(100) DEFAULT NULL COMMENT '标签名称',
  `state` varchar(1) DEFAULT NULL COMMENT '状态',
  `count` bigint(20) DEFAULT NULL COMMENT '使用数量',
  `recommend` varchar(1) DEFAULT NULL COMMENT '是否推荐',
  `fans` bigint(20) DEFAULT NULL COMMENT '粉丝数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='标签';

-- ----------------------------
-- Records of tb_label
-- ----------------------------
INSERT INTO `tb_label` VALUES ('1', 'java', '1', null, null, null);
INSERT INTO `tb_label` VALUES ('1140608516445282304', 'Python', '1', null, null, null);
INSERT INTO `tb_label` VALUES ('2', 'PHP', '1', null, null, null);
INSERT INTO `tb_label` VALUES ('3', 'C++', '1', null, null, null);
INSERT INTO `tb_label` VALUES ('4', 'python', '1', null, null, null);

-- ----------------------------
-- Table structure for `tb_ul`
-- ----------------------------
DROP TABLE IF EXISTS `tb_ul`;
CREATE TABLE `tb_ul` (
  `userid` varchar(20) NOT NULL,
  `labelid` varchar(20) NOT NULL,
  PRIMARY KEY (`userid`,`labelid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_ul
-- ----------------------------
INSERT INTO `tb_ul` VALUES ('1', '1');
INSERT INTO `tb_ul` VALUES ('1', '2');
INSERT INTO `tb_ul` VALUES ('1', '3');
