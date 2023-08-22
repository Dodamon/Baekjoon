# 처음에 DFS로 풀고.. 효율성 꽝인 코드를 써서 실패
# 크게 보면 조합문제인데 이건 n이 완탐하기에는 너무 크다 그래서 효율성 문제에서 실패한거 같다
# 거스름돈 문제는 이상적으로 dp를 사용해서 푼다
# dp[price] : price을 나타낼수 있는 경우의 수
# 그런데 여기 동전을 보면 a동전을 사용해서 b 동전을 나타 낼수 있기 때문에 for문 한개를 사용해서 dp를 채울 경우 겹치는 경우의 수가 발생할 수 있다.
# 따라서 이런 경우를 지우기 위해
# 1. money를 오름차순으로 정렬
# 2. for coin을 하나 정해서 : for price = coint ~ n라고 할때 coin이 포함되는 경우의 수를 price에 채워 나간다..
# 나는 생각하기 매우.. 어려운 문제였따..:(

def solution(n, money):
    answer = 0
    DIV = 1_000_000_007
    dp = [1] + [0] * (n)
    
    for coin in sorted(money):
        for price in range(coin, n+1):
            dp[price] = (dp[price] + dp[price-coin]) % DIV
    
    return dp[n]