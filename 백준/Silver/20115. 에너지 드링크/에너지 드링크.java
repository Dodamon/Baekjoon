import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		String[] inputs = br.readLine().split(" ");
		int[] nums = new int[N];
		
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(inputs[i]);
		}

		Arrays.sort(nums);
		
		double total = nums[N-1];
		for(int i = 0; i < N-1; i++) {
			total += nums[i]/2.0;
		}

		/*---------------출력----------------*/
		bw.write(total + "");
		bw.flush();
		br.close();
		bw.close();
	}
}
