import sys
import copy
from collections import deque

input = sys.stdin.readline

# 물고기 번호는 1 ~ 16, 위치와 방향을 저장한다
fishList = [0] * 17
board = [[0] * 4 for _ in range(4)]
dy = [-1, -1, 0, 1, 1, 1, 0, -1]
dx = [0, -1, -1, -1, 0, 1, 1, 1]

class Fish:
    def __init__(self, y, x, d, isAlive):
        self.y = y
        self.x = x
        self.d = d
        self.isAlive = isAlive

for i in range(4):
     l = list(map(int, input().split()))
     for j in range(4):
         num, direction = l[j*2], l[j*2+1]
         fishList[num] = Fish(i, j, direction-1, True)
         board[i][j] = num


fish_num = board[0][0]
queue = deque()
queue.append([(0, 0), fishList[fish_num].d, fish_num,  board, fishList])
fishList[fish_num].isAlive = False
answer = 0

while queue:
    shark, sd, total, board, fishList = queue.popleft()
    answer = max(total, answer)

    # 1. 물고기가 움직인다.
    for i in range(1, 17):
        fish = fishList[i]
        # 물고기가 이미 상어한테 먹혔다면 움직이지 않는다.
        if not fish.isAlive:
            continue

        # 물고기가 이동할 칸을 찾는다 45도씩 돌아가면서
        ny = fish.y + dy[fish.d]
        nx = fish.x + dx[fish.d]
        for _ in range(8):
            if ny < 0 or nx < 0 or ny >= 4 or nx >= 4 or (ny == shark[0] and nx == shark[1]):
                fish.d = (fish.d+1)%8
                ny = fish.y + dy[fish.d]
                nx = fish.x + dx[fish.d]
            else:
                break

        # 이동할 수 있는 칸이 없다면 이동하지 않는다.
        if ny < 0 or nx < 0 or ny >= 4 or nx >= 4 or (ny == shark[0] and nx == shark[1]):
            continue

        # 이동할 수 있다면 이동한다
        # fish2 <- fish1
        temp = board[ny][nx]
        fish2 = fishList[temp]
        fish2.y = fish.y
        fish2.x = fish.x
        board[ny][nx] = i

        # fish -> fish2
        board[fish.y][fish.x] = temp
        fish.y = ny
        fish.x = nx

    # 2. 상어가 이동한다.
    (y, x) = shark
    d = sd

    ny = y + dy[d]
    nx = x + dx[d]
    while 0 <= ny < 4 and 0 <= nx < 4:
        num = board[ny][nx]
        fish = fishList[num]
        if fish.isAlive:
            fish.isAlive = False
            queue.append([(ny, nx), fish.d, total + num, [arr[:] for arr in board], copy.deepcopy(fishList)])
            fish.isAlive = True
        ny = ny + dy[d]
        nx = nx + dx[d]


print(answer)