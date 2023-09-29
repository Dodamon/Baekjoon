def solution(sticker):
    answer = 0
    N = len(sticker)
    dp = [0] * N
    
    if N < 3:
        return max(sticker)
    
    dp[0], dp[1] = sticker[0], sticker[0]
    for i in range(2, N-1):
        dp[i] = max(dp[i-1], dp[i-2] + sticker[i])
    answer = dp[N-2]

    
    dp[0], dp[1] = 0, sticker[1]
    for i in range(2, N):
        dp[i] = max(dp[i-1], dp[i-2] + sticker[i])
    return max(answer, dp[N-1])