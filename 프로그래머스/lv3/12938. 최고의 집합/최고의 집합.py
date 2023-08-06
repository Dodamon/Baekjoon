def solution(n, s):
    answer = []
    
    # n이 s보다 크면 제일 작은 1로도 s을 만들 수 없기 때문에 바로 출력한다
    if n > s:
        answer = [-1]
        return answer
    
    div, mod = s//n, s%n
    
    answer = [div for _ in range(n)]
    
    index = n - 1
    while mod > 0:
        answer[index] += 1
        index -= 1
        mod -= 1
    
    return answer