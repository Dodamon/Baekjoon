import heapq

def solution(n, works):
    answer = 0
    total = sum(works)
    pq = []
    
    if total <= n:
        return answer
    if total - len(works) == n:
        return len(works)
    
    for work in works:
        heapq.heappush(pq, work*-1)
        
    while n > 0:
        work = heapq.heappop(pq)
        heapq.heappush(pq, work+1)
        n -= 1
    
    for work in pq:
        answer += work**2
        
    return answer