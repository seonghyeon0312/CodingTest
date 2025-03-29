import sys
sys.setrecursionlimit(10**6)
input =sys.stdin.readline

def dfs(visited, node, graph):
    if visited[node]:
        return
    else:
        visited[node] = True
        for x in graph[node]:
            if not visited[x]:
                dfs(visited,x,graph)


v, e = map(int,input().split())

graph = [[] for _ in range(v+1)]
for i in range(e):
    start, end = map(int,input().split())
    graph[start].append(end)
    graph[end].append(start)

visited = [False for _ in range(v+1)]

count =0

for i in range(1,v+1):
    if not visited[i]:
        dfs(visited, i, graph)
        count+=1

print(count)
