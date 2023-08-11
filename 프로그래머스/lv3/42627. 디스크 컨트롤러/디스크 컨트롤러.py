import heapq

def solution(jobs):
    answer = 0
    n = len(jobs)
    for i, job in enumerate(jobs):
        start, time = job
        jobs[i] = (start, start+time, 0)
        answer += time
        
    heapq.heapify(jobs)
    cur = -1
    while jobs:
        start, end, wait = heapq.heappop(jobs)
        while cur > start:
            heapq.heappush(jobs, (cur, end + (cur - start), wait + (cur - start)))
            start, end, wait = heapq.heappop(jobs)
        
        cur = end
        answer += wait
    
    
    return answer // n