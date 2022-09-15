from collections import deque
import sys
sys.setrecursionlimit(10**5)


input = sys.stdin.readline
N, L, R = map(int, input().split())
people = [list(map(int, input().split())) for _ in range(N)]

# right, down
dx = [1, 0]
dy = [0, 1]

def BFS(y, x):
    queue = deque()
    visited[y][x] = True
    queue.append([y, x])
    total = 0
    path = []

    while queue:
        y, x = queue.popleft()
        path.append([y, x])
        total += people[y][x]

        if x + 1 < N and not isBorders_w[y][x] and not visited[y][x + 1]:
            queue.append([y, x+1])
            visited[y][x+1] = True
        if x - 1 >= 0 and not isBorders_w[y][x-1] and not visited[y][x - 1]:
            queue.append([y, x-1])
            visited[y][x-1] = True
        if y + 1 < N and not isBorders_h[y][x] and not visited[y+1][x]:
            queue.append([y+1, x])
            visited[y+1][x] = True
        if y - 1 >= 0 and not isBorders_h[y-1][x] and not visited[y-1][x]:
            queue.append([y-1, x])
            visited[y-1][x] = True

    return total, path

days = 0
while True:
    isBorders_w = [[False] * (N - 1) for _ in range(N)]
    isBorders_h = [[False] * (N) for _ in range(N - 1)]

    # Step 1: Open
    cnt = 0
    for y in range(N):
        for x in range(N-1):
            diff = abs(people[y][x] - people[y][x+1])
            if L > diff or diff > R:
                isBorders_w[y][x] = True
            else:
                cnt += 1

    for x in range(N):
        for y in range(N-1):
            diff = abs(people[y][x] - people[y+1][x])
            if L > diff or diff > R:
                isBorders_h[y][x] = True
            else:
                cnt += 1

    #print(isBorders_w, isBorders_h)
    if cnt == 0:
        break
    # Step 2: BFS
    visited = [[False] * N for _ in range(N)]
    # isMoved = False
    for i in range(N):
        for j in range(N):
            if not visited[i][j]:
                total, path = BFS(i, j)
                new_people = total // len(path)
                std = people[path[0][0]][path[0][1]]
                for y, x in path:
                    # if std != people[y][x]:
                    #     isMoved = True
                    people[y][x] = new_people
    days += 1
    #print(people)
print(days)


