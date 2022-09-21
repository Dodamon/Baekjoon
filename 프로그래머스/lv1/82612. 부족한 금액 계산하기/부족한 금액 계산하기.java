class Solution {
    public long solution(int price, int money, int count) {
        long answer = ((count+1) * count) / 2;
        answer *= price;
        
        answer = answer < money ? 0: answer - money;
        return answer;
    }
}