# FIRST_HALF
#     상반기 주문 정보
#     FLAVOR  PK
#     SHIPMENT_ID FK
    
# JULY
#     7월 아이스크림 총주문량
#     SHIPMENT_ID PK
#     FLAVOR  FK

# 체크리스트: 7월 같은 아이스크림 맛(FLAVOR)에 대하여 서로 다른 출하 번호가 있을 수 있음.
    
# => 7월 아이스크림 총 주문량과 상반기의 아이스크림 총 주문량을 더한 값이 큰 순서대로 상위 3개의 맛을 조회하는 SQL 문을 작성해주세요.

# 이건 어떻게 풀어야할까..? -> 두 테이블을 조인하는것도 아니고..
# UNION 으로 처리해야하려나?..
# 어찌됐든 두 테이블을 하나로 합쳐서 그 중에서 FLAVOR 를 그룹핑해서 SUM 하고.
# order by를 sum 한 것에 내림차순 후 상위 3개만 꺼내면 될 것 같은데? -> limit 3을 활용해봐도 될듯.

select FLAVOR
from (
select FLAVOR, SUM(TOTAL_ORDER) 'total'
from (SELECT FLAVOR, TOTAL_ORDER FROM FIRST_HALF
UNION ALL
SELECT FLAVOR, TOTAL_ORDER FROM JULY) as merge
group by FLAVOR
order by total desc
) as result
limit 3