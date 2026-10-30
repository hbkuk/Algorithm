-- 풀이 방식
--  시간대 서브 테이블 만들기. -> 어떻게 만들지? 임시 테이블이라도 만들어야하는건가?
--  ANIMAL_OUTS 테이블 LEFT JOIN 해서 처리. -> ANIMAL_OUTS 테이블에서 같은 HOUR 행이 있을 경우 그 값을 넣어주기.

WITH RECURSIVE hours AS (
    SELECT 0 AS h
    UNION ALL
    SELECT h + 1 FROM hours WHERE h < 23
)
SELECT h.h 'HOUR', IFNULL(o.COUNT, 0) 'COUNT'
FROM hours h LEFT JOIN (
    SELECT HOUR(DATETIME) 'HOUR', COUNT(*) 'COUNT'
    FROM ANIMAL_OUTS
    GROUP BY HOUR
) as o ON h.h=o.HOUR
ORDER BY 'HOUR'