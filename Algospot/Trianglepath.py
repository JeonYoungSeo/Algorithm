C = int(input())

def path(y, x, tri) :
    memo = [[-1]*101 for i in range(101)]    

    def path_rec(y, x) :
        ##기저조건 
        if y == n-1 :
            return tri[y][x]
        
        #메모이제이션 
        if memo[y][x] != -1 :
            return memo[y][x] 
        
        
        ret = max(path_rec(y+1,x), path_rec(y+1,x+1)) + tri[y][x]
        memo[y][x] = ret 
      
        return ret 

    return path_rec(y,x)



for _ in range(C) :
    n = int(input()) #2~100
    
    tri = list()

    for _ in range(n) :
        tri.append(list(map(int,input().split())))

    print(path(0,0,tri))

    


