###QuadTree
C = int(input())

def quadtree_recur(qtree) :
    global occur
    ##기저 조건 : w,b를 만났을때 
    if qtree[occur]== 'w' or qtree[occur] == 'b' :
        return qtree[occur]
    
    occur += 1
    left_upper = quadtree_recur(qtree)
    occur += 1
    right_upper = quadtree_recur(qtree)
    occur += 1
    left_bottom = quadtree_recur(qtree)
    occur += 1
    right_bottom = quadtree_recur(qtree)

    return "x" + left_bottom + right_bottom + left_upper + right_upper 
    


for _ in range(C) :
    qtree = input()
    occur = 0
    print(quadtree_recur(qtree))
