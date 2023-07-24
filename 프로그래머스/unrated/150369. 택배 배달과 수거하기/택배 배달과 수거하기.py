def solution(cap, n, deliveries, pickups) -> int:
    answer = 0
    stack = list(zip(deliveries, pickups))

    truck_to_deli = 0
    truck_to_pick = 0

    while stack:
        deli, pick = stack.pop()
        truck_to_pick += pick
        truck_to_deli += deli

        while truck_to_pick > 0 or truck_to_deli > 0:
            truck_to_pick -= cap
            truck_to_deli -= cap
            answer += (len(stack) + 1) * 2

    return answer
