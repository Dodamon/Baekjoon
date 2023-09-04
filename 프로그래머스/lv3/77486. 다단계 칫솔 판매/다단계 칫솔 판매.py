import math

def solution(enroll, referral, seller, amount):
    answer = [0] * len(enroll)
    
    # 사람의 이름을 기준으로 인덱스로 저장한다
    # index["john"] = 0
    # parents[0] = "-"
    index = dict()
    parents = [""] * len(enroll)
    for i, name in enumerate(enroll):
        index[name] = i
        parents[i] = referral[i]

    
    for i, name in enumerate(seller):
        
        j = index[name]
        money = amount[i] * 100
        
        # 남은 돈이 0 보다 클때까지 그 위에 사람에게 이익의 10%를 줄 수 있다
        while money > 0:
            next_money = math.floor(money * 0.1)
            money = money - next_money
            
            # 10%를 주고 남은 돈을 answer에 저장하다
            answer[j] += money
            # 더이상 위에 이익을 분배할 사람이 없다면 탐색을 멈춘다
            if parents[j] == "-":
                break
            # 다음 탐색을 위해 자신을 조직에 참여시킨 parent를 찾아 j, money를 갱신한다
            j = index[parents[j]]
            money = next_money
            
    return answer