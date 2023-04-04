"""
1. 아이디어
    1) N(전체 용액 수)를 입력받아서 sort()를 통해 오름차순으로 정렬
    2) for문에서 포인터(start, end)를 이동시키며 최적값(용액 합 0) 도출

2. 시간복잡도
- N(전체 용액 수)는 최대 100,000 이다.
    1) 완전 탐색일 경우 => O(N^2), 시간초과!
    2) 투 포인터로 진행할 경우 => O(N), 가능!

3. 자료구조
    1) N(전체 용액수) 저장 int
    2) N개의 용액 리스트 int[]
    3) 두 용액의 특성값 int
"""

import sys
input = sys.stdin.readline

n = int(input())
liquid = sorted(list(map(int, input().split())))

start = 0
end = n-1
ans = liquid[start] + liquid[end]
res = (start, end)

while start < end:
    mix = liquid[start] + liquid[end]

    if abs(mix) < abs(ans):
        ans = mix
        res = (start, end)

    if mix < 0:
        start += 1
    elif mix > 0:
        end -= 1
    else:
        break

print(liquid[res[0]], liquid[res[1]])







