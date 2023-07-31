from collections import deque
def solution(maps):
    answer = 0

    start, exit, lever = (0, 0), (0, 0), (0, 0)
    C, R = len(maps), len(maps[0])
    for y in range(C):
        for x in range(R):
            if maps[y][x] == 'S':
                start = (y, x)
            elif maps[y][x] == 'E':
                exit = (y, x)
            elif maps[y][x] == 'L':
                lever = (y, x)

    def bfs(start, end):
        dy = [-1, 1, 0, 0]
        dx = [0, 0, -1, 1]
        visited = [[False for _ in range(R)] for _ in range(C)]
        queue = deque()

        visited[start[0]][start[1]] = True
        queue.append((0, start))

        while queue:
            times, (y, x) = queue.popleft()

            if y == end[0] and x == end[1]:
                return times

            for i in range(4):
                ny = y + dy[i]
                nx = x + dx[i]
                if ny < 0 or ny >= C or nx < 0 or nx >= R or visited[ny][nx] or maps[ny][nx] == 'X':
                    continue

                visited[ny][nx] = True
                queue.append((times + 1, (ny, nx)))

        return -1

    # 시작점 부터 lever 까지 최소거리로 간다
    tolever = bfs(start, lever)
    if tolever == -1:
        return -1

    # lever 부터 출구까지 최소거리로 간다
    toexit = bfs(lever, exit)
    if toexit == -1:
        return -1

    return tolever + toexit

print(solution(["LOOXS","OOOOX","OOOOO","OOOOO","EOOOO"]))