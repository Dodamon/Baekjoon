from collections import Counter, defaultdict

def solution(gems):
    
    N = len(set(gems))
    visited = set()
    counts = defaultdict(int)
    answer = []
    
    left, right = 0, 0
    visited.add(gems[right])
    counts[gems[right]] += 1
    length = len(gems) + 1
    
    while right < len(gems) and left <= right:
        if len(visited) == N:
            if right - left < length:
                answer = [left+1, right+1]
                length = right - left
                
            counts[gems[left]] -= 1
            if counts[gems[left]] == 0:
                visited.remove(gems[left])
            left += 1
            
        else:
            right += 1
            if right < len(gems):
                visited.add(gems[right])
                counts[gems[right]] += 1
                
    return answer