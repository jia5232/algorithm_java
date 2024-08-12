package lecture.inflearn_basic.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OnlyNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String answer = "";
        for (int i = 0; i < str.length(); i++) {
            if(Character.isDigit(str.charAt(i))){
                answer += str.charAt(i);
            }
        }
        int n = Integer.parseInt(answer);
        System.out.println(n);
    }
}