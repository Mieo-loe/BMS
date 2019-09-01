/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50643
Source Host           : 127.0.0.1:3306
Source Database       : bms

Target Server Type    : MYSQL
Target Server Version : 50643
File Encoding         : 65001

Date: 2019-09-01 22:40:04
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '书籍id',
  `bookCode` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '书籍编码',
  `bookName` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '书籍名称',
  `bookPrice` double(255,2) DEFAULT NULL COMMENT '书籍价格',
  `bookNumber` int(11) DEFAULT NULL COMMENT '书籍数量',
  `bookCategory` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '书籍类别',
  `bookDate` date DEFAULT NULL COMMENT '录入日期',
  `sta_id` int(11) DEFAULT NULL COMMENT '录入人id',
  `isdelete` int(1) DEFAULT '0' COMMENT '是否被删除(0:未删除，1:被删除)',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `book_ibfk_1` (`sta_id`) USING BTREE,
  CONSTRAINT `book_ibfk_1` FOREIGN KEY (`sta_id`) REFERENCES `staff` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1047 DEFAULT CHARSET=latin1 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES ('1001', 'RGZN', '人工智能', '12.01', '12', '计算机', '2019-08-22', '1', '1');
INSERT INTO `book` VALUES ('1002', 'JSJWL', '计算机网络', '42.00', '35', '计算机', '2019-08-22', '1', '1');
INSERT INTO `book` VALUES ('1003', 'ZNL', '正能量', '35.50', '20', '人文', '2019-08-22', '1', '1');
INSERT INTO `book` VALUES ('1004', 'ZRSYNL', '责任胜于能力', '25.00', '18', '人文', '2019-08-22', '1', '1');
INSERT INTO `book` VALUES ('1005', 'DZ', '读者', '10.00', '80', '杂志', '2019-08-22', '1', '0');
INSERT INTO `book` VALUES ('1006', 'GSH', '故事会', '5.00', '80', '杂志', '2019-08-22', '1', '0');
INSERT INTO `book` VALUES ('1007', 'MHLS', '猫和老鼠', '20.00', '50', '漫画', '2019-08-22', '1', '0');
INSERT INTO `book` VALUES ('1008', 'HZW', '海贼王', '15.00', '50', '漫画', '2019-08-22', '1', '0');
INSERT INTO `book` VALUES ('1009', 'ZBL', '资本论', '65.00', '100', '小说', '2019-08-22', '1', '0');
INSERT INTO `book` VALUES ('1011', 'QNWZ', '青年文摘', '10.00', '9', '杂志', '2019-08-22', '2', '0');
INSERT INTO `book` VALUES ('1012', 'ZGTS', '中国通史', '40.00', '18', '小说', '2019-08-22', '2', '0');
INSERT INTO `book` VALUES ('1013', 'DDJ', '道德经', '25.00', '30', '小说', '2019-08-22', '2', '0');
INSERT INTO `book` VALUES ('1014', 'XZHDX', '雪中悍刀行', '35.00', '25', '小说', '2019-08-22', '2', '0');
INSERT INTO `book` VALUES ('1015', 'BNGD', '百年孤独', '58.00', '40', '小说', '2019-08-22', '2', '0');
INSERT INTO `book` VALUES ('1016', 'PFDSJ', '平凡的世界', '65.00', '50', '小说', '2019-08-22', '2', '0');
INSERT INTO `book` VALUES ('1017', 'WDDH', '瓦尔登湖', '45.00', '40', '小说', '2019-08-22', '2', '0');
INSERT INTO `book` VALUES ('1018', 'DSJ', '大数据', '80.00', '25', '计算机', '2019-08-22', '2', '0');
INSERT INTO `book` VALUES ('1019', 'RXDRD', '人性的弱点', '43.00', '24', '小说', '2019-08-22', '2', '0');
INSERT INTO `book` VALUES ('1020', 'RHYDYBS', '如何阅读一本书', '58.00', '20', '杂志', '2019-08-22', '2', '0');
INSERT INTO `book` VALUES ('1021', 'BY', '北鸢', '35.00', '18', '小说', '2019-08-30', '11', '0');
INSERT INTO `book` VALUES ('1022', 'GYZM', '古乐之美', '28.00', '30', '小说', '2019-08-22', '3', '0');
INSERT INTO `book` VALUES ('1023', 'WCF', '望春风', '48.00', '20', '小说', '2019-08-22', '3', '0');
INSERT INTO `book` VALUES ('1024', 'SMXJ', '水墨戏剧', '65.00', '20', '小说', '2019-08-22', '3', '0');
INSERT INTO `book` VALUES ('1025', 'RGDXFM', '如果大雪封门', '28.00', '65', '小说', '2019-08-22', '3', '0');
INSERT INTO `book` VALUES ('1026', 'YW', '鱼王', '35.00', '28', '童话', '2019-08-22', '3', '0');
INSERT INTO `book` VALUES ('1027', 'SJDLD', '世界的凛冬', '28.00', '65', '小说', '2019-08-22', '3', '0');
INSERT INTO `book` VALUES ('1028', 'BLBT', '步履不停', '35.00', '45', '小说', '2019-08-22', '3', '0');
INSERT INTO `book` VALUES ('1029', 'SBQ', '散步去', '40.00', '30', '小说', '2019-08-22', '3', '0');
INSERT INTO `book` VALUES ('1030', 'FLLSDSN', '佛罗伦萨的神女1', '65.00', '40', '小说', '2019-08-22', '11', '0');

