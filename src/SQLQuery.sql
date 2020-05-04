SELECT *  FROM film WHERE title LIKE 
'%ACADEMY%' OR description 
LIKE '%epic%'
;
SELECT *  FROM film WHERE title LIKE 
'%ACADEMY%' OR description 
LIKE '%epic%'
;


SELECT id, title, description, release_year, rating,
film.id, film.language_id 
FROM film limit 2;


SELECT *  FROM actor JOIN film_actor ON actor.id = film_actor.actor_id WHERE film_id = 4;



SELECT * 
FROM actor
JOIN film_actor
ON actor.id = film_actor.actor_id
WHERE film_id = 4
;



SELECT * FROM film limit 10;

SELECT film.title
FROM film
WHERE title LIKE '%ACADEMY%'
OR description LIKE '%Epic%'
;






SELECT language.id, language.name 
FROM language
WHERE id = 6
;


SELECT language.name
FROM language
JOIN film
ON film.language_id = language.id
WHERE film.id = 6 
;

SELECT film.language_id FROM film;
SELECT language.id FROM language;


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