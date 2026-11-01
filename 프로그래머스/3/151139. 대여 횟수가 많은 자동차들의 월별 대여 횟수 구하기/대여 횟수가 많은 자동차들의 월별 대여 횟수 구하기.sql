# 대여 시작일을 기준으로 2022년 8월부터 2022년 10월까지 총 대여 횟수가 5회 이상인 자동차들에 대해서 해당 기간 동안의 월별 자동차 ID 별 총 대여 횟수(컬럼명: RECORDS) 리스트

# 바깥 쿼리: 서브 쿼리로 부터 전달 받은 자동차 ID의 8월 10월까지의 자동차 ID별 총 건수.
# 서브 쿼리: 2022년 8월부터 22년 10월까지 총 대여 횟수가 5회 이상인 자동차 ID 출력.

SELECT MONTH(START_DATE) as MONTH, CAR_ID, COUNT(*) as RECORDS
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
WHERE CAR_ID in 
(
    SELECT CAR_ID
    FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
    WHERE START_DATE >= '2022-08-01' and START_DATE < '2022-11-01'
    GROUP BY CAR_ID
    HAVING COUNT(*) >= 5   
) AND START_DATE >= '2022-08-01' and START_DATE < '2022-11-01'
GROUP BY MONTH, CAR_ID
ORDER BY MONTH, CAR_ID DESC