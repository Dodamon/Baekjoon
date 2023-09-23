from collections import deque, defaultdict

def solution(x, y, n):
    answer = 0
    queue = deque()
    queue.append((y, 0))
    if x == y:
        return 0
    
    while queue:
        num, depth = queue.popleft()
        if num == x:
            answer = depth
            break
        if num < x:
            continue
        
        if num % 2 == 0:
            queue.append((num//2, depth+1))
        if num % 3 == 0:
            queue.append((num//3, depth+1))
        if num > n:
            queue.append((num-n, depth+1))
    
    if answer == 0:
        answer = -1

    return answer