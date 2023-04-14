def solution(picks, minerals):
    answer = 0
    
    arr = []
    total = 0
    count = 0
    diam_count = 0
    iron_count = 0
    ston_count = 0
    
    for mineral in minerals:
        if mineral == "diamond":
            total += 25
            diam_count += 1
        elif mineral == "iron":
            total += 5
            iron_count += 1
        else :
            total += 1
            ston_count += 1
            
        count += 1
        
        if count == 5:
            arr.append((total, diam_count, iron_count, ston_count))
            total = 0
            count = 0
            diam_count = 0
            iron_count = 0
            ston_count = 0
            
    if total != 0:
        arr.append((total, diam_count, iron_count, ston_count))
    
    count = picks[0] + picks[1] + picks[2]
    if count < len(arr) :
        arr = arr[:count]
    arr.sort(reverse=True)
    print(arr)
    
    idx = 0
    while (True) :
        # 더 이상 사용할 곡괭이가 없을 때
        if picks[0] <= 0 and picks[1] <= 0 and picks[2] <= 0:
            break
        # 모든 광물을 캤을 때
        if idx == len(arr):
            break
        
        if picks[0] != 0:
            total, diam_count, iron_count, ston_count = arr[idx]
            answer += (diam_count + iron_count + ston_count)
            picks[0] -= 1
            
        elif picks[1] != 0:
            total, diam_count, iron_count, ston_count = arr[idx]
            answer += (diam_count * 5 + iron_count + ston_count)
            picks[1] -= 1
        else :
            total, diam_count, iron_count, ston_count = arr[idx]
            answer += (diam_count * 25 + iron_count * 5 + ston_count)
            picks[2] -= 1
        
        idx += 1
        
    return answer