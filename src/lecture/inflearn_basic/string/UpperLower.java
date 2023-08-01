package lecture.inflearn_basic.string;
import java.util.Scanner;

public class UpperLower {
    public static String solution(String str){
        String[] arr = str.split("");
        String result = "";
        for(String s : arr){
            if(Character.isLowerCase(s.charAt(0))){
                result+=s.toUpperCase();
            }else{
                result+=s.toLowerCase();
            }
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(solution(str));
    }
}
