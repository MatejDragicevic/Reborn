# Write your MySQL query statement below

-- area >= 3 000 000 
-- population >= 25 000 000

select name, population, area
from World
where area >= 3000000
or population >= 25000000

-- #Union
-- SELECT name, population, area
-- FROM World
-- WHERE area > 3000000 
-- 
-- UNION
-- 
-- SELECT name, population, area
-- FROM World
-- WHERE population > 25000000