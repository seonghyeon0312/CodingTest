from collections import deque

dx = [0,1,0,-1]
dy = [1,0,-1,0]

def solution(maps):
    answer = 0
    queue = deque()
    n,m=len(maps), len(maps[0])
    
    visited = [[False for _ in range(m)] for _ in range(n)]
    visited[0][0] = True
    queue.append([0,0])
    
    while queue:
        x,y = queue.popleft()
        
        for i in range(4):
            nx, ny= x+dx[i], y+dy[i]
            
            if 0<=nx<n and 0<=ny<m and not visited[nx][ny] and maps[nx][ny] != 0:
                visited[nx][ny] = True
                maps[nx][ny] = maps[x][y] +1
                queue.append([nx,ny])
            if nx == n-1 and ny == m-1:
                return maps[nx][ny]
    
    return -1
    