def solution(alp, cop, problems):
    answer = 0
    alp_max, cop_max = alp, cop
    
    for alp_req, cop_req, alp_rwd, cop_rwd, cost in problems:
        alp_max = max(alp_max, alp_req)
        cop_max = max(cop_max, cop_req)
    
    dp = [[0] * 162 for _ in range(162)]
    for y in range(162):
        for x in range(162):
            dp[y][x] = y + x - alp - cop
    
    for y in range(alp, 161):
        for x in range(cop, 161):
            # dp[y+1][x] = min(dp[y+1][x], dp[y][x] + 1)
            # dp[y][x+1] = min(dp[y][x+1], dp[y][x] + 1)
            
            for k in range(len(problems)):
                ny = y + problems[k][2]
                nx = x + problems[k][3]
                
                if ny > alp_max:
                    ny = alp_max
                if nx > cop_max:
                    nx = cop_max
                if y >= problems[k][0] and x >= problems[k][1]:
                    dp[ny][nx] = min(dp[ny][nx], dp[y][x] + problems[k][4])

    answer = dp[alp_max][cop_max]
    return answer