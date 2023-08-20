import sys
from collections import deque

N = int(sys.stdin.readline())
graph = [list(map(int, sys.stdin.readline().split())) for _ in range(N)]
min = min(map(min, graph))
max = max(map(max, graph))
count_max = 0
dx = [0, 1, 0, -1]
dy = [1, 0, -1, 0]

def bfs(y, x, std):
    que = deque()
    que.append([y, x])

    while que:
        [y, x] = que.pop()
        visited[y][x] = True
        for i in range(4):
            next_y = y + dy[i]
            next_x = x + dx[i]
            if next_y < 0 or next_y >= N or \
                next_x < 0 or next_x >= N or \
                    graph[next_y][next_x] < std or visited[next_y][next_x]:
                    continue
            que.append([next_y, next_x])
            
for std in range(min, max+1):
    visited = [[False]*N for _ in range(N)]
    count = 0
    for i in range(N):
        for j in range(N):
            if graph[i][j] >= std and not visited[i][j]:
                bfs(i, j, std)
                count += 1
    
    if count_max < count:
        count_max = count

print(count_max)