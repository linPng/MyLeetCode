<!--上升的温度 简单-->
select a.ID
from weather as a cross join weather as b
     on datediff(a.recordDate , b.recordDate ) = 1
where a.Temperature  > b.Temperature ;
