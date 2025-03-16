
height = list()

sum = 0
for _ in range(9):
    temp= int(input())
    sum+=temp
    height.append(temp)

height.sort()
height_set = set(height)
target = sum-100

for h in height:
    target_h = target - h
    if target_h in height_set and target_h !=h:
        height.remove(target_h)
        height.remove(h)
        break

for tall in height:
    print(tall)