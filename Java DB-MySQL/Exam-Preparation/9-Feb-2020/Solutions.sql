SELECT `first_name`, `age`, `salary` FROM `players`
ORDER BY `salary` DESC;

SELECT p.`id`, CONCAT_WS(' ', p.`first_name`, p.`last_name`) AS `full_name`, p.`age`, p.`position` , p.`hire_date` FROM `players` AS p
JOIN `skills_data` AS s
ON s.`id` = p.`skills_data_id`
WHERE p.`age` < 23 AND p.`position` = 'A' AND p.`hire_date` IS NULL AND s.`strength` > 50
ORDER BY `salary` ASC, `age` ASC;

SELECT t.`name` AS `team_name`, t.`established`, t.`fan_base`, COUNT(p.`id`) AS `players_count` FROM `teams` AS t
LEFT JOIN `players` AS p
ON p.`team_id` = t.`id`
GROUP BY t.`name`
ORDER BY `players_count` DESC, t.`fan_base` DESC;

SELECT MAX(sd.`speed`) AS `max_speed`, t.`name` AS `town_name` FROM `skills_data` AS sd
RIGHT JOIN `players` AS p
ON p.`skills_data_id` = sd.`id`
RIGHT JOIN `teams` AS tm
ON tm.`id` = p.`team_id`
RIGHT JOIN `stadiums` AS s
ON s.`id` = tm.`stadium_id`
RIGHT JOIN `towns` AS t
ON t.`id` = s.`town_id`
WHERE tm.`name` != 'Devify'
GROUP BY t.`id`, tm.`id`
ORDER BY `max_speed` DESC, t.`name` ASC;

SELECT c.`name`, COUNT(p.`id`) AS `total_count_of_players`, SUM(p.`salary`)
AS`total_sum_of_salaries` FROM `countries` AS c
LEFT JOIN `towns` AS t
ON t.`country_id` = c.`id`
LEFT JOIN `stadiums` AS s
ON s.`town_id` = t.`id`
LEFT JOIN `teams` AS tm
ON tm.`stadium_id` = s.`id`
LEFT JOIN `players` AS p
ON p.`team_id` = t.`id`
GROUP BY c.`id`
ORDER BY total_count_of_players DESC, c.`name` ASC;

DELIMITER $$

CREATE FUNCTION udf_stadium_players_count (stadium_name VARCHAR(30))
RETURNS INTEGER

DETERMINISTIC
BEGIN 
 DECLARE `count` INT;
 
 SET `count` := (SELECT COUNT(p.`id`) FROM `players` AS p
 JOIN `teams` AS t
 ON t.`id` = p.`team_id`
 JOIN `stadiums` AS s
 ON s.`id` = t.`stadium_id`
 WHERE s.`name` = stadium_name
 GROUP BY s.`id` 
 );
 
 RETURN `count`;
END 

$$

SELECT udf_stadium_players_count ('Jaxworks') as `count`; 

DELIMITER $$
CREATE PROCEDURE  udp_find_playmaker(IN min_dribble_points INT,team_name VARCHAR(45))
BEGIN

    SELECT CONCAT_WS(' ', p.`first_name`, p.`last_name`) AS `full_name`, 
    p.`age`, p.`salary`, sd.`dribbling`, sd.`speed`, tm.`name` AS `team_name`
FROM `players` AS p
JOIN `teams` AS tm
ON tm.`id` = p.`team_id`
JOIN `skills_data` AS sd
ON sd.`id` = p.`skills_data_id`
WHERE tm.`name` = 'Skyble' AND sd.`dribbling` > 20
AND sd.`speed` > (SELECT AVG(sd.speed) FROM `skills_data` AS sd)
ORDER BY sd.`speed` DESC
LIMIT 1;
END
$$

CALL udp_find_playmaker (20, 'Skyble'); 

INSERT INTO `coaches` (`first_name`, `last_name`, `salary`, `coach_level`)
(SELECT `first_name`, `last_name`, `salary` * 2, char_length(`first_name`) FROM `players`
WHERE `age` >= 45);

UPDATE `coaches` as c
JOIN `players_coaches` AS pc
ON c.`id` = pc.`coach_id`
SET c.`coach_level` = c.`coach_level` + 1 
WHERE LEFT(c.`first_name`, 1) = 'A' AND pc.`coach_id` IS NOT NULL;

-- ??????? --
/* As you remember at the beginning of our work, we promoted several football players
 to coaches. Now you need to remove all of them from the table of players in order
 for our database to be updated accordingly.	 
Delete all players from table players, which are already added in table coaches.  */

