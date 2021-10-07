SELECT `peak_name` FROM `peaks`
ORDER BY `peak_name` ASC;

SELECT `country_name`, `population` FROM `countries`
WHERE `continent_code` = 'EU'
ORDER BY `population` DESC, `country_code` ASC
LIMIT 30;

ALTER TABLE `countries`
ADD COLUMN `currency` VARCHAR(8);

UPDATE `countries`
SET `currency` =  CASE WHEN `currency_code` = 'EUR' THEN 'Euro' ELSE 'Not Euro' END;

SELECT `country_name`, `country_code`, `currency` FROM `countries`
ORDER BY `country_name` ASC;