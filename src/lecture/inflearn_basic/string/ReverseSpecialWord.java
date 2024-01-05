package lecture.inflearn_basic.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReverseSpecialWord {
    public static String solution(char[] arr){
        int lt = 0, rt = arr.length-1;
        while (lt<rt){
            if(!Character.isAlphabetic(arr[lt])) lt++;
            else if(!Character.isAlphabetic(arr[rt])) rt--;
            else{
                char tmp = arr[lt];
                arr[lt] = arr[rt];
                arr[rt] = tmp;
                lt++;
                rt--;
            }
        }
        return String.valueOf(arr);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        System.out.println(solution(str.toCharArray()));
    }
}