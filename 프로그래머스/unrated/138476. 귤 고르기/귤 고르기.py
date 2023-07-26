import collections

def solution(k, tangerine):
    answer = 0
    counts = collections.defaultdict(int)
    # 같은 종류의 귤끼리 count를 한다
    # 가장 count가 높은 귤 순으로 박스에 넣는다

    for t in tangerine:
        counts[t] += 1
    counts = sorted(counts.items(), key=lambda x: x[1], reverse=True)

    for count in counts:
        if k <= 0:
            break
        answer += 1
        k -= count[1]

    return answer