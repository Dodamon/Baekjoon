import math

def solution(enroll, referral, seller, amount):
    answer = [0] * len(enroll)
    
    index = dict()
    parents = [""] * len(enroll)
    for i, name in enumerate(enroll):
        index[name] = i
        parents[i] = referral[i]

    
    for i, name in enumerate(seller):
        
        j = index[name]
        money = amount[i] * 100
        
        while money > 0:
            next_money = math.floor(money * 0.1)
            money = money - next_money
            
            answer[j] += money
            if parents[j] == "-":
                break
                
            j = index[parents[j]]
            money = next_money
            
    return answer