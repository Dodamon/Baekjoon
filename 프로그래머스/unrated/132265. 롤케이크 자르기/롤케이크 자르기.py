import collections
def solution(topping):
    answer = 0
    right = collections.Counter(topping)
    left = collections.defaultdict(int)
    
    for i, t in enumerate(topping):
        if right[t] == 1:
            right.pop(t)
        else:
            right[t] -=1
        
        left[t] += 1
        if len(right) == len(left):
            answer += 1
            
    return answer