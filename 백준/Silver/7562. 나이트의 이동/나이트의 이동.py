import sys
from collections import deque

T = int(sys.stdin.readline())
dx = [1, 2, 2, 1, -1, -2, -2, -1]
dy = [-2, -1, 1, 2, 2, 1, -1, -2]

for _ in range(T):
    l = int(sys.stdin.readline())
    start = list(map(int, sys.stdin.readline().split()))
    target = list(map(int, sys.stdin.readline().split()))
    graph = [[0]*l for _ in range(l)]

    que = deque()
    que.append(start)

    while que:
        y, x = que.popleft()
        if y == target[0] and x == target[1]:
            print(graph[y][x])
            break
        
        for i in range(8):
            ny = y + dy[i]
            nx = x + dx[i]
            if 0 <= nx < l and 0 <= ny < l and graph[ny][nx] == 0:
                que.append([ny, nx])
                graph[ny][nx] = graph[y][x] + 1


