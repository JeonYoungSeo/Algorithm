n = int(input())
word = input()
word = list(word)
answer = 0

leng = len(word)

for i in range(leng) :
    if(leng-i < answer) : break
    
    al = set()
    tmp = 0
    
    for j in range(i, leng) :
        a = word[j]
        al.add(a)
        if len(al) > n :
            break
        tmp += 1
    answer = max(answer, tmp)

print(answer)
