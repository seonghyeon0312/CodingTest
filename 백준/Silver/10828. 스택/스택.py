import sys
input=sys.stdin.readline
N=int(input())
queue=[]
for _ in range(0, N):
  order=input().split()
  if order[0]=="push":
    queue.append(int(order[1]))
  elif order[0]=="empty":
    if len(queue)>=1:
      print(0)
    else:
      print(1)
  elif order[0]=="size":
    print(len(queue))
  elif order[0]=="pop":
    if len(queue)>=1:
      print(queue.pop())
    else:
      print(-1)
  elif order[0]=="top":
    if len(queue)>=1:
      print(queue[-1])
    else:
      print(-1)
