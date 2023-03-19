import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuffer sb = new StringBuffer();

        int N = Integer.parseInt(br.readLine());
        String[] inputs = br.readLine().split(" ");
        int[] arr = new int[N];

        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(inputs[i]);
        }

        int maxIndex = N;
        boolean[] visited = new boolean[N + 1];
        // next_permutation
        // 오른쪽에서 왼쪽으로 탐색
        for(int i = N-1; i > 0 ; i--) {

            if(arr[i-1] > arr[i]) continue;

            // 오른쪽 부터 탐색 할때 오름차순이면 계속
            // 오른쪽 부터 탐색 할대 내림차순이 나타나면 분기

            // 오른 쪽부터 탐색 하면서 arr[i-1] 보다 큰 수를 찾는다
            for(int j = N-1; j > i-1; j--){
                if(arr[i-1] < arr[j]) {
                    maxIndex = j;
                    break;
                }
            }

            if(maxIndex != N) {
                // swap 연산
                int temp = arr[i-1];
                arr[i-1] = arr[maxIndex];
                arr[maxIndex] = temp;

                // 0 ~ i-1 끼지 arr를 sb에 넣는다
                for(int k = 0; k < i; k++){
                    sb.append(arr[k]).append(" ");
                    visited[arr[k]] = true;
                }

                // i ~ N-1 끼지 reverse 해서 sb에 넣느다
                for(int k = 1; k <= N; k++){
                    if(!visited[k]){
                        sb.append(k).append(" ");
                    }
                }
            }
            break;
        }

        if(maxIndex == N) {
            sb.append(-1);
        }

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
}
