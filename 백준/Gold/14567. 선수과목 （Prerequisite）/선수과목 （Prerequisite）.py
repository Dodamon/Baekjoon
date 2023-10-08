import sys
from collections import deque, defaultdict
input = sys.stdin.readline

n, m = map(int, input().split())
arr = defaultdict(list)
answer = [1] * (n+1)

for i in range(m):
    a, b = map(int, input().split())
    arr[a].append(b)

for a in range(1, n+1):
    for b in arr[a]:
        answer[b] = max(answer[b], answer[a]+1)
 
print(*answer[1:])