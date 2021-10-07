SELECT concat_ws(' ', first_name, last_name) AS `Full_name`, 
timestampdiff(day, born, died) AS `Days Lived` FROM `authors`; 