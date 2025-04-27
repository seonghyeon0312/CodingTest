import sys
sys.setrecursionlimit(10**6)
input = sys.stdin.readline

n,p = map(int, input().split())
now= [0]+(list(map(int,input().split())))
goal =  [0] + (list(map(int,input().split())))

graph = [[] for _ in range(n+1)]

for _ in range(n-1):
    u,v= map(int,input().split())
    graph[u].append(v)
    graph[v].append(u)


visited = [False for _ in range(n+1)]
visited[0]=True

current = [0 for _ in range(n+1)]

def dfs(node):
    current[node] = goal[node]-now[node]
    for neighbor in graph[node]:
        if visited[neighbor]:
            continue
        visited[neighbor] = True
        dfs(neighbor)
        if current[neighbor] > 0:
            current[node]+=current[neighbor]

visited[p]=True
dfs(p)
print(current[p])
