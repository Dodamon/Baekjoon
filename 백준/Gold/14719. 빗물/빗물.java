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

        while(left < right){
            left_max = left_max < height[left] ? height[left] : left_max;
            right_max = right_max < height[right] ? height[right] : right_max;

            if(left_max <= right_max){
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
