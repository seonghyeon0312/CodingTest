import math

N = int(input())

numbers = list(map(int, input().split()))
maxNum = max(numbers)
result = [True for i in range(maxNum+1)]

for i in range(2, int(math.sqrt(maxNum))+1):
    if result[i]:
        j=2
        while i*j <= maxNum:
            result[i*j] = False
            j+=1
result[0]=False
result[1]=False
count=0

for num in numbers:
    if result[num]:
        count+=1
    
print(count)