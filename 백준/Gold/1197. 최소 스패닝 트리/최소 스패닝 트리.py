import sys
sys.setrecursionlimit(10**6)
input = sys.stdin.readline
V,E = map(int,input().split())
parents = [i for i in range(V+1)]

def find(start):
    global parents
    if parents[start]==start:
        return start
    else:
        parents[start] = find(parents[start])
        return parents[start]

def union(start, end):
    global parents
    start = find(start)
    end = find(end)

    if start != end:
        parents[end] = start

edge = list()
for _ in range(E):
    edge.append(list(map(int,input().split())))

edge = sorted(edge, key= lambda x: x[2])

total = 0
count =0
for i in range(E):
    start, end, weight = edge[i]
    if find(start) != find(end):
        union(start,end)
        total+=weight
        count+=1

    if count==V-1:
        break

print(total)