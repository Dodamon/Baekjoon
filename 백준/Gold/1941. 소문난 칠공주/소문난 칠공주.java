import java.io.*;
import java.util.*;

public class Main {

    static int count, last_y, last_x;
    static boolean[][] visited;
    static char[][] map;
    static long z = 0;

    public static class Pos {
        int y, x;

        public Pos(int y, int x){
            this.y = y;
            this.x = x;
        }
    }

    public static void comb(int idx, int cnt, int s) {
        int x = idx % 5;
        int y = idx / 5;

        if(cnt - s >= 4) return;

        if(cnt == 7){
            z++;
            idx--;
            x = idx % 5;
            y = idx / 5;
            if(s >= 4 && isConnected(y, x)) {
                count++;
            }
            return;
        }


        for(int i = idx; i < 25; i++){
            //idx = 4
            // i = 9
            x = i % 5;
            y = i / 5;

            visited[y][x] = true;
            if(map[y][x] == 'S') {
                comb(i + 1, cnt + 1, s + 1);
            } else {
                comb(i + 1, cnt + 1, s);
            }
            visited[y][x] = false;

        }
    }
    public static boolean isConnected(int y, int x) {
        int[] dy = {-1, 1, 0, 0};
        int[] dx = {0, 0, -1, 1};
        Queue<Pos> queue = new ArrayDeque<>();
        boolean[][] checked = new boolean[5][5];

        //System.out.println("here");
        queue.add(new Pos(y, x));
        checked[y][x] = true;
        int cnt = 1;

        while(!queue.isEmpty()) {
            Pos p = queue.poll();
            y = p.y;
            x = p.x;

            for(int i = 0; i < 4; i++){
                int ny = y + dy[i];
                int nx = x + dx[i];

                if(ny < 0 || ny >= 5 || nx < 0 || nx >= 5 ) continue;

                if(!checked[ny][nx] && visited[ny][nx]) {
                    checked[ny][nx] = true;
                    queue.add(new Pos(ny, nx));
                    cnt++;
                }
            }
        }

        boolean result = cnt == 7 ? true : false;

        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        map = new char[5][5];


        for(int i = 0; i < 5; i++){
            String inputs = br.readLine();
            for(int j = 0; j < 5; j++){
                map[i][j] = inputs.charAt(j);
            }
        }
        //System.out.println(Arrays.deepToString(map));

        //step 1:  7개명 학생을 고른다
        //step 2 : 연결되어 있는지 확인한다
        visited = new boolean[5][5];
        comb(0,0, 0);
        //System.out.println(z);
        bw.write(count + "");
        bw.flush();
        br.close();
        bw.close();
    }
}


