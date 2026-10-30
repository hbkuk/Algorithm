-- 쿼리 구조: 메인 쿼리, 서브쿼리 구조
-- 메인 쿼리: 서브 쿼리의 HOST_ID에 해당하는 행을 출력한다.
-- 서브 쿼리: HOST_ID가 2개 이상인 ID를 찾는다.

SELECT main.ID, main.NAME, main.HOST_ID
FROM PLACES main JOIN
(
SELECT HOST_ID
FROM PLACES
GROUP BY HOST_ID
HAVING COUNT(*) >= 2
) as sub ON main.HOST_ID = sub.HOST_ID
ORDER BY main.ID