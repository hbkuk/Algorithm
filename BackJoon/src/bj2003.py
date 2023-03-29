"""
1. 아이디어
- 투 포인터를 통한 구간 이동, 3가지 경우 나누기
    목표합 > 실제sum, 포인터 좌측 +1, 리셋 
    목표합 < 실제sum, 포인터 우측 +1, 리셋
    목표합 = 실제sum, 카운팅+=1
2. 시간복잡도
- O(N) : 10,000 < 2억개!, 출력 가능
3. 자료구조
- 수열 저장 int[]
- 합계 저장 int
- 경우의 수 저장 int
"""

import sys

input = sys.stdin.readline

N, M = map(int, input().split())
A = list(map(int, input().split()))

count = 0
interval_sum = 0
end = 0

for start in range(N):
    # end 포인터 이동
    while interval_sum < M and end < N:
        interval_sum += A[end]
        end += 1

    # 부분합이 M과 같으면 카운트
    if interval_sum == M:
        count += 1

    # start 포인터 이동에 따른 interval_sum 갱신
    interval_sum -= A[start]

print(count)
