import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;

public class Main {
	static boolean isFinished = false;
	static class Pos {
		int y,  x;

		public Pos(int y, int x) {
			this.y = y;
			this.x = x;
		}
		
	}
	
	public static boolean check(int y, int x, int num, int[][] map) {
		for(int i = 0; i < 9; i++) {
			if(map[y][i] == num || map[i][x] == num)
				return false;
		}
		int sy = (y / 3) * 3;
		int sx = (x / 3) * 3;
		
		for(int  i = sy; i < sy + 3; i++) {
			for(int j = sx; j < sx + 3; j++) {
				if(map[i][j] == num)
					return false;
			}
		}
		return true;
	}

	
	public static boolean makeSudoku(int[][] map, ArrayList<Pos> list, int cnt, int N) {
		
		if(cnt == N) {
			//System.out.println(Arrays.deepToString(map));
			return true;
		}
		
		Pos p = list.get(cnt);
		int y = p.y;
		int x = p.x;
		boolean result = false;
		
		for(int num = 1; num < 10; num++) {
			
			// 가로 세로 체크 사각형 체크			
			if(check(y, x, num, map)) {
				map[y][x] = num;
				result = makeSudoku(map, list, cnt+1, N);
				if(result) {
					return result;
				}
			}
		}
		
		map[y][x] = 0;
		return result;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuffer sb = new StringBuffer();
		
		ArrayList<Pos> list = new ArrayList<>();
		
		int[][] map = new int[9][9];
		for(int i = 0; i < 9; i++) {
			String inputs = br.readLine();
			for(int j = 0; j < 9; j++) {
				map[i][j] = inputs.charAt(j) - '0';
				
				if(map[i][j] == 0) {
					list.add(new Pos(i, j));
				}
			}
		}
		
		//System.out.println(Arrays.deepToString(map));
		makeSudoku(map, list, 0, list.size());
		for(int i = 0; i < 9 ; i++) {
			for(int j = 0; j < 9; j++) {
				sb.append(map[i][j]);
			}
			sb.append("\n");
		}

		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
}
