package lecture.inflearn_basic.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WordInSentence {
    public static String solution(String[] arr){
        String answer = "";
        for (String s : arr) {
            if(s.length() > answer.length()) answer = s;
        }
        return answer;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        System.out.println(solution(str.split(" ")));
    }
}