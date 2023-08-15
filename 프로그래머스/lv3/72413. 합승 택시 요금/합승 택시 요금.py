# 플로이드 와샬
from collections import defaultdict

def solution(n, s, a, b, fares):

    INF = 200000001
    answer = INF
    dist = [[INF] * n for _ in range(n)]

    for u, v, w in fares:
        dist[u-1][v-1] = w
        dist[v-1][u-1] = w
        
        
    for k in range(n):
        for i in range(n):
            for j in range(n):
                if i == j:
                    dist[i][j] = 0
                else:
                    dist[i][j] = min(dist[i][k] + dist[k][j], dist[i][j])
    
    
    for i in range(n):
        answer = min(dist[s-1][i] + dist[i][a-1] + dist[i][b-1], answer)
    return answer