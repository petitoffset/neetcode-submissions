-- Write your query below
SELECT s.seller_name
FROM seller s
LEFT JOIN orders o
    ON o.seller_id = s.seller_id
   AND o.sale_date BETWEEN '2020-01-01' AND '2020-12-31'
WHERE o.order_id IS NULL
ORDER BY s.seller_name;