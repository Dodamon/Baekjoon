import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		String[] inputs = br.readLine().split(" ");
		int flag = Integer.parseInt(inputs[0]);
		int[] data = new int[N];
		
		long factori = 1;
		for (int i = 1; i < N; i++) {
			factori *= i;
		}
		int div = N - 1;

		if (flag == 1) {
			long n = Long.parseLong(inputs[1]) - 1;

			boolean[] visited = new boolean[N + 1];
			while (div >= 0) {
				long m = n / factori; // 몫에 따라 숫자가 정해진다

				int cnt = 0;
				for (int i = 1; i <= N; i++) {
					if (visited[i])
						continue;
					if (cnt == m) {
						visited[i] = true;
						sb.append(i).append(" ");
						break;
					}
					cnt++;
				}
				if (div == 0) break;
				n = n % factori;
				factori /= div;
				div--;
			}
		} else {
			boolean[] visited = new boolean[N + 1];
			long result = 0;

			for (int i = 1; i <= N; i++) {
				int n = Integer.parseInt(inputs[i]);

				int count = 0;
				for (int j = 1; j <= N; j++) {
					if (visited[j]) continue;
					if (n == j) {
						visited[j] = true;
						break;
					}
					count++;
				}
				result += factori * count;
				if (div == 0) break;
				factori /= div;
				div--;
				
			}
			
			sb.append(result + 1);

		}

		bw.append(sb.toString());
		bw.flush();
		br.close();
		bw.close();

	}
}
// 2432902008176640000
