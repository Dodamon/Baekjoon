import java.util.*;
class Solution {
    public static String[] solution(String[] record) {
        HashMap<String,String> enterMap = new HashMap<>();
        Queue<String> resultList = new LinkedList<>();
        
        String [] answer;
        StringTokenizer st;
        String uid,name;
        int changeCount = 0;
        
        for (int i = 0; i < record.length; i++) {
            st = new StringTokenizer(record[i]);
            switch (st.nextToken()){
                case "Enter":
                    uid = st.nextToken();
                    name = st.nextToken();
                    enterMap.put(uid,name);
                    resultList.add(uid + " " + "in");
                    break;
                case "Change":
                    uid = st.nextToken();
                    name = st.nextToken();
                    enterMap.put(uid,name);
                    break;
                case "Leave":
                    uid = st.nextToken();
                    resultList.add(uid + " " + "out");
                    break;
                default:
                    break;
            }
        }
        answer = new String[resultList.size()];
        for (int i = 0; i < answer.length; i++) {
            String[] tmp = resultList.poll().split(" ");
            name = enterMap.get(tmp[0]);
            String op = tmp[1];
            answer[i] = name;
            answer[i] += op.equals("in") ? "님이 들어왔습니다." : "님이 나갔습니다.";
        }
        return answer;
    }
}