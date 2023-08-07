def solution(arr):
    global answer
    answer = [0, 0]
    
    def compress(y, x, n):
        state = arr[y][x]
        isPossible = True
        
        for i in range(y, y + n):
            for j in range(x, x + n):
                if arr[i][j] != state:
                    isPossible = False
                    break;
            if not isPossible:
                break;
        
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