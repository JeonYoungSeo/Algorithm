#test case
C = int(input())

## 함수 정의 
def countPairing(taken) :
    pairFree = -1
    for i in range(n) :
        if taken[i] != 1 :
            pairFree = i
            break
    if pairFree == -1 :
        return 1
    ret = 0
    #print(n)
    for j in range(pairFree+1,n) :
        if taken[j] != 1 and areFriend[pairFree][j] :
            taken[pairFree] = taken[j] = 1
            ret += countPairing(taken)
            taken[pairFree] = taken[j] = 0

    return ret


for c in range(C) :
    ##n = number of student, m = number of pair
    n, m = map(int, input().split())

    lst = list(map(int,input().split()))

    #print(lst) 

    areFriend = [[0]*10 for i in range(10)] 
    ## [[0]*10]]*10은 같은 address를 가진 list가 10개 생성되어 사용불가
    
    #for a in range(10) :
    #    print(areFriend[a])

    #print()
    for i in range(0, m*2, 2) :
        #순서바뀌어도 상관없게 하기 위함.
        areFriend[lst[i]][lst[i+1]] = 1
        areFriend[lst[i+1]][lst[i]] = 1
        #print(i,i+1)
    
    #for a in range(10) :
    #    print(areFriend[a],a)
    
    taken = [0 for i in range(n)]
    #print(taken)
    print(countPairing(taken))
