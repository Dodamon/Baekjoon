import java.io.*;
import java.util.PriorityQueue;

public class Main {
    static class Stock implements Comparable<Stock> {

        int val, order;
        public Stock(int val, int order){
            this.val = val;
            this.order = order;
        }
        @Override
        public int compareTo(Stock o) {
            if(this.val == o.val)
                return this.order - o.order;
            return o.val - this.val;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuffer sb = new StringBuffer();

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];

            String[] inputs = br.readLine().split(" "); // 주식의 가격을 순서대로 저장할 배열
            PriorityQueue<Stock> pq = new PriorityQueue<>(); // 주식의 가격을 가격이 큰 순서대로 우선순위 큐에 저장한다

            for(int i = 0; i < N; i++){
                arr[i] = Integer.parseInt(inputs[i]);
                pq.add(new Stock(arr[i], i));
            }

            Stock s = pq.poll();
            long sum = 0;
            for(int i = 0; i < N; i ++){

                while(!pq.isEmpty() && s.order <= i){
                    s = pq.poll();
                }

                // 현재 순서보다 뒤에 잇는 가장 큰 값보다 작으면
                // 3. 현재 순서보다 뒤에있는 가장큰 값보다 작으면 아무것도 하지 않는다.
                if(s.order <= i || s.val <= arr[i]) continue;
                // 2. 주식을 사고 나중에 최대로 팔수 얻을 수 있는 이익을 더한다
                sum += s.val - arr[i];
            }
            sb.append(sum).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
}
