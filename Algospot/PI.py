C = int(input())

def memo(case) :
    memo = [-1]*10002
    
    def score(s,e) :        
        sub = list()
                
        #규칙 찾기위해 붙어있는 수의 차를 구한다
        for i in range(s,e) :
            sub.append(case[i+1] - case[i])

        if len(set(sub)) == 1 :
            if sub[0] == 0 :
                return 1

            elif sub[0] == 1 or sub[0] == -1 :
                return 2 
            
            else : 
                return 5 
        elif len(set(sub)) == 2 :
            if sub[0] == -sub[1]:
                return 4
        
        return 10 
    
    
    def memo_recur(a) :
        if a >= len(case) :
            return 0

        if memo[a] != -1 :
            return memo[a] 
        
        ret = 987654321

        for i in range(3, 6) :
            if a+i <= len(case) :
                ret = min(ret, memo_recur(a+i) + score(a, a+i-1))
 
        return ret
    
    print(memo_recur(0))

    return 0

for _ in range(C) :
    case = list(input().rstrip())
    case = map(int, case)
    case = list(case)

    memo(case)

