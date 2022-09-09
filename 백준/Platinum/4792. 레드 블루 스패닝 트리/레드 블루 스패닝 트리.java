import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int[] parent;
	
	public static class Edge implements Comparable<Edge>{
		int v, u, cost;

		public Edge(int v, int u, int cost) {
			this.v = v;
			this.u = u;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge o) {
			return o.cost - this.cost;
		}
		
	}
	public static boolean union(int v, int u) {
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
		if(v == parent[v]) return v;
		return parent[v] = find(parent[v]);
	}
	public static int kruskal(int N, PriorityQueue<Edge> pq) {
		int edgeCount = 0;
		int total = 0;
		while(edgeCount < N-1) {
			Edge edge = pq.poll();
			
			//System.out.println(edge.v + " " + edge.u + " " + edge.cost);
			if(!union(edge.v, edge.u)) {
				total += edge.cost;
				edgeCount++;
			}
		}
		return total;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		while (true) {
			String[] inputs = br.readLine().split(" ");
			int N = Integer.parseInt(inputs[0]);
			int M = Integer.parseInt(inputs[1]);
			int K = Integer.parseInt(inputs[2]);
			
			if(N == 0 && M == 0 && K == 0) break;
			
			PriorityQueue<Edge> pq_blue = new PriorityQueue<>();
			PriorityQueue<Edge> pq_red = new PriorityQueue<>();
			int blueCount = 0;
			
			for(int i = 0; i < M; i++) {
				inputs = br.readLine().split(" ");
				int flag = inputs[0].charAt(0) == 'B'? 1: 0;
				int v = Integer.parseInt(inputs[1]);
				int u = Integer.parseInt(inputs[2]);
				if(flag == 1) blueCount++;
				
				pq_blue.offer(new Edge(v, u, flag));
				flag = flag == 1? 0 : 1;
				pq_red.offer(new Edge(v, u, flag));
			}
			
			if(blueCount < K) {
				sb.append(0).append("\n");
				continue;
			}
			
			parent = new int[N+1];
			for(int i = 0; i < N+1; i++) {
				parent[i] = i;
			}
			int max = kruskal(N, pq_blue);
			//System.out.println();
			for(int i = 0; i < N+1; i++) {
				parent[i] = i;
			}
			int min = (N-1) - kruskal(N, pq_red);
			
			if(min <= K && max >= K) {
				sb.append(1).append("\n");
			} else {
				sb.append(0).append("\n");
			}
			 //System.out.println(min + " " + max);
		}

		/*---------------출력----------------*/
		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
}
