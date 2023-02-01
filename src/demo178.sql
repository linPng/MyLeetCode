<!--第二高的薪水 简单 -->
select Score,
dense_rank() OVER (
        ORDER BY Score DESC
    ) as "rank"
from Scores
order by Score DESC
<!-- dense_rank 和 rank 不同的地方在与dense不会跳过排名  如1，1，2，3 而不是 1，1，3，4； -->