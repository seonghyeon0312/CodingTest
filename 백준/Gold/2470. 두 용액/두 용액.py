N=int(input())

liquid = sorted(list(map(int,input().split())))
pl, pr = 0, N-1
minDiff = float('inf')
result = list()
while pl<pr:
    liquidSum = (liquid[pl]+liquid[pr])
    if liquidSum == 0:
        if result:
            result.pop() 
        result.append([liquid[pl], liquid[pr]])
        break
    elif abs(liquidSum) < abs(minDiff):
        minDiff = liquidSum
        if result:
            result.pop()
        result.append([liquid[pl],liquid[pr]])
        if liquidSum < 0:
            pl+=1
        elif liquidSum > 0:
            pr-=1
    elif abs(liquidSum) >= abs(minDiff):
        if liquidSum < 0:
            pl+=1
        elif liquidSum > 0:
            pr-=1
        

print(result[0][0], result[0][1])