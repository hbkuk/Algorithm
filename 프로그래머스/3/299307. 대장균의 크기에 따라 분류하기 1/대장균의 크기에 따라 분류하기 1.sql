-- 코드를 작성해주세요

select ID, CASE
               WHEN SIZE_OF_COLONY > 1000            THEN 'HIGH'
               WHEN SIZE_OF_COLONY > 100 and SIZE_OF_COLONY <= 1000 THEN 'MEDIUM'
               WHEN SIZE_OF_COLONY <= 100            THEN 'LOW'
    END AS 'SIZE'
from ECOLI_DATA
order by ID