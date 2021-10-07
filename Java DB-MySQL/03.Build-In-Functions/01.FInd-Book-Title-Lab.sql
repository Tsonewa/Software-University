-- find books which titles start with “The”. Order the result by id

SELECT title FROM `books`
WHERE substring(title, 1, 3) = 'The'
ORDER BY id;