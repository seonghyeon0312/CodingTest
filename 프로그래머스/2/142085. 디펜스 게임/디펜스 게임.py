import heapq

def solution(n, k, enemy):
    max_heap = []
    
    for i in range(len(enemy)):
        heapq.heappush(max_heap, -enemy[i])  # 최대 힙처럼 사용 (음수로 저장)
        n -= enemy[i]
        
        if n < 0:
            if k == 0:
                return i
            # 가장 큰 적 수만큼 병사 회수하고 무적권 사용
            n += -heapq.heappop(max_heap)
            k -= 1
            
    return len(enemy)