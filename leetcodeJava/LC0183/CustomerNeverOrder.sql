# Write your MySQL query statement below

select name as 'Customers'
from Customers
where id not in
(select distinct customerId
from Orders)

-- SELECT Name AS Customers
-- FROM CUSTOMERS
-- LEFT JOIN ORDERS
-- ON ORDERS.CustomerID = Customers.Id
-- WHERE Orders.CustomerID IS NULL