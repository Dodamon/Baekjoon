import java.io.*;
import java.util.*;

public class Main {
    public static int isPalindrome(String[] str, int left, int right, int cnt){
        if(left >= right) return cnt;
        if(cnt > 1) return 2;

        while(left < right){
            if(str[left].equals(str[right])){
                left++;
                right--;
            } else {
                int result = 2;
                if (left + 1 < right && str[left + 1].equals(str[right])) {
                    int temp = isPalindrome(str, left + 2, right - 1, cnt + 1);
                    result = result > temp ? temp : result;
                }
                if (right - 1 > left && str[right - 1].equals(str[left])) {
                    int temp = isPalindrome(str, left + 1, right - 2, cnt + 1);
                    result = result > temp ? temp : result;
                }
                return result;
            }
        }
        return cnt;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuffer sb = new StringBuffer();

        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++){
            String[] str = br.readLine().split("");
            int result = isPalindrome(str, 0, str.length-1, 0);
            sb.append(result).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
}