-- ----------------------------
-- Table structure for card
-- ----------------------------
DROP TABLE IF EXISTS `card`;
CREATE TABLE `card` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '会员卡id',
  `createDate` date DEFAULT NULL COMMENT '办卡日期',
  `expirationDate` date DEFAULT NULL,
  `discount` double(3,2) DEFAULT '1.00',
  `cus_id` int(11) DEFAULT NULL COMMENT '持卡人id',
  `sta_id` int(11) DEFAULT NULL COMMENT '创建者id',
  `isdelete` int(1) DEFAULT '0' COMMENT '是否被删除(0:未删除，1:被删除)',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `cus_id` (`cus_id`) USING BTREE,
  KEY `card_ibfk_2` (`sta_id`) USING BTREE,
  CONSTRAINT `card_ibfk_1` FOREIGN KEY (`cus_id`) REFERENCES `customer` (`id`),
  CONSTRAINT `card_ibfk_2` FOREIGN KEY (`sta_id`) REFERENCES `staff` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1332345699 DEFAULT CHARSET=latin1 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of card
-- ----------------------------
INSERT INTO `card` VALUES ('1012345678', '2019-08-22', '2019-09-22', '0.80', '101', '1', '1');
INSERT INTO `card` VALUES ('1022345678', '2019-08-22', '2019-09-22', '0.80', '102', '1', '1');
INSERT INTO `card` VALUES ('1032345678', '2019-08-22', '2019-09-22', '0.80', '103', '2', '1');
INSERT INTO `card` VALUES ('1042345678', '2019-08-22', '2019-09-22', '0.80', '104', '3', '1');
INSERT INTO `card` VALUES ('1052345678', '2019-08-22', '2019-09-22', '0.80', '105', '1', '1');
INSERT INTO `card` VALUES ('1062345678', '2019-08-22', '2019-09-22', '0.80', '106', '4', '0');
INSERT INTO `card` VALUES ('1072345678', '2019-08-22', '2019-09-22', '0.80', '107', '5', '0');
INSERT INTO `card` VALUES ('1082345678', '2019-08-22', '2019-09-22', '0.80', '107', '11', '0');
INSERT INTO `card` VALUES ('1332345683', '2019-08-01', '2019-08-30', '0.10', '104', '5', '0');
INSERT INTO `card` VALUES ('1332345687', '2019-08-25', '2019-11-25', '1.00', '107', '5', '1');
INSERT INTO `card` VALUES ('1332345691', '2019-08-25', '2019-08-25', '1.00', '107', '5', '1');
INSERT INTO `card` VALUES ('1332345693', '2019-08-22', '2019-08-22', '1.00', '101', '11', '1');
INSERT INTO `card` VALUES ('1332345694', '2019-08-22', '2019-08-22', '1.00', '101', '11', '1');
INSERT INTO `card` VALUES ('1332345695', '2019-08-22', '2019-08-22', '1.00', '101', '11', '0');
INSERT INTO `card` VALUES ('1332345697', '2019-08-22', '2019-08-22', '0.80', '107', '11', '0');
INSERT INTO `card` VALUES ('1332345698', '2019-08-22', '2019-08-22', '0.20', '101', '11', '0');

