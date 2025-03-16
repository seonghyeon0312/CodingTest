height = list()
height2 = list()
sum = 0
for _ in range(9):
    temp= int(input())
    sum+=temp
    height.append(temp)
    height2.append(temp)

height.sort()
height2.sort()
target = sum-100
check = False
for i in range(9):
    for j in range(9):
        if i==j:
            continue
        if height[i]+height2[j] == target:
            idx1 = max(i, j)
            idx2 = min(i,j)
            del height[idx1], height[idx2]
            check =True
            break
    if check:
        break

for tall in height:
    print(tall)