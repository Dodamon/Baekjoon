import sys

input = sys.stdin.readline

N, M, y, x, K = map(int, input().split())
maps = [list(map(int, input().split())) for _ in range(N)]
orders = list(map(int, input().split()))
#  동쪽은 1, 서쪽은 2, 북쪽은 3, 남쪽은 4
dy = [0, 0, 0, -1, 1]
dx = [0, 1, -1, 0, 0]

dice = [0] * 6
global dice_col, dice_row
dice_col = [0, 4, 5, 1]
dice_row = [0, 2, 5, 3]
dicey, dicex = 0, 0

def find_next_dice(d, y, x):

    # 가로로
    nx, ny = 0, 0
    if d == 1 or d == 2:
        nx = (x + (dy[d] + dx[d]) * -1) % 4
        ny = y
        dice_col[ny], dice_col[(ny+2) % 4] = dice_row[nx], 5-dice_row[nx]

    # 세로
    if d == 3 or d == 4:
        nx = x
        ny = (y + (dy[d] + dx[d]) * -1) % 4
        dice_row[nx], dice_row[(nx + 2) % 4] = dice_col[ny], 5 - dice_col[ny]

    return ny, nx


for i in orders:

    ny = y + dy[i]
    nx = x + dx[i]
    if nx < 0 or ny < 0 or nx >= M or ny >= N:
        continue

    dicey, dicex = find_next_dice(i, dicey, dicex)
    ntop = dice_row[dicex]
    if maps[ny][nx] == 0:
        maps[ny][nx] = dice[5-ntop]
    else:
        dice[5-ntop] = maps[ny][nx]
        maps[ny][nx] = 0

    y, x, top = ny, nx, ntop
    print(dice[top])