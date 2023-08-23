import java.util.*;
class Solution {
    private static int result = 0;
    public int solution(int[] queue1, int[] queue2) {
        long total1 = 0;
        long total2 = 0;
        Deque<Integer> list1 = new LinkedList<>();
        Deque<Integer> list2 = new LinkedList<>();
        
        for (int i = 0; i < queue1.length; i++) {
            list1.add(queue1[i]);
            list2.add(queue2[i]);
            total1 += queue1[i];
            total2 += queue2[i];
        }
        
        long TSum = total1 + total2;
        long half = TSum/2;
        if(half < Arrays.stream(queue2).max().getAsInt() || half < Arrays.stream(queue1).max().getAsInt()|| TSum %2 != 0){
            return -1;
        }  // 애시당초 안되는 애들은 제외
        
        dfs(list1,list2,half);
        return result;
    }
    private static void dfs(Deque<Integer> list1, Deque<Integer> list2, long half) {
        // 차피 한 쪽만 맞춰지면 나머지는 신경안써도 된다.
        long listSum = 0;
        for (int a : list1) {
            listSum += a;
        }
        int temp = 0;
        int count = 0;

        while (list2.size() > 0) {
            if (listSum > half) {
                temp = list1.poll();
                listSum -= temp;
                count += 1;
            } else if (listSum == half) {
                result = count;
                return;
            } else {
                temp = list2.poll();
                listSum += temp;
                list1.add(temp);
                count += 1;
            }
        }
        
        result = -1;
    }
}