import collections
import itertools

# 풀이) 조합 심화 문제.... :)
def solution(orders, course):    
    answer = []
    
    # 한사람당 만들수 있는 course_size 길이의 코스요리를 만든다
    for course_size in course:
        order_combinations = []
        for order in orders:
            order_combinations += itertools.combinations(sorted(order), course_size)
        # 모든 사람이 만들 수 있는 course_size길이의 코스요리를 카운트 해서 가장 많이 카운트 된 결과를 저장한다...
        most_ordered = collections.Counter(order_combinations).most_common()
        answer += ["".join(sorted(k)) for k, v in most_ordered if v > 1 and v == most_ordered[0][1]]
    return sorted(answer)