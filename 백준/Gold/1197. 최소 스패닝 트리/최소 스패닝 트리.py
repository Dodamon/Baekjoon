import sys
from collections import defaultdict
import heapq
input = sys.stdin.readline
sys.setrecursionlimit(10**5)
INF = 10**6

V, E = map(int, input().split())
graph = defaultdict(list)
visited = [False] * (V + 1)

for _ in range(E):
    u, v, cost = map(int, input().split())
    graph[u].append((cost, v))
    graph[v].append((cost, u))

def prim(start):
    visited[start] = 1
    pqueue = []
    result = 0
    for cost, node in graph[start]:
        heapq.heappush(pqueue, (cost, node))
    
    while pqueue:
        cost, node = heapq.heappop(pqueue)
        if not visited[node]:
            visited[node] = True
            result += cost

            for cost, nnode in graph[node]:
                if not visited[nnode]:
                    heapq.heappush(pqueue, (cost, nnode))
    return result

print(prim(1))