maxSum = 0
def brute_force(depth, before, maxSum, sum, visited, num,N):
    for i in range(N):
        if not visited[i]:
            visited[i] = True
            sum += abs(before - num[i])
            if depth == N-1:
                maxSum=max(maxSum,sum)
                visited[i]=False
                break
            maxSum = brute_force(depth+1, num[i], maxSum, sum, visited,num,N)
            sum -= abs(before-num[i])
            visited[i]=False

    return maxSum

N = int(input())
num = list(map(int, input().split()))
visited = [False for _ in range(N)]
sum = 0
for idx in range(N):
    visited[idx]=True
    maxSum = brute_force(1, num[idx], maxSum, sum, visited, num, N)
    visited[idx]=False

print(maxSum)