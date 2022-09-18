import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] inputs = br.readLine().split(" ");
		
		int N = Integer.parseInt(inputs[0]);
		int K = Integer.parseInt(inputs[1]);
		int[] nums = new int[N];
		
		inputs = br.readLine().split(" ");
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(inputs[i]);
		}
		
		ArrayList<Integer> diff = new ArrayList<>();
		int idx = 0;
		for(int i = 0; i < N - 1; i ++) {
			diff.add(nums[i+1] - nums[i]);
		}
		Collections.sort(diff); // 오름 차순으로 차이을 정렬해서 N-K까지의 차이를 더한다
		
		int result = 0;
		for(int i = 0; i < N-K; i++) {
			result += diff.get(i);
		}

		bw.write(result +"");
		bw.flush();
		br.close();
		bw.close();
	}
}