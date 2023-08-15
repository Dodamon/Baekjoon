from collections import deque

global visited
N, M = map(int, input().split(" "))
maps = [ list(input()) for _ in range(M)]
visited = [[False] * N for _ in range(M)]
dy = [-1, 1, 0, 0]
dx = [0, 0, -1, 1]

counts = dict()
counts['B'] = 0
counts['W'] = 0

def bfs(y, x, state):
    global visited
    
    queue = deque()
    queue.append((y, x))
    visited[y][x] = True
    count = 0
    
    while queue:
        y, x = queue.popleft()
        count += 1
        for i in range(4):
            ny = y + dy[i]
            nx = x + dx[i]
            if ny < 0 or ny >= M or nx < 0 or nx >= N or visited[ny][nx] or maps[ny][nx] != state:
                continue
            queue.append((ny, nx))
            visited[ny][nx] = True
    return count        
    

for y in range(M):
    for x in range(N):
        if not visited[y][x]:
            count = bfs(y, x, maps[y][x])
            counts[maps[y][x]] += count**2
            
print(counts['W'], counts['B'])