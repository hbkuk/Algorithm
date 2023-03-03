def dfs(c):

    # 방문정보 등록
    v[c] = 1
    ans_dfs.append(c)

    # 다음 방문지
    for i in adj[c]:
        if v[i] == 0:
            dfs(i)

def bfs(s):
    # 필요한 q, v[], 변수 생성
    q = []

    # Q에 초기데이터 삽입
    q.append(s)
    ans_bfs.append(s)
    v[s] = 1

    while q:
        c = q.pop(0)
        for n in adj[c]:
            if v[n] == 0:
                q.append(n)
                v[n] = 1
                ans_bfs.append(n)


# 정점 N과 간선 M의 개수, 시작 정점 번호 V
N,M,V = map( int, input().split() )
# 인접 리스트 생성
adj = [[] for _ in range(N+1) ]
# 인접리스트 채우기
for _ in range(M):
    s, e = map( int, input().split() )
    # 양방향
    adj[s].append(e)
    adj[e].append(s)

# 오름차순 정렬
for i in range( 1, N+1 ):
    adj[i].sort()

# dfs 방문정보, 방문기록
v = [0] * ( N + 1)
ans_dfs = []
dfs(V)

# bfd 방문정보, 방문기록
v = [0] * ( N + 1)
ans_bfs = []
bfs(V)

print( *ans_dfs )
print( *ans_bfs )


