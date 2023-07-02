def solution(targets):
    targets.sort(key = lambda x:x[1])
    answer = 0
    last = -1
    
    for target in targets:
        s, e = target
        
        if last == -1 or s >= last:
            last = e
            answer += 1    
            
    return answer