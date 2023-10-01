package lecture.inflearn_basic.string;

import java.util.Scanner;

public class OnlyNumber {
//    // 1. 아스키코드 사용
//    public static int solution(String s){
//        int answer = 0;
//        for(char x : s.toCharArray()){
//            if(x>=48 && x<=57) answer = answer*10 + (x-48); //자릿수를 누적해서 계속 더함
//        }
//        return answer;
//    }
    public static int solution(String s){
        String answer = "";
        for(char x : s.toCharArray()){
            if(Character.isDigit(x)) answer+=x;
        }
        return Integer.parseInt(answer);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(solution(sc.next()));
    }
}
