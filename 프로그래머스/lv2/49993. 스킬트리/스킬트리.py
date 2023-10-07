from collections import defaultdict

def solution(skill, skill_trees):
    answer = 0
    skills = defaultdict(int)
    
    for i, alpha in enumerate(skill):
        skills[alpha] = i+1
    
    for tree in skill_trees:
        needSkill = 1
        for alpha in tree:
            if skills[alpha] > needSkill:
                break
                
            elif skills[alpha] == needSkill:
                needSkill += 1
        
        else:
            answer += 1
            
    return answer