SELECT `name` FROM `towns`
WHERE LENGTH(name) IN (5,6)
ORDER BY `name` ASC;

SELECT * FROM `towns`
WHERE LEFT(`name`, 1) IN ('M','K','B','E')
ORDER BY `name` ASC;

SELECT * FROM `towns`
WHERE LEFT(`name`, 1) IN ('R','B','D') IS FALSE
ORDER BY `name` ASC;


