import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class Main {
	
	public static int[] parent;
	public static int[] powers;
	public static class Edge implements Comparable<Edge>{
		int u, v, cost;

		public Edge(int u, int v, int cost) {
			this.u = u;
			this.v = v;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge o) {
			return this.cost - o.cost;
		}
	}
	
	public static void union(int v, int u) {
		v = find(v);
		u = find(u);
		
		if(u < v) {
			parent[v] = u;
		} else {
			parent[u] = v;
		}
	}
	
	public static int find(int v) {
		if(v == 0) return 0;
		if(v == parent[v]) return v;
		return parent[v] = find(parent[v]);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] inputs = br.readLine().split(" ");

		int N = Integer.parseInt(inputs[0]);
		int M = Integer.parseInt(inputs[1]);
		int K = Integer.parseInt(inputs[2]);

		powers = new int[K];
		parent = new int[N + 1];
		
		for(int i = 0; i < N + 1; i++) {
			parent[i] = i;
		}
		
		
		inputs = br.readLine().split(" ");
		for(int i = 0; i < K; i++) {
			powers[i] = Integer.parseInt(inputs[i]);
			parent[powers[i]] = 0;
		}
		
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		for(int i = 0; i < M; i++) {
			inputs = br.readLine().split(" ");
			int v = Integer.parseInt(inputs[0]);
			int u = Integer.parseInt(inputs[1]);
			int cost = Integer.parseInt(inputs[2]);
			pq.add(new Edge(v, u, cost));
		}
		
		int edgeCount = 0;
		int total = 0;;
		boolean allPowered = false;
		while(!allPowered && !pq.isEmpty()) {
			Edge edge = pq.poll();
			
			if (find(edge.v) != find(edge.u)) {
				union(edge.v, edge.u);
				total += edge.cost;
				edgeCount++;
			}
			
			for(int i = 1; i < N + 1; i++) {
				if(parent[i] == 0) {
					allPowered = true;
				} else {
					allPowered = false;
					break;
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
