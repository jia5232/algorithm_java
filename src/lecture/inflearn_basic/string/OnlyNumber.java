package lecture.inflearn_basic.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OnlyNumber {
    public static int solution(String str){
        String answer = "";
        for (int i = 0; i < str.length(); i++) {
            if(Character.isDigit(str.charAt(i))) answer += str.charAt(i);
        }
        return Integer.parseInt(answer);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        System.out.println(solution(str));
    }
}