<!--第二高的薪水 简单 -->
select ifnull(
(select distinct salary
from Employee
order by salary desc
limit 1,1)
,null)  as SecondHighestSalary
