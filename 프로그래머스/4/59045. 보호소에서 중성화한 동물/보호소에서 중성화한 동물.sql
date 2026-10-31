-- 보호소에 들어온 동물의 정보 테이블: ANIMAL_INS
-- 보호소에서 나간 동물의 정보 테이블: ANIMAL_OUTS
-- 중성화 여부(SEX_UPON_INTAKE)
--   'Intact' 으로 시작하면 중성화를 거치지 않음.
--   'Neutered' 으로 시작하면 중성화를 거침.

-- [필요한 쿼리]: 보호소에 들어올 당시에는 중성화되지 않았지만, 보호소를 나갈 당시에는 중성화된 동물의 아이디와 생물 종, 이름을 조회하는 아이디 순으로 조회하는 SQL 문을 작성해주세요.

-- [예외 케이스]
-- 무조건 들어오면 나가는건가? -> 그런 조건은 없음.


SELECT o.ANIMAL_ID, o.ANIMAL_TYPE, o.NAME
FROM ANIMAL_INS i JOIN ANIMAL_OUTS o ON i.ANIMAL_ID = o.ANIMAL_ID
WHERE i.SEX_UPON_INTAKE like 'Intact%' and (o.SEX_UPON_OUTCOME like 'Spayed%' or o.SEX_UPON_OUTCOME like 'Neutered%')