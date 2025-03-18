def DFS(depth, height, visited, board, N, count):
    if depth == N:
        return count
    for col in range(N):
        if board[depth][col] > height and not visited[depth][col]:
            BFS(depth, col, visited, board, N, height)
            count+=1

    count = DFS(depth+1,height, visited, board, N, count)
    return count

def BFS(row, col, visited, board, N, height):
    dx = [0, 1, 0, -1]
    dy = [1, 0, -1, 0]
    queue = list()
    queue.append([row,col])
    while len(queue) > 0:
        pop = queue.pop(0)

        for i in range(4):
            newX= pop[0]+dx[i]
            newY = pop[1]+dy[i]

            if newX>=0 and newX<N and newY<N and newY >= 0:
                if not visited[newX][newY] and board[newX][newY] > height:
                    visited[newX][newY] = True
                    queue.append([newX,newY])


N = int(input())
board = list()
maxHeight = 101
for _ in range(N):
    row = list(map(int, input().split()))
    maxHeight= max(max(row),maxHeight)
    board.append(row)

count = 0
maxArea = -1

for i in range(0,maxHeight+1):
    visited = [[False for _ in range(N)] for _ in range(N)]
    maxArea = max(DFS(0, i, visited, board, N, 0),maxArea)

print(maxArea)