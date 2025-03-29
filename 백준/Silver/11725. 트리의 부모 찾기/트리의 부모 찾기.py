import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**6)

N = int(input())

graph = [[] for _ in range(N+1)]

for _ in range(N-1):
    s, e = map(int,input().split())

    graph[s].append(e)
    graph[e].append(s)

visited = [False] * (N+1)
result = [0] * (N+1)
result[1]=1

def dfs(visited, graph, result, root):
    # if len(graph[root])==1:
    #     return root

    for node in graph[root]:
        if not visited[node]:
            visited[node] = True
            tmp = dfs(visited, graph, result, node)
            result[tmp] = root
    return root

dfs(visited, graph, result,1)

for i in range(2,len(result)):
    print(result[i])