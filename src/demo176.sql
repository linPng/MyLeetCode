<!--第N高的薪水 中等 -->
CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
declare m INT;
    set m = N-1; # 必须单独定义变量, 不能直接下文sql中用N-1
  RETURN (
      # Write your MySQL query statement below.
      select ifnull(
(select distinct salary
from Employee
order by salary desc
limit m,1)
,null)  as SecondHighestSalary
  );
END
