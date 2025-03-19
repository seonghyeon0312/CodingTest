def blackJack(N,M,cards,visited,depth, point, maxPoint):
    if depth==3:
        return point

    for j in range(0, N):
        if cards[j]+point <= M and not visited[j]:
            visited[j] = True
            point += cards[j]
            maxPoint = max(maxPoint, blackJack(N, M, cards, visited, depth+1, point, maxPoint))
            point-=cards[j]
            visited[j]=False
    return maxPoint

N, M = map(int, input().split())
cards = list(map(int, input().split()))
visited = [False] * N
maxPoint = float("-inf")

maxPoint= blackJack(N,M,cards,visited,0, 0,maxPoint)

print(maxPoint)