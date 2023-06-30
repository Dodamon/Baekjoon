import sys

N = int(sys.stdin.readline())
meetings = []

# 회의 K 까지 왔을때 최대 인원수
dp = [0] * (N+1) 
last = [0] * (N+1)

meetings.append((0, 0, 0))
for i in range(N):
    s, e, p = map(int, sys.stdin.readline().split())
    meetings.append((s, e, p))
# meetings.sort(key=lambda x: (x[1], x[0], -x[2]))

dp[0] = meetings[0][2]
dp[1] = meetings[1][2]
last[0] = meetings[0][1]
for i in range(2, N+1):
    s, e, p = meetings[i]

    dp[i] = max(dp[i-2] + p, dp[i-1])

print(dp[N])
    
