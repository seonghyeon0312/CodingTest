import sys
input=sys.stdin.readline
sys.setrecursionlimit(10**6)
def dfs(node, hi, graph):
  if hi[node]:
    return
  hi[node]=True
  for x in graph[node]:
    if hi[x]==False:
      dfs(x, hi, graph)

V,E=list(map(int,input().split()))
graph=[[] for _ in range(V+1)] #인접 리스트
for i in range(E):
  start,end=list(map(int,input().split()))
  graph[start].append(end)
  graph[end].append(start)

#방문 여부 저장 리스트
hi=[False for i in range(V+1)]

#연결 요소 개수
cnt=0

for i in range(1,V+1):
  if not hi[i]:
    cnt+=1
    dfs(i,hi,graph)

print(cnt)