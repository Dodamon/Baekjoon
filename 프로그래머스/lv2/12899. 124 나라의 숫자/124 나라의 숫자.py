def solution(n):
    nums = ["1", "2", "4"]
    answer = ''
    
    if n == 1:
        return "1"
    
    n -= 1
    while n > 0:
        answer += nums[n%3]
        n = n // 3 - 1
        if n == 0:
            answer += nums[n]  

    return answer[::-1]