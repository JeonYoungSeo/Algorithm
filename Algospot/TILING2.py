##algospot TILING2 

MOD = 100000007

case = int(input())

def tiling(width) :
    #기저조건 
    if width <= 1 : 
        return 1 
    
    #메모이제이션
    if memo[width] != -1 :
        return memo[width]
    
    ret = (tiling(width-2)+tiling(width-1)) % MOD
    
    return ret 
    
for _ in range(case) :
    memo = [-1]*101
    
    width = int(input())

    print(tiling(width))




