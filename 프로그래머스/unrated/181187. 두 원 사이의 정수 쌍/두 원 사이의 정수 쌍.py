from math import sqrt

def solution(r1, r2):
    answer = 0
    for x in range(r1):
        answer += int(sqrt(r2**2 - x**2)) - int(sqrt(r1**2 - x**2 - 1))
    for x in range(r1, r2):
        answer += int(sqrt(r2**2 - x**2))
    return answer * 4