SELECT * FROM orders.orders;

SELECT `product_name`, `order_date`, 
DATE_ADD(`order_date`, INTERVAL 3 day) AS `pay_due`, 
DATE_ADD(`order_date`, INTERVAL 1 month) AS `deliver_due` FROM `orders`;