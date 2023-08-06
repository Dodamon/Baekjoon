import heapq

def solution(n, works):
    answer = 0
    total = sum(works)
    pq = []
    
    if total <= n:
        return answer
    if total - len(works) == n:
        return len(works)
    
    # 우선 순위 큐에 넣어서 작업량이 많은 순으로 작업을 pop한다.
    # 작업에서 1씩 뺀다음 다시 우선순위 큐에 넣는다.
    # 시간 복잡도 nlogn
    
    for work in works:
        heapq.heappush(pq, work*-1)
        
    while n > 0:
        work = heapq.heappop(pq)
        heapq.heappush(pq, work+1)
        n -= 1
    
    for work in pq:
        answer += work**2
        
    return answer