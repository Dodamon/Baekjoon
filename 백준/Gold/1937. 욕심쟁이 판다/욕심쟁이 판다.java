import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

class Main {
	static int N;
	static int max;
	static int[][] map;
	static int[][] dp;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	static class Pos {
		int x, y, level;

		public Pos(int y, int x, int level) {
			this.x = x;
			this.y = y;
			this.level = level;
		}
	}
	
	// dp[y][x] y, x에서 출발에서 가장 깊이 갈 수 있는
	public static int dfs(int y, int x, int level) {
		
		if(dp[y][x] != 0) {
			return dp[y][x];
		}
		
		int local_max = 0;
		for(int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			
			if(ny < 0 || ny >= N || nx < 0 || nx >= N || map[ny][nx] <= map[y][x]) continue;
			
			int temp = dfs(ny, nx, level+1);
			local_max = local_max < temp? temp: local_max;
		}
		dp[y][x] = local_max + 1;
		
		max = dp[y][x] > max ? dp[y][x]: max;
		
		return dp[y][x];
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		max = Integer.MIN_VALUE;
		map = new int[N][N];
		dp = new int[N][N];
		
		for(int i = 0; i < N; i++) { // 대나무 숲의 정보를 저장한다
			String[] inputs = br.readLine().split(" ");
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(inputs[j]);
			}
		}

		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(dp[i][j] == 0) {
					dfs(i, j, 1);
				}
			}
		}
		// System.out.println(Arrays.deepToString(dp));
		
		bw.write(max + "");
		br.close();
		bw.close();
	}
}
