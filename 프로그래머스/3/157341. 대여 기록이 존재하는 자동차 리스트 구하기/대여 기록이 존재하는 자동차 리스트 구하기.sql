-- 코드를 입력하세요
SELECT c.CAR_ID
FROM CAR_RENTAL_COMPANY_CAR c JOIN CAR_RENTAL_COMPANY_RENTAL_HISTORY h ON c.CAR_ID = h.CAR_ID
WHERE c.CAR_TYPE = "세단" AND MONTH(h.START_DATE) = 10
GROUP BY c.CAR_ID
ORDER BY c.CAR_ID DESC

-- 세단 && 10월에 대여를 시작한 기록이 있는 자동차 리스트