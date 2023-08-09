import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        // right : 철수의 토핑종류
        // left  : 동생의 토핑종류
        HashMap<Integer, Integer> right = new HashMap<>();
        Set<Integer> left = new HashSet<>();
        
        // HashMap을 사용해서 전체 토핑종류를 카운팅한다
        for (int i = 0; i < topping.length; i++) {
            right.put(topping[i], right.getOrDefault(topping[i], 0) + 1);
        }
        
        // 다시 for문을 통해 탐색하면서 철수의 토핑종류를 늘려준다
        for (int i = 0; i < topping.length; i++) {
            if (right.get(topping[i]) == 1) {
                right.remove(topping[i]);
            } else {
                right.put(topping[i], right.get(topping[i])-1);
            }
            
            left.add(topping[i]);
            
            // 둘이 토핑의 종류가 같다면 answer의 값을 하나더 올려준다
            if (left.size() == right.size()) {
                answer++;
            }
                          
        }
        return answer;
    }
}