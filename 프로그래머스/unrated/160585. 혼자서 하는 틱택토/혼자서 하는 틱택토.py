import collections

result = collections.defaultdict(int)


def dfs(board, visited, y, x):
    dy = [1, 0, 1, -1]
    dx = [0, 1, 1, 1]
    global result

    visited[y][x] = True
    shape = board[y][x]
    que = collections.deque()
    que.append((y, x, -1, 1))

    while que:
        y, x, d, depth = que.pop()

        if depth == 3:
            result[shape] += 1

        for i in range(4):
            ny = y + dy[i]
            nx = x + dx[i]
            if ny < 0 or ny >= 3 or nx < 0 or nx >= 3 or visited[ny][nx] or board[ny][nx] != shape:
                continue

            visited[ny][nx] = True
            if d == i:
                que.append((ny, nx, i, depth + 1))
            else:
                que.append((ny, nx, i, 2))

    return visited


def solution(board):
    answer = 1
    count = collections.defaultdict(int)
    visited = [[False] * 3 for _ in range(3)]

    for y in range(3):
        for x in range(3):
            count[board[y][x]] += 1
            if (board[y][x] == 'X' or board[y][x] == 'O') and not visited[y][x]:
                visited = dfs(board, visited, y, x)

    # "O"를 표시할 차례인데 "X"를 표시하거나 반대로 "X"를 표시할 차례인데 "O"를 표시한다.
    if count['O'] != count['X'] and count['O'] != count['X']+1:
        return 0

    # 선공이나 후공이 승리해서 게임이 종료되었음에도 그 게임을 진행한다.
    if result['X'] and result['O']:
        answer = 0
    elif result['O'] and result['X'] == 0 and count['O'] == count['X']:
        answer = 0
    elif count['X'] and count['O'] == 0 and count['O'] != count['X']:
        answer = 0

    return answer
