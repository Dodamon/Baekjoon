import sys

N = int(sys.stdin.readline())
meetings = []
count = 0

for i in range(N):
    start, end = map(int, sys.stdin.readline().split())
    meetings.append((start, end))

meetings.sort(key=lambda x: (x[1], x[0]))

pre_end = -1
for meeting in meetings:

    start, end = meeting

    if pre_end == -1 or pre_end <= start:
        count += 1
        pre_end = end

print(count)