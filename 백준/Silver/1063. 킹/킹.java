

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;


public class Main{
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		HashMap<String, int[]> hashmap = new HashMap<>();
		
		hashmap.put("R", new int[] {0, 1});
		hashmap.put("L", new int[] {0, -1});
		hashmap.put("B", new int[] {-1, 0});
		hashmap.put("T", new int[] {1, 0});
		hashmap.put("RT", new int[] {1, 1});
		hashmap.put("LT", new int[] {1, -1});
		hashmap.put("RB", new int[] {-1, 1});
		hashmap.put("LB", new int[] {-1, -1});
		
		
		String[] inputs = br.readLine().split(" ");
		int[] king = new int[2];
		int[] stone = new int[2];
		king[0] = inputs[0].charAt(1) - '1';
		king[1] = inputs[0].charAt(0) - 'A';
		stone[0] = inputs[1].charAt(1) - '1';
		stone[1] = inputs[1].charAt(0) - 'A';
		
		int N = Integer.parseInt(inputs[2]);
		
		for(int i = 0; i < N; i++) {
			String cmd = br.readLine();
			
			// 킹을 움직인다
			int[] d = hashmap.get(cmd);
			int y = king[0];
			int x = king[1];
			int dy = d[0];
			int dx = d[1];
			int ny = y + dy;
			int nx = x + dx;
			
			if(ny < 0 || ny >= 8 || nx < 0 || nx >= 8) continue;
		
			// 킹이 움직인 칸에 돌이 있다면 돌도 움직인다
			int sy = stone[0];
			int sx = stone[1];
			
			if(sy == ny && sx == nx) {
				int nsy = sy + dy;
				int nsx = sx + dx;
				if(nsy < 0 || nsy >= 8 || nsx < 0 || nsx >= 8) continue;
				
				stone[0] = nsy;
				stone[1] = nsx;
			}
			
			king[0] = ny;
			king[1] = nx;
			
		
		}
		
		String result = (char)(king[1] + 'A') + "" + (char)(king[0] + '1');
		sb.append(result).append("\n");
		result = (char)(stone[1] + 'A') + "" + (char)(stone[0] + '1');
		sb.append(result).append("\n");

		bw.append(sb.toString());
		bw.flush();
		br.close();
		bw.close();

	}
}


