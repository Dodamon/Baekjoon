class Solution {
    int solution(int[][] lan) {
        int[][] dp = new int[lan.length][4];

        // 이차원 lan를 이중 for문 으로 돌면서 dp표를 채울 수 있다.
        // 시간 복잡도 O(4 * N)
        // 첫번째 행은 lan의 첫행과 똑같이 채우고 시작한다
        // 예시 1
        // | 1      | 2     | 3     | 5     |
        dp[0][0] = lan[0][0];
        dp[0][1] = lan[0][1];
        dp[0][2] = lan[0][2];
        dp[0][3] = lan[0][3];

        // 두번째 행 y 부터 for문을 돌면서 dp표를 채운다
        for (int y = 1; y < lan.length ; y++) {
            dp[y][0] = max(dp[y-1][1], dp[y-1][2], dp[y-1][3]) + lan[y][0];
            dp[y][1] = max(dp[y-1][0], dp[y-1][2], dp[y-1][3]) + lan[y][1];
            dp[y][2] = max(dp[y-1][0], dp[y-1][1], dp[y-1][3]) + lan[y][2];
            dp[y][3] = max(dp[y-1][0], dp[y-1][1], dp[y-1][2]) + lan[y][3];
        }
        // 예시 1
        // | 1      | 2     | 3     | 5     |
        // | 5+5    | 6+5   | 7+5   | 8+3   |
        // | 4+7+5  | 3+7+5 | 2+6+5 | 1+7+5 |

        // 마지막 행ㅏ의 최대값 중에 가장 큰 값을 출력
        int n = lan.length - 1;
        return max(dp[n][0], dp[n][1], dp[n][2], dp[n][3]);
    }

    static int max(int a,int b,int c){
        a = a>b?a:b;
        return a>c?a:c;
    }
    static int max(int a,int b,int c, int d){
        a = a>b?a:b;
        a = a>c?a:c;
        return a>d?a:d;
    }
}