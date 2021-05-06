C = int(input())

def inputlst() :
    return list(map(int,input().split()))

def exe() :
    N = int(input())
    
    lst = inputlst()

    memo = [-1]*500
    
    def lis(start) :
        #메모이제이션
        if memo[start] != -1 :
            return memo[start]

        #처음에는 자신도 포함이니 1
        memo[start] = 1 
        #다음 큰수를 찾아서 재귀를 할거야
        for nxt in range(start+1,len(lst)) :
            if lst[start] < lst[nxt] :
                memo[start] = max(memo[start], lis(nxt)+1)
        
        return memo[start]
    
    maxlen = 0 
    for start in range(len(lst)) :
        maxlen = max(maxlen, lis(start))
    
    print(maxlen)

for _ in range(C) :
    exe() 
    
#### 스코프의 개념에 대해서 다시 찾아보았다 .
#### 예제를 다 읽고 풀었지만 스스로 하려고 노력해보았다 . 
###