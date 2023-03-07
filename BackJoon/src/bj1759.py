import sys
sys.stdin = open( "input.txt", "r")

l, c = map(int, input().split())
bet = list(map(str, input().split()))
bet.sort() #알파벳 오름차순 정렬
vowels = ['a', 'e', 'i', 'o', 'u']
ans = []

def check(ans):
    mo = 0 #모음 개수
    ja = 0 #자음 개수
    for i in range(l): #개수 계산
        if ans[i] in vowels:
            mo += 1
        else:
            ja += 1
    if mo >= 1 and ja >= 2: #자음모음 개수 충족
        return True
    else:
        return False
def func(j):
    if len(ans) is l:
        if check(ans) is False: #자음모음 개수 조건 확인
            return
        for i in ans: #출력
            print(i, end="")
        print()
        return
    for i in range(j, c): #알파벳 오름차순 정렬(j)
        ans.append(bet[i])
        func(i+1)
        ans.pop()
func(0)