-- ----------------------------
-- Table structure for cash_record
-- ----------------------------
DROP TABLE IF EXISTS `cash_record`;
CREATE TABLE `cash_record` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '收银记录id',
  `cashDate` date DEFAULT NULL COMMENT '收银时间',
  `bookNumber` int(11) DEFAULT '1',
  `cashAmount` double(255,2) DEFAULT '0.00' COMMENT '收银金额',
  `cashProfit` double(255,2) DEFAULT '0.00' COMMENT '盈利金额',
  `boo_id` int(11) DEFAULT NULL COMMENT '书籍id',
  `car_id` int(11) DEFAULT NULL COMMENT '收银员id',
  `sta_id` int(11) DEFAULT NULL COMMENT '录入的员工id',
  `isdelete` int(1) DEFAULT '0' COMMENT '是否被删除(0:未删除，1:被删除)',
  PRIMARY KEY (`id`),
  KEY `cash_record_ibfk_1` (`boo_id`) USING BTREE,
  KEY `cash_record_ibfk_2` (`car_id`) USING BTREE,
  KEY `sta_id` (`sta_id`),
  CONSTRAINT `cash_record_ibfk_1` FOREIGN KEY (`boo_id`) REFERENCES `book` (`id`),
  CONSTRAINT `cash_record_ibfk_2` FOREIGN KEY (`car_id`) REFERENCES `card` (`id`),
  CONSTRAINT `cash_record_ibfk_3` FOREIGN KEY (`sta_id`) REFERENCES `staff` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=190822038 DEFAULT CHARSET=latin1 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of cash_record
-- ----------------------------
INSERT INTO `cash_record` VALUES ('190822004', '2019-08-22', '0', '40.00', '10.00', '1012', '1032345678', '1', '1');
INSERT INTO `cash_record` VALUES ('190822005', '2019-08-22', '0', '60.00', '30.00', '1026', '1082345678', '1', '1');
INSERT INTO `cash_record` VALUES ('190822006', '2019-08-25', '0', '70.00', '60.00', '1003', '1052345678', '1', '1');
INSERT INTO `cash_record` VALUES ('190822007', '2019-08-25', '0', '70.00', '60.00', '1006', '1332345691', '1', '1');
INSERT INTO `cash_record` VALUES ('190822009', '2019-08-25', '0', '70.00', '60.00', '1009', '1042345678', '1', '1');
INSERT INTO `cash_record` VALUES ('190822010', '2019-08-07', '0', '70.00', '60.00', '1003', '1012345678', '1', '1');
INSERT INTO `cash_record` VALUES ('190822011', '2019-08-25', '0', '70.00', '60.00', '1001', '1012345678', '1', '1');
INSERT INTO `cash_record` VALUES ('190822016', '2019-08-26', '0', '110.00', '215.00', '1002', '1042345678', '1', '0');
INSERT INTO `cash_record` VALUES ('190822017', '2019-08-27', '0', '840.00', '525.00', '1002', '1052345678', '1', '0');
INSERT INTO `cash_record` VALUES ('190822018', '2019-08-28', '0', '810.00', '525.00', '1003', '1052345678', '1', '0');
INSERT INTO `cash_record` VALUES ('190822019', '2019-08-29', '0', '810.00', '245.00', '1006', '1062345678', '1', '0');
INSERT INTO `cash_record` VALUES ('190822020', '2019-08-30', '0', '802.00', '215.00', '1006', '1062345678', '1', '0');
INSERT INTO `cash_record` VALUES ('190822021', '2019-08-31', '0', '231.00', '242.00', '1005', '1012345678', '1', '0');
INSERT INTO `cash_record` VALUES ('190822022', '2019-08-21', '0', '442.00', '214.00', '1005', '1012345678', '1', '0');
INSERT INTO `cash_record` VALUES ('190822023', '2019-08-23', '0', '521.00', '522.00', '1006', '1012345678', '1', '0');
INSERT INTO `cash_record` VALUES ('190822024', '2019-08-22', '0', '268.00', '241.00', '1007', '1012345678', '1', '0');
INSERT INTO `cash_record` VALUES ('190822025', '2019-08-23', '0', '584.00', '112.00', '1006', '1012345678', '1', '0');
INSERT INTO `cash_record` VALUES ('190822026', '2019-08-24', '0', '855.00', '522.00', '1001', '1012345678', '1', '0');
INSERT INTO `cash_record` VALUES ('190822037', '2019-08-31', '1', '110.00', '88.00', '1011', '1012345678', '11', '0');

-- ----------------------------
-- Table structure for customer
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '客户id',
  `customerCode` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '用户编码',
  `customerName` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '客户名字',
  `customerPhone` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '电话号码',
  `sta_id` int(11) DEFAULT NULL COMMENT '创建者id',
  `isdelete` int(1) DEFAULT '0' COMMENT '是否被删除(0:未删除，1:被删除)',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `sta_id` (`sta_id`) USING BTREE,
  CONSTRAINT `customer_ibfk_1` FOREIGN KEY (`sta_id`) REFERENCES `staff` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=116 DEFAULT CHARSET=latin1 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of customer
