package lecture.inflearn_basic.string;

import java.util.Scanner;

public class LongPalindrome {
    public static String solution(String s){
        String answer = "NO";
        s = s.toLowerCase().replaceAll("[^a-z]", "");
        //replace는 정규식 못쓰고, replaceAll은 정규식 쓸 수 있다!
        //replaceAll("[^a-z]", "") : a-z가 아닌것들을 전부 ""로 대체해라.
        String tmp = new StringBuilder(s).reverse().toString();
        if(s.equals(tmp)) answer = "YES";
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(solution(sc.nextLine()));
    }
}
