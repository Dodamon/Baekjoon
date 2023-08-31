from collections import deque

def solution(n, t, m, timetable):
    answer = ''
    
    for i, time in enumerate(timetable):
        HH, MM = time.split(":")
        HH, MM = int(HH), int(MM)
        TT = HH * 60 + MM
        timetable[i] = TT
    
    result = 0
    timetable.sort()
    timetable = deque(timetable)
    busTime = 9 * 60
    endTime = 24 * 60
    waitingQueue = deque()
    
    while n > 0 and busTime < endTime:

        while timetable and timetable[0] <= busTime:
            waitingQueue.append(timetable.popleft())
            
        if len(waitingQueue) >= m:
            temp = 0
            for _ in range(m):
                temp = waitingQueue.popleft()
            result = temp - 1
        else:
            while waitingQueue:
                waitingQueue.popleft()
            result = busTime
            
        n -= 1
        busTime += t
        
    answer = str(result//60).zfill(2) + ":" + str(result%60).zfill(2)
        
    return answer