/*
 Navicat MySQL Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 50558
 Source Host           : localhost:3306
 Source Schema         : parttime_job

 Target Server Type    : MySQL
 Target Server Version : 50558
 File Encoding         : 65001

 Date: 19/08/2018 16:06:11
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for applyinfo  申请信息
-- ----------------------------
DROP TABLE IF EXISTS `applyinfo`;
CREATE TABLE `applyinfo`  (
  `student_id` int NOT NULL,
  `merchant_id` int NOT NULL,
  `job` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`student_id`, `merchant_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for dd     行业数据字典 
-- ----------------------------
DROP TABLE IF EXISTS `job`;
CREATE TABLE `job`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `keycode` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '对外键',
  `parameter` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '值',
  `fathernode` int NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;
select *  from dd

select *     from job    WHERE keycode like '%行业%'
	
select * from job where fathernode in(
	select  fathernode from job where id=10
)
-- ----------------------------
-- Table structure for merchant_baseinfo     商家信息
-- ----------------------------
DROP TABLE IF EXISTS `merchant_baseinfo`;
CREATE TABLE `merchant_baseinfo`  (
  `merchant_id` int NOT NULL AUTO_INCREMENT COMMENT '商家id',
  `merchant_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商家名',
  `merchant_username` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商家登陆用户名',
  `merchant_password` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商家登陆密码',
  `merchant_telephone` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商家电话',
  `merchant_license` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '营业执照码',
  `merchant_idcard` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '店主身份证',
  PRIMARY KEY (`merchant_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for merchant_wantedjob     商家发布的兼职信息
-- ----------------------------
DROP TABLE IF EXISTS `merchant_wantedjob`;    
CREATE TABLE `merchant_wantedjob`  (
  `merchant_id` int NOT NULL,
  `salary` decimal(10, 2) NULL DEFAULT NULL,
  `job` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `worktime` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `workplace` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `workdescp` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`merchant_id`) USING BTREE,
  CONSTRAINT `merchant_wantedjob_ibfk_1` FOREIGN KEY (`merchant_id`) REFERENCES `merchant_baseinfo` (`merchant_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for student_baseinfo      学生基本信息
-- ----------------------------
DROP TABLE IF EXISTS `student_baseinfo`;
CREATE TABLE `student_baseinfo`  (
  `stu_id` int NOT NULL AUTO_INCREMENT COMMENT '兼职学生id',
  `stu_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '兼职学生姓名',
  `stu_username` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '兼职学生用户名',
  `stu_password` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '兼职学生密码',
  `stu_telephone` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '兼职学生电话',
  `stu_idcard` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '兼职学生身份证',
  PRIMARY KEY (`stu_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for student_wantedjob     学生兼职意向
-- ----------------------------
DROP TABLE IF EXISTS `student_wantedjob`;
CREATE TABLE `student_wantedjob`  (
  `stu_id` int NOT NULL,
  `job` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '职业名',
  `workplace` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所在学校',
  `salary` decimal(10, 2) NULL DEFAULT NULL COMMENT '薪资',
  `worktime` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '预期工作时间',
  PRIMARY KEY (`stu_id`) USING BTREE,
  CONSTRAINT `student_wantedjob_ibfk_1` FOREIGN KEY (`stu_id`) REFERENCES `student_baseinfo` (`stu_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

SET FOREIGN_KEY_CHECKS = 1;
