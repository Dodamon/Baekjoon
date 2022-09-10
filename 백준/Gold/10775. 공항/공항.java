import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int G = Integer.parseInt(br.readLine());
		int P = Integer.parseInt(br.readLine());
		int[] g = new int[P];
		
		int[] planes = new int[G + 1];
		int total = 0;
		
		boolean keepGoing = true;
		for(int i = 0; i < P; i++) {
			int n = Integer.parseInt(br.readLine());
			if(!keepGoing) continue;
			
			while(planes[n] > 0) {
				int t = planes[n];
				planes[n] += 1;
				n = n - t;// 와.... 미쳤다....
			}
			
			if(n <= 0){
				keepGoing = false;
			} else {
				planes[n] = 1;
				total++;
			}
		}
		
		
		/*---------------출력----------------*/
		bw.write(total + "");
		bw.flush();
		br.close();
		bw.close();
	}
}
