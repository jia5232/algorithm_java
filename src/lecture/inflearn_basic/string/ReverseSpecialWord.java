package lecture.inflearn_basic.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReverseSpecialWord {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] charArr = br.readLine().toCharArray();
        int lt = 0, rt = charArr.length-1;
        while (lt<rt){
            if(!Character.isAlphabetic(charArr[lt])) lt++;
            else if(!Character.isAlphabetic(charArr[rt])) rt--;
            else{
                char tmp = charArr[lt];
                charArr[lt] = charArr[rt];
                charArr[rt] = tmp;
                lt++;
                rt--;
            }
        }
        System.out.println(String.valueOf(charArr));
    }
}