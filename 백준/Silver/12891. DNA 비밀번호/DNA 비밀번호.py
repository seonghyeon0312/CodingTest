s,p=list(map(int,input().split()))
string=input().strip()
private=(string[0:p])
count=list(map(int,input().split()))
time={'A':count[0],'C':count[1],'G':count[2],'T':count[3]}
now={'A':private.count('A'),'C':private.count('C'),'G':private.count('G'),'T':private.count('T')}
start=0
cnt=0
for end in range(p-1,s):
  if now['A']>= time['A'] and now['C']>= time['C'] and now['G']>= time['G'] and now['T']>= time['T']:
    cnt+=1
  if end==s-1:
    break
  now[string[start]]-=1
  now[string[end+1]]+=1
  start+=1
print(cnt)