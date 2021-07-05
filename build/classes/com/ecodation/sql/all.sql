CREATE SCHEMA `blogdb` DEFAULT CHARACTER SET utf8 ;

use blogdb;

CREATE TABLE `blogdb`.`blog` (
  `blog_id` INT NOT NULL AUTO_INCREMENT,
  `header` VARCHAR(450) NULL,
  `content` VARCHAR(5000) NULL,
  `blog_categories` VARCHAR(50) NULL,
  `image_type` VARCHAR(45) NULL,
  `image_name` VARCHAR(45) NULL,
  `image_path` VARCHAR(250) NULL,
  `creation_date` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`blog_id`));
  
  CREATE TABLE `blogdb`.`social` (
  `social_id` INT NOT NULL AUTO_INCREMENT,
  `social_name` VARCHAR(85) NULL,
  `social_icon` VARCHAR(65) NULL,
  `social_url` VARCHAR(150) NULL,
  `creation_date` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`social_id`));
  
  CREATE TABLE `blogdb`.`sss` (
  `sss_id` INT NOT NULL AUTO_INCREMENT,
  `header` VARCHAR(250) NULL DEFAULT 'header alanı girilmedi',
  `content` VARCHAR(800) NULL DEFAULT 'icerik alanı girilmedi',
  `url` VARCHAR(150) NULL DEFAULT '#',
  `creation_date` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`sss_id`));
