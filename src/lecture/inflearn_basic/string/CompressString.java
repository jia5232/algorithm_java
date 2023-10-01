package lecture.inflearn_basic.string;

import java.util.Scanner;

public class CompressString {
    public static String solution(String str){
        str+=" "; //뒤에 빈문자 하나 추가!
        String result = "";
        int cnt = 1;
        for (int i = 0; i < str.length()-1; i++) {
            if(str.charAt(i)==str.charAt(i+1)) cnt++;
            else{
                result+=str.charAt(i);
                if(cnt>1) result+=String.valueOf(cnt);
                cnt = 1;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(solution(sc.next()));
    }
}
