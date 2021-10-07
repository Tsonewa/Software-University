USE `geography`;

SELECT country_name, iso_code FROM `countries`
WHERE country_name LIKE '%a%a%a%' ORDER BY iso_code;

/*Combine all peak names with all river names, so that t
he last letter of each peak name is the same as the first letter of 
its corresponding river name. Display the peak name, the river name, 
and the obtained mix(converted to lower case).
 Sort the results by the obtained mix alphabetically.*/
 
 SELECT `peak_name`, `river_name`,
 lower(concat(LEFT(peak_name, LENGTH(peak_name)), (RIGHT(river_name, LENGTH(river_name))))) 
 AS `mix` FROM `peaks`, `rivers`
 WHERE LEFT(peak_name, 1) = LEFT(river_name, 1) 
 ORDER BY `mix`;