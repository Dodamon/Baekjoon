import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;

public class Main {
	
	public static class Monkey implements Comparable<Monkey> {
		int w, i;

		public Monkey(int w, int i) {
			this.w = w;
			this.i = i;
		}

		@Override
		public int compareTo(Monkey o) {
			return this.w - o.w;
		}
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int INF = Integer.MAX_VALUE;
		
		String[] inputs = br.readLine().split(" ");
		int N = Integer.parseInt(inputs[0]);
		int M = Integer.parseInt(inputs[1]);
		int Q = Integer.parseInt(inputs[2]);
		
		int[][] D = new int[N][N];
		int[][] cost = new int[N][N];
		
		Monkey[] orders = new Monkey[N];
		inputs = br.readLine().split(" ");
		for(int i = 0; i < N; i++) {
			orders[i] = new Monkey(Integer.parseInt(inputs[i]), i);
		}
		
		for(int i = 0; i < M; i++) {
			inputs = br.readLine().split(" ");
			int a = Integer.parseInt(inputs[0]) - 1;
			int b = Integer.parseInt(inputs[1]) - 1;
			int d = Integer.parseInt(inputs[2]);
			
			D[a][b] = d;
			D[b][a] = d;
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				cost[i][j] = orders[i].w < orders[j].w? orders[j].w : orders[i].w;
				
				if(D[i][j] == 0) {
					D[i][j] = INF;
				} else {
					D[i][j] += cost[i][j];
				}
			}
		}
		
		//System.out.println(Arrays.deepToString(D));
		
		Arrays.sort(orders);
		for(int k = 0; k < N; k++) {
			int m = orders[k].i;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					
					if(m == j || m == i || i == j) continue;
					if(D[i][m] == INF || D[m][j] == INF) continue;
					
					int c = cost[i][m] > cost[m][j] ? cost[m][j] : cost[i][m];
					if(D[i][m] + D[m][j] - c < D[i][j]) {
						D[i][j] = D[i][m] + D[m][j] - c;
						cost[i][j] = cost[i][m] < cost[m][j]? cost[m][j]: cost[i][m];
						
						D[j][i] = D[i][j];
						cost[j][i] = cost[j][i];
					}
				}
			}
		}
		
		for(int i = 0; i < Q; i++) {
			inputs = br.readLine().split(" ");
			int a = Integer.parseInt(inputs[0]) - 1;
			int b = Integer.parseInt(inputs[1]) - 1;

			if(D[a][b] >= INF) {
				sb.append(-1);
			} else {
				sb.append(D[a][b]);
			}
			sb.append("\n");
		}

		/*---------------출력----------------*/
		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
}
