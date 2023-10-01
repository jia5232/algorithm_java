package lecture.inflearn_basic.string;

import java.util.Scanner;

public class Cipher {
    public static String solution(int num, String str){
        String answer = "";
        for (int i = 0; i <num ; i++) {
            String tmp = str.substring(0, 7).replace('#', '1').replace("*", "0");
            int n = Integer.parseInt(tmp, 2);
            str = str.substring(7);//7부터 끝까지로 바꿈.
            answer+=(char)n;
            // (int)로 캐스팅 -> 아스키코드로 변환
            // (char)로 캐스팅 -> 문자로 변환
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();
        System.out.println(solution(n, s));
    }
}
