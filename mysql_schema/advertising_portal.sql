-- DROP DATABASE advertising_portal;
CREATE DATABASE advertising_portal;
USE advertising_portal;

CREATE TABLE `user` (
	`user_id` int NOT NULL AUTO_INCREMENT,
	`email` varchar(50) NOT NULL UNIQUE,
	`password` varchar(255) NOT NULL,
	`name` varchar(20) NOT NULL,
	`city` varchar(50) NOT NULL,
	`phone_number` varchar(10) NOT NULL,
	`role` varchar(20) NOT NULL,
	`enabled` bool NOT NULL,
	PRIMARY KEY (`user_id`)
);

CREATE TABLE `advertisement` (
	`advertisement_id` int NOT NULL AUTO_INCREMENT,
	`title` varchar(50) NOT NULL,
	`description` TEXT(1000) NOT NULL,
	`price` int NOT NULL,
	`status` varchar(20) NOT NULL,
	`add_date` DATETIME NOT NULL,
	`refresh_date` DATETIME NOT NULL,
	`user_id` int NOT NULL,
	`sub_category_id` int NOT NULL,
	PRIMARY KEY (`advertisement_id`)
);

CREATE TABLE `image` (
	`image_id` int NOT NULL AUTO_INCREMENT,
	`image` blob(1024) NOT NULL,
	`advertisement_id` int NOT NULL,
	PRIMARY KEY (`image_id`)
);

CREATE TABLE `category` (
	`category_id` int NOT NULL,
	`name` varchar(50) NOT NULL,
	`icon` blob(1024) NOT NULL,
	PRIMARY KEY (`category_id`)
);

CREATE TABLE `sub_category` (
	`sub_category_id` int NOT NULL,
	`name` varchar(50) NOT NULL,
	`category_id` int NOT NULL,
	PRIMARY KEY (`sub_category_id`)
);

ALTER TABLE `advertisement` ADD CONSTRAINT `advertisement_fk0` FOREIGN KEY (`user_id`) REFERENCES `user`(`user_id`);

ALTER TABLE `advertisement` ADD CONSTRAINT `advertisement_fk1` FOREIGN KEY (`sub_category_id`) REFERENCES `sub_category`(`sub_category_id`);

ALTER TABLE `image` ADD CONSTRAINT `image_fk0` FOREIGN KEY (`advertisement_id`) REFERENCES `advertisement`(`advertisement_id`);

ALTER TABLE `sub_category` ADD CONSTRAINT `sub_category_fk0` FOREIGN KEY (`category_id`) REFERENCES `category`(`category_id`);

