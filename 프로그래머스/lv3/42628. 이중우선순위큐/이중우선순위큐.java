import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {0, 0};
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        PriorityQueue<Integer> pq_reverse = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int i = 0; i < operations.length; i++) {
            String[] operation = operations[i].split(" ");
            int num = Integer.parseInt(operation[1]);
            
            if (operation[0].equals("I")) {
                pq.add(num);
                pq_reverse.add(num);
            } else if (num > 0 && pq_reverse.size() > 0) {
                int min = pq_reverse.poll();
                pq.remove(min);
            } else if (pq.size() > 0) {
                int max = pq.poll();
                pq_reverse.remove(max);
            }
        }
        if (pq.size() > 1) {
            answer[1] = pq.poll();
            answer[0] = pq_reverse.poll();
        }
        return answer;
    }
}