-- ----------------------------
INSERT INTO `customer` VALUES ('101', 'ZS', '三大', '123', '1', '1');
INSERT INTO `customer` VALUES ('102', 'DY', '第一', '10223456789', '1', '1');
INSERT INTO `customer` VALUES ('103', 'DS', '第三', '10323456789', '2', '1');
INSERT INTO `customer` VALUES ('104', 'DW', '第五', '10423456789', '3', '1');
INSERT INTO `customer` VALUES ('105', 'DL', '第六', '10523456789', '1', '1');
INSERT INTO `customer` VALUES ('106', 'DQ', '第七', '10623456789', '4', '0');
INSERT INTO `customer` VALUES ('107', 'DB', '第八', '10723456789', '5', '0');
INSERT INTO `customer` VALUES ('108', 'DJ', '第九', '10823456789', '2', '0');
INSERT INTO `customer` VALUES ('109', 'DS', '第十', '10923456789', '3', '0');
INSERT INTO `customer` VALUES ('110', 'XX', '笑笑11', '12415125121', '4', '0');
INSERT INTO `customer` VALUES ('112', 'CZ', '陈只1', '11215192519', '4', '1');
INSERT INTO `customer` VALUES ('113', 'QQ', 'QQ', '11111111111111', '11', '1');
INSERT INTO `customer` VALUES ('114', '1', '1213', '111', '11', '0');
INSERT INTO `customer` VALUES ('115', 'XX1', '谢谢1', '12415125121', '11', '0');

-- ----------------------------
-- Table structure for recycle
-- ----------------------------
DROP TABLE IF EXISTS `recycle`;
CREATE TABLE `recycle` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tableName` varchar(255) DEFAULT NULL,
  `recordId` varchar(255) DEFAULT NULL,
  `deleteTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=65 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of recycle
-- ----------------------------
INSERT INTO `recycle` VALUES ('41', 'cash_record', '190822004', '2019-08-31 14:14:07');
INSERT INTO `recycle` VALUES ('42', 'card', '1012345678', '2019-08-31 14:14:10');
INSERT INTO `recycle` VALUES ('43', 'customer', '101', '2019-08-31 14:14:17');
INSERT INTO `recycle` VALUES ('47', 'cash_record', '190822005', '2019-08-31 14:42:20');
INSERT INTO `recycle` VALUES ('48', 'cash_record', '190822006', '2019-08-31 14:42:20');
INSERT INTO `recycle` VALUES ('49', 'cash_record', '190822007', '2019-08-31 14:42:21');
INSERT INTO `recycle` VALUES ('50', 'card', '1022345678', '2019-08-31 14:42:24');
INSERT INTO `recycle` VALUES ('52', 'cash_record', '190822009', '2019-08-31 14:46:22');
INSERT INTO `recycle` VALUES ('53', 'cash_record', '190822010', '2019-08-31 14:46:24');
INSERT INTO `recycle` VALUES ('54', 'cash_record', '190822011', '2019-08-31 14:46:25');
INSERT INTO `recycle` VALUES ('55', 'card', '1042345678', '2019-08-31 14:46:29');
INSERT INTO `recycle` VALUES ('56', 'card', '1052345678', '2019-08-31 14:46:30');
INSERT INTO `recycle` VALUES ('57', 'customer', '102', '2019-08-31 14:46:34');
INSERT INTO `recycle` VALUES ('58', 'customer', '103', '2019-08-31 14:46:35');
INSERT INTO `recycle` VALUES ('59', 'customer', '104', '2019-08-31 14:46:36');
INSERT INTO `recycle` VALUES ('60', 'customer', '105', '2019-08-31 14:46:39');
INSERT INTO `recycle` VALUES ('61', 'book', '1001', '2019-08-31 14:46:48');
INSERT INTO `recycle` VALUES ('62', 'book', '1002', '2019-08-31 14:46:49');
INSERT INTO `recycle` VALUES ('63', 'book', '1003', '2019-08-31 14:46:50');
INSERT INTO `recycle` VALUES ('64', 'book', '1004', '2019-08-31 14:46:50');

