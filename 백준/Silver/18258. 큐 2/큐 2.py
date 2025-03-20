import sys
from collections import deque

input = sys.stdin.readline
N=int(input()) 

queue =deque([])

for i in range(N):
    queue.append(input().split())
    
result = deque()

while queue:
    order = queue.popleft()
    if order[0] == "push":
        result.append(order[1])
    elif order[0] == "front":
        print(result[0] if result else -1)
    elif order[0] == "back":
        print(result[-1] if result else -1)
    elif order[0]=="size":
        print(len(result))
    elif order[0] == "empty":
        print(0 if result else 1)
    elif order[0]=="pop":
        print(result.popleft() if result else -1) 