-- dep_id average salary(round to 2)

SELECT department_id, ROUND(AVG(salary), 2) AS `Average Salary` FROM `employees`
GROUP BY department_id
ORDER BY department_id; 
