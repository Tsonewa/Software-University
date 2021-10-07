-- find books which titles start with “The” and replace the substring with 3 asterisks.

SELECT REPLACE(title, 'The' ,'***') AS title FROM books
WHERE substring(title, 1, 3) = 'The'
ORDER BY id;