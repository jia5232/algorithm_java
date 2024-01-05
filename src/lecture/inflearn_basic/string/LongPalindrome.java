package lecture.inflearn_basic.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LongPalindrome {
    public static boolean solution(String str){
        String newStr = str.toLowerCase().replaceAll("[^a-z]", "");
        //replace는 정규식 못쓰고, replaceAll은 정규식 쓸 수 있다!
        //replaceAll("[^a-z]", "") : a-z가 아닌것들을 전부 ""로 대체해라.
        String reverseStr = new StringBuilder(newStr).reverse().toString();
        if(newStr.equalsIgnoreCase(reverseStr)) return true;
        else return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        if(solution(str)) System.out.println("YES");
        else System.out.println("NO");
    }
}