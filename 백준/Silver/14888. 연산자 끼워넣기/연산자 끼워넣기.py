import sys

n = int(input())
value = list(map(int, input().split()))
calc = list(map(int, input().split()))
maxValue = -(sys.maxsize)
minValue = sys.maxsize
sum = value[0]

# 재귀함수 정의
def recur( index, sum, plus, minus, multi, div ):
    global maxValue, minValue

    # n개의 자연수가 조합되었다면( 연산자를 다 조합했다면 )
    if index == n:
        maxValue = max( maxValue, sum )
        minValue = min( minValue, sum )
        return
    
    if plus > 0:
        recur( index + 1, sum + value[index], plus-1, minus, multi, div )
    if minus > 0:
        recur( index + 1, sum - value[index], plus, minus-1, multi, div )
    if multi > 0:
        recur( index + 1, sum * value[index], plus, minus, multi-1, div )
    if div > 0:
        if sum >= 0:
            recur( index + 1, sum // value[index], plus, minus, multi, div-1 )
        elif sum < 0:
            recur( index + 1, -(-sum // value[index]), plus, minus, multi, div-1 )

# 초기, 재귀함수 호출
recur( 1, sum, calc[0], calc[1], calc[2], calc[3] )
print( maxValue )
print( minValue )

