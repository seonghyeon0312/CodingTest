cord = list(map(int, input().split()))
minX = min((cord[0]-0),(cord[2]-cord[0]))
minY = min((cord[1]-0),(cord[3]-cord[1]))
print(min(minX,minY))
