import heapq

def solution(n, times):
    answer = 0
    
    mintime = min(times)
    maxtime = mintime * n
    
    while mintime + 1 < maxtime:
        midtime = (maxtime + mintime)//2 
        
        if sum([maxtime//t for t in times]) >= n:
            maxtime = midtime
        else:
            mintime = midtime

    answer = maxtime
    return answer