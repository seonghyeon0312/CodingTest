#백준 실버5 14916번 거스름돈
N=int(input())
change=dict()

for i in range((N//5),-1,-1):
  if i*5==N and i==(N//5):
    change[i]=i
  else:
    if (N-(i*5))%2==0:
      change[i]=i+(N-(i*5))//2
    else:
      change[i]=-1
result=list(change.values())
temp=min(result)

for x in result:
  if temp==-1:
    temp=x
  else:
    if temp>x and x!=-1:
      temp=x

print(temp)
