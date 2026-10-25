# [접근 방식] 
# DATETIME 으로 그룹핑하고, COUNT 변수를 써서 표현한다.
#   - DATETIME에서 HOUR 만 추출.
# 시간대 순 오름차순 정렬.
# 
# [엣지 케이스]
# 

SELECT HOUR(DATETIME) as HOUR, count(*) as COUNT
FROM ANIMAL_OUTS
GROUP BY HOUR
HAVING HOUR BETWEEN 9 and 19
ORDER BY HOUR