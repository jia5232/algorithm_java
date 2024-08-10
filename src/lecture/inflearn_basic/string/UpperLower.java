package lecture.inflearn_basic.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UpperLower {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String answer = "";
        for(int i=0; i<str.length(); i++){
            if (Character.isLowerCase(str.charAt(i))){
                String tmp = String.valueOf(str.charAt(i)).toUpperCase();
                answer += tmp;
            } else {
                String tmp = String.valueOf(str.charAt(i)).toLowerCase();
                answer += tmp;
            }
        }
        System.out.println(answer);
    }
}