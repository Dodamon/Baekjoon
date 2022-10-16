import java.io.*;
import java.util.*;

public class Main {
    static int totalB, totalW;
    static int N, M;
    static char[][] map;
    static class Pos {
        int y, x;

        public Pos(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    public static void bfs(int y, int x, boolean[][] visited){
        Queue<Pos> queue = new ArrayDeque<Pos>();
        queue.add(new Pos(y, x));
        visited[y][x] = true;
        char team = map[y][x];

        int[] dy = new int[]{0, 0, -1, 1};
        int[] dx = new int[]{-1, 1, 0, 0};

        int cnt = 1;
        while(!queue.isEmpty()){
            Pos p = queue.poll();
            y = p.y;
            x = p.x;
            for(int i = 0; i < 4; i++){
                int ny = y + dy[i];
                int nx = x + dx[i];

                if(ny < 0 || ny >= M || nx < 0 || nx >= N || map[ny][nx] != team || visited[ny][nx]) continue;

                visited[ny][nx] = true;
                queue.add(new Pos(ny, nx));
                cnt++;
            }
        }

        if(team == 'B'){
            totalB += cnt * cnt;
        } else {
            totalW += cnt * cnt;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuffer sb = new StringBuffer();

        String[] inputs = br.readLine().split(" ");
        N = Integer.parseInt(inputs[0]); // 가로
        M = Integer.parseInt(inputs[1]); // 세로
        map = new char[M][N];
        boolean[][] visited = new boolean[M][N];
        totalW = 0;
        totalB = 0;

        for(int i = 0; i < M; i++){
            String inputs2 = br.readLine();
            for(int j = 0; j < N; j++){
                map[i][j] = inputs2.charAt(j);
            }
        }

        for(int i = 0; i < M; i++){
            for(int j = 0; j < N; j++){
               if(!visited[i][j]){
                   bfs(i, j, visited);
               }
            }
        }

        bw.write(totalW + " " + totalB);
        bw.flush();
        br.close();
        bw.close();
    }
}
