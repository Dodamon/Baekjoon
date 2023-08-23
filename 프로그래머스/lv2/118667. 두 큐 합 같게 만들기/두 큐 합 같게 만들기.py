from collections import deque

def solution(queue1, queue2):
    answer = -1
    N = len(queue1)
    total1, total2 = sum(queue1), sum(queue2)
    origin = queue2[:]
    
    queue1, queue2 = deque(queue1), deque(queue2)
    target = total1 + total2
    if target % 2 == 1:
        return answer
    
    target //= 2
    count = 0
    # queue1을 기준으로 target 값보다 크면 pop 아니면 push를 한다
    # queue1이 queue2랑 같다면 탐색을 멈춥니다.
    while queue2 and queue1 != origin:
        if total1 == target:
            answer = count
            break
            
        if total1 < target:
            n = queue2.popleft()
            total1 += n
            queue1.append(n)
        else:
            total1 -= queue1.popleft()
        count += 1

        
    return answer
