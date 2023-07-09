import sys
import functools
input = sys.stdin.readline

def pre_permuation(nums):

    #1. 인덱스를 뒤에서 부터 탐색하면서 내림차순이 아닌 곳의 인덱스를 찾는다
    N = len(nums) - 1
    i = N
    while i > 0 and nums[i-1] <= nums[i]: i -= 1

    #2. 인덱스 i와 바꿀 인덱스 j를 뒤에서 부터 탐색한다 (nums[i] 보다 작은 수)
    j = N
    while j > i and nums[i-1] <= nums[j]: j -= 1
    
    #3. 인덱스 i와 j를 바꾸고 j 인덱스 아래를 오름 차순으로 바꿔준다.
    nums[i-1], nums[j] = nums[j], nums[i-1]

    return nums[:i] + sorted(nums[i:], reverse=True)

    

def solution(A, B):
    C = -1
    nums = [int(num) for num in str(A)]
    # 내림차순으로 정렬해서 가장큰수 부터 시작
    nums.sort(reverse=True)
    minValue = functools.reduce(lambda x, y: x * 10 + y, nums[::-1])

    # 만약에 만들수 있는 가장 작은 수보다 B가 작다면 바로 리턴한다
    if minValue >= B:
        return C
    
    # pre_permutation을 사용해서 사전순으로 다음으로 작은 숫자를 찾아 낸다
    C = functools.reduce(lambda x, y: x * 10 + y, nums)
    while True:

        if C == minValue:
            break
        if C < B and nums[0] != 0:
            break
        nums = pre_permuation(nums)
        C = functools.reduce(lambda x, y: x * 10 + y, nums)

    if nums[0] == 0 or C >= B:
        C = -1 

    return C 

A, B = map(int, input().split())
print(solution(A, B))