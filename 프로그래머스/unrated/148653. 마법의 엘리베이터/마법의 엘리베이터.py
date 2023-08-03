import sys

def solution(storey):
    answer = 0
    total = sum(map(int, list(str(storey))))
    
    def move(cur, stones) :
        print(cur)
        
        if cur <= 0:
            return stones
        
        if stones >= total:
            return stones
        
        next = cur // 10
        answer = min(move(next, stones + cur % 10), move(next + 1, stones + (10 - cur % 10)))
        return answer
    
    answer = move(storey, 0)
    return answer