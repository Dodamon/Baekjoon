import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] inputs = br.readLine().split(" ");

        long x = Long.parseLong(inputs[0]);
        long y = Long.parseLong(inputs[1]);
        long w = Long.parseLong(inputs[2]); // 직선이동
        long s = Long.parseLong(inputs[3]); // 대각선이동


        long max = x < y ? y : x; // y, x 중 큰값을 저장
        long min = x < y ? x : y; // x, y 중 작은 값을 저장

        long line = x + y; // 직선으로 이동하는 횟수
        long cross = 0L; // 대각선으로 이동하는 횟수

        long result = line * w;// 초기값 직선만 이동 할때
        long temp = 0L; // 중간 결과값을 저장하는 변수

        while (line >= 2) { // 직선으로 갈수 있는 횟수가 2번이상 남았을때
            if(min == 0) { // 2번 대각선 이동만
                max -= 2;
                cross += 2;
            } else { // 1번 대각선 이동
                min--;
                max--;
                cross++;
            }

            line -= 2;
            temp = cross * s + line * w;
            if(temp > result) break; // 이전 구한 값보다 작아지지 않을때 반복문을 멈춘다.

            result = temp; // 새로운 최소값 갱신
        }

        bw.flush();
        bw.write(result + "");
        br.close();
        bw.close();

    }
}
