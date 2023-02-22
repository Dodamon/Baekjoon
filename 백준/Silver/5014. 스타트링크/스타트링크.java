import java.io.*;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Main {

    static int F, S, G;
    static int[] dy = new int[2];
    static class Node {
        private int y;
        private int cnt;

        public Node(int y, int cnt) {
            this.y = y;
            this.cnt = cnt;
        }
    }

    public static int bfs(int s) {

        Queue<Node> queue = new LinkedList<>();
        HashSet<Integer> set = new HashSet<>();
        set.add(s);
        queue.add(new Node(s, 0));

        if(s == G) return 0;

        while(!queue.isEmpty()) {
            Node node = queue.poll();
            int y = node.y;
            int cnt = node.cnt;

            for(int i = 0; i < 2; i++) {
                int ny = y + dy[i];
                if(ny == G) return cnt + 1;

                if(ny < 1 || ny > F || set.contains(ny))
                    continue;
                set.add(ny);
                queue.add(new Node(ny, cnt + 1));
            }
        }
        return -1;
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] inputs = br.readLine().split(" ");

        F = Integer.parseInt(inputs[0]); // 총
        S = Integer.parseInt(inputs[1]); // 현재
        G = Integer.parseInt(inputs[2]); // 스타트링크
        dy[0] = Integer.parseInt(inputs[3]);
        dy[1] = Integer.parseInt(inputs[4]) * -1;

        // S + Ux + Dy = G
        // 1보다 크고 F보다 같거나 작을 동안
        int temp = bfs(S);
        String result = bfs(S) == -1 ? "use the stairs" : temp + "";
        bw.write(result);
        bw.flush();
        br.close();
        bw.close();

    }
}
