class Solution {
    public int solution(int[] a) {
        int answer = 0;
        int N = a.length;
        
        if (N < 3) {
            return N;
        }
        
        int left = a[0];
        int right = a[N-1];
        int[] maxLeft = new int[N];
        int[] maxRight = new int[N];
        
        // 보통 터질때는 인접한 풍선중 번호가 큰 풍선이 터진다
        for(int i = 0; i < N; i++){
            if (left > a[i]) {
                left = a[i];
            } 
            if (right > a[N-1-i]) {
                right = a[N-1-i];
            }            
            maxLeft[i] = left;
            maxRight[N-1-i] = right;
        }
        
        answer = 2;
        for (int i = 1; i < N-1; i++) {
            if (maxLeft[i-1] >= a[i] || maxRight[i+1] >= a[i]) {
                answer++;
            }
        }
        return answer;
    }
} 