from collections import deque

def solution(queue1, queue2):
    answer = -1
    N = len(queue1)
    total1, total2 = sum(queue1), sum(queue2)
    origin = queue2[:]
    
    queue1, queue2 = deque(queue1), deque(queue2)
    target = total1 + total2
    # 만약 두개의 큐의 합이 홀수라면 합을 같게 만들수 없기 때문에 바로 리턴한다
    if target % 2 == 1:
        return answer
    
    target //= 2
    count = 0
    # queue1을 기준으로 target 값보다 크면 pop 아니면 push를 한다
    # queue1이 queue2랑 같거나 or queue2에서 더이상 pop할 원소가 없을때 탐색을 멈춘다
    while queue2:
        if total1 == target:
            answer = count
            break
        # 1. queue1의 총합이 target 값보다 작을 경우
        if total1 < target:
            n = queue2.popleft()
            total1 += n
            queue1.append(n)
        # 2. queue2의 총합이 target 값보다 클 경우
        else:
            total1 -= queue1.popleft()
        count += 1

        
    return answer