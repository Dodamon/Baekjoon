class Solution
{
    public int binarySearch(int mid, int a, int b, int level) {
        
        int d = (int) Math.pow(2, (level-2));
        
        if (a <= mid && b > mid) {
            return level;
        } else if (a <= mid) {
            return binarySearch(mid-d, a, b, level-1);
        } else {
            return binarySearch(mid+d, a, b, level-1);
        }     
    }
    
    public int solution(int n, int a, int b)
    {
        if (a > b) {
            int temp = a;
            a = b;
            b = temp;
        } 
        
        int answer = binarySearch(n/ 2, a, b, (int) Math.round(Math.log10(n)/Math.log10(2)));
        return answer;
    }
}