package lecture.inflearn_basic.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WordInSentence {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strArr = br.readLine().split(" ");
        String answer = "";
        int max = 0;
        for(String s : strArr){
            if(s.length()>max){
                max = s.length();
                answer = s;
            }
        }
        System.out.println(answer);
    }
}