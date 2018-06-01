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
	`add_date` DATETIME,
	`refresh_date` DATETIME,
	`user_id` int NOT NULL,
	`sub_category_id` int NOT NULL,
	PRIMARY KEY (`advertisement_id`)
);

CREATE TABLE `image` (
	`image_id` int NOT NULL AUTO_INCREMENT,
	`image` MEDIUMTEXT NOT NULL,
	`advertisement_id` int NOT NULL,
	PRIMARY KEY (`image_id`)
);

CREATE TABLE `category` (
	`category_id` int NOT NULL AUTO_INCREMENT,
	`name` varchar(50) NOT NULL,
	PRIMARY KEY (`category_id`)
);

CREATE TABLE `sub_category` (
	`sub_category_id` int NOT NULL AUTO_INCREMENT,
	`name` varchar(50) NOT NULL,
	`category_id` int NOT NULL,
	PRIMARY KEY (`sub_category_id`)
);

ALTER TABLE `advertisement` ADD CONSTRAINT `advertisement_fk0` FOREIGN KEY (`user_id`) REFERENCES `user`(`user_id`);

ALTER TABLE `advertisement` ADD CONSTRAINT `advertisement_fk1` FOREIGN KEY (`sub_category_id`) REFERENCES `sub_category`(`sub_category_id`);

ALTER TABLE `image` ADD CONSTRAINT `image_fk0` FOREIGN KEY (`advertisement_id`) REFERENCES `advertisement`(`advertisement_id`);

ALTER TABLE `sub_category` ADD CONSTRAINT `sub_category_fk0` FOREIGN KEY (`category_id`) REFERENCES `category`(`category_id`);

INSERT INTO category (name) VALUES ("Electronics");
INSERT INTO category (name) VALUES ("Automotive");
INSERT INTO category (name) VALUES ("Real estate");
INSERT INTO category (name) VALUES ("Fasion");
INSERT INTO category (name) VALUES ("House & Garden");
INSERT INTO category (name) VALUES ("Sport & Hobby");
INSERT INTO category (name) VALUES ("Music & Education");
INSERT INTO category (name) VALUES ("For kids");

INSERT INTO sub_category (name, category_id) VALUES ("Computers", 1);
INSERT INTO sub_category (name, category_id) VALUES ("Laptops & Notebooks", 1);
INSERT INTO sub_category (name, category_id) VALUES ("Tablets", 1);
INSERT INTO sub_category (name, category_id) VALUES ("Mobile phones", 1);
INSERT INTO sub_category (name, category_id) VALUES ("Consoles", 1);
INSERT INTO sub_category (name, category_id) VALUES ("Games", 1);
INSERT INTO sub_category (name, category_id) VALUES ("AGD devices", 1);
INSERT INTO sub_category (name, category_id) VALUES ("Audio devices", 1);
INSERT INTO sub_category (name, category_id) VALUES ("Photography", 1);
INSERT INTO sub_category (name, category_id) VALUES ("TVs", 1);
INSERT INTO sub_category (name, category_id) VALUES ("Other", 1);

INSERT INTO sub_category (name, category_id) VALUES ("Cars", 2);
INSERT INTO sub_category (name, category_id) VALUES ("Motorcycles & Scooters", 2);
INSERT INTO sub_category (name, category_id) VALUES ("Vans & Trucks", 2);
INSERT INTO sub_category (name, category_id) VALUES ("Trailers", 2);
INSERT INTO sub_category (name, category_id) VALUES ("Parts & Tires", 2);
INSERT INTO sub_category (name, category_id) VALUES ("Car audio", 2);
INSERT INTO sub_category (name, category_id) VALUES ("Other", 2);

INSERT INTO sub_category (name, category_id) VALUES ("Flats", 3);
INSERT INTO sub_category (name, category_id) VALUES ("Houses", 3);
INSERT INTO sub_category (name, category_id) VALUES ("Plots", 3);
INSERT INTO sub_category (name, category_id) VALUES ("Offices", 3);
INSERT INTO sub_category (name, category_id) VALUES ("Warehouses", 3);
INSERT INTO sub_category (name, category_id) VALUES ("Other", 3);

INSERT INTO sub_category (name, category_id) VALUES ("Clothes", 4);
INSERT INTO sub_category (name, category_id) VALUES ("Boots", 4);
INSERT INTO sub_category (name, category_id) VALUES ("Underwear", 4);
INSERT INTO sub_category (name, category_id) VALUES ("Accesories", 4);
INSERT INTO sub_category (name, category_id) VALUES ("Cosmetics", 4);
INSERT INTO sub_category (name, category_id) VALUES ("Watches", 4);
INSERT INTO sub_category (name, category_id) VALUES ("Jewellery", 4);
INSERT INTO sub_category (name, category_id) VALUES ("Other", 4);

INSERT INTO sub_category (name, category_id) VALUES ("Furnitures", 5);
INSERT INTO sub_category (name, category_id) VALUES ("Tools", 5);
INSERT INTO sub_category (name, category_id) VALUES ("Building materials", 5);
INSERT INTO sub_category (name, category_id) VALUES ("Other", 5);

INSERT INTO sub_category (name, category_id) VALUES ("Bikes", 6);
INSERT INTO sub_category (name, category_id) VALUES ("Skis & Snowboard", 6);
INSERT INTO sub_category (name, category_id) VALUES ("Fitness", 6);
INSERT INTO sub_category (name, category_id) VALUES ("Fishing", 6);
INSERT INTO sub_category (name, category_id) VALUES ("Other", 6);

INSERT INTO sub_category (name, category_id) VALUES ("Instruments", 7);
INSERT INTO sub_category (name, category_id) VALUES ("Discs", 7);
INSERT INTO sub_category (name, category_id) VALUES ("Books", 7);
INSERT INTO sub_category (name, category_id) VALUES ("School articles", 7);
INSERT INTO sub_category (name, category_id) VALUES ("Other", 7);

INSERT INTO sub_category (name, category_id) VALUES ("Toys", 8);
INSERT INTO sub_category (name, category_id) VALUES ("Board games", 8);
INSERT INTO sub_category (name, category_id) VALUES ("Strollers", 8);
INSERT INTO sub_category (name, category_id) VALUES ("Seats & Carriers", 8);
INSERT INTO sub_category (name, category_id) VALUES ("Other", 8);
