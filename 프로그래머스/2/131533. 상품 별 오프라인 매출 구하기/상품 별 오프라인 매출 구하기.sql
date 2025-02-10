-- 코드를 입력하세요
SELECT p.PRODUCT_CODE as 'PRODUCT_CODE', (p.PRICE * SUM(s.sales_amount)) as 'SALES'

FROM PRODUCT p JOIN OFFLINE_SALE s ON p.PRODUCT_ID = s.PRODUCT_ID
GROUP BY p.PRODUCT_CODE
ORDER BY (p.PRICE * SUM(s.sales_amount)) DESC, PRODUCT_CODE ASC

-- 상품코드 별 매출액(판매가 * 판매량)

-- 상품 코드별 GROUP -> SALES_AMOUNT가 각행으로 나옴.
--  -  각행을 더해서 * 매출액 곱하면 됨.