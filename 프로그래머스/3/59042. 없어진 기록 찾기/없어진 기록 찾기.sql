-- 보호소에 들어온 기록이 없는 동물의 ID와 이름을 ID 순으로 조회하는 SQL문을 작성
--  동물 보호소에 들어온 동물의 정보를 담은 테이블 : ANIMAL_INS
--  동물 보호소에서 입양 보낸 동물의 정보를 담은 테이블: ANIMAL_OUTS


-- 두 테이블을 조인한다. ANIMAL_OUTS left join ANIMAL_INS
--  ANIMAL_INS 가 NULL인 행을 찾아서 반환한다.


select o.ANIMAL_ID, o.NAME
from ANIMAL_OUTS o left join ANIMAL_INS i ON o.ANIMAL_ID = i.ANIMAL_ID
where i.ANIMAL_ID is NULL
order by o.ANIMAL_ID, o.NAME