package lecture.inflearn_basic.string;
import java.util.*;

public class FindString { //1.문자 찾기
    public static int solution(String str, char t){
        int answer = 0;
        String[] arr = str.toUpperCase().split("");
        String t_string = Character.toString(t).toUpperCase();
        for(String a : arr){
            if(a.equals(t_string)) answer++;
        }
        return answer;
    }

    public static void main(String[] args){
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        char t = kb.next().charAt(0);
        System.out.println(solution(str, t));
    }
}