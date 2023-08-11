import heapq

def solution(jobs):
    answer = 0
    n = len(jobs)
    for i, job in enumerate(jobs):
        start, time = job
        # (start, end, wait) 을 값으로 넣는다
        # 처음에 대기하는 시간은 다 0으로 넣어준다
        jobs[i] = (start, start+time, 0)
        answer += time
    
    # 우선순위 큐로 만든다
    # 1순위 : 시작시간 , 2순위: 끝나는 시간 
    heapq.heapify(jobs)
    cur = -1
    while jobs:
        start, end, wait = heapq.heappop(jobs)
        # 우선순위 가장 top에 있는 작업의 시작시간이 현재 시간보다 작을경우
        # 갱신해서 다시 넣어 준다
        while cur > start:
            heapq.heappush(jobs, (cur, end + (cur - start), wait + (cur - start)))
            start, end, wait = heapq.heappop(jobs)
        
        cur = end
        answer += wait
    
    return answer // n