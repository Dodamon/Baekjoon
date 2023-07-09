import sys
input = sys.stdin.readline
# dfs를 사용한 완전탐색

A, B = input().split()
A = sorted(map(int, A), reverse=True)
B = int(B)
L = len(A)
ans = -1

def dfs(depth, visited, cur) -> bool:
    global ans

    if depth == L:
        ans = cur
        return True
    
    for i in range(L):
        if visited & (1 << i):
            continue

        new = cur * 10 + A[i]
        if 0 < new < B:
            if dfs(depth+1, visited | (1 << i), new):
                return True


dfs(0, 0, 0)
print(ans)
