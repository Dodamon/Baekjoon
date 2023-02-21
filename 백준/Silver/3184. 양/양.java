import java.util.*;
import java.io.*;

public class Main {
    static int R, C;
    static int V = 0;
    static int O = 0;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static char[][] map;

    static class Pair {
        private int y;
        private int x;

        public Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static void bfs(int y, int x) {

        int v = 0;
        int o = 0;

        Pair p = new Pair(y, x);
        Queue<Pair> queue = new LinkedList<>();
        if(map[y][x] == 'o') {
            o++;
        } else if(map[y][x] == 'v') {
            v++;
        }
        map[y][x] = '#';
        queue.add(p);

        while (!queue.isEmpty()) {
            p = queue.poll();
            y = p.y;
            x = p.x;

            for(int i = 0; i < 4; i++){
                int ny = y + dy[i];
                int nx = x + dx[i];

                if(ny < 0 || ny >= R || nx < 0 || nx >= C || map[ny][nx] == '#')
                    continue;

                if(map[ny][nx] == 'o') {
                    o++;
                } else if(map[ny][nx] == 'v') {
                    v++;
                }
                map[ny][nx] = '#';
                queue.add(new Pair(ny, nx));
            }
        }

        if(o > v) {
            O += o;
        } else {
            V += v;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] inputs = br.readLine().split(" ");
        R = Integer.parseInt(inputs[0]);
        C = Integer.parseInt(inputs[1]);

        map = new char[R][C];

        for(int y = 0; y < R; y++){
            String input = br.readLine();
            for(int x = 0; x < C; x++){
                map[y][x] = input.charAt(x);
            }
        }

        for(int y = 0; y < R; y++) {
            for(int x = 0; x < C; x++) {
                if(map[y][x] != '#') {
                    bfs(y, x);
                }
            }
        }

        bw.write(O + " " + V);
        br.close();
        bw.close();
    }
}
