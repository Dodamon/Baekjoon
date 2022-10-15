## 컨베이어 벨트 위의 로봇
import sys
from collections import deque


input = sys.stdin.readline

N, K = map(int, input().split())
A = deque(list(map(int, input().split())))
robots = deque([0] * (2*N))
steps = 0

while True:

    steps += 1
    ## STEP1: 회전한다
    alt = A.pop()
    A.appendleft(alt)

    alt = robots.pop()
    robots.appendleft(alt)
    if robots[N-1]:
        robots[N-1] = 0

    ## STEP2: 로봇이 이동한다
    for i in range(N-1, -1, -1):
        ni = i + 1
        if robots[i] and not robots[ni] and A[ni] >= 1:
            robots[i], robots[ni] = 0, 1
            A[ni] -= 1
    if robots[N - 1]:
        robots[N - 1] = 0

    ## STEP3: 로봇을 올린다
    if A[0] >= 1:
        robots[0] = 1
        A[0] -= 1

    #print(robots, A)
    ## STEP4: 내구도가 0인 칸의 갯수가 K개인지 확인한다.
    cnt = 0
    for i in range(N*2):
        if A[i] == 0:
            cnt += 1
    if cnt >= K:
        break

print(steps)
