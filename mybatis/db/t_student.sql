/*
Navicat MySQL Data Transfer

Source Server         : 本机
Source Server Version : 50528
Source Host           : localhost:3306
Source Database       : ssm

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2022-11-16 23:07:06
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_student
-- ----------------------------
DROP TABLE IF EXISTS `t_student`;
CREATE TABLE `t_student` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `height` double DEFAULT NULL,
  `birth` date DEFAULT NULL,
  `sex` char(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of t_student
-- ----------------------------
INSERT INTO `t_student` VALUES ('1', '张三', '20', '1.81', '2013-01-23', '男');
INSERT INTO `t_student` VALUES ('2', '李四', '18', '1.88', '1998-11-13', '女');
INSERT INTO `t_student` VALUES ('4', '赵六', '18', '1.88', '1970-01-01', '女');
INSERT INTO `t_student` VALUES ('5', '李七', '18', '1.6', '1970-01-01', '女');
