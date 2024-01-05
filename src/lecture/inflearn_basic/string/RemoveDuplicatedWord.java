package lecture.inflearn_basic.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RemoveDuplicatedWord {
    public static String solution(String str){
        String answer = "";
        String[] arr = str.split("");
        for (int i = 0; i < arr.length; i++) {
            if(i == str.indexOf(str.charAt(i))) answer += str.charAt(i);
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        System.out.println(solution(str));
    }
}