C = int(input())

### ㄴ블럭의 정보
coverType =[[[0,0], [1,0], [0,1]],
     [[0,0], [0,1], [1,1]],
     [[0,0], [1,0],[1,1]],
     [[0,0], [1,0], [1,-1]]
     ]

def set(board, y, x, Type, delta) :
    # 덮을 수 있는지 없는지
    able = True

    for i in range(3) :
        ny = y + coverType[Type][i][0]
        nx = x + coverType[Type][i][1]
        
        if ny < 0 or ny >= len(board) or nx < 0 or nx >= len(board[0]) :
            able = False
        else :
            board[ny][nx] += delta
            if board[ny][nx] > 1 :
                able = False

    return able      

        

def cover(board) :
    
    y = x = -1
    
    ##가장 첫 0 찾기
    for i in range(len(board)) :
        for j in range(len(board[1])) :
            if board[i][j] == 0 :
                y = i
                x = j
                break
        if y != -1 :
            break
    ##꽉채웟으면 1 반환
    if y == -1 :
        return 1

    ret = 0

    for k in range(4) :
        if set(board, y, x, k, 1) :
            """for i in range(len(board)) :
                print(board[i])
            print()"""
            ret += cover(board)
        set(board, y, x, k, -1)

    return ret

for c in range(C) :
    H, W = map(int, input().split())

    board = [[] for i in range(H)]

    for h in range(len(board)) :
        board[h] = list(input())

  
    
    #들어갈수 있는 지 판단하기 위해 1,0으로 치환
    for h in range(len(board)) :
        for w in range(len(board[0])) :
            if board[h][w] == '#' :
                board[h][w] = 1
            else :
                board[h][w] = 0 

    ###만들어진 보드의 모양 
    #for i in range(H) :
     #   print(board[i])

    if sum(x.count(0) for x in board) % 3 != 0 :
        print(0)
        continue
    else :
        print(cover(board))

    
    
