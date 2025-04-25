/*
 Navicat Premium Dump SQL

 Source Server         : db_artical
 Source Server Type    : MySQL
 Source Server Version : 90001 (9.0.1)
 Source Host           : localhost:3306
 Source Schema         : weather

 Target Server Type    : MySQL
 Target Server Version : 90001 (9.0.1)
 File Encoding         : 65001

 Date: 25/04/2025 10:50:24
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for city_weather_info
-- ----------------------------
DROP TABLE IF EXISTS `city_weather_info`;
CREATE TABLE `city_weather_info`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `category_id` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `name` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '城市名称',
  `status` int NULL DEFAULT NULL,
  `code` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `type` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `extend` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `sort` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `image` varchar(2555) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '图片',
  `category_ids` json NULL,
  `deleted_status` tinyint NULL DEFAULT 0,
  `fxLink` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '当前数据的响应式页面，便于嵌入网站或应用',
  `obsTime` datetime NULL DEFAULT NULL COMMENT '数据观测时间',
  `temp` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '温度，默认单位：摄氏度',
  `feelsLike` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '体感温度，默认单位：摄氏度',
  `icon` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '天气状况的图标代码，另请参考天气图标项目',
  `text` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '天气状况的文字描述，包括阴晴雨雪等天气状态的描述',
  `wind360` varchar(255) CHARACTER SET utf8mb4  NOT NULL COMMENT '风向360角度',
  `windDir` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '风向',
  `windScale` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '风力',
  `windSpeed` double NULL DEFAULT NULL COMMENT '风速 公里/小时',
  `humidity` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '相对湿度',
  `precip` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '过去1小时降水量，默认单位：毫米',
  `pressure` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '大气压强，默认单位：百帕',
  `vis` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '能见度，默认单位：公里',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `category_id`(`category_id` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1899455940723200002 CHARACTER SET = utf8mb4  ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of city_weather_info
-- ----------------------------

-- ----------------------------
-- Table structure for cms_article_category
-- ----------------------------
DROP TABLE IF EXISTS `cms_article_category`;
CREATE TABLE `cms_article_category`  (
  `id` bigint NOT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `description` varchar(1025) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  `code` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `status` int NULL DEFAULT NULL,
  `parent_id` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `parent_ids` json NULL,
  `extend` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `type` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `sort` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `image` varchar(1025) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `deleted_status` tinyint NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4  ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of cms_article_category
-- ----------------------------
INSERT INTO `cms_article_category` VALUES (0, '全部', NULL, NULL, NULL, NULL, 0, '-1', '[\"-1\"]', NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `cms_article_category` VALUES (1, '数学集合', NULL, NULL, NULL, NULL, 0, '0', '[\"0\"]', NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `cms_article_category` VALUES (2, '语文', NULL, NULL, NULL, NULL, 0, '1', '[\"0\", \"1\"]', NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `cms_article_category` VALUES (3, '物理', NULL, NULL, NULL, NULL, 0, '2', '[\"0\", \"1\", \"2\"]', NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `cms_article_category` VALUES (4, '小说', NULL, NULL, NULL, NULL, 0, '1', '[\"0\", \"1\"]', NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `cms_article_category` VALUES (1898275423952822273, '撒旦', NULL, NULL, NULL, NULL, 0, '1', '[\"0\", \"1\"]', NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `cms_article_category` VALUES (1898275477325340673, '大说', NULL, NULL, NULL, NULL, 0, '0', '[\"0\"]', NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `cms_article_category` VALUES (1898275708108529666, '22', NULL, NULL, NULL, NULL, 0, '0', '[\"0\"]', NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `cms_article_category` VALUES (1898275812668334081, '热违法', NULL, NULL, NULL, NULL, 0, '1898275477325340673', '[\"0\", \"1898275477325340673\"]', NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `cms_article_category` VALUES (1898288617450627074, '删除', NULL, NULL, NULL, NULL, 0, '0', '[\"0\"]', NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `cms_article_category` VALUES (1901818754368405505, '', NULL, NULL, NULL, NULL, 0, '1898339691481939969', '[\"0\", \"1898339631364980738\", \"1898339691481939969\"]', NULL, NULL, NULL, NULL, NULL, 0);

-- ----------------------------
-- Table structure for cms_article_info
-- ----------------------------
DROP TABLE IF EXISTS `cms_article_info`;
CREATE TABLE `cms_article_info`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `title` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `content` varchar(1025) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `category_id` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `author` varchar(100) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `name` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `status` int NULL DEFAULT NULL,
  `code` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `extend` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `type` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `sort` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `image` varchar(1025) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `deleted_status` tinyint NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `category_id`(`category_id` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1901921331705802754 CHARACTER SET = utf8mb4  ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of cms_article_info
-- ----------------------------
INSERT INTO `cms_article_info` VALUES (1897977408964722690, '123', '456', '1', '789', NULL, '2025-03-07 19:47:31', '2025-03-10 07:32:22', 'wer', 0, '0', NULL, NULL, '6', NULL, NULL, 0);
INSERT INTO `cms_article_info` VALUES (1897979467944398850, '123', '123', '1', '456', '', '2025-03-07 19:55:42', '2025-03-10 15:28:46', 'sd', 0, '0', NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `cms_article_info` VALUES (1898277683193700353, '二位夫人为放', '但是撒旦f', '3', 'fz\'xzx', '', '2025-03-08 15:40:42', '2025-03-10 15:28:47', 'sd', 0, '0', NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `cms_article_info` VALUES (1898277763623673857, '而无法s\'d', '但是', '2', 'vdf', '', '2025-03-08 15:41:01', '2025-03-10 15:28:49', 'xc', 0, '0', NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `cms_article_info` VALUES (1901819215288860674, 'dsgv', 'fresd', '2', 'dfg', '', '2025-03-18 10:13:29', '2025-03-18 10:13:29', '', 0, '0', '', '', '', NULL, NULL, 0);
INSERT INTO `cms_article_info` VALUES (1901874720065679362, '辐射热', '哈哈', '3', 'dfg', '', '2025-03-18 13:54:03', '2025-03-18 13:54:03', '', 0, '0', '', '', '', NULL, NULL, 0);
INSERT INTO `cms_article_info` VALUES (1901921331705802753, '第三次', '的v', '3', '而无法', '', '2025-03-18 16:59:16', '2025-03-18 16:59:28', '', 0, '0', '', '', '', NULL, NULL, 0);

-- ----------------------------
-- Table structure for cms_article_tag_category
-- ----------------------------
DROP TABLE IF EXISTS `cms_article_tag_category`;
CREATE TABLE `cms_article_tag_category`  (
  `id` bigint NOT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `description` varchar(1025) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  `code` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `status` int NULL DEFAULT NULL,
  `parent_id` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `parent_ids` json NULL,
  `extend` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `type` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `sort` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `image` varchar(1025) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `deleted_status` tinyint NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4  ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of cms_article_tag_category
-- ----------------------------
INSERT INTO `cms_article_tag_category` VALUES (0, '全部', NULL, NULL, NULL, NULL, NULL, '-1', '[\"-1\"]', NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `cms_article_tag_category` VALUES (1898621501231218690, '配置1', NULL, NULL, NULL, NULL, 0, '0', '[\"0\"]', NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `cms_article_tag_category` VALUES (1898632030293303297, '配置1-1', NULL, NULL, NULL, NULL, 0, '1898621501231218690', '[\"0\", \"1898621501231218690\"]', NULL, NULL, NULL, NULL, NULL, 0);

-- ----------------------------
-- Table structure for cms_article_tag_info
-- ----------------------------
DROP TABLE IF EXISTS `cms_article_tag_info`;
CREATE TABLE `cms_article_tag_info`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `category_id` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `name` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `status` int NULL DEFAULT NULL,
  `code` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `type` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `extend` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `sort` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `image` varchar(2555) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `deleted_status` tinyint NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `category_id`(`category_id` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1898636467665608707 CHARACTER SET = utf8mb4  ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of cms_article_tag_info
-- ----------------------------
INSERT INTO `cms_article_tag_info` VALUES (1898631883257782273, '1898621501231218690', 'ewfs\'e\'f\'z\'x', '2025-03-09 15:08:10', '2025-03-09 15:08:10', 'e\'w\'f', 0, '0', '1', '11', '11', NULL, NULL, 0);
INSERT INTO `cms_article_tag_info` VALUES (1898635221105876994, '1898632030293303297', '很好的', '2025-03-09 15:21:26', '2025-03-09 07:21:43', 'haiad', 0, '0', '下拉框', '从', '4', NULL, NULL, 0);
INSERT INTO `cms_article_tag_info` VALUES (1898636191940452354, '0', 'sd', '2025-03-09 15:25:17', '2025-03-09 15:25:17', '而无法s\'d', 0, '0', 'c\'x', '的色佛', '5', NULL, NULL, 0);
INSERT INTO `cms_article_tag_info` VALUES (1898636467665608706, '1898621501231218690', '饿温', '2025-03-09 15:26:23', '2025-03-09 15:26:23', '而无法饿温', 0, '0', 'ew', '而无法', '1', NULL, NULL, 0);

-- ----------------------------
-- Table structure for crm_user_address_info
-- ----------------------------
DROP TABLE IF EXISTS `crm_user_address_info`;
CREATE TABLE `crm_user_address_info`  (
  `id` bigint NOT NULL COMMENT '主键 ID',
  `flag` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '标识',
  `code` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '编码',
  `status` int NULL DEFAULT 0 COMMENT '状态值: 0: 正常; 1: 默认;',
  `sort` bigint NULL DEFAULT 0 COMMENT '排序值',
  `remark` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '备注',
  `extend` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '扩展',
  `created_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `updated_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `user_id` bigint NULL DEFAULT NULL COMMENT '用户ID',
  `name` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '姓名',
  `phone` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '手机号',
  `province_name` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '省-名称',
  `province_code` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '省-编码',
  `city_name` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '市-名称',
  `city_code` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '市-编码',
  `district_name` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '区/镇-名称',
  `district_code` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '区/镇-编码',
  `address_detail` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '详细地址',
  `deleted_status` tinyint NULL DEFAULT 0,
  `category_id` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `category_ids` json NULL,
  `description` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `type` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `image` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4  COMMENT = '系统-配置-信息' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of crm_user_address_info
-- ----------------------------
INSERT INTO `crm_user_address_info` VALUES (1, NULL, NULL, 0, 0, NULL, NULL, NULL, NULL, 1900170964877955074, 'admin', '13213', '111', NULL, '111', NULL, '111', NULL, '111', 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `crm_user_address_info` VALUES (2, '', NULL, 0, 0, NULL, NULL, NULL, NULL, 1898724739184001026, 'aaa', '123243546546', '河北省', NULL, '张家口', NULL, '北云门', NULL, 'BBB小区', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `crm_user_address_info` VALUES (3, NULL, NULL, 0, 0, NULL, NULL, NULL, NULL, 1900170964877955074, 'bbb', '132224557657', '深圳省', NULL, '小渔村', NULL, '北环三区', NULL, '###小区', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `crm_user_address_info` VALUES (4, NULL, NULL, 0, 0, NULL, NULL, NULL, NULL, 1900170964877955074, 'bbb', '132224557657', '深圳省', NULL, '小渔村', NULL, '南环三区', NULL, '@@@小区', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for crm_user_category
-- ----------------------------
DROP TABLE IF EXISTS `crm_user_category`;
CREATE TABLE `crm_user_category`  (
  `id` bigint NOT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `description` varchar(1025) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  `code` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `status` int NULL DEFAULT NULL,
  `parent_id` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `parent_ids` json NULL,
  `extend` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `type` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `sort` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `image` varchar(2555) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `deleted_status` tinyint NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4  ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of crm_user_category
-- ----------------------------
INSERT INTO `crm_user_category` VALUES (0, '全部', NULL, NULL, NULL, NULL, NULL, '-1', '[\"-1\"]', NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `crm_user_category` VALUES (1898711866655313921, '微信公众号', NULL, NULL, NULL, NULL, 0, '0', '[\"0\"]', NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `crm_user_category` VALUES (1898711903900733442, '微信小程序', NULL, NULL, NULL, NULL, 0, '0', '[\"0\"]', NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `crm_user_category` VALUES (1898711935676780546, 'H5', NULL, NULL, NULL, NULL, 0, '0', '[\"0\"]', NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `crm_user_category` VALUES (1898711956719603713, 'PC', NULL, NULL, NULL, NULL, 0, '0', '[\"0\"]', NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `crm_user_category` VALUES (1898712000961122306, 'APP', NULL, NULL, NULL, NULL, 0, '0', '[\"0\"]', NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `crm_user_category` VALUES (1898712033349537793, '外部导入', NULL, NULL, NULL, NULL, 0, '0', '[\"0\"]', NULL, NULL, NULL, NULL, NULL, 0);

-- ----------------------------
-- Table structure for crm_user_city
-- ----------------------------
DROP TABLE IF EXISTS `crm_user_city`;
CREATE TABLE `crm_user_city`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `category_id` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `name` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '城市名称',
  `status` int NULL DEFAULT NULL,
  `code` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `type` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `extend` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `sort` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `image` varchar(2555) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '图片',
  `category_ids` json NULL,
  `deleted_status` tinyint NULL DEFAULT 0,
  `warn` json NULL COMMENT '警报',
  `city_id` bigint NULL DEFAULT NULL COMMENT '城市id',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `category_id`(`category_id` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1899455940723200002 CHARACTER SET = utf8mb4  ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of crm_user_city
-- ----------------------------

-- ----------------------------
-- Table structure for crm_user_city_care
-- ----------------------------
DROP TABLE IF EXISTS `crm_user_city_care`;
CREATE TABLE `crm_user_city_care`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `category_id` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `name` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '城市名称',
  `status` int NULL DEFAULT NULL,
  `code` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `type` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `extend` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `sort` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `image` varchar(2555) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '图片',
  `category_ids` json NULL,
  `deleted_status` tinyint NULL DEFAULT 0,
  `city_id` bigint NULL DEFAULT NULL COMMENT '城市id',
  `user_id` bigint NULL DEFAULT NULL COMMENT '用户id',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `category_id`(`category_id` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1899455940723200002 CHARACTER SET = utf8mb4  ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of crm_user_city_care
-- ----------------------------

-- ----------------------------
-- Table structure for crm_user_info
-- ----------------------------
DROP TABLE IF EXISTS `crm_user_info`;
CREATE TABLE `crm_user_info`  (
  `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT,
  `category_id` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `name` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `status` int NULL DEFAULT NULL,
  `code` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `type` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `extend` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `sort` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `username` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `image` varchar(2555) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `user_grade` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `is_group` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `is_vip` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `balance` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `recommender` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `id_number` varbinary(255) NULL DEFAULT NULL,
  `sex` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `birthday` datetime NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `roles` json NULL,
  `deleted_status` tinyint NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `category_id`(`category_id` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1904826326545473538 CHARACTER SET = utf8mb4  ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of crm_user_info
-- ----------------------------
INSERT INTO `crm_user_info` VALUES (1, '1898711866655313921', NULL, '2025-03-29 14:57:35', '2025-04-25 10:22:07', '管理员', 0, NULL, NULL, NULL, NULL, NULL, 'admin', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '阿达额分', 'e10adc3949ba59abbe56e057f20f883e', '[\"1905254920082030594\", \"1905255465828089858\"]', 0);
INSERT INTO `crm_user_info` VALUES (1898724739184001026, '1898711866655313921', '', '2025-03-09 21:17:09', '2025-03-31 13:57:19', 'aaa', 0, '2', NULL, NULL, '', '从第三方', 'aaa', NULL, '12234324', '', NULL, NULL, NULL, NULL, 0x33323433353334353134333135, NULL, '2025-02-23 08:00:00', '阿达额分', 'e10adc3949ba59abbe56e057f20f883e', '[\"1905255465828089858\"]', 0);
INSERT INTO `crm_user_info` VALUES (1900170964877955074, '1898711866655313921', '', '2025-03-13 21:03:56', '2025-03-31 13:57:19', 'bbb', 0, '0', NULL, NULL, '', '范德萨', 'bbb', NULL, '的发表', '', NULL, NULL, NULL, NULL, 0x3233323534333534373533, NULL, '2025-03-01 08:00:00', '阿达额分', 'e10adc3949ba59abbe56e057f20f883e', NULL, 0);
INSERT INTO `crm_user_info` VALUES (1904826326545473537, '1898711903900733442', '', '2025-03-26 17:22:40', '2025-04-25 09:59:30', 'ccc', 1, '22', NULL, NULL, '', '速度非常', 'ccc', NULL, '124435543', '', NULL, NULL, NULL, NULL, 0x3132343434343635, NULL, '2025-03-08 08:00:00', '阿达额分', 'e10adc3949ba59abbe56e057f20f883e', '[]', 0);

-- ----------------------------
-- Table structure for crm_user_tag_category
-- ----------------------------
DROP TABLE IF EXISTS `crm_user_tag_category`;
CREATE TABLE `crm_user_tag_category`  (
  `id` bigint NOT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `description` varchar(1025) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  `code` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `status` int NULL DEFAULT NULL,
  `parent_id` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `parent_ids` json NULL,
  `extend` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `type` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `sort` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `image` varchar(2555) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `deleted_status` tinyint NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4  ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of crm_user_tag_category
-- ----------------------------
INSERT INTO `crm_user_tag_category` VALUES (0, '全部', NULL, NULL, NULL, NULL, NULL, '-1', '[\"-1\"]', NULL, NULL, '0', NULL, NULL, 0);
INSERT INTO `crm_user_tag_category` VALUES (1898621501231218690, '配置1', NULL, NULL, NULL, NULL, 0, '0', '[\"0\"]', NULL, NULL, '0', NULL, NULL, 0);
INSERT INTO `crm_user_tag_category` VALUES (1901874043037904897, '配置1-1', NULL, NULL, NULL, NULL, 0, '1898621501231218690', '[\"0\", \"1898621501231218690\"]', NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `crm_user_tag_category` VALUES (1901874176785870850, '配置1-2', NULL, NULL, NULL, NULL, 0, '1898621501231218690', '[\"0\", \"1898621501231218690\"]', NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `crm_user_tag_category` VALUES (1901874295375622146, '配置2', NULL, NULL, NULL, NULL, 0, '0', '[\"0\"]', NULL, NULL, NULL, NULL, NULL, 0);

-- ----------------------------
-- Table structure for crm_user_tag_info
-- ----------------------------
DROP TABLE IF EXISTS `crm_user_tag_info`;
CREATE TABLE `crm_user_tag_info`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `category_id` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `name` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `status` int NULL DEFAULT NULL,
  `code` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `type` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `extend` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `sort` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `image` varchar(2555) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `deleted_status` tinyint NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `category_id`(`category_id` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1901874350140649475 CHARACTER SET = utf8mb4  ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of crm_user_tag_info
-- ----------------------------
INSERT INTO `crm_user_tag_info` VALUES (1901874077754159106, '1901874043037904897', '', '2025-03-18 13:51:29', '2025-03-18 13:51:29', '开心', 0, '0', NULL, NULL, '', NULL, NULL, 0);
INSERT INTO `crm_user_tag_info` VALUES (1901874131055374337, '1901874043037904897', '', '2025-03-18 13:51:42', '2025-03-18 13:51:42', '喜喜', 0, '0', NULL, NULL, '', NULL, NULL, 0);

-- ----------------------------
-- Table structure for demo
-- ----------------------------
DROP TABLE IF EXISTS `demo`;
CREATE TABLE `demo`  (
  `id` bigint NOT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `status` int NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  `code` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `parent_id` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `extend` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `type` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `sort` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `image` varchar(2555) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `deleted_status` tinyint NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4  ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of demo
-- ----------------------------

-- ----------------------------
-- Table structure for info_admin_info
-- ----------------------------
DROP TABLE IF EXISTS `info_admin_info`;
CREATE TABLE `info_admin_info`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `category_id` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `name` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `status` int NULL DEFAULT NULL,
  `code` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `type` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `extend` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `sort` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `image` varchar(2555) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '手机号',
  `password` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '密码',
  `position` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '岗位',
  `role` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '角色',
  `username` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '登录名',
  `deleted_status` tinyint NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `category_id`(`category_id` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1904506038205210626 CHARACTER SET = utf8mb4  ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of info_admin_info
-- ----------------------------
INSERT INTO `info_admin_info` VALUES (1898635221105876994, '1898632030293303297', '很好的', '2025-03-09 15:21:26', '2025-03-14 11:31:32', 'haiad', 1, '1', '下拉框', '从', '4', NULL, NULL, '1234324535', 'e10adc3949ba59abbe56e057f20f883e', '英语老师', '班主任', '二二', 0);
INSERT INTO `info_admin_info` VALUES (1898636191940452354, '0', 'sd', '2025-03-09 15:25:17', '2025-03-29 18:46:43', '而无法s\'d', 1, '0', 'c\'x', '的色佛', '5', NULL, NULL, '1234324535', 'b951e54693a591c8d1f1ca200fee3dd3', '英语老师', '语文老师', '石头人官方', 0);
INSERT INTO `info_admin_info` VALUES (1898636467665608706, '1898621501231218690', '饿温', '2025-03-09 15:26:23', '2025-03-14 11:31:32', '而无法饿温', 1, '0', 'ew', '而无法', '1', NULL, NULL, '1234324535', 'e10adc3949ba59abbe56e057f20f883e', '语文老师', '数学老师', '推荐人人', 0);
INSERT INTO `info_admin_info` VALUES (1899450516468883458, '1898621501231218690', 'dvd', '2025-03-11 21:21:07', '2025-03-25 20:13:53', '输入的各地d', 1, '0', '地方vd\'f\'g\'v', 'xc书的v', '0', NULL, NULL, '1234324535', 'e10adc3949ba59abbe56e057f20f883e', '班主任', '英语老师', '沟通和风格', 0);
INSERT INTO `info_admin_info` VALUES (1900388714095259649, '1898621501231218690', '', '2025-03-14 11:29:11', '2025-03-29 18:46:44', '111', 1, '0', '', '', '', NULL, NULL, '111', 'e10adc3949ba59abbe56e057f20f883e', '岗位2', '数学老师', '111', 0);

-- ----------------------------
-- Table structure for info_org_info
-- ----------------------------
DROP TABLE IF EXISTS `info_org_info`;
CREATE TABLE `info_org_info`  (
  `id` bigint NOT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `description` varchar(1025) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  `code` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `status` int NULL DEFAULT NULL,
  `parent_id` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `parent_ids` json NULL,
  `extend` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `type` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `sort` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `image` varchar(2555) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `deleted_status` tinyint NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4  ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of info_org_info
-- ----------------------------
INSERT INTO `info_org_info` VALUES (0, '全部', NULL, NULL, NULL, NULL, NULL, '-1', '[\"-1\"]', NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `info_org_info` VALUES (1898621501231218690, '配置1', NULL, NULL, NULL, NULL, 0, '0', '[\"0\"]', NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `info_org_info` VALUES (1898632030293303297, '配置1-1', NULL, NULL, NULL, NULL, 0, '1898621501231218690', '[\"0\", \"1898621501231218690\"]', NULL, NULL, NULL, NULL, NULL, 0);

-- ----------------------------
-- Table structure for product_brand
-- ----------------------------
DROP TABLE IF EXISTS `product_brand`;
CREATE TABLE `product_brand`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `category_id` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `name` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `status` int NULL DEFAULT NULL,
  `code` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `type` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `extend` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `sort` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `image` varchar(2555) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '图片',
  `category_ids` json NULL,
  `use_num` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `deleted_status` tinyint NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `category_id`(`category_id` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1904779143620284419 CHARACTER SET = utf8mb4  ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of product_brand
-- ----------------------------
INSERT INTO `product_brand` VALUES (1, '0', 'ewfs\'e\'f\'z\'x', '2025-03-09 15:08:10', '2025-03-11 15:49:34', 'e\'w\'f', 1, '0', '自定义', '11', '11', NULL, NULL, '[\"0\"]', '1', 0);
INSERT INTO `product_brand` VALUES (2, '1', '很好的', '2025-03-09 15:21:26', '2025-03-11 15:52:06', 'haiad', 1, '0', '自定义', '从', '4', NULL, NULL, '[\"1\"]', '2', 0);
INSERT INTO `product_brand` VALUES (3, '1', 'sd', '2025-03-09 15:25:17', '2025-03-11 15:32:47', '而无法s\'d', 1, '0', 'c\'x', '的色佛', '5', NULL, NULL, '[\"1\"]', '3', 0);
INSERT INTO `product_brand` VALUES (33, '0', 'ter', '2025-03-11 15:58:21', '2025-03-26 14:15:03', '哈哈', 0, NULL, NULL, NULL, NULL, NULL, NULL, '[\"0\"]', '44', 0);
INSERT INTO `product_brand` VALUES (1899368392969670658, '1', '', '2025-03-11 15:54:48', '2025-03-11 15:55:30', 'asd', 1, '0', '', NULL, '0', NULL, NULL, '[\"1\"]', NULL, 0);
INSERT INTO `product_brand` VALUES (1899368471688368129, '1899368392969670658', '', '2025-03-11 15:55:06', '2025-03-26 14:11:28', 'sdf', 0, '0', '', NULL, '', NULL, NULL, '[\"1\", \"1899368392969670658\"]', NULL, 0);
INSERT INTO `product_brand` VALUES (1899368555754803201, '1899368392969670658', '', '2025-03-11 15:55:26', '2025-03-11 15:55:32', 'sdfawes', 1, '0', '', NULL, '2', NULL, NULL, '[\"1\", \"1899368392969670658\"]', NULL, 0);
INSERT INTO `product_brand` VALUES (1904779143620284418, '-1', NULL, '2025-03-11 15:50:44', '2025-03-11 16:09:23', '全部', 1, NULL, NULL, NULL, NULL, NULL, NULL, '[\"-1\"]', '1', 0);

-- ----------------------------
-- Table structure for product_category
-- ----------------------------
DROP TABLE IF EXISTS `product_category`;
CREATE TABLE `product_category`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `category_id` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `name` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `status` int NULL DEFAULT NULL,
  `code` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `type` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `extend` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `sort` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `image` varchar(2555) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '图片',
  `category_ids` json NULL,
  `use_num` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `deleted_status` tinyint NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `category_id`(`category_id` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1899368555754803204 CHARACTER SET = utf8mb4  ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of product_category
-- ----------------------------
INSERT INTO `product_category` VALUES (1, '0', 'ewfs\'e\'f\'z\'x', '2025-03-09 15:08:10', '2025-03-26 16:09:41', 'e\'w\'f', 1, '0', '自定义', '11', '11', NULL, 'http://47.242.21.112:9000/develop/2025/03/26/16/20250326160925375_164176.png', '[\"0\"]', '1', 0);
INSERT INTO `product_category` VALUES (2, '1', '很好的', '2025-03-09 15:21:26', '2025-03-26 16:10:21', 'haiad', 1, '0', '自定义', '从', '4', NULL, 'http://47.242.21.112:9000/develop/2025/03/26/16/20250326160947834_860435.png', '[\"1\"]', '2', 0);
INSERT INTO `product_category` VALUES (3, '1', 'sd', '2025-03-09 15:25:17', '2025-03-26 16:10:32', '而无法s\'d', 1, '0', 'c\'x', '的色佛', '5', NULL, 'http://47.242.21.112:9000/develop/2025/03/26/16/20250326161027152_793211.png', '[\"1\"]', '3', 0);
INSERT INTO `product_category` VALUES (33, '0', 'ter', '2025-03-11 15:58:21', '2025-03-26 16:11:53', '哈哈', 0, NULL, NULL, NULL, '2', NULL, 'http://47.242.21.112:9000/develop/2025/03/26/16/20250326160903374_752356.png', '[\"0\"]', '44', 0);
INSERT INTO `product_category` VALUES (1899368392969670658, '1', '', '2025-03-11 15:54:48', '2025-03-26 16:11:24', 'asd', 1, '0', '', NULL, '0', NULL, 'http://47.242.21.112:9000/develop/2025/03/26/16/20250326161114369_428794.png', '[\"1\"]', NULL, 0);
INSERT INTO `product_category` VALUES (1899368471688368129, '1899368392969670658', '', '2025-03-11 15:55:06', '2025-03-26 16:11:36', 'sdf', 0, '0', '', NULL, '', NULL, 'http://47.242.21.112:9000/develop/2025/03/26/16/20250326161131438_498671.png', '[\"1\", \"1899368392969670658\"]', NULL, 0);
INSERT INTO `product_category` VALUES (1899368555754803201, '1899368392969670658', '', '2025-03-11 15:55:26', '2025-03-26 16:11:46', 'sdfawes', 1, '0', '', NULL, '2', NULL, 'http://47.242.21.112:9000/develop/2025/03/26/16/20250326161143498_737442.png', '[\"1\", \"1899368392969670658\"]', NULL, 0);
INSERT INTO `product_category` VALUES (1899368555754803203, '-1', NULL, '2025-03-11 15:50:44', '2025-03-14 11:56:18', '全部', 1, NULL, NULL, NULL, NULL, NULL, 'https://img.zcool.cn/community/01102b61086ea011013eaf709d8900.jpg?x-oss-process=image/auto-orient,1/resize,m_lfit,w_1280,limit_1/sharpen,100', '[\"-1\"]', '1', 0);

-- ----------------------------
-- Table structure for product_comment
-- ----------------------------
DROP TABLE IF EXISTS `product_comment`;
CREATE TABLE `product_comment`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `category_id` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `name` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `status` int NULL DEFAULT NULL,
  `code` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `type` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `extend` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `sort` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `image` varchar(2555) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '图片',
  `category_ids` json NULL,
  `mark` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '评分',
  `username` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '用户名称',
  `reviews` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '商品评价',
  `service_attitude` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '服务态度',
  `logistics_service` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '物流服务',
  `evaluation_content` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '评价内容',
  `quality` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '商品质量',
  `deleted_status` tinyint NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `category_id`(`category_id` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1899455940723200002 CHARACTER SET = utf8mb4  ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of product_comment
-- ----------------------------
INSERT INTO `product_comment` VALUES (1, '2', NULL, '2025-03-11 20:08:27', '2025-03-26 16:22:19', 'esf', 0, NULL, NULL, NULL, '2', '5', 'http://47.242.21.112:9000/develop/2025/03/26/16/20250326161957130_947815.png', NULL, '2', '撒谎贝多芬', '5', '4', '4', '好', '4', 0);
INSERT INTO `product_comment` VALUES (1899455940723200001, NULL, '', '2025-03-11 21:42:41', '2025-03-26 16:20:26', 'egg', 0, '0', '', NULL, '2', '3', 'http://47.242.21.112:9000/develop/2025/03/26/16/20250326162014364_675238.png', '[]', '4', '撒旦', '4', '2', '2', '乐意', '3', 0);

-- ----------------------------
-- Table structure for product_spec
-- ----------------------------
DROP TABLE IF EXISTS `product_spec`;
CREATE TABLE `product_spec`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `category_id` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `name` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `status` int NULL DEFAULT NULL,
  `code` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `type` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `extend` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `sort` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `image` varchar(2555) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '图片',
  `category_ids` json NULL,
  `attrs` json NULL,
  `deleted_status` tinyint NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `category_id`(`category_id` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1899457048698933251 CHARACTER SET = utf8mb4  ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of product_spec
-- ----------------------------
INSERT INTO `product_spec` VALUES (1, '2', NULL, '2025-03-11 20:08:27', '2025-03-11 21:34:04', 'esf', 0, NULL, NULL, NULL, '2', NULL, NULL, NULL, '[{\"name\": \"颜色\", \"attributes\": [\"红色\", \"蓝色\"]}]', 0);
INSERT INTO `product_spec` VALUES (1899368555754803201, '1899368392969670658', '', '2025-03-11 15:55:26', '2025-03-11 20:08:37', 'sdfawes', 1, '0', '', NULL, '2', NULL, NULL, '[\"1\", \"1899368392969670658\"]', '[{\"name\": \"颜色\", \"attributes\": [\"红色\", \"蓝色\"]}, {\"name\": \"型号\", \"attributes\": [\"N109\", \"N110\", \"N111\"]}, {\"name\": \"大小\", \"attributes\": [\"20\"]}]', 0);
INSERT INTO `product_spec` VALUES (1899455940723200001, NULL, '', '2025-03-11 21:42:41', '2025-03-11 21:42:41', 'egg', 0, '0', '', NULL, '2', NULL, NULL, '[]', '[{\"name\": \"颜色\", \"attributes\": [\"红色\", \"蓝色\", \"gr\"]}, {\"name\": \"drg\", \"attributes\": [\"rdg\"]}]', 0);
INSERT INTO `product_spec` VALUES (1899457048698933250, NULL, '', '2025-03-11 21:47:05', '2025-03-11 21:47:05', 'trhgh', 0, '0', '', NULL, '2', NULL, NULL, '[]', '[{\"name\": \"颜色\", \"attributes\": [\"蓝色\"]}, {\"name\": \"trh\", \"attributes\": [\"fghh\"]}]', 0);

-- ----------------------------
-- Table structure for product_tag_category
-- ----------------------------
DROP TABLE IF EXISTS `product_tag_category`;
CREATE TABLE `product_tag_category`  (
  `id` bigint NOT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `description` varchar(1025) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  `code` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `status` int NULL DEFAULT NULL,
  `parent_id` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `parent_ids` json NULL,
  `extend` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `type` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `sort` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `image` varchar(2555) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `deleted_status` tinyint NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4  ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of product_tag_category
-- ----------------------------
INSERT INTO `product_tag_category` VALUES (0, '全部', NULL, NULL, NULL, NULL, NULL, '-1', '[\"-1\"]', NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `product_tag_category` VALUES (1898621501231218690, '配置1', NULL, NULL, NULL, NULL, 0, '0', '[\"0\"]', NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `product_tag_category` VALUES (1898632030293303297, '配置1-1', NULL, NULL, NULL, NULL, 0, '1898621501231218690', '[\"0\", \"1898621501231218690\"]', NULL, NULL, NULL, NULL, NULL, 0);

-- ----------------------------
-- Table structure for product_tag_info
-- ----------------------------
DROP TABLE IF EXISTS `product_tag_info`;
CREATE TABLE `product_tag_info`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `category_id` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `border_color` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '边框颜色',
  `bg_color` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '背景颜色',
  `font_color` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '字体颜色',
  `mobile_show` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '移动端展示',
  `name` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `status` int NULL DEFAULT NULL,
  `code` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `type` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `extend` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `sort` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `image` varchar(2555) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '图片',
  `deleted_status` tinyint NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `category_id`(`category_id` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1904532800859500546 CHARACTER SET = utf8mb4  ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of product_tag_info
-- ----------------------------
INSERT INTO `product_tag_info` VALUES (1898631883257782273, '1898621501231218690', 'ewfs\'e\'f\'z\'x', '2025-03-09 15:08:10', '2025-03-29 14:12:11', '#831111', '#812525', '#F90D0D', '0', 'e\'w\'f', 1, '0', '自定义', '11', '11', NULL, NULL, 0);
INSERT INTO `product_tag_info` VALUES (1898635221105876994, '1898632030293303297', '很好的', '2025-03-09 15:21:26', '2025-03-29 14:12:11', '#41E20C', '#FF0000', '#0F0303', '0', 'haiad', 1, '0', '自定义', '从', '4', NULL, NULL, 0);
INSERT INTO `product_tag_info` VALUES (1904515921315065857, '1898632030293303297', '', '2025-03-25 20:49:14', '2025-03-29 14:12:11', '', '', '', '0', '', 1, '0', '图片', '', '0', NULL, 'http://47.242.21.112:9000/develop/2025/03/26/13/20250326134827195_678931.png', 0);
INSERT INTO `product_tag_info` VALUES (1904532510668189698, '1898632030293303297', '', '2025-03-25 21:55:09', '2025-03-29 14:12:11', '#A064CE', '#5FBF7F', '#9D2D2D', '0', '下送货', 1, '0', '自定义', '', '2', '', '', 0);
INSERT INTO `product_tag_info` VALUES (1904532800859500545, '1898632030293303297', '', '2025-03-25 21:56:18', '2025-03-26 13:48:57', '', '', '', '0', '', 0, '0', '图片', '', '3', '', 'http://47.242.21.112:9000/develop/2025/03/26/13/20250326134845662_375194.png', 0);

-- ----------------------------
-- Table structure for shop_cart_info
-- ----------------------------
DROP TABLE IF EXISTS `shop_cart_info`;
CREATE TABLE `shop_cart_info`  (
  `id` bigint NOT NULL COMMENT '主键 ID',
  `flag` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '标识',
  `code` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '编码',
  `status` int NULL DEFAULT 0 COMMENT '状态值: 0: 禁用; 1: 启用;',
  `sort` bigint NULL DEFAULT 0 COMMENT '排序值',
  `remark` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '备注',
  `extend` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '扩展',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `user_id` bigint NULL DEFAULT NULL COMMENT '用户ID',
  `product_id` bigint NULL DEFAULT NULL COMMENT '产品ID',
  `name` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '名称',
  `description` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '描述',
  `image` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '封面',
  `price` decimal(10, 2) NULL DEFAULT 0.00 COMMENT '价格',
  `num` int NULL DEFAULT NULL COMMENT '数量',
  `type` tinyint NULL DEFAULT NULL COMMENT '类别：0:临时；1：正常',
  `deleted_status` tinyint NULL DEFAULT 0 COMMENT '逻辑删除状态：0逻辑未删除值;1:逻辑已删除值',
  `category_id` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `category_ids` json NULL,
  `product_details_id` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4  COMMENT = '系统-配置-信息' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of shop_cart_info
-- ----------------------------
INSERT INTO `shop_cart_info` VALUES (1, NULL, NULL, 0, 0, NULL, NULL, NULL, NULL, 1, 1, '完美日记', NULL, NULL, 100.00, 1, NULL, 0, NULL, NULL, NULL);
INSERT INTO `shop_cart_info` VALUES (2, NULL, NULL, 0, 0, NULL, NULL, NULL, NULL, 1, 2, '三叶草', NULL, NULL, 50.00, 2, NULL, 0, NULL, NULL, NULL);
INSERT INTO `shop_cart_info` VALUES (1906643835741442050, NULL, NULL, 0, 0, NULL, NULL, '2025-03-31 17:44:49', NULL, 1, 3, '大包保', NULL, NULL, 80.00, 5, NULL, 0, NULL, NULL, NULL);
INSERT INTO `shop_cart_info` VALUES (1906644875832365057, NULL, NULL, 0, 0, NULL, NULL, '2025-03-31 17:48:57', NULL, 1, 4, '手拿包', NULL, NULL, 1234.00, 3, NULL, 0, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for shop_order_details
-- ----------------------------
DROP TABLE IF EXISTS `shop_order_details`;
CREATE TABLE `shop_order_details`  (
  `id` bigint NOT NULL COMMENT '主键 ID',
  `flag` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '标识',
  `code` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '编码',
  `status` int NULL DEFAULT 0 COMMENT '状态值: 0: 禁用; 1: 启用;',
  `sort` bigint NULL DEFAULT 0 COMMENT '排序值',
  `remark` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '备注',
  `extend` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '扩展',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `deleted_status` tinyint NULL DEFAULT 0 COMMENT '逻辑删除状态：0逻辑未删除值;1:逻辑已删除值',
  `order_id` bigint NULL DEFAULT NULL COMMENT '订单ID',
  `user_id` bigint NULL DEFAULT NULL COMMENT '用户ID',
  `product_id` bigint NULL DEFAULT NULL COMMENT '产品ID',
  `product_details_id` bigint NULL DEFAULT NULL COMMENT '产品明细ID',
  `name` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '名称',
  `image` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '图片',
  `spec_flags` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '规格标识',
  `specs` json NULL COMMENT '规格',
  `num` int NULL DEFAULT NULL COMMENT '数量',
  `price` decimal(10, 2) NULL DEFAULT NULL COMMENT '价格',
  `amount` decimal(10, 2) NULL DEFAULT 0.00,
  `weight` decimal(10, 2) NULL DEFAULT NULL COMMENT '重量',
  `volume` decimal(10, 2) NULL DEFAULT NULL COMMENT '体积',
  `integral` int NULL DEFAULT NULL COMMENT '积分',
  `reply_status` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '评价状态，0-未评价，1-已评价',
  `category_id` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `category_ids` json NULL,
  `type` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4  COMMENT = '系统-配置-信息' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of shop_order_details
-- ----------------------------

-- ----------------------------
-- Table structure for shop_order_info
-- ----------------------------
DROP TABLE IF EXISTS `shop_order_info`;
CREATE TABLE `shop_order_info`  (
  `id` bigint NOT NULL COMMENT '主键 ID',
  `flag` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '标识',
  `code` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '编码',
  `status` int NULL DEFAULT 0 COMMENT '状态值:状态	订单状态（0->待发货；1->待收货|已发货；2->已收货|待评价；3->已完成）9:已取消',
  `sort` bigint NULL DEFAULT 0 COMMENT '排序值',
  `extend` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '扩展',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `deleted_status` tinyint NULL DEFAULT 0 COMMENT '逻辑删除状态：0逻辑未删除值;1:逻辑已删除值',
  `user_id` bigint NULL DEFAULT NULL COMMENT '用户ID',
  `receiver_name` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '收货姓名',
  `receiver_phone` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '收货电话',
  `receiver_address` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '收货详细地址',
  `delivery_type` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '发货类型：配送方式 1=快递 ，2=门店自提，0：无需配送',
  `delivery_code` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '快递公司编码或门店id(type=1:快递公司编码|type=2:门店id)',
  `delivery_name` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '快递名称/送货人姓名 (type=1:快递名称|type=2:送货人姓名)',
  `delivery_num` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '快递单号/手机号 (type=1:快递单号|type=2:手机号)',
  `delivery_uid` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '配送员id（仅type=2时有效）',
  `delivery_mark` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '快递备注/配送备注',
  `delivery_amount` decimal(10, 2) NULL DEFAULT NULL COMMENT '运费金额：商家发快递或物流的真实价格  快递价格 （仅type=1时有效）',
  `goods_num` int NULL DEFAULT NULL COMMENT '订单总数',
  `integral_promotion_amount` decimal(10, 2) NULL DEFAULT NULL COMMENT '积分抵扣金额',
  `integral_use` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '使用了多少积分',
  `integral_get` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '消费赚取积分',
  `integral_back` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '给用户退了多少积分（integral_back=integral_get-integral_use）',
  `coupon_promotion_amount` decimal(10, 2) NULL DEFAULT NULL COMMENT '优惠劵金额/优惠金额',
  `coupon_id` bigint NULL DEFAULT NULL COMMENT '优惠券ID',
  `coupon_user_id` bigint NULL DEFAULT NULL COMMENT '用户优惠券ID',
  `coupon_data` json NULL COMMENT '优惠券数据',
  `pay_status` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '支付状态：0：未支付；1：已支付',
  `pay_amount` decimal(10, 2) NULL DEFAULT NULL COMMENT '实际支付（总支付，支付接口回调实际支付的价格）（正常情况下应该包含支付商品跟支付邮费）',
  `pay_time` datetime NULL DEFAULT NULL COMMENT '支付时间',
  `pay_type` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '支付方式：wxpay:微信支付;alipay:支付宝;balance:余额支付;offline:线下支付;（abchina:农业银行;boc:中国银行;ccb:中国建设银行;icbc:中国工商银行）暂时无用',
  `pay_trade_id` int NULL DEFAULT NULL COMMENT '支付流水号(交易号)',
  `pay_mark` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '支付备注',
  `refund_status` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '0 未退款 1 申请中 2 已退款',
  `refund_reason_wap_img` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '前台退款图片',
  `refund_reason_wap_desc` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '前台退款用户说明',
  `refund_reason_wap` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '前台退款原因',
  `refund_reason_refuse` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '不退款的理由',
  `refund_reason_time` datetime NULL DEFAULT NULL COMMENT '退款时间',
  `refund_amount` decimal(10, 2) NULL DEFAULT NULL COMMENT '退款金额',
  `promotion_amount` decimal(10, 2) NULL DEFAULT NULL COMMENT '优惠金额',
  `vip_promotion_amount` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '会员优惠金额',
  `vip_id` bigint NULL DEFAULT NULL COMMENT '会员卡ID',
  `vip_data` json NULL COMMENT '会员卡i信息',
  `goods_amount` decimal(10, 2) NULL DEFAULT NULL COMMENT '商品金额',
  `receivable_amount` decimal(10, 2) NULL DEFAULT NULL COMMENT '应收金额/应付金额',
  `total_amount` decimal(10, 2) NULL DEFAULT NULL COMMENT '总价',
  `mark` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '备注',
  `remark` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '商家备注',
  `description` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `category_id` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `category_ids` json NULL,
  `name` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `type` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `image` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4  COMMENT = '系统-配置-信息' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of shop_order_info
-- ----------------------------
INSERT INTO `shop_order_info` VALUES (1906683263683825666, NULL, NULL, 0, 0, NULL, NULL, NULL, 0, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `shop_order_info` VALUES (1906684023825928193, NULL, NULL, 0, 0, NULL, NULL, NULL, 0, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for shop_product_details
-- ----------------------------
DROP TABLE IF EXISTS `shop_product_details`;
CREATE TABLE `shop_product_details`  (
  `id` bigint NOT NULL COMMENT '主键 ID',
  `flag` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '标识',
  `code` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '编码',
  `status` int NULL DEFAULT 0 COMMENT '状态值: 0: 禁用; 1: 启用;',
  `sort` bigint NULL DEFAULT 0 COMMENT '排序值',
  `remark` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '备注',
  `extend` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '扩展',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `product_id` bigint NULL DEFAULT NULL COMMENT '产品ID',
  `specs` json NULL COMMENT '规格',
  `spec_flags` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '规格标识',
  `name` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '名称',
  `description` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '描述',
  `type` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '类型:number:数字;string:字符串;bool:布尔值;double:浮点数;array:数组(用英文逗号分隔的字符串);json：JSON对象',
  `image` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '图片',
  `original_price` decimal(10, 2) NULL DEFAULT NULL COMMENT '原价',
  `cost_price` decimal(10, 2) NULL DEFAULT NULL COMMENT '成本价',
  `price` decimal(10, 2) NULL DEFAULT NULL COMMENT '售价',
  `bar_code` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '条形码',
  `inventory` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '库存',
  `weight` double NULL DEFAULT NULL COMMENT '重量（KG）',
  `volume` double NULL DEFAULT NULL COMMENT '体积(m³)',
  `deleted_status` tinyint NULL DEFAULT 0 COMMENT '逻辑删除状态：0逻辑未删除值;1:逻辑已删除值',
  `category_id` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `category_ids` json NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4  COMMENT = '系统-配置-信息' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of shop_product_details
-- ----------------------------

-- ----------------------------
-- Table structure for shop_product_info
-- ----------------------------
DROP TABLE IF EXISTS `shop_product_info`;
CREATE TABLE `shop_product_info`  (
  `id` bigint NOT NULL COMMENT '主键 ID',
  `code` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '编码',
  `status` int NULL DEFAULT 0 COMMENT '状态值: 0: 禁用; 1: 启用;',
  `sort` bigint NULL DEFAULT 0 COMMENT '排序值',
  `remark` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '备注',
  `extend` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '扩展',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `type` tinyint NULL DEFAULT NULL COMMENT '类型',
  `category_id` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '上级分类ID',
  `category_ids` json NULL COMMENT '上级分类ID数组',
  `brand_id` bigint NULL DEFAULT NULL COMMENT '品牌ID',
  `brand_name` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '品牌名称',
  `unit_id` bigint NULL DEFAULT NULL COMMENT '单位ID',
  `unit_name` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '单位名称',
  `name` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '名称',
  `description` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '描述',
  `image` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '图片',
  `images` json NULL COMMENT '图片集合',
  `recomend_img` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '推荐图',
  `content` longtext CHARACTER SET utf8mb4  NULL COMMENT '内容',
  `keyword` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '关键词',
  `tag_ids` json NULL COMMENT '标签',
  `shelf_status` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '上架状态',
  `shelf_time` datetime NULL DEFAULT NULL COMMENT '上架时间',
  `takedown_status` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '下架状态',
  `takedown_time` datetime NULL DEFAULT NULL COMMENT '下架时间',
  `spec_type` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '规格类型',
  `watchword` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '口令',
  `services` json NULL COMMENT '服务保障',
  `attrs` json NULL COMMENT '参数',
  `sold_num` int NULL DEFAULT NULL COMMENT '已售数量',
  `give_integral` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '赠送积分',
  `give_coupons` json NULL COMMENT '赠送优惠券',
  `user_tag_ids` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '关联用户标签',
  `limit_status` tinyint NULL DEFAULT NULL COMMENT '是否限购',
  `limit_type` tinyint NULL DEFAULT NULL COMMENT '限购类型',
  `limit_num` int NULL DEFAULT NULL COMMENT '限购数量',
  `presell_status` tinyint NULL DEFAULT NULL COMMENT '预售商品状态',
  `presell_time_start` datetime NULL DEFAULT NULL COMMENT '预售商品开始时间',
  `presell_time_end` datetime NULL DEFAULT NULL COMMENT '预售商品结束时间',
  `recommend_status` tinyint NULL DEFAULT NULL COMMENT '优品推荐',
  `recommend_product_ids` json NULL COMMENT '选择优品推荐商品',
  `activity_priority` json NULL COMMENT '活动优先级',
  `delivery_way` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '配送方式',
  `delivery_type` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '运费设置',
  `delivery_price` decimal(10, 2) NULL DEFAULT NULL COMMENT '运费价格',
  `delivery_tpl_id` int NULL DEFAULT NULL COMMENT '运费模板',
  `price` decimal(10, 2) UNSIGNED ZEROFILL NULL DEFAULT 00000000.00 COMMENT '价格',
  `original_price` decimal(10, 2) NULL DEFAULT 0.00 COMMENT '原价',
  `specs` json NULL COMMENT '规格',
  `score_num` decimal(10, 2) NULL DEFAULT 5.00 COMMENT '评分',
  `deleted_status` tinyint NULL DEFAULT 0 COMMENT '逻辑删除状态：0逻辑未删除值;1:逻辑已删除值',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4  COMMENT = '系统-配置-信息' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of shop_product_info
-- ----------------------------
INSERT INTO `shop_product_info` VALUES (1, NULL, 0, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '完美日记', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 20.00, NULL, 00000020.00, 0.00, NULL, 5.00, 0);
INSERT INTO `shop_product_info` VALUES (2, NULL, 0, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '三叶草', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 00000100.00, 0.00, NULL, 5.00, 0);
INSERT INTO `shop_product_info` VALUES (3, NULL, 0, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '大包保', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 00000080.00, 0.00, NULL, 5.00, 0);
INSERT INTO `shop_product_info` VALUES (4, NULL, 0, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '手拿包', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 00001234.00, 0.00, NULL, 5.00, 0);
INSERT INTO `shop_product_info` VALUES (5, NULL, 0, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 00000150.00, 0.00, NULL, 5.00, 0);

-- ----------------------------
-- Table structure for system_config_category
-- ----------------------------
DROP TABLE IF EXISTS `system_config_category`;
CREATE TABLE `system_config_category`  (
  `id` bigint NOT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `description` varchar(1025) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  `code` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `status` int NULL DEFAULT NULL,
  `parent_id` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `parent_ids` json NULL,
  `extend` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `type` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `sort` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `image` varchar(2555) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `deleted_status` tinyint NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4  ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of system_config_category
-- ----------------------------
INSERT INTO `system_config_category` VALUES (0, '全部', NULL, NULL, NULL, NULL, NULL, '-1', '[\"-1\"]', NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `system_config_category` VALUES (1901593576480931841, '系统设置', NULL, NULL, NULL, NULL, 0, '0', '[\"0\"]', NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `system_config_category` VALUES (1901593608152121346, '系统信息', NULL, NULL, NULL, NULL, 0, '1901593576480931841', '[\"0\", \"1901593576480931841\"]', NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `system_config_category` VALUES (1901597045182898178, '后台设置', NULL, NULL, NULL, NULL, 0, '1901593576480931841', '[\"0\", \"1901593576480931841\"]', NULL, NULL, NULL, NULL, NULL, 0);

-- ----------------------------
-- Table structure for system_config_info
-- ----------------------------
DROP TABLE IF EXISTS `system_config_info`;
CREATE TABLE `system_config_info`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `category_id` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `name` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `status` int NULL DEFAULT NULL,
  `code` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `type` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `extend` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `sort` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `image` varchar(2555) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `value` varchar(1025) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `deleted_status` tinyint NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `category_id`(`category_id` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1901594985012101122 CHARACTER SET = utf8mb4  ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of system_config_info
-- ----------------------------
INSERT INTO `system_config_info` VALUES (1901594118863159297, '1901593608152121346', '网站名称', '2025-03-17 19:19:02', '2025-03-17 19:29:13', '网站名称', 0, 'SystemSetting.Sys.NetName', '1', 'SystemSetting.Sys.NetName', '', NULL, NULL, 'PRO', 0);
INSERT INTO `system_config_info` VALUES (1901594324082065410, '1901593608152121346', '网站地址', '2025-03-17 19:19:51', '2025-03-17 19:29:22', '网站地址', 0, 'SystemSetting.Sys.NetAddress', '1', 'SystemSetting.Sys.NetAddress', '', '', '', 'https://pro.crmeb.net', 0);
INSERT INTO `system_config_info` VALUES (1901594514172116994, '1901593608152121346', '联系电话', '2025-03-17 19:20:36', '2025-03-17 19:29:32', '联系电话', 0, 'SystemSetting.Sys.Phone', '1', 'SystemSetting.Sys.Phone', '', '', '', '4000809707', 0);
INSERT INTO `system_config_info` VALUES (1901594654928764930, '1901593608152121346', '网站缓存时间', '2025-03-17 19:21:10', '2025-03-17 19:29:39', '网站缓存时间', 0, 'SystemSetting.Sys.NetCacheTime', '1', 'SystemSetting.Sys.NetCacheTime', '', '', '', '86400', 0);
INSERT INTO `system_config_info` VALUES (1901594985012101121, '1901593608152121346', '备案号', '2025-03-17 19:22:29', '2025-03-17 19:29:49', '备案号', 0, 'SystemSetting.Sys.NetRecordNumber', '1', 'SystemSetting.Sys.NetRecordNumber', '', '', '', '陕ICP备14011498号-3', 0);

-- ----------------------------
-- Table structure for system_dict_category
-- ----------------------------
DROP TABLE IF EXISTS `system_dict_category`;
CREATE TABLE `system_dict_category`  (
  `id` bigint NOT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `description` varchar(1025) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  `code` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `status` int NULL DEFAULT NULL,
  `parent_id` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `parent_ids` json NULL,
  `extend` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `type` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `sort` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `image` varchar(2555) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `value` varchar(1255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `deleted_status` tinyint NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4  ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of system_dict_category
-- ----------------------------
INSERT INTO `system_dict_category` VALUES (0, '全部', NULL, NULL, NULL, NULL, NULL, '-1', '[\"-1\"]', NULL, NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `system_dict_category` VALUES (1898621501231218690, '员工管理', NULL, '2025-03-25 19:36:33', NULL, 'EmployeeManagement', 0, '0', '[\"0\"]', NULL, NULL, NULL, NULL, NULL, '员工管理', 0);
INSERT INTO `system_dict_category` VALUES (1904501624295882754, '角色', NULL, NULL, NULL, 'Emp.Role', 0, '1898621501231218690', '[\"0\", \"1898621501231218690\"]', NULL, NULL, NULL, NULL, NULL, '角色', 0);
INSERT INTO `system_dict_category` VALUES (1904501777304092673, '岗位', NULL, '2025-03-25 20:14:52', NULL, 'Emp.Position', 0, '1898621501231218690', '[\"0\", \"1898621501231218690\"]', NULL, NULL, NULL, NULL, NULL, '岗位', 0);
INSERT INTO `system_dict_category` VALUES (1904501956392484866, '组织', NULL, NULL, NULL, 'Emp.Organization', 0, '1898621501231218690', '[\"0\", \"1898621501231218690\"]', NULL, NULL, NULL, NULL, NULL, '组织', 0);

-- ----------------------------
-- Table structure for system_dict_info
-- ----------------------------
DROP TABLE IF EXISTS `system_dict_info`;
CREATE TABLE `system_dict_info`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `category_id` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `name` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `status` int NULL DEFAULT NULL,
  `code` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `type` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `extend` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `sort` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `image` varchar(2555) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `deleted_status` tinyint NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `category_id`(`category_id` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1904504920586772482 CHARACTER SET = utf8mb4  ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of system_dict_info
-- ----------------------------
INSERT INTO `system_dict_info` VALUES (1904502152765603842, '1904501624295882754', '班主任', '2025-03-25 19:54:31', '2025-03-25 19:55:04', '班主任', 1, '1', NULL, NULL, '1', NULL, NULL, 0);
INSERT INTO `system_dict_info` VALUES (1904502266246692866, '1904501624295882754', '语文老师', '2025-03-25 19:54:58', '2025-03-25 19:55:15', '语文老师', 1, '2', '', '', '2', '', '', 0);
INSERT INTO `system_dict_info` VALUES (1904502421331083266, '1904501624295882754', '数学老师', '2025-03-25 19:55:35', '2025-03-25 19:56:08', '数学老师', 1, '3', '', '', '3', '', '', 0);
INSERT INTO `system_dict_info` VALUES (1904502508929122306, '1904501624295882754', '英语老师', '2025-03-25 19:55:56', '2025-03-25 19:56:09', '英语老师', 1, '4', '', '', '4', '', '', 0);
INSERT INTO `system_dict_info` VALUES (1904504110494744578, '1904501777304092673', '岗位1', '2025-03-25 20:02:18', '2025-03-25 20:27:12', '岗位1', 1, '1', NULL, NULL, '1', NULL, NULL, 0);
INSERT INTO `system_dict_info` VALUES (1904504256779485186, '1904501777304092673', '岗位2', '2025-03-25 20:02:53', '2025-03-25 20:27:11', '岗位2', 1, '2', NULL, NULL, '2', NULL, NULL, 0);
INSERT INTO `system_dict_info` VALUES (1904504731469799425, '1904501777304092673', '岗位3', '2025-03-25 20:04:46', '2025-03-25 20:27:11', '岗位3', 1, '3', '', '', '3', '', '', 0);
INSERT INTO `system_dict_info` VALUES (1904504811673280513, '1904501956392484866', '组织1', '2025-03-25 20:05:05', '2025-03-25 20:27:11', '组织1', 1, '1', '', '', '1', '', '', 0);
INSERT INTO `system_dict_info` VALUES (1904504874956939266, '1904501956392484866', '组织2', '2025-03-25 20:05:20', '2025-03-25 20:27:10', '组织2', 1, '2', '', '', '2', '', '', 0);
INSERT INTO `system_dict_info` VALUES (1904504920586772481, '1904501956392484866', '组织3', '2025-03-25 20:05:31', '2025-03-25 20:27:08', '组织3', 1, '3', '', '', '3', '', '', 0);

-- ----------------------------
-- Table structure for system_permission_info
-- ----------------------------
DROP TABLE IF EXISTS `system_permission_info`;
CREATE TABLE `system_permission_info`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `category_id` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `name` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `status` int NULL DEFAULT NULL,
  `code` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `type` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `extend` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `sort` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `image` varchar(2555) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '图片',
  `category_ids` json NULL,
  `path` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `meta` json NULL,
  `component` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `redirect` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `deleted_status` tinyint NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `category_id`(`category_id` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1905982966867103747 CHARACTER SET = utf8mb4  ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of system_permission_info
-- ----------------------------
INSERT INTO `system_permission_info` VALUES (1905216795536482305, '0', '', '2025-03-27 19:14:16', '2025-03-29 13:36:39', '文章管理', 1, '', '', NULL, '1', NULL, NULL, '[\"0\"]', '/Article', '{\"title\": \"文章管理\"}', '', '/Article/ArticleInfo', 0);
INSERT INTO `system_permission_info` VALUES (1905217139251306497, '1905216795536482305', '', '2025-03-27 19:15:37', '2025-03-29 13:36:40', '文章管理', 1, '', '', NULL, '1', NULL, NULL, '[\"0\", \"1905216795536482305\"]', '/Article/ArticleInfo', '{\"title\": \"文章管理\"}', '@/views/cms/article/index.vue', '', 0);
INSERT INTO `system_permission_info` VALUES (1905217704895143938, '1905216795536482305', '', '2025-03-27 19:17:52', '2025-03-29 13:36:40', '文章标签', 1, '', '', NULL, '2', NULL, NULL, '[\"0\", \"1905216795536482305\"]', '/Article/ArticleTag', '{\"title\": \"文章标签\"}', '@/views/cms/articleTag/index.vue', '', 0);
INSERT INTO `system_permission_info` VALUES (1905217954414288897, '1905216795536482305', '', '2025-03-27 19:18:52', '2025-03-29 13:36:36', '测试页面', 1, '', '', NULL, '3', NULL, NULL, '[\"0\", \"1905216795536482305\"]', '/Article/TestMe', '{\"title\": \"测试页面\"}', '@/views/test/test.vue', '', 0);
INSERT INTO `system_permission_info` VALUES (1905452177347813377, '0', '', '2025-03-28 10:49:35', '2025-03-29 13:36:35', '商品管理', 1, '', '', NULL, '1', NULL, NULL, '[\"0\"]', '/Product', '{\"title\": \"商品管理\"}', '', '/Product/ProductTag', 0);
INSERT INTO `system_permission_info` VALUES (1905452392205230082, '1905452177347813377', '', '2025-03-28 10:50:26', '2025-03-29 13:36:35', '商品标签', 1, '', '', NULL, '1', NULL, NULL, '[\"0\", \"1905452177347813377\"]', '/Product/ProductTag', '{\"title\": \"商品标签\"}', '@/views/product/productTag/index.vue', '', 0);
INSERT INTO `system_permission_info` VALUES (1905452527639306242, '1905452177347813377', '', '2025-03-28 10:50:58', '2025-03-29 13:36:34', '商品品牌', 1, '', '', NULL, '1', NULL, NULL, '[\"0\", \"1905452177347813377\"]', '/Product/ProductBrand', '{\"title\": \"商品品牌\"}', '@/views/product/productBrand/index.vue', '', 0);
INSERT INTO `system_permission_info` VALUES (1905452718916345858, '1905452177347813377', '', '2025-03-28 10:51:44', '2025-03-29 13:36:34', '商品分类', 1, '', '', NULL, '1', NULL, NULL, '[\"0\", \"1905452177347813377\"]', '/Product/ProductCategory', '{\"title\": \"商品分类\"}', '@/views/product/productCategory/index.vue', '', 0);
INSERT INTO `system_permission_info` VALUES (1905452845152313346, '1905452177347813377', '', '2025-03-28 10:52:14', '2025-03-29 13:36:34', '商品规格', 1, '', '', NULL, '1', NULL, NULL, '[\"0\", \"1905452177347813377\"]', '/Product/ProductSpec', '{\"title\": \"商品规格\"}', '@/views/product/productSpec/index.vue', '', 0);
INSERT INTO `system_permission_info` VALUES (1905453081631367170, '1905452177347813377', '', '2025-03-28 10:53:10', '2025-03-29 13:36:33', '商品评论', 1, '', '', NULL, '2', NULL, NULL, '[\"0\", \"1905452177347813377\"]', '/Product/ProductComment', '{\"title\": \"商品评论\"}', '@/views/product/productComment/index.vue', '', 0);
INSERT INTO `system_permission_info` VALUES (1905856358508331010, '0', '', '2025-03-28 10:49:35', '2025-03-29 20:28:14', '基本管理', 1, '', '', NULL, '1', NULL, NULL, '[\"0\"]', '/Info', '{\"title\": \"基本管理\"}', '', '/Info/AdminInfo', 0);
INSERT INTO `system_permission_info` VALUES (1905856572694659074, '1905856358508331010', '', '2025-03-29 13:36:30', '2025-03-29 13:36:33', '员工管理', 1, '', '', NULL, '2', NULL, NULL, '[\"0\", \"1905856358508331010\"]', '/Info/AdminInfo', '{\"title\": \"员工管理\"}', '@/views/info/admin/index.vue', '', 0);
INSERT INTO `system_permission_info` VALUES (1905856866983804930, '0', '', '2025-03-29 13:37:40', '2025-03-29 13:37:43', '系统模块', 1, '', '', NULL, '1', NULL, NULL, '[\"0\"]', '/System', '{\"title\": \"系统模块\"}', '', '/System/ConfigInfo', 0);
INSERT INTO `system_permission_info` VALUES (1905857064007041025, '1905856866983804930', '', '2025-03-29 13:38:27', '2025-03-29 13:40:41', '配置管理', 1, '', '', NULL, '2', NULL, NULL, '[\"0\", \"1905856866983804930\"]', '/System/ConfigInfo', '{\"title\": \"配置管理\"}', '@/views/system/config/index.vue', '', 0);
INSERT INTO `system_permission_info` VALUES (1905857173000224769, '1905856866983804930', '', '2025-03-29 13:38:53', '2025-03-29 13:40:40', '字典管理', 1, '', '', NULL, '2', NULL, NULL, '[\"0\", \"1905856866983804930\"]', '/System/DictInfo', '{\"title\": \"字典管理\"}', '@/views/system/dict/index.vue', '', 0);
INSERT INTO `system_permission_info` VALUES (1905857300725170178, '1905856866983804930', '', '2025-03-29 13:39:24', '2025-03-29 13:40:40', '短信管理', 1, '', '', NULL, '2', NULL, NULL, '[\"0\", \"1905856866983804930\"]', '/System/TplInfo', '{\"title\": \"短信管理\"}', '@/views/system/sms/tpl/index.vue', '', 0);
INSERT INTO `system_permission_info` VALUES (1905857420019564545, '1905856866983804930', '', '2025-03-29 13:39:52', '2025-03-29 13:40:40', '权限管理', 1, '', '', NULL, '2', NULL, NULL, '[\"0\", \"1905856866983804930\"]', '/System/PermissionInfo', '{\"title\": \"权限管理\"}', '@/views/system/permission/index.vue', '', 0);
INSERT INTO `system_permission_info` VALUES (1905857575066206209, '1905856866983804930', '', '2025-03-29 13:40:29', '2025-03-29 13:40:39', '角色管理', 1, '', '', NULL, '2', NULL, NULL, '[\"0\", \"1905856866983804930\"]', '/System/RolesInfo', '{\"title\": \"角色管理\"}', '@/views/system/role/index.vue', '', 0);
INSERT INTO `system_permission_info` VALUES (1905982966867103746, '-1', NULL, '2025-03-11 15:50:44', '2025-03-16 13:11:05', '全部', 1, NULL, NULL, NULL, NULL, NULL, NULL, '[\"-1\"]', NULL, NULL, NULL, NULL, 0);

-- ----------------------------
-- Table structure for system_role_info
-- ----------------------------
DROP TABLE IF EXISTS `system_role_info`;
CREATE TABLE `system_role_info`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `category_id` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `name` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `status` int NULL DEFAULT NULL,
  `code` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `type` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `extend` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `sort` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `image` varchar(2555) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '图片',
  `category_ids` json NULL,
  `deleted_status` tinyint NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `category_id`(`category_id` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1905614681721946115 CHARACTER SET = utf8mb4  ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of system_role_info
-- ----------------------------
INSERT INTO `system_role_info` VALUES (1905254920082030594, NULL, '', '2025-03-27 21:45:45', '2025-03-30 11:31:35', '老板', 1, '', '', NULL, '', NULL, NULL, '[\"1905217139251306497\", \"1905217704895143938\", \"1905452177347813377\", \"1905452392205230082\", \"1905452527639306242\", \"1905452718916345858\", \"1905452845152313346\", \"1905453081631367170\"]', 0);
INSERT INTO `system_role_info` VALUES (1905255465828089858, NULL, '', '2025-03-27 21:47:55', '2025-03-30 11:49:00', '小明', 1, '', '', NULL, '', NULL, NULL, '[\"1905452177347813377\", \"1905452392205230082\", \"1905452527639306242\", \"1905452718916345858\", \"1905452845152313346\", \"1905453081631367170\", \"1905856866983804930\", \"1905857064007041025\", \"1905857173000224769\", \"1905857300725170178\", \"1905857420019564545\", \"1905857575066206209\"]', 0);

-- ----------------------------
-- Table structure for system_sms_tpl_category
-- ----------------------------
DROP TABLE IF EXISTS `system_sms_tpl_category`;
CREATE TABLE `system_sms_tpl_category`  (
  `id` bigint NOT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `description` varchar(1025) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  `code` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `status` int NULL DEFAULT NULL,
  `parent_id` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `parent_ids` json NULL,
  `extend` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `type` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `sort` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `image` varchar(2555) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `deleted_status` tinyint NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4  ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of system_sms_tpl_category
-- ----------------------------
INSERT INTO `system_sms_tpl_category` VALUES (0, '全部', NULL, NULL, NULL, NULL, NULL, '-1', '[\"-1\"]', NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `system_sms_tpl_category` VALUES (1898621501231218690, '配置1', NULL, NULL, NULL, NULL, 0, '0', '[\"0\"]', NULL, NULL, NULL, NULL, NULL, 0);

-- ----------------------------
-- Table structure for system_sms_tpl_info
-- ----------------------------
DROP TABLE IF EXISTS `system_sms_tpl_info`;
CREATE TABLE `system_sms_tpl_info`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `category_id` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `name` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `status` int NULL DEFAULT NULL,
  `code` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `type` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `extend` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `sort` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `image` varchar(2555) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `deleted_status` tinyint NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `category_id`(`category_id` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1904820549134999555 CHARACTER SET = utf8mb4  ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of system_sms_tpl_info
-- ----------------------------
INSERT INTO `system_sms_tpl_info` VALUES (1898662854820577282, '1898621501231218690', 'ewf', '2025-03-09 17:11:14', '2025-03-26 16:59:33', 'SDF', 1, '2', '', '', '1', '', NULL, 0);
INSERT INTO `system_sms_tpl_info` VALUES (1904820549134999554, NULL, '', '2025-03-26 16:59:43', '2025-03-26 16:59:43', '', 0, '0', '', '', '', '', '', 0);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` bigint NOT NULL,
  `username` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `status` int NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  `roles` json NULL,
  `code` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4  ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'admin', 'e10adc3949ba59abbe56e057f20f883e', '管理员', NULL, NULL, NULL, NULL, NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;
