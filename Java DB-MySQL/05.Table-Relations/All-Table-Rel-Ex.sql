CREATE SCHEMA `relations`;
USE `relations`;

-- 1. One-to-One Relation --

CREATE TABLE `passports` (
`passport_id` INT PRIMARY KEY NOT NULL UNIQUE,
`passport_number` CHAR(8) NOT NULL 
);

CREATE TABLE `persons` (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`first_name` VARCHAR (30) NOT NULL,
`salary` FLOAT(10,2),
`passport_id` INT UNIQUE
);
ALTER TABLE `persons`
ADD CONSTRAINT `fk_person_passport`
FOREIGN KEY (`passport_id`)
REFERENCES `passports`(`passport_id`);

INSERT INTO `passports` 
VALUES 
(101, 'N34FG21B'),
(102, 'K65LO4R7'),
(103, 'ZE657QP2');

INSERT INTO `persons` (`first_name`, `salary`, `passport_id`)
VALUES
('Roberto', 43300.00, 102),
('Tom', 56100.00, 103),
('Yana', 60200.00, 101);

 -- 2.One-To-Many Relation --
 
 CREATE TABLE `manufacturers` (
 `manufacturer_id` INT PRIMARY KEY AUTO_INCREMENT,
 `name` VARCHAR(20) NOT NULL,
 `established_on` DATE NOT NULL
 );
 
 CREATE TABLE `models` (
 `model_id` INT PRIMARY KEY NOT NULL,
 `name` VARCHAR(45) NOT NULL,
 `manufacturer_id` INT);
 
 ALTER TABLE `models`
 ADD CONSTRAINT `fk_models_manufacturers`
 FOREIGN KEY (`manufacturer_id`)
 REFERENCES `manufacturers`(`manufacturer_id`);
 
 INSERT INTO `manufacturers` (`name`, `established_on`)
 VALUES
 ('BMW', '1916-03-01'),
 ('Tesla', '2003-01-01'),
 ('Lada', '1996-05-01');
 
 INSERT INTO `models` VALUES
 (101, 'X1', 1),
 (102, 'i6', 1),
 (103, 'Model S', 2),
 (104, 'Model X', 2),
 (105, 'Model 3', 2),
 (106, 'Nova', 3);
 
  -- 3. Many-To-Many Relation --
  
  CREATE TABLE `students` (
  `student_id` INT PRIMARY KEY AUTO_INCREMENT,
  `name` VARCHAR(30) NOT NULL
  );
  
  INSERT INTO `students` (`name`)
  VALUES
  ('Mila'), ('Toni'), ('Ron');
  
  CREATE TABLE `exams` (
  `exam_id` INT PRIMARY KEY auto_increment,
  `name` VARCHAR(45) NOT NULL
  );
  
  INSERT INTO `exams` VALUES (101, 'Spring MVC'), (102, 'Neo4j'), (103, 'Oracle 11g');
  
  CREATE TABLE `students_exams` (
  `student_id` INT NOT NULL,
  `exam_id` INT NOT NULL
  );
  
  INSERT INTO `students_exams` 
  VALUES 
  (1,101), 
  (1,102), 
  (2,101), 
  (3,103), 
  (2,102), 
  (2,103);
  
  ALTER TABLE `students_exams`
  ADD CONSTRAINT `fk_students_exams_students`
  foreign key (`student_id`)
  REFERENCES `students`(`student_id`),
  ADD CONSTRAINT `fk_students_exams_exams`
  FOREIGN KEY (`exam_id`)
  REFERENCES `exams`(`exam_id`);
 
 -- 4. Self-Referencing Table --
 
 CREATE TABLE `teachers` (
 `teacher_id` INT PRIMARY KEY NOT NULL,
 `name` VARCHAR (30) NOT NULL,
 `manager_id` INT,
 CONSTRAINT `fk_teacher_manager`
 FOREIGN KEY (`manager_id`)
 REFERENCES `teachers`(`teacher_id`));
 
 INSERT INTO `teachers` (`teacher_id`, `name`)
 VALUES
 (101, 'John'),
 (102, 'Maya'),
 (103, 'Silvia'),
 (104, 'Ted'),
 (105, 'Mark'),
 (106, 'Greta');
 
 UPDATE `teachers`
 SET `manager_id` = 106
 WHERE `teacher_id` IN (102, 103);

 UPDATE `teachers`
 SET `manager_id` = 105
 WHERE `teacher_id` = 104;
 
