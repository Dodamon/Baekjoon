def solution(A, B):
    answer = 0
    
    # 오름 차순으로 정렬한다
    # 정렬해서 순서를 바꿔도 되는 이유는
    # A의 순서를 임의로 만들고 B를 맞추면 되기 때문이다
    A.sort()
    B.sort()
    
    j = 0
    for i, a in enumerate(A):
        # 현재 a는 A중 가장 작은 수다
        # B에서 작은수중에서 a보다 큰수를 찾아준다.
        while j < len(B) and a >= B[j]:
            j += 1
        
        if j < len(B) and a < B[j]:
            answer += 1
            j += 1
            
    return answer