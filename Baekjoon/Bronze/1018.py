N, M = map(int, input().split())

a= [0] * N

small = 64
count = 0

for i in range(N):
    a [i] = input()

for i in range(N-7):
    for j in range(M-7):
        count = 0 
        for x in range(i, i+8, 2):
            for y in range(j, j+8, 2):
                if a[x][y] == 'B' :
                    count += 1
            for y in range(j+1, j+8, 2):
                if a[x][y] == 'W' :
                    count += 1
        for x in range(i+1, i+8, 2):
            for y in range(j, j+8, 2):
                if a[x][y] == 'W' :
                    count += 1
            for y in range(j+1, j+8, 2):
                if a[x][y] == 'B' :
                    count += 1
        if small > count :
            small = count
        count = 0 
        for x in range(i, i+8, 2):
            for y in range(j, j+8, 2):
                if a[x][y] == 'W' :
                    count += 1
            for y in range(j+1, j+8, 2):
                if a[x][y] == 'B' :
                     count += 1
        for x in range(i+1, i+8, 2):
            for y in range(j, j+8, 2):
                if a[x][y] == 'B' :
                     count +=1
            for y in range(j+1, j+8, 2):
                if a[x][y] == 'W' :
                     count +=1
        if small > count :
            small = count
        count = 0
                    
                                
print(small)
