from collections import deque
def solution(rectangle, characterX, characterY, itemX, itemY):
    answer = 0
    graph = [[-1] * 101 for _ in range(101)]
    visited = [[0] * 101 for _ in range(101)]
    
    for rect in rectangle:
        x1, y1, x2, y2 = map(lambda x: x*2, rect)
        for i in range(x1, x2+1):
            for j in range(y1, y2+1):
                if x1 < i < x2 and y1 < j < y2:
                    graph[i][j] = 0
                elif graph[i][j] != 0:
                    graph[i][j] = 1
    queue = deque()
    queue.append((characterX*2, characterY*2))
    visited[characterX*2][characterY*2] = 1
    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]
    
    while queue:
        x, y = queue.popleft()
        if (x, y) == (itemX*2, itemY*2):
            answer = visited[x][y] // 2
            break
            
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 1 < nx < 101 and 1 < ny < 101 and graph[nx][ny] == 1 and visited[nx][ny] == 0:
                visited[nx][ny] = visited[x][y] + 1
                queue.append((nx, ny))

            
    
    return answer