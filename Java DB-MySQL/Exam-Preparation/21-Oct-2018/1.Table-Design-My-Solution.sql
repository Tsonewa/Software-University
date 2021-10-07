CREATE TABLE `planets` (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(30) NOT NULL
);

CREATE TABLE `spaceports` (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(50) NOT NULL,
`planet_id` INT,
CONSTRAINT `fk_planet_spaceports`
FOREIGN KEY (`planet_id`)
REFERENCES `planets`(`id`)
);

CREATE TABLE `spaceships` (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(50) NOT NULL,
`manufacturer` VARCHAR(30) NOT NULL,
`light_speed_rate` INT 
);

CREATE TABLE `colonists` (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`first_name` VARCHAR(20) NOT NULL,
`last_name` VARCHAR(20) NOT NULL,
`ucn` CHAR(10) NOT NULL UNIQUE,
`birth_date` DATE NOT NULL
);

CREATE TABLE `journeys` (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`journey_start` DATETIME NOT NULL,
`journey_end` DATETIME NOT NULL,
`purpose` ENUM('Medical', 'Technical', 'Educational', 'Military'),
`destination_spaceport_id` INT,
CONSTRAINT `fk_destination_spaceport`
FOREIGN KEY (`destination_spaceport_id`)
REFERENCES `spaceports`(`id`),
`spaceship_id` INT,
CONSTRAINT `fk_journeys_spaceship`
FOREIGN KEY (`spaceship_id`)
REFERENCES `spaceships`(`id`)
);

CREATE TABLE `travel_cards` (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`card_number` CHAR(10) UNIQUE NOT NULL,
`job_during_journey` ENUM('Pilot', 'Engineer', 'Trooper', 'Cleaner','Cook') NOT NULL,
`colonist_id` INT,
CONSTRAINT `fk_travel_cards_colonist`
FOREIGN KEY (`colonist_id`)
REFERENCES `colonists`(`id`),
`journey_id` INT,
CONSTRAINT `fk_travel_cards_journeys`
FOREIGN KEY (`journey_id`)
REFERENCES `journeys`(`id`));

-- Section: Data Manipulation Language (DML) --

INSERT INTO `travel_cards` (card_number, job_during_journey, colonist_id, journey_id)
(SELECT CASE
         WHEN c.birth_date >= '1980-01-01' 
         THEN CONCAT(year(c.birth_date), day(c.birth_date), SUBSTRING(c.ucn,1, 4))
         ELSE concat(year(c.birth_date), month(c.birth_date), SUBSTRING(c.ucn, -4, 4))
		END as card_numer,
       CASE
         WHEN c.id mod 2 = 0 THEN 'Pilot'
         WHEN c.id mod 3 = 0 THEN 'Cook'
         ELSE 'Engineer'
		END as job_during_journey,
       c.id as colonist_id,
       substr(c.ucn, 1, 1) as journey_id
FROM `colonists` AS c
WHERE c.id BETWEEN 96 AND 100);

UPDATE `journeys` AS j
SET `purpose` = CASE 
WHEN j.id MOD 2 = 0 THEN 'Medical'
WHEN j.id MOD 3 = 0 THEN 'Technical'
WHEN j.id MOD 5 = 0 THEN 'Educational'
WHEN j.id MOD 7 = 0 THEN 'Military'
ELSE j.purpose
END;

DELETE c FROM `colonists` AS c
LEFT JOIN travel_cards AS tc
ON tc.colonist_id = c.id
LEFT JOIN journeys AS j
ON j.id = tc.journey_id
WHERE j.id IS NULL;

SELECT card_number, job_during_journey FROM `travel_cards` 
ORDER BY card_number ASC;

SELECT id, CONCAT_WS(' ', first_name, last_name) AS 'full_name', ucn FROM `colonists`
ORDER BY first_name, last_name, id ASC;

SELECT id, journey_start, journey_end FROM journeys
WHERE purpose = 'Military'
ORDER BY journey_start ASC;

SELECT c.id, CONCAT_WS(' ',c.first_name, c.last_name) AS 'full_name'FROM colonists AS c
JOIN travel_cards AS tc
ON tc.colonist_id = c.id
WHERE tc.job_During_journey = 'Pilot'
ORDER BY c.id ASC;

SELECT COUNT(*) AS 'count' FROM colonists AS c
JOIN travel_cards AS tc
ON tc.colonist_id = c.id
JOIN journeys AS j
ON j.id = tc.journey_id
WHERE j.purpose = 'Technical';

SELECT s.`name` as 'spaceship_name', sp.`name` AS 'spaceport_name' FROM `spaceships` AS s
 JOIN journeys AS j
 ON j.spaceship_id = s.id
 JOIN spaceports AS sp
 ON sp.id = j.destination_spaceport_id
 ORDER BY s.light_speed_rate DESC
 LIMIT 1;
 
 SELECT s.`name`, s.manufacturer FROM `spaceships` AS s
 JOIN journeys AS j
 ON j.spaceship_id = s.id
 JOIN travel_cards AS tc
 ON tc.journey_id = j.id
 JOIN colonists AS c
 ON c.id = tc.colonist_id
 WHERE job_during_journey = 'Pilot' AND 
 c.birth_date >= date_sub('2019-01-01', interval 30 year)
 ORDER BY s.`name` ASC;  
 
 SELECT p.`name` AS 'planet_name', sp.`name` AS 'spaceport_name' FROM planets AS p
 JOIN spaceports AS sp
 ON sp.planet_id = p.id
 JOIN journeys AS j
 ON sp.id = j.destination_spaceport_id
 WHERE j.purpose = 'Educational'
 ORDER BY spaceport_name DESC;
 
SELECT p.`name` AS 'planet_name', COUNT(j.id) AS 'journeys_count' FROM planets AS p
 JOIN spaceports AS sp
 ON sp.planet_id = p.id
 JOIN journeys AS j
 ON sp.id = j.destination_spaceport_id
 GROUP BY p.`name`
 ORDER BY journeys_count DESC, p.`name` ASC;
 
SELECT j.id, p.`name` AS 'planet_name', sp.`name` AS 'spaceport_name', j.purpose FROM planets AS p
JOIN spaceports AS sp
ON sp.planet_id = p.id
JOIN journeys AS j
ON sp.id = j.destination_spaceport_id
ORDER BY DATEDIFF(j.journey_end, j.journey_start) ASC
LIMIT 1;

