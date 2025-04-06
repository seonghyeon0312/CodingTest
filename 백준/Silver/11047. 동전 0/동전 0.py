#백준 실버4 11047번 동전 0
N,K=list(map(int,input().split()))
coin=[int(input()) for _ in range(N)]
coin.sort(reverse=True)
cnt=0

for x in coin:
  if x<=K:
    cnt+=K//x
    K%=x
print(cnt)