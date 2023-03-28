"""
1. 아이디어
- 투포인터 활용
- for문으로, 처음 K개 합산
- 다음 인덱스 더해주고, 이전 인덱스 빼주면서 최대값 갱신

2. 시간복잡도
- 완전 탐색일 경우 O(N^2) -> 10_000_000_000 > 2억개!, 시간초과 발생
- 투포인터로 할 경우 O(N) -> 100_000 < 2억개!, 가능!

3. 자료구조
- 각 숫자들 N개 저장 배열 : int[]
    * 최대 100 이므로, int 가능
- N에서 K개의 값을 저장할 변수 : int
    * 최대 : K * 100 = 100_000 * 100 = 10e7, int 가능
- 최대값 저장 변수 : int
"""

import sys
input = sys.stdin.readline

N,K = map(int, input().split())
nums = list(map(int, input().split()))
sum = 0

# K개 더해주기
for i in range( K ):
    sum += nums[i]
maxv = sum

# 다음 인덱스 더해주고, 이전 인덱스 빼주기
for j in range( K, N ):
    sum += nums[i]
    sum -= nums[i-k]
    maxv = max(maxv, sum)

print( maxv )