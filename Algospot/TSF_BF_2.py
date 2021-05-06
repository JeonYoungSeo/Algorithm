from pprint import pprint
import sys
input = lambda : sys.stdin.readline().rstrip()

def travel(dots, current, visited, leng):
    max_len = len(dots)
    if(len(visited) == max_len):
        return leng

    mini = 9999999999
    for i in range(max_len):
        #모든 점을 다음 위치로 시도
        if i in visited:
            #이미 방문한 점인 경우 방문하면 안됨
            continue
        else:
            #방문 시도
            tmp = travel(dots, i, visited+[i], leng + dots[current][i])
            #최소 거리만 저장
            if mini > tmp:
                #현재 거리가 최소인 경우 
                mini = tmp
    return mini

#기저조건: 모든 점을 다 방문했을 경우
#알고싶은것 : 방문했을때 거리의 경우의 수

T = int(input())
for t in range(T):
    N = int(input())
    dots = []
    for n in range(N):
        dots.append(list(map(float, input().split())))
        #문자열.split() -> 스페이스바 기준 나눠진 배열
        #map(함수, 배열) -> 배열의 각 항목에 함수를 적용시킨 배열
        #list(...) -> map의 결과는 배열과 유사하지만 배열은 아님
    #pprint(dots)
    #dots[a][b] 의 의미는?
    #a에서 b까지의 거리
    li = []
    for i in range(len(dots)) :
        #모든 점에서 시작해본다.
        li.append(travel(dots, i , [i], 0))
    res = min(li)
    #min(배열) -> 배열 안의 값 중 가장 작은 값을 반환
    print("{:.2f}".format(res))
    pass