from collections import defaultdict
from collections import deque

def bfs(n, graph, v1, v2) :
    visited = [False for _ in range(n+1)]
    visited[v1] = True
    queue = deque()
    count = 1
    
    for n in graph[v1]:
        if n != v2:
            queue.append(n)
            visited[n] = True
    
    while queue:
        n1 = queue.popleft()
        count += 1
        
        for n2 in graph[n1]:
            if not visited[n2]:
                queue.append(n2)
                visited[n2] = True
    return count 
    

def solution(n, wires):
    answer = n
    graph = defaultdict(list)
    
    # 인접리스트로 표현하기
    for v1, v2 in wires:
        graph[v1].append(v2)
        graph[v2].append(v1)
    
    # BFS를 돌면서 각 Tree에 속한 노드 갯수를 구한다.
    for v1, v2 in wires:
        l1 = bfs(n, graph, v1, v2)
        l2 = n - l1
        answer = min(abs(l1-l2), answer)
        
    return answer