# 플로이드 와샬
from collections import defaultdict

def solution(n, s, a, b, fares):

    INF = 200000001
    answer = INF
    d = [[INF] * n for _ in range(n)]
    
    for x in range(n):
        d[x][x] = 0
        
    for u, v, w in fares:
        d[u-1][v-1] = w
        d[v-1][u-1] = w
        
        
    for k in range(n):
        for i in range(n):
            for j in range(n):
                if d[i][j] > d[i][k] + d[j][k]:
                    d[i][j] = d[i][k] + d[k][j]
    
    
    for i in range(n):
        answer = min(d[s-1][i] + d[i][a-1] + d[i][b-1], answer)
    return answer