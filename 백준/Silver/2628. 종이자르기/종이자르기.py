x, y= list(map(int,input().split()))

test = int(input())
row = [0]
col = [0]

for i in range(0,test):
    direction, cutCord = list(map(int,input().split()))
    if direction == 0:
        if cutCord != y or cutCord!=0:
            row.append(cutCord)
    else:
        if cutCord != x or cutCord!=0:
            col.append(cutCord)    
        
row = list(set(row))
col = list(set(col))

row.append(y)
col.append(x)
        
row.sort()
col.sort()

maxRow, maxCol = 0,0

for i in range(1,len(row)):
    excreta = row[i]-row[i-1]
    if maxRow < excreta:
        maxRow= excreta
        
for i in range(1,len(col)):
    excreta = col[i]-col[i-1]
    if maxCol < excreta:
        maxCol = excreta
print(maxRow*maxCol)