import java.io.*;
import java.util.*;

public class Main {

    static class Convey {
        boolean isRobot;
        int val;

        public Convey(Boolean isRobot, int val) {
            this.isRobot = isRobot;
            this.val = val;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuffer sb = new StringBuffer();

        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int N2 =N*2;
        int K = Integer.parseInt(inputs[1]);

        Deque<Convey> deque_top = new ArrayDeque<Convey>();
        Deque<Convey> deque_down = new ArrayDeque<Convey>();

        inputs = br.readLine().split(" ");
        for(int i = 0; i < N; i++){
            int val = Integer.parseInt(inputs[i]);
            deque_top.addLast(new Convey(false, val));
        }

        for(int i = 0; i < N; i++){
            int val = Integer.parseInt(inputs[i+N]);
            deque_down.addFirst(new Convey(false, val));
        }

        int step = 1;
        int cnt_zero = 0;
        while(true){
            //Step 1: 회전한다
            Convey c = deque_top.pollLast();
            deque_down.addLast(c);
            c = deque_down.pollFirst();
            deque_top.addFirst(c);
            c=deque_top.peekLast();
            if(c.isRobot){ // N자리에 로봇이 있을 경우 로봇을 내린다
                c.isRobot = false;
            }

            //Step 2: 로봇이 이동한다;
            Convey rc = deque_top.pollLast();
            Convey lc = null;
            for(int i = 0; i < N-1; i++) {
                lc = deque_top.pollLast();
                //System.out.println(i);

                if(!rc.isRobot && lc.isRobot && rc.val >= 1) { // right의 컨베이어 벨트에 로봇이 없고 내구성이 1보다 이상일 경우만 로봇을 둘수 잇다
                    rc.val--;
                    rc.isRobot = true;
                    lc.isRobot = false;
                    if (rc.val == 0) {
                        cnt_zero++;
                    }
                }
                deque_top.addFirst(rc);
                rc = lc;
            }
            deque_top.addFirst(rc);
            c=deque_top.peekLast();
            if(c.isRobot){ // N자리에 로봇이 있을 경우 로봇을 내린다
                c.isRobot = false;
            }

            //Step 3: 로봇을 올린다
            c = deque_top.peekFirst();
            if(c.val >= 1){
                c.val--;
                c.isRobot = true;
                if(c.val == 0){
                    cnt_zero++;
                }
            }

            // Step 4: 내구도가 0개인 칸의 갯수가 K 이상의면 과정을 종룔한다
            if(cnt_zero >= K)
                break;

            step++;
        }


        bw.write(step + "");
        bw.flush();
        br.close();
        bw.close();
    }
}
