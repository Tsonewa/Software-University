SELECT * FROM `departments`
ORDER BY `department_id` ASC;

SELECT `name` FROM `departments`
ORDER BY `department_id` ASC;

SELECT `first_name`, `last_name`, `salary` FROM `employees`
ORDER BY `employee_id` ASC;

SELECT `first_name`, `middle_name`, `last_name` FROM `employees`
ORDER BY `employee_id` ASC;

SELECT CONCAT(`first_name`, '.', `last_name`, '@softuni.bg') AS `full_email_address` FROM `employees`;

SELECT `salary` AS 'Salary' FROM `employees`
GROUP BY `salary`
ORDER BY `employee_id` ASC;

SELECT `employee_id`, `first_name` AS 'First Name',
`last_name` AS 'Last Name', `middle_name` AS 'Middle Name',
`job_title` AS 'Job Title', `department_id` AS 'Dept ID',
`manager_id` AS 'Mngr ID', `hire_date` AS 'Hire Date', `salary` FROM `employees`
WHERE `job_title` = 'Sales Representative'
ORDER BY `employee_id` ASC;

SELECT `first_name`, `last_name`, `job_title` AS 'Job Title' FROM `employees`
WHERE `salary` BETWEEN 20000 AND 30000
ORDER BY `employee_id` ASC;

SELECT CONCAT_WS(' ',`first_name`, `middle_name`, `last_name`) AS 'Full Name' FROM `employees`
WHERE `salary` IN (25000, 14000, 12500, 23600);

SELECT `first_name`, `last_name` FROM `employees`
WHERE `manager_id` IS NULL;

SELECT `first_name`, `last_name`, `salary` FROM `employees`
WHERE `salary` > 50000
ORDER BY `salary` DESC;

SELECT `first_name`, `last_name` FROM `employees`
ORDER BY `salary` DESC
LIMIT 5;

SELECT `first_name`, `last_name` FROM `employees`
WHERE `department_id` != 4;

SELECT * FROM `employees`
ORDER BY `salary` DESC, `first_name` ASC, 'last_name' DESC, `middle_name` ASC, `employee_id` ASC;

CREATE VIEW `v_employees_salaries` AS
SELECT `first_name`, `last_name`, `salary` FROM `employees`;

SELECT * FROM `v_employees_salaries`;

CREATE VIEW `v_employees_job_titles` AS
SELECT CONCAT_WS(' ', `first_name`, CASE WHEN `middle_name` IS NULL THEN `middle_name` = '' ELSE `middle_name` END, `last_name`) AS 'full_name', `job_title` FROM `employees`;

SELECT * FROM `v_employees_job_titles`;

SELECT `job_title` FROM `employees`
GROUP BY `job_title`
ORDER BY `job_title` ASC;

SELECT * FROM `projects`
ORDER BY `start_date` ASC, `name` ASC
LIMIT 10;

SELECT `first_name`, `last_name`, `hire_date` FROM `employees`
ORDER BY `hire_date` DESC
LIMIT 7;

UPDATE `employees`
SET `salary` = `salary` * 1.12
WHERE `department_id` IN (1,2,4,11);

SELECT `salary` AS 'Salary' FROM `employees`;

