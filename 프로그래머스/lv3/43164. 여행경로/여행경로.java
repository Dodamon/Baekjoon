import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
	
    static public Queue<String> pq = new PriorityQueue<>();
    static public boolean[] visited;
    
    static public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];
        dfs(tickets, "ICN", 0, "ICN");
        String[] answer = pq.peek().split(",");
        return answer;
    }
    
    static public void dfs(String[][] tickets, String currentCity, int cnt, String path){

        if(cnt == tickets.length){
            pq.add(path);
            return;
        }
        for(int i=0;i<tickets.length;i++){
        	
            if(!visited[i] && currentCity.equals(tickets[i][0])){
            
                visited[i] = true;
                dfs(tickets, tickets[i][1], cnt+1, path +","+ tickets[i][1]);
                visited[i] = false;
            }
        }
    }
}