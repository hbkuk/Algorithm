import sys
from itertools import combinations

sys.stdin = open( "input.txt", "r")

n, m = map( int, input().split() )
city = list( list(map(int, input().split())) for _ in range( n ))
result = 999999
house = []
chicken = []

for i in range(n):
    for j in range(n):
        if city[i][j] == 1:
            house.append( [i, j] )  # 집 좌표 저장
        elif city[i][j] == 2:
            chicken.append( [i, j]) # 치킨집 좌표 저장

def solve( ):
    global result
    for chi in combinations( chicken, m ):    # m개의 치킨집 선택
        minSum = 0
        for hou in house:   # 전체 집 탐색
            minValue = 999
            for i in range(m):
                minValue = min( minValue , abs( hou[0] - chi[i][0] ) + abs( hou[1] - chi[i][1] ) )
            minSum += minValue # m개의 치킨집 중 가장 가까운거리 탐색
        result = min( result, minSum )
    return result
    
solve()
print( result )