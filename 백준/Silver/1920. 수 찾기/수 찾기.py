import sys
input=sys.stdin.readline

N=int(input())
n_list=input().split()
n_hash={}
for i in range(N):
  if n_list[i] not in n_hash:
    n_hash[n_list[i]]=1
M=int(input())
m_list=input().split()

for i in range(M):
  if m_list[i] in n_hash:
    print(1)
  else:
    print(0)