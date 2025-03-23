import heapq
import sys
input = sys.stdin.readline

N = int(input())

minHeap = []
maxHeap = []


for i in range(N):
    num = int(input())
    if i%2==0:
        heapq.heappush(maxHeap,num*-1)
        if len(maxHeap) - len(minHeap) > 1:
            top = heapq.heappop(maxHeap)
            heapq.heappush(minHeap, top)
        if minHeap and maxHeap:
            if minHeap[0]<=(maxHeap[0]*-1):
                top = heapq.heappop(maxHeap)
                replace = heapq.heapreplace(minHeap, top*-1)
                heapq.heappush(maxHeap, replace*-1)
        print(maxHeap[0]*-1)
        
    else:
        heapq.heappush(minHeap, num)
        if len(minHeap) - len(maxHeap) > 1:
            top = heapq.heappop(minHeap)
            heapq.heappush(maxHeap, top)
        if minHeap and maxHeap:
            if minHeap[0]<=(maxHeap[0]*-1):
                top = heapq.heappop(minHeap)
                replace = heapq.heapreplace(maxHeap, top*-1)
                heapq.heappush(minHeap,replace*-1)
        print(maxHeap[0]*-1)
    