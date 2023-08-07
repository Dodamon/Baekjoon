def solution(routes):
    routes.sort(key=lambda x: (x[1], x[0]))
    answer = 1
    cmp = routes[0][1]
    
    for i in range(1, len(routes)):
        start, end = routes[i]
        if start > cmp:
            answer += 1
            cmp = end
        
    return answer