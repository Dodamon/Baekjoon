import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;

class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		//boolean[] visited = new boolean[N];
		HashMap<String, Boolean> visited = new HashMap<>();
		String[] list = new String[N];
		
		for(int i = 0; i < N; i++) {
			String car = br.readLine();
			list[i] = car;
			visited.put(car, false);
		}
		
		
		int result = 0;
		int index = 0;
		for(int i = 0; i < N; i++) {
			String car = br.readLine();
			while(visited.get(list[index])) {
				index++;
			}
			
			if(!list[index].equals(car)) {
				visited.put(car, true);
				result++;
			} else {
				visited.put(car, true);
				index++;
			}
		}
		
		bw.write(result + "");
		br.close();
		bw.close();
	}
}
