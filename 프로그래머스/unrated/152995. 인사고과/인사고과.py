def solution(scores):
    answer = 0
    count = 0
    total = 0
    grade = 1

    y, x = sorted(scores, key=lambda x: (x[0]+1) * (x[1]+1), reverse=True)[0]
    scores[:] = sorted(list(zip(scores, [i for i in range(len(scores))])), key=lambda x: x[0][0] + x[0][1], reverse=True)

    for score in scores:
        (ny, nx), ni = score

        if ny < y and nx < x:
            if ni == 0:
                answer = -1
        else:
            if ny + nx == total:
                count += 1
            else:
                grade += count
                total = ny + nx
                count = 1

        if ni == 0:
            break

    if answer != -1:
        answer = grade

    return answer