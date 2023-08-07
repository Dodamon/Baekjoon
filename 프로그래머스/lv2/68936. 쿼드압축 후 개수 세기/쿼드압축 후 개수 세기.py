def solution(arr):
    global answer
    answer = [0, 0]
    
    # 재귀로 풀수 있다
    # y: 쿼드 압축을 시작하는 박스의 가장 왼쪽 위 y좌표
    # x: 퀴드 압축을 시작하는 박스의 가장 왼쪽 위 x좌표
    def compress(y, x, n):
        state = arr[y][x]
        isPossible = True
        
        # 한가지 상태로 이뤄져 있는지 탐색하낟
        for i in range(y, y + n):
            for j in range(x, x + n):
                if arr[i][j] != state:
                    isPossible = False
                    break;
            if not isPossible:
                break;
        
        # 하나의 상태로 나타낼수 있다면 바로 answer에 값을 저장한다
        # 하나의 상태로 나타낼수 없다면 재귀적으로 탐색을 시작한다
        if isPossible:
            answer[state] += 1
        else:
            n = n // 2
            compress(y, x, n)
            compress(y, x + n, n)
            compress(y + n, x, n)
            compress(y + n, x + n, n)
            
    compress(0, 0, len(arr))
    return answer