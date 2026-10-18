-- 코드를 작성해주세요

-- 부서별 평균 연봉 조회.
--   부서별로 부서 ID, 영문 부서명, 평균 연봉(소수점 첫째 자리에서 반올림, AVG_SAL)
--   부서별 평균 연봉을 기준으로 내림차순

-- select hd.DEPT_ID, hd.DEPT_NAME_EN, ROUNDUP(AVG(he.SAL), ) AVG_SAL
-- FROM HR_DEPARTMENT hd JOIN HR_EMPLOYEES he ON hd.DEPT_ID = he.DEPT_ID
-- GROUP BY he.DEPT_ID
-- ORDER BY AVG_SAL DESC

select hd.DEPT_ID, hd.DEPT_NAME_EN, ROUND(AVG(he.SAL), 0) AVG_SAL
FROM HR_DEPARTMENT hd JOIN HR_EMPLOYEES he ON hd.DEPT_ID = he.DEPT_ID
GROUP BY hd.DEPT_ID
ORDER BY AVG_SAL DESC
