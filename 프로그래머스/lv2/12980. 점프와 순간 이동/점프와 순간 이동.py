def solution(n):
    answer = 0
    # 뒤로 갈수 없고 앞으로만 가기 때문에 dp로 풀지 않아도 된다
    # 슈트를 입은 사람이 N에 도착한 것을 반대로 한다고 생각하면 된다.. 
    while n > 0:
        if n % 2 == 0:
            n = n // 2
        else:
            answer += 1
            n -= 1 
    
    return answer