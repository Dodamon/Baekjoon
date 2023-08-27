import java.util.*;
class Solution {
    private static HashMap<String, Integer> map = new HashMap<>();
    private static List<Integer> answer = new ArrayList<>();
    private static int index = 26;
    private static String line = "";
    
    public int[] solution(String msg) {
        for (int i = 0; i < 26; i++) {
            map.put(Character.toString((char)('A'+i)), i+1);
        }
        
        // map에 A-Z 까지 i가 들어간다
        // 현재 입력 인덱스: w
        // 다음 글자 인덱스: s
        for (int w = 0; w < msg.length(); w++) {
            String temp = msg.charAt(w)+""; // 처음에는 무조건 한글자가 들어간다
            int s = w + 1;
            while(map.containsKey(temp)){  // 맨 처음 돌았을 때는
                
                // else {
                //     s++;
                // }
                if(s == msg.length()){
                    break;
                }
                
                temp += msg.charAt(s)+"";  // 있우면 계속 붙여서 넣는다
                s++;
            
            }  // 이게 끝나면 없는 애가 나온다.
            
            // 이게 끝나면
            // 1) map에 들어 있지 않은 temp가 나온다 -> map에 등록한다 ex) abc -> temp의 길이를 하나 빼준다..
            // 2) map에 있는데 s가 msg의 마지막을 가르키는 경우 -> map에 등록하지 않는다
            if (!map.containsKey(temp)) {
                index+=1;
                map.put(temp,index);
                temp = temp.substring(0, temp.length()-1);
            }
            
            // answer에는 위에서 추가한 temp가 아니라 바로전 길이의 인덱스를 anwer에 넣어야한다 ex) ab
            answer.add(map.get(temp));
            w += temp.length()-1;
        }
        int [] result = new int[answer.size()];
        for(int i = 0; i < answer.size();i++){
            result[i] = answer.get(i);
        }
        return result;
    }
}