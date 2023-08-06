def solution(n, s):
    answer = []
    
    # n이 s보다 크면 제일 작은 1로도 s을 만들 수 없기 때문에 바로 출력한다
    if n > s:
        answer = [-1]
        return answer
    
    # 최대의 곱은 모든수가 골고루 클때 발생한다
    div, mod = s//n, s%n
    
    for i in range(n):
        if i >= n - mod:
            answer.append(div + 1)
        else:
            answer.append(div)
    
    return answer