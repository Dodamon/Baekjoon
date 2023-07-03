def solution(order):
    stack = []
    cnt = 0
    for i in range(1, len(order)+1):
        stack.append(i)
        while stack and stack[-1] == order[cnt]:
            cnt += 1
            stack.pop()
            
    return cnt