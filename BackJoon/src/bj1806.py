"""
1. 아이디어
- for문을 통해서 투 포인터로 문제 접근
2. 시간복잡도
- 투 포인터 O(N) : 1e^5 < 2억개 가능!
3. 자료구조
- 수열 저장 list[]
- 부분합 저장 int
- 길이 저장 int

4. 의문
- 길이를 저장하는 값은 N의 크기로 일단 지정?
- 합을 만드는 것이 불가능하다면 0을 출력...?
"""

import sys
input = sys.stdin.readline

N,S = map(int, input().split())
A = list(map(int, input().split()))
sum = 0
minLength = float('inf')
end = 0

def solve():
    global sum, minLength, end
    for start in range(N):
        # 특정 조건까지 end 포인터 이동
        while sum < S and end < N:
            sum += A[end]
            end += 1
        # while문을 빠져나와서, 문제의 합과 같은지 확인
        if sum >= S:
            minLength = min(minLength, end - start)
        # 초기화
        sum -= A[start]

solve()
if minLength == N :
    print( 0 )
else:
    print( minLength )
