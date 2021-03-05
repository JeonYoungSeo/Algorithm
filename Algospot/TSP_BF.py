##모든 마을을 지나는 가장 짧은 거리 찾기

C = int(input()) #case 수

def shortest(visited, path, CurrentLengh) :
    short = 987654321.0
    
    for j in range(len(visited)) :
        path.append(j)
        visited[j] = 1
        short = min(shortestLength(visited, path, CurrentLengh),short)
        path.pop()
        visited[j] = 0

    return print(short)

def shortestLength(visited, path, CurrentLengh) : 

    ##기저조건 모든 마을을 다 돌았을 경우
    if len(path) == len(visited) :
        # return CurrentLengh + dist[path[-1]][0] 책에서 요구하는 정답
        return CurrentLengh

    ret = 987654321.0
    
    ##todo j뒤에서부터 탐색해도되지않을까 ? -> 모두 돌아야해
    ## 모든 경로 탐색하여 최소거리 찾기
    for i in range(len(dist)) :
        
        if visited[i] == 1 :
            continue
            
        here = path[len(path)-1]
        visited[i] = 1
        path.append(i)
        #print(path,'\n')
   
        short = shortestLength(visited, path, CurrentLengh+dist[here][i])
        
        #print(ret, short)
        ret = min(ret, short)
    
        path.pop()
        visited[i] = 0

    return ret
        


for c in range(C) :
    N = int(input()) 
    
    dist = [[0]*8 for i in range(N)]
    
    for i in range(N) :
        dist[i] = list(map(float, input().split()))

    path = [] ##지나온 경로
    CurrentLengh = 0##현재까지 거리
    visited = [0]*len(dist) ##방문 여부
    
    shortest(visited, path, CurrentLengh)
  
