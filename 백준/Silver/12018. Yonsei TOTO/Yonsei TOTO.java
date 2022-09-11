import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] inputs = br.readLine().split(" ");
		int N = Integer.parseInt(inputs[0]);
		int M = Integer.parseInt(inputs[1]);
		
		ArrayList<ArrayList<Integer>> list = new ArrayList<>(N);
		int[] enrolled = new int[N];
		
		for(int i = 0; i < N; i++) {
			inputs = br.readLine().split(" ");
			int K = Integer.parseInt(inputs[0]);
			enrolled[i] = Integer.parseInt(inputs[1]);
			
			inputs = br.readLine().split(" ");
			list.add(new ArrayList<>());
			for(int j = 0; j < K; j++) {
				list.get(i).add(Integer.parseInt(inputs[j]));
			}
			
			Collections.sort(list.get(i), Collections.reverseOrder());
		}
		
		int[] mileage = new int[N];
		for(int i = 0; i < N; i++) {
			int n = enrolled[i];
			if(list.get(i).size() < n) {
				mileage[i] = 1;
			} else {
				mileage[i] = list.get(i).get(n-1);
			}
		}
		
		Arrays.sort(mileage);
		
		int count = 0;
		
		for(int i = 0; i < N; i++) {
			M -= mileage[i];
			//System.out.println(mileage[i]);
			if(M < 0) break;
			count++;
		}

		/*---------------출력----------------*/
		bw.write(count + "");
		bw.flush();
		br.close();
		bw.close();
	}
}
