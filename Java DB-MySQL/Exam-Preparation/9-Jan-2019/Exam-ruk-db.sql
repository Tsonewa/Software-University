CREATE TABLE `branches` (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(30) UNIQUE NOT NULL
);

CREATE TABLE `employees` (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`first_name` VARCHAR(20) NOT NULL,
`last_name` VARCHAR(20) NOT NULL,
`salary` DECIMAL(10,2) NOT NULL,
`started_on` DATE NOT NULL,
`branch_id` INT NOT NULL,
CONSTRAINT `fk_branches_id`
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
CONSTRAINT `fk_employees_id`
FOREIGN KEY (`employee_id`)
REFERENCES `employees`(`id`),

CONSTRAINT `fk_clients_id`
FOREIGN KEY (`client_id`)
REFERENCES `clients`(`id`)
);

CREATE TABLE `bank_accounts` (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`account_number` VARCHAR(10) NOT NULL,
`balance` DECIMAL(10,2) NOT NULL,
`client_id` INT UNIQUE NOT NULL,
CONSTRAINT `fk_client_id`
FOREIGN KEY (`client_id`)
REFERENCES `clients`(`id`)
);

CREATE TABLE `cards` (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`card_number` VARCHAR(19) NOT NULL,
`card_status` VARCHAR(7) NOT NULL,
`bank_account_id` INT,
CONSTRAINT `fk_bank_acc_id`
FOREIGN KEY (`bank_account_id`)
REFERENCES `bank_accounts`(`id`)
);

INSERT INTO `cards` (card_number, card_status, bank_account_id)
(
SELECT REVERSE(full_name), 'Active', id FROM `clients`
WHERE id BETWEEN 191 AND 200
);

/*Update all clients which have the same id as the employee they are appointed to. 
Set their employee_id with the employee with the lowest count of clients. 
If there are 2 such employees with equal count of clients, take the one with the lowest id. */

UPDATE `employees_clients` AS ec
SET ec.employee_id = 
(SELECT ec.employee_id FROM (SELECT * FROM (employees_clients)) AS ecc
GROUP BY employee_id
ORDER BY COUNT(ecc.client_id) ASC, ecc.employee_id ASC
LIMIT 1
)
WHERE ec.employee_id = ec.client_id;

-- Delete all employees which do not have any clients.  

DELETE emp FROM `employees` AS emp
LEFT JOIN `employees_clients` AS ec
ON emp.id = ec.employee_id 
WHERE ec.client_id IS NULL;

SELECT * FROM `clients`
ORDER BY id ASC;

SELECT id, CONCAT_WS(' ', first_name, last_name) AS 'full_name', CONCAT('$', salary) AS 'salary', started_on FROM `employees`
ORDER BY salary DESC, id ASC;

SELECT cards.id, CONCAT(cards.card_number, ' : ', clients.full_name) AS 'card_token' FROM `cards`
JOIN clients
ON cards.id = clients.id
ORDER BY cards.id DESC;

