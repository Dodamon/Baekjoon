import java.util.*;

class Solution {
    public int[] solution(String[] maps) {
        int n = maps.length;
        int m = maps[0].length();
        boolean[][] visited = new boolean[n][m];
        List<Integer> answer = new ArrayList<>();

        // maps를 for 문을 돌서면 방문한다
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < m; x++){
                // 이벽 아니고 방문한 적이 없을때 방문한다
                if (maps[y].charAt(x) != 'X' && !visited[y][x]) {
                    answer.add(bfs(y, x, visited, maps));
                }
            }
        }

        // 비어있다는 것은 갈수 잇는 무인도가 없다는 것을 뜻한다
        if (answer.isEmpty()){
            answer.add(-1);
        } else {
            Collections.sort(answer);
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }
    
    public int bfs(int y, int x, boolean[][] visited, String[] maps) {
        int[] dy = {-1, 1, 0, 0};
        int[] dx = {0, 0, -1, 1};
        int days = 0; // 무인도에 총 몇일 있을 수 있는지 counting 하는 변수
        int n = maps.length;
        int m = maps[0].length();

        // 큐와 visited를 사용해서 방문한 노드를 방문체크를 한다.
        Queue<Pos> queue = new LinkedList<Pos>();
        queue.add(new Pos(x, y));
        visited[y][x] = true;

        // 큐가 비었다는 건 더이상 방문할 노드가 없다는 걸 의미한다
        // 큐가 있을 동안 탐색을 계속한다
        while (!queue.isEmpty()) {
            Pos p = queue.poll();
            days += maps[p.y].charAt(p.x) - '0';
            // 진짜 노드를 방문했을때
            // 큐에서 뺄때 days의 값을 계속 더해준다

            // 다음 방문할 노드를 넣기 위해 4방향을 탐색한다
            for(int i = 0; i < 4; i++) {
                int ny = p.y + dy[i];
                int nx = p.x + dx[i];

                // 범위가 넘어가거나 방문한 적이 있거나 벽일때는 다음 방향으로 넘어간다
                if (ny < 0 || ny >= n || nx < 0 || nx >= m || visited[ny][nx] || maps[ny].charAt(nx) == 'X') {
                    continue;
                }

                // 다음 방문할 노드를 큐에 넣어준다
                queue.add(new Pos(nx, ny));
                // 큐에 똑같은 노드가 들어가지 않도록 방문 체크를 해준다
                visited[ny][nx] = true;
            }
        }
        return days;
    }
    
    class Pos {
        int x;
        int y;
        public Pos(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    
}