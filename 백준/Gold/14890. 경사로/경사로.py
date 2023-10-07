import sys
from collections import deque

input = sys.stdin.readline

N, L = map(int, input().split())
maps = [list(map(int, input().split())) for _ in range(N)]
answer = 0

def check_line(line):
    for i in range(1, N):
        if abs(line[i] - line[i-1]) > 1:
            return False
        if line[i] < line[i-1]:
            for j in range(L):
                if i + j >= N or line[i] != line[i + j] or slope[i + j]:
                    return False
                slope[i + j] = True

        elif line[i] > line[i-1]:
            for j in range(L):
                if i - j - 1 < 0 or line[i - 1] != line[i - j - 1] or slope[i - j - 1]:
                    return False
                slope[i - j - 1] = True
    return True


for i in range(N):
    slope = [False] * N
    if check_line([maps[i][j] for j in range(N)]):
        answer += 1

for j in range(N):
    slope = [False] * N
    if check_line([maps[i][j] for i in range(N)]):
        answer += 1

print(answer)
