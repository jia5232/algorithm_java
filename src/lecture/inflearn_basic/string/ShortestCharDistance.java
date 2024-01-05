package lecture.inflearn_basic.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ShortestCharDistance {
    public static void solution(String s, String t){
        char target = t.charAt(0);
        Integer[] answer = new Integer[s.length()];

        int p = 1000;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) != target){
                p++;
                answer[i] = p;
            }
            else{
                p = 0;
                answer[i] = p;
            }
        }

        p = 1000;
        for (int i = s.length()-1; i >= 0; i--) {
            if(s.charAt(i) != target){
                p++;
                answer[i] = Math.min(answer[i], p);
            }
            else p = 0;
        }

        for (Integer i : answer) {
            System.out.print(i+" ");
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String s = st.nextToken();
        String t = st.nextToken();
        solution(s, t);
    }
}