# Write your MySQL query statement below
select id, 'Root' as type
from Tree
where p_id is null

union

select t1.id, 'Inner' as type
from Tree t1
join Tree t2
on t1.id = t2.p_id
where t1.p_id is not null

union

select t1.id, 'Leaf' as type
from Tree t1
left join Tree t2
on t1.id = t2.p_id
where t1.p_id is not null
and t2.p_id is null;

-- better
select id,
case
    when p_id is null then 'Root'
    when id in (select p_id from tree) then 'Inner'
    else 'Leaf'
end as Type
from tree;