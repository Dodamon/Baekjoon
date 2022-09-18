import sys
sys.setrecursionlimit(10**6)

T = int(sys.stdin.readline())
field = [ [0] * 50 for i in range(50)]

def dfs(y, x):

    if y < 0 or y >= N or x < 0 or x >= M or field[y][x] == 0:
        return

    field[y][x] = 0
    dfs(y+1, x)
    dfs(y-1, x)
    dfs(y, x+1)
    dfs(y, x-1)

for i in range(T):
    M, N, K = map(int, sys.stdin.readline().split())
    count  = 0
    for j in range(K):
        x, y = map(int, sys.stdin.readline().split())
        field[y][x] = 1

    for y in range(N):
        for x in range(M):
            if field[y][x] == 1:
                dfs(y, x)
                count += 1
    print(count)

