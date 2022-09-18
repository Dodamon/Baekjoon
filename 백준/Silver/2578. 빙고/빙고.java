import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;

class Main {

	public static boolean isBingo_Y(boolean[][] checked, HashMap<Integer, int[]> map, int y, int x) {

		boolean bingo = true;
		for (int k = 0; k < 5; k++) {
			if (!checked[y][k]) {
				bingo = false;
				break;
			}
		}
		if (bingo) return true;
		return false;
	}
	public static boolean isBingo_X(boolean[][] checked, HashMap<Integer, int[]> map, int y, int x) {

		boolean bingo = true;
		for (int k = 0; k < 5; k++) {
			if (!checked[k][x]) {
				bingo = false;
				break;
			}
		}
		if (bingo) return true;
		return false;
	}
	public static boolean isBingo_cross1(boolean[][] checked, HashMap<Integer, int[]> map, int y, int x) {

		boolean bingo = true;
		for (int k = 0; k < 5; k++) {
			if (!checked[k][k]) {
				bingo = false;
				break;
			}
		}
		if (bingo) return true;
		return false;
	}
	public static boolean isBingo_cross2(boolean[][] checked, HashMap<Integer, int[]> map, int y, int x) {

		boolean bingo = true;
		for (int k = 0; k < 5; k++) {
			if (!checked[k][4-k]) {
				bingo = false;
				break;
			}
		}
		if (bingo) return true;
		return false;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		HashMap<Integer, int[]> map = new HashMap<>();
		boolean[][] checked = new boolean[5][5];

		for (int i = 0; i < 5; i++) {
			String[] inputs = br.readLine().split(" ");
			for (int j = 0; j < 5; j++) {
				int n = Integer.parseInt(inputs[j]);
				map.put(n, new int[] { i, j });
			}
		}

		int[] nums = new int[25];
		for (int i = 0; i < 5; i++) {
			String[] inputs = br.readLine().split(" ");
			for (int j = 0; j < 5; j++) {
				nums[i * 5 + j] = Integer.parseInt(inputs[j]);
			}
		}
		
		int count = 0;
		int result = 0;
		for (int i = 0; i < 25; i++) {

			int n = nums[i];
			int y = map.get(n)[0];
			int x = map.get(n)[1];
			//System.out.println(n);

			checked[y][x] = true;
			
			if(isBingo_Y(checked, map, y, x)) {
				count++;
			}
			if(isBingo_X(checked, map, y, x)) {
				count++;
			}
			if(y == x && isBingo_cross1(checked, map, y, x)) {
				count++;
			}
			if(y+x == 4 && isBingo_cross2(checked, map, y, x)) {
				count++;
			}
			
			if(count >= 3) {
				result = i +1;
				break;
			}
		}

		bw.write(result + "");
		bw.flush();
		br.close();
		bw.close();
	}
}