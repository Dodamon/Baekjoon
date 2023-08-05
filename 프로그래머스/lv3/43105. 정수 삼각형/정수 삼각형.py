# 와우 신기한 DP

def solution(triangle):
    answer = 0
    for i, row in enumerate(triangle):
        for j, col in enumerate(row):
            if i == 0:
                break
                
            # 대각선 방향으로 위에서 오른쪽 왼쪽을 저장한다
            left, right = 0, 0
            if j > 0:
                left = triangle[i-1][j-1]

            if j < len(row) - 1:
                right = triangle[i-1][j]
            triangle[i][j] += max(left, right)

    answer = max(triangle[len(triangle) - 1])
    return answer
