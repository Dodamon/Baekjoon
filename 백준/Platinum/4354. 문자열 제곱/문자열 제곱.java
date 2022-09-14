import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
	
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
	
	static int KMP(String T, String P) {
		int[] table = makeTable(P);
		
		int n = T.length();
		int m = P.length();
		
		int idx = 0;// 현재 대응되는 글자수
		for(int i=1; i < n; i++) {
			
			while(idx > 0 && T.charAt(i) != P.charAt(idx)){
				idx = table[idx - 1];
			}
			
			if(T.charAt(i) == P.charAt(idx)){
				if(idx == m-1) {
					return i - idx;
				} else {
					idx += 1;
				}
			}
		}
		return 1;
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			String T = br.readLine();
			if(T.charAt(0) == '.') {
				break;
			}
			int result = KMP(T+T, T);
			
			sb.append(T.length()/result).append("\n");
		}
		
		/*---------------출력----------------*/
		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
}
