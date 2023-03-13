import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static class Pair {
        private int y;
        private int x;

        public Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];

        for(int i = 0; i < N; i++) {
            String[] inputs = br.readLine().split(" ");
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(inputs[j]);
            }
        }

        long[][] dp = new long[N][N];
        dp[0][0] = 1L;

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(0, 0));
        int y, x, v;
        int[] dy = {1, 0};
        int[] dx = {0, 1};

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                v = map[i][j];

                if(dp[i][j] == 0) continue;

                for(int k = 0; k < 2; k++) {
                    int ny = i + dy[k] * v;
                    int nx = j + dx[k] * v;

                    if (ny < 0 || ny >= N || nx < 0 || nx >= N) {
                        continue;
                    }
                    if(ny == i && nx == j) {
                        continue;
                    }
                    dp[ny][nx] += dp[i][j];
                }
            }
        }

//
//        while(!queue.isEmpty()) {
//            Pair p = queue.poll();
//            y = p.y;
//            x = p.x;
//            v = map[y][x];
//
//            for(int i = 0; i < 2; i++) {
//                int ny = y + dy[i] * v;
//                int nx = x + dx[i] * v;
//
//                if(ny < 0 || ny >= N || nx < 0 || nx >= N ){
//                    continue;
//                }
//                dp[ny][nx] += dp[y][x];
//
//                if(ny == N-1 && nx == N-1) {
//                    continue;
//                }
//
//                queue.add(new Pair(ny, nx));
//            }
//        }
//        System.out.println(Arrays.deepToString(dp));
        bw.write(dp[N-1][N-1] + "");
        bw.flush();
        br.close();
        bw.close();

    }
}
