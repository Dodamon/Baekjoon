import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static class Grade implements Comparable<Grade>{
        private int a;
        private int b;

        public Grade(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public int compareTo(Grade o) {
            if (this.a == o.a) return this.b - o.b;
            return this.a - o.a;
        }
    }
    public static int recruit(int N, List<Grade> list) {
        Collections.sort(list);
        int count = 1;
        int cmp = list.get(0).b;
        
        // 현재 i 번째 신입사원은 i-1 번째 신입사원보다 1차 서류 순위가 낮다.
        // 현재 i 번째 신입사원이 이전 사람들의 2차 서류의 최대순위보다 더 낮은 순위를 가진다면
        // 그 신입사원을 뽑는다
        for (int i = 1; i < N; i++) {
            if (list.get(i).b < cmp) {
                count += 1;
                cmp = cmp > list.get(i).b ? list.get(i).b : cmp;
            }
        }
        return count;
    }
    public static void main(String[] args) throws IOException {


        Scanner sc = new Scanner(System.in);
        StringBuffer sb = new StringBuffer();

        int T = sc.nextInt();

        for(;T>0; T--) {
            int N = sc.nextInt();
            List<Grade> list = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                list.add(new Grade(sc.nextInt(), sc.nextInt()));
            }
            sb.append(recruit(N, list));
            sb.append("\n");

        }
        System.out.println(sb.toString());
    }
}