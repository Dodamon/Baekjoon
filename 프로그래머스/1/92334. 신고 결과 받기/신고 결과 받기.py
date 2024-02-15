def solution(id_list, report, k):
    answer = {}
    hashmap = {}
    
    for id in id_list:
        hashmap[id] = set()
        answer[id] = 0
        
    for r in report:
        a, b = r.split(' ')
        hashmap[b].add(a)
    
    for id in hashmap.keys():
        if len(hashmap[id]) >= k:
            for email in hashmap[id]:
                answer[email] += 1
        
    return list(answer.values())