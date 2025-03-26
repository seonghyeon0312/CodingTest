from collections import deque

class Snake:
    def __init__(self):
        self.que = deque()
        self.direction = 0
    
    def isContain(self,x,y) -> bool:
        for cord in self.que:
            if cord[0]==x and cord[1]==y:
                return False
        return True
    
N = int(input())
K = int(input())

board = [[0 for _ in range(N)]for _ in range(N)]

for _ in range(K):
    x, y=map(int,input().split())
    board[x-1][y-1] = 1

L=int(input())
turn = deque()
for _ in range(L):
    time, direct = input().split()
    turn.append([int(time),direct])
del time
del direct

length = 1
snake = Snake()
snake.que.append([0,0])

dx = [0,1,0,-1]
dy = [1,0,-1,0]
count = 1


while True:
    head = snake.que[-1]
    newX = head[0]+dx[snake.direction]
    newY = head[1]+dy[snake.direction]
    
    if newX< 0 or newX>=N or newY < 0 or newY>=N:
        break
    elif not snake.isContain(newX,newY):
        break
    elif board[newX][newY] == 1:
        snake.que.append([newX,newY])
        board[newX][newY]=0
    elif board[newX][newY]==0:
        snake.que.append([newX,newY])
        snake.que.popleft()
        
    if turn:    
        if count == turn[0][0]:
            if turn[0][1] == "D":
                snake.direction=(snake.direction+1)%4
            else:
                snake.direction=(snake.direction-1)%4
            turn.popleft()
    
    count+=1

print(count)  