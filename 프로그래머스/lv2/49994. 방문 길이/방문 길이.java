import java.util.*;

class Solution {
    public int solution(String dirs) {
        int answer = 0;
        
        boolean visited[][][] = new boolean[4][11][11];
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('U', 0);
        map.put('D', 1);
        map.put('R', 2);
        map.put('L', 3);
        
        int[] dy = {-1, 1, 0, 0};
        int[] dx = {0, 0, 1, -1};
        
        int y = 5;
        int x = 5;
        
        for(int d = 0; d < dirs.length(); d++) {
            int i = map.get(dirs.charAt(d));
            
            int ny = y + dy[i];
            int nx = x + dx[i];
            
            if(ny < 0 || ny > 10 || nx < 0 || nx > 10) {
                continue;
            }
            
            int j = i;
            if (i % 2 == 0){
                j++;
            } else {
                j--;
            }
            
            if (!visited[i][ny][nx] && !visited[j][y][x]) {
                visited[i][ny][nx] = true;
                answer++;
            }
            y = ny;
            x = nx;
        }
        return answer;
    }
}