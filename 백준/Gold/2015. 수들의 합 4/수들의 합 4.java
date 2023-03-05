import java.io.*;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int K = Integer.parseInt(inputs[1]);
        long answer = 0;

        inputs = br.readLine().split(" ");
        int[] S = new int[N + 1];
        HashMap<Integer, Long> hashMap = new HashMap<>();

        S[0] = 0;
        for(int i = 1; i <= N; i++) {
            S[i] = S[i-1] + Integer.parseInt(inputs[i - 1]);
            answer += (hashMap.containsKey(S[i]-K))? hashMap.get(S[i]- K): 0;

            if(hashMap.containsKey(S[i])) {
                hashMap.put(S[i], hashMap.get(S[i]) + 1);
            } else {
                hashMap.put(S[i], 1L);
            }
        }

        answer += hashMap.containsKey(K)? hashMap.get(K) : 0;

        bw.write(answer + "");
        bw.flush();
        br.close();
        bw.close();
    }
}
