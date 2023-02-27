"""
1. 아이디어
- 2중 for => 값 1 && 방문X ==> BFS
- BFS 돌면서 그림 개수 + 1, 최대값 갱신

2. 시간 복잡도
- BFS : O(V+E)
- V : 500 * 500
- E : 4 * 500 * 500
- V + E : 5 * 250000 = 100만 < 2억 >> 가능!

3. 자료구조
- 그래프 전체 지도 : input[][]
- 방문 : bool[][]
- Queue( BFS )

"""

import sys
input = sys.stdin.readline

# n(세로), m(가로) 입력받는다.
n, m = map( int, input().split() )

# 그림의 전체 지도를 n개의 list 생성
map = [list(map( int, input().split())) for _ in range(n)]

# 방문정보 list 생성
chk = [[False] * m for _ in range(n)]

# dy, dx 정의
dy = [ 0, 1, 0, -1 ]
dx = [ 1, 0, -1, 0 ]

# bfs 함수 정의
def bfs( y, x):
    rs = 1
    q = [( y, x)]
    while q:
        ey, ex = q.pop()
        for k in range( 4 ):
            ny = ey + dy[k]
            nx = ex + dx[k]
            if 0 <= ny < n and 0 <= nx < m:
                if map[ny][nx] == 1 and chk[ny][nx] == False:
                    rs += 1
                    chk[ny][nx] = True
                    q.append(( ny,nx ))
    return rs                    

# 전체 그림 카운트
cnt = 0
# 최대 그림 크기 value
maxV = 0

for j in range(n):
    for i in range(m):
        # 그림이 1이면서 방문하지 않았다면
        if map[j][i] == 1 and chk[j][i] == False:
            # 방문했다면 체크
            chk[j][i] = True
            # 전체 그림 갯수 +1
            cnt += 1
            # 최대값 갱신
            maxV = max( maxV, bfs( j, i) )

print( cnt )
print( maxV )