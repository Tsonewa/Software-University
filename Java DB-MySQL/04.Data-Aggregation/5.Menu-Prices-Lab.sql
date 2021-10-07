-- Category_id 
-- Average Price  
-- Cheapest Product 
-- Most Expensive Product

 SELECT category_id, ROUND(AVG(price),2) AS `Average Price`,
 ROUND(MIN(price),2) AS `Cheapest PRoduct`, 
 ROUND(MAX(price),2) AS `Most Expensive Product` FROM `products`
 GROUP BY category_id;