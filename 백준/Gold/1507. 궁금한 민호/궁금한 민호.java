import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		boolean[][] visited = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			String[] inputs = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(inputs[j]);
			}
		}


		for (int i = 0; i < N; i++) { // 출발 노드
			for (int j = 0; j < N; j++) {// 도착 노드
				boolean isInserted = true;
				for (int k = 0; k < N; k++) {// 거쳐가는 노드
					
					if(i == k || i == j || k == j) continue;
					
					if (map[i][k] + map[k][j] == map[i][j]) {
						
						visited[i][j] = true;
					} else if(map[i][k] + map[k][j] < map[i][j]) {
						bw.write(-1 + "");
						bw.flush();
						return;
					}
				}
			}
		}
		
		int total = 0;
		for (int i = 0; i < N; i++)
		{
			for (int j = i; j < N; j++)
			{
				if (!visited[i][j])
				{
					total += map[i][j];
				}
			}
		}

		/*---------------출력----------------*/
		bw.write(total + "");
		bw.flush();
		br.close();
		bw.close();
	}
}
