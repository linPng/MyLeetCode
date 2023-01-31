<!--部门工资前三高的所有员工 困难-->
SELECT
    Department.NAME AS Department,
    e1.NAME AS Employee,
    e1.Salary AS Salary
FROM
    Employee AS e1,Department
WHERE
        e1.DepartmentId = Department.Id
  AND 3 > (SELECT  count( DISTINCT e2.Salary )
           FROM	Employee AS e2
           WHERE	e1.Salary < e2.Salary 	AND e1.DepartmentId = e2.DepartmentId 	)
ORDER BY Department.NAME,Salary DESC;