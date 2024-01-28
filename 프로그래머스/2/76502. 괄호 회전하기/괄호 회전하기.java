import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        Map<Character, Integer> hashMap = new HashMap<>();
        hashMap.put('(', 0);
        hashMap.put(')', 1);
        hashMap.put('[', 2);
        hashMap.put(']', 3);
        hashMap.put('{', 4);
        hashMap.put('}', 5);
        
        // 회전 한번
        for(int i = 0; i < s.length(); i++) {
            
            Boolean isPossible = true;
            Stack<Integer> stack = new Stack<>();
            
            for (int j = 0; j < s.length(); j++) {
                int index = (i + j) % s.length();
                
                Integer cur = hashMap.get(s.charAt(index));
                if(cur % 2 == 0) {
                    stack.push(cur);
                } else{
                    if (stack.empty()) {
                        isPossible = false;
                        break;
                    }
                    Integer top = stack.peek();
                    if (top + 1 == cur) {
                        stack.pop();
                    } else {
                        isPossible = false;
                        break;
                    }
                } 
            }
            
            if (isPossible && stack.empty()) {
                answer++;
            }
            
        }
        return answer;
    }
}