"""
1. 아이디어
- for문으로 1부터 시작해서, start 포인터와 end 포인터를 변경하면서 합을 합을 찾음.
- 찾는 즉시 카운터르 증가시키고, start 포인터를 + 1 증가시킴.
2. 시간복잡도
- 완전 탐색은 O(N^2)으로 1e^12로 시간초과 발생, 따라서 투 포인터로 진행 O(N) => 가능
3. 자료구조
- 조합 카운트 int
"""

import math

N = int(input())

a = [False, False] + [True] * (N-1)
prime_num = []

for i in range(2, N+1):
    if a[i]:
        prime_num.append(i)
        for j in range(2*i, N+1, i):
            a[j] = False

answer = 0
start = 0
end = 0
while end <= len(prime_num):
    temp_sum = sum(prime_num[start:end])
    if temp_sum == N:
        answer += 1
        end += 1
    elif temp_sum < N:
        end += 1
    else:
        start += 1

print(answer)
