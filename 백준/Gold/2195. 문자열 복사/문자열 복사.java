import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String S = br.readLine();
        String P = br.readLine();
        int cnt = 0;
        int max;

        for (int i = 0; i < P.length(); i+= max) {

            max = 0;
            for (int j = 0; j < S.length(); j++) {
                int temp = 0;

                for (int k = 0; k + i < P.length() && k + j < S.length() ; k++) {
                    if(P.charAt(k+i) != S.charAt(k+j))
                        break;
                    temp++;
                }
                max = (max < temp)? temp: max;
            }
            cnt++;
        }

        bw.write(cnt+"");
        bw.flush();
        br.close();
        bw.close();

    }
}
