import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class Main {

	static int N, M;

	public static class Pair {
		int y, x;

		public Pair(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

	public static class Node implements Comparable<Node> {
		Pair red, blue;
		int cost;

		public Node(Pair red, Pair blue, int cost) {
			this.red = red;
			this.blue = blue;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
	}

	public static int bfs(Pair hole, Node start, char[][] map) {
		int[] dy = { 0, 0, -1, 1 };
		int[] dx = { -1, 1, 0, 0 };

		PriorityQueue<Node> pq = new PriorityQueue<>();
		boolean[][][][] visited = new boolean[N][M][N][M];
		visited[start.red.y][start.red.x][start.blue.y][start.blue.x] = true;
		
		pq.add(start);
		int result = 0;

		while (!pq.isEmpty()) {
			Node node = pq.poll();

			//System.out.println(node.red.y + " " + node.red.x);
			//System.out.println(node.blue.y + " " + node.blue.x);
			//System.out.println(node.cost);

			if (node.cost >= 10) {
				return -1;
			}

			for (int i = 0; i < 4; i++) {
				int nRy = node.red.y;
				int nRx = node.red.x;
				int nBy = node.blue.y;
				int nBx = node.blue.x;
				
				// 빨간 구슬 이동 
				while(true) {
					nRy += dy[i];
					nRx += dx[i];
					if(nRy < 0 || nRy >= N || nRx < 0 || nRx >= M || map[nRy][nRx] == '#') {
						nRy -= dy[i];
						nRx -= dx[i];
						break;
					}
					if(map[nRy][nRx] == 'O') break; 
				}
				
				// 파란 구슬 이동
				while(true) {
					nBy += dy[i];
					nBx += dx[i];
					if(nBy < 0 || nBy >= N || nBx < 0 || nBx >= M || map[nBy][nBx] == '#') {
						nBy -= dy[i];
						nBx -= dx[i];
						break;
					}
					if(map[nBy][nBx] == 'O') break;
				}
				
				// 파란 구슬이 구멍에 들어갔을 때
				if(map[nBy][nBx] == 'O') continue;
				
				if(map[nRy][nRx] == 'O') {
					return node.cost + 1;
				}
				
				// 빨간 파랑 서로 만났을 때 
				if(nRx == nBx && nRy == nBy && map[nRy][nRx] != 'O') { 
					int red_move = Math.abs(nRx-node.red.x) + Math.abs(nRy-node.red.y);
					int blue_move = Math.abs(nBx-node.blue.x) + Math.abs(nBy-node.blue.y);
					
					// 파란 공이 더 빨리 도착한 경우  
					if(red_move > blue_move) {
						nRx -= dx[i];
						nRy -= dy[i];
					}else { // 빨간 공이 더 빨리 도착한 경우  
						nBx -= dx[i];
						nBy -= dy[i];
					}
				}
				
				if(!visited[nRy][nRx][nBy][nBx]) {
					visited[nRy][nRx][nBy][nBx] = true;
					pq.add(new Node(new Pair(nRy, nRx), new Pair(nBy, nBx), node.cost + 1));
				}
				
			}
		}
		
		result = result == 0 ? -1: 1;
		return result;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] inputs = br.readLine().split(" ");

		N = Integer.parseInt(inputs[0]);
		M = Integer.parseInt(inputs[1]);

		char[][] map = new char[N][M];
		Pair red = new Pair(0, 0);
		Pair blue = new Pair(0, 0);
		Pair hole = new Pair(0, 0);

		for (int i = 0; i < N; i++) {
			String inputs2 = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = inputs2.charAt(j);
				if (map[i][j] == 'R') {
					red.y = i;
					red.x = j;
				} else if (map[i][j] == 'B') {
					blue.y = i;
					blue.x = j;
				} else if (map[i][j] == 'O') {
					hole.y = i;
					hole.x = j;
				}
			}
		}

		Node start = new Node(red, blue, 0);
		int result = bfs(hole, start, map);
		/*---------------출력----------------*/
		bw.write(result + "");
		bw.flush();
		br.close();
		bw.close();
	}
}
