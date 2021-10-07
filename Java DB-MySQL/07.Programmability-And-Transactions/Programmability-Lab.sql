-- 1. Count employees by town name --

SELECT * FROM soft_uni.towns;

DELIMITER $$

CREATE FUNCTION `ufn_count_employees_by_town` (town_name varchar(10))
RETURNS INTEGER

DETERMINISTIC
BEGIN 
 DECLARE `count` INT;
 
 SET `count` := (SELECT COUNT(e.`employee_id`) AS `count` FROM `towns` AS t
JOIN `addresses` AS a
ON a.`town_id` = t.`town_id`
JOIN `employees` AS e
ON e.`address_id` = a.`address_id`
WHERE t.`name` = town_name);
 
 RETURN `count`;
END 

$$

SELECT ufn_count_employees_by_town('Seattle') AS `count`;

-- 2. Employees promotion -- 

DELIMITER $$
CREATE PROCEDURE  `usp_raise_salaries`(department_name VARCHAR(50))
BEGIN
    UPDATE `employees` AS e
    JOIN `departments` AS d
    ON d.`department_id` = e.`department_id` 
    SET e.`salary` = e.`salary` * 1.05
    WHERE d.`name` = department_name;
END ;

$$

CALL `usp_raise_salaries`('Finance'); 

SELECT e.`first_name`, e.`salary` FROM `employees` AS e
JOIN `departments` AS d
ON d.`department_id` = e.`department_id`
WHERE d.`name` = 'Finance'
ORDER BY e.`first_name`; 

-- 3. Employees Promotion by ID -- 

DELIMITER $$
CREATE PROCEDURE  `usp_raise_salaries`(department_id VARCHAR(50))
BEGIN
    UPDATE `employees` AS e
    RIGHT JOIN `departments` AS d
    ON d.`department_id` = e.`department_id` 
    SET e.`salary` = e.`salary` * 1.05
    WHERE d.`department_id` = department_id;
END ;

$$


