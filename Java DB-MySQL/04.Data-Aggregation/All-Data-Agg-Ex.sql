-- 1.Records Count --

SELECT COUNT(*) AS `count`FROM `wizzard_deposits`;

-- 2. Longest Magic Wand --

SELECT MAX(`magic_wand_size`) AS `longest_magic_wand` FROM `wizzard_deposits`;

-- 3. Lpngest Magic Wand per Deposit Groups --

SELECT `deposit_group`,  MAX(`magic_wand_size`) AS `longest_magic_wand` FROM `wizzard_deposits`
GROUP BY `deposit_group`
ORDER BY `longest_magic_wand` ASC, `deposit_group` ASC;

-- 4. Smallest Deposit Group Per Magic Wand Size --

SELECT `deposit_group` FROM `wizzard_deposits`
GROUP BY `deposit_group`
HAVING AVG(`magic_wand_size`)
LIMIT 1;

-- 5. Deposit Sum --

SELECT `deposit_group`, SUM(`deposit_amount`) AS `total_sum` FROM `wizzard_deposits`
GROUP BY `deposit_group`
ORDER BY `total_sum` ASC;

-- 6. Deposits Sum for Ollivander Family --

SELECT `deposit_group`, SUM(`deposit_amount`) AS `total_sum` FROM `wizzard_deposits`
WHERE `magic_wand_creator` = 'Ollivander family'
GROUP BY `deposit_group`
ORDER BY `deposit_group` ASC;

-- 7. Deposits Filter --

SELECT `deposit_group`, SUM(`deposit_amount`) AS `total_sum` FROM `wizzard_deposits`
WHERE `magic_wand_creator` = 'Ollivander family'
GROUP BY `deposit_group`
HAVING `total_sum` < 150000
ORDER BY `total_sum` DESC;

-- 8. Deposit Charge --

SELECT `deposit_group`, `magic_wand_creator`, MIN(`deposit_charge`) AS `min_deposit_charge` FROM `wizzard_deposits`
GROUP BY `deposit_group`, `magic_wand_creator`
ORDER BY `magic_wand_creator` ASC, `deposit_group` ASC;

-- 9. Age Groups --

SELECT CASE 
WHEN `age` BETWEEN 0 AND 10 THEN '[0-10]'
WHEN `age` BETWEEN 11 AND 20 THEN '[11-20]'
WHEN `age` BETWEEN 21 AND 30 THEN '[21-30]'
WHEN `age` BETWEEN 31 AND 40 THEN '[31-40]'
WHEN `age` BETWEEN 41 AND 50 THEN '[41-50]'
WHEN `age` BETWEEN 51 AND 60 THEN '[51-60]'
ELSE '[61+]'
END AS `age_group`, COUNT(*) AS `wizzard_count` FROM `wizzard_deposits`
GROUP BY `age_group`
ORDER BY `wizzard_count` ASC;

-- 10. First Letter --

SELECT LEFT(`first_name`, 1) AS `first_letter` FROM `wizzard_deposits`
WHERE`deposit_group` = 'Troll Chest'
GROUP BY `first_letter`
ORDER BY `first_letter` ASC;

-- 11. Average Interest --

SELECT `deposit_group`, `is_deposit_expired`, AVG(`deposit_interest`) AS `average_interest` FROM `wizzard_deposits`
WHERE `deposit_start_date` > '1985-01-01'
GROUP BY `deposit_group`, `is_deposit_expired`
ORDER BY `deposit_group` DESC, `is_deposit_expired` ASC;

-- 12. Rich WIzard, Poor Wizard --

SELECT SUM(`hw`.`deposit_amount` - `gw`.`deposit_amount`) as 'sum_difference'
FROM `wizzard_deposits` AS `hw`, `wizzard_deposits` AS `gw`
WHERE `gw`.`id` - `hw`.`id` = 1;

-- 13. Employees Minimum Salaries --

SELECT `department_id`, MIN(`salary`) AS `minimum_salary` FROM `employees`
WHERE `department_id` IN (2,5,7) AND `hire_date` > '2000-01-01'
GROUP BY `department_id`
ORDER BY `department_id` ASC;

-- 14. Employees Average Salaries --

CREATE TABLE `new table` AS 
(SELECT * FROM `employees`
WHERE `salary` > 30000);

DELETE FROM `new table`
WHERE `manager_id` = 42;

UPDATE `new table`
SET `salary` = `salary`-  5000
WHERE `department_id` = 1;

SELECT `department_id`, AVG(`salary`) AS `avg_salary` FROM `new table`
GROUP BY `department_id`
ORDER BY `department_id` ASC;

-- 15. Employees Maximum Salaries --

SELECT `department_id`, MAX(`salary`) AS `max_salary` FROM `employees`
GROUP BY `department_id`
HAVING `max_salary` NOT BETWEEN 30000 AND 70000;

-- 16. Employees Count Salaries --

SELECT COUNT(`salary`) AS `` FROM `employees`
WHERE `manager_id` IS NULL;

-- 17. 3rd Highest Salary --

SELECT department_id, (
    SELECT distinct salary
    FROM     employees as t2
    WHERE    t2.department_id = t1.department_id
    ORDER BY salary DESC
    LIMIT 1 OFFSET 2) as third_highest_salary FROM  employees as t1
group by department_id
having third_highest_salary IS NOT NULL
order by department_id asc;

-- 18. Salary Challenge --

select first_name, last_name, department_id from employees as d1
where salary > (select avg(salary) as a from employees as d2 where d2.department_id = d1.department_id group by department_id)
order by department_id, employee_id limit 10;

-- 19. Departments Total Salaries -- 

select department_id, SUM(salary) as total_sum from employees
group by department_id
order by  department_id;

