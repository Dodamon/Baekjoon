# 중복순열
# 4^7 * 100 < 1억
from itertools import product
import collections

def solution(users, emoticons):
    answer = [0, 0]
    sales = [10, 20, 30, 40]
    
    for i, user in enumerate(users):
        percent, price = user
        if percent == 40:
            continue
        elif percent > 30:
            users[i][0] = 40
        elif percent > 20:
            users[i][0] = 30
        elif percent > 10:
            users[i][0] = 20
        else:
            users[i][0] = 10
    
    
    for percents in product(sales, repeat=len(emoticons)):
        
        # percent 별로 할인된 이모티콘 비용을 계산한다
        costs = collections.defaultdict(int)
        for i in range(len(percents)):
            costs[percents[i]] += emoticons[i] * (100 - percents[i]) / 100 
            costs[0] += emoticons[i]
        # 누적합을 계산한다
        for p in range(30, 0, -10):
            costs[p] += costs[p + 10]
            
        
        # 사람들을 탐색하면서 이모티콘 플러스 서비스를 가입할지 구매할지 결과를 구한다
        result = [0, 0]
        for user in users:
            percent, price = user
            if costs[percent] >= price:
                result[0] += 1
            else:
                result[1] += costs[percent]
        
        answer = max(answer, result)
        
    return answer