package lecture.inflearn_basic.string;
import java.util.Scanner;

public class UpperLower {
    public static String solution(String str){
        String result = "";

        //1. 대소문자 구분 메소드 사용
//        String[] arr = str.split("");
//        for(String s : arr){
//            if(Character.isLowerCase(s.charAt(0))){
//                result+=s.toUpperCase();
//            }else{
//                result+=s.toLowerCase();
//            }
//        }

        //2. 아스키코드 사용 (65~90:대문자, 97~122:소문자)
        for(char c : str.toCharArray()){
            if(c>=65 && c<=90) result+=Character.toLowerCase(c);
            else if(c>=97 && c<=122) result+=Character.toUpperCase(c);
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(solution(str));
    }
}
