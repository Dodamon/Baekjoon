class Solution {
	static int N; //문자열의 길이
	static int needChanged;// 'A'가 아닌 수 == A에서 바꿔야할 아파벳의 수
	static int moveCol, moveRow;// 위아래, 좌우 최소 움직임 저장

    // N이 20이 최대 이기 때문에 조합으로는 풀수 없다 20!
    // 따라서 RLLLLRRRR 처럼 오른쪽 왼쪽으로 움직임을 저장해서 부분집합을 활용해서 푼다 => N이 최대 30 까지 가능
	public static void subset(String name, int cnt, int[] moves) {

		if (cnt == N - 1) { // 문자의 길이가 N개 일때 움직임은 최대 N-1개가 있다
			int cur = 0;// 현재 위치
			int changed = 0;// 지금까지 바꾼 아파벳의 수
			boolean[] isChanged = new boolean[N];// 알파벳 바꿨는지 확인한다
			isChanged[0] = true;// 첫번째 원소는 움직임 없이 바꿔진다

			for (int i = 0; i < moveCol; i++) {// 움직임 배열은 처음 부터 가장 작은 움직임으로 저장된 movCol만큼만 움직인다
				if (changed == needChanged) {//지금까지 바꾼 알파벳의 수가 바꿔야할 알파벳의 수와 같다면
					moveCol = i ; // 좌우 최소 움직임의 수를 갱신한다
					return;
				}

				cur = (cur + moves[i]) % N; // 다음 index로 움직인다
				cur += cur < 0 ? N : 0;// 0보다 작다면 N을 더해준다
				
				if (isChanged[cur] || name.charAt(cur) == 'A') continue; // 이전에 바꾼적이 있거나 바꿀 필요가 없다면 넘어간다

				isChanged[cur] = true; // 이전에 바꾼 적이 없다면 바꿔준다
				changed++;//바꾼 알파벳수를 1 늘려준다
			}
			return;
		}

		moves[cnt] = -1;// 오른쪽으로 간다
		subset(name, cnt + 1, moves); 
		moves[cnt] = 1;// 왼쪽으로 간다
		subset(name, cnt + 1, moves);

	}

	public static int solution(String name) {
		N = name.length();
		moveCol = N - 1;
		moveRow = 0;
		needChanged = 0;

		for (int i = 0; i < name.length(); i++) {
			char c = name.charAt(i);
			needChanged += (c == 'A') ? 0 : 1;
			moveRow += (c - 'A') > ('Z' - c + 1) ? ('Z' - c + 1) : c - 'A';// 필요한 위아래 움직임은 항상 동일하다
		}
        needChanged -= name.charAt(0) == 'A'? 0: 1;// 처음 알파벳은 움직이지 않아도 바꿀 수 있기 때문에 이를 확인해준다

		subset(name, 0, new int[N - 1]);
		return moveCol + moveRow;
	}

}