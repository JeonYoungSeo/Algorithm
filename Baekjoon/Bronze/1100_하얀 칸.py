a = list()
n = 0
for i in range(8):
    a.append(list(input()))

result = 0

for i in range(len(a)):
    for j in range(len(a[i])) :
        if i%2==0 and j%2==0:
            if a[i][j] == 'F' :
                result+=1
        elif i%2!=0 and j%2!=0 :
            if a[i][j] == 'F' :
                result+=1


print(result)
