import collections
answer = -1
dy = [-1, 1, 0, 0]
dx = [0, 0, -1, 1]


def bfs(board, start, end, Y, X):
    global answer

    queue = collections.deque()
    queue.append((0, start[0], start[1]))
    visited = [[10000 for x in range(X)] for y in range(Y)]
    visited[start[0]][start[1]] = 0

    while queue:
        depth, y, x = queue.pop()

        if y == end[0] and x == end[1]:
            if answer == -1:
                answer = depth
            else:
                answer = min(answer, depth)

        for i in range(4):

            ny = y + dy[i]
            nx = x + dx[i]

            while 0 <= ny < Y and 0 <= nx < X and board[ny][nx] != 'D':
                ny += dy[i]
                nx += dx[i]

            ny -= dy[i]
            nx -= dx[i]

            if visited[ny][nx] < depth + 1:
                continue

            visited[ny][nx] = depth + 1
            queue.append((depth+1, ny, nx))


def solution(board):
    # 최단거리
    Y, X = len(board), len(board[0])
    start = []
    end = []

    for y in range(Y):
        for x in range(X):
            if board[y][x] == 'R':
                start = [y, x]
            elif board[y][x] == 'G':
                end = [y, x]

    bfs(board, start, end, Y, X)
    return answer
