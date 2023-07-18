<!--行程和用户-->
select t.request_at as Day,ROUND((count(IF(t.status in ('cancelled_by_driver','cancelled_by_client'),1,null)))/(count(t.id)),2) as 'Cancellation Rate'
from Trips t
inner join Users d on t.driver_id=d.users_id and d.role in ('driver','partner') and d.banned='No'
inner join Users c on t.client_id=c.users_id and c.role in ('client','partner') and c.banned='No'
where t.request_at between '2013-10-01' and '2013-10-03'
group by t.request_at
order by t.request_at
