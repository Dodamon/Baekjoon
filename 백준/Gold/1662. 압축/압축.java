import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> stackK = new Stack<>();
        stack.push(0);

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                stack.push(stack.pop()+1);
            } else if (s.charAt(i) == '(') {
                stack.push(0);
                stackK.push(s.charAt(i-1)-'0');
            } else {
                int q = stack.pop();
                int k = stackK.pop();
                stack.push(stack.pop()-1 + k*q);
            }
        }

        int answer = stack.pop();
        bw.flush();
        bw.write(answer + "");
        bw.close();
    }
}
