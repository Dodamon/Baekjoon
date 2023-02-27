import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // dp[i][j]  = i 줄에 사자를 j 방식으로 놓는 경우의 수
        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[N][3];

        dp[0][0] = 1;
        dp[0][1] = 1;
        dp[0][2] = 1;

        for(int i = 1; i < N; i++){
            dp[i][0] = (dp[i-1][0] + dp[i-1][1] + dp[i-1][2]) % 9901;
            dp[i][1] = (dp[i-1][0] + dp[i-1][2]) % 9901;
            dp[i][2] = (dp[i-1][0] + dp[i-1][1]) % 9901;
        }

        bw.write((dp[N-1][0] + dp[N-1][1] + dp[N-1][2]) % 9901 + "");
        bw.flush();
        br.close();
        bw.close();

    }
}
