"""
1. 시나리오
 - 

"""
import sys
sys.stdin = open( "input.txt", "r")

t=int(input())
for i in range(t):
    cnt=0
    
    n,m=map(int, input().split()) #문서의 개수,몇번째에 놓여있는지
    pr=list(map(int, input().split())) #중요도
    
    m_pr = [0 for i in range(n)]
    m_pr[m]=1#중요도가 궁금한 문서(m번째 문서)의 인덱스를 임의로 1로 표시
    
    while True:#큐의 첫번째 값이 내가 찾는 값(m)일때까지 반복
        if pr[0]==max(pr): #중요도가 제일 큰 값이면 cnt에 1을 더해준다
            cnt+=1
            
            if m_pr[0]!=1: #원하는 문서가 아니라면
                del pr[0] #중요도의 첫번째 값 삭제
                del m_pr[0]#인덱스의 첫번째 값 삭제
                
            else:#원하는 문서라면
                print(cnt)#cnt를 출력하고 반복문 종료
                break
                
        else: #원래 문서를 저장하기 위함 m_pr은 pr이 변할 때마다 순서를 바꿔줘야함
            pr.append(pr.pop(0))#아니라면 중요도(pr)의 첫번째값을 맨뒤에 넣어주고, 삭제
            m_pr.append(m_pr.pop(0)) 
            