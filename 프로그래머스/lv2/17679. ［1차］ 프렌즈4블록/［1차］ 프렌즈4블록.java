class Solution {
    private static int [] dx = {0,0,1,1} , dy = {0,1,1,0};
    private static boolean check = false, tempCheck = true;
    private static char [][] map;
    private static boolean [][] visited;
    private static int result = 0;
    
    public int solution(int m, int n, String[] board) {
        map = new char[m][n];
        visited = new boolean[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = board[i].charAt(j);
            }
        }  // 맵을 구성한다.

        while (!check){
            // 내릴 블록이 있는 체크한다
            // check == false : 터질블록을 찾았다
            check = true;
            for (int i = 0; i < m-1; i++) {
                for (int j = 0; j < n-1; j++) {
                    if(map[i][j] >='A' && map[i][j] <= 'Z'){
                        find(i,j,map[i][j],m,n);
                    }
                }
            }

            collapse(m,n);
            visited = new boolean[m][n];
            if(check) break;
        }
        return result;
    }
    
    private static void find(int x, int y, char a, int m, int n){
        int nx,ny;
        for (int i = 0; i < 4; i++) {
            nx = x + dx[i];
            ny = y + dy[i];
            if(map[nx][ny] != a) return;
        }
        // 여기에 도달했다는건 2 x 2 가 완성되었다.
        for (int i = 0; i < 4; i++) {
            nx = x + dx[i];
            ny = y + dy[i];
            if(!visited[nx][ny]){
                visited[nx][ny] = true;
                result += 1;
            }
        }
        check = false;
    }

    private static void collapse(int m, int n){
        int x,y;
        for (int j = 0; j < n; j++) {
            for (int i = m-1; i >= 0; i--) { // y축
                // 터진 블록이면 (i, j)
                if(visited[i][j]){
                    map[i][j] = '@';
                    x = i;
                    y = j;
                    // 
                    while(true){
                        x -= 1;
                        if(x >= 0 && map[x][y] != '@' && !visited[x][y]){
                            map[i][j] = map[x][y];
                            map[x][y] = '@';
                            visited[i][j] = false;
                            visited[x][y] = true;
                            break;
                        }
                        if(x < 0){
                            break;
                        }
                    }
                }
            }
        }
    }
}