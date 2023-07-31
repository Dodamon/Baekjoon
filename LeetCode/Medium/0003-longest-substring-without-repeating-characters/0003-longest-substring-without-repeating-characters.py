from collections import defaultdict

class Solution(object):
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        index = defaultdict(lambda : -1)
        dp = [1 for _ in range(len(s))]
        left, right = 0, 0
        
        if not s:
            return 0

        for i, char in enumerate(s):
            if i == 0:
                index[char] = i
                continue
                
            # 이전에 방문했던 문자일때
            # left 위치를 갱신한다
        
            if index[char] != -1:
                for l in range(left, index[char]):
                    index[s[l]] = -1
                left = index[char] + 1

            index[char] = i
            right += 1
            dp[i] = right - left + 1
            
        return max(dp)
