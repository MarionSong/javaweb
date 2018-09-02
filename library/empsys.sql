/*
SQLyog 企业版 - MySQL GUI v8.14 
MySQL - 5.5.59-MariaDB : Database - empsys
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`empsys` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `empsys`;

/*Table structure for table `kungfu` */

DROP TABLE IF EXISTS `kungfu`;

CREATE TABLE `kungfu` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) DEFAULT NULL COMMENT '武功名字',
  `parentId` int(10) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL COMMENT '武功描述',
  `note` text COMMENT '详细说明',
  `createTime` datetime DEFAULT NULL,
  `updateTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8;

/*Data for the table `kungfu` */

insert  into `kungfu`(`id`,`name`,`parentId`,`description`,`note`,`createTime`,`updateTime`) values (1,'总览',NULL,NULL,NULL,'2018-08-30 10:38:43','2018-08-30 10:38:43'),(2,'雷击术',1,'基础术法，可以简单操纵雷电之术',NULL,'2018-08-30 10:38:43','2018-08-30 10:38:43'),(3,'第一层',2,NULL,'以丹田为引，吸引身边雷元素到体内，日夜修炼，可强身健体，借雷洗髓','2018-08-30 10:38:43','2018-08-30 10:38:43'),(4,'第二层',2,NULL,'引雷元素入丹田，小成后，成为雷元素气旋，生生不息，若有雷丹辅助，可有事半功倍之效。','2018-08-30 10:38:43','2018-08-30 10:38:43'),(5,'第三层',2,NULL,'引雷如体，打破丹田气旋，使其遍布全身，最终引入手脚，以丹田为中心，形成五个气旋至此方为大成，虽然过程凶险\r\n但是大成之后面对数倍于自身的敌人可立于不败之地，在面对一般的天劫时也可从容而过。','2018-08-30 10:38:43','2018-08-30 10:38:43'),(6,'雷道四绝天',1,'大成之后拥有毁天灭地之威，举手投足间，山崩地裂，寸草不生',NULL,'2018-08-30 10:38:43','2018-08-30 10:38:43'),(7,'第一层',6,NULL,'理解上古雷兽的控雷精髓，增加身体对雷的亲和度，更能增快元气的恢复','2018-08-30 10:38:43','2018-08-30 10:38:43'),(8,'第二层',6,NULL,'经历九九八十一道雷劫的洗礼，重塑己身，身体硬如金石。','2018-08-30 10:38:43','2018-08-30 10:38:43'),(9,'第三层',6,NULL,'御雷而行，操纵天威，于雷池中不断淬炼，成为极品雷体','2018-08-30 10:38:43','2018-08-30 10:38:43'),(10,'第四层',6,NULL,'领悟雷道奥义后探索自身化雷电为金、为木、为火、为土，五行相生，生生不息','2018-08-30 10:38:56','2018-08-30 10:38:56'),(18,'火球术',1,'剧烈的高温焚烬一切物体',NULL,'2018-08-30 12:29:16','2018-08-30 21:35:10'),(28,'第一层',18,NULL,'卧草。。。','2018-08-30 20:48:31','2018-08-30 21:26:27'),(29,'第二层',18,NULL,'厉害。。。','2018-08-30 20:48:38','2018-08-30 21:08:53'),(30,'第三层',18,NULL,'牛逼。。。','2018-08-30 20:48:46','2018-08-30 21:17:20'),(34,'冰冻术',1,'一念之间，千里冰封',NULL,'2018-08-30 21:40:58','2018-08-30 22:14:21'),(35,'第一层',34,NULL,'通过经脉，感知身体旁的冰属性元素，引入体内，并围绕丹田旋转','2018-08-30 22:16:24','2018-08-30 22:17:43'),(36,'第二层',34,NULL,'压缩冰元素，由气态转为液态','2018-08-30 22:17:31','2018-08-30 22:17:31'),(37,'第三层',34,NULL,'压缩冰属性从液态变为固态','2018-08-30 22:18:43','2018-08-30 22:18:43'),(38,'火焰术',1,'沾物即燃',NULL,'2018-08-31 19:40:31','2018-08-31 22:45:06'),(39,'第一层',38,NULL,'燃烧','2018-08-31 21:08:29','2018-08-31 21:08:29');

/*Table structure for table `menus` */

DROP TABLE IF EXISTS `menus`;

CREATE TABLE `menus` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL COMMENT '资源名称',
  `url` varchar(200) DEFAULT NULL COMMENT '资源URL',
  `type` int(11) DEFAULT NULL COMMENT '类型     1：菜单   2：按钮',
  `sort` int(11) DEFAULT NULL COMMENT '排序',
  `note` varchar(100) DEFAULT NULL COMMENT '备注',
  `parentId` int(11) DEFAULT NULL COMMENT '父菜单ID，一级菜单为0',
  `permission` varchar(500) DEFAULT NULL COMMENT '授权(如：user:create)',
  `createdTime` datetime DEFAULT NULL COMMENT '创建时间',
  `modifiedTime` datetime DEFAULT NULL COMMENT '修改时间',
  `createdUser` varchar(20) DEFAULT NULL COMMENT '创建用户',
  `modifiedUser` varchar(20) DEFAULT NULL COMMENT '修改用户',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=131 DEFAULT CHARSET=utf8 COMMENT='资源管理';

/*Data for the table `menus` */

insert  into `menus`(`id`,`name`,`url`,`type`,`sort`,`note`,`parentId`,`permission`,`createdTime`,`modifiedTime`,`createdUser`,`modifiedUser`) values (8,'系统管理','请求路径',1,8,NULL,NULL,'sys:list','2017-07-12 15:15:59','2017-07-21 11:16:00','admin','admin'),(24,'系统配置','请求路径',1,24,NULL,8,NULL,'2017-07-12 15:15:59','2017-07-12 15:15:59','admin','admin'),(25,'日志管理','请求路径',1,25,NULL,8,NULL,'2017-07-12 15:15:59','2017-07-12 15:15:59','admin','admin'),(45,'用户管理','user/listUI.do',1,45,NULL,8,'sys:user:view','2017-07-12 15:15:59','2017-07-21 17:36:01','admin','admin'),(46,'菜单管理','menu/listUI.do',1,46,NULL,8,'sys:menu:view','2017-07-12 15:15:59','2017-07-21 17:36:16','admin','admin'),(47,'角色管理','role/listUI.do',1,47,NULL,8,'sys:role:view','2017-07-12 15:15:59','2017-07-21 17:38:03','admin','admin'),(48,'组织管理','请求路径',1,48,NULL,8,'sys:org:view','2017-07-12 15:15:59','2017-07-21 18:37:57','admin','admin'),(115,'查看','',2,1,NULL,46,'sys:menu:view','2017-07-13 16:33:41','2017-07-21 11:09:05',NULL,NULL),(116,'新增','',2,2,NULL,46,'sys:menu:add','2017-07-13 16:34:02','2017-07-21 11:09:22',NULL,NULL),(117,'修改','',2,3,NULL,46,'sys:menu:update','2017-07-13 16:34:25','2017-07-21 11:09:45',NULL,NULL),(118,'删除','',2,4,NULL,46,'sys:menu:delete','2017-07-13 16:34:46','2017-07-21 11:10:12',NULL,NULL),(119,'查看','',2,1,NULL,45,'sys:user:view','2017-07-13 16:35:05','2017-07-21 11:12:46',NULL,NULL),(120,'查看','',2,1,NULL,47,'sys:role:view','2017-07-13 16:35:26','2017-07-21 11:13:43',NULL,NULL),(126,'新增','',2,2,NULL,45,'sys:user:add','2017-07-21 11:11:34','2017-07-21 11:11:34',NULL,NULL),(127,'修改','',2,3,NULL,45,'sys:user:update','2017-07-21 11:11:56','2017-07-21 11:11:56',NULL,NULL),(128,'新增','',2,2,NULL,47,'sys:role:add','2017-07-21 11:14:24','2017-07-21 11:14:24',NULL,NULL),(129,'修改','',2,3,NULL,47,'sys:role:update','2017-07-21 11:14:48','2017-07-21 11:14:48',NULL,NULL),(130,'删除','',2,4,NULL,47,'sys:role:delete','2017-07-21 11:15:09','2017-07-21 11:15:09',NULL,NULL);

/*Table structure for table `role_menus` */

DROP TABLE IF EXISTS `role_menus`;

CREATE TABLE `role_menus` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) DEFAULT NULL COMMENT '角色ID',
  `menu_id` int(11) DEFAULT NULL COMMENT 'ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1250 DEFAULT CHARSET=utf8 COMMENT='角色与菜单对应关系';

/*Data for the table `role_menus` */

insert  into `role_menus`(`id`,`role_id`,`menu_id`) values (1232,1,8),(1233,1,24),(1234,1,25),(1235,1,45),(1236,1,119),(1237,1,126),(1238,1,127),(1239,1,46),(1240,1,115),(1241,1,116),(1242,1,117),(1243,1,118),(1244,1,47),(1245,1,120),(1246,1,128),(1247,1,129),(1248,1,130),(1249,1,48);

/*Table structure for table `roles` */

DROP TABLE IF EXISTS `roles`;

CREATE TABLE `roles` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL COMMENT '角色名称',
  `createdTime` datetime DEFAULT NULL COMMENT '创建时间',
  `modifiedTime` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=utf8 COMMENT='角色';

/*Data for the table `roles` */

insert  into `roles`(`id`,`name`,`createdTime`,`modifiedTime`) values (1,'admin','2018-08-31 15:33:11','2018-08-31 15:33:11'),(45,'zm','2018-08-31 15:33:11','2018-08-31 15:33:11'),(46,'zl','2018-08-31 15:33:11','2018-08-31 15:33:11'),(47,'nd','2018-08-31 15:33:11','2018-08-31 15:33:11'),(48,'wd','2018-08-31 15:33:11','2018-08-31 15:33:11');

/*Table structure for table `user_role` */

DROP TABLE IF EXISTS `user_role`;

CREATE TABLE `user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL COMMENT '用户ID',
  `role_id` int(11) DEFAULT NULL COMMENT '角色ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=69 DEFAULT CHARSET=utf8 COMMENT='用户与角色对应关系';

/*Data for the table `user_role` */

insert  into `user_role`(`id`,`user_id`,`role_id`) values (65,1,1),(66,2,46),(67,3,47),(68,2,45);

/*Table structure for table `users` */

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `id` int(11) NOT NULL DEFAULT '0',
  `username` varchar(50) NOT NULL COMMENT '用户名',
  `password` varchar(100) DEFAULT NULL COMMENT '密码',
  `createdTime` datetime DEFAULT NULL COMMENT '创建时间',
  `modifiedTime` datetime DEFAULT NULL COMMENT '修改时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `users` */

insert  into `users`(`id`,`username`,`password`,`createdTime`,`modifiedTime`) values (1,'admin','123456','2018-08-31 12:24:46','2018-08-31 12:24:46'),(2,'daoxuan','123456','2018-08-31 12:24:46','2018-08-31 12:24:46'),(3,'zhangxiaofan','123456','2018-08-31 12:24:46','2018-08-31 12:24:46');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
