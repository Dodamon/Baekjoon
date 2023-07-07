import sys
input = sys.stdin.readline

def pre_permutation(nums, N) -> list:

    # 바뀌는 순열 인덱스를 찾는다
    # 뒤에서 부터 내림차순이 아닌 인덱스 i를 찾는다
    i = N-1
    while i > 0 and nums[i-1] <= nums[i]: i -= 1
    if i == 0: return {-1}

    # 뒤에서 부터 nums[i] 보다 작은 수 가 나오는 인덱스 j를 찾는다
    j = N-1
    while j > i-1 and nums[i-1] <= nums[j]: j -= 1


    # swap(i-1, j)
    nums[i-1], nums[j] = nums[j], nums[i-1]
    return nums[:i] + sorted(nums[i:], reverse=True)


def solution() -> None:
    N = int(input())
    nums = list(map(int, input().split()))
    print(*pre_permutation(nums, N), sep=" ")


solution()