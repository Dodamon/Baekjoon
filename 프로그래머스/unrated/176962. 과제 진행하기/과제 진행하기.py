def solution(plans):
    answer = []

    for i, plan in enumerate(plans):
        name, start, playtime = plan
        hh, mm = map(int, start.split(':'))
        times = []
        time = hh * 60 + mm
        plans[i] = [name, time, int(playtime)]
    plans.sort(key=lambda x: x[1])
    
    remains = []
    # stack에 남아있는 과제들을 저장한다
    for i, plan in enumerate(plans):

        name, start, playtime = plan
        if i == len(plans) - 1:
            next = 60000000
        else:
            next = plans[i+1][1]

        while True:
            if start + playtime <= next:
                answer.append(name)
                start += playtime
                if remains:
                    name, playtime = remains.pop()
                else:
                    break
            else:
                remains.append((name, playtime - (next - start)))
                break
                
    while remains:
        answer.append(remains.pop())

    return answer


print(solution(
    [["aaa", "12:00", "20"], ["bbb", "12:10", "30"], ["ccc", "12:40", "10"]]))
