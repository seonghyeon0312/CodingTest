
import heapq


N,K= map(int,input().split())

queue =list()

board = [list(map(int,input().split())) for _ in range(N)]
visited = [[False for _ in range(N)] for _ in range(N)]

for row in range(N):
    for col in range(N):
        if board[row][col]>0:
            heapq.heappush(queue,[board[row][col],row,col])
            visited[row][col] = True

s,x,y = map(int,input().split())

def bfs():
    dx = [0,1,0,-1]
    dy = [1,0,-1,0]
    time =0
    while queue and time < s:
        tmpQueue = list()
        size = len(queue)
        for _ in range(size):
            P, X, Y = heapq.heappop(queue)
            for i in range(4):
                nx, ny = X+dx[i], Y+dy[i]
                if nx>=0 and nx<N and ny>=0 and ny<N and not visited[nx][ny]:
                    visited[nx][ny] = True
                    board[nx][ny] = P
                    tmpQueue.append([P,nx,ny])
        queue.clear()
        queue.extend(tmpQueue)
        heapq.heapify(queue)
        time+=1

bfs()

print(board[x-1][y-1])