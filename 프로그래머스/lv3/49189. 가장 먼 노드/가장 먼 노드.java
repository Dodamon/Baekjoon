import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>(); 
        // 인접리스트 형태로 저장

		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<>()); // 인접리스트 초기화
		}

		for (int i = 0; i < edge.length; i++) {
			int n1 = edge[i][0];
			int n2 = edge[i][1];

			graph.get(n1).add(n2);
			graph.get(n2).add(n1);
		}

		Queue<Integer> queue = new LinkedList<>();
		boolean[] visited = new boolean[n + 1];
		queue.offer(1);
		visited[1] = true;

		while (true) {
			answer = queue.size();
			Queue<Integer> queue2 = new LinkedList<>();
			while (!queue.isEmpty()) {

				int node = queue.poll();

				for (int next : graph.get(node)) {
					if (visited[next])
						continue;

					queue2.offer(next);
					visited[next] = true;
				}
			}
			queue = queue2;
			
			if(queue.isEmpty()) break;
		}

		return answer;
    }
}