"""
1. 아이디어
- N개의 리스트에서 M개의 리스트 요소를 꺼내서 이진탐색으로 찾기

2. 시간복잡도
- N개의 리스트 정렬(sort) => O(NlgN)
- M개를 for문을 통해 N개 리스트에 있는지 확인 => O(M * lgN)
- 총합 : O((N+M)lgN) < 2억개!! ==> 가능.

3. 자료구조
- N개의 숫자 ==> int[]
- M개의 숫자 ==> int[]
"""

import sys
input = sys.stdin.readline

N=int(input())
n_list=list(map(int, input().split()))
n_list.sort()

M=int(input())
m_list=list(map(int, input().split()))


def solve(st,ed,target):
    if st==ed:
        if n_list[st]==target:
            print( 1 )
        else:
            print( 0 )
        return
    
    mid = (st + ed) // 2
    if n_list[mid] < target:
        solve(mid + 1, ed, target)
    else:
        solve(st, mid, target)

for number in m_list:
    solve(0, N-1, number)
