R, C, N = map(int, input().split())
board = [list(input()) for _ in range(R)]

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]
bomb = 'O'

N -= 1
while True:
    queue = []
    if N == 0: break

    # 3. 폭탄이 설치되지 않는 부분에 폭탄을 설치한다
    for y in range(R):
        for x in range(C):
            if board[y][x] == '.':
                board[y][x] = 'O'
            else:
                queue.append((y, x))    

    N -= 1
    if N == 0: break
    
    # 4. 이전에 설치된 폭탄을 터트린다.
    while queue:
        y, x = queue.pop()
        board[y][x] = '.'

        for i in range(4):
            ny = y + dy[i]
            nx = x + dx[i]

            if ny < 0 or ny >= R or nx < 0 or nx >= C:
                continue
            if board[ny][nx] == 'O':
                board[ny][nx] = '.'

    N -= 1
    if N == 0: break

for row in board:
    print(*row, sep="")