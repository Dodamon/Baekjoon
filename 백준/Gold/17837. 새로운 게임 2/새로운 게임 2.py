import sys
input = sys.stdin.readline

N, K = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(N)]
states = [[[] for _ in range(N)] for _ in range(N)]
players = []

dy = [0, 0, -1, 1]
dx = [1, -1, 0, 0]

for i in range(K):
    y, x, d = map(int, input().split())
    players.append([y-1, x-1, d-1])
    states[y-1][x-1].append(i)

count = 0
while count < 1000 * K:

    cur = count%K
    y, x, d = players[cur]
    count += 1

    ny = y + dy[d]
    nx = x + dx[d]
    # 파란색이나 범위를 벗어날때
    if ny < 0 or nx < 0 or ny >= N or nx >= N or board[ny][nx] == 2:
        if d % 2 == 0: d += 1
        else: d -= 1
        players[cur][2] = d
        ny = y + dy[d]
        nx = x + dx[d]

        # 방향을 바꿔도 갈 수 없다면 방향만 바꾼다
        if ny < 0 or nx < 0 or ny >= N or nx >= N or board[ny][nx] == 2:
            continue

    # 이동한다
    if board[ny][nx] == 0:
        idx = states[y][x].index(cur)
        move = states[y][x][idx:]
        for i in states[y][x][idx:]:
            players[i][0] = ny
            players[i][1] = nx
    elif board[ny][nx] == 1:
        idx = states[y][x].index(cur)
        move = states[y][x][idx:]
        for i in states[y][x][idx:]:
            players[i][0] = ny
            players[i][1] = nx
        move.reverse()
    states[ny][nx].extend(move)
    states[y][x] = states[y][x][:idx]
    if len(states[ny][nx]) >= 4:
        break

if count == 1000 * K:
    count = -1
else:
    if count % K != 0:
        count = (count//K) + 1
    else:
         count //= K
print(count)