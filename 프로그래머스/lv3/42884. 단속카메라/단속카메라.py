def solution(routes):
    routes.sort(key=lambda x: (x[1], x[0]))
    answer = 1
    cmp = routes[0][1]
    
    # 차량의 진출 시점을 기준으로 정렬을 한다
    # 현재 차량의 진입 시점이 앞의 차량의 진출 시점보다 작다면 겹치는 구간이 생기기 때문에
    # 하나의 단속카메라만을 둘수 있다
    for i in range(1, len(routes)):
        start, end = routes[i]
        if start > cmp:
            answer += 1
            cmp = end
        
    return answer