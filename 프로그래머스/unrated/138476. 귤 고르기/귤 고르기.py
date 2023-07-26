import collections


def solution(k, tangerine):
    answer = 0
    counts = collections.Counter(tangerine)
    # 같은 종류의 귤끼리 count를 한다
    # 가장 count가 높은 귤 순으로 박스에 넣는다
    for count in sorted(counts.values(), reverse=True):
        if k <= 0:
            break
        answer += 1
        k -= count
    return answer