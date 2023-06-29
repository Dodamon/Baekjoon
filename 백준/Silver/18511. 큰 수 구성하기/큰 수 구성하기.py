import sys

N, K = map(int, sys.stdin.readline().split())
nums = list(map(int, sys.stdin.readline().split()))
ans = 0

def recursive_dfs(cur):
    global ans
    if cur > N:
        return
    ans = max(cur, ans)
    for i in range(K):
        recursive_dfs(cur*10 + nums[i])
recursive_dfs(0)
print(ans)