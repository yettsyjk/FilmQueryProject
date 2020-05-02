SELECT * 
FROM film
JOIN film_actor 
ON film.id = film_actor.film_id
WHERE film_id = 1
;


SELECT * 
FROM film
JOIN film_actor 
ON film.id = film_actor.film_id
WHERE film_id = ?//binding variables
;

SELECT * FROM actor WHERE id = 12;
SELECT * FROM actor WHERE id = ?;//binding variables