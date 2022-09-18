import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int[] T = new int[N+1];
		int[] P = new int[N+1];
		int[] dp = new int[N + 1];

		for (int i = 1; i < N + 1; i++) {
			String[] inputs = br.readLine().split(" ");
			T[i] = Integer.parseInt(inputs[0]);
			P[i] = Integer.parseInt(inputs[1]);
		}

		for (int i = 1; i < N + 1; i++) { // dp표를 채운다 i일 에 왔을 때 얻을 수 있는 최대 이익
			int max = dp[i-1];
			for (int j = 1; j <= i; j++) {
				if (j + T[j] - 1 == i) { // i일에 끝나는 일을 찾는다
					max = max < dp[j-1] + P[j] ? dp[j-1] + P[j] : max;
				
				}
			}
			dp[i] = max;
		}
		
		bw.write(dp[N] +"");
		bw.flush();
		br.close();
		bw.close();
	}
}