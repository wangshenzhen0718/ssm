/*
Navicat MySQL Data Transfer

Source Server         : 本机
Source Server Version : 50528
Source Host           : localhost:3306
Source Database       : ssm

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2022-10-30 22:47:21
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_car
-- ----------------------------
DROP TABLE IF EXISTS `t_car`;
CREATE TABLE `t_car` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键自增',
  `brand` varchar(255) DEFAULT NULL COMMENT '汽车品牌',
  `car_num` varchar(255) DEFAULT NULL COMMENT '汽车编号',
  `guide_price` decimal(10,2) DEFAULT NULL COMMENT '厂家指导价',
  `produce_time` char(10) DEFAULT NULL COMMENT '生产日期',
  `car_type` varchar(255) DEFAULT NULL COMMENT '汽车类型，包括：燃油车，电车，氢能源',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of t_car
-- ----------------------------
INSERT INTO `t_car` VALUES ('1', '宝马520Li', '1001', '10.00', '2020-10-11', '燃油车');
INSERT INTO `t_car` VALUES ('2', '奔驰E00L', '1002', '55.00', '2020-10-11', '新能源');
INSERT INTO `t_car` VALUES ('27', '比亚迪汉', '1111', '10.00', '2022-10-30', '电动车');
INSERT INTO `t_car` VALUES ('28', '比亚迪 plus', '1000', '20.00', '2022-10-31', '电动车');
