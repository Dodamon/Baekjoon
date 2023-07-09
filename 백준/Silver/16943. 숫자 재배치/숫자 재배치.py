def dfs(depth, visit, now):
    global ans
    if depth == L:
        ans = now
        return True
    
    for i in range(L):
        if visit & (1 << i):
            continue
        new = now + A[i] * 10 ** (L-1-depth)
        if 0 < new < B:
            if dfs(depth+1, visit | (1 << i), new):
                return True
    return False

A, B = input().split()
A = sorted(map(int, A), reverse=True)
B = int(B)
L = len(A)

ans = -1
dfs(0, 0, 0)
print(ans)
