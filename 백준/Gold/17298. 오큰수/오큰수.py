import sys

N = int(sys.stdin.readline().rstrip())
arr = list(map(int, sys.stdin.readline().split()))
result = [0] * N
stack = []

for i in range(len(arr)):
    while stack and arr[stack[-1]] < arr[i]:
        index = stack.pop()
        result[index] = arr[i]
    stack.append(i)
for i in stack:
    result[i] = -1

print(" ".join(map(str, result)))