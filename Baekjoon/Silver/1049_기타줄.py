n, t = map(int, input().split())

amin = bmin = 1000

for _ in range(t) :
    a,b = map(int, input().split())

    amin = min(a, amin)
    bmin = min(b, bmin)

a=b=0

div = n//6
rem = n%6

if(n%6==0) :
    a = amin*div
else :
    a = min(amin*(div+1), amin*div+rem*bmin)

b = bmin * n
print(min(a,b))
