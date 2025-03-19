def queen(row,col,diag1,diag2,count,N):
    if row == N:
        count+=1
        return count
    
    for i in range(N):
        if not col[i] and not diag1[row+i] and not diag2[row-i+(N-1)] :
            col[i] = diag1[row+i] = diag2[row-i+(N-1)] = True
            count = queen(row+1,col,diag1,diag2,count,N)
            col[i] = diag1[row+i] = diag2[row-i+(N-1)] = False
    return count


N=int(input())

count=0
col=[False] * N
diag1 = [False] * (2*N-1)
diag2 = [False] * (2*N-1)

count = queen(0,col,diag1,diag2,count,N)

print(count)