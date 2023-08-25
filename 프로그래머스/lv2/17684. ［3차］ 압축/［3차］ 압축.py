def solution(msg):
    answer = []
    idx = 1
    hashmap = {}
    
    for i in range(26):
        hashmap[(chr) (ord("A") + i)] = idx
        idx += 1
    
    i = 0
    while i < len(msg):
        j = i + 1
        while j <= len(msg) and hashmap.get(msg[i:j]) != None:
            j += 1
            
        answer.append(hashmap[msg[i:j-1]])
        hashmap[msg[i:j]] = idx
        idx += 1
        i += (j-i-1)
    
    return answer