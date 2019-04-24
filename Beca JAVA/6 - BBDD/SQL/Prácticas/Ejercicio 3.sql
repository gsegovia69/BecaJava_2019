SELECT COUNT(film.film_id) AS Peliculas
FROM film
WHERE film.title LIKE '_C%';