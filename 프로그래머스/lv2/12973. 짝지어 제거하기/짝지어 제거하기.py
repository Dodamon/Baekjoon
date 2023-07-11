def solution(s):
    answer = 0
    stack = []
    
    # 문자길이가 1이거나 짝수가 아닐때는 짝을 지어 제거할수 없기 때문에 바로 출력한다
    if len(s) == 1 or len(s) % 2 == 1:
        return answer
    
    # 문자열을 하나씩 돌면서
    # 스텍의 top과 같으면 스텍에서 pop 한다
    # 스텍의 top과 다르면 스텍에 push 한다
    for cur in s:
        if len(stack) == 0:
            stack.append(cur)
            continue

        pre = stack[-1]
        if pre == cur:
            stack.pop()
        else:
            stack.append(cur) 
    
    # 스텍이 비어있다는 것은 모든 문자열을 제거했다는 뜻이다 
    if len(stack) == 0:
        answer = 1
    return answer
