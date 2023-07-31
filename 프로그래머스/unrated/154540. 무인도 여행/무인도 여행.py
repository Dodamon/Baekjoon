from collections import deque

# BFS 탐색을 하면서 붙어있는 땅들(무인도)에서 머물수 있는 기간을 구한다
def solution(maps):
    answer = []
    n, m = len(maps), len(maps[0])
    visited = [[False for _ in range(m)] for _ in range(n)]
    
    def bfs(visited, y, x):
        
        dy = [-1, 1, 0, 0]
        dx = [0, 0, -1, 1]
        
        queue = deque()
        queue.append((y, x))
        visited[y][x] = True
        days = 0
        
        while queue:
            y, x = queue.popleft()
            days += int(maps[y][x])
            
            for i in range(4):
                ny = y + dy[i]
                nx = x + dx[i]
                
                if ny < 0 or ny >= n or nx < 0 or nx >= m or visited[ny][nx] or maps[ny][nx] == 'X':
                    continue
                
                queue.append((ny, nx))
                visited[ny][nx] = True
        
        return days
        
    for y in range(n):
        for x in range(m):
            if maps[y][x] != 'X' and not visited[y][x]:
                answer.append(bfs(visited, y, x))
    
    if not answer:
        answer.append(-1)
    else:
        answer.sort()
        
    return answer