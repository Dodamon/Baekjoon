import java.io.*;
import java.util.*;

public class Main {
    //투포인터
    //시간복잡도 O(N)
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] inputs= br.readLine().split(" ");

        int N = Integer.parseInt(inputs[0]);
        int M = Integer.parseInt(inputs[1]);
        inputs= br.readLine().split(" ");

        int[] height = new int[M];
        for(int i = 0; i < M; i++){
            height[i] = Integer.parseInt(inputs[i]);
        }

        Stack<Integer> stack = new Stack<Integer>();
        int total = 0;
        int left = 0, right = M-1;
        int left_max = height[left];
        int right_max = height[right];
        
        // 최대 높은 블럭은 전체 물의 부피에 영향을 주지 않고 왼쪽과 오른쪽을 가르는 역할을한다
        // 왼쪽 포인터와 오른쪽 포인터가 최고 높은 블럭을 만나러 가운데로 올때까지
        // 각각 좌우 기둘 최대 높이 left_max, right_max와 현재 높이의 차이 만큼 물높이를 더해주면된다
        while(left < right){
            left_max = left_max < height[left] ? height[left] : left_max;
            right_max = right_max < height[right] ? height[right] : right_max;

            if(left_max <= right_max){ // 더높은 쪽을 향해 투 포인터가 움직인다.
                total += left_max - height[left];
                left += 1;
            } else {
                total += right_max - height[right];
                right -= 1;
            }
        }

        bw.write(total + "");
        bw.flush();
        br.close();
        bw.close();
    }
}


