import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {

	
	public static class Node implements Comparable<Node> {
		int y, x, cost, d;

		public Node(int y, int x, int d, int cost) {
			this.y = y;
			this.x = x;
			this.d = d;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			if(this.cost == o.cost) {
				if(this.y == o.y) {
					return o.x - this.x;
				}
				return o.y - this.y;
			}
			return this.cost - o.cost;
		}
		
	}

	public static int solution(int[][] board) {
		int N = board.length;
		int[][][] visited = new int[4][N][N];
		int answer = 0;
		int[] dy = { 1, 0, -1, 0 };
		int[] dx = { 0, 1, 0, -1 };
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
      
		pq.offer(new Node(0, 0, -1, 0));
		
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			
			if(node.y == N-1 && node.x == N-1) {
				answer = node.cost;
				break;
			}
            
			
			for(int i = 0; i < 4; i++) {
				int ny = node.y + dy[i];
				int nx = node.x + dx[i];
				int nd = i;
				int ncost = node.cost;
				
				if(node.d == -1) {
					ncost += 100;
				} else {
					ncost += node.d == nd ? 100 : 600;
				}
				
				if(ny < 0 || ny >= N || nx < 0 || nx >= N || board[ny][nx] == 1) continue;
                if(visited[nd][ny][nx] != 0 && visited[nd][ny][nx] < ncost) continue;
                
				visited[nd][ny][nx] = ncost;
				pq.offer(new Node(ny, nx, nd, ncost));
			}
		}

		return answer;
	}


}
