def solution(plans):
    plans = sorted(map(lambda x: [x[0], int(x[1][:2]) * 60 + int(x[1][3:]), int(x[2])], plans), key=lambda x: x[1])
    # 계획을 시간순이 작은 순서로 정렬한다
    
    remains = []
    for plan in plans:
        name, start, playtime = plan
        
        for i, remain in enumerate(remains):
            # 남아있는 과제중 end이 현재 과제의 start 보다 크다면
            # 남아있는 과제의 end시간이 현재 과제의 playtime 만큼 커진다
            if remain[0] > start:
                remains[i][0] += playtime
                
        # 남아있는 과제에 과제가 끝나는 시간과 과제 이름을 저장한다
        remains.append([start + playtime, name])
    remains.sort()
    # 과제들의 끝나는 시간순으로 정렬하면
    # 먼저 끝나는 시간이 가장 앞으로 오게된다.

    return list(map(lambda x: x[1], remains))

print(solution(
    [["aaa", "12:00", "20"], ["bbb", "12:10", "30"], ["ccc", "12:40", "10"]]))
