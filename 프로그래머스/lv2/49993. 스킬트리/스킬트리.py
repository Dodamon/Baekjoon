from collections import defaultdict

def solution(skill, skill_trees):
    answer = 0
    skills = defaultdict(int)
    
    for i, alpha in enumerate(skill):
        skills[alpha] = i+1
    
    for tree in skill_trees:
        needSkill = 1
        isPossible = True
        for alpha in tree:
            if skills[alpha] > needSkill:
                isPossible = False
                break
                
            elif skills[alpha] == needSkill:
                needSkill += 1
        
        if isPossible:
            answer += 1
            
    return answer