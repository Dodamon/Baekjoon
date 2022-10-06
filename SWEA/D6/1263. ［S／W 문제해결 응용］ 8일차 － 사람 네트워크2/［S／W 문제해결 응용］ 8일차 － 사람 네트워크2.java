import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuffer sb = new StringBuffer();
		final int INF = 999999;

		int TC = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= TC; tc++) {
			String[] inputs = br.readLine().split(" ");
			int N = Integer.parseInt(inputs[0]);

			int[][] distance = new int[N][N];

			int index = 1;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					distance[i][j] = Integer.parseInt(inputs[index++]);
					distance[i][j] = distance[i][j] == 0 ? INF: 1;
				}
			}
			
			// 플로이드 와샬
			//int max = Integer.MIN_VALUE;
			int min = Integer.MAX_VALUE;
			for (int k = 0; k < N; ++k) {
				for (int i = 0; i < N; ++i) {
					if (i == k)
						continue; // 출발지와 경유지가 같다면 다음 출발지
					for (int j = 0; j < N; ++j) {
						if (i == j || k == j)
							continue; // 경유지와 목적지가 같거나 출발지가 곧 목적지라면 패스
						
						if (distance[i][j] > distance[i][k] + distance[k][j]) {
							distance[i][j] = distance[i][k] + distance[k][j];
							//max = max < distance[i][j] ? distance[i][j]: max;
							//min = min > distance[i][j] ? distance[i][j]: min;
						}
					}
				}
			}
			
			for(int i = 0; i < N; i++) {
				int temp = 0;
				for(int j = 0; j < N; j++) {
					if(distance[i][j] == INF) continue;
					temp += distance[i][j];
				}
				min = min > temp ? temp : min;
			}
			
			
			sb.append("#").append(tc).append(" ").append(min).append("\n");
		}
	
		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();

	}

}
