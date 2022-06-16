
def func(num) : 
    for i in prime_number :
        if i > num : 
            break
        for j in prime_number :
            if i+j > num : 
                break 
            for k in prime_number :
                if(i+j+k > num) :
                    break 
                if(i+j+k == num) :
                    return str(i)+" "+str(j)+" "+str(k)
    return 0


n = int(input())

prime = [True,] * 1001
prime_number = list()
for i in range(2, 334) :
    for j in range(i+i, 1001, i) : 
        prime[j] = False

for i in range(2, 1001) :
    if prime[i] : 
        prime_number.append(i)

for _ in range(n) : 
    num = int(input())

    print(func(num))

