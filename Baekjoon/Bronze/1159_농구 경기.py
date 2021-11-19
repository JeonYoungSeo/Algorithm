from collections import Counter

N = int(input())

lst = list()

for _ in range(N):
    temp = input()
    lst.append(temp[0])

cnt = Counter(lst)

result = list()

for key, value in cnt.items() :
    if value >= 5:
        result.append(key)

result.sort()

for c in result :
    print(c, end="")

if len(result) == 0 :
    print("PREDAJA")
    
