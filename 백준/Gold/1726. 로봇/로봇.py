# from collections import deque
#
# m,n = map(int, input().split())
#
# board = [list(map(int,input().split())) for _ in range(m)]
# visited = [[[False]*4 for _ in range(n)] for _ in range(m)]
#
# nowX, nowY, nowD = map(int,input().split())
# nowX-=1
# nowY-=1
# nowD -= 1
# goalX, goalY, goalD = map(int,input().split())
# goalX-=1
# goalY-=1
# goalD -=1
# goal = m*n+1
#
# direction = [[0,1],[0,-1],[1,0],[-1,0]]
#
# queue = deque()
# visited[nowX][nowY][nowD] = True
# queue.append([nowX,nowY,nowD,0])
#
# def bfs():
#     while queue:
#         x,y,d, cost = queue.popleft()
#         if x==goalX and y==goalY and d==goalD:
#             print(cost)
#             return
#
#         for i in range(1, 4):
#             nx = x+(direction[d][0] * i)
#             ny = y+(direction[d][1] * i)
#
#             if 0 <= nx < m and 0 <= ny < n:
#                 if visited[nx][ny][d] and board[nx][ny] == 1:
#                     continue
#                 visited[nx][ny][d] = True
#                 queue.append([nx,ny,d,cost+1])
#             else:
#                 break
#
#         for i in range(4):
#             nx = x+direction[i][0]
#             ny = y+direction[i][1]
#
#             if 0 <= nx < m and 0 <= ny < n and board[nx][ny]==0:
#                 if visited[nx][ny][i]:
#                     continue
#
#                 diff = abs(d - i)  # i가 새 방향 인덱스(0~3)일 때
#                 if diff == 1:
#                     turn = 1
#                 elif diff == 2:
#                     turn = 2
#                 else:
#                     turn = 0
#                 visited[nx][ny][i] = True
#                 queue.append([nx,ny,d,cost+turn])
# bfs()

from collections import deque
import sys
input = sys.stdin.readline

m, n = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(m)]
visited = [[[False]*4 for _ in range(n)] for _ in range(m)]

nowX, nowY, nowD = map(int, input().split())
nowX -= 1; nowY -= 1
goalX, goalY, goalD = map(int, input().split())
goalX -= 1; goalY -= 1

map_dir = {1:0, 2:2, 3:1, 4:3}
nowD  = map_dir[nowD]
goalD = map_dir[goalD]
direction = [[0,1],[1,0],[0,-1],[-1,0]]

queue = deque()
visited[nowX][nowY][nowD] = True
queue.append([nowX, nowY, nowD, 0])

def bfs():
    while queue:
        x, y, d, cost = queue.popleft()
        # 목표 도착
        if x == goalX and y == goalY and d == goalD:
            print(cost)
            return

        for k in range(1,4):
            nx = x + direction[d][0] * k
            ny = y + direction[d][1] * k
            if not (0 <= nx < m and 0 <= ny < n) or board[nx][ny] == 1:
                break
            if not visited[nx][ny][d]:
                visited[nx][ny][d] = True
                queue.append([nx, ny, d, cost + 1])

        for nd in ((d + 3) % 4, (d + 1) % 4):
            if not visited[x][y][nd]:
                visited[x][y][nd] = True
                queue.append([x, y, nd, cost + 1])
bfs()