import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;

class Main {
	static int R, C;
	static int K, V;
	static class Pos {
		int x, y;

		public Pos(int y, int x) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void bfs(char[][] map, boolean[][] visited, int y, int x) {
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		
		Queue<Pos> queue = new ArrayDeque<>();
		queue.add(new Pos(y, x));
		visited[y][x] = true;
		int v = 0;
		int k = 0;
		
		while(!queue.isEmpty()) {
			Pos p = queue.poll();
			y = p.y;
			x = p.x;
			
			if(map[y][x] == 'v') {
				v++;
			} else if(map[y][x] == 'k') {
				k++;
			}
			
			for(int i = 0; i < 4; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				
				if(ny < 0 || ny >= R || nx < 0 || nx >= C || map[ny][nx] == '#' || visited[ny][nx]) continue;
				
				visited[ny][nx] = true;
				queue.add(new Pos(ny, nx));
			}
		}
		
		if(v < k) {
			K += k;
		} else {
			V += v;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] inputs = br.readLine().split(" ");
		R = Integer.parseInt(inputs[0]);
		C = Integer.parseInt(inputs[1]);
		
		char[][] map = new char[R][C];
		boolean[][] visited = new boolean[R][C];
		K = 0;
		V = 0;
		
		for(int i = 0; i < R; i++) {
			String inputs2 = br.readLine();
			for(int j = 0; j < C; j++) {
				map[i][j] = inputs2.charAt(j);
			}
		}
		
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				
				if(map[i][j] != '#' && !visited[i][j]) {
					bfs(map, visited, i, j);
				}
				
			}
		}
		
		bw.write(K + " " + V);
		br.close();
		bw.close();
	}
}
