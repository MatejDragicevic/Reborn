# Write your MySQL query statement below
select s1.name
from SalesPerson s1
where sales_id not in
(select s2.sales_id
from SalesPerson s2
left join Orders o on s2.sales_id = o.sales_id
left join Company c on o.com_id = c.com_id
where c.name = "RED");

-- or

select s.name
from orders o
join company c
on (o.com_id = c.com_id and c.name = 'RED')
right join salesperson s
on s.sales_id = o.sales_id
where o.sales_id is null