N, K = map(int, input().split())

wifi = sorted([int(input()) for _ in range(N)])

start = 1
end = wifi[-1]-wifi[0]
result = 0

while start<=end:
    mid =( start+end )//2
    count = 1
    current = wifi[0]
    for i in range(1, len(wifi)):
        if wifi[i] >= current + mid:
            count+=1
            current=wifi[i]
        
    if count < K:
        end = mid -1
    else:
        result = mid
        start = mid+1
    
print(result)
        
            