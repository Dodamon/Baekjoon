class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int sum = (brown + 4) / 2; // sum = h + w
        int h = 3; // 높이 초기값은 3
        int w = sum - h;
        while ( h <= w ){// 가로길이는 세로길이와 같거나 세로길이 보다 길다
            if((h - 2) * (w - 2) == yellow) {
                // 각각 2개씩 빼서 yellow와 같다면 리턴한다
                answer[0] = w;
                answer[1] = h;
                return answer;
            }
            h += 1;// 전체 세로 길이늘 늘려준다
            w = sum - h; // 세로길이에 따라 가로 길이를 정해준다
        }
        return answer;
    }
}
