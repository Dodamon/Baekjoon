# 방문체크를 하면서 위치를 이동한다
def solution(dirs):
    answer = 0
    visited = [[[False] * 11 for _ in range(11)] for _ in range(4)]
    dict = {"U": 0, "D": 1, "R": 2, "L": 3}
    dy = [-1, 1, 0, 0]
    dx = [0, 0, 1, -1]

    y, x = 5, 5
    for d in dirs:
        i = dict[d]

        ny = y + dy[i]
        nx = x + dx[i]

        # 1 좌표상으로 방문하지 못할때
        if ny < 0 or ny > 10 or nx < 0 or nx > 10:
            continue

        # 2 좌표상으로 갈수는 있고 이전에 방문한 적이 없을때
        j = i
        if i % 2 == 0:
            j += 1
        else:
            j -= 1

        if not visited[i][ny][nx] and not visited[j][y][x]:
            visited[i][ny][nx] = True
            answer += 1

        y, x = ny, nx

    return answer
