def TSP(N,depth,result,minResult, start, first):
    if depth == N-1:
        if W[start][first] == 0:
            return minResult
        result+=W[start][first]
        minResult = min(minResult,result)
        return minResult

    for i in range(N):
        if not col[i] and W[start][i] !=0:
            col[i] = True
            result += W[start][i]
            minResult = TSP(N,depth+1,result,minResult, i, first)
            result-=W[start][i]
            col[i]=False
    return minResult

N=int(input())

W = [list(map(int,input().split())) for _ in range(N)]
row = [False for _ in range(N)]
col = [False for _ in range(N)]

result=0
minResult=float('inf')
for i in range(N):
    col[i]=True
    minResult= TSP(N,0,result,minResult,i,i)
    col[i]=False

print(minResult)