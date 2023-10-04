import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        int temp1, temp2;
        PriorityQueue<Integer> pq = new PriorityQueue();
        
        for(int scov : scoville) {
        	pq.add(scov);
        }
        
        while(pq.peek() < K) {
            if(pq.size() < 2) return -1;
        	temp1 = pq.poll();
        	temp2 = pq.poll();
        	pq.add(temp1 + temp2 * 2);
        	answer++;
        }
        
         return answer;
    }
}