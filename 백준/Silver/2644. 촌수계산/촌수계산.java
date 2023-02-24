import java.io.*;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static List<List<Integer>> list;

    public static int dfs(boolean[] visited, int cur, int target, int level) {

        if( cur == target) {
            return level;
        }

        int result = 0;
        for(int next : list.get(cur)) {
            if(visited[next]) continue;

            visited[next] = true;
            result = dfs(visited, next, target, level + 1);
            if(result != -1) return result;
            visited[next] = false;

        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        boolean[] visited = new boolean[n+1];

        list = new ArrayList<>();
        for(int i = 0; i < n + 1 ; i++) {
            list.add(new ArrayList<>());
        }
        String[] inputs = br.readLine().split(" ");
        int p = Integer.parseInt(inputs[0]);
        int q = Integer.parseInt(inputs[1]);
        int m = Integer.parseInt(br.readLine());

        for(int i = 0; i < m; i++) {

            inputs = br.readLine().split(" ");
            int x = Integer.parseInt(inputs[0]);
            int y = Integer.parseInt(inputs[1]);
            list.get(x).add(y);
            list.get(y).add(x);
        }
        int result = dfs(visited, p, q, 0);

        bw.write(result + "");
        bw.flush();
        br.close();
        bw.close();
    }
}
