import java.util.ArrayList;

class Solution {
	static boolean[][] win;
	static boolean[][] lose;
	static boolean[] visited;
	static ArrayList<ArrayList<Integer>> adjList;

    public static int solution(int n, int[][] results) {
        
        adjList = new ArrayList<ArrayList<Integer>>(n+1);
        
        win = new boolean[n+1][n+1];
        lose = new boolean[n+1][n+1];
        visited = new boolean[n+1];
        int count = 0;
        
        for(int[] edge: results) {
        	int u = edge[0];
        	int v = edge[1];
        	win[u][v] = true;
        	lose[v][u] = true;
        }
        
        for(int[] edge: results) {
        	int u = edge[0];
        	int v = edge[1];
        	
        	for(int i = 1; i < n+1; i++) {
        		if(!win[i][u]) continue;
        		for(int j = 1; j < n+1; j++) {
        			win[i][j] = (win[u][j]) ? true: win[i][j];
        		}
        	}
        	
        	for(int i = 1; i < n+1; i++) {
        		if(!lose[i][v]) continue;
        		for(int j = 1; j < n+1; j++) {
        			lose[i][j] = (lose[v][j]) ? true: lose[i][j];
        		}
        	}
        }
       
       for(int i = 1; i < n+1; i++) {
    	   boolean isSpecified = true;
    	   for(int j = 1; j < n+1; j++) {
    		   if(i == j) continue;
    		   if(win[i][j] || lose[i][j]) {
    			   continue;
    		   } else {
    			   isSpecified = false;
    			   break;
    		   }
    	   }
    	   count += isSpecified? 1: 0;
       }
       
       return count;
	}
}