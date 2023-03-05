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
        // answer과 count가 long이어야 하는 이유 최대 N * (N+1)/2 이기 때문이다ㅠ long 주의 하자!!
        
        inputs = br.readLine().split(" ");
        int[] S = new int[N + 1];
        HashMap<Integer, Long> hashMap = new HashMap<>();
        
        // 누적합
        S[0] = 0;
        for(int i = 1; i <= N; i++) {
            S[i] = S[i-1] + Integer.parseInt(inputs[i - 1]);
            // 이전 누적합중에 S[i] - S[j] = K를 만족시키는 S[j]가 있었다면 그 갯수를 더해준다
            answer += (hashMap.containsKey(S[i]-K))? hashMap.get(S[i]- K): 0;
            
            // Hashmap에 누적합을 key로 그 갯수를 value해서 저장한다
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
