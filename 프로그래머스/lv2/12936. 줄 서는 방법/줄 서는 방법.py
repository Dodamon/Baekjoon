import math

def solution(n, k):
    answer = []
    l = [i for i in range(1, n+1)]
    
    while l:
        index = (k-1) // math.factorial(n-1)
        answer.append(l.pop(index))
        
        k = k % math.factorial(n - 1)
        n -= 1
    
    return answer