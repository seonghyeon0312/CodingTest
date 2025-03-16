import sys
input=sys.stdin.readline
print=sys.stdout.write

N= int(input())
count = [0]*10001

for _ in range(N):
    count[int(input())]+=1

for i in range(1,10001):
    if count[i] == 0:
        continue
    else:
        for j in range(count[i]):
            print(f"{i}\n")