CREATE VIEW `v_employees_hired_after_2000` AS
SELECT first_name, last_name FROM `employees`
WHERE extract(year FROM hire_date) > 2000;

SELECT * FROM `v_employees_hired_after_2000`;


SELECT first_name,last_name FROM `employees`
WHERE length(last_name) = 5;