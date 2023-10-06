def solution(n):
    N = n * (n+1) // 2
    answer = []
    l = [[0] * n for _ in range(n)]
    dy = [1, 0, -1]
    dx = [0, 1, -1]
    y, x, v = 0, 0, 0
    num = 1
    d = 0
    
    for num in range(1, N+1):
        l[y][x] = num
        ny = y + dy[v]
        nx = x + dx[v]
        
        if (ny == n-1-d and nx == d) or (ny == n-1-d and nx == ny-d) or (ny == d * 2 -1 and nx == d):
            v = (v+1)%3
            if v == 2:
                d += 1
        y, x = ny, nx
    

    for y in range(n):
        for x in range(y+1):
            answer.append(l[y][x])
            
    return answer