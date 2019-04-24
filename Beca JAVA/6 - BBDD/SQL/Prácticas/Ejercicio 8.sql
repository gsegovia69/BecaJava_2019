SELECT f.title, COUNT(p.amount) AS rentals, SUM(p.amount) as total_amount
FROM payment p
INNER JOIN rental r ON r.rental_id=p.rental_id
INNER JOIN inventory i ON i.inventory_id=r.inventory_id
INNER JOIN film f ON f.film_id=i.film_id
GROUP BY f.title
ORDER BY rentals DESC