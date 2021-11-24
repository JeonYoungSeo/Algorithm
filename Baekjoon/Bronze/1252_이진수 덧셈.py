a, b = map(int, input().split())

c = a+b

c = [0,] + list(map(int, str(c)))

c.reverse()

for i in range(len(c)) :
    if c[i] >= 2 :
        c[i] -= 2
        c[i+1] += 1

c.reverse()

if c[0] == 0 :
    c.remove(0)

for i in c :
    print(i, end = "")