-- ----------------------------
-- Table structure for staff
-- ----------------------------
DROP TABLE IF EXISTS `staff`;
CREATE TABLE `staff` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '员工id',
  `staffCode` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '员工编码',
  `staffName` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '员工姓名',
  `staffSex` char(1) CHARACTER SET utf8 DEFAULT '男',
  `staffAddress` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `staffUsername` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '员工账号',
  `staffPassword` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '员工密码',
  `staffPhone` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '电话号码',
  `staff_Permission` int(1) DEFAULT '1' COMMENT '登录权限',
  `start_Worktime` time DEFAULT NULL COMMENT '上班时间',
  `end_Worktime` time DEFAULT NULL COMMENT '下班时间',
  `isdelete` int(1) DEFAULT '0' COMMENT '是否被删除(0:未删除，1:被删除)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of staff
-- ----------------------------
INSERT INTO `staff` VALUES ('0', 'ADMIN', '系统管理员', '男', null, 'admin', '1', null, '1', '00:00:00', '23:59:59', '0');
INSERT INTO `staff` VALUES ('1', 'ZS', '张三', '男', '宿舍一号', '123456', '123456', '1112345678', '1', '09:00:00', '17:00:00', '0');
INSERT INTO `staff` VALUES ('2', 'LS', '李四', '男', '宿舍一号', '223456', '223456', '1212345678', '1', '09:00:00', '17:00:00', '0');
INSERT INTO `staff` VALUES ('3', 'WW', '王五', '男', '宿舍一号', '323456', '323456', '1312345678', '1', '09:00:00', '17:00:00', '0');
INSERT INTO `staff` VALUES ('4', 'ML', '马六', '男', '宿舍一号', '423456', '423456', '1412345678', '1', '09:00:00', '17:00:00', '0');
INSERT INTO `staff` VALUES ('5', 'MY', '刘英', '女', '宿舍二号', '523456', '523456', '1512345678', '1', '09:00:00', '17:00:00', '0');
INSERT INTO `staff` VALUES ('6', 'YQ', '永强', '男', '宿舍一号', '623456', '623456', '1612345678', '1', '09:00:00', '17:00:00', '0');
INSERT INTO `staff` VALUES ('7', 'DM', '大麦', '女', '宿舍二号', '723456', '723456', '1712345678', '1', '09:00:00', '17:00:00', '0');
INSERT INTO `staff` VALUES ('8', 'XH', '小红', '女', '宿舍二号', '823456', '823456', '1812345678', '1', '09:00:00', '17:00:00', '0');
INSERT INTO `staff` VALUES ('9', 'AF', '阿芬', '女', '宿舍二号', '923456', '923456', '1912345678', '1', '09:00:00', '17:00:00', '0');
INSERT INTO `staff` VALUES ('10', 'ZG', '赵构', '男', '宿舍一号', '3', '3', '2112345678', '1', '09:00:00', '17:00:00', '0');
INSERT INTO `staff` VALUES ('11', 'LH', '林湖', '男', '宿舍一号', '1', '1', '15669444468', '1', '00:00:00', '23:59:58', '0');
INSERT INTO `staff` VALUES ('12', 'BW', '白伟', '男', '宿舍一号', '2', '2', '15994466469', '1', '09:00:00', '18:00:00', '0');

-- ----------------------------
-- View structure for bookandstaff
-- ----------------------------
DROP VIEW IF EXISTS `bookandstaff`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `bookandstaff` AS select `book`.`id` AS `id`,`book`.`bookCode` AS `bookCode`,`book`.`bookName` AS `bookName`,`book`.`bookPrice` AS `bookPrice`,`book`.`bookNumber` AS `bookNumber`,`book`.`bookCategory` AS `bookCategory`,`book`.`bookDate` AS `bookDate`,`book`.`sta_id` AS `sta_id`,`staff`.`staffCode` AS `staffCode`,`staff`.`staffName` AS `staffName`,`staff`.`staffSex` AS `staffSex`,`staff`.`staffAddress` AS `staffAddress`,`staff`.`staffUsername` AS `staffUsername`,`staff`.`staffPassword` AS `staffPassword`,`staff`.`staffPhone` AS `staffPhone`,`staff`.`staff_Permission` AS `staff_Permission`,`staff`.`start_Worktime` AS `start_Worktime`,`staff`.`end_Worktime` AS `end_Worktime`,`staff`.`id` AS `sid`,`book`.`isdelete` AS `isdelete` from (`book` join `staff` on((`book`.`sta_id` = `staff`.`id`))) ;

-- ----------------------------
-- View structure for cardandcustomerandstaff
-- ----------------------------
DROP VIEW IF EXISTS `cardandcustomerandstaff`;
