def solution(s):
    sp = s[2:-2].split('},{')
    sp = sorted(sp, key = len)
    answer = []
    for i in sp:
        nums = i.split(',')
        nums = map(int, nums)
        remain = [ item for item in nums if item not in answer]
        answer.append(remain[0])
        
    return answer