class Solution(object):
    def canCompleteCircuit(self, gas, cost):
        if sum(gas) < sum(cost):
            return -1
        
        start, total = 0, 0
        for i in range(len(gas)) :
            if gas[i] + total < cost[i]:
                start = i + 1
                total = 0

            else:
                total += gas[i] - cost[i]
        return start