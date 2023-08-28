from collections import defaultdict

def solution(orders, course):
    global result
    answer = []
    
    menus = defaultdict(int)
    counts = defaultdict(int)

    # 비트 마스킹으로 풀수 있다
    person = 1
    for order in orders:
        for i in range(len(order)):
            menus[order[i]] |= (1 << person)
            counts[order[i]] += 1
        person += 1
    
    menus = sorted(menus.items(), key=lambda item: counts[item[0]])
    
    def dfs(n, idx, path, people):
        if len(path) == n:
            result[bin(people).count("1")].append("".join(sorted(path)))
            return
            
        for i in range(idx, len(menus)):
            if counts[menus[i][0]] < 2:
                continue
                
            if not people:
                dfs(n, i+1, menus[i][0], menus[i][1] )
            elif bin(menus[i][1] & people).count("1") >= 2:
                dfs(n, i+1, path + menus[i][0], menus[i][1] & people)
    
    for c in course:
        result = defaultdict(list)
        dfs(c, 0, "", 0)
        result = sorted(result.items(), key=lambda item: item[0], reverse=True)
        if result:
            answer.extend(result[0][1])
        
    return sorted(answer)