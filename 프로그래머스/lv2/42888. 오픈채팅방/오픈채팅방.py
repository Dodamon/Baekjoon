# 해시
# O(N)
def solution(record):
    answer = []
    names = {}
    
    # 기록을 읽으면서 id당 닉네임을 저장하고 바꾼다
    for r in record:
        records = r.split()
        id = records[1]
        op = records[0]
        if op == "Enter":
            nick = records[2]
            names[id] = nick
        elif op == "Change":
            nick = records[2]
            names[id] = nick  
            
    # 정답을 저장한다
    for r in record:
        records = r.split()
        id = records[1]
        op = records[0]
        if op == "Enter":
            answer.append(f"{names[id]}님이 들어왔습니다.")
        elif op == "Leave":
            answer.append(f"{names[id]}님이 나갔습니다.")           
            
    return answer