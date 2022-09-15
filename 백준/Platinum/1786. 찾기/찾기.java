import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
	
	static int count;
	static StringBuilder sb = new StringBuilder();
	
	static int[] makeTable(String P) {
		int n = P.length();
		int[] table = new int[n];
		
		int idx=0;//prefix에서 일치하는 글자수
		for(int i=1; i < n; i++) {
			
			//연속적으로 더 일치하지 않으면 idx = table[idx-1]을 돌려준다
			while(idx > 0 && P.charAt(i) != P.charAt(idx)) {
				idx = table[idx-1];
			}
			
			if(P.charAt(i) == P.charAt(idx)) {
				idx += 1;
				table[i] = idx;
			}
		}
		return table;	
	}
	
	static void KMP(String T, String P) {
		int[] table = makeTable(P);
		
		int n = T.length();
		int m = P.length();
		
		int idx = 0;// 현재 대응되는 글자수
		for(int i=0; i < n; i++) {
			
			while(idx > 0 && T.charAt(i) != P.charAt(idx)){
				idx = table[idx - 1];
			}
			
			if(T.charAt(i) == P.charAt(idx)){
				if(idx == m-1) {
					sb.append(i-idx+1).append(" ");
					count++;
					idx = table[idx];
				} else {
					idx += 1;
				}
			}
		}
		
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String T = br.readLine();
		String P = br.readLine();
		
		KMP(T, P);
		
		/*---------------출력----------------*/
		bw.write(count + "\n");
		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
}
