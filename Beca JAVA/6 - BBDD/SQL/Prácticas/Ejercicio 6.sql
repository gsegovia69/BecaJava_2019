SELECT a.postal_code, COUNT(r.rental_id) AS rentals
FROM rental r
INNER JOIN customer c ON c.customer_id=r.customer_id
INNER JOIN address a ON a.address_id=c.address_id
GROUP BY a.postal_code
ORDER BY rentals DESC;