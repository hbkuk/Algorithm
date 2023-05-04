import sys
input = sys.stdin.readline

N, M = map(int, input().split())
trees = list(map(int, input().split()))

st = 0
ed = max(trees)

while(st < ed):
    mid = (st + ed) // 2 + 1

    sum = 0
    for tree in trees:
        if tree > mid:
            sum += (tree - mid)
    
    if sum >= M:
        st = mid
    else:
        ed = mid - 1

print( st )