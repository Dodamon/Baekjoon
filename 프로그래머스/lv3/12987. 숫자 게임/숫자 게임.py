def solution(A, B):
    answer = 0
    
    A.sort()
    B.sort()
    
    j = 0
    for i, a in enumerate(A):
        while j < len(B) and a >= B[j]:
            j += 1
        
        if j < len(B) and a < B[j]:
            answer += 1
            j += 1
            
    return answer