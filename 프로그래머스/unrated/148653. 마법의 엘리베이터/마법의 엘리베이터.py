import sys

# 2^9 = 516가지의 경우의 수를 가진다
# 부분집합..? 재귀
def solution(storey):
    answer = 0
    # 나올수 있는 최솟값중 하나 이다. (모든 자리수의 합)
    # total이 최솟값이 될수 도 있고 더 작은 수가 답이 될 수도 있다.
    total = sum(map(int, list(str(storey))))
    
    # 엘리베이터를 움직이는 방법은 두가지 이다 올라가거나 내려간다
    # 현재 층의 1의 자리수 만을 본다.
    # cur : 현재층의 1의 자리수
    # stones : 사용한 마법돌의 수
    
    def move(cur, stones) :
        
        # 0층에 도착하거나 사용한 돌의 수가 각 자라의 합이랑 같거나 클경우 더 할 필요가 없음으로 리턴한다
        if cur <= 0 or stones >= total:
            return stones
        
        # 다음 층은 계속 10으로 나눈다
        next = cur // 10
        
        # 엘리베이터를 움직이는 두가지 방법
        # 1. 올라간다 (올라갈경우 carry = 1이 되어 앞의 자리수가 하나 올라간다)
        # 2. 내려가다
        answer = min(move(next, stones + cur % 10), move(next + 1, stones + (10 - cur % 10)))
        return answer
    
    answer = move(storey, 0)
    return answer