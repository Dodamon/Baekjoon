import sys
# 오큰수 = 리스트 오른쪽 수중 가장 왼쪽에 있는 수를 말한다.
N = int(sys.stdin.readline().rstrip())
arr = list(map(int, sys.stdin.readline().split()))
result = [0] * N
stack = []

for i in range(len(arr)):
    # 위로 볼록한 변환점이 나올때 오큰수가 발생할 수 있다.
    # 그 변환점에 있는 수보다 작은 경우에만 pop하고 그 index에 해당하는 오큰수를 저장
    while stack and arr[stack[-1]] < arr[i]:
        index = stack.pop()
        result[index] = arr[i]
    stack.append(i)
# 오큰수를 찾지못하고 stack에 남아있는 index를 대상으로 -1를 저장
for i in stack:
    result[i] = -1

print(" ".join(map(str, result)))
