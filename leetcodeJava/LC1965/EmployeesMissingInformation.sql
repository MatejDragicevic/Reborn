# Write your MySQL query statement below

(select distinct e.employee_id
from Employees e
left join Salaries s
on e.employee_id = s.employee_id
where s.employee_id is null
 
union

select distinct s.employee_id
from Employees e
right join Salaries s
on e.employee_id = s.employee_id
where e.employee_id is null)
order by employee_id;

-- or

SELECT sub.employee_id
FROM (
	SELECT e.employee_id, name, salary
	FROM employees AS e
	LEFT JOIN salaries AS s
	ON e.employee_id = s.employee_id
	
	UNION
	
	SELECT s.employee_id, name, salary
	FROM employees AS e
	RIGHT JOIN salaries AS s
	ON e.employee_id = s.employee_id) AS sub
WHERE sub.name IS NULL OR sub.salary IS NULL
ORDER BY sub.employee_id

-- or

SELECT employee_id
FROM Employees e
LEFT JOIN Salaries s
USING (employee_id)
WHERE s.salary IS NULL
UNION 
SELECT employee_id
FROM Employees e
RIGHT JOIN Salaries s
USING (employee_id)
WHERE e.name IS NULL
ORDER BY employee_id