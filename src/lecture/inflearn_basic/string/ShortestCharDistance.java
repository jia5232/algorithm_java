package lecture.inflearn_basic.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ShortestCharDistance {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String s = st.nextToken();
        char t = st.nextToken().charAt(0);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)==t){
                sb.append(0).append(" ");
                continue;
            }
            int min = Integer.MAX_VALUE;
            for (int j = i+1; j < s.length(); j++) {
                if(s.charAt(j)==t){
                    min = Math.min(min, j-i);
                }
            }
            for (int j = i-1; j >= 0; j--) {
                if(s.charAt(j)==t){
                    min = Math.min(min, i-j);
                }
            }
            sb.append(min).append(" ");
        }
        System.out.println(sb);
    }
}