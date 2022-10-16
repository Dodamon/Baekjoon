import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] inputs = br.readLine().split(" ");
		int N = Integer.parseInt(inputs[0]);
		int K = Integer.parseInt(inputs[1]);
		
		int[] dp = new int[K + 1];
		int[] w = new int[N + 1];
		int[] v = new int[N + 1];
		
		for(int i = 1; i < N + 1; i++) {
			inputs = br.readLine().split(" ");
			w[i] = Integer.parseInt(inputs[0]);
			v[i] = Integer.parseInt(inputs[1]);
		}
		
		for(int i = 1
				; i < N+1; i++) {
			for(int j=K; j >= 1; j--) {
				if(w[i] <= j) {
					dp[j] = dp[j] < dp[j - w[i]] + v[i] ? dp[j - w[i]] + v[i] : dp[j];
				}
			}
		}
		bw.write(dp[K] + "");
		br.close();
		bw.close();
	}
}
