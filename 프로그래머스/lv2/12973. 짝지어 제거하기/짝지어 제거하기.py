def solution(s):
    answer = 0
    stack = []

    if len(s) == 1 or len(s) % 2 == 1:
        return answer
    
    for cur in s:

        if len(stack) == 0:
            stack.append(cur)
            continue

        pre = stack[-1]
        if pre == cur:
            stack.pop()
        else:
            stack.append(cur) 
    
    if len(stack) == 0:
        answer = 1
    return answer
