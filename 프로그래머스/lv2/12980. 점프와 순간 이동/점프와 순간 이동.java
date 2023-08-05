import java.util.*;

public class Solution {
    public int solution(int n) {
        return move(n);
    }
    
    public int move(int N){
        int result = 0;
        while(N>0){
            if(N%2 != 0){
                N-= 1;
                result += 1;
            }else {
                N /= 2;
            }
        }
        
        return result;
    }
}
