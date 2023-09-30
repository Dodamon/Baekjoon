# union find

def solution(stones, k):

    if k == 1:
        return min(stones)
    if k == len(stones):
        return max(stones)
    
    answer = 0
    l = []
    for i, num in enumerate(stones):
        l.append((i, num))
    l.sort(key = lambda x: x[1])
    
    before = [x for x in range(-1, len(stones)-1)]
    after = [x for x in range(1, len(stones)+1)]
    
    # 돌이 하나씩 사라진다
    for i, stone in l:
        if after[i] - before[i] - 1 >= k:
            answer = stone
            break
        
        if before[i] == -1:
            before[after[i]] = before[i]
        elif after[i] == len(stones):
            after[before[i]] = after[i]
        else:
            after[before[i]] = after[i]
            before[after[i]] = before[i]
    
    return answer