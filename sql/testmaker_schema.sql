/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 80015
 Source Host           : localhost:3306
 Source Schema         : testmaker

 Target Server Type    : MySQL
 Target Server Version : 80015
 File Encoding         : 65001

 Date: 03/05/2019 13:14:42
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for _contesttable
-- ----------------------------
DROP TABLE IF EXISTS `_contesttable`;
CREATE TABLE `_contesttable`  (
  `a` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for chapter
-- ----------------------------
DROP TABLE IF EXISTS `chapter`;
CREATE TABLE `chapter`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created_on` datetime(0) NOT NULL,
  `updated_on` datetime(0) NOT NULL,
  `number` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `syllabus_id` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK_qy0s6jxmr6tti57fw3pumpnkd`(`syllabus_id`) USING BTREE,
  CONSTRAINT `FK_qy0s6jxmr6tti57fw3pumpnkd` FOREIGN KEY (`syllabus_id`) REFERENCES `syllabus` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FKqmbmdsthpcwy455xtj8bqqn5n` FOREIGN KEY (`syllabus_id`) REFERENCES `syllabus` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 103 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for exam_quest
-- ----------------------------
DROP TABLE IF EXISTS `exam_quest`;
CREATE TABLE `exam_quest`  (
  `exam_id` int(11) NOT NULL,
  `question_id` int(11) NOT NULL,
  `number` int(11) NOT NULL,
  PRIMARY KEY (`exam_id`, `number`) USING BTREE,
  INDEX `question_id`(`question_id`) USING BTREE,
  CONSTRAINT `question_id` FOREIGN KEY (`question_id`) REFERENCES `question` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `exam_id` FOREIGN KEY (`exam_id`) REFERENCES `examination` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for examination
-- ----------------------------
DROP TABLE IF EXISTS `examination`;
CREATE TABLE `examination`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  CONSTRAINT `user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for hibernate_sequence
-- ----------------------------
DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE `hibernate_sequence`  (
  `next_val` bigint(20) NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for knowledge_point
-- ----------------------------
DROP TABLE IF EXISTS `knowledge_point`;
CREATE TABLE `knowledge_point`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created_on` datetime(0) NOT NULL,
  `updated_on` datetime(0) NOT NULL,
  `k_level` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `number` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `score` smallint(6) NOT NULL,
  `title` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `chapter_id` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK_n0av3nxe7c9nurtlndoehgmu1`(`chapter_id`) USING BTREE,
  CONSTRAINT `FK_n0av3nxe7c9nurtlndoehgmu1` FOREIGN KEY (`chapter_id`) REFERENCES `chapter` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FKs3gobyn4eufqcp5t7oj6r2veq` FOREIGN KEY (`chapter_id`) REFERENCES `chapter` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 354 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for project
-- ----------------------------
DROP TABLE IF EXISTS `project`;
CREATE TABLE `project`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created_on` datetime(0) NOT NULL,
  `updated_on` datetime(0) NOT NULL,
  `custom_field1` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `custom_field2` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `custom_field3` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `exported_on` datetime(0) NULL DEFAULT NULL,
  `finish_date` date NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `start_date` date NULL DEFAULT NULL,
  `exported_by` int(11) NULL DEFAULT NULL,
  `facilitator_id` int(11) NOT NULL,
  `status_id` int(11) NOT NULL,
  `syllabus_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `UK_3k75vvu7mevyvvb5may5lj8k7`(`name`) USING BTREE,
  UNIQUE INDEX `UK_iflk2yk9ma95q0q9ovhftpi63`(`name`) USING BTREE,
  INDEX `FK_me72p0k7n5mpnoieinaymgckr`(`exported_by`) USING BTREE,
  INDEX `FK_gla35o52d1qcrxgbfrdstn1qn`(`facilitator_id`) USING BTREE,
  INDEX `FK_cmq2womflwqgdijyxklbasgdi`(`status_id`) USING BTREE,
  INDEX `FK_7x1lbg3ru2e55annuyooest2g`(`syllabus_id`) USING BTREE,
  CONSTRAINT `FK6eqismi3fjpgi7lvep992yrji` FOREIGN KEY (`status_id`) REFERENCES `project_status` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FKf301jbtxcn4lo2s55f5sl8jki` FOREIGN KEY (`syllabus_id`) REFERENCES `syllabus` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FKgbcsw7nrlqmgn7r4e426krb20` FOREIGN KEY (`facilitator_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FKth9u2k3y9m755kaqvvg7as2tf` FOREIGN KEY (`exported_by`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 140 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for project_status
-- ----------------------------
DROP TABLE IF EXISTS `project_status`;
CREATE TABLE `project_status`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created_on` datetime(0) NOT NULL,
  `updated_on` datetime(0) NOT NULL,
  `is_finish` bit(1) NOT NULL,
  `is_start` bit(1) NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `UK_gc9netg5vvbi8wn4vxmn6ey1t`(`name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 145 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for project_user
-- ----------------------------
DROP TABLE IF EXISTS `project_user`;
CREATE TABLE `project_user`  (
  `PROJECT_ID` int(11) NOT NULL,
  `USER_ID` int(11) NOT NULL,
  INDEX `FKr6jugtwk9axivplnrehno65fg`(`USER_ID`) USING BTREE,
  INDEX `FKev8k0euy0d3vwdmwwpep9ccdv`(`PROJECT_ID`) USING BTREE,
  CONSTRAINT `FK4qtxsgrdr19mn0i80wqkfxkq7` FOREIGN KEY (`PROJECT_ID`) REFERENCES `project` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FKev8k0euy0d3vwdmwwpep9ccdv` FOREIGN KEY (`PROJECT_ID`) REFERENCES `project` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FKr6jugtwk9axivplnrehno65fg` FOREIGN KEY (`USER_ID`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FKtllkcrbifycjjo3ri03sbmkxv` FOREIGN KEY (`USER_ID`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for project_users
-- ----------------------------
DROP TABLE IF EXISTS `project_users`;
CREATE TABLE `project_users`  (
  `project_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `id` int(11) NOT NULL,
  `created_on` datetime(0) NOT NULL,
  `updated_on` datetime(0) NOT NULL,
  INDEX `FK_4isj8wuooru4brw3629wu4iyg`(`user_id`) USING BTREE,
  INDEX `FK_rl5jp955lxoxtbv6pa1wig6vd`(`project_id`) USING BTREE,
  CONSTRAINT `FK93remjbrgji107mqni2o7fk0w` FOREIGN KEY (`project_id`) REFERENCES `project` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_4isj8wuooru4brw3629wu4iyg` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_rl5jp955lxoxtbv6pa1wig6vd` FOREIGN KEY (`project_id`) REFERENCES `project` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FKhrk6ne02irq1ag8nwvsrke08r` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for project_users_role
-- ----------------------------
DROP TABLE IF EXISTS `project_users_role`;
CREATE TABLE `project_users_role`  (
  `project_user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  INDEX `FKamc04oqap4vx84vs4gqy4p4jr`(`role_id`) USING BTREE,
  CONSTRAINT `FKamc04oqap4vx84vs4gqy4p4jr` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for question
-- ----------------------------
DROP TABLE IF EXISTS `question`;
CREATE TABLE `question`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created_on` datetime(0) NOT NULL,
  `updated_on` datetime(0) NOT NULL,
  `authoring_finish_date` date NOT NULL,
  `authoring_start_date` date NOT NULL,
  `custom_field1` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `custom_field2` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `custom_field3` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `description` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `difficulty` int(11) NOT NULL,
  `memo` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `multiple_choice` bit(1) NOT NULL DEFAULT b'0',
  `published` datetime(0) NULL DEFAULT NULL,
  `reviewing_finish_date` date NULL DEFAULT NULL,
  `reviewing_start_date` date NULL DEFAULT NULL,
  `scenario` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `score` smallint(6) NOT NULL,
  `stem` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `author_id` int(11) NOT NULL,
  `knowledge_point` int(11) NULL DEFAULT NULL,
  `language` int(11) NOT NULL,
  `project_id` int(11) NOT NULL,
  `quality_admin_id` int(11) NOT NULL,
  `status` int(11) NOT NULL,
  `type` int(11) NOT NULL,
  `custom_filed1` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `remark` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK_k179yjp59ndpikaaruth27f9m`(`author_id`) USING BTREE,
  INDEX `FK_j7imy0kvvgnmc9at4412exaxs`(`knowledge_point`) USING BTREE,
  INDEX `FK_jljdfx6hvc29oglbvo6h1fira`(`language`) USING BTREE,
  INDEX `FK_htpraiywcov18x05oog450542`(`project_id`) USING BTREE,
  INDEX `FK_bxxsn12lgu7q6kam1tsor1nr`(`quality_admin_id`) USING BTREE,
  INDEX `FK_hod8cehxh1lbef9lmlowmhwpk`(`status`) USING BTREE,
  INDEX `FK_64rlcm7utqkwfl1j2t3bqrv4n`(`type`) USING BTREE,
  CONSTRAINT `FK6u43au26uw1n87airoiar498d` FOREIGN KEY (`quality_admin_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK6ybx3ougbvuby84i1s0tv7dpc` FOREIGN KEY (`project_id`) REFERENCES `project` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK8k15h9e04o5tvnugd738gel6j` FOREIGN KEY (`status`) REFERENCES `question_status` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK96wrldbs52u9mxp5rmrdedwku` FOREIGN KEY (`knowledge_point`) REFERENCES `knowledge_point` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK9788yosql586568o45lxvkfwu` FOREIGN KEY (`author_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_64rlcm7utqkwfl1j2t3bqrv4n` FOREIGN KEY (`type`) REFERENCES `question_type` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_bxxsn12lgu7q6kam1tsor1nr` FOREIGN KEY (`quality_admin_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_hod8cehxh1lbef9lmlowmhwpk` FOREIGN KEY (`status`) REFERENCES `question_status` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_htpraiywcov18x05oog450542` FOREIGN KEY (`project_id`) REFERENCES `project` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_j7imy0kvvgnmc9at4412exaxs` FOREIGN KEY (`knowledge_point`) REFERENCES `knowledge_point` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_jljdfx6hvc29oglbvo6h1fira` FOREIGN KEY (`language`) REFERENCES `question_language` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_k179yjp59ndpikaaruth27f9m` FOREIGN KEY (`author_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FKf5jpie4loef3d0e3eltx986t4` FOREIGN KEY (`type`) REFERENCES `question_type` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FKrtn1ca8jyh1tmoqfyya12tcew` FOREIGN KEY (`language`) REFERENCES `question_language` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 380 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for question_choice
-- ----------------------------
DROP TABLE IF EXISTS `question_choice`;
CREATE TABLE `question_choice`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created_on` datetime(0) NOT NULL,
  `updated_on` datetime(0) NOT NULL,
  `choice_label` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `is_correct_answer` bit(1) NOT NULL,
  `question_id` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK_drrr6mb7k16ao25w6txc41pdd`(`question_id`) USING BTREE,
  CONSTRAINT `FK_drrr6mb7k16ao25w6txc41pdd` FOREIGN KEY (`question_id`) REFERENCES `question` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FKcliu69yk43jdwcb5mf7077eq3` FOREIGN KEY (`question_id`) REFERENCES `question` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1395 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for question_choice_image
-- ----------------------------
DROP TABLE IF EXISTS `question_choice_image`;
CREATE TABLE `question_choice_image`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created_on` datetime(0) NOT NULL,
  `updated_on` datetime(0) NOT NULL,
  `path` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `caption` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `question_choice_id` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK_p6avf3k6h46pngoxu6ltsrcvh`(`question_choice_id`) USING BTREE,
  CONSTRAINT `FK_p6avf3k6h46pngoxu6ltsrcvh` FOREIGN KEY (`question_choice_id`) REFERENCES `question_choice` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FKq2mgfh8grlhfgyuo7alxvi0v3` FOREIGN KEY (`question_choice_id`) REFERENCES `question_choice` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for question_image
-- ----------------------------
DROP TABLE IF EXISTS `question_image`;
CREATE TABLE `question_image`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created_on` datetime(0) NOT NULL,
  `updated_on` datetime(0) NOT NULL,
  `path` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `caption` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `question_id` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK_rt5bt00pq2t32duqhyinbeour`(`question_id`) USING BTREE,
  CONSTRAINT `FK8sar3tc41m4v104w3blx5anqk` FOREIGN KEY (`question_id`) REFERENCES `question` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_rt5bt00pq2t32duqhyinbeour` FOREIGN KEY (`question_id`) REFERENCES `question` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 123 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for question_language
-- ----------------------------
DROP TABLE IF EXISTS `question_language`;
CREATE TABLE `question_language`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created_on` datetime(0) NOT NULL,
  `updated_on` datetime(0) NOT NULL,
  `name` varchar(55) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `UK_h7snp9gauw2o9k8o320ym954t`(`name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for question_reviewers
-- ----------------------------
DROP TABLE IF EXISTS `question_reviewers`;
CREATE TABLE `question_reviewers`  (
  `question_id` int(11) NOT NULL,
  `reviewer_id` int(11) NOT NULL,
  PRIMARY KEY (`question_id`, `reviewer_id`) USING BTREE,
  INDEX `FK_kdm8obpe6leusm1ymmvon7wew`(`reviewer_id`) USING BTREE,
  CONSTRAINT `FK_9phi7xaxiornk7f3k237bji8u` FOREIGN KEY (`question_id`) REFERENCES `question` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_kdm8obpe6leusm1ymmvon7wew` FOREIGN KEY (`reviewer_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for question_status
-- ----------------------------
DROP TABLE IF EXISTS `question_status`;
CREATE TABLE `question_status`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created_on` datetime(0) NOT NULL,
  `updated_on` datetime(0) NOT NULL,
  `is_finish` bit(1) NOT NULL,
  `is_start` bit(1) NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `accessible_by_author` bit(1) NOT NULL,
  `accessible_by_facilitator` bit(1) NOT NULL,
  `accessible_by_quality_admin` bit(1) NOT NULL,
  `accessible_by_reviewer` bit(1) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `UK_kb1iiy21r8irey42pnd96p72c`(`name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for question_status_transition
-- ----------------------------
DROP TABLE IF EXISTS `question_status_transition`;
CREATE TABLE `question_status_transition`  (
  `created_on` datetime(0) NOT NULL,
  `updated_on` datetime(0) NOT NULL,
  `sequence` int(11) NULL DEFAULT NULL,
  `next_status_id` int(11) NOT NULL DEFAULT 0,
  `status_id` int(11) NOT NULL DEFAULT 0,
  PRIMARY KEY (`next_status_id`, `status_id`) USING BTREE,
  INDEX `FK_k7x5nc6556qxlqhs7ru5y0lws`(`status_id`) USING BTREE,
  CONSTRAINT `FK1tq2onehme80dnmfq6qluedsc` FOREIGN KEY (`status_id`) REFERENCES `question_status` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_4g1t9k1kluds2uuefpbyiignn` FOREIGN KEY (`next_status_id`) REFERENCES `question_status` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_k7x5nc6556qxlqhs7ru5y0lws` FOREIGN KEY (`status_id`) REFERENCES `question_status` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FKd5vq021449xyn29i0k9yag4ia` FOREIGN KEY (`next_status_id`) REFERENCES `question_status` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for question_type
-- ----------------------------
DROP TABLE IF EXISTS `question_type`;
CREATE TABLE `question_type`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created_on` datetime(0) NOT NULL,
  `updated_on` datetime(0) NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `UK_7ei21extes3bkiv5byn0pfrg5`(`name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 87 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for question_user
-- ----------------------------
DROP TABLE IF EXISTS `question_user`;
CREATE TABLE `question_user`  (
  `question_id` int(11) NOT NULL,
  `reviewer_id` int(11) NOT NULL,
  PRIMARY KEY (`question_id`, `reviewer_id`) USING BTREE,
  INDEX `FKb5fbdwebuyisdxbydv0k88aci`(`reviewer_id`) USING BTREE,
  CONSTRAINT `FKb5fbdwebuyisdxbydv0k88aci` FOREIGN KEY (`reviewer_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FKksmm4dmd9xk0u35us8lns45pq` FOREIGN KEY (`question_id`) REFERENCES `question` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for review_assessment
-- ----------------------------
DROP TABLE IF EXISTS `review_assessment`;
CREATE TABLE `review_assessment`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created_on` datetime(0) NOT NULL,
  `updated_on` datetime(0) NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `UK_5up7uru8ni1q5dungaxxk3dty`(`name`) USING BTREE,
  UNIQUE INDEX `UK_fk6dw6ne8j7dbjxnyyt3oufuc`(`name`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for review_comment
-- ----------------------------
DROP TABLE IF EXISTS `review_comment`;
CREATE TABLE `review_comment`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created_on` datetime(0) NOT NULL,
  `updated_on` datetime(0) NOT NULL,
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `is_final_review` bit(1) NOT NULL,
  `question_id` int(11) NOT NULL,
  `reviewer_id` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK_1c3t2dqlk78fnc2qhysp2p9v5`(`question_id`) USING BTREE,
  INDEX `FK_omf7d51gg0vs40946txened42`(`reviewer_id`) USING BTREE,
  CONSTRAINT `FK9u809qmhqj6ku0kpghv8w5rhg` FOREIGN KEY (`question_id`) REFERENCES `question` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_1c3t2dqlk78fnc2qhysp2p9v5` FOREIGN KEY (`question_id`) REFERENCES `question` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_omf7d51gg0vs40946txened42` FOREIGN KEY (`reviewer_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FKiyblxw0o4whqmo2dmxwdr297p` FOREIGN KEY (`reviewer_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 797 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created_on` datetime(0) NOT NULL,
  `updated_on` datetime(0) NOT NULL,
  `name` varchar(55) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `UK_8sewwnpamngi6b1dwaa88askk`(`name`) USING BTREE,
  UNIQUE INDEX `UK_7d8a768x6aiuvmsa24hqiharg`(`name`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for syllabus
-- ----------------------------
DROP TABLE IF EXISTS `syllabus`;
CREATE TABLE `syllabus`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created_on` datetime(0) NOT NULL,
  `updated_on` datetime(0) NOT NULL,
  `is_disabled` bit(1) NULL DEFAULT b'0',
  `level` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `version` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `isDisabled` bit(1) NULL DEFAULT b'0',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `unique_level_version`(`level`, `version`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 148 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created_on` datetime(0) NOT NULL,
  `updated_on` datetime(0) NOT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `enabled` bit(1) NOT NULL,
  `full_name` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `is_admin` bit(1) NOT NULL,
  `last_login` datetime(0) NULL DEFAULT NULL,
  `login_count` int(11) NOT NULL,
  `password` char(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `username` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `UK_ob8kqyqqgmefl0aco34akdtpe`(`email`) USING BTREE,
  UNIQUE INDEX `UK_sb8bbouer5wak8vyiiy4pf2bx`(`username`) USING BTREE,
  UNIQUE INDEX `UK_e6gkqunxajvyxl5uctpl2vl2p`(`email`) USING BTREE,
  UNIQUE INDEX `UK_jreodf78a7pl5qidfh43axdfb`(`username`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 139 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
