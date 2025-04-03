from collections import deque
from pkgutil import resolve_name

N = int(input())

board = [[int(num) for num in input()] for _ in range(N)]
result = [[0 for _ in range(N)] for _ in range(N)]
visited = [[False for _ in range(N)] for _ in range(N)]
houseCount = list()

queue = deque()
houseNumber = 1
dx = [0,1,0,-1]
dy = [1,0,-1,0]

def bfs():
    count = 1
    while queue:
        x, y = queue.popleft()
        for i in range(4):
            nx, ny = x+dx[i], y+dy[i]

            if nx>=0 and nx<N and ny<N and ny>=0 and not visited[nx][ny]:
                visited[nx][ny]=True
                if board[nx][ny] == 1:
                    result[nx][ny] = houseNumber
                    queue.append([nx,ny])
                    count+=1

    return count
for i in range(N):
    for j in range(N):
        if not visited[i][j] and board[i][j] == 1:
            queue.append([i,j])
            visited[i][j]= True
            houseCount.append(bfs())
            houseNumber+=1
houseCount.sort()
print(len(houseCount))
for num in houseCount:
    print(num)
