package lecture.inflearn_basic.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UpperLower {
    public static String solution(char[] arr){
        String answer = "";
        for (char c : arr) {
            if(Character.isLowerCase(c)) answer += String.valueOf(c).toUpperCase();
            else answer += String.valueOf(c).toLowerCase();
        }
        return answer;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        System.out.println(solution(str.toCharArray()));
    }
}