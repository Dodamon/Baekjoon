 import java.util.*;

class Solution {
    ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
   
    public int bfs(int n, int start, int except) {
        boolean[] visited = new boolean[n+1];
        Queue<Integer> queue = new LinkedList<Integer>();
        // 처음 시작하는 하는 노드는 이미 방문했다고 가정한다
        int count = 1;
        visited[start] = true;
        
        // 시작하는 노드에서 갈수있는 노드중 except node만 빼고 다 큐에 push한다
        for (int i = 0; i < graph.get(start).size(); i++) {
            int node = graph.get(start).get(i);
            if (node != except) {
                queue.add(node);
                visited[node] = true;
            }
        }
        
        // bfs 탐색을 시작한다
        while (!queue.isEmpty()) {
            int node = queue.poll();
            count++;
            for (int i = 0; i < graph.get(node).size(); i++) {
                int next_node = graph.get(node).get(i);
                
                if (!visited[next_node]) {
                    queue.add(next_node);
                    visited[next_node] = true;
                }
            }
        }

        return count;
    }
    public int solution(int n, int[][] wires) {
        int answer = 1001;
        
        // 인접리스트를 만들기 위해서 선언하고 할당한다
        // 노드 종류는 1 ~ n+1
        // wires의 길이는 n-1개가 있다
        for (int i = 0; i < n+1; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < n-1; i++){
            int v1 = wires[i][0];
            int v2 = wires[i][1];
            graph.get(v1).add(v2);
            graph.get(v2).add(v1);
        }
        System.out.println(graph);
        // v1과 v2의 연결을 끊어 가면서 탐색을 시작한다
        // 큐에 넣을때 v2를 넣지 않는다
        for (int i = 0; i < n-1; i++) {
            int v1 = wires[i][0];
            int v2 = wires[i][1];
            // v1만 방문하면 끊어진 v2에 연결된 노드의 수를 알 수 있다
            // 트리 형태이기 때문에 무조건 다른 노드들은 연결되어있고
            // v1에서 v2로 가는 길은 유일한다
            int count = bfs(n, v1, v2);
            int diff = Math.abs((n - count) - count);
            answer = answer > diff? diff: answer;
        }
        return answer;
    }
}