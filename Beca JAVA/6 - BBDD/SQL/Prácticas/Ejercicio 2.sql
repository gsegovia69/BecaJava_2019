SELECT COUNT(film.title) 
AS Peliculas_perros 
FROM film 
WHERE film.description 
LIKE '% dog %';