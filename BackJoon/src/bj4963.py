import sys
sys.setrecursionlimit(10**6)

dr = [-1, -1, -1, 0, 0, 1, 1, 1]
dc = [-1, 0, 1, -1, 1, -1, 0, 1]

def dfs(a, b):
    global island, visited
    visited[a][b] = 1
    for dir in range(8):
        nr = dr[dir] + a
        nc = dc[dir] + b
        if nr >= 0 and nr < h and nc >= 0 and nc < w:
            if arr[nr][nc] == 1 and visited[nr][nc] == 0:
                dfs(nr,nc)



while True:
    island = 0
    w, h = map(int,input().split())
    if w == 0 and h == 0 :
        break
    arr = []
    visited = [[0] * w for _ in range(h)]
    for i in range(h):
        arr.append(list(map(int,input().split())))
    for i in range(h):
        for j in range(w):
            if arr[i][j] == 1 and visited[i][j] == 0:
                dfs(i,j)
                island += 1
    print(island)