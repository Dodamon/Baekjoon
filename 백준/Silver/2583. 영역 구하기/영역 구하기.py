import sys
input = sys.stdin.readline

def bfs(y, x, ground, N, M):

    # 동서 남북
    dy = [0, 0, 1, -1]
    dx = [1, -1, 0, 0]
    queue = []
    queue.append((y, x))
    ground[y][x] = True
    area = 0

    while queue:
        y, x = queue.pop(0)
        area += 1

        for i in range(4):
            ny, nx = y + dy[i], x + dx[i]
            if ny < 0 or ny >= M or nx < 0 or nx >= N or ground[ny][nx] == True:
                continue

            ground[ny][nx] = True
            queue.append((ny, nx))

    return area, ground

def soultion() -> int:
    M, N, K = map(int, input().split())
    ground = [[False]*N for _ in range(M)]
    boxes = []
    ans = 0
    areas = []

    for _ in range(K):
        x1, y1, x2, y2 = map(int, input().split())
        boxes.append((x1, y1, x2, y2))

    for box in boxes:
        x1, y1, x2, y2 = box

        for x in range(x1, x2):
            for y in range(y1, y2):
                ground[y][x] = True

    for y in range(M):
        for x in range(N):
            if ground[y][x] == False:
                area, ground = bfs(y, x, ground, N, M)
                ans += 1
                areas.append(area)

    areas.sort()      
    print(ans)
    print(*areas)
soultion()