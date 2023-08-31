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
        
        # result : 지금 이 버스를 탈수 있는 제일 느린시간을 의미한다
        # 지금 도착한 busTime 보다 빨리온 크루들을 waiting Queue에 넣는다
        while timetable and timetable[0] <= busTime:
            waitingQueue.append(timetable.popleft())
        
        # 만약 waiting Queue의 길이가 bus에 탈수 있는 길이보다 많거나 같을 경우
        # result는 마지막 탄사람의 시간보다 -1이 되어야 이 버스를 탈 수 있다
        if len(waitingQueue) >= m:
            temp = 0
            for _ in range(m):
                temp = waitingQueue.popleft()
            result = temp - 1
        # waiting Queue의 길이가 bus에 탈수 있는 길이 보다 작을 경우
        # result는 버스가 도착한 시간이다
        else:
            while waitingQueue:
                waitingQueue.popleft()
            result = busTime
            
        n -= 1
        busTime += t
        
    answer = str(result//60).zfill(2) + ":" + str(result%60).zfill(2)
        
    return answer