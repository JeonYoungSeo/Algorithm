a = int(input())

k = 0 
for i in range(10000000):
    j = str(i)
    if (j.count('666')>=1):
        k += 1
        if k == a:
            print(j)
            break
