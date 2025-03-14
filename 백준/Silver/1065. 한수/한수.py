def count(N):
  cnt=99
  for i in range(100,N+1):
    i=str(i)
    temp1=int(i[1])-int(i[0])
    temp2=int(i[2])-int(i[1])
    if temp1==temp2:
      cnt+=1
  return cnt

N=int(input())
if N < 100:
  print(N)
elif N>=100 and N<1000:
  print(count(N))
else:
  print(count(999))