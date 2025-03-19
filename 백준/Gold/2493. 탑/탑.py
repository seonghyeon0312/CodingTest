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
    
print(" ".join(map(str,result)) + "\n")