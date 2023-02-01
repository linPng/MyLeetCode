<!--超过经理收入的员工 中等 效率极低 -->
SELECT
    a.NAME AS Employee
FROM Employee AS a JOIN Employee AS b
ON a.ManagerId = b.Id
AND a.Salary > b.Salary