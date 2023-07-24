def solution(scores):

    wanho, scores = scores[0], scores[1:]
    wanho_a, wanho_b = wanho
    threshold = 0
    rank = 1

    # score_a는 내림차순 score_b는 오름차순 기준으로 정렬해서 -> 이렇게 되면 b만 비교할 수 있다.
    # score_a기준으로 연산을 진행한다
    # 1. 원후의 a, b가 현재 score 보다 작다면 바로 -1을 리턴한다

    # 2. 만약 threshold 값보다 b의 값이 같거나 클 경우 => threshold 값을 갱신한다.
    # 3. 만약 threshold 값보다 b의 값이 작을 경우 => threshold의 a보다 현재 a값이 무조건 작거나 같은데 b까지 작으면 
    # rank에 영향을 주지 않고 만약 a가 작을 경우 인센티브를 받을 수 없다
    for score_a, score_b in sorted(scores, key=lambda s: (-s[0], s[1])):

        if wanho_a < score_a and wanho_b < score_b:
            return -1

        if threshold <= score_b:
            threshold = score_b

            if wanho_a + wanho_b < score_a + score_b:
                rank += 1
    return rank

