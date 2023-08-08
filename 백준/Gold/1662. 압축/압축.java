import java.io.*;
import java.util.Stack;

// 괄호 문제의 심화버전 인거같다..
// stack안에는 문자열의 길이가 저장되고
// stackK에는 (앞에오는 K들이 저장된다
// for문을 통해 탐색하면서 3가지 경우에 따라 각각 처리한다
// 1. 숫자일경우 - stack에서 pop해서 이전에 카운트했던 문자열의 길이에 1을 더해준다
// 2. (  일경우 - stack에 0을 넣어서 그 시점을 기준으로 문자열 길이를 다시 카운트 하도록한다
// 3. )  일경우 - stack에서 앞에 카운트했던 문자열 -1 + K*(Q의 길이)를 계산한뒤 다시 push해준다
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
