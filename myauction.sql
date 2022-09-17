/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50733
 Source Host           : localhost:3306
 Source Schema         : myauction

 Target Server Type    : MySQL
 Target Server Version : 50733
 File Encoding         : 65001

 Date: 17/09/2022 23:05:59
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for auction
-- ----------------------------
DROP TABLE IF EXISTS `auction`;
CREATE TABLE `auction`  (
  `auctionId` int(11) NOT NULL AUTO_INCREMENT COMMENT '竞品id',
  `auctionName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '竞拍名称',
  `auctionStartPrice` decimal(9, 2) NOT NULL COMMENT '起拍价',
  `auctionUpset` decimal(9, 2) NOT NULL COMMENT '底价',
  `auctionStartTime` datetime NOT NULL COMMENT '竞拍开始时间',
  `auctionEndTime` datetime NOT NULL COMMENT '竞拍截止时间',
  `auctionPic` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '竞拍图片',
  `auctionPicType` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图片类型',
  `auctionDesc` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '竞品描述',
  PRIMARY KEY (`auctionId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 62 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of auction
-- ----------------------------
INSERT INTO `auction` VALUES (2, '旧电脑', 100.00, 100.00, '2017-04-20 00:00:00', '2035-03-01 00:00:00', 'book_10.gif', 'image/gif', '差价');
INSERT INTO `auction` VALUES (4, '旧电脑2', 100.00, 100.00, '2017-04-20 00:00:00', '2018-07-19 00:00:00', 'book_04.gif', 'image/gif', 'very good');
INSERT INTO `auction` VALUES (5, '旧桌子', 200.00, 200.00, '2017-04-20 00:00:00', '2017-04-30 00:00:00', 'images/33232242.jpg', 'jpg', 'very good');
INSERT INTO `auction` VALUES (7, '旧电脑5', 100.00, 100.00, '2017-04-20 00:00:00', '2017-04-30 00:00:00', 'book_01.gif', 'image/gif', 'very good');
INSERT INTO `auction` VALUES (8, '旧桌子2', 200.00, 200.00, '2017-04-20 00:00:00', '2017-04-30 00:00:00', 'book_10.gif', 'image/gif', 'very good');
INSERT INTO `auction` VALUES (9, '旧桌子3', 200.00, 200.00, '2017-04-20 00:00:00', '2017-04-30 00:00:00', 'book_09.gif', 'image/gif', 'very good');
INSERT INTO `auction` VALUES (11, '花瓶', 1000.00, 1000.00, '2017-04-23 00:00:00', '2041-01-03 00:00:00', 'book_09.gif', 'image/gif', '差评');
INSERT INTO `auction` VALUES (13, '旧碗', 56.00, 56.00, '2017-04-23 00:00:00', '2017-04-30 00:00:00', 'ad20.jpg', 'jpg', 'sss');
INSERT INTO `auction` VALUES (14, '显示器', 1222.00, 1222.00, '2017-04-24 00:00:00', '2018-04-28 00:00:00', 'book_06.gif', 'image/gif', 'dsds');
INSERT INTO `auction` VALUES (16, '旧拖鞋', 10.00, 10.00, '2017-06-14 00:00:00', '2017-06-30 00:00:00', 'book_08.gif', 'image/gif', '标杆');
INSERT INTO `auction` VALUES (19, '牛角杯888', 100.00, 100.00, '2017-07-15 00:00:00', '2017-07-29 00:00:00', 'book_06.gif', 'gif', 'very good');
INSERT INTO `auction` VALUES (20, 'AK74', 100.00, 100.00, '2017-07-22 00:00:00', '2025-03-01 00:00:00', 'book_01.gif', 'gif', '好');
INSERT INTO `auction` VALUES (21, '二手尿壶99', 100.00, 100.00, '2018-03-13 00:00:00', '2018-03-31 00:00:00', 'book_05.gif', 'image/gif', '好用!');
INSERT INTO `auction` VALUES (22, '二手宝马444', 10000.00, 10000.00, '2018-03-10 00:00:00', '2018-03-31 00:00:00', 'ad20.jpg', 'image/jpeg', 'ssss');
INSERT INTO `auction` VALUES (23, '二手尿壶82', 500.00, 100.00, '2018-03-08 00:00:00', '2018-03-31 00:00:00', 'book_05.gif', 'image/gif', 'sss');
INSERT INTO `auction` VALUES (25, '显示器007', 100.00, 100.00, '2018-04-08 00:00:00', '2018-04-30 00:00:00', 'ad20.jpg', 'image/jpeg', '非常好');
INSERT INTO `auction` VALUES (29, '杯子10000', 100.00, 100.00, '2018-05-08 00:00:00', '2018-05-29 00:00:00', '61Z58PICgN6.jpg', 'image/jpeg', '差评');
INSERT INTO `auction` VALUES (31, '二手尿壶777', 1000.00, 1000.00, '2018-06-10 00:00:00', '2018-06-30 00:00:00', '61Z58PICgN6.jpg', 'image/jpeg', '好用');
INSERT INTO `auction` VALUES (32, '二手古董尿壶008', 2000.00, 2000.00, '2018-06-22 00:00:00', '2018-06-30 00:00:00', '61Z58PICgN6.jpg', 'image/jpeg', '好用');
INSERT INTO `auction` VALUES (33, '二手古董尿壶11111', 90.00, 90.00, '2018-06-30 00:00:00', '2018-07-21 00:00:00', '61Z58PICgN6.jpg', 'image/jpeg', '好用');
INSERT INTO `auction` VALUES (34, '宝马0900', 2000.00, 2000.00, '2018-07-01 00:00:00', '2018-07-31 00:00:00', 'ad20.jpg', 'image/jpeg', 'ssss');
INSERT INTO `auction` VALUES (35, '二手古董尿壶0000', 2000.00, 2000.00, '2018-07-02 00:00:00', '2018-11-30 00:00:00', '61Z58PICgN6.jpg', 'image/jpeg', 'sss');
INSERT INTO `auction` VALUES (36, 'iphone8', 8000.00, 8000.00, '2018-07-05 10:33:13', '2018-11-30 00:00:00', 'xxx.jpg', 'jpg', '好用');
INSERT INTO `auction` VALUES (38, '二手古董尿壶007', 90.00, 90.00, '2018-07-08 00:00:00', '2018-12-01 00:00:00', '61Z58PICgN6.jpg', 'image/jpeg', '好用');
INSERT INTO `auction` VALUES (40, '旧中华字典008', 10.00, 10.00, '2018-12-04 00:00:00', '2019-02-01 00:00:00', '61Z58PICgN6.jpg', 'image/jpeg', 'very good');
INSERT INTO `auction` VALUES (42, '花瓶8888', 1000.00, 1000.00, '2019-01-18 00:00:00', '2019-01-31 00:00:00', 'ad20.jpg', 'image/jpeg', 'sssafds');
INSERT INTO `auction` VALUES (43, '三手电脑1', 1111.00, 1111.00, '2019-03-23 00:00:00', '2019-03-31 00:00:00', 'abc.jpg', 'image/jpeg', 'ddd');
INSERT INTO `auction` VALUES (44, '三手电脑2', 1111.00, 1111.00, '2019-03-09 00:00:00', '2040-03-31 00:00:00', 'abc.jpg', 'image/jpeg', '大哥大');
INSERT INTO `auction` VALUES (45, '三手电脑8888', 1111.00, 1111.00, '2019-03-29 00:00:00', '2019-03-31 00:00:00', 'abc.jpg', 'image/jpeg', 'dssafs');
INSERT INTO `auction` VALUES (46, 'AK74', 111.00, 111.00, '2019-03-31 16:00:00', '2019-04-29 16:00:00', 'timg.jpg', 'image/jpeg', 'aaaa');
INSERT INTO `auction` VALUES (47, '好吃', 24.00, 22.00, '2019-04-06 16:00:00', '2044-07-21 16:00:00', 'timg (2).jpg', 'image/jpeg', '222');
INSERT INTO `auction` VALUES (50, '四手电脑22', 111.00, 111.00, '2019-04-02 16:00:00', '2039-07-01 16:00:00', 'timg (2).jpg', 'image/jpeg', '111');
INSERT INTO `auction` VALUES (51, '三手电脑3', 1111.00, 1111.00, '2019-04-05 00:00:00', '2039-12-26 00:00:00', 'timg.jpg', 'image/jpeg', 'dfsa');
INSERT INTO `auction` VALUES (52, '三手电脑888', 1111.00, 1111.00, '2019-04-19 00:00:00', '2022-12-30 00:00:00', '58072422Ndd7e66c4.jpg', 'image/jpeg', 'good');
INSERT INTO `auction` VALUES (53, '旧olll', 111.00, 9090.00, '2019-01-03 00:00:00', '2019-01-28 14:50:56', 'timg (2).jpg', 'image/jpeg', 'klklk');
INSERT INTO `auction` VALUES (54, '蜜汁全鸡', 29.00, 20.00, '2022-09-08 18:49:53', '2022-09-17 16:00:00', '1656136487430.jpg', 'image/jpeg', '疯狂的鸡');
INSERT INTO `auction` VALUES (60, '冰美式', 9.90, 9.00, '2022-09-08 16:00:00', '2022-09-29 16:00:00', 'R-516611-1126524479.jpg', 'image/jpeg', 'good');
INSERT INTO `auction` VALUES (61, '疯狂星期四', 20.00, 20.00, '2022-09-08 16:00:00', '2035-09-29 16:00:00', 'R-516611-1126524479.jpg', 'image/jpeg', 'good');

-- ----------------------------
-- Table structure for auctionrecord
-- ----------------------------
DROP TABLE IF EXISTS `auctionrecord`;
CREATE TABLE `auctionrecord`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '流水号',
  `userId` int(11) NULL DEFAULT NULL COMMENT '竞拍用户id',
  `auctionId` int(11) NOT NULL COMMENT '竞拍竞品id',
  `auctionTime` datetime NOT NULL COMMENT '竞品时间',
  `auctionPrice` decimal(9, 2) NOT NULL COMMENT '竞拍价格',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK_rec_REF_user`(`userId`) USING BTREE,
  INDEX `FK_rec_REF_AUC`(`auctionId`) USING BTREE,
  CONSTRAINT `FK_rec_REF_AUC` FOREIGN KEY (`auctionId`) REFERENCES `auction` (`auctionId`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_rec_REF_user` FOREIGN KEY (`userId`) REFERENCES `user` (`userId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 58 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of auctionrecord
-- ----------------------------
INSERT INTO `auctionrecord` VALUES (5, NULL, 2, '2018-06-30 09:36:04', 127.00);
INSERT INTO `auctionrecord` VALUES (6, 5, 2, '2017-04-25 09:27:40', 123.00);
INSERT INTO `auctionrecord` VALUES (9, 5, 16, '2017-06-14 20:45:57', 19.00);
INSERT INTO `auctionrecord` VALUES (10, 5, 20, '2017-07-18 15:33:10', 110.00);
INSERT INTO `auctionrecord` VALUES (11, 5, 20, '2017-07-18 15:33:45', 120.00);
INSERT INTO `auctionrecord` VALUES (12, 9, 21, '2018-03-13 16:18:19', 110.00);
INSERT INTO `auctionrecord` VALUES (13, 5, 21, '2018-03-13 16:19:03', 120.00);
INSERT INTO `auctionrecord` VALUES (14, 10, 14, '2018-03-14 08:47:43', 1555.00);
INSERT INTO `auctionrecord` VALUES (16, 10, 21, '2018-03-14 08:48:20', 130.00);
INSERT INTO `auctionrecord` VALUES (17, 5, 21, '2018-03-24 09:36:27', 145.00);
INSERT INTO `auctionrecord` VALUES (24, 5, 29, '2018-05-10 14:29:42', 110.00);
INSERT INTO `auctionrecord` VALUES (25, 5, 29, '2018-05-10 14:30:05', 120.00);
INSERT INTO `auctionrecord` VALUES (28, 5, 31, '2018-06-14 14:52:51', 1100.00);
INSERT INTO `auctionrecord` VALUES (29, 5, 31, '2018-06-19 09:19:55', 1200.00);
INSERT INTO `auctionrecord` VALUES (30, 5, 31, '2018-06-21 09:30:30', 1300.00);
INSERT INTO `auctionrecord` VALUES (31, 5, 32, '2018-06-26 19:41:06', 2100.00);
INSERT INTO `auctionrecord` VALUES (32, 5, 34, '2018-07-01 09:16:56', 2400.00);
INSERT INTO `auctionrecord` VALUES (33, 5, 35, '2018-07-02 19:57:20', 2200.00);
INSERT INTO `auctionrecord` VALUES (34, 5, 33, '2018-07-07 10:37:17', 100.00);
INSERT INTO `auctionrecord` VALUES (35, 5, 33, '2018-07-07 10:37:36', 120.00);
INSERT INTO `auctionrecord` VALUES (38, 5, 38, '2018-10-21 10:13:30', 100.00);
INSERT INTO `auctionrecord` VALUES (45, 5, 40, '2018-12-05 09:35:27', 11.00);
INSERT INTO `auctionrecord` VALUES (46, 5, 40, '2018-12-05 09:35:51', 12.00);
INSERT INTO `auctionrecord` VALUES (47, 10, 43, '2019-03-26 16:52:24', 1200.00);
INSERT INTO `auctionrecord` VALUES (48, 10, 43, '2019-03-26 17:20:47', 1377.00);
INSERT INTO `auctionrecord` VALUES (49, 10, 45, '2019-03-28 16:32:35', 1211.00);
INSERT INTO `auctionrecord` VALUES (50, 10, 45, '2019-03-28 16:34:38', 1250.00);
INSERT INTO `auctionrecord` VALUES (51, 10, 46, '2019-04-02 06:31:09', 112.00);
INSERT INTO `auctionrecord` VALUES (52, 10, 50, '2019-04-02 08:37:59', 122.00);
INSERT INTO `auctionrecord` VALUES (53, 10, 47, '2019-04-13 14:33:16', 23.00);
INSERT INTO `auctionrecord` VALUES (54, 10, 52, '2019-04-20 15:00:19', 1200.00);
INSERT INTO `auctionrecord` VALUES (55, 10, 52, '2019-01-02 09:52:50', 1300.00);
INSERT INTO `auctionrecord` VALUES (56, 5, 52, '2022-09-08 17:13:13', 1400.00);
INSERT INTO `auctionrecord` VALUES (57, 5, 52, '2022-09-13 09:53:51', 1500.00);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `userId` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `userName` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户账号',
  `userPassword` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `userCardNo` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '卡号',
  `userTel` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电话',
  `userAddress` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '地址',
  `userPostNumber` varchar(6) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮编',
  `userIsadmin` int(11) NULL DEFAULT 0 COMMENT '管理员标识',
  `userQuestion` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密保问题',
  `userAnswer` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密保答案',
  PRIMARY KEY (`userId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 28 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '旺财', '8888', NULL, NULL, NULL, NULL, 0, NULL, NULL);
INSERT INTO `user` VALUES (5, 'test1', '999', '123456789012345678', '8787878', '广东省广州', '600600', 0, '', '');
INSERT INTO `user` VALUES (7, '张三', '0000', NULL, NULL, NULL, NULL, 1, NULL, NULL);
INSERT INTO `user` VALUES (8, '李四', '10000', '123456789012345678', NULL, NULL, '511500', 0, NULL, NULL);
INSERT INTO `user` VALUES (9, 'Jack', '99999', '12345646456464', '99999999', 'gangdong', '599599', 0, '', '');
INSERT INTO `user` VALUES (10, 'kk', '11', '123456789012345', '12234', 'sadfsaf', '23443', 0, '', '');
INSERT INTO `user` VALUES (17, 'kate', '123', '123456789012345678', '2222', 'asdad', '324234', 0, NULL, NULL);
INSERT INTO `user` VALUES (19, 'Mike', '123456', '123456789012345678', '110', 'sss', '511500', 1, NULL, NULL);
INSERT INTO `user` VALUES (22, 'alibaba', '123456', '1234567894152653', '021-4589562', '现代', '510000', 0, NULL, NULL);
INSERT INTO `user` VALUES (23, 'admin', '123456', '4525485965245152', '18819054302', '广州', '510000', 1, NULL, NULL);
INSERT INTO `user` VALUES (24, 'lisi', '123456', '4525485965245152', '18819054302', '上海', '510000', 0, NULL, NULL);
INSERT INTO `user` VALUES (25, 'zs', '123123123', '12321312312312', '12312335325', '广州', '123456', 0, NULL, NULL);
INSERT INTO `user` VALUES (27, 'kfc', '123456', '1234623', '10086', '广州', '123456', 0, NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;
