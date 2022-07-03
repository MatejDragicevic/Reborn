# Write your MySQL query statement below
select a.actor_id, d.director_id
from actordirector a
join actordirector d on a.timestamp=d.timestamp
group by a.actor_id, d.director_id
having count(*)>2;

-- or easier
# Write your MySQL query statement below
select actor_id, director_id
from actordirector
group by actor_id, director_id
having count(*)>2;