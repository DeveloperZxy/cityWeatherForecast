/*
 Navicat Premium Data Transfer

 Source Server         : weather
 Source Server Type    : MySQL
 Source Server Version : 50739 (5.7.39-log)
 Source Host           : 47.242.21.112:3306
 Source Schema         : weather

 Target Server Type    : MySQL
 Target Server Version : 50739 (5.7.39-log)
 File Encoding         : 65001

 Date: 27/04/2025 11:07:27
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for city_info
-- ----------------------------
DROP TABLE IF EXISTS `city_info`;
CREATE TABLE `city_info`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `category_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '城市名称',
  `status` int(11) NULL DEFAULT NULL,
  `code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `extend` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `sort` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `image` varchar(2555) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '图片',
  `category_ids` json NULL,
  `deleted_status` tinyint(4) NULL DEFAULT 0,
  `warn` json NULL COMMENT '警报',
  `location_data` json NULL COMMENT '位置信息',
  `location_id` bigint(20) NULL DEFAULT NULL COMMENT '城市id',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `category_id`(`category_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1916004953295372290 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of city_info
-- ----------------------------
INSERT INTO `city_info` VALUES (1915774879975489538, NULL, NULL, '2025-04-25 22:28:19', '2025-04-26 14:03:03', '北京', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '{\"id\": \"101010100\", \"tz\": \"Asia/Shanghai\", \"lat\": \"39.90499\", \"lon\": \"116.40529\", \"adm1\": \"北京市\", \"adm2\": \"北京\", \"name\": \"北京\", \"rank\": \"10\", \"type\": \"city\", \"isDst\": \"0\", \"fxLink\": \"https://www.qweather.com/weather/beijing-101010100.html\", \"country\": \"中国\", \"utcOffset\": \"+08:00\"}', 101010100);
INSERT INTO `city_info` VALUES (1915776479204884482, NULL, NULL, '2025-04-25 22:34:40', '2025-04-26 14:03:03', '闵行', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '{\"id\": \"101020200\", \"tz\": \"Asia/Shanghai\", \"lat\": \"31.11166\", \"lon\": \"121.37597\", \"adm1\": \"上海市\", \"adm2\": \"上海\", \"name\": \"闵行\", \"rank\": \"25\", \"type\": \"city\", \"isDst\": \"0\", \"fxLink\": \"https://www.qweather.com/weather/minhang-101020200.html\", \"country\": \"中国\", \"utcOffset\": \"+08:00\"}', 101020200);

-- ----------------------------
-- Table structure for city_weather_info
-- ----------------------------
DROP TABLE IF EXISTS `city_weather_info`;
CREATE TABLE `city_weather_info`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `category_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '城市名称',
  `status` int(11) NULL DEFAULT NULL,
  `code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `extend` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `sort` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `image` varchar(2555) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '图片',
  `category_ids` json NULL,
  `deleted_status` tinyint(4) NULL DEFAULT 0,
  `fx_link` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '当前数据的响应式页面，便于嵌入网站或应用',
  `obs_time` datetime NULL DEFAULT NULL COMMENT '数据观测时间',
  `temp` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '温度，默认单位：摄氏度',
  `feels_like` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '体感温度，默认单位：摄氏度',
  `icon` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '天气状况的图标代码，另请参考天气图标项目',
  `text` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '天气状况的文字描述，包括阴晴雨雪等天气状态的描述',
  `wind360` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '风向360角度',
  `wind_dir` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '风向',
  `wind_scale` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '风力',
  `wind_speed` double NULL DEFAULT NULL COMMENT '风速 公里/小时',
  `humidity` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '相对湿度',
  `precip` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '过去1小时降水量，默认单位：毫米',
  `pressure` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '大气压强，默认单位：百帕',
  `vis` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '能见度，默认单位：公里',
  `location_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '城市Id',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `category_id`(`category_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1916322662327488515 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of city_weather_info
-- ----------------------------
INSERT INTO `city_weather_info` VALUES (1916060938785509378, NULL, NULL, '2025-04-26 17:25:00', '2025-04-26 17:25:00', '北京', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-26 17:16:00', '23', '22', '104', '阴', '180', '南风', '2', 9, '42', '0.0', '1004', '6', '101010100');
INSERT INTO `city_weather_info` VALUES (1916060939494346754, NULL, NULL, '2025-04-26 17:25:00', '2025-04-26 17:25:00', '闵行', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-26 17:16:00', '21', '16', '104', '阴', '135', '东南风', '4', 23, '24', '0.0', '1018', '30', '101020200');
INSERT INTO `city_weather_info` VALUES (1916062193289252865, NULL, NULL, '2025-04-26 17:29:59', '2025-04-26 17:29:59', '北京', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-26 17:24:00', '23', '21', '104', '阴', '225', '西南风', '3', 12, '42', '0.0', '1004', '6', '101010100');
INSERT INTO `city_weather_info` VALUES (1916062193985507329, NULL, NULL, '2025-04-26 17:29:59', '2025-04-26 17:29:59', '闵行', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-26 17:24:00', '21', '18', '101', '多云', '135', '东南风', '3', 13, '23', '0.0', '1018', '25', '101020200');
INSERT INTO `city_weather_info` VALUES (1916063451576258561, NULL, NULL, '2025-04-26 17:34:59', '2025-04-26 17:34:59', '北京', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-26 17:30:00', '23', '22', '104', '阴', '225', '西南风', '2', 10, '43', '0.0', '1004', '7', '101010100');
INSERT INTO `city_weather_info` VALUES (1916063452427702273, NULL, NULL, '2025-04-26 17:34:59', '2025-04-26 17:34:59', '闵行', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-26 17:30:00', '20', '16', '101', '多云', '90', '东风', '3', 17, '23', '0.0', '1018', '30', '101020200');
INSERT INTO `city_weather_info` VALUES (1916064709963927554, NULL, NULL, '2025-04-26 17:39:59', '2025-04-26 17:39:59', '北京', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-26 17:30:00', '23', '22', '104', '阴', '225', '西南风', '2', 10, '43', '0.0', '1004', '7', '101010100');
INSERT INTO `city_weather_info` VALUES (1916064710685347842, NULL, NULL, '2025-04-26 17:39:59', '2025-04-26 17:39:59', '闵行', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-26 17:30:00', '20', '16', '101', '多云', '90', '东风', '3', 17, '23', '0.0', '1018', '30', '101020200');
INSERT INTO `city_weather_info` VALUES (1916065968284487682, NULL, NULL, '2025-04-26 17:44:59', '2025-04-26 17:44:59', '北京', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-26 17:40:00', '23', '22', '104', '阴', '225', '西南风', '2', 10, '44', '0.0', '1004', '6', '101010100');
INSERT INTO `city_weather_info` VALUES (1916065968934604802, NULL, NULL, '2025-04-26 17:44:59', '2025-04-26 17:44:59', '闵行', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-26 17:41:00', '20', '18', '104', '阴', '135', '东南风', '1', 5, '24', '0.0', '1018', '30', '101020200');
INSERT INTO `city_weather_info` VALUES (1916067226575687682, NULL, NULL, '2025-04-26 17:49:59', '2025-04-26 17:49:59', '北京', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-26 17:40:00', '23', '22', '104', '阴', '225', '西南风', '2', 10, '44', '0.0', '1004', '6', '101010100');
INSERT INTO `city_weather_info` VALUES (1916067227292913665, NULL, NULL, '2025-04-26 17:49:59', '2025-04-26 17:49:59', '闵行', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-26 17:41:00', '20', '18', '104', '阴', '135', '东南风', '1', 5, '24', '0.0', '1018', '30', '101020200');
INSERT INTO `city_weather_info` VALUES (1916068484783001602, NULL, NULL, '2025-04-26 17:54:59', '2025-04-26 17:54:59', '北京', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-26 17:48:00', '23', '21', '104', '阴', '225', '西南风', '3', 14, '44', '0.0', '1004', '6', '101010100');
INSERT INTO `city_weather_info` VALUES (1916068485567336450, NULL, NULL, '2025-04-26 17:54:59', '2025-04-26 17:54:59', '闵行', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-26 17:50:00', '20', '17', '104', '阴', '135', '东南风', '3', 14, '24', '0.0', '1018', '30', '101020200');
INSERT INTO `city_weather_info` VALUES (1916069743212613633, NULL, NULL, '2025-04-26 17:59:59', '2025-04-26 17:59:59', '北京', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-26 17:56:00', '23', '23', '104', '阴', '225', '西南风', '1', 5, '45', '0.0', '1004', '6', '101010100');
INSERT INTO `city_weather_info` VALUES (1916069743879507970, NULL, NULL, '2025-04-26 17:59:59', '2025-04-26 17:59:59', '闵行', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-26 17:56:00', '20', '15', '104', '阴', '180', '南风', '4', 21, '25', '0.0', '1018', '30', '101020200');
INSERT INTO `city_weather_info` VALUES (1916071001336041473, NULL, NULL, '2025-04-26 18:04:59', '2025-04-26 18:04:59', '北京', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-26 18:00:00', '23', '22', '104', '阴', '225', '西南风', '2', 8, '45', '0.0', '1004', '6', '101010100');
INSERT INTO `city_weather_info` VALUES (1916071002057461762, NULL, NULL, '2025-04-26 18:04:59', '2025-04-26 18:04:59', '闵行', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-26 18:00:00', '19', '15', '104', '阴', '135', '东南风', '3', 17, '26', '0.0', '1018', '30', '101020200');
INSERT INTO `city_weather_info` VALUES (1916072259635630082, NULL, NULL, '2025-04-26 18:09:59', '2025-04-26 18:09:59', '北京', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-26 18:00:00', '23', '22', '104', '阴', '225', '西南风', '2', 8, '45', '0.0', '1004', '6', '101010100');
INSERT INTO `city_weather_info` VALUES (1916072260285747201, NULL, NULL, '2025-04-26 18:09:59', '2025-04-26 18:09:59', '闵行', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-26 18:00:00', '19', '15', '104', '阴', '135', '东南风', '3', 17, '26', '0.0', '1018', '30', '101020200');
INSERT INTO `city_weather_info` VALUES (1916073517918441473, NULL, NULL, '2025-04-26 18:14:59', '2025-04-26 18:14:59', '北京', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-26 18:08:00', '23', '23', '104', '阴', '180', '南风', '1', 5, '45', '0.0', '1004', '6', '101010100');
INSERT INTO `city_weather_info` VALUES (1916073518644056065, NULL, NULL, '2025-04-26 18:14:59', '2025-04-26 18:14:59', '闵行', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-26 18:08:00', '19', '15', '104', '阴', '135', '东南风', '3', 16, '29', '0.0', '1018', '30', '101020200');
INSERT INTO `city_weather_info` VALUES (1916074776322887681, NULL, NULL, '2025-04-26 18:19:59', '2025-04-26 18:19:59', '北京', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-26 18:17:00', '23', '22', '104', '阴', '225', '西南风', '2', 8, '46', '0.0', '1004', '6', '101010100');
INSERT INTO `city_weather_info` VALUES (1916074777027530753, NULL, NULL, '2025-04-26 18:19:59', '2025-04-26 18:19:59', '闵行', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-26 18:17:00', '19', '14', '104', '阴', '135', '东南风', '4', 22, '30', '0.0', '1018', '30', '101020200');
INSERT INTO `city_weather_info` VALUES (1916076034467287042, NULL, NULL, '2025-04-26 18:24:59', '2025-04-26 18:24:59', '北京', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-26 18:17:00', '23', '22', '104', '阴', '225', '西南风', '2', 8, '46', '0.0', '1004', '6', '101010100');
INSERT INTO `city_weather_info` VALUES (1916076035180318721, NULL, NULL, '2025-04-26 18:24:59', '2025-04-26 18:24:59', '闵行', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-26 18:17:00', '19', '14', '104', '阴', '135', '东南风', '4', 22, '30', '0.0', '1018', '30', '101020200');
INSERT INTO `city_weather_info` VALUES (1916077292813012993, NULL, NULL, '2025-04-26 18:29:59', '2025-04-26 18:29:59', '北京', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-26 18:24:00', '23', '23', '104', '阴', '180', '南风', '2', 7, '47', '0.0', '1004', '6', '101010100');
INSERT INTO `city_weather_info` VALUES (1916077293526044673, NULL, NULL, '2025-04-26 18:29:59', '2025-04-26 18:29:59', '闵行', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-26 18:24:00', '19', '17', '104', '阴', '180', '南风', '2', 8, '32', '0.0', '1018', '30', '101020200');
INSERT INTO `city_weather_info` VALUES (1916078551162933250, NULL, NULL, '2025-04-26 18:34:59', '2025-04-26 18:34:59', '北京', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-26 18:32:00', '23', '22', '104', '阴', '225', '西南风', '2', 9, '48', '0.0', '1004', '6', '101010100');
INSERT INTO `city_weather_info` VALUES (1916078551804661762, NULL, NULL, '2025-04-26 18:34:59', '2025-04-26 18:34:59', '闵行', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-26 18:32:00', '19', '15', '104', '阴', '135', '东南风', '4', 22, '33', '0.0', '1018', '28', '101020200');
INSERT INTO `city_weather_info` VALUES (1916079809311526914, NULL, NULL, '2025-04-26 18:39:59', '2025-04-26 18:39:59', '北京', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-26 18:32:00', '23', '22', '104', '阴', '225', '西南风', '2', 9, '48', '0.0', '1004', '6', '101010100');
INSERT INTO `city_weather_info` VALUES (1916079810024558593, NULL, NULL, '2025-04-26 18:39:59', '2025-04-26 18:39:59', '闵行', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-26 18:32:00', '19', '15', '104', '阴', '135', '东南风', '4', 22, '33', '0.0', '1018', '28', '101020200');
INSERT INTO `city_weather_info` VALUES (1916081067640475650, NULL, NULL, '2025-04-26 18:44:59', '2025-04-26 18:44:59', '北京', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-26 18:41:00', '23', '21', '104', '阴', '180', '南风', '3', 18, '49', '0.0', '1004', '6', '101010100');
INSERT INTO `city_weather_info` VALUES (1916081068286398465, NULL, NULL, '2025-04-26 18:44:59', '2025-04-26 18:44:59', '闵行', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-26 18:41:00', '18', '14', '104', '阴', '135', '东南风', '3', 19, '33', '0.0', '1018', '30', '101020200');
INSERT INTO `city_weather_info` VALUES (1916082326921531393, NULL, NULL, '2025-04-26 18:49:59', '2025-04-26 18:49:59', '北京', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-26 18:41:00', '23', '21', '104', '阴', '180', '南风', '3', 18, '49', '0.0', '1004', '6', '101010100');
INSERT INTO `city_weather_info` VALUES (1916082327567454209, NULL, NULL, '2025-04-26 18:50:00', '2025-04-26 18:50:00', '闵行', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-26 18:41:00', '18', '14', '104', '阴', '135', '东南风', '3', 19, '33', '0.0', '1018', '30', '101020200');
INSERT INTO `city_weather_info` VALUES (1916083584218681345, NULL, NULL, '2025-04-26 18:54:59', '2025-04-26 18:54:59', '北京', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-26 18:48:00', '23', '22', '104', '阴', '225', '西南风', '2', 9, '49', '0.0', '1004', '6', '101010100');
INSERT INTO `city_weather_info` VALUES (1916083584919130113, NULL, NULL, '2025-04-26 18:54:59', '2025-04-26 18:54:59', '闵行', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-26 18:48:00', '18', '16', '104', '阴', '135', '东南风', '2', 9, '34', '0.0', '1018', '30', '101020200');
INSERT INTO `city_weather_info` VALUES (1916084842623127553, NULL, NULL, '2025-04-26 18:59:59', '2025-04-26 18:59:59', '北京', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-26 18:56:00', '22', '22', '104', '阴', '225', '西南风', '2', 7, '50', '0.0', '1004', '6', '101010100');
INSERT INTO `city_weather_info` VALUES (1916084843394879490, NULL, NULL, '2025-04-26 18:59:59', '2025-04-26 18:59:59', '闵行', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-26 18:56:00', '18', '16', '104', '阴', '90', '东风', '2', 6, '34', '0.0', '1018', '30', '101020200');
INSERT INTO `city_weather_info` VALUES (1916086100843024386, NULL, NULL, '2025-04-26 19:04:59', '2025-04-26 19:04:59', '北京', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-26 19:01:00', '22', '22', '104', '阴', '225', '西南风', '2', 7, '51', '0.0', '1004', '6', '101010100');
INSERT INTO `city_weather_info` VALUES (1916086101497335810, NULL, NULL, '2025-04-26 19:04:59', '2025-04-26 19:04:59', '闵行', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-26 19:00:00', '18', '16', '104', '阴', '135', '东南风', '2', 8, '34', '0.0', '1018', '30', '101020200');
INSERT INTO `city_weather_info` VALUES (1916087359230693378, NULL, NULL, '2025-04-26 19:09:59', '2025-04-26 19:09:59', '北京', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-26 19:01:00', '22', '22', '104', '阴', '225', '西南风', '2', 7, '51', '0.0', '1004', '6', '101010100');
INSERT INTO `city_weather_info` VALUES (1916087359868227585, NULL, NULL, '2025-04-26 19:09:59', '2025-04-26 19:09:59', '闵行', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-26 19:00:00', '18', '16', '104', '阴', '135', '东南风', '2', 8, '34', '0.0', '1018', '30', '101020200');
INSERT INTO `city_weather_info` VALUES (1916088618046181378, NULL, NULL, '2025-04-26 19:14:59', '2025-04-26 19:14:59', '北京', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-26 19:08:00', '22', '22', '104', '阴', '225', '西南风', '2', 7, '51', '0.0', '1004', '6', '101010100');
INSERT INTO `city_weather_info` VALUES (1916088618692104193, NULL, NULL, '2025-04-26 19:14:59', '2025-04-26 19:14:59', '闵行', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-26 19:08:00', '18', '14', '104', '阴', '135', '东南风', '3', 17, '36', '0.0', '1018', '30', '101020200');
INSERT INTO `city_weather_info` VALUES (1916089875725012993, NULL, NULL, '2025-04-26 19:19:59', '2025-04-26 19:19:59', '北京', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-26 19:16:00', '22', '21', '104', '阴', '225', '西南风', '2', 8, '52', '0.0', '1004', '6', '101010100');
INSERT INTO `city_weather_info` VALUES (1916089876379324417, NULL, NULL, '2025-04-26 19:19:59', '2025-04-26 19:19:59', '闵行', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-26 19:16:00', '18', '17', '104', '阴', '90', '东风', '1', 3, '37', '0.0', '1018', '30', '101020200');
INSERT INTO `city_weather_info` VALUES (1916091134020407297, NULL, NULL, '2025-04-26 19:24:59', '2025-04-26 19:24:59', '北京', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-26 19:16:00', '22', '21', '104', '阴', '225', '西南风', '2', 8, '52', '0.0', '1004', '6', '101010100');
INSERT INTO `city_weather_info` VALUES (1916091134804742146, NULL, NULL, '2025-04-26 19:24:59', '2025-04-26 19:24:59', '闵行', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-26 19:16:00', '18', '17', '104', '阴', '90', '东风', '1', 3, '37', '0.0', '1018', '30', '101020200');
INSERT INTO `city_weather_info` VALUES (1916092392382910466, NULL, NULL, '2025-04-26 19:29:59', '2025-04-26 19:29:59', '北京', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-26 19:24:00', '22', '22', '104', '阴', '180', '南风', '2', 8, '53', '0.0', '1004', '6', '101010100');
INSERT INTO `city_weather_info` VALUES (1916092393100136449, NULL, NULL, '2025-04-26 19:29:59', '2025-04-26 19:29:59', '闵行', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-26 19:24:00', '18', '16', '104', '阴', '135', '东南风', '2', 11, '39', '0.0', '1018', '30', '101020200');
INSERT INTO `city_weather_info` VALUES (1916093650636361730, NULL, NULL, '2025-04-26 19:34:59', '2025-04-26 19:34:59', '北京', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-26 19:32:00', '22', '22', '104', '阴', '180', '南风', '2', 8, '54', '0.0', '1004', '6', '101010100');
INSERT INTO `city_weather_info` VALUES (1916093651349393410, NULL, NULL, '2025-04-26 19:34:59', '2025-04-26 19:34:59', '闵行', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-26 19:33:00', '17', '15', '104', '阴', '135', '东南风', '2', 11, '40', '0.0', '1018', '29', '101020200');
INSERT INTO `city_weather_info` VALUES (1916094908973699073, NULL, NULL, '2025-04-26 19:39:59', '2025-04-26 19:39:59', '北京', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-26 19:32:00', '22', '22', '104', '阴', '180', '南风', '2', 8, '54', '0.0', '1004', '6', '101010100');
INSERT INTO `city_weather_info` VALUES (1916094909686730754, NULL, NULL, '2025-04-26 19:39:59', '2025-04-26 19:39:59', '闵行', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-26 19:33:00', '17', '15', '104', '阴', '135', '东南风', '2', 11, '40', '0.0', '1018', '29', '101020200');
INSERT INTO `city_weather_info` VALUES (1916096167201984513, NULL, NULL, '2025-04-26 19:44:59', '2025-04-26 19:44:59', '北京', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-26 19:41:00', '22', '22', '104', '阴', '180', '南风', '2', 6, '55', '0.0', '1004', '6', '101010100');
INSERT INTO `city_weather_info` VALUES (1916096167860490241, NULL, NULL, '2025-04-26 19:44:59', '2025-04-26 19:44:59', '闵行', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-26 19:40:00', '17', '14', '104', '阴', '135', '东南风', '3', 16, '41', '0.0', '1018', '30', '101020200');
INSERT INTO `city_weather_info` VALUES (1916097426038403074, NULL, NULL, '2025-04-26 19:49:59', '2025-04-26 19:49:59', '北京', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-26 19:41:00', '22', '22', '104', '阴', '180', '南风', '2', 6, '55', '0.0', '1004', '6', '101010100');
INSERT INTO `city_weather_info` VALUES (1916097426650771458, NULL, NULL, '2025-04-26 19:49:59', '2025-04-26 19:49:59', '闵行', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-26 19:40:00', '17', '14', '104', '阴', '135', '东南风', '3', 16, '41', '0.0', '1018', '30', '101020200');
INSERT INTO `city_weather_info` VALUES (1916098683545268226, NULL, NULL, '2025-04-26 19:54:59', '2025-04-26 19:54:59', '北京', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-26 19:48:00', '21', '20', '502', '霾', '180', '南风', '2', 11, '56', '0.0', '1004', '6', '101010100');
INSERT INTO `city_weather_info` VALUES (1916098684199579649, NULL, NULL, '2025-04-26 19:54:59', '2025-04-26 19:54:59', '闵行', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-26 19:48:00', '17', '13', '104', '阴', '135', '东南风', '4', 20, '42', '0.0', '1018', '30', '101020200');
INSERT INTO `city_weather_info` VALUES (1916099944260775938, NULL, NULL, '2025-04-26 20:00:00', '2025-04-26 20:00:00', '北京', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-26 19:56:00', '21', '20', '502', '霾', '180', '南风', '2', 10, '56', '0.0', '1004', '6', '101010100');
INSERT INTO `city_weather_info` VALUES (1916099944973807618, NULL, NULL, '2025-04-26 20:00:00', '2025-04-26 20:00:00', '闵行', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-26 19:56:00', '17', '14', '104', '阴', '135', '东南风', '3', 16, '42', '0.0', '1018', '28', '101020200');
INSERT INTO `city_weather_info` VALUES (1916101200790380545, NULL, NULL, '2025-04-26 20:04:59', '2025-04-26 20:04:59', '北京', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-26 20:00:00', '21', '21', '502', '霾', '180', '南风', '2', 7, '56', '0.0', '1004', '6', '101010100');
INSERT INTO `city_weather_info` VALUES (1916101201436303361, NULL, NULL, '2025-04-26 20:04:59', '2025-04-26 20:04:59', '闵行', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-26 20:00:00', '17', '14', '104', '阴', '135', '东南风', '3', 17, '43', '0.0', '1018', '30', '101020200');
INSERT INTO `city_weather_info` VALUES (1916102458641178625, NULL, NULL, '2025-04-26 20:09:59', '2025-04-26 20:09:59', '北京', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-26 20:00:00', '21', '21', '502', '霾', '180', '南风', '2', 7, '56', '0.0', '1004', '6', '101010100');
INSERT INTO `city_weather_info` VALUES (1916102459362598914, NULL, NULL, '2025-04-26 20:09:59', '2025-04-26 20:09:59', '闵行', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-26 20:00:00', '17', '14', '104', '阴', '135', '东南风', '3', 17, '43', '0.0', '1018', '30', '101020200');
INSERT INTO `city_weather_info` VALUES (1916103716898824193, NULL, NULL, '2025-04-26 20:14:59', '2025-04-26 20:14:59', '北京', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-26 20:08:00', '21', '21', '502', '霾', '270', '西风', '1', 5, '57', '0.0', '1004', '6', '101010100');
INSERT INTO `city_weather_info` VALUES (1916103717557329921, NULL, NULL, '2025-04-26 20:14:59', '2025-04-26 20:14:59', '闵行', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-26 20:08:00', '17', '15', '104', '阴', '180', '南风', '2', 7, '44', '0.0', '1019', '30', '101020200');
INSERT INTO `city_weather_info` VALUES (1916104974879645698, NULL, NULL, '2025-04-26 20:19:59', '2025-04-26 20:19:59', '北京', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-26 20:16:00', '21', '21', '502', '霾', '0', '北风', '1', 5, '58', '0.0', '1004', '6', '101010100');
INSERT INTO `city_weather_info` VALUES (1916104974879645699, NULL, NULL, '2025-04-26 20:19:59', '2025-04-26 20:19:59', '闵行', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-26 20:16:00', '17', '14', '104', '阴', '135', '东南风', '3', 14, '45', '0.0', '1019', '30', '101020200');
INSERT INTO `city_weather_info` VALUES (1916106233409921025, NULL, NULL, '2025-04-26 20:24:59', '2025-04-26 20:24:59', '北京', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-26 20:16:00', '21', '21', '502', '霾', '0', '北风', '1', 5, '58', '0.0', '1004', '6', '101010100');
INSERT INTO `city_weather_info` VALUES (1916106234131341313, NULL, NULL, '2025-04-26 20:24:59', '2025-04-26 20:24:59', '闵行', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-26 20:16:00', '17', '14', '104', '阴', '135', '东南风', '3', 14, '45', '0.0', '1019', '30', '101020200');
INSERT INTO `city_weather_info` VALUES (1916107491810172930, NULL, NULL, '2025-04-26 20:29:59', '2025-04-26 20:29:59', '北京', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-26 20:24:00', '21', '22', '502', '霾', '0', '北风', '1', 3, '59', '0.0', '1004', '6', '101010100');
INSERT INTO `city_weather_info` VALUES (1916107492464484353, NULL, NULL, '2025-04-26 20:29:59', '2025-04-26 20:29:59', '闵行', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-26 20:24:00', '17', '15', '104', '阴', '180', '南风', '2', 10, '45', '0.0', '1019', '30', '101020200');
INSERT INTO `city_weather_info` VALUES (1916108750118150145, NULL, NULL, '2025-04-26 20:34:59', '2025-04-26 20:34:59', '北京', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-26 20:32:00', '20', '20', '502', '霾', '315', '西北风', '1', 3, '60', '0.0', '1004', '6', '101010100');
INSERT INTO `city_weather_info` VALUES (1916108750839570433, NULL, NULL, '2025-04-26 20:34:59', '2025-04-26 20:34:59', '闵行', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-26 20:32:00', '17', '15', '104', '阴', '135', '东南风', '2', 9, '47', '0.0', '1019', '30', '101020200');
INSERT INTO `city_weather_info` VALUES (1916110008539373570, NULL, NULL, '2025-04-26 20:39:59', '2025-04-26 20:39:59', '北京', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-26 20:32:00', '20', '20', '502', '霾', '315', '西北风', '1', 3, '60', '0.0', '1004', '6', '101010100');
INSERT INTO `city_weather_info` VALUES (1916110009248210946, NULL, NULL, '2025-04-26 20:39:59', '2025-04-26 20:39:59', '闵行', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-26 20:32:00', '17', '15', '104', '阴', '135', '东南风', '2', 9, '47', '0.0', '1019', '30', '101020200');
INSERT INTO `city_weather_info` VALUES (1916111266750881793, NULL, NULL, '2025-04-26 20:44:59', '2025-04-26 20:44:59', '北京', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-26 20:40:00', '20', '20', '502', '霾', '0', '北风', '1', 5, '61', '0.0', '1004', '6', '101010100');
INSERT INTO `city_weather_info` VALUES (1916111267531022338, NULL, NULL, '2025-04-26 20:44:59', '2025-04-26 20:44:59', '闵行', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-26 20:40:00', '17', '14', '104', '阴', '135', '东南风', '3', 13, '48', '0.0', '1019', '30', '101020200');
INSERT INTO `city_weather_info` VALUES (1916112524836560897, NULL, NULL, '2025-04-26 20:49:59', '2025-04-26 20:49:59', '北京', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-26 20:40:00', '20', '20', '502', '霾', '0', '北风', '1', 5, '61', '0.0', '1004', '6', '101010100');
INSERT INTO `city_weather_info` VALUES (1916112525549592578, NULL, NULL, '2025-04-26 20:49:59', '2025-04-26 20:49:59', '闵行', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-26 20:40:00', '17', '14', '104', '阴', '135', '东南风', '3', 13, '48', '0.0', '1019', '30', '101020200');
INSERT INTO `city_weather_info` VALUES (1916113782934822914, NULL, NULL, '2025-04-26 20:54:59', '2025-04-26 20:54:59', '北京', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-26 20:48:00', '20', '21', '502', '霾', '45', '东北风', '1', 2, '62', '0.0', '1004', '5', '101010100');
INSERT INTO `city_weather_info` VALUES (1916113783584940033, NULL, NULL, '2025-04-26 20:54:59', '2025-04-26 20:54:59', '闵行', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-26 20:48:00', '17', '15', '104', '阴', '90', '东风', '2', 8, '49', '0.0', '1019', '30', '101020200');
INSERT INTO `city_weather_info` VALUES (1916115041557372930, NULL, NULL, '2025-04-26 20:59:59', '2025-04-26 20:59:59', '北京', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-26 20:56:00', '20', '21', '502', '霾', '0', '北风', '0', 0, '63', '0.0', '1004', '5', '101010100');
INSERT INTO `city_weather_info` VALUES (1916115042278793218, NULL, NULL, '2025-04-26 20:59:59', '2025-04-26 20:59:59', '闵行', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-26 20:56:00', '17', '15', '104', '阴', '90', '东风', '2', 10, '50', '0.0', '1019', '30', '101020200');
INSERT INTO `city_weather_info` VALUES (1916116299546583042, NULL, NULL, '2025-04-26 21:04:59', '2025-04-26 21:04:59', '北京', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-26 21:01:00', '20', '21', '502', '霾', '0', '北风', '0', 0, '64', '0.0', '1004', '6', '101010100');
INSERT INTO `city_weather_info` VALUES (1916116300070871042, NULL, NULL, '2025-04-26 21:04:59', '2025-04-26 21:04:59', '闵行', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-26 21:01:00', '17', '16', '104', '阴', '180', '南风', '2', 8, '51', '0.0', '1019', '29', '101020200');
INSERT INTO `city_weather_info` VALUES (1916117558013943809, NULL, NULL, '2025-04-26 21:09:59', '2025-04-26 21:09:59', '北京', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-26 21:01:00', '20', '21', '502', '霾', '0', '北风', '0', 0, '64', '0.0', '1004', '6', '101010100');
INSERT INTO `city_weather_info` VALUES (1916117558588563457, NULL, NULL, '2025-04-26 21:09:59', '2025-04-26 21:09:59', '闵行', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-26 21:01:00', '17', '16', '104', '阴', '180', '南风', '2', 8, '51', '0.0', '1019', '29', '101020200');
INSERT INTO `city_weather_info` VALUES (1916118816376446978, NULL, NULL, '2025-04-26 21:14:59', '2025-04-26 21:14:59', '北京', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-26 21:08:00', '19', '20', '502', '霾', '0', '北风', '0', 1, '64', '0.0', '1005', '5', '101010100');
INSERT INTO `city_weather_info` VALUES (1916118816904929282, NULL, NULL, '2025-04-26 21:14:59', '2025-04-26 21:14:59', '闵行', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-26 21:08:00', '17', '15', '104', '阴', '135', '东南风', '3', 12, '52', '0.0', '1019', '30', '101020200');
INSERT INTO `city_weather_info` VALUES (1916120075309375489, NULL, NULL, '2025-04-26 21:19:59', '2025-04-26 21:19:59', '北京', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-26 21:16:00', '19', '20', '502', '霾', '225', '西南风', '1', 2, '65', '0.0', '1005', '5', '101010100');
INSERT INTO `city_weather_info` VALUES (1916120075825274882, NULL, NULL, '2025-04-26 21:19:59', '2025-04-26 21:19:59', '闵行', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-26 21:16:00', '16', '13', '104', '阴', '135', '东南风', '3', 14, '54', '0.0', '1019', '30', '101020200');
INSERT INTO `city_weather_info` VALUES (1916121332916903938, NULL, NULL, '2025-04-26 21:24:59', '2025-04-26 21:24:59', '北京', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-26 21:16:00', '19', '20', '502', '霾', '225', '西南风', '1', 2, '65', '0.0', '1005', '5', '101010100');
INSERT INTO `city_weather_info` VALUES (1916121333571215361, NULL, NULL, '2025-04-26 21:24:59', '2025-04-26 21:24:59', '闵行', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-26 21:16:00', '16', '13', '104', '阴', '135', '东南风', '3', 14, '54', '0.0', '1019', '30', '101020200');
INSERT INTO `city_weather_info` VALUES (1916122591010971649, NULL, NULL, '2025-04-26 21:29:59', '2025-04-26 21:29:59', '北京', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-26 21:25:00', '19', '20', '502', '霾', '180', '南风', '1', 2, '66', '0.0', '1005', '5', '101010100');
INSERT INTO `city_weather_info` VALUES (1916122591606562817, NULL, NULL, '2025-04-26 21:29:59', '2025-04-26 21:29:59', '闵行', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-26 21:25:00', '16', '14', '104', '阴', '135', '东南风', '3', 12, '55', '0.0', '1019', '30', '101020200');
INSERT INTO `city_weather_info` VALUES (1916123849415417858, NULL, NULL, '2025-04-26 21:34:59', '2025-04-26 21:34:59', '北京', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-26 21:32:00', '19', '19', '502', '霾', '180', '南风', '1', 3, '66', '0.0', '1005', '5', '101010100');
INSERT INTO `city_weather_info` VALUES (1916123849998426114, NULL, NULL, '2025-04-26 21:34:59', '2025-04-26 21:34:59', '闵行', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-26 21:32:00', '16', '13', '104', '阴', '135', '东南风', '3', 16, '55', '0.0', '1019', '29', '101020200');
INSERT INTO `city_weather_info` VALUES (1916125108314791937, NULL, NULL, '2025-04-26 21:39:59', '2025-04-26 21:39:59', '北京', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-26 21:32:00', '19', '19', '502', '霾', '180', '南风', '1', 3, '66', '0.0', '1005', '5', '101010100');
INSERT INTO `city_weather_info` VALUES (1916125108956520449, NULL, NULL, '2025-04-26 21:39:59', '2025-04-26 21:39:59', '闵行', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-26 21:32:00', '16', '13', '104', '阴', '135', '东南风', '3', 16, '55', '0.0', '1019', '29', '101020200');
INSERT INTO `city_weather_info` VALUES (1916126366002012161, NULL, NULL, '2025-04-26 21:44:59', '2025-04-26 21:44:59', '北京', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-26 21:40:00', '19', '18', '502', '霾', '180', '南风', '2', 11, '63', '0.0', '1005', '5', '101010100');
INSERT INTO `city_weather_info` VALUES (1916126366589214722, NULL, NULL, '2025-04-26 21:44:59', '2025-04-26 21:44:59', '闵行', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-26 21:40:00', '16', '13', '104', '阴', '135', '东南风', '3', 16, '56', '0.0', '1019', '28', '101020200');
INSERT INTO `city_weather_info` VALUES (1916127624402264066, NULL, NULL, '2025-04-26 21:49:59', '2025-04-26 21:49:59', '北京', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-26 21:40:00', '19', '18', '502', '霾', '180', '南风', '2', 11, '63', '0.0', '1005', '5', '101010100');
INSERT INTO `city_weather_info` VALUES (1916127624997855234, NULL, NULL, '2025-04-26 21:49:59', '2025-04-26 21:49:59', '闵行', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-26 21:40:00', '16', '13', '104', '阴', '135', '东南风', '3', 16, '56', '0.0', '1019', '28', '101020200');
INSERT INTO `city_weather_info` VALUES (1916128882798272514, NULL, NULL, '2025-04-26 21:54:59', '2025-04-26 21:54:59', '北京', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-26 21:48:00', '19', '19', '502', '霾', '315', '西北风', '1', 5, '60', '0.0', '1005', '5', '101010100');
INSERT INTO `city_weather_info` VALUES (1916128883645521922, NULL, NULL, '2025-04-26 21:54:59', '2025-04-26 21:54:59', '闵行', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-26 21:48:00', '16', '14', '104', '阴', '135', '东南风', '3', 12, '57', '0.0', '1019', '30', '101020200');
INSERT INTO `city_weather_info` VALUES (1916130141164969985, NULL, NULL, '2025-04-26 21:59:59', '2025-04-26 21:59:59', '北京', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-26 21:56:00', '20', '21', '502', '霾', '135', '东南风', '0', 1, '58', '0.0', '1005', '5', '101010100');
INSERT INTO `city_weather_info` VALUES (1916130141949304833, NULL, NULL, '2025-04-26 21:59:59', '2025-04-26 21:59:59', '闵行', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-26 21:56:00', '16', '13', '104', '阴', '90', '东风', '3', 14, '57', '0.0', '1019', '30', '101020200');
INSERT INTO `city_weather_info` VALUES (1916131399414226946, NULL, NULL, '2025-04-26 22:04:59', '2025-04-26 22:04:59', '北京', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-26 22:00:00', '19', '19', '502', '霾', '270', '西风', '1', 4, '59', '0.0', '1005', '5', '101010100');
INSERT INTO `city_weather_info` VALUES (1916131400206950402, NULL, NULL, '2025-04-26 22:04:59', '2025-04-26 22:04:59', '闵行', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-26 22:00:00', '16', '14', '104', '阴', '135', '东南风', '2', 9, '58', '0.0', '1019', '30', '101020200');
INSERT INTO `city_weather_info` VALUES (1916132658045165570, NULL, NULL, '2025-04-26 22:09:59', '2025-04-26 22:09:59', '北京', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-26 22:00:00', '19', '19', '502', '霾', '270', '西风', '1', 4, '59', '0.0', '1005', '5', '101010100');
INSERT INTO `city_weather_info` VALUES (1916132658766585857, NULL, NULL, '2025-04-26 22:09:59', '2025-04-26 22:09:59', '闵行', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-26 22:00:00', '16', '14', '104', '阴', '135', '东南风', '2', 9, '58', '0.0', '1019', '30', '101020200');
INSERT INTO `city_weather_info` VALUES (1916133917015912449, NULL, NULL, '2025-04-26 22:14:59', '2025-04-26 22:14:59', '北京', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-26 22:10:00', '19', '19', '502', '霾', '315', '西北风', '1', 2, '60', '0.0', '1006', '5', '101010100');
INSERT INTO `city_weather_info` VALUES (1916133917678612481, NULL, NULL, '2025-04-26 22:14:59', '2025-04-26 22:14:59', '闵行', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-26 22:10:00', '16', '15', '104', '阴', '45', '东北风', '2', 8, '58', '0.0', '1019', '29', '101020200');
INSERT INTO `city_weather_info` VALUES (1916140211533750273, NULL, NULL, '2025-04-26 22:40:01', '2025-04-26 22:40:01', '北京', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-26 22:32:00', '19', '19', '502', '霾', '225', '西南风', '1', 4, '62', '0.0', '1006', '4', '101010100');
INSERT INTO `city_weather_info` VALUES (1916140212511023105, NULL, NULL, '2025-04-26 22:40:01', '2025-04-26 22:40:01', '闵行', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-26 22:32:00', '16', '14', '104', '阴', '90', '东风', '3', 12, '59', '0.0', '1019', '30', '101020200');
INSERT INTO `city_weather_info` VALUES (1916141469426491394, NULL, NULL, '2025-04-26 22:45:01', '2025-04-26 22:45:01', '北京', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-26 22:40:00', '18', '18', '502', '霾', '315', '西北风', '1', 3, '62', '0.0', '1006', '5', '101010100');
INSERT INTO `city_weather_info` VALUES (1916141470496038914, NULL, NULL, '2025-04-26 22:45:01', '2025-04-26 22:45:01', '闵行', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-26 22:40:00', '16', '14', '104', '阴', '135', '东南风', '2', 9, '59', '0.0', '1019', '30', '101020200');
INSERT INTO `city_weather_info` VALUES (1916142728044847106, NULL, NULL, '2025-04-26 22:50:01', '2025-04-26 22:50:01', '北京', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-26 22:40:00', '18', '18', '502', '霾', '315', '西北风', '1', 3, '62', '0.0', '1006', '5', '101010100');
INSERT INTO `city_weather_info` VALUES (1916142729080840194, NULL, NULL, '2025-04-26 22:50:01', '2025-04-26 22:50:01', '闵行', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-26 22:40:00', '16', '14', '104', '阴', '135', '东南风', '2', 9, '59', '0.0', '1019', '30', '101020200');
INSERT INTO `city_weather_info` VALUES (1916143983668469762, NULL, NULL, '2025-04-26 22:55:00', '2025-04-26 22:55:00', '北京', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-26 22:48:00', '19', '19', '104', '阴', '0', '北风', '1', 4, '61', '0.0', '1006', '4', '101010100');
INSERT INTO `city_weather_info` VALUES (1916143985316831233, NULL, NULL, '2025-04-26 22:55:01', '2025-04-26 22:55:01', '闵行', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-26 22:48:00', '16', '14', '104', '阴', '90', '东风', '2', 10, '60', '0.0', '1019', '29', '101020200');
INSERT INTO `city_weather_info` VALUES (1916145241317941249, NULL, NULL, '2025-04-26 23:00:00', '2025-04-26 23:00:00', '北京', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-26 22:56:00', '19', '19', '104', '阴', '270', '西风', '1', 2, '62', '0.0', '1006', '4', '101010100');
INSERT INTO `city_weather_info` VALUES (1916145242425237506, NULL, NULL, '2025-04-26 23:00:00', '2025-04-26 23:00:00', '闵行', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-26 22:57:00', '16', '16', '104', '阴', '135', '东南风', '1', 3, '60', '0.0', '1019', '28', '101020200');
INSERT INTO `city_weather_info` VALUES (1916146504122200066, NULL, NULL, '2025-04-26 23:05:01', '2025-04-26 23:05:01', '北京', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-26 22:59:00', '18', '18', '104', '阴', '90', '东风', '1', 2, '62', '0.0', '1006', '4', '101010100');
INSERT INTO `city_weather_info` VALUES (1916146505250467841, NULL, NULL, '2025-04-26 23:05:01', '2025-04-26 23:05:01', '闵行', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-26 23:00:00', '16', '15', '104', '阴', '90', '东风', '2', 6, '60', '0.0', '1019', '30', '101020200');
INSERT INTO `city_weather_info` VALUES (1916147761582940161, NULL, NULL, '2025-04-26 23:10:01', '2025-04-26 23:10:01', '北京', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-26 22:59:00', '18', '18', '104', '阴', '90', '东风', '1', 2, '62', '0.0', '1006', '4', '101010100');
INSERT INTO `city_weather_info` VALUES (1916147762543435778, NULL, NULL, '2025-04-26 23:10:01', '2025-04-26 23:10:01', '闵行', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-26 23:00:00', '16', '15', '104', '阴', '90', '东风', '2', 6, '60', '0.0', '1019', '30', '101020200');
INSERT INTO `city_weather_info` VALUES (1916149015847608321, NULL, NULL, '2025-04-26 23:15:00', '2025-04-26 23:15:00', '北京', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-26 23:08:00', '18', '18', '104', '阴', '315', '西北风', '1', 3, '62', '0.0', '1006', '4', '101010100');
INSERT INTO `city_weather_info` VALUES (1916149016816492546, NULL, NULL, '2025-04-26 23:15:00', '2025-04-26 23:15:00', '闵行', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-26 23:09:00', '16', '15', '104', '阴', '135', '东南风', '1', 5, '59', '0.0', '1019', '30', '101020200');
INSERT INTO `city_weather_info` VALUES (1916150274063310850, NULL, NULL, '2025-04-26 23:20:00', '2025-04-26 23:20:00', '北京', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-26 23:17:00', '18', '18', '104', '阴', '315', '西北风', '1', 4, '63', '0.0', '1006', '4', '101010100');
INSERT INTO `city_weather_info` VALUES (1916150275053166593, NULL, NULL, '2025-04-26 23:20:00', '2025-04-26 23:20:00', '闵行', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-26 23:16:00', '16', '15', '104', '阴', '90', '东风', '1', 4, '59', '0.0', '1019', '30', '101020200');
INSERT INTO `city_weather_info` VALUES (1916151532505505794, NULL, NULL, '2025-04-26 23:25:00', '2025-04-26 23:25:00', '北京', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-26 23:17:00', '18', '18', '104', '阴', '315', '西北风', '1', 4, '63', '0.0', '1006', '4', '101010100');
INSERT INTO `city_weather_info` VALUES (1916151533432446978, NULL, NULL, '2025-04-26 23:25:00', '2025-04-26 23:25:00', '闵行', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-26 23:16:00', '16', '15', '104', '阴', '90', '东风', '1', 4, '59', '0.0', '1019', '30', '101020200');
INSERT INTO `city_weather_info` VALUES (1916152791136444417, NULL, NULL, '2025-04-26 23:30:00', '2025-04-26 23:30:00', '北京', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-26 23:24:00', '18', '18', '104', '阴', '315', '西北风', '1', 3, '63', '0.0', '1006', '4', '101010100');
INSERT INTO `city_weather_info` VALUES (1916152792256323586, NULL, NULL, '2025-04-26 23:30:00', '2025-04-26 23:30:00', '闵行', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-26 23:24:00', '16', '14', '104', '阴', '135', '东南风', '2', 9, '59', '0.0', '1019', '30', '101020200');
INSERT INTO `city_weather_info` VALUES (1916154049314398209, NULL, NULL, '2025-04-26 23:35:00', '2025-04-26 23:35:00', '北京', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-26 23:24:00', '18', '18', '104', '阴', '315', '西北风', '1', 3, '63', '0.0', '1006', '4', '101010100');
INSERT INTO `city_weather_info` VALUES (1916154050211979265, NULL, NULL, '2025-04-26 23:35:00', '2025-04-26 23:35:00', '闵行', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-26 23:24:00', '16', '14', '104', '阴', '135', '东南风', '2', 9, '59', '0.0', '1019', '30', '101020200');
INSERT INTO `city_weather_info` VALUES (1916282395972993026, NULL, NULL, '2025-04-27 08:05:00', '2025-04-27 08:05:00', '北京', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-27 08:00:00', '16', '10', '100', '晴', '45', '东北风', '4', 25, '22', '0.0', '1013', '30', '101010100');
INSERT INTO `city_weather_info` VALUES (1916282396933488641, NULL, NULL, '2025-04-27 08:05:00', '2025-04-27 08:05:00', '闵行', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-27 08:00:00', '17', '15', '104', '阴', '135', '东南风', '3', 16, '71', '0.0', '1015', '22', '101020200');
INSERT INTO `city_weather_info` VALUES (1916283653337251841, NULL, NULL, '2025-04-27 08:10:00', '2025-04-27 08:10:00', '北京', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-27 08:00:00', '16', '10', '100', '晴', '45', '东北风', '4', 25, '22', '0.0', '1013', '30', '101010100');
INSERT INTO `city_weather_info` VALUES (1916283654587154434, NULL, NULL, '2025-04-27 08:10:00', '2025-04-27 08:10:00', '闵行', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-27 08:00:00', '17', '15', '104', '阴', '135', '东南风', '3', 16, '71', '0.0', '1015', '22', '101020200');
INSERT INTO `city_weather_info` VALUES (1916284910865186817, NULL, NULL, '2025-04-27 08:14:59', '2025-04-27 08:14:59', '北京', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-27 08:08:00', '16', '11', '100', '晴', '45', '东北风', '4', 20, '22', '0.0', '1014', '30', '101010100');
INSERT INTO `city_weather_info` VALUES (1916284911892791298, NULL, NULL, '2025-04-27 08:15:00', '2025-04-27 08:15:00', '闵行', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-27 08:08:00', '17', '14', '104', '阴', '180', '南风', '4', 22, '70', '0.0', '1015', '25', '101020200');
INSERT INTO `city_weather_info` VALUES (1916286169961693185, NULL, NULL, '2025-04-27 08:19:59', '2025-04-27 08:19:59', '北京', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-27 08:16:00', '16', '9', '100', '晴', '45', '东北风', '5', 32, '22', '0.0', '1014', '30', '101010100');
INSERT INTO `city_weather_info` VALUES (1916286170947354625, NULL, NULL, '2025-04-27 08:20:00', '2025-04-27 08:20:00', '闵行', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-27 08:16:00', '17', '15', '104', '阴', '180', '南风', '3', 17, '70', '0.0', '1015', '24', '101020200');
INSERT INTO `city_weather_info` VALUES (1916287428324155394, NULL, NULL, '2025-04-27 08:25:00', '2025-04-27 08:25:00', '北京', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-27 08:16:00', '16', '9', '100', '晴', '45', '东北风', '5', 32, '22', '0.0', '1014', '30', '101010100');
INSERT INTO `city_weather_info` VALUES (1916287429326594050, NULL, NULL, '2025-04-27 08:25:00', '2025-04-27 08:25:00', '闵行', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-27 08:16:00', '17', '15', '104', '阴', '180', '南风', '3', 17, '70', '0.0', '1015', '24', '101020200');
INSERT INTO `city_weather_info` VALUES (1916288686061707265, NULL, NULL, '2025-04-27 08:29:59', '2025-04-27 08:29:59', '北京', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-27 08:24:00', '16', '11', '100', '晴', '45', '东北风', '4', 20, '22', '0.0', '1014', '30', '101010100');
INSERT INTO `city_weather_info` VALUES (1916288687047368705, NULL, NULL, '2025-04-27 08:30:00', '2025-04-27 08:30:00', '闵行', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-27 08:24:00', '17', '16', '104', '阴', '180', '南风', '2', 11, '70', '0.0', '1015', '21', '101020200');
INSERT INTO `city_weather_info` VALUES (1916289944717811713, NULL, NULL, '2025-04-27 08:34:59', '2025-04-27 08:34:59', '北京', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-27 08:32:00', '16', '12', '100', '晴', '315', '西北风', '3', 17, '22', '0.0', '1014', '30', '101010100');
INSERT INTO `city_weather_info` VALUES (1916289945632169986, NULL, NULL, '2025-04-27 08:35:00', '2025-04-27 08:35:00', '闵行', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-27 08:32:00', '17', '15', '104', '阴', '180', '南风', '3', 16, '70', '0.0', '1015', '19', '101020200');
INSERT INTO `city_weather_info` VALUES (1916291207849238530, NULL, NULL, '2025-04-27 08:40:01', '2025-04-27 08:40:01', '北京', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-27 08:32:00', '16', '12', '100', '晴', '315', '西北风', '3', 17, '22', '0.0', '1014', '30', '101010100');
INSERT INTO `city_weather_info` VALUES (1916291212710436866, NULL, NULL, '2025-04-27 08:40:02', '2025-04-27 08:40:02', '闵行', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-27 08:32:00', '17', '15', '104', '阴', '180', '南风', '3', 16, '70', '0.0', '1015', '19', '101020200');
INSERT INTO `city_weather_info` VALUES (1916292466790555649, NULL, NULL, '2025-04-27 08:45:01', '2025-04-27 08:45:01', '北京', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-27 08:41:00', '16', '11', '100', '晴', '0', '北风', '3', 18, '22', '0.0', '1014', '30', '101010100');
INSERT INTO `city_weather_info` VALUES (1916292472276705281, NULL, NULL, '2025-04-27 08:45:02', '2025-04-27 08:45:02', '闵行', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-27 08:41:00', '17', '16', '104', '阴', '135', '东南风', '2', 10, '71', '0.0', '1015', '21', '101020200');
INSERT INTO `city_weather_info` VALUES (1916293725727678466, NULL, NULL, '2025-04-27 08:50:01', '2025-04-27 08:50:01', '北京', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-27 08:41:00', '16', '11', '100', '晴', '0', '北风', '3', 18, '22', '0.0', '1014', '30', '101010100');
INSERT INTO `city_weather_info` VALUES (1916293729573855234, NULL, NULL, '2025-04-27 08:50:02', '2025-04-27 08:50:02', '闵行', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-27 08:41:00', '17', '16', '104', '阴', '135', '东南风', '2', 10, '71', '0.0', '1015', '21', '101020200');
INSERT INTO `city_weather_info` VALUES (1916294984799019010, NULL, NULL, '2025-04-27 08:55:01', '2025-04-27 08:55:01', '北京', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-27 08:49:00', '16', '11', '100', '晴', '0', '北风', '4', 23, '21', '0.0', '1014', '30', '101010100');
INSERT INTO `city_weather_info` VALUES (1916294989261758465, NULL, NULL, '2025-04-27 08:55:03', '2025-04-27 08:55:03', '闵行', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-27 08:48:00', '17', '14', '104', '阴', '135', '东南风', '4', 20, '70', '0.0', '1015', '25', '101020200');
INSERT INTO `city_weather_info` VALUES (1916296241232142338, NULL, NULL, '2025-04-27 09:00:01', '2025-04-27 09:00:01', '北京', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-27 08:56:00', '16', '11', '100', '晴', '45', '东北风', '4', 23, '21', '0.0', '1014', '30', '101010100');
INSERT INTO `city_weather_info` VALUES (1916296244247846914, NULL, NULL, '2025-04-27 09:00:01', '2025-04-27 09:00:01', '闵行', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-27 08:56:00', '17', '16', '104', '阴', '180', '南风', '2', 8, '70', '0.0', '1015', '23', '101020200');
INSERT INTO `city_weather_info` VALUES (1916297499514953729, NULL, NULL, '2025-04-27 09:05:01', '2025-04-27 09:05:01', '北京', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-27 09:00:00', '16', '11', '100', '晴', '45', '东北风', '3', 19, '20', '0.0', '1014', '30', '101010100');
INSERT INTO `city_weather_info` VALUES (1916297502140588034, NULL, NULL, '2025-04-27 09:05:02', '2025-04-27 09:05:02', '闵行', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-27 09:00:00', '17', '16', '104', '阴', '135', '东南风', '2', 11, '70', '0.0', '1015', '20', '101020200');
INSERT INTO `city_weather_info` VALUES (1916298755566395393, NULL, NULL, '2025-04-27 09:10:00', '2025-04-27 09:10:00', '北京', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-27 09:00:00', '16', '11', '100', '晴', '45', '东北风', '3', 19, '20', '0.0', '1014', '30', '101010100');
INSERT INTO `city_weather_info` VALUES (1916298758510796802, NULL, NULL, '2025-04-27 09:10:01', '2025-04-27 09:10:01', '闵行', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-27 09:00:00', '17', '16', '104', '阴', '135', '东南风', '2', 11, '70', '0.0', '1015', '20', '101020200');
INSERT INTO `city_weather_info` VALUES (1916300011466842113, NULL, NULL, '2025-04-27 09:15:00', '2025-04-27 09:15:00', '北京', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-27 09:08:00', '17', '12', '100', '晴', '45', '东北风', '4', 20, '21', '0.0', '1015', '30', '101010100');
INSERT INTO `city_weather_info` VALUES (1916300012658024449, NULL, NULL, '2025-04-27 09:15:00', '2025-04-27 09:15:00', '闵行', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-27 09:08:00', '17', '15', '104', '阴', '135', '东南风', '3', 14, '69', '0.0', '1015', '26', '101020200');
INSERT INTO `city_weather_info` VALUES (1916301274191458306, NULL, NULL, '2025-04-27 09:20:01', '2025-04-27 09:20:01', '北京', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-27 09:16:00', '17', '11', '100', '晴', '45', '东北风', '4', 25, '21', '0.0', '1015', '28', '101010100');
INSERT INTO `city_weather_info` VALUES (1916301275453943810, NULL, NULL, '2025-04-27 09:20:01', '2025-04-27 09:20:01', '闵行', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-27 09:16:00', '17', '14', '104', '阴', '180', '南风', '3', 18, '69', '0.0', '1015', '27', '101020200');
INSERT INTO `city_weather_info` VALUES (1916302528611307522, NULL, NULL, '2025-04-27 09:25:00', '2025-04-27 09:25:00', '北京', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-27 09:16:00', '17', '11', '100', '晴', '45', '东北风', '4', 25, '21', '0.0', '1015', '28', '101010100');
INSERT INTO `city_weather_info` VALUES (1916302529471139842, NULL, NULL, '2025-04-27 09:25:00', '2025-04-27 09:25:00', '闵行', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-27 09:16:00', '17', '14', '104', '阴', '180', '南风', '3', 18, '69', '0.0', '1015', '27', '101020200');
INSERT INTO `city_weather_info` VALUES (1916303792120238082, NULL, NULL, '2025-04-27 09:30:01', '2025-04-27 09:30:01', '北京', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-27 09:24:00', '17', '12', '100', '晴', '0', '北风', '4', 21, '20', '0.0', '1015', '27', '101010100');
INSERT INTO `city_weather_info` VALUES (1916303793554690050, NULL, NULL, '2025-04-27 09:30:01', '2025-04-27 09:30:01', '闵行', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-27 09:24:00', '17', '15', '104', '阴', '135', '东南风', '3', 17, '68', '0.0', '1015', '30', '101020200');
INSERT INTO `city_weather_info` VALUES (1916305044203868162, NULL, NULL, '2025-04-27 09:34:59', '2025-04-27 09:34:59', '北京', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-27 09:30:00', '17', '12', '100', '晴', '45', '东北风', '4', 21, '19', '0.0', '1015', '30', '101010100');
INSERT INTO `city_weather_info` VALUES (1916305045449576449, NULL, NULL, '2025-04-27 09:35:00', '2025-04-27 09:35:00', '闵行', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-27 09:30:00', '18', '16', '104', '阴', '180', '南风', '3', 18, '68', '0.0', '1015', '30', '101020200');
INSERT INTO `city_weather_info` VALUES (1916306302805446657, NULL, NULL, '2025-04-27 09:39:59', '2025-04-27 09:39:59', '北京', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-27 09:30:00', '17', '12', '100', '晴', '45', '东北风', '4', 21, '19', '0.0', '1015', '30', '101010100');
INSERT INTO `city_weather_info` VALUES (1916306303786913794, NULL, NULL, '2025-04-27 09:40:00', '2025-04-27 09:40:00', '闵行', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-27 09:30:00', '18', '16', '104', '阴', '180', '南风', '3', 18, '68', '0.0', '1015', '30', '101020200');
INSERT INTO `city_weather_info` VALUES (1916307561763438594, NULL, NULL, '2025-04-27 09:45:00', '2025-04-27 09:45:00', '北京', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-27 09:41:00', '17', '12', '100', '晴', '45', '东北风', '4', 21, '20', '0.0', '1015', '26', '101010100');
INSERT INTO `city_weather_info` VALUES (1916307562661019650, NULL, NULL, '2025-04-27 09:45:00', '2025-04-27 09:45:00', '闵行', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-27 09:41:00', '18', '15', '104', '阴', '180', '南风', '4', 20, '69', '0.0', '1015', '20', '101020200');
INSERT INTO `city_weather_info` VALUES (1916308819253526530, NULL, NULL, '2025-04-27 09:49:59', '2025-04-27 09:49:59', '北京', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-27 09:41:00', '17', '12', '100', '晴', '45', '东北风', '4', 21, '20', '0.0', '1015', '26', '101010100');
INSERT INTO `city_weather_info` VALUES (1916308820306296833, NULL, NULL, '2025-04-27 09:50:00', '2025-04-27 09:50:00', '闵行', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-27 09:41:00', '18', '15', '104', '阴', '180', '南风', '4', 20, '69', '0.0', '1015', '20', '101020200');
INSERT INTO `city_weather_info` VALUES (1916310078438113281, NULL, NULL, '2025-04-27 09:55:00', '2025-04-27 09:55:00', '北京', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-27 09:48:00', '17', '13', '100', '晴', '45', '东北风', '3', 14, '19', '0.0', '1015', '29', '101010100');
INSERT INTO `city_weather_info` VALUES (1916310079306334209, NULL, NULL, '2025-04-27 09:55:00', '2025-04-27 09:55:00', '闵行', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-27 09:48:00', '18', '17', '104', '阴', '180', '南风', '2', 10, '69', '0.0', '1015', '30', '101020200');
INSERT INTO `city_weather_info` VALUES (1916311336058224642, NULL, NULL, '2025-04-27 10:00:00', '2025-04-27 10:00:00', '北京', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-27 09:56:00', '17', '13', '100', '晴', '45', '东北风', '3', 17, '19', '0.0', '1015', '30', '101010100');
INSERT INTO `city_weather_info` VALUES (1916311338847436801, NULL, NULL, '2025-04-27 10:00:00', '2025-04-27 10:00:00', '闵行', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-27 09:56:00', '18', '16', '104', '阴', '180', '南风', '3', 18, '69', '0.0', '1015', '18', '101020200');
INSERT INTO `city_weather_info` VALUES (1916312595314216961, NULL, NULL, '2025-04-27 10:05:00', '2025-04-27 10:05:00', '北京', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-27 10:00:00', '17', '11', '100', '晴', '45', '东北风', '4', 25, '19', '0.0', '1015', '30', '101010100');
INSERT INTO `city_weather_info` VALUES (1916312596366987266, NULL, NULL, '2025-04-27 10:05:00', '2025-04-27 10:05:00', '闵行', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-27 10:00:00', '17', '17', '104', '阴', '180', '南风', '2', 6, '70', '0.0', '1015', '22', '101020200');
INSERT INTO `city_weather_info` VALUES (1916313852842053634, NULL, NULL, '2025-04-27 10:09:59', '2025-04-27 10:09:59', '北京', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-27 10:00:00', '17', '11', '100', '晴', '45', '东北风', '4', 25, '19', '0.0', '1015', '30', '101010100');
INSERT INTO `city_weather_info` VALUES (1916313853831909378, NULL, NULL, '2025-04-27 10:10:00', '2025-04-27 10:10:00', '闵行', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-27 10:00:00', '17', '17', '104', '阴', '180', '南风', '2', 6, '70', '0.0', '1015', '22', '101020200');
INSERT INTO `city_weather_info` VALUES (1916315110684463106, NULL, NULL, '2025-04-27 10:14:59', '2025-04-27 10:14:59', '北京', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-27 10:09:00', '17', '12', '100', '晴', '45', '东北风', '4', 20, '18', '0.0', '1016', '30', '101010100');
INSERT INTO `city_weather_info` VALUES (1916315111938560001, NULL, NULL, '2025-04-27 10:15:00', '2025-04-27 10:15:00', '闵行', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-27 10:08:00', '17', '16', '104', '阴', '135', '东南风', '2', 9, '70', '0.0', '1014', '25', '101020200');
INSERT INTO `city_weather_info` VALUES (1916316370032627714, NULL, NULL, '2025-04-27 10:20:00', '2025-04-27 10:20:00', '北京', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-27 10:16:00', '17', '12', '100', '晴', '90', '东风', '4', 23, '18', '0.0', '1016', '30', '101010100');
INSERT INTO `city_weather_info` VALUES (1916316371093786625, NULL, NULL, '2025-04-27 10:20:00', '2025-04-27 10:20:00', '闵行', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-27 10:16:00', '17', '16', '104', '阴', '135', '东南风', '2', 7, '71', '0.0', '1014', '22', '101020200');
INSERT INTO `city_weather_info` VALUES (1916317627258474497, NULL, NULL, '2025-04-27 10:24:59', '2025-04-27 10:24:59', '北京', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-27 10:16:00', '17', '12', '100', '晴', '90', '东风', '4', 23, '18', '0.0', '1016', '30', '101010100');
INSERT INTO `city_weather_info` VALUES (1916317628382547969, NULL, NULL, '2025-04-27 10:25:00', '2025-04-27 10:25:00', '闵行', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-27 10:16:00', '17', '16', '104', '阴', '135', '东南风', '2', 7, '71', '0.0', '1014', '22', '101020200');
INSERT INTO `city_weather_info` VALUES (1916318886082351106, NULL, NULL, '2025-04-27 10:29:59', '2025-04-27 10:29:59', '北京', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-27 10:24:00', '18', '13', '100', '晴', '45', '东北风', '4', 22, '17', '0.0', '1016', '30', '101010100');
INSERT INTO `city_weather_info` VALUES (1916318887344836610, NULL, NULL, '2025-04-27 10:30:00', '2025-04-27 10:30:00', '闵行', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-27 10:24:00', '17', '15', '104', '阴', '180', '南风', '3', 18, '72', '0.0', '1014', '25', '101020200');
INSERT INTO `city_weather_info` VALUES (1916320146328096770, NULL, NULL, '2025-04-27 10:35:00', '2025-04-27 10:35:00', '北京', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-27 10:24:00', '18', '13', '100', '晴', '45', '东北风', '4', 22, '17', '0.0', '1016', '30', '101010100');
INSERT INTO `city_weather_info` VALUES (1916320147330535425, NULL, NULL, '2025-04-27 10:35:00', '2025-04-27 10:35:00', '闵行', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-27 10:24:00', '17', '15', '104', '阴', '180', '南风', '3', 18, '72', '0.0', '1014', '25', '101020200');
INSERT INTO `city_weather_info` VALUES (1916321402169823234, NULL, NULL, '2025-04-27 10:39:59', '2025-04-27 10:39:59', '北京', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-27 10:34:00', '17', '14', '100', '晴', '90', '东风', '2', 10, '17', '0.0', '1016', '29', '101010100');
INSERT INTO `city_weather_info` VALUES (1916321403491028994, NULL, NULL, '2025-04-27 10:40:00', '2025-04-27 10:40:00', '闵行', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-27 10:33:00', '17', '15', '104', '阴', '180', '南风', '3', 14, '73', '0.0', '1014', '21', '101020200');
INSERT INTO `city_weather_info` VALUES (1916322661203415042, NULL, NULL, '2025-04-27 10:45:00', '2025-04-27 10:45:00', '北京', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-27 10:40:00', '18', '13', '100', '晴', '90', '东风', '4', 23, '18', '0.0', '1016', '30', '101010100');
INSERT INTO `city_weather_info` VALUES (1916322662327488514, NULL, NULL, '2025-04-27 10:45:00', '2025-04-27 10:45:00', '闵行', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2025-04-27 10:40:00', '17', '15', '104', '阴', '135', '东南风', '3', 14, '74', '0.0', '1014', '24', '101020200');

-- ----------------------------
-- Table structure for crm_user_category
-- ----------------------------
DROP TABLE IF EXISTS `crm_user_category`;
CREATE TABLE `crm_user_category`  (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `description` varchar(1025) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  `code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `status` int(11) NULL DEFAULT NULL,
  `parent_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `parent_ids` json NULL,
  `extend` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `sort` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `image` varchar(2555) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `deleted_status` tinyint(4) NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of crm_user_category
-- ----------------------------
INSERT INTO `crm_user_category` VALUES (0, '全部', NULL, NULL, NULL, NULL, 0, '-1', '[\"-1\"]', NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `crm_user_category` VALUES (1898711866655313921, '管理员', NULL, '2025-04-27 09:09:17', NULL, NULL, 0, '0', '[\"0\"]', NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `crm_user_category` VALUES (1898711903900733442, '微信小程序', NULL, NULL, NULL, NULL, 0, '0', '[\"0\"]', NULL, NULL, NULL, NULL, NULL, 1);
INSERT INTO `crm_user_category` VALUES (1898711935676780546, 'H5', NULL, NULL, NULL, NULL, 0, '0', '[\"0\"]', NULL, NULL, NULL, NULL, NULL, 1);
INSERT INTO `crm_user_category` VALUES (1898711956719603713, 'PC', NULL, NULL, NULL, NULL, 0, '0', '[\"0\"]', NULL, NULL, NULL, NULL, NULL, 1);
INSERT INTO `crm_user_category` VALUES (1898712000961122306, 'APP', NULL, NULL, NULL, NULL, 0, '0', '[\"0\"]', NULL, NULL, NULL, NULL, NULL, 1);
INSERT INTO `crm_user_category` VALUES (1898712033349537793, '外部导入', NULL, NULL, NULL, NULL, 0, '0', '[\"0\"]', NULL, NULL, NULL, NULL, NULL, 1);
INSERT INTO `crm_user_category` VALUES (1916301840246329345, '哈哈哈', NULL, NULL, NULL, NULL, 0, '1898711866655313921', '[\"0\", \"1898711866655313921\"]', NULL, NULL, NULL, NULL, NULL, 1);
INSERT INTO `crm_user_category` VALUES (1916301854569877506, '哈哈哈', NULL, NULL, NULL, NULL, 0, '1898711866655313921', '[\"0\", \"1898711866655313921\"]', NULL, NULL, NULL, NULL, NULL, 1);
INSERT INTO `crm_user_category` VALUES (1916301950644604929, '撒吃撒', NULL, NULL, NULL, NULL, 0, '0', '[\"0\"]', NULL, NULL, NULL, NULL, NULL, 1);
INSERT INTO `crm_user_category` VALUES (1916302011592036354, '用户', NULL, NULL, NULL, NULL, 0, '0', '[\"0\"]', NULL, NULL, NULL, NULL, NULL, 0);

-- ----------------------------
-- Table structure for crm_user_city
-- ----------------------------
DROP TABLE IF EXISTS `crm_user_city`;
CREATE TABLE `crm_user_city`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `category_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '城市名称',
  `status` int(11) NULL DEFAULT NULL,
  `code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `extend` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `sort` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `image` varchar(2555) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '图片',
  `category_ids` json NULL,
  `deleted_status` tinyint(4) NULL DEFAULT 0,
  `warn` json NULL COMMENT '警报',
  `city_id` bigint(20) NULL DEFAULT NULL COMMENT '城市id',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `category_id`(`category_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1899455940723200002 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of crm_user_city
-- ----------------------------

-- ----------------------------
-- Table structure for crm_user_city_care
-- ----------------------------
DROP TABLE IF EXISTS `crm_user_city_care`;
CREATE TABLE `crm_user_city_care`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `category_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '城市名称',
  `status` int(11) NULL DEFAULT NULL,
  `code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `extend` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `sort` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `image` varchar(2555) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '图片',
  `category_ids` json NULL,
  `deleted_status` tinyint(4) NULL DEFAULT 0,
  `city_id` bigint(20) NULL DEFAULT NULL COMMENT '城市id',
  `user_id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户id',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `category_id`(`category_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1916312944062205955 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of crm_user_city_care
-- ----------------------------
INSERT INTO `crm_user_city_care` VALUES (1916010934578438145, NULL, NULL, '2025-04-26 14:06:19', '2025-04-26 14:06:19', '', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1916004903504789506, '1');
INSERT INTO `crm_user_city_care` VALUES (1916031453461692418, NULL, NULL, '2025-04-26 15:27:50', '2025-04-26 15:27:50', '', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1915776479204884482, '1');
INSERT INTO `crm_user_city_care` VALUES (1916126926503632897, NULL, NULL, '2025-04-26 21:47:13', '2025-04-26 21:47:13', '', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1915774879975489538, '1');
INSERT INTO `crm_user_city_care` VALUES (1916307602624348162, NULL, NULL, '2025-04-27 09:45:09', '2025-04-27 10:00:41', '', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 1915774879975489538, '1916302768525496321');
INSERT INTO `crm_user_city_care` VALUES (1916312613328752642, NULL, NULL, '2025-04-27 10:05:04', '2025-04-27 10:05:08', '', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 1915774879975489538, '1916302768525496321');
INSERT INTO `crm_user_city_care` VALUES (1916312840878133249, NULL, NULL, '2025-04-27 10:05:58', '2025-04-27 10:06:07', '', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 1915776479204884482, '1916302768525496321');
INSERT INTO `crm_user_city_care` VALUES (1916312944062205954, NULL, NULL, '2025-04-27 10:06:23', '2025-04-27 10:06:23', '', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1915774879975489538, '1916302768525496321');

-- ----------------------------
-- Table structure for crm_user_info
-- ----------------------------
DROP TABLE IF EXISTS `crm_user_info`;
CREATE TABLE `crm_user_info`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `category_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `status` int(11) NULL DEFAULT NULL,
  `code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `extend` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `sort` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `image` varchar(2555) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `user_grade` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `is_group` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `is_vip` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `balance` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `recommender` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `id_number` varbinary(255) NULL DEFAULT NULL,
  `sex` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `birthday` datetime NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `roles` json NULL,
  `deleted_status` tinyint(4) NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `category_id`(`category_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1916302768525496322 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of crm_user_info
-- ----------------------------
INSERT INTO `crm_user_info` VALUES (1, '1898711866655313921', NULL, '2025-03-29 14:57:35', '2025-04-27 10:11:18', '管理员', 1, NULL, NULL, NULL, NULL, NULL, 'admin', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '阿达额分', 'e10adc3949ba59abbe56e057f20f883e', '[\"1905254920082030594\"]', 0);
INSERT INTO `crm_user_info` VALUES (1898724739184001026, '1898711866655313921', '', '2025-03-09 21:17:09', '2025-04-27 09:07:42', 'aaa', 1, '2', NULL, NULL, '', '从第三方', 'aaa', NULL, '12234324', '', NULL, NULL, NULL, NULL, 0x33323433353334353134333135, NULL, '2025-02-23 08:00:00', '阿达额分', 'e10adc3949ba59abbe56e057f20f883e', '[\"1905255465828089858\"]', 1);
INSERT INTO `crm_user_info` VALUES (1900170964877955074, '1898711866655313921', '', '2025-03-13 21:03:56', '2025-04-27 09:07:37', 'bbb', 1, '0', NULL, NULL, '', '范德萨', 'bbb', NULL, '的发表', '', NULL, NULL, NULL, NULL, 0x3233323534333534373533, NULL, '2025-03-01 08:00:00', '阿达额分', 'e10adc3949ba59abbe56e057f20f883e', NULL, 1);
INSERT INTO `crm_user_info` VALUES (1904826326545473537, '1898711903900733442', '', '2025-03-26 17:22:40', '2025-04-27 09:07:33', 'ccc', 1, '22', NULL, NULL, '', '速度非常', 'ccc', NULL, '124435543', '', NULL, NULL, NULL, NULL, 0x3132343434343635, NULL, '2025-03-08 08:00:00', '阿达额分', 'e10adc3949ba59abbe56e057f20f883e', '[]', 1);
INSERT INTO `crm_user_info` VALUES (1916302768525496321, '1916302011592036354', '', '2025-04-27 09:25:57', '2025-04-27 10:11:07', 'user', 1, '', NULL, NULL, '', '', 'user', NULL, '1111111', '', NULL, NULL, NULL, NULL, '', NULL, NULL, '11111', 'e10adc3949ba59abbe56e057f20f883e', '[\"1905255465828089858\"]', 0);

-- ----------------------------
-- Table structure for crm_user_tag_category
-- ----------------------------
DROP TABLE IF EXISTS `crm_user_tag_category`;
CREATE TABLE `crm_user_tag_category`  (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `description` varchar(1025) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  `code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `status` int(11) NULL DEFAULT NULL,
  `parent_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `parent_ids` json NULL,
  `extend` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `sort` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `image` varchar(2555) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `deleted_status` tinyint(4) NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

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
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `category_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `status` int(11) NULL DEFAULT NULL,
  `code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `extend` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `sort` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `image` varchar(2555) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `deleted_status` tinyint(4) NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `category_id`(`category_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1901874350140649475 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

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
  `id` bigint(20) NOT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `status` int(11) NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  `code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `parent_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `extend` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `sort` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `image` varchar(2555) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `deleted_status` tinyint(4) NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of demo
-- ----------------------------

-- ----------------------------
-- Table structure for info_admin_info
-- ----------------------------
DROP TABLE IF EXISTS `info_admin_info`;
CREATE TABLE `info_admin_info`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `category_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `status` int(11) NULL DEFAULT NULL,
  `code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `extend` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `sort` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `image` varchar(2555) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '手机号',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '密码',
  `position` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '岗位',
  `role` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '角色',
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '登录名',
  `deleted_status` tinyint(4) NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `category_id`(`category_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1904506038205210626 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

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
  `id` bigint(20) NOT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `description` varchar(1025) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  `code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `status` int(11) NULL DEFAULT NULL,
  `parent_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `parent_ids` json NULL,
  `extend` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `sort` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `image` varchar(2555) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `deleted_status` tinyint(4) NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

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
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `category_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `status` int(11) NULL DEFAULT NULL,
  `code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `extend` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `sort` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `image` varchar(2555) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '图片',
  `category_ids` json NULL,
  `use_num` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `deleted_status` tinyint(4) NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `category_id`(`category_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1904779143620284419 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

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
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `category_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `status` int(11) NULL DEFAULT NULL,
  `code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `extend` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `sort` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `image` varchar(2555) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '图片',
  `category_ids` json NULL,
  `use_num` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `deleted_status` tinyint(4) NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `category_id`(`category_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1899368555754803204 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

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
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `category_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `status` int(11) NULL DEFAULT NULL,
  `code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `extend` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `sort` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `image` varchar(2555) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '图片',
  `category_ids` json NULL,
  `mark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '评分',
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户名称',
  `reviews` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '商品评价',
  `service_attitude` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '服务态度',
  `logistics_service` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '物流服务',
  `evaluation_content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '评价内容',
  `quality` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '商品质量',
  `deleted_status` tinyint(4) NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `category_id`(`category_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1899455940723200002 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

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
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `category_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `status` int(11) NULL DEFAULT NULL,
  `code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `extend` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `sort` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `image` varchar(2555) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '图片',
  `category_ids` json NULL,
  `attrs` json NULL,
  `deleted_status` tinyint(4) NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `category_id`(`category_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1899457048698933251 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

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
  `id` bigint(20) NOT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `description` varchar(1025) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  `code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `status` int(11) NULL DEFAULT NULL,
  `parent_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `parent_ids` json NULL,
  `extend` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `sort` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `image` varchar(2555) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `deleted_status` tinyint(4) NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

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
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `category_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `border_color` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '边框颜色',
  `bg_color` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '背景颜色',
  `font_color` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '字体颜色',
  `mobile_show` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '移动端展示',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `status` int(11) NULL DEFAULT NULL,
  `code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `extend` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `sort` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `image` varchar(2555) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '图片',
  `deleted_status` tinyint(4) NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `category_id`(`category_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1904532800859500546 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

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
  `id` bigint(20) NOT NULL COMMENT '主键 ID',
  `flag` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '标识',
  `code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '编码',
  `status` int(11) NULL DEFAULT 0 COMMENT '状态值: 0: 禁用; 1: 启用;',
  `sort` bigint(20) NULL DEFAULT 0 COMMENT '排序值',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  `extend` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '扩展',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `user_id` bigint(20) NULL DEFAULT NULL COMMENT '用户ID',
  `product_id` bigint(20) NULL DEFAULT NULL COMMENT '产品ID',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '名称',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '描述',
  `image` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '封面',
  `price` decimal(10, 2) NULL DEFAULT 0.00 COMMENT '价格',
  `num` int(11) NULL DEFAULT NULL COMMENT '数量',
  `type` tinyint(4) NULL DEFAULT NULL COMMENT '类别：0:临时；1：正常',
  `deleted_status` tinyint(4) NULL DEFAULT 0 COMMENT '逻辑删除状态：0逻辑未删除值;1:逻辑已删除值',
  `category_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `category_ids` json NULL,
  `product_details_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '系统-配置-信息' ROW_FORMAT = DYNAMIC;

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
  `id` bigint(20) NOT NULL COMMENT '主键 ID',
  `flag` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '标识',
  `code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '编码',
  `status` int(11) NULL DEFAULT 0 COMMENT '状态值: 0: 禁用; 1: 启用;',
  `sort` bigint(20) NULL DEFAULT 0 COMMENT '排序值',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  `extend` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '扩展',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `deleted_status` tinyint(4) NULL DEFAULT 0 COMMENT '逻辑删除状态：0逻辑未删除值;1:逻辑已删除值',
  `order_id` bigint(20) NULL DEFAULT NULL COMMENT '订单ID',
  `user_id` bigint(20) NULL DEFAULT NULL COMMENT '用户ID',
  `product_id` bigint(20) NULL DEFAULT NULL COMMENT '产品ID',
  `product_details_id` bigint(20) NULL DEFAULT NULL COMMENT '产品明细ID',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '名称',
  `image` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '图片',
  `spec_flags` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '规格标识',
  `specs` json NULL COMMENT '规格',
  `num` int(11) NULL DEFAULT NULL COMMENT '数量',
  `price` decimal(10, 2) NULL DEFAULT NULL COMMENT '价格',
  `amount` decimal(10, 2) NULL DEFAULT 0.00,
  `weight` decimal(10, 2) NULL DEFAULT NULL COMMENT '重量',
  `volume` decimal(10, 2) NULL DEFAULT NULL COMMENT '体积',
  `integral` int(11) NULL DEFAULT NULL COMMENT '积分',
  `reply_status` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '评价状态，0-未评价，1-已评价',
  `category_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `category_ids` json NULL,
  `type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '系统-配置-信息' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of shop_order_details
-- ----------------------------

-- ----------------------------
-- Table structure for shop_order_info
-- ----------------------------
DROP TABLE IF EXISTS `shop_order_info`;
CREATE TABLE `shop_order_info`  (
  `id` bigint(20) NOT NULL COMMENT '主键 ID',
  `flag` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '标识',
  `code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '编码',
  `status` int(11) NULL DEFAULT 0 COMMENT '状态值:状态	订单状态（0->待发货；1->待收货|已发货；2->已收货|待评价；3->已完成）9:已取消',
  `sort` bigint(20) NULL DEFAULT 0 COMMENT '排序值',
  `extend` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '扩展',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `deleted_status` tinyint(4) NULL DEFAULT 0 COMMENT '逻辑删除状态：0逻辑未删除值;1:逻辑已删除值',
  `user_id` bigint(20) NULL DEFAULT NULL COMMENT '用户ID',
  `receiver_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '收货姓名',
  `receiver_phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '收货电话',
  `receiver_address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '收货详细地址',
  `delivery_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '发货类型：配送方式 1=快递 ，2=门店自提，0：无需配送',
  `delivery_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '快递公司编码或门店id(type=1:快递公司编码|type=2:门店id)',
  `delivery_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '快递名称/送货人姓名 (type=1:快递名称|type=2:送货人姓名)',
  `delivery_num` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '快递单号/手机号 (type=1:快递单号|type=2:手机号)',
  `delivery_uid` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '配送员id（仅type=2时有效）',
  `delivery_mark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '快递备注/配送备注',
  `delivery_amount` decimal(10, 2) NULL DEFAULT NULL COMMENT '运费金额：商家发快递或物流的真实价格  快递价格 （仅type=1时有效）',
  `goods_num` int(11) NULL DEFAULT NULL COMMENT '订单总数',
  `integral_promotion_amount` decimal(10, 2) NULL DEFAULT NULL COMMENT '积分抵扣金额',
  `integral_use` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '使用了多少积分',
  `integral_get` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '消费赚取积分',
  `integral_back` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '给用户退了多少积分（integral_back=integral_get-integral_use）',
  `coupon_promotion_amount` decimal(10, 2) NULL DEFAULT NULL COMMENT '优惠劵金额/优惠金额',
  `coupon_id` bigint(20) NULL DEFAULT NULL COMMENT '优惠券ID',
  `coupon_user_id` bigint(20) NULL DEFAULT NULL COMMENT '用户优惠券ID',
  `coupon_data` json NULL COMMENT '优惠券数据',
  `pay_status` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '支付状态：0：未支付；1：已支付',
  `pay_amount` decimal(10, 2) NULL DEFAULT NULL COMMENT '实际支付（总支付，支付接口回调实际支付的价格）（正常情况下应该包含支付商品跟支付邮费）',
  `pay_time` datetime NULL DEFAULT NULL COMMENT '支付时间',
  `pay_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '支付方式：wxpay:微信支付;alipay:支付宝;balance:余额支付;offline:线下支付;（abchina:农业银行;boc:中国银行;ccb:中国建设银行;icbc:中国工商银行）暂时无用',
  `pay_trade_id` int(11) NULL DEFAULT NULL COMMENT '支付流水号(交易号)',
  `pay_mark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '支付备注',
  `refund_status` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '0 未退款 1 申请中 2 已退款',
  `refund_reason_wap_img` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '前台退款图片',
  `refund_reason_wap_desc` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '前台退款用户说明',
  `refund_reason_wap` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '前台退款原因',
  `refund_reason_refuse` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '不退款的理由',
  `refund_reason_time` datetime NULL DEFAULT NULL COMMENT '退款时间',
  `refund_amount` decimal(10, 2) NULL DEFAULT NULL COMMENT '退款金额',
  `promotion_amount` decimal(10, 2) NULL DEFAULT NULL COMMENT '优惠金额',
  `vip_promotion_amount` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '会员优惠金额',
  `vip_id` bigint(20) NULL DEFAULT NULL COMMENT '会员卡ID',
  `vip_data` json NULL COMMENT '会员卡i信息',
  `goods_amount` decimal(10, 2) NULL DEFAULT NULL COMMENT '商品金额',
  `receivable_amount` decimal(10, 2) NULL DEFAULT NULL COMMENT '应收金额/应付金额',
  `total_amount` decimal(10, 2) NULL DEFAULT NULL COMMENT '总价',
  `mark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '商家备注',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `category_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `category_ids` json NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `image` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '系统-配置-信息' ROW_FORMAT = DYNAMIC;

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
  `id` bigint(20) NOT NULL COMMENT '主键 ID',
  `flag` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '标识',
  `code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '编码',
  `status` int(11) NULL DEFAULT 0 COMMENT '状态值: 0: 禁用; 1: 启用;',
  `sort` bigint(20) NULL DEFAULT 0 COMMENT '排序值',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  `extend` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '扩展',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `product_id` bigint(20) NULL DEFAULT NULL COMMENT '产品ID',
  `specs` json NULL COMMENT '规格',
  `spec_flags` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '规格标识',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '名称',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '描述',
  `type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '类型:number:数字;string:字符串;bool:布尔值;double:浮点数;array:数组(用英文逗号分隔的字符串);json：JSON对象',
  `image` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '图片',
  `original_price` decimal(10, 2) NULL DEFAULT NULL COMMENT '原价',
  `cost_price` decimal(10, 2) NULL DEFAULT NULL COMMENT '成本价',
  `price` decimal(10, 2) NULL DEFAULT NULL COMMENT '售价',
  `bar_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '条形码',
  `inventory` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '库存',
  `weight` double NULL DEFAULT NULL COMMENT '重量（KG）',
  `volume` double NULL DEFAULT NULL COMMENT '体积(m³)',
  `deleted_status` tinyint(4) NULL DEFAULT 0 COMMENT '逻辑删除状态：0逻辑未删除值;1:逻辑已删除值',
  `category_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `category_ids` json NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '系统-配置-信息' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of shop_product_details
-- ----------------------------

-- ----------------------------
-- Table structure for shop_product_info
-- ----------------------------
DROP TABLE IF EXISTS `shop_product_info`;
CREATE TABLE `shop_product_info`  (
  `id` bigint(20) NOT NULL COMMENT '主键 ID',
  `code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '编码',
  `status` int(11) NULL DEFAULT 0 COMMENT '状态值: 0: 禁用; 1: 启用;',
  `sort` bigint(20) NULL DEFAULT 0 COMMENT '排序值',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  `extend` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '扩展',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `type` tinyint(4) NULL DEFAULT NULL COMMENT '类型',
  `category_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '上级分类ID',
  `category_ids` json NULL COMMENT '上级分类ID数组',
  `brand_id` bigint(20) NULL DEFAULT NULL COMMENT '品牌ID',
  `brand_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '品牌名称',
  `unit_id` bigint(20) NULL DEFAULT NULL COMMENT '单位ID',
  `unit_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '单位名称',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '名称',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '描述',
  `image` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '图片',
  `images` json NULL COMMENT '图片集合',
  `recomend_img` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '推荐图',
  `content` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '内容',
  `keyword` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '关键词',
  `tag_ids` json NULL COMMENT '标签',
  `shelf_status` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '上架状态',
  `shelf_time` datetime NULL DEFAULT NULL COMMENT '上架时间',
  `takedown_status` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '下架状态',
  `takedown_time` datetime NULL DEFAULT NULL COMMENT '下架时间',
  `spec_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '规格类型',
  `watchword` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '口令',
  `services` json NULL COMMENT '服务保障',
  `attrs` json NULL COMMENT '参数',
  `sold_num` int(11) NULL DEFAULT NULL COMMENT '已售数量',
  `give_integral` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '赠送积分',
  `give_coupons` json NULL COMMENT '赠送优惠券',
  `user_tag_ids` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '关联用户标签',
  `limit_status` tinyint(4) NULL DEFAULT NULL COMMENT '是否限购',
  `limit_type` tinyint(4) NULL DEFAULT NULL COMMENT '限购类型',
  `limit_num` int(11) NULL DEFAULT NULL COMMENT '限购数量',
  `presell_status` tinyint(4) NULL DEFAULT NULL COMMENT '预售商品状态',
  `presell_time_start` datetime NULL DEFAULT NULL COMMENT '预售商品开始时间',
  `presell_time_end` datetime NULL DEFAULT NULL COMMENT '预售商品结束时间',
  `recommend_status` tinyint(4) NULL DEFAULT NULL COMMENT '优品推荐',
  `recommend_product_ids` json NULL COMMENT '选择优品推荐商品',
  `activity_priority` json NULL COMMENT '活动优先级',
  `delivery_way` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '配送方式',
  `delivery_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '运费设置',
  `delivery_price` decimal(10, 2) NULL DEFAULT NULL COMMENT '运费价格',
  `delivery_tpl_id` int(11) NULL DEFAULT NULL COMMENT '运费模板',
  `price` decimal(10, 2) UNSIGNED ZEROFILL NULL DEFAULT 00000000.00 COMMENT '价格',
  `original_price` decimal(10, 2) NULL DEFAULT 0.00 COMMENT '原价',
  `specs` json NULL COMMENT '规格',
  `score_num` decimal(10, 2) NULL DEFAULT 5.00 COMMENT '评分',
  `deleted_status` tinyint(4) NULL DEFAULT 0 COMMENT '逻辑删除状态：0逻辑未删除值;1:逻辑已删除值',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '系统-配置-信息' ROW_FORMAT = DYNAMIC;

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
  `id` bigint(20) NOT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `description` varchar(1025) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  `code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `status` int(11) NULL DEFAULT NULL,
  `parent_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `parent_ids` json NULL,
  `extend` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `sort` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `image` varchar(2555) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `deleted_status` tinyint(4) NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

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
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `category_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `status` int(11) NULL DEFAULT NULL,
  `code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `extend` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `sort` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `image` varchar(2555) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `value` varchar(1025) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `deleted_status` tinyint(4) NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `category_id`(`category_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1901594985012101122 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

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
  `id` bigint(20) NOT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `description` varchar(1025) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  `code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `status` int(11) NULL DEFAULT NULL,
  `parent_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `parent_ids` json NULL,
  `extend` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `sort` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `image` varchar(2555) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `value` varchar(1255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `deleted_status` tinyint(4) NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

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
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `category_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `status` int(11) NULL DEFAULT NULL,
  `code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `extend` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `sort` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `image` varchar(2555) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `deleted_status` tinyint(4) NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `category_id`(`category_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1904504920586772482 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

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
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `category_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `status` int(11) NULL DEFAULT NULL,
  `code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `extend` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `sort` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `image` varchar(2555) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '图片',
  `category_ids` json NULL,
  `path` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `meta` json NULL,
  `component` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `redirect` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `deleted_status` tinyint(4) NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `category_id`(`category_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1905982966867103753 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of system_permission_info
-- ----------------------------
INSERT INTO `system_permission_info` VALUES (0, '-1', NULL, '2025-03-11 15:50:44', '2025-04-27 08:36:50', '全部', 1, NULL, NULL, NULL, NULL, NULL, NULL, '[\"-1\"]', NULL, NULL, NULL, NULL, 0);
INSERT INTO `system_permission_info` VALUES (1905856358508331010, '0', '', '2025-03-28 10:49:35', '2025-03-29 20:28:14', '基本管理', 1, '', '', NULL, '1', NULL, NULL, '[\"0\"]', '/Info', '{\"title\": \"基本管理\"}', '', '/Info/AdminInfo', 0);
INSERT INTO `system_permission_info` VALUES (1905856572694659074, '1905856358508331010', '', '2025-03-29 13:36:30', '2025-04-27 09:33:51', '用户管理', 1, '', '', NULL, '2', NULL, NULL, '[\"0\", \"1905856358508331010\"]', '/Info/UserInfo1', '{\"title\": \"用户管理\"}', '@/views/crm/user/index.vue', '', 0);
INSERT INTO `system_permission_info` VALUES (1905856866983804930, '0', '', '2025-03-29 13:37:40', '2025-03-29 13:37:43', '系统模块', 1, '', '', NULL, '1', NULL, NULL, '[\"0\"]', '/System', '{\"title\": \"系统模块\"}', '', '/System/ConfigInfo', 0);
INSERT INTO `system_permission_info` VALUES (1905857064007041025, '1905856866983804930', '', '2025-03-29 13:38:27', '2025-03-29 13:40:41', '配置管理', 1, '', '', NULL, '2', NULL, NULL, '[\"0\", \"1905856866983804930\"]', '/System/ConfigInfo', '{\"title\": \"配置管理\"}', '@/views/system/config/index.vue', '', 0);
INSERT INTO `system_permission_info` VALUES (1905857173000224769, '1905856866983804930', '', '2025-03-29 13:38:53', '2025-03-29 13:40:40', '字典管理', 1, '', '', NULL, '2', NULL, NULL, '[\"0\", \"1905856866983804930\"]', '/System/DictInfo', '{\"title\": \"字典管理\"}', '@/views/system/dict/index.vue', '', 0);
INSERT INTO `system_permission_info` VALUES (1905857300725170178, '1905856866983804930', '', '2025-03-29 13:39:24', '2025-03-29 13:40:40', '短信管理', 1, '', '', NULL, '2', NULL, NULL, '[\"0\", \"1905856866983804930\"]', '/System/TplInfo', '{\"title\": \"短信管理\"}', '@/views/system/sms/tpl/index.vue', '', 0);
INSERT INTO `system_permission_info` VALUES (1905857420019564545, '1905856866983804930', '', '2025-03-29 13:39:52', '2025-03-29 13:40:40', '权限管理', 1, '', '', NULL, '2', NULL, NULL, '[\"0\", \"1905856866983804930\"]', '/System/PermissionInfo', '{\"title\": \"权限管理\"}', '@/views/system/permission/index.vue', '', 0);
INSERT INTO `system_permission_info` VALUES (1905857575066206209, '1905856866983804930', '', '2025-03-29 13:40:29', '2025-03-29 13:40:39', '角色管理', 1, '', '', NULL, '2', NULL, NULL, '[\"0\", \"1905856866983804930\"]', '/System/RolesInfo', '{\"title\": \"角色管理\"}', '@/views/system/role/index.vue', '', 0);
INSERT INTO `system_permission_info` VALUES (1905982966867103747, '0', NULL, '2025-04-27 08:37:13', '2025-04-27 08:39:16', '天气管理', 1, NULL, NULL, NULL, '1', NULL, NULL, '[\"0\"]', '/weather', '{\"title\": \"天气管理\"}', NULL, '/Weather/WeatherInfo1', 0);
INSERT INTO `system_permission_info` VALUES (1905982966867103748, '1905982966867103747', NULL, '2025-04-27 08:39:46', '2025-04-27 08:44:28', '天气管理', 1, NULL, NULL, NULL, '1', NULL, NULL, '[\"0\", \"1905982966867103747\"]', '/Weather/WeatherInfo1', '{\"title\": \"天气管理\"}', '@/views/weather/WeatherIndex.vue', NULL, 0);
INSERT INTO `system_permission_info` VALUES (1905982966867103749, '1905982966867103747', NULL, '2025-04-27 08:42:18', '2025-04-27 09:40:35', '城市管理', 0, NULL, NULL, NULL, NULL, NULL, NULL, '[\"0\", \"1905982966867103747\"]', '/Weather/WeatherCity1', '{\"title\": \"城市管理\"}', '@/views/weather/city/index.vue', NULL, 0);
INSERT INTO `system_permission_info` VALUES (1905982966867103750, '1905982966867103747', NULL, '2025-04-27 08:45:16', '2025-04-27 09:40:35', '历史天气', 0, NULL, NULL, NULL, NULL, NULL, NULL, '[\"0\", \"1905982966867103747\"]', '/Weather/HistoryWeatherCity1', '{\"title\": \"历史天气\"}', '@/views/weather/historyWeather/index.vue', NULL, 0);
INSERT INTO `system_permission_info` VALUES (1905982966867103751, '1905982966867103747', NULL, '2025-04-27 08:54:36', '2025-04-27 09:40:36', '天气详情', 0, NULL, NULL, NULL, NULL, NULL, NULL, '[\"0\", \"1905982966867103747\"]', '/Weather/WeatherDetail', '{\"title\": \"天气详情\"}', '@/views/weather/detail/WeatherDetail.vue', NULL, 0);
INSERT INTO `system_permission_info` VALUES (1905982966867103752, '1905856358508331010', NULL, '2025-04-27 09:04:08', '2025-04-27 09:40:35', '个人中心', 0, NULL, NULL, NULL, NULL, NULL, NULL, '[\"0\", \"1905856358508331010\"]', '/User/UserCenter1', '{\"title\": \"个人中心\"}', '@/views/crm/user/UserCenter.vue', NULL, 0);

-- ----------------------------
-- Table structure for system_role_info
-- ----------------------------
DROP TABLE IF EXISTS `system_role_info`;
CREATE TABLE `system_role_info`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `category_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `status` int(11) NULL DEFAULT NULL,
  `code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `extend` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `sort` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `image` varchar(2555) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '图片',
  `category_ids` json NULL,
  `deleted_status` tinyint(4) NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `category_id`(`category_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1905614681721946115 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of system_role_info
-- ----------------------------
INSERT INTO `system_role_info` VALUES (1905254920082030594, NULL, '', '2025-03-27 21:45:45', '2025-04-27 10:14:08', '管理员', 1, '', '', NULL, '', NULL, NULL, '[\"1905856358508331010\", \"1905982966867103752\", \"1905856572694659074\", \"1905982966867103747\", \"1905982966867103749\", \"1905982966867103750\", \"1905982966867103751\", \"1905982966867103748\"]', 0);
INSERT INTO `system_role_info` VALUES (1905255465828089858, NULL, '', '2025-03-27 21:47:55', '2025-04-27 10:14:15', '用户', 1, '', '', NULL, '', NULL, NULL, '[\"1905982966867103752\", \"1905982966867103750\", \"1905982966867103751\", \"1905982966867103748\"]', 0);

-- ----------------------------
-- Table structure for system_sms_tpl_category
-- ----------------------------
DROP TABLE IF EXISTS `system_sms_tpl_category`;
CREATE TABLE `system_sms_tpl_category`  (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `description` varchar(1025) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  `code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `status` int(11) NULL DEFAULT NULL,
  `parent_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `parent_ids` json NULL,
  `extend` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `sort` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `image` varchar(2555) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `deleted_status` tinyint(4) NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

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
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `category_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `status` int(11) NULL DEFAULT NULL,
  `code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `extend` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `sort` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `image` varchar(2555) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `deleted_status` tinyint(4) NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `category_id`(`category_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1904820549134999555 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

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
  `id` bigint(20) NOT NULL,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `status` int(11) NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `roles` json NULL,
  `code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'admin', 'e10adc3949ba59abbe56e057f20f883e', '管理员', NULL, NULL, NULL, NULL, NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;
