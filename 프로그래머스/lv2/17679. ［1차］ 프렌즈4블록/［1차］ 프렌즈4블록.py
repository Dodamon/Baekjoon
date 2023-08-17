from collections import deque
def solution(m, n, board):
    global ready
    answer = 0
    popped = [[False] * n for _ in range(m)]
    maps = []
    for b in board:
        maps.append(list(b))
    
    def pop(y, x, state):
        
        if x+1 < n and y+1 < m and not popped[y+1][x] and not popped[y][x+1] and not popped[y+1][x+1] and maps[y+1][x] == state and maps[y][x+1] == state and maps[y+1][x+1] == state:
            print(maps[y][x], y, x)
            ready.add((y, x))
            ready.add((y+1, x))
            ready.add((y+1, x+1))
            ready.add((y, x+1))
    
    while True:
        ready = set()
        
        # 터트릴 준비가 된 블럭을 ready set 에 쌓는다
        for y in range(m-1):
            for x in range(n-1):
                if not popped[y][x]:
                    pop(y, x, maps[y][x])
        
        # ready set에 있는 블럭을 터트린다
        for y, x in ready:
            popped[y][x] = True
        
        
        # ready set이 비었다면 멈춘다
        if not ready:
            break
        answer += len(ready)
        
        
        # 블록을 내린다
        for x in range(n):
            queue = deque()
            for y in range(m-1, -1, -1):
                if not popped[y][x]:
                    popped[y][x] = True
                    queue.append(maps[y][x])

            for y in range(m-1, -1, -1):
                if queue:
                    popped[y][x] = False
                    maps[y][x] = queue.popleft()

    return answer