<!--从不订购的客户 简单 in可以两个字段-->
SELECT
    Department.name AS 'Department',
        Employee.name AS 'Employee',
        Salary
FROM
    Employee
        JOIN
    Department ON Employee.DepartmentId = Department.Id
WHERE
        (Employee.DepartmentId , Salary) IN
        (   SELECT
                DepartmentId, MAX(Salary)
            FROM
                Employee
            GROUP BY DepartmentId
        )
;