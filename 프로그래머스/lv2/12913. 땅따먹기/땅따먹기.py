# dp문제
# dp[y][x]을 마지막으로 밟았을때 최대 점수

def solution(land):
    for y in range(len(land)):
        for x in range(len(land[0])):
            if y != 0:
                land[y][x] += max(land[y-1][:x] + land[y-1][x+1:])

    answer = max(land[len(land)-1][:])
    return answer