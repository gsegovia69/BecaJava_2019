SELECT COUNT(film.title) AS NUM_PELICULAS 
FROM film 
WHERE film.length<90 
AND film.rating IN ('G', 'NC-17');