-- 코드를 입력하세요
SELECT 
    COUNT(*)
FROM
    USER_INFO
WHERE -- 2021년에 가입한 회원 && 나이가 20세 이상 && 나이가 29세 이하
    YEAR(JOINED) = 2021 
    AND
    AGE BETWEEN 20 and 29