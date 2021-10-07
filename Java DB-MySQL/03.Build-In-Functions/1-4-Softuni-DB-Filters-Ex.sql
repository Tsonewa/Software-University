SELECT first_name, last_name FROM `employees`
WHERE substring(first_name, 1, 2) = 'Sa'
ORDER BY `employee_id`;

SELECT first_name, last_name FROM `employees`
WHERE last_name LIKE '%ei%'
ORDER BY `employee_id`;

-- Find the first names of all employees in the departments with ID 3 or 10 
-- and whose hire year is between 1995 and 2005 inclusively. 
-- Order the information by id. 

SELECT first_name FROM `employees`
WHERE `department_id` IN (3,10) AND extract(year FROM hire_date) BETWEEN 1995 AND 2005
ORDER BY `employee_id`;

SELECT first_name, last_name FROM `employees`
WHERE `job_title` LIKE '%engineer%' IS FALSE
ORDER BY `employee_id`;