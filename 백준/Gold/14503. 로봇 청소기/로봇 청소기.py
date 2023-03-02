import sys
input = sys.stdin.readline

N,m = map( int, input().split() )
y, x, d= map( int, input().split() )
map = [ list(map( int, input().split() )) for _ in range(N) ]

dy = [ -1, 0, 1, 0 ]
dx = [ 0, 1, 0, -1 ]
def solve( y, x, d ):
    cnt = 0
    while 1:
        # 1-1. 현재 칸을 청소한다.
        map[y][x] = 2
        # 1-2. 청소량을 1 증가시킨다.
        cnt+=1

        flag = 1
        while flag == 1:
            # 2. 현재 칸을 중심으로 왼쪽부터 4방향을 확인한다.
            for i in range( 0, 4 ):
                ny = y + dy[(d+3-i)%4]
                nx = x + dx[(d+3-i)%4]
                # 2-1. 90도 회전했을때 바라보는 방향의 칸이 청소되지 않았으면
                if map[ny][nx] == 0:
                    # 2-2. 해당 칸으로 이동한다.
                    y = ny
                    x = nx
                    d = ((d+3-i)%4)
                    flag = 0
                    # 2-3. 탐색 for문을 빠져나간다
                    break

            # 3. 4방향을 탐색했을 때, 청소가 안된 칸이 없다면
            else:
                # 3-1. 뒤가 벽이라면(바라보는 방향을 빼주면 뒤로 이동)
                by = y - dy[d]
                bx = x - dx[d]
                if map[by][bx] == 1:
                    return cnt
                # 3-2. 벽이 아니라면
                else:
                    y = by
                    x = bx


ans = solve( y, x, d)
print( ans )