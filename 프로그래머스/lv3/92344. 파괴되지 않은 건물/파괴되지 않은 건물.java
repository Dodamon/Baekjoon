class Solution {
    public int solution(int[][] board, int[][] skill) {
        
        int n = board.length;
        int m = board[0].length;
        int[][] dv = new int[n][m];
        int answer = 0;
        
        for(int[] s : skill) {
            int y1 = s[1];
            int x1 = s[2];
            int y2 = s[3];
            int x2 = s[4];
            int value = s[5];
            
            value *= (s[0] == 1)? -1 : 1;
            dv[y1][x1] += value;
            if(x2 + 1 < m) {
                dv[y1][x2 + 1] += value * -1;
            }
            
            if(y2 + 1 < n) {
                dv[y2 + 1][x1] += value * -1;
            }
            
            if(y2 + 1 < n && x2 + 1 < m) {
                dv[y2 + 1][x2 + 1] += value;
            }

        }
        
        
        
        
        for(int i = 0; i < n; i++) {
            for(int j = 1; j < m; j++) {
                dv[i][j] += dv[i][j-1];
            }
        }
        
        for(int j = 0; j < m; j++) {
            for(int i = 1; i < n; i++) {
                dv[i][j] += dv[i-1][j];
            }
        }
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                answer += ((dv[i][j] + board[i][j]) > 0) ? 1 : 0;
            }
        }
        
        
        

        
        return answer;
    }
}