import java.io.*;
import java.util.*;

public class Main {
    
    static int n, m;
    static int[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static class Pair {
        int y, x;

        public Pair(int y, int x) {
            this.y = y;
            this.x = x;

        }
    }

    public static int BFS(int y, int x) {
        
        map[y][x] = 0;
        int cnt = 1;
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(y, x));
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            y = pair.y;
            x = pair.x;
            for(int i = 0; i < 4; i++){
                int ny = y + dy[i];
                int nx = x + dx[i];

                if(ny < 0 || ny >= n || nx < 0 || nx >= m || map[ny][nx] == 0) continue;

                queue.add(new Pair(ny, nx));
                map[ny][nx] = 0;
                cnt++;

            }
        }

        return cnt;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] inputs = br.readLine().split(" ");

        n = Integer.parseInt(inputs[0]);
        m = Integer.parseInt(inputs[1]);
        map = new int[n][m];
        
        for(int i = 0; i < n ; i++) {
            inputs = br.readLine().split(" ");
            for(int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(inputs[j]);
            }
        }
        
        int resultMax = 0;
        int resultTemp = 0;
        int cnt = 0;

        for(int i = 0; i < n ; i++) {
            for(int j = 0; j < m; j++) {
                if(map[i][j] == 1) {
                    resultTemp = BFS(i, j);
                    resultMax = resultTemp > resultMax ? resultTemp: resultMax;
                    cnt++;            
                }
            }
        }
        
        bw.write(cnt + "\n" + resultMax);
        bw.flush();
        br.close();
        bw.close();

    }
}
