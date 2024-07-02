from collections import defaultdict

def solution(want, number, discount):
    answer = 0

    hashmap = defaultdict(int)
    state = []
    
    state.append(hashmap.copy())
    for product in discount :
        hashmap[product] += 1
        state.append(hashmap.copy())
    

    
    
    for i in range(len(discount) - 9) :
        start, end = state[i], state[i + 10]
        isOk = True
        for j in range(len(want)) :
            product = want[j]
            product_num = number[j]
            
            if end[product] - start[product] != product_num :
                isOk = False
                break;
                
        if isOk :
            answer += 1
            
    return answer