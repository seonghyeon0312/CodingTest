import sys
input=sys.stdin.readline

T=int(input())
N=[int(input().strip()) for _ in range(T)]
num_list=[1,2,4]
for i in range(3,10):
  new=num_list[i-1]+num_list[i-2]+num_list[i-3]
  num_list.append(new)

for x in N:
  print(num_list[x-1])