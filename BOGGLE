
## Number of cases
C = int(input())

def fword(x, y, wrd) :
    if x<0 or x>4 or y<0 or y>4 :
        return False

    if lst[x][y] != wrd[0] :
        return False
    #print(wrd)
    if len(wrd) == 1 :
        return True
    
    for i, j in zip(dy, dx) :
        if fword(x+i, y+j, wrd[1:]) :
            return True
        #print(wrd)
    return False        


for Case in range(C) :
    lst = list()
    
    for i in range(5) :
        lst.append(input())
    print(lst)
    dy = [-1, -1, -1, 1, 1, 1, 0, 0]
    dx = [-1, 0, 1, -1, 0 ,1, -1, 1]

    ## number of word 
    N = int(input())
    word = list()
    for j in range(N) :
        word.append(input())
        check = 0
        
        for x in range(5) :
            for y in range(5) :
                if fword(x, y, word[j]) :
                    print(word[j], "YES")
                    check = 1
                    break
            if check == 1 :
                break
        if check == 1 :
            continue 
        print(word[j],"NO")     
                
            

