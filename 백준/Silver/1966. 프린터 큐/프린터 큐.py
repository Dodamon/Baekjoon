import sys
from collections import deque

T = int(sys.stdin.readline().rstrip())

for _ in range(T):
    N, M = map(int, sys.stdin.readline().split())
    nums = deque(map(int, sys.stdin.readline().split()))
    sorted_nums = sorted(nums, reverse=True)
    target_index = M
    index = 0

    while True:
        while sorted_nums[index] != nums[0]:
            num = nums.popleft()
            nums.append(num)
            target_index = (target_index - 1) % len(nums)
        
        if target_index == 0:
            break
        else:
            nums.popleft()
            index += 1
            target_index = (target_index - 1) % len(nums)
    
    print(index+1)




        