import math
from collections import defaultdict

# 문자열 + 단순구현문제
# 시간복잡도 O(3n)

def solution(fees, records):
    answer = []
    times = defaultdict(int)
    
    # 차 번호 별로 정리하기 위해서 문자열 처리
    for i, record in enumerate(records):
        time, car, type = record.split(' ')
        HH, MM = map(int, time.split(':'))
        time = HH * 60 + MM
        records[i] = (time, car, type)
    records.sort(key=lambda x:(x[1], x[0]))
    
    
    # 차량번호를 key로하는 times 딕셔너리에 in, out의 시간 차이를 저장한다
    # out이 없는 경우 23:59로 처리한다
    i = 0
    while i < len(records):
        in_time, in_car, _ = records[i]
        out_time = 23 * 60 + 59
        
        if i < len(records)-1 and records[i+1][1] == in_car:
            i += 1
            out_time, out_car, _ = records[i]
            
        times[in_car] += out_time - in_time
        i += 1
        
    # 반복문을 돌면서 비용을 계산한다
    for car, time in list(times.items()):
        if time <= fees[0]:
            answer.append(fees[1])
        else:
            answer.append(fees[1] + math.ceil((time - fees[0]) / fees[2]) * fees[3])
    
    return answer