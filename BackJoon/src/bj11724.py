"""
1. 시나리오
- dfs를 돌면서 빠져나오면 +1을 해준다.

2. 시간 복잡도
- 정점: 1,000개
- 간선: (1,000 x 999) / 2
- 500,500 < 2억개 가능!

3. 자료구조
- [False] * N

"""

import sys
sys.setrecursionlimit(10**6)
input = sys.stdin.readline

def dfs(c):
    if v[c] == True:
        return
    v[c] = True
    for i in adj[c]:
        dfs(i)


N,M = map(int, input().split())
adj = [[] for _ in range(N+1) ]

for _ in range(M):
    s, e = map( int, input().split() )
    # 양방향
    adj[s].append(e)
    adj[e].append(s)

count = 0
v = [False] * ( N + 1 )

for i in range( 1, N + 1 ):
    if v[i] == False:
        dfs(i)
        count += 1

print(count)




