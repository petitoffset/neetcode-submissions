-- Write your query below(SELECT customer_id COUNT(CASE WHEN product_name = 'A' THEN 1 END), 
WITH ords AS 
( SELECT customer_id 
FROM orders 
GROUP BY customer_id 
HAVING COUNT(CASE WHEN product_name = 'A' THEN 1 END) > 0 
AND COUNT(CASE WHEN product_name = 'B' THEN 1 END) > 0 
AND COUNT(CASE WHEN product_name = 'C' THEN 1 END) = 0 ) 
SELECT o.customer_id, c.customer_name 
FROM ords o 
JOIN customers c 
USING (customer_id) 
ORDER BY c.customer_name;
