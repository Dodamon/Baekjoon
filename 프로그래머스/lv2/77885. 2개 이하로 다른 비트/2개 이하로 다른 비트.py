from collections import Counter

def solution(numbers):
    answer = []
    
    for n, num in enumerate(numbers):
        
        # 한개의 비트를 바꾼다
        # 일의자리 부터 탐색해서 0 이 있다면 넣어주고 탐색을 멈춘다
        i = 0
        N = len(bin(num)) - 2
        while i < N:
            if num & (1 << i) == 0:
                num |= (1 << i)
                break
            i += 1
        
        if num == numbers[n]:
            num |= (1 << i)
            #num ^= (1 << i-1)
        # 두개의 비트가 달라질때
        j = i-1
        while j >= 0:
            if num & (1 << j) != 0:
                num ^= (1 << j)
                break
            j -= 1
            
        # 정답배열에 넣는다    
        answer.append(num)
    return answer
