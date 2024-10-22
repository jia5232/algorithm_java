package lecture.inflearn_basic.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WordInSentence {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputArr = br.readLine().split(" ");
        int max = 0;
        String answer = "";
        for (int i = 0; i < inputArr.length; i++) {
            if(inputArr[i].length() > max){
                max = inputArr[i].length();
                answer = inputArr[i];
            }
        }
        System.out.println(answer);
    }
}