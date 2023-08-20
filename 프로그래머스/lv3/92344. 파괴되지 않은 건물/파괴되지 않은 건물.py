# 2차원 누적합... 미쳤따..
def solution(board, skill):
    # 세로, 가로
    M, N = len(board), len(board[0])
    result = [[0] * (N+1) for _ in range(M+1)]
    answer = 0
    
    # 스킬을 하나씩 탐색하면서 2차원 누적합을 할 준비를 한다
    for t, r1, c1, r2, c2, degree in skill:
        
        # 적의 공격일경우 반대로 실행
        if t == 1:
            t = -1
        else:
            t = 1
            
        degree *= t
        result[r1][c1] += degree
        result[r2+1][c2+1] += degree 
        result[r1][c2+1] += degree * -1
        result[r2+1][c1] += degree * -1
    

    # 누적합 시작 x축:
    for y in range(M):
        for x in range(1, N):
            result[y][x] += result[y][x-1]
    # 누적합 시작 y축:
    for x in range(N):
        for y in range(1, M):
            result[y][x] += result[y-1][x]
    
    # 파괴되지 않는 건물을 카운트 한다
    for y in range(M):
        for x in range(N):
            if board[y][x] + result[y][x] > 0:
                answer += 1
                
    return answer