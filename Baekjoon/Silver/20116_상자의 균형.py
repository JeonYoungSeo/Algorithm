n, l = map(int,input().split())

ori = list(map(int, input().split()))
arr = [0] * n
arr[0] = ori[0]
for i in range(1, n) :
    arr[i] += arr[i-1]+ori[i]
answer = True
for s in range(1,n) :
    sum = arr[n-1]-arr[s-1]
    avg = sum/(n-s)
    # print(sum, n-s+1)
    curr = ori[s-1]
    # print(avg, curr,s,n-1)
    if  curr-l < avg < curr + l :
        continue
    else :
        answer = False
        break
if answer : 
    print("stable")
else :
    print("unstable")
