C = int(input())


def fencerecur(fence, left, right) :
    #기저조건 
    if left == right :
        return fence[left]

    mid = (left + right)//2

    ret = max(fencerecur(fence, left, mid),fencerecur(fence, mid + 1, right))

    #겹치는 부분이 크니 ? 

    mid_left  = mid
    mid_right = mid + 1
    area = (mid_right - mid_left + 1 ) * min(fence[mid_left], fence[mid_right])
    
    ret = max(ret, area)
    
    while (mid_left >= left) & (mid_right <= right) : #범위안에잇어야
        #왼쪽이 더 크거나, 오른쪽 끝에 도달했다
        if (mid_left > left) and (mid_right == right or fence[mid_left-1] > fence[mid_right+1])  :
            mid_left -= 1 
            height = min(fence[mid_left:mid_right+1])
        else : 
            mid_right += 1 
            height = min(fence[mid_left:mid_right+1])
        area = (mid_right - mid_left + 1 ) * height
        
        ret = max(ret, area)
        
        

        #그 반대 
     

    return ret


for i in range(C) :
    N = int(input())
    height = list(map(int,input().split()))

    print(fencerecur(height,0,N-1))


