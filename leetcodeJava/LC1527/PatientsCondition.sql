# Write your MySQL query statement below
select
    *
from
    Patients
where
    conditions like 'DIAB1%' or conditions like '% DIAB1%'
--    regexp_like(conditions, '^DIAB1') or regexp_like(conditions, ' DIAB1');