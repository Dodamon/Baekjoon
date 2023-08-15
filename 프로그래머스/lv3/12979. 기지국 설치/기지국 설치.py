# 그리디 : 가장 최선의 선택을
import math

def solution(n, stations, w):
    answer = 0
    left = 1
    
    for s in stations:
        if s - w > 0:
            answer += math.ceil(((s-w) - left) / (w * 2 + 1))
        left = s + w + 1
    
    if left - 1 < n:
        answer += math.ceil((n - (left-1)) / (w * 2 + 1))
    return answer