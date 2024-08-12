package lecture.inflearn_basic.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Cipher {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        String str = br.readLine();
        int size = str.length()/num;
        String answer = "";
        for (int i = 0; i < str.length()-1; i+=size) {
            String tmp = "";
            for (int j = i; j < i+size; j++) {
                if(str.charAt(j)=='#') tmp += '1';
                else tmp += '0';
            }
            int number = Integer.parseInt(tmp, 2);
            answer += (char) number;
        }
        System.out.println(answer);
    }
}