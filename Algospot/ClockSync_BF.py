###### clocksync 
import time
import sys
import pprint
input = lambda : sys.stdin.readline().rstrip()


###스위치 갯수와 횟수 
num_switch = 10 
count = 4

## 스위치에 연결되있는 시계 

clockswitch = [
    [1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
    [0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0],
    [0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1],
    [1, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0],
    [0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 1, 0, 1, 0, 0, 0],
    [1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1],
    [0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1],
    [0, 0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 1, 1],
    [0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
    [0, 0, 0, 1, 1, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0]
]

## 전부 12시일까 ? 
def isSync(clock) :
    check = 1
    for i in range(len(clock)) :
        if clock[i] != 12 :
            check = 0
            break
    return check 

def clicked_siwtch(clock,switch) :
    for i in range(len(clock)) :
        if clockswitch[switch][i] == 1 :
            clock[i] += 3 
            if clock[i] == 15 : 
                clock[i] = 3
                
def click_mintime(clock, switch) :
    if switch == num_switch :
        if isSync(clock) == 1 : 
            return 0
        else :
            return 987654321

    ret = 987654321

    for click in range(4) :
        
        ret = min(ret, click + click_mintime(clock, switch+1))
        clicked_siwtch(clock,switch)
        
    return ret




C = int(input())

for c in range(C) :
    start = time.time() 
    switch = 0 

    clock = list(map(int, input().split()))

    print(click_mintime(clock, switch))
    print("time :", time.time() - start)  # 현재시각 - 시작시간 = 실행 시간

