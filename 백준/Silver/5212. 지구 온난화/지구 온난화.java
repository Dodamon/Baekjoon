import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;


public class Main{
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		String[] inputs = br.readLine().split(" ");
		
		int R = Integer.parseInt(inputs[0]);
		int C = Integer.parseInt(inputs[1]);
		char[][] map = new char[R][C];
		char[][] result = new char[R][C];
		
		
		for(int i = 0; i < R; i++) {
			String input = br.readLine();
			for(int j = 0; j < C; j++) {
				map[i][j] = input.charAt(j);
				result[i][j] = map[i][j];
	
			}
		}
		
		
		int[] dy = {-1, 1, 0, 0};
		int[] dx = {0, 0, -1, 1};
		
		int max_y = Integer.MIN_VALUE;
		int min_y = Integer.MAX_VALUE;
		int max_x = Integer.MIN_VALUE;
		int min_x = Integer.MAX_VALUE;
		
		for(int y = 0; y < R; y++) {
			for(int x = 0; x < C; x++) {
				if(map[y][x] == 'X') {
					
					int count = 0;
					for(int i = 0; i < 4; i++) {
						int ny = y + dy[i];
						int nx = x + dx[i];
						if(ny < 0 || ny >= R || nx < 0 || nx >= C) {
							count++;
							continue;
						}
						if(map[ny][nx] == 'X') {
							continue;
						}
						count++;
					}
					
					
					if(count >= 3) {
						result[y][x] = '.';
					} else {
						
						max_y = max_y < y ? y: max_y;
						min_y = min_y > y ? y: min_y;
						max_x = max_x < x ? x: max_x;
						min_x = min_x > x ? x: min_x;
					}
				}
			}
		}

		for(int y =  min_y; y <= max_y; y++) {
			for(int x = min_x; x <= max_x; x++) {
				sb.append(result[y][x]);
			}
			sb.append("\n");
		}
		
		

		bw.append(sb.toString());
		bw.flush();
		br.close();
		bw.close();

	}
}


