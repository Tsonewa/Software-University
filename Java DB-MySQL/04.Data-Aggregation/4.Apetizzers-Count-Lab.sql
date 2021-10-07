-- count of all appetizers (category id = 2) with price higher than 8.

SELECT COUNT(*) FROM `products`
WHERE  category_id = 2 AND price > 8
GROUP BY category_id;