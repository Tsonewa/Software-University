SELECT `id`, `first_name`, `last_name`, `job_title` FROM `employees`
ORDER BY `id`;

SELECT `id`, CONCAT_WS(' ', `first_name`, `last_name`) AS `full_name`, `job_title`, `salary` FROM `employees`
WHERE `salary` > 1000
ORDER BY `id` ASC;

UPDATE `employees` 
SET `salary` = `salary` + 100
WHERE `job_title` = 'Manager';

SELECT * FROM `employees`
ORDER BY `salary` DESC
LIMIT 1;

SELECT * FROM `employees`
WHERE `salary` >= 1000 AND `department_id` = 4
ORDER BY `id` ASC;

DELETE FROM `employees`
WHERE `department_id` IN (2,1);
 
