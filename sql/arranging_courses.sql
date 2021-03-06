/*
Navicat MySQL Data Transfer

Source Server         : MySQL：000000
Source Server Version : 50621
Source Host           : localhost:3306
Source Database       : arranging_courses

Target Server Type    : MYSQL
Target Server Version : 50621
File Encoding         : 65001

Date: 2020-04-28 21:36:50
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for arrange
-- ----------------------------
DROP TABLE IF EXISTS `arrange`;
CREATE TABLE `arrange` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `course_id` int(10) NOT NULL,
  `class_id` int(10) NOT NULL,
  `room_id` int(10) NOT NULL,
  `techer_id` int(20) NOT NULL,
  `seme_id` int(20) NOT NULL,
  `course_name` varchar(20) DEFAULT '',
  `class_name` varchar(20) DEFAULT NULL,
  `room_name` varchar(20) DEFAULT NULL,
  `techer_name` varchar(20) DEFAULT NULL,
  `star_week` int(11) DEFAULT NULL,
  `end_week` int(11) DEFAULT NULL,
  `srd` int(10) DEFAULT '0',
  `statu` int(2) DEFAULT '0' COMMENT '标志',
  `mark` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of arrange
-- ----------------------------

-- ----------------------------
-- Table structure for classes
-- ----------------------------
DROP TABLE IF EXISTS `classes`;
CREATE TABLE `classes` (
  `id` int(3) NOT NULL AUTO_INCREMENT,
  `class_name` varchar(20) NOT NULL DEFAULT '',
  `class_number` varchar(20) DEFAULT NULL,
  `day_limit` int(10) DEFAULT '8',
  `statu` int(10) DEFAULT '0',
  `mark` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of classes
-- ----------------------------
INSERT INTO `classes` VALUES ('1', '软件1班', '345', '3', '0', null);

-- ----------------------------
-- Table structure for classroom
-- ----------------------------
DROP TABLE IF EXISTS `classroom`;
CREATE TABLE `classroom` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `room_name` varchar(20) NOT NULL DEFAULT '',
  `room_space` int(4) DEFAULT NULL,
  `room_layer` int(10) DEFAULT NULL,
  `room_sign` int(11) DEFAULT '0',
  `statu` int(10) DEFAULT '0',
  `mark` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='教室表';

-- ----------------------------
-- Records of classroom
-- ----------------------------
INSERT INTO `classroom` VALUES ('1', 'I302', '50', '1', '0', '0', null);

-- ----------------------------
-- Table structure for college
-- ----------------------------
DROP TABLE IF EXISTS `college`;
CREATE TABLE `college` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `college_name` varchar(20) NOT NULL DEFAULT '',
  `college_describe` int(200) NOT NULL,
  `statu` int(10) DEFAULT '0',
  `mark` varchar(200) DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of college
-- ----------------------------

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `course_name` varchar(20) NOT NULL DEFAULT '',
  `course_time` int(2) DEFAULT NULL COMMENT '课时',
  `statu` int(10) DEFAULT '0',
  `mark` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES ('1', '数据结构', '30', '0', null);

-- ----------------------------
-- Table structure for courses_table
-- ----------------------------
DROP TABLE IF EXISTS `courses_table`;
CREATE TABLE `courses_table` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `type` varchar(20) DEFAULT NULL COMMENT '类别',
  `type_id` int(11) DEFAULT NULL COMMENT '类别ID',
  `courses` longtext COMMENT '课程数据',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COMMENT='课程表';

-- ----------------------------
-- Records of courses_table
-- ----------------------------
INSERT INTO `courses_table` VALUES ('1', 'class', '1', '[{\"classStart\":3,\"dayOfWeek\":1,\"name\":\"文科物理学\"},{\"classStart\":5,\"dayOfWeek\":1,\"name\":\"人工智能\"},{\"classStart\":3,\"dayOfWeek\":2,\"name\":\"计算机网络\"},{\"classStart\":5,\"dayOfWeek\":2,\"name\":\"编译原理\"},{\"classStart\":6,\"dayOfWeek\":4,\"name\":\"算法分析与设计\"}]');
INSERT INTO `courses_table` VALUES ('3', 'engineRoom', '2', '[{\"dayOfWeek\":1,\"classStart\":1,\"name\":\"高等数学\"},{\"dayOfWeek\":3,\"classStart\":3,\"name\":\"大学英语\"},{\"dayOfWeek\":7,\"classStart\":5,\"name\":\"软件工程\"}]');
INSERT INTO `courses_table` VALUES ('11', 'engineRoom', '1', '[{\"dayOfWeek\":2,\"classStart\":1,\"name\":\"数据结构\"},{\"dayOfWeek\":5,\"classStart\":4,\"name\":\"高等数学\"},{\"dayOfWeek\":1,\"classStart\":2,\"name\":\"大学英语\"},{\"dayOfWeek\":2,\"classStart\":2,\"name\":\"计算机\"},{\"dayOfWeek\":3,\"classStart\":1,\"name\":\"可信计算\"},{\"dayOfWeek\":4,\"classStart\":2,\"name\":\"微机原理\"},{\"dayOfWeek\":5,\"classStart\":5,\"name\":\"心理健康\"}]');

-- ----------------------------
-- Table structure for course_table
-- ----------------------------
DROP TABLE IF EXISTS `course_table`;
CREATE TABLE `course_table` (
  `id` int(11) NOT NULL,
  `arr_id` int(11) DEFAULT NULL COMMENT '排课ID',
  `course_id` int(11) DEFAULT NULL COMMENT '课程ID',
  `class_id` int(11) DEFAULT NULL COMMENT '班级ID',
  `room_id` int(11) DEFAULT NULL COMMENT '教室ID',
  `techer_id` int(11) DEFAULT NULL COMMENT '教师ID',
  `seme_id` int(11) DEFAULT NULL,
  `seme_name` varchar(255) DEFAULT NULL,
  `time_id` int(11) DEFAULT NULL,
  `time_name` varchar(255) DEFAULT NULL,
  `course_name` varchar(255) DEFAULT NULL COMMENT '课程名称',
  `class_name` varchar(255) DEFAULT NULL COMMENT '教室名称',
  `room_name` varchar(255) DEFAULT NULL COMMENT '教室名称',
  `techer_name` varchar(255) DEFAULT NULL COMMENT '教师名称',
  `statu` int(3) DEFAULT NULL,
  `temporary` int(11) DEFAULT NULL,
  `mark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='课程表';

-- ----------------------------
-- Records of course_table
-- ----------------------------

-- ----------------------------
-- Table structure for engine_room
-- ----------------------------
DROP TABLE IF EXISTS `engine_room`;
CREATE TABLE `engine_room` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `room_name` varchar(20) NOT NULL DEFAULT '',
  `room_space` int(4) DEFAULT NULL,
  `room_layer` int(10) DEFAULT NULL,
  `room_sign` int(11) DEFAULT '0',
  `statu` int(10) DEFAULT '0',
  `mark` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='机房表';

-- ----------------------------
-- Records of engine_room
-- ----------------------------
INSERT INTO `engine_room` VALUES ('1', 'I302', '500', '1', '0', '0', null);
INSERT INTO `engine_room` VALUES ('2', '机房2', '77', '1', '0', '0', null);

-- ----------------------------
-- Table structure for exam
-- ----------------------------
DROP TABLE IF EXISTS `exam`;
CREATE TABLE `exam` (
  `id` int(3) NOT NULL AUTO_INCREMENT,
  `class_name` varchar(20) NOT NULL DEFAULT '',
  `class_number` varchar(20) DEFAULT '',
  `day_limit` int(10) DEFAULT '8',
  `statu` varchar(200) DEFAULT '0',
  `mark` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of exam
-- ----------------------------
INSERT INTO `exam` VALUES ('1', '软件1班', '2020-09', '3', '数学2', '阿瑟东');

-- ----------------------------
-- Table structure for grade
-- ----------------------------
DROP TABLE IF EXISTS `grade`;
CREATE TABLE `grade` (
  `id` int(3) NOT NULL AUTO_INCREMENT,
  `class_name` varchar(20) DEFAULT '',
  `class_number` varchar(20) DEFAULT '',
  `day_limit` int(10) DEFAULT '8',
  `statu` int(10) DEFAULT '0',
  `mark` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of grade
-- ----------------------------
INSERT INTO `grade` VALUES ('1', '12', 'C语言', '3', '0', '67');

-- ----------------------------
-- Table structure for semester
-- ----------------------------
DROP TABLE IF EXISTS `semester`;
CREATE TABLE `semester` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `year` varchar(20) NOT NULL DEFAULT '',
  `semester` varchar(20) NOT NULL DEFAULT '',
  `week_count` int(10) NOT NULL,
  `statu` int(10) DEFAULT '0',
  `mark` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of semester
-- ----------------------------

-- ----------------------------
-- Table structure for speciality
-- ----------------------------
DROP TABLE IF EXISTS `speciality`;
CREATE TABLE `speciality` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `spe_name` varchar(20) NOT NULL DEFAULT '',
  `spe_describe` varchar(200) NOT NULL DEFAULT '',
  `statu` int(10) DEFAULT '0',
  `mark` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of speciality
-- ----------------------------

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `teacher_name` varchar(20) NOT NULL DEFAULT '',
  `teacher_phone` varchar(15) DEFAULT NULL,
  `count_limit` int(10) DEFAULT '20',
  `statu` int(10) DEFAULT '0',
  `mark` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('1', 'dj', '18890908762', '6', '0', null);

-- ----------------------------
-- Table structure for teaching
-- ----------------------------
DROP TABLE IF EXISTS `teaching`;
CREATE TABLE `teaching` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `class_id` int(10) DEFAULT NULL,
  `teacher_id` int(10) DEFAULT NULL,
  `sem_id` int(10) DEFAULT NULL,
  `class_name` varchar(20) DEFAULT NULL,
  `techer_name` varchar(20) DEFAULT NULL,
  `sign` varchar(20) DEFAULT NULL,
  `statu` int(10) DEFAULT NULL,
  `mark` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teaching
-- ----------------------------

-- ----------------------------
-- Table structure for term_room
-- ----------------------------
DROP TABLE IF EXISTS `term_room`;
CREATE TABLE `term_room` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `room_name` varchar(20) DEFAULT '',
  `room_space` int(4) DEFAULT NULL,
  `room_layer` int(10) DEFAULT NULL,
  `room_sign` int(11) DEFAULT '0',
  `statu` int(10) DEFAULT '0',
  `mark` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='教室表';

-- ----------------------------
-- Records of term_room
-- ----------------------------
INSERT INTO `term_room` VALUES ('1', '第一学期', '50', '1', '0', '0', '2020年');
INSERT INTO `term_room` VALUES ('2', '第二学期', null, null, '0', '0', '2020年');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `no` varchar(20) DEFAULT NULL COMMENT '学号',
  `username` varchar(20) DEFAULT '',
  `password` varchar(20) DEFAULT '',
  `role` varchar(10) DEFAULT '普通用户',
  `age` int(3) DEFAULT NULL COMMENT '年纪',
  `statu` int(11) DEFAULT '0',
  `mark` varchar(200) DEFAULT NULL,
  `class_name` varchar(50) DEFAULT NULL COMMENT '班级',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('17', '1', 'kwk', '123456', '32', '23', null, '123213', null);
INSERT INTO `user` VALUES ('18', '2', 'admin', '123456', '超级管理员', '21', null, '123434', null);
INSERT INTO `user` VALUES ('19', null, 'DJ小', '123123', '23', null, '0', '12', null);
