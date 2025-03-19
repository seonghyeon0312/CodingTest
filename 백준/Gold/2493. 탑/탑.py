import sys
input=sys.stdin.readline
print = sys.stdout.write

N = int(input())

heights = list(map(int,input().split()))
    
result = [0]*N
stack = list()

for i in range(N):
    while stack and stack[-1][1] < heights[i]:
        stack.pop()
        
    if stack:
        result[i]=stack[-1][0]+1
        
    stack.append([i,heights[i]])

for receive in result:
    print(f"{receive} ")
