class Solution(object):
    def numDecodings(self, s):
        """
        :type s: str
        :rtype: int
        """
        if s[0] == '0':
            return 0
        
        # dp[i] i까지 왔을때 경우의수
        # dp[i] = dp[i-1] + dp[i-2]
        dp = [0] * (len(s) + 1)
        dp[0] = 1

        for i in range(1, len(s)):
            if s[i] >= '1':
                dp[i] += dp[i - 1]
            if int(s[i-1: i+1]) >= 10 and int(s[i-1: i+1]) <= 26:
                dp[i] += dp[i - 2] if i > 2 else 1


        return dp[len(s)-1]