import java.io.*;
import java.util.*;

public class Main {

    static boolean isChanged;
    public static class Pos {
        int y, x;
        public Pos(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    public static char[][] bfs(char[][] map, boolean[][] visited, int y, int x){

        int[] dy = {-1, 1, 0, 0};
        int[] dx = {0, 0, -1, 1};
        Queue<Pos> queue = new ArrayDeque<>();
        Queue<Pos> path = new ArrayDeque<>();

        visited[y][x] = true;
        path.add(new Pos(y, x));
        queue.add(new Pos(y, x));

        int cnt = 1;
        while (!queue.isEmpty()){
            Pos p = queue.poll();
            y = p.y;
            x = p.x;
            char c = map[y][x];

            for(int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                if (ny < 0 || ny >= 12 || nx < 0 || nx >= 6 || visited[ny][nx] || map[ny][nx] != c) continue;

                visited[ny][nx] = true;
                queue.add(new Pos(ny, nx));
                path.add(new Pos(ny, nx));
                cnt++;
            }
        }

        if(cnt >= 4) {
            isChanged = true;
            while(!path.isEmpty()){
                Pos p = path.poll();
                y = p.y;
                x = p.x;
                map[y][x] = '.';
            }
        }

        return map;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 곤듀님 화이팅
        // 우윳빛깔 곤듀님

        char[][] map = new char[12][6];
        for (int i = 0; i < 12; i++) {
            String inputs = br.readLine();
            for (int j = 0; j < 6; j++) {
                map[i][j] = inputs.charAt(j);
            }
        }

        int count = 0;
        while(true){

            isChanged = false;

            // step 1: 4개 이상 연결되어 있으면 터진다
            boolean[][] visited = new boolean[12][6];
            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 6; j++) {
                   if(map[i][j] == '.' || visited[i][j]) continue;
                   map = bfs(map, visited, i, j);
                }
            }
            //System.out.println(Arrays.deepToString(map));
            //System.out.println(isChanged);
            if(!isChanged) break;

            // step 2: 뿌요뿌요가 아래로 내려간다
            for(int x = 0; x < 6; x++){
                int idx = 11;
                for(int y = 11; y > -1; y--){
                    if(map[y][x] != '.') {
                        map[idx--][x] = map[y][x];
                    }
                }
                for(int y = idx; y > -1; y--) {
                    map[y][x] = '.';
                }
            }
            count++;

        }

        bw.write(count + "");
        bw.flush();
        br.close();
        bw.close();
    }
}


