SELECT a.first_name, a.last_name, COUNT(*) AS films
FROM film_actor fa
INNER JOIN actor a ON a.actor_id=fa.actor_id
WHERE fa.film_id IN (SELECT film_id FROM film f WHERE f.length>60)
GROUP BY a.first_name HAVING a.first_name='PENELOPE' OR a.first_name='ED'
