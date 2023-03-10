"""
1. 시나리오
- dfs 방식으로 풀것.

2. 시간복잡도
- 12개의 숫자 중 중복없이 6개를 선택

3. 알고리즘
- q []
-
"""
import sys
sys.stdin = open( "input.txt", "r")

def dfs( depth, idx ):
    if len(q) == 6:
        print( " ".join(map(str,q)))
        return
    for i in range( idx, k ):
        q.append(S[i])
        dfs(depth + 1, i + 1)
        q.pop()

while True:
    global S
    array = list(map(int, input().split()))
    k = array[0]
    S = array[1:]
    q = []
    dfs( 0, 0 )
    if k == 0:
        exit()
    print()
