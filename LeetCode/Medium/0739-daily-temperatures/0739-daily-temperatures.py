class Solution(object):
    def dailyTemperatures(self, temperatures):
        """
        :type temperatures: List[int]
        :rtype: List[int]
        """
        answer = [0 for _ in range(len(temperatures))]
        stack = []
        # stack 있는 온도 보다 낮은 온도는 stack에 넣는다
        # stack 에 있는 온도 보다 높은 경우 pop 한다
        
        for i, cur in enumerate(temperatures):
            
            while stack and temperatures[stack[-1]] < cur:
                index = stack.pop()
                answer[index] = i - index
                
            stack.append(i)
            
        return answer
        