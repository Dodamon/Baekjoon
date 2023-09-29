# dp
def solution(sticker):
    answer = 0
    N = len(sticker)
    dp = [0] * N
    
    if N < 3:
        return max(sticker)
    # 1. 1번째 스티커가 들어가는 경우 (1 ~ N-1의 스티커중에서 탐색한다)
    dp[0], dp[1] = sticker[0], sticker[0]
    for i in range(2, N-1):
        dp[i] = max(dp[i-1], dp[i-2] + sticker[i])
    answer = dp[N-2]

    # 2. 1번째 스티커가 들어가지 않는 경우 (2 ~ N의 스티커중에서 탐색한다)
    dp[0], dp[1] = 0, sticker[1]
    for i in range(2, N):
        dp[i] = max(dp[i-1], dp[i-2] + sticker[i])
    return max(answer, dp[N-1])