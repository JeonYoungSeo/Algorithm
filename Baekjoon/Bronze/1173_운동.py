N, m, M, T, R = map(int, input().split())

pulse = m

if(pulse+T>M):
    print(-1)
else :
    t_time = 0;
    r_time = 0;
    
    while(t_time<N) :
        if pulse+T<=M :
            pulse += T
            t_time += 1
            continue
        pulse -= R
        if(pulse<m):
            pulse = m
        r_time += 1
    print(r_time+t_time)


            
