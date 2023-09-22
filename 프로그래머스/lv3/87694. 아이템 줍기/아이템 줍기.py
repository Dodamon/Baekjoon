from collections import deque
def solution(rectangle, characterX, characterY, itemX, itemY):
    answer = 0
    graph = [[-1] * 101 for _ in range(101)]
    visited = [[0] * 101 for _ in range(101)]
    # 좌표를 2배로 늘려서 탐색을 한다 -> 왜?: 선분이 없는데 지나 가는 것을 막기 위해서.. (굉장하다..)
    # 1. 다각형 둘레에 1을 채운다
    # 2. BFS를 통해 최단 거리로 아이템에 도착하는 길이를 구할 수 있다.
    for rect in rectangle:
        x1, y1, x2, y2 = map(lambda x: x*2, rect)
        for i in range(x1, x2+1):
            for j in range(y1, y2+1):
                # 다른 사각형 안에 포함되어있으면 0을
                if x1 < i < x2 and y1 < j < y2:
                    graph[i][j] = 0
                # 포함되어 있지 않고 테두리라면 1을 채운다
                elif graph[i][j] != 0:
                    graph[i][j] = 1
    queue = deque()
    queue.append((characterX*2, characterY*2))
    visited[characterX*2][characterY*2] = 1
    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]
    # BFS 최단 거리 탐색
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