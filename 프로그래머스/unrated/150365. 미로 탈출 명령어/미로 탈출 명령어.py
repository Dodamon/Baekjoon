from collections import deque

def solution(n, m, x, y, r, c, k):
    answer = ""
    
    dx = [1, 0, 0, -1]
    dy = [0, -1, 1, 0]
    dw = ['d', 'l', 'r', 'u']
    
    queue = deque([(x, y, "", 0)])
    
    while queue:
        x, y, path, cnt = queue.popleft()
        if (x, y) == (r, c) and (k - cnt) % 2 == 1:
            return "impossible"
        if (x, y) == (r, c) and cnt == k:
            return path
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx <= 0 or nx > n or ny <= 0 or ny > m: continue
            if abs(nx - r) + abs(ny - c) + cnt + 1 > k: continue
            queue.append((nx, ny, path + dw[i], cnt + 1))
            break
            
    return "impossible"