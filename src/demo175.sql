<!--组合两个表 简单 -->
select firstName,lastName,city,state
from Person
left join Address on Person.personId=Address.personId
