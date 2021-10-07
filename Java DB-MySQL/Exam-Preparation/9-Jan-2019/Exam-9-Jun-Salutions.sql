
-- Section 1: DDL --

CREATE schema `ruk_database`;
USE `ruk_database`;

CREATE TABLE `branches` (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(30) NOT NULL
);

CREATE TABLE `employees` (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`first_name` VARCHAR(20) NOT NULL,
`last_name` VARCHAR(20) NOT NULL,
`salary` DECIMAL(10,2) NOT NULL,
`started_on` DATE NOT NULL,
`branch_id` INT,
CONSTRAINT `fk_employees_branches`
FOREIGN KEY (`branch_id`)
REFERENCES `branches`(`id`)
);

CREATE TABLE `clients` (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`full_name` VARCHAR(50) NOT NULL,
`age` INT NOT NULL
);

CREATE TABLE `employees_clients` (
`employee_id` INT,
`client_id` INT,
CONSTRAINT `pk_employees_clients`
PRIMARY KEY (`employee_id`, `client_id`),

CONSTRAINT `fk_employees_clients_employees`
FOREIGN KEY (`employee_id`)
REFERENCES `employees`(`id`),

CONSTRAINT `fk_employees_clients_clients`
FOREIGN KEY (`client_id`)
REFERENCES `clients`(`id`)
);

CREATE TABLE `bank_accounts` (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`account_number` VARCHAR(10) NOT NULL,
`balance` DECIMAL(10,2) NOT NULL,
`client_id` INT UNIQUE NOT NULL,
CONSTRAINT `fk_bank_accounts_clients`
FOREIGN KEY (`client_id`)
REFERENCES `clients`(`id`)
);

CREATE TABLE `cards` (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`card_number` VARCHAR(19) NOT NULL,
`card_status` VARCHAR(7) NOT NULL,
`bank_account_id` INT NOT NULL,
CONSTRAINT `fk_cards_bank_accounts`
FOREIGN KEY (`bank_account_id`)
REFERENCES `bank_accounts`(`id`)
);


-- Section 2: DML --

INSERT INTO `cards` (`card_number`, `card_status`, `bank_account_id`)

(SELECT REVERSE(full_name), 'Active', `id` FROM `clients`
WHERE `id` BETWEEN 191 AND 200);



UPDATE `employees_clients` as ec
JOIN
(SELECT ec1.`employee_id`, COUNT(ec1.`client_id`) AS 'count'
		FROM employees_clients as ec1 
		GROUP BY ec1.employee_id
		ORDER BY `count`, ec1.`employee_id`) AS s
SET ec.employee_id = s.employee_id
WHERE ec.employee_id = ec.client_id;

DELETE e FROM `employees` AS e
LEFT JOIN `employees_clients` as ce
ON e.`id` = ce.`employee_id`
WHERE ce.`client_id` IS NULL;

-- Section 3: Querying 

SELECT `id`, `full_name` FROM `clients`
ORDER BY `id` ASC;

SELECT `id`, CONCAT_WS(' ', first_name, last_name) AS `full_name`,
CONCAT('$', `salary`) AS `salary` , `started_on` FROM `employees`
WHERE `salary` >= 100000 AND `started_on` >= '2018-01-01'
ORDER BY `salary` DESC, `id` ASC;

SELECT c.`id`, CONCAT(c.`card_number`, ' : ', cl.`full_name`) AS `card_token` FROM `cards` AS c
JOIN `bank_accounts` AS b
ON b.`id` = c.`bank_account_id`
JOIN `clients` AS cl
ON cl.`id` = b.`client_id`
ORDER BY c.`id` DESC;

SELECT CONCAT_WS(' ', `first_name`, `last_name`) AS `name`,
 `started_on`, COUNT(ec.`client_id`) AS `count_of_clients` FROM `employees` AS e
 JOIN `employees_clients` AS ec
 ON e.`id` = ec.`employee_id`
 GROUP BY `employee_id`
 ORDER BY `count_of_clients` DESC, ec.`employee_id`
 LIMIT 5;
 
SELECT b.`name`, COUNT(card.id) as count_of_cards
FROM branches as b
JOIN employees as e
ON b.id = e.branch_id
JOIN employees_clients as ec
ON e.id = ec.employee_id
JOIN clients as c
ON ec.client_id = c.id
JOIN bank_accounts as ba
ON c.id = ba.client_id
JOIN cards as card
ON ba.id = card.bank_account_id
GROUP BY b.`name` 
ORDER BY count_of_cards DESC, b.`name`;

-- Section 4: Programmability
DELIMITER $$

CREATE FUNCTION `udf_client_cards_count` (client_name varchar(30)) 
RETURNS int

DETERMINISTIC
BEGIN 
 DECLARE `count` int;
 
 SET `count` := (SELECT COUNT(c.`id`) FROM `clients` AS cl
 JOIN `bank_accounts` AS b
 ON b.`client_id` = cl.`id`
 JOIN `cards` AS c
 ON b.`id` = c.`bank_account_id`
 WHERE cl.`full_name` = client_name);
 
 RETURN `count`;
END 

$$

SELECT c.full_name, udf_client_cards_count('Baxy David') as `cards` FROM clients AS c
WHERE c.full_name = 'Baxy David';

DELIMITER $$
CREATE PROCEDURE `udp_client_info`(client_name varchar(50))
BEGIN
    SELECT c.`full_name`, c.`age`, 
   ba.`account_number`, CONCAT('$', ba.`balance`) AS `balance`
    FROM `clients` AS c
    JOIN `bank_accounts` AS ba
    ON ba.`client_id` = c.`id`
    WHERE c.`full_name` = client_name;
END 
$$

CALL `udp_client_info`('Hunter Wesgate');