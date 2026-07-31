-- Write your query below
with totals as (
    select user_id, sum(distance) as travelled_distance
    from rides
    group by user_id
)
select name, coalesce(travelled_distance, 0) as travelled_distance
from users u
left join totals t
on (u.id = t.user_id)
order by travelled_distance desc, name