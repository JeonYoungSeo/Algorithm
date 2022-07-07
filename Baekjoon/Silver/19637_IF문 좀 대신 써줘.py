import sys
input = sys.stdin.readline

n, m = map(int,input().split())

word = []
power = [] 

for _ in range(n) :
    a,b = input().split()
    word.append(a)
    power.append(int(b))

for _ in range(m) :
    num = int(input())
    
    left = 0 
    right = n-1

    while left<right :
        mid = (left+right)//2 

        if power[mid] < num :
            left = mid+1 
        else :
            right = mid
    print(word[left])
