n,m = map(int, input().split())
map = list()

for _ in range(n) :
    line = list(input())
    map.append(line)

for i in range(n) :
    for j in range(m) :
        if map[i][j] == '*' :
            map[i][j] = -1
        if map[i][j] == 'S' :
            map[i][j] = 0
        

my = [-1,1,0,0]
mx = [0,0,-1,1]

answer = 0
wrong = -1
while True :
    find = False
    end = False
    for y in range(n) :
        for x in range(m) :
            if map[y][x] != answer : continue
            
            for i in range(4) :
                ny = y + my[i]
                nx = x + mx[i] 
                if ny<0 or nx<0 or ny>=n or nx>=m : continue
                if (type(map[ny][nx])==type(1) and map[ny][nx] < 0) or map[ny][nx] == 'X' : continue
                if map[ny][nx] == 'D' :
                    end = True
                    break

                map[ny][nx] = answer + 1
                find = True
        if end :
            break
    if end :
        print(answer+1)
        break
    if find == False :
        print("KAKTUS")
        break

    for y in range(n) :
        for x in range(m) :
            if map[y][x] != wrong : continue
            for i in range(4) :
                ny = y + my[i]
                nx = x + mx[i] 
                if ny<0 or nx<0 or ny>=n or nx>=m : continue
                if map[ny][nx] == 'X' or map[ny][nx] =='D' : continue

                map[ny][nx] = wrong-1
    
    answer += 1
    wrong -=1
