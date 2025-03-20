N = int(input())  
num = N
depth = 0  

while True:
    if num < 10:
        num = num * 10 + num  
    else:
        sumN = (num // 10) + (num % 10)  
        num = (num % 10) * 10 + (sumN % 10)  
    depth += 1

    if num == N:
        break

print(depth)