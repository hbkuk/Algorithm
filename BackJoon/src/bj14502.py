"""
1. 시나리오
- 벽을 3개 세운다.
    * (1,1)부터 (M,N) 까지 확인했을 때, 0(빈칸)인 위치에만 조합한다. => Combination 라이브러리 사용
- 바이러스를 감염시킨다.
    * while:q 를 통해서 무한 반복문을 시작한다.
    * (1,1)부터 (M,N)까지 확인했을 때 2번인(감염된 공간) 위치를 q에 저장한다.
    * 상하좌우로 이동할 수 있는 dy[],dx[] 배열을 만든다.
    * for문을 돌리고 넣기 전 방문 정보를 2번(감염된 공간)으로 만든다.
    * for i in range(4)와 같은 for문을 만든다.
    * q에 데이터가 없다면 while 무한 반복문을 종료한다.
- max 함수를 이용해서 가장 많은 수의 안전지대(0번)를 출력한다.
"""
import sys
from collections import deque
from itertools import combinations
import copy

input = sys.stdin.readline
N,M = map(int,input().split())
board = [list(map(int,input().split())) for _ in range(N)]

# ✨ 준비 1
safe_zone = []
virus = []
res = 0
dx = [-1,0,1,0]
dy = [0,-1,0,1]

# 감염
def BFS():
    global res
    cnt = len(safe_zone)-3
    ch_virus = deque([])
    for x,y in virus:
        ch_virus.append((x,y))
    while ch_virus:
        xx,yy = ch_virus.popleft()
        for i in range(4):
            nx = xx + dx[i]
            ny = yy + dy[i]
            if 0<=nx<N and 0<=ny<M and ch_board[nx][ny] == 0:
                ch_board[nx][ny] = 2
                ch_virus.append((nx,ny))
                cnt-=1
    res = max(res,cnt)

# 벽을 만들 준비
for i in range(N):
    for j in range(M):
        if board[i][j] == 0:
            safe_zone.append((i,j))
        elif board[i][j] == 2:
            virus.append((i,j))


# 조합
for comb in combinations(safe_zone,3):
    ch_board = copy.deepcopy(board)
    for x,y in comb:
        ch_board[x][y] = 1
    BFS()

# 최댓값 출력
print(res)

