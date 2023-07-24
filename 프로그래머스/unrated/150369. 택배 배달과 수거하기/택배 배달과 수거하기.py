def solution(cap, n, deliveries, pickups) -> int:
    answer = 0
    stack = list(zip(deliveries, pickups))

    truck_to_deli = 0
    truck_to_pick = 0
    
    # 스택을 사용해서 뒤에서 꺼내면서
    # 트럭의 박스 수에 최대 허용량 cap을 빼준다
    # 트럭의 박스 수가 양수가 될때 트럭이 가득찬것이기 때문에 출발지점으로 돌아가야한다.
    while stack:
        deli, pick = stack.pop()
        truck_to_pick += pick
        truck_to_deli += deli
        

        while truck_to_pick > 0 or truck_to_deli > 0:
            truck_to_pick -= cap
            truck_to_deli -= cap
            answer += (len(stack) + 1) * 2

    return answer
