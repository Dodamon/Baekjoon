import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class Main{
	
	static int[] arr;
	static int N, C;
	static List<Integer> left, right;
	public static void comb(List<Integer> list, int start, int end, int sum) {
		if(sum > C) return;
		if(start == end) {
			list.add(sum);
			return;
		}
		comb(list, start+1, end, sum);
		comb(list, start+1, end, sum + arr[start]);
	}
	public static int upperbound(int s, int e, int val) {
		while( s <= e) {
			int mid = (s+e) / 2;
			if(right.get(mid) <= C - val) {
				s = mid + 1;
			} else {
				e = mid - 1;
			}
		}
		return e;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] inputs = br.readLine().split(" ");
		N = Integer.parseInt(inputs[0]);
		C = Integer.parseInt(inputs[1]);
		arr = new int[N];
		
		inputs = br.readLine().split(" ");
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(inputs[i]);
		}
		
		/*---------------------입력 끝-------------------------*/
		// 2^30은   10억이 넘기 때문에 부분집합으로 풀경우 시간초과가 발생한다
		// 30을 2개로 나눠서 15개씩 부분집합을 구하고
		// right , left의 부분집합을 합해서 최종 C보다 작게 물건을 가방안에 넣는 경우의 수를 구한다. 
		left = new ArrayList<Integer>();
		right = new ArrayList<Integer>();
		comb(left, 0, N/2, 0);
		comb(right, N/2, N, 0);
		right.sort((a, b) -> (a-b));
		
		int cnt = 0;
		int idx = 0;
		for(int i = 0; i < left.size(); i++) { // 이부분 다시 이해하기!!!!! 2022-10-15
			//  left의 어떤 값 + (right (0~ upperbound.idx))
			idx = upperbound(0, right.size()-1, left.get(i));
			cnt += idx + 1;
		}

		/*---------------출력----------------*/
		bw.write(cnt + "");
		bw.flush();
		br.close();
		bw.close();
	}
}