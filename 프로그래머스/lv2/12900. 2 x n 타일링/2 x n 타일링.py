def solution(n):
    answer = 0
    dp = [0] * (n+1)
    dp[1] = 1
    dp[2] = 2
    dp[3] = 3
    if n < 4:
        return dp[n]
    
    for i in range(4, n+1):
        dp[i] =(dp[i-2] * 2 + dp[i-3]) % 1000000007
        
    
    return dp[n]