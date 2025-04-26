from collections import deque

m, n = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(m)]
nowX, nowY, nowD = map(int, input().split())
goalX, goalY, goalD = map(int, input().split())

# 방향 매핑: 동(1), 서(2), 남(3), 북(4) -> 0, 1, 2, 3
dir_map = {1: 0, 2: 1, 3: 2, 4: 3}
dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]

nowX -= 1
nowY -= 1
goalX -= 1
goalY -= 1
nowD = dir_map[nowD]
goalD = dir_map[goalD]

visited = [[[False]*4 for _ in range(n)] for _ in range(m)]
queue = deque()
queue.append((nowX, nowY, nowD, 0))
visited[nowX][nowY][nowD] = True

while queue:
    x, y, d, cnt = queue.popleft()
    if (x, y, d) == (goalX, goalY, goalD):
        print(cnt)
        break

    for k in range(1, 4):
        nx = x + dx[d]*k
        ny = y + dy[d]*k
        if 0 <= nx < m and 0 <= ny < n and board[nx][ny] == 0:
            if not visited[nx][ny][d]:
                visited[nx][ny][d] = True
                queue.append((nx, ny, d, cnt+1))
        else:
            break

    for nd in range(4):
        if nd != d and not visited[x][y][nd]:
            # 방향 전환 비용 계산
            if (d == 0 and nd == 1) or (d == 1 and nd == 0) or (d == 2 and nd == 3) or (d == 3 and nd == 2):
                turn_cost = 2  # 180도 회전
            else:
                turn_cost = 1  # 90도 회전
            visited[x][y][nd] = True
            queue.append((x, y, nd, cnt + turn_cost))