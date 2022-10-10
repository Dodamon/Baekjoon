import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
	
	static int N, M;
	static int[][] map;
	static int[] parent;
	
	public static class Edge implements Comparable<Edge> {
		int v, u, cost;
		public Edge(int v, int u, int cost) {
			this.v = v;
			this.u = u;
			this.cost = cost;
		}
		@Override
		public int compareTo(Edge o) {
			return this.cost - o.cost;
		}
		
	}

	public static void bfs(int y, int x, boolean[][] visited, int num) {
		Queue<int[]> queue = new ArrayDeque<int[]>();
		
		int[] dy = {-1, 1, 0, 0};
		int[] dx = {0, 0, -1, 1};
		
		map[y][x] = num;
		queue.offer(new int[] {y, x});
		
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			y = cur[0];
			x = cur[1];
			
			for(int i = 0; i < 4; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				
				if(ny < 0 || ny >= N || nx < 0 || nx >= M || map[ny][nx] != 1) continue;
				
				map[ny][nx] = num;
				queue.offer(new int[] {ny, nx});
				
			}
		}
	}
	public static boolean union(int u, int v) {
		u = find(u);
		v = find(v);
		
		if(u == v) {
			return true;
		} else {
			if(u < v) {
				parent[v] = u;
			} else {
				parent[u] = v;
			}
			return false;
		}
	}
	public static int find(int v) {
		if(v == parent[v]) {
			return v;
		}
		return parent[v] = find(parent[v]);
		
	}
	public static int kruskal(PriorityQueue<Edge> pq, int num) {
		
		int total = 0;
		int count = 0;
		while(!pq.isEmpty()) {
			Edge edge = pq.poll();
			//System.out.println(edge.v + " " + edge.u + " :: " + edge.cost );
			if(!union(edge.v, edge.u)) {
				total += edge.cost;
				count++;
			}
			if(count == N-1) break;
		}
		
		//System.out.println(Arrays.toString(parent));
		for(int i = 3; i < parent.length - 2; i++) {
			if(!union(2, i)) {
				total = 0;
				break;
			}
		}
		
		return total;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] inputs = br.readLine().split(" ");
		
		N = Integer.parseInt(inputs[0]);
		M = Integer.parseInt(inputs[1]);
		map = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			inputs = br.readLine().split(" ");
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(inputs[j]);
			}
		}
		/*------------------입력끝-------------------*/
		
		// 섬들에 숫자 표시 2 ~
		int num = 2;
		boolean[][] visited = new boolean[N][M];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] == 1 && !visited[i][j]) {
					bfs(i, j, visited, num++);
				}
			}
		}
		//System.out.println(Arrays.deepToString(map));
		
		
		PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
		int[] dy = {-1, 1, 0, 0};
		int[] dx = {0, 0, -1, 1};
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] != 0) {
				
					//System.out.println(y + " " + x);
					for(int k = 0; k < 4; k++) {
						int cost = 0;
						int y = i;
						int x = j;
						int n = map[i][j];
						
						while(true) {
							int ny = y + dy[k];
							int nx = x + dx[k];
							
							if(ny < 0 || ny >= N || nx < 0 || nx >= M || map[ny][nx] == n) break;
							
							if(map[ny][nx] != 0 && map[ny][nx] != n) {
								//System.out.println("here");
								if(cost > 1) {
									//System.out.println(i + " " + j + " "  + cost);
									pq.offer(new Edge(n, map[ny][nx], cost));
								}
								break;
							}
							
							y = ny;
							x = nx;
							cost++;
						}
					}
				}
			}
		}
		
		parent = new int[num + 2];
		for(int i = 2; i < num; i++ ) {
			parent[i] = i;
		}
		
		int result = kruskal(pq, num);
		result = result == 0? -1: result;
		
		/*---------------출력----------------*/
		bw.write(result + "");
		bw.flush();
		br.close();
		bw.close();
	}
}
