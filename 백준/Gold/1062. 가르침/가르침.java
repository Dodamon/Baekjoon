import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
 
public class Main {
 
    static int N, K;
    static int max = Integer.MIN_VALUE;
    static boolean[] visited;
    static String[] word;
    
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    	String[] inputs = br.readLine().split(" ");
        N = Integer.parseInt(inputs[0]); // N개의 단어
        K = Integer.parseInt(inputs[1]); // K개의 글자를 가르칠 수 있다
        
        
        word = new String[N];
        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            str = str.replace("anta", "");
            str = str.replace("tica", "");
            word[i] = str;
        }
        
        int result = 0;
        if(K < 5) { //a c i n t의 개수가 5개이므로
        	result = 0;
        } else if(K == 26) { //모든 알파벳을 다 읽을 수 있다.
            result = N;
        } else {
        
	        visited = new boolean[26]; //각 알파벳을 배웠는지 체크
	        visited['a' - 'a'] = true;
	        visited['c' - 'a'] = true;
	        visited['i' - 'a'] = true;
	        visited['n' - 'a'] = true;
	        visited['t' - 'a'] = true;
	        
	        backtracking(0, 0);
	        result = max;
        }
        
        bw.write(result + "");
        bw.flush();
        br.close();
        bw.close();
    }
    
    public static void backtracking(int alpha, int len) {
        if(len == K- 5) { // 가르칠수 있는 글자를 다 가르쳤다면
            int count = 0;
            
            for(int i = 0; i < N; i++) { // N개의 단어중에 읽을 수 있는 단어를 찾는다
                boolean read = true;
                for(int j = 0; j < word[i].length(); j++) {
                    if(!visited[word[i].charAt(j) - 'a']) {
                        read = false;
                        break;
                    }
                }
                if(read) count++;
            }
            max = Math.max(max, count); // 가장 많이 읽을 수 있는 단어을 갱신한다
            return;
        }
        
        
        // 아직 가르칠 수 있는 글자가 남았다면
        for(int i = alpha; i < 26; i++) {
            if(visited[i] == false) { 
                visited[i] = true; // 그 글자를 배우거나
                backtracking(i, len + 1);
                visited[i] = false; // 그 글자를 배우지 않거나
            }
        }
    }
}
