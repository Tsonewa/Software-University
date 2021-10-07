<-- 0.Create DB minions -->

CREATE SCHEMA `minions`;

<-- 1. Create Tables -->

CREATE TABLE `minions` (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(45) NOT NULL,
`age` INT);

CREATE TABLE `towns`(
`town_id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(45) NOT NULL);

<-- 02.Alter Table -->

ALTER TABLE `minions`
ADD COLUMN `town_id` INT NOT NULL;

ALTER TABLE `minions`
ADD CONSTRAINT `fk_town_minions`
FOREIGN KEY minions(`town_id`)
REFERENCES towns(`id`); 

<-- 03.Insert Records in both tables -->

INSERT INTO `towns`
VALUES
(1,'Sofia'), 
(2,'Plovdiv'),
(3,'Varna');

INSERT INTO `minions`
VALUES
(1,'Kevin', 22, 1),
(2,'Bob', 15, 3),
(3,'Steward', null, 2);

<-- 04.Truncate table minions -->

TRUNCATE TABLE `minions`;

<-- 05.Drop all tables -->

// DROP SCHEMA `minions`;
DROP TABLE `minions`;
DROP TABLE `towns`;

<-- 06.Create table people -->

CREATE TABLE `people`(
`id` INT UNIQUE PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(200) NOT NULL,
`picture` MEDIUMBLOB,
`height` DECIMAL(10,2),
`weight` DECIMAL(10,2),
`gender` CHAR(1) NOT NULL,
`birthdate` DATE NOT NULL,
`biography` TEXT);

INSERT INTO `people` (`name`, `height`, `weight`, `gender`, `birthdate`, `biography`)
VALUES
('Harvey', 1.95, 85.2, 'm', '1985-10-10', 'Harvey Reginald Specter, J.D. is a former corporate attorney, one of the name partners at Specter Litt Wheeler Williams, the managing partner of Specter Litt, and a former Assistant District Attorney for the New York County District Attorneys Office. He is also the husband of Donna Paulsen.After being promoted to the position of senior partner at Pearson Hardman in 2011, he hired Mike Ross, a veritable genius with a photographic memory who was able to pass the bar exam despite not attending law school, as his associate.'),
('Mike', 1.80, 85.56, 'm', '1990-12-15', null),
('Luis', 1.70, 110.10, 'm', '1980-12-10', null),
('Tina', 1.80, 50.10, 'f', '1980-11-08', null),
('Donna', 1.60, 45.10, 'f', '1980-12-12', null);

<-- 07.Create table users -->

CREATE TABLE `users` (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`username` VARCHAR(30) NOT NULL UNIQUE,
`password` VARCHAR(26) NOT NULL,
`profile_picture` MEDIUMBLOB,
`last_login_time` TIME,
`is_deleted` BOOLEAN);

INSERT INTO `users`
VALUES
(1, 'first', '123', 'url;test', '03:15:58', false),
(2, 'second', '1234', 'url;test2', '04:25:58', true),
(3, 'third', '12345', 'url;test3', '05:55:58', false),
(4, 'fourth', '123248', 'url;test4', '06:15:59', true),
(5, 'fifth', '123456', 'url;test5', '07:15:58', false);

<-- 08.Change Primary key -->

/* Using SQL queries modify table users from the previous task.
First remove current primary key then create new primary key 
that would be combination of fields id and username. The initial 
primary key name on id is pk_users */

ALTER TABLE `users`
DROP PRIMARY KEY,
ADD CONSTRAINT `fk_users`
PRIMARY KEY `users`(`id`, `username`);


<-- 09.Set default value of a field -->

ALTER TABLE `users` 
MODIFY `last_login_time` TIMESTAMP DEFAULT NOW();

<-- 10. Set unique Field -->

ALTER TABLE `users`
DROP PRIMARY KEY,
ADD CONSTRAINT `fk_users`
PRIMARY KEY `users`(`id`);

ALTER TABLE `users`
MODIFY `username` VARCHAR(30) UNIQUE NOT NULL;

<-- 11.Movies Database -->

CREATE schema `movies`;

CREATE TABLE `directors`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`director_name` VARCHAR(50) NOT NULL,
`notes` VARCHAR(200));

CREATE TABLE `genres`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`genre_name` VARCHAR(45) NOT NULL,
`notes` VARCHAR(200));

CREATE TABLE `categories`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`category_name` VARCHAR(45) NOT NULL,
`notes` VARCHAR(200));

CREATE TABLE `movies`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`title` VARCHAR(45)NOT NULL,
`director_id` INT,
`copyright_year` YEAR,
`lenght` INT,
`genre_id` INT,
`category_id` INT,
`rating` DECIMAL(3,1),
`notes` VARCHAR(200));

ALTER TABLE `movies`
ADD CONSTRAINT `fk_movies_directors`
FOREIGN KEY (`director_id`)
REFERENCES `directors`(`id`),
ADD CONSTRAINT `fk_genre_movies`
FOREIGN KEY (`genre_id`)
REFERENCES `genres`(`id`),
ADD CONSTRAINT `fk_movies_categories`
FOREIGN KEY (`category_id`)
REFERENCES `categories`(`id`);

INSERT INTO `categories` (`category_name`, `notes`)
VALUES
('Comedy', 'Comedy is a genre of film in which the main emphasis is on humour.'),
('Horror', 'Horror films may incorporate incidents of physical violence and psychological terror'),
('Action', 'Action film is a film genre in which the protagonist or protagonists are thrust into a series of events that typically include violence, extended fighting, physical feats, rescues and frantic chases.'),
('Family', 'Family film is a genre that is contains appropriate content for younger viewers.'),
('Sci-Fi', 'Science fiction is a genre of speculative fiction that typically deals with imaginative and futuristic concepts such as advanced science and technology.');

INSERT INTO `genres` (`genre_name`, `notes`)
VALUES
('Funny', 'Comedy is a genre of film in which the main emphasis is on humour.'),
('Historical', 'Horror films may incorporate incidents of physical violence and psychological terror'),
('Danger', 'Action film is a film genre in which the protagonist or protagonists are thrust into a series of events that typically include violence, extended fighting, physical feats, rescues and frantic chases.'),
('Hapiness', 'Family film is a genre that is contains appropriate content for younger viewers.'),
('Fantasy', 'Science fiction is a genre of speculative fiction that typically deals with imaginative and futuristic concepts such as advanced science and technology.');

INSERT INTO `directors` (`director_name`, `notes`)
VALUES
('Quentin Tarantino', 'Pulp fiction'),
('John Michel McDonagh', 'The guard'),
('Joon-ho Bong', 'Snowpiercer'),
('Guy Ritchie', 'Lock, stock and two smoking'),
('Alfred Hitchcock', 'North by Northwest');

INSERT INTO `movies` (`title`,`director_id`,`copyright_year`, `lenght`,
`genre_id`, `category_id`, `rating`, `notes`)
VALUES
('first', 1, '1990-10-10', 234, 2, 3, 9.8, 'notes...'),
('second', 2, '1980-10-10', 295, 3, 3, 10.8, 'notes...'),
('third', 4, '1970-10-10', 144, 4, 4, 5.8, 'notes...'),
('fourth', 5, '1960-10-10', 269, 5, 1, 9.1, 'notes...'),
('fifth', 3, '1950-10-08', 68, 1, 2, 8.0, 'notes...');

<-- 12.Car rental database -->

CREATE TABLE `categories` (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`category` VARCHAR(45) NOT NULL,
`daily_rate` DECIMAL(4,2) NOT NULL,
`weekly_rate` DECIMAL(4,2) NOT NULL,
`monthly_rate` DECIMAL(4,2) NOT NULL);

CREATE TABLE `cars`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`plate_number` VARCHAR(10) NOT NULL,
`make` VARCHAR(45),
`model` VARCHAR(30) NOT NULL,
`car_year` YEAR,
`category_id` INT,
`doors` INT,
`picture` BLOB,
`car_condition` VARCHAR(200),
`is_available` BOOLEAN NOT NULL);

ALTER TABLE `cars`
ADD CONSTRAINT `fk_category_id`
FOREIGN KEY (`category_id`)
REFERENCES `categories`(`id`);

CREATE TABLE `employees` (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`first_name` VARCHAR(30) NOT NULL,
`last_name` VARCHAR(30) NOT NULL,
`title` VARCHAR(20),
`notes` TEXT
);

CREATE TABLE `customers`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`driver_licence_number` VARCHAR(30) NOT NULL,
`full_name` VARCHAR(50) NOT NULL,
`address` VARCHAR(50) NOT NULL,
`city` VARCHAR(20) NOT NULL,
`zip_code` INT,
`notes` TEXT
);

CREATE TABLE `rental_orders` (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`employee_id` INT,
`customer_id` INT,
`car_id` INT,
`car_condition` VARCHAR(200),
`tank_level` INT NOT NULL,
`kilometrage_start` INT NOT NULL,
`kilometrage_end` INT NOT NULL,
`total_kilometrage` INT NOT NULL,
`start_date` DATE NOT NULL,
`end_date` DATE NOT NULL,
`total_days` INT NOT NULL,
`rate_applied` DECIMAL(10,2),
`tax_rate` DECIMAL(10,2),
`order_status` BOOL NOT NULL,
`notes` TEXT);

ALTER TABLE `rental_orders`
ADD CONSTRAINT `fk_rental_orders_employees`
FOREIGN KEY (`employee_id`)
REFERENCES `employees`(`id`),
ADD CONSTRAINT `fk_rental_orders_customers`
FOREIGN KEY (`customer_id`)
REFERENCES `customers`(`id`),
ADD CONSTRAINT `fk_rental_orders_cars`
FOREIGN KEY (`car_id`)
REFERENCES `cars`(`id`);

INSERT INTO `categories` (`category`,`daily_rate`, `weekly_rate`, `monthly_rate`)
VALUES
('Standart', 12.2, 15.2,15.5),
('Lux', 12.6, 5.2,10.5),
('Budget', 11.2, 1.2,8.5);

INSERT INTO `cars` (`plate_number`, `make`, `model`, `car_year`, `category_id`, `doors`, `picture`, `car_condition`, `is_available`)
VALUES
('CO5968AX', 'AUDI', 'A8', '2015', 3, 2, 'bloc;url', 'Perfect', true),
('CA1000EP', 'VW', 'Tuareg', '2020', 4, 4, 'bloc;url', 'Good', false),
('EH1963PS', 'Toyota', 'Corolla', '2002', 5, 5, 'bloc;url', 'Fair', true);

INSERT INTO `customers`
VALUES
(1, '125654945', 'Jesus Garcia', '131A West ave', 'Mexico City', 1562, null),
(2, '12565A54', 'John Smith', '131W 17th Str, CA', 'San Bernardino', 1555, null),
(3, 'AH1581D5', 'Mike Specter', 'Forth Ave, AK', 'Cordova', 1000, null);

INSERT INTO `employees`
VALUES
(1, 'Mike', 'Ross', 'Mr', null),
(2, 'Luis', 'Lith', 'Mr', null),
(3, 'Donna', 'Polsen', 'Mrs', null);

INSERT INTO `rental_orders` 
VALUES
(1, 1, 2, 5, 'Fair', 50, 12564, 12515, 585, '2021-12-12', '2021-12-14', 2, 10.2, 10.2, 1, null),
(2, 2, 3, 6, 'Fair', 50, 12564, 12515, 585, '2021-12-12', '2021-12-14', 2, 10.2, 10.2, 1, null),
(3, 2, 3, 4, 'Fair', 50, 12564, 12515, 585, '2021-12-12', '2021-12-14', 2, 10.2, 10.2, 1, null);

<-- 13.Basic insert -->

INSERT INTO `towns` (`name`)
VALUES
('Sofia'),
('Plovdiv'),
('Varna'),
('Burgas');

INSERT INTO `departments` (`name`)
VALUES
('Engineering'),
('Sales'),
('Marketing'),
('Software Development'),
('Quality Assurance');

INSERT INTO `addresses` (`address_text`, `town_id`)
VALUES
('first address', 1),
('second address', 2),
('third address', 3);

INSERT INTO `employees` (`first_name`, `middle_name`, `last_name`, `job_title`, `department_id`, `hire_date`, `salary`, `address_id`)
VALUES
('Ivan', 'Ivanov', 'Ivanov', '.NET Developer', 4, '2013-02-01', 3500.00, 1),
('Petar', 'Petrov', 'Petrov', 'Senior Engineer', 1, '2004-03-02', 4000.00, 2),
('Maria', 'Petrova', 'Ivanova', 'Intern', 5, '2016-08-28', 525.25, 3),
('Georgi', 'Terziev', 'Ivanov', 'CEO', 2, '2007-09-12', 3000.00, 1),
('Peter', 'Pan', 'Pan', 'Intern', 3, '2016-08-28', 599.88, 2);


<-- 14. Basic Select All Fields --> 

SELECT * FROM `towns`;
SELECT * FROM `departments`;
SELECT * FROM `employees`;

<-- 15.Basic Select All Field And Order Them -->

SELECT * FROM `towns`
ORDER BY `name` ASC;

SELECT * FROM `departments`
ORDER BY `name` ASC;

SELECT * FROM `employees`
ORDER BY `salary` DESC;

<-- 16.Basic Select Some Fields -->

 SELECT `name` FROM `towns`;

SELECT `name` FROM `departments`;

SELECT `first_name`, `last_name`, `job_title`, `salary` FROM `employees`;

<-- 17. Increase Employees Salary -->

UPDATE `employees`
SET `salary` = `salary` * 1.1; 

SELECT `salary` FROM `employees`;

<-- 18. Delete All Records -->

TRUNCATE `soft_uni`;

