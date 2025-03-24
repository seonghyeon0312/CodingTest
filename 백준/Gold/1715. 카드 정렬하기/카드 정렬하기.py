#백준 골드4 1715번 카드 정렬하기
import heapq

N=int(input())
card=[]

for _ in range(N):
  heapq.heappush(card,int(input()))
Sum=0
while len(card) >1:
  num1=heapq.heappop(card)
  num2=heapq.heappop(card)
  Sum+=num1+num2
  heapq.heappush(card,num1+num2)
print(Sum)
