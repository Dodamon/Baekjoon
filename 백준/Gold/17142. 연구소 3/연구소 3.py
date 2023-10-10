import sys
from collections import deque
from itertools import combinations

input = sys.stdin.readline

N, M = map(int, input().split())
maps = [list(map(int, input().split())) for _ in range(N)]
answer = N*N+1
dy = [-1, 1, 0, 0]
dx = [0, 0, -1, 1]

virus = []
space = 0
for y in range(N):
    for x in range(N):
        if maps[y][x] == 2:
            virus.append((y, x))
        if maps[y][x] == 0:
            space += 1

l = [i for i in range(len(virus))]
comb = list(combinations(l, M))

for case in comb:
    visited = [[False] * N for _ in range(N)]
    queue = deque()
    total_time = 0
    total_space =0

    for i in case:
        y, x = virus[i]
        visited[y][x] = True
        queue.append((y, x, 0))

    while queue:
        y, x, time = queue.popleft()

        if maps[y][x] != 2:
            total_time = max(total_time, time)

        for i in range(4):
            ny = y + dy[i]
            nx = x + dx[i]
            if ny < 0 or nx < 0 or ny >= N or nx >= N or visited[ny][nx] or maps[ny][nx] == 1:
                continue

            visited[ny][nx] = True
            queue.append((ny, nx, time+1))
            if maps[ny][nx] == 0:
                total_space += 1

    if total_space == space:
        answer = min(answer, total_time)

if answer == N*N+1:
    answer = -1

print(answer)
