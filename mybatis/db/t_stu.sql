/*
Navicat MySQL Data Transfer

Source Server         : 本机
Source Server Version : 50528
Source Host           : localhost:3306
Source Database       : ssm

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2022-11-16 23:06:58
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_stu
-- ----------------------------
DROP TABLE IF EXISTS `t_stu`;
CREATE TABLE `t_stu` (
  `sid` int(11) DEFAULT NULL,
  `sname` varchar(255) DEFAULT NULL,
  `cid` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of t_stu
-- ----------------------------
INSERT INTO `t_stu` VALUES ('1', '张三', '1000');
INSERT INTO `t_stu` VALUES ('2', '李四', '1000');
INSERT INTO `t_stu` VALUES ('3', '王五', '1000');
INSERT INTO `t_stu` VALUES ('4', '赵六', '1001');
INSERT INTO `t_stu` VALUES ('5', '钱七', '1001');
