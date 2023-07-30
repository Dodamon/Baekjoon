class Solution(object):
    def removeDuplicateLetters(self, s):
        """
        :type s: str
        :rtype: str
        """
        alphas = list(s)
        counts = collections.Counter(alphas)
        stack = []
        visited = set()
  
        
        for cur in alphas:
            counts[cur] -= 1
            if cur in visited:
                continue
            
            while stack and cur < stack[-1] and counts[stack[-1]] > 0 :
                visited.remove(stack[-1])
                stack.pop()
            
            visited.add(cur)
            stack.append(cur)

        return ''.join(stack)
        
        
        