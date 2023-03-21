import sys
from collections import deque
input = sys.stdin.readline


s = list(input().rstrip())
alpha = deque()
op = deque()
priority = {"+": 0, "-": 0, "*": 1, "/": 1, "(": 2, ")":2}


for i in range(len(s)):
    if s[i].isalpha():
        alpha.append(s[i])
    else:
        # op가 비어있으면 무조건 넣기
        if not op:
            op.append(s[i])
            continue

        if s[i] == ')':
            while alpha:
                print(alpha.popleft(), end = "")
            while op and op[-1] != '(':
                print(op.pop(), end = "")
            op.pop()
        else:
            if priority[op[-1]] >= priority[s[i]]:
                while alpha:
                    print(alpha.popleft(), end = "")
                while op and op[-1] != '(' and priority[op[-1]] >= priority[s[i]]:
                    print(op.pop(), end = "")
            op.append(s[i])
                

while alpha:
    print(alpha.popleft(), end = "")
while op:
    print(op.pop(), end = "")

