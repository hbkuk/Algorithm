-- [최종 결과]
-- 2021년에 가입한 전체 회원들 중 상품을 구매한 회원수
-- 상품을 구매한 회원의 비율(=2021년에 가입한 회원 중 상품을 구매한 회원수 / 2021년에 가입한 전체 회원 수)
-- <년 | 월> 별로 출력.

SELECT 
    YEAR(o.SALES_DATE)as YEAR, 
    MONTH(o.SALES_DATE) as MONTH, 
    COUNT(DISTINCT u.USER_ID) as PURCHASED_USERS,
    ROUND(COUNT(DISTINCT u.USER_ID) / (
        SELECT COUNT(DISTINCT USER_ID)
        FROM USER_INFO u
        WHERE YEAR(JOINED) = '2021'
    ), 1) as PUCHASED_RATIO
FROM USER_INFO u JOIN ONLINE_SALE o ON u.USER_ID = o.USER_ID
WHERE YEAR(u.JOINED) = '2021'
GROUP BY YEAR, MONTH
ORDER BY YEAR, MONTH