UPDATE `teachers`
 SET `manager_id` = 101
 WHERE `teacher_id` IN (105, 106);
 
-- 5. Online Store Database --

CREATE TABLE `item_types` (
`item_type_id` INT PRIMARY KEY auto_increment,
`name` VARCHAR(50)
);

CREATE TABLE `items` (
`item_id` INT PRIMARY KEY auto_increment,
`name` VARCHAR(50) NOT NULL,
`item_type_id` INT,
constraint `fk_items_item_type`
foreign key (`item_type_id`)
references `item_types`(`item_type_id`));

CREATE TABLE `orders` (
`order_id` INT PRIMARY KEY auto_increment,
`customer_id` INT UNIQUE
);

CREATE TABLE `order_items` (
`order_id` INT,
`item_id` INT,

CONSTRAINT `pk_order_items`
PRIMARY KEY (`order_id`, `item_id`),

CONSTRAINT `fk_order_item_item`
FOREIGN KEY (`item_id`)
references `items`(`item_id`),

CONSTRAINT `fk_order_item_order`
FOREIGN KEY (`order_id`)
references `orders`(`order_id`)
);

CREATE TABLE `customers` (
`customer_id` INT PRIMARY KEY auto_increment,
`name` VARCHAR(50) NOT NULL,
`birthday` DATE NOT NULL,
`city_id` int);

CREATE TABLE `cities` (`city_id` INT PRIMARY KEY auto_increment, `name` VARCHAR(50) NOT NULL);

ALTER TABLE `customers`
ADD CONSTRAINT `fk_customers_cities`
FOREIGN KEY (`city_id`)
REFERENCES `cities`(`city_id`);

ALTER TABLE `orders`
ADD CONSTRAINT `fk_order_customers`
foreign key (`customer_id`)
references `customers`(`customer_id`);

-- 6. University Database --

CREATE TABLE `majors` (
`major_id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(50) NOT NULL
);

CREATE TABLE `students` (
`student_id` INT PRIMARY KEY auto_increment,
`student_number` VARCHAR(12) NOT NULL,
`student_name` VARCHAR(50) NOT NULL,
`major_id` INT
);

ALTER TABLE `students`
ADD CONSTRAINT `fk_students_majors`
foreign key (`major_id`)
references `majors`(`major_id`);

CREATE TABLE `payments` (
`payment_id` INT PRIMARY KEY auto_increment,
`payment_date` DATE NOT NULL,
`payment_amount` DECIMAL (8,2) NOT NULL,
`student_id` INT
);

ALTER TABLE `payments`
ADD CONSTRAINT `fk_payments_students`
foreign key (`student_id`)
references `students`(`student_id`);

CREATE TABLE `subjects`
(
`subject_id` INT PRIMARY KEY auto_increment,
`subject_name` VARCHAR(50)
);

CREATE TABLE `agenda` (
`student_id` INT,
`subject_id` INT,

CONSTRAINT `fk_agenda`
PRIMARY KEY (`student_id`, `subject_id`),

CONSTRAINT `fk_agenda_student`
foreign key (`student_id`)
references `students`(`student_id`),

CONSTRAINT `fk_agenda_subjest`
foreign key (`subject_id`)
references `subjects`(`subject_id`)
);

-- 7. Peaks in Rila -- 

select m.mountain_range, p.peak_name, p.elevation as peak_elevation from mountains as m
join peaks as p
on m.id = p.mountain_id
where m.mountain_range = 'Rila'
order by p.elevation desc;