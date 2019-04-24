SELECT f.title FROM film_category fc
INNER JOIN film f ON f.film_id=fc.film_id
INNER JOIN category c ON c.category_id=fc.category_id
WHERE c.name='Action';