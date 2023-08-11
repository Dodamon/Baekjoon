import java.util.*;

public class Main {

    public static class Storage implements Comparable<Storage>{
        private int x;
        private int y;

        public Storage(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Storage o) {
            if (this.x == o.x) {
                return this.y - o.y;
            }
            return this.x - o.x;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        List<Storage> storages = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            storages.add(new Storage(sc.nextInt(), sc.nextInt()));
        }
        Collections.sort(storages);

        int left = 0;
        int right = N-1;
        Storage leftMax = new Storage(0, 0);
        Storage rightMax = new Storage(0, 0);

        int answer = 0;
        // 윈두우 슬라이딩 처럼 left <= right 일때까지 반복한다
        // 가장 큰 저장소를 기준으로 left, right가 중앙으로 모인다
        while (left <= right) {
            if (leftMax.y <= storages.get(left).y){
                answer += leftMax.y * (storages.get(left).x - leftMax.x);
                leftMax.y = storages.get(left).y;
                leftMax.x = storages.get(left).x;
            }

            if (rightMax.y <= storages.get(right).y) {
                answer += rightMax.y * (rightMax.x - storages.get(right).x);
                rightMax.y = storages.get(right).y;
                rightMax.x = storages.get(right).x;
            }

            if (storages.get(left).y < storages.get(right).y) {
                left++;
            } else {
                right--;
            }
        }

        answer += storages.get(left).y;
        System.out.println(answer);
    }
}
