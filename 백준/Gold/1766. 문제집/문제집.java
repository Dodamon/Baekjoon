import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
	
	public static class Node {
		int n;
		Node next = null;
		
		public Node(int n, Node next) {
			super();
			this.n = n;
			this.next = next;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		String[] inputs = br.readLine().split(" ");
		int N = Integer.parseInt(inputs[0]);
		int M = Integer.parseInt(inputs[1]);
		int[] degree = new int[N+1];
		Node[] nodes = new Node[N+1];
		
		for(int i = 0; i < N+1; i++) {
			nodes[i] = new Node(0, null);
		}

		for(int i = 0; i < M; i++) {
			inputs = br.readLine().split(" ");
			int a = Integer.parseInt(inputs[0]);
			int b = Integer.parseInt(inputs[1]);
			
			degree[b]++;
			nodes[a] = new Node(b, nodes[a]);
		}
		
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		boolean[] visited = new boolean[N+1];
		for(int i = 1; i < N + 1; i++) {
			if(degree[i] == 0) {
				pq.add(i);
				visited[i] = true;
			}
		}
		
		
		while(!pq.isEmpty()) {
			int n =  pq.poll();
			sb.append(n).append(" ");
			
			for(Node node = nodes[n]; node.next != null; node = node.next) {
				
				if(visited[node.n]) continue;
				degree[node.n]--;
				
				if(degree[node.n] == 0) {
					visited[node.n] = true;
					pq.offer(node.n);
				}
			}
		}
		/*---------------출력----------------*/
		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
}
