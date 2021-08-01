/*
SQLyog Ultimate v13.1.1 (64 bit)
MySQL - 5.5.48 : Database - electronic_commerce
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`electronic_commerce` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `electronic_commerce`;

/*Table structure for table `tf_c_goods` */

DROP TABLE IF EXISTS `tf_c_goods`;

CREATE TABLE `tf_c_goods` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `product_code` varchar(100) DEFAULT NULL COMMENT '商品编码',
  `name` varchar(200) DEFAULT NULL COMMENT '商品名称',
  `type` varchar(50) DEFAULT NULL COMMENT '分类',
  `weight` double(10,2) DEFAULT NULL COMMENT '重量',
  `status` char(1) DEFAULT NULL COMMENT '是否有效:0,无效,1,有效',
  `supplier_id` varchar(20) DEFAULT NULL COMMENT '供应商编号',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Table structure for table `tf_c_orders` */

DROP TABLE IF EXISTS `tf_c_orders`;

CREATE TABLE `tf_c_orders` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户编号',
  `good_id` bigint(20) DEFAULT NULL COMMENT '商品编号',
  `amount` double(10,2) DEFAULT NULL COMMENT '金额',
  `status` char(1) DEFAULT NULL COMMENT '状态:0无效,1,有效',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='订单表';

/*Table structure for table `tf_c_shopping_cart` */

DROP TABLE IF EXISTS `tf_c_shopping_cart`;

CREATE TABLE `tf_c_shopping_cart` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `orders_id` bigint(20) DEFAULT NULL COMMENT '订单编号',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户编号',
  `preferential_price` double(10,2) DEFAULT NULL COMMENT '优惠价格',
  `total` double(10,2) DEFAULT NULL COMMENT '总价',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='购物车表';

/*Table structure for table `tf_c_supplier` */

DROP TABLE IF EXISTS `tf_c_supplier`;

CREATE TABLE `tf_c_supplier` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `name` varchar(200) DEFAULT NULL COMMENT '供应商名称',
  `registration_number` varchar(20) DEFAULT NULL COMMENT '注册号',
  `contacts_name` varchar(100) DEFAULT NULL COMMENT '联系人名称',
  `phone` varchar(20) DEFAULT NULL COMMENT '联系方式',
  `status` char(1) DEFAULT NULL COMMENT '是否有效:0,无效,1,有效',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='供应商表';

/*Table structure for table `tf_c_user` */

DROP TABLE IF EXISTS `tf_c_user`;

CREATE TABLE `tf_c_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `name` varchar(100) DEFAULT NULL COMMENT '用户名',
  `pwd` varchar(100) DEFAULT NULL COMMENT '密码',
  `alias` varchar(100) DEFAULT NULL COMMENT '别名',
  `certificate_num` varchar(20) DEFAULT NULL COMMENT '身份证号码',
  `status` char(1) DEFAULT NULL COMMENT '是否有效:0,无效,1,效果',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户表';

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
