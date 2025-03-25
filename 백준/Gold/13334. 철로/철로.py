import heapq
import sys
input = sys.stdin.readline

N = int(input())
segments = []

for _ in range(N):
    a, b = map(int, input().split())
    if a > b:
        a, b = b, a
    segments.append((a, b))

d = int(input())

# 끝점 기준으로 정렬
segments.sort(key=lambda x: x[1])

heap = []
max_count = 0

for start, end in segments:
    # 현재 선로의 범위 밖에 있는 선분 제거
    while heap and heap[0] < end - d:
        heapq.heappop(heap)
    
    if start >= end - d:
        heapq.heappush(heap, start)
    
    max_count = max(max_count, len(heap))

print(max_count)