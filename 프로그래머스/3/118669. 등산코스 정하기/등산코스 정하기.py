# 최단거리 알고리즘
# 음수가 없는 v의 값, 우선순위큐 사용
from collections import defaultdict
import heapq

def solution(n, paths, gates, summits):
    answer = [0, 10000001]
    visited = [10000001] * (n+1)
    graph = defaultdict(list)
    
    # 인접리스트로 만들기
    for i, j, w in paths:
        graph[i].append((j, w))
        graph[j].append((i, w))
        
    for summit in summits:
        visited[summit] = 0
        
    def dfs(start):
        result = [0, 10000001]
        pq = []
        heapq.heappush(pq, (0, start))

        while pq:
            intens, i = heapq.heappop(pq)
            if intens >= result[1] or intens >= answer[1]:
                continue
            if i in gates:
                result[0] = i
                result[1] = intens
                continue
            
            for j, w in graph[i]:
                next_intens = max(w, intens)
                if visited[j] > next_intens:
                    heapq.heappush(pq, (next_intens, j))
                    visited[j] = next_intens
        return result
    
    for summit in sorted(set(summits)):
        result = dfs(summit)
        
        if result[1] < answer[1]:
            answer[0] = summit
            answer[1] = result[1]
    
    return answer