-- Write your query below
select name, coalesce(sum(distance), 0) as travelled_distance
from users u
left join rides r
on (u.id = r.user_id)
group by user_id, name
order by travelled_distance desc, name
