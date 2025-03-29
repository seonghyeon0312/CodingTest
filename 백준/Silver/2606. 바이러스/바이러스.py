from collections import deque

N = int(input())
M = int(input())

vertex = [[] for _ in range(N+1)]

for _ in range(M):
    s, e = map(int,input().split())
    vertex[s].append(e)
    vertex[e].append(s)
visited = [False] * (N+1)
count =0


def DFS(vertex, count, visited):
    stack = deque()
    stack.append(1)

    while stack:
        node = stack.pop()
        for next in vertex[node]:
            if not visited[next]:
                visited[next] = True
                count += 1
                stack.append(next)
    return count
count = DFS(vertex, count, visited) 
if count != 0:
    print(count-1)
else:
    print(0)