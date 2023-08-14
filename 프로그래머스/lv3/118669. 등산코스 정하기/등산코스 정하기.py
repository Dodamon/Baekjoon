from collections import defaultdict
import heapq

# 크루스칼 우선순위큐를 사용해서 구현한다
# 출발지를 우선순위큐에 다 넣고 방문처리를 한다
# 해당 노드에 더 작은 값으로 방문한 경험이 있다면 더이상 탐색을 진행하지 않는다.
# 처음으로 봉우리에 도착한 값을 바로 리턴해서 정답으로 사용한다.
# 올라갔다가 내려오는 경우를 생각하지 않고 올라가는 경우만 생각해서 문제를 풀수있다 (왔던길로 내려가면 되기때문에)
def solution(n, paths, gates, summits):
    global result
    
    answer = []
    graph = defaultdict(list)
    pq = []
    visited = [10000001 for _ in range(n+1)]
    
    # 인접리스트로 그래프 관계를 정의한다
    for path in paths:
        i, j, w = path
        graph[i].append((j, w))
        graph[j].append((i, w))
        
    #크루스칼 우선순위큐
    def bfs(pq, visited):
        
        # 우선순위큐에서 하나씩 뺀다
        while pq:
            w1, s1, n1 = heapq.heappop(pq)
            if n1 in gates:
                return [s1, w1]
            
            for (n2, w2) in graph[n1]:
                next_w = max(w1, w2)
                if visited[n2] > next_w:
                    visited[n2] = next_w
                    # 지나갔던 갔던 edge값중 가장 큰 값을 넣어준다
                    heapq.heappush(pq, (next_w, s1, n2))
                    
    # 출발지를 다 우선순위에 넣는다
    for summit in sorted(summits):
        heapq.heappush(pq, (0, summit, summit))
        visited[summit] = 0
    answer = bfs(pq, visited)
        
    # 봉우리중 가장 작은 intensity값을 가지는 정답을 출력한다
    
    